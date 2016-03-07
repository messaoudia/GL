package models.Utils;

import controllers.Global.Mail;
import models.Adresse;
import models.Client;
import models.Contact;
import models.Utilisateur;
import play.Logger;
import play.libs.mailer.Email;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * Created by Guillaume on 10/02/2016.
 */
public class Utils {

    /**
     * Teste si les deux listes passées en parametre sont égales
     *
     * @param l1
     * @param l2
     * @param <T>
     * @return
     */
    public static <T> boolean isEqualList(List<T> l1, List<T> l2) {
        return (l1 != null && l2 != null && l1.containsAll(l2)
                && l2.containsAll(l1) && l1.size() == l2.size());
    }

    /**
     * Retourne un objet java.util.Date, avec l'année, le mois et le jour passé en parametre
     * heure =0 ,minutes =0 et secondes = 0
     *
     * @param year
     * @param month
     * @param day
     * @return
     */
    public static Date getDateFrom(int year, int month, int day) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month - 1);
        cal.set(Calendar.DAY_OF_MONTH, day);
        cal.set(Calendar.HOUR, 1);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);

        return cal.getTime();
    }

    /**
     * Calcule le nombre de jours entre date1 et date2 : date2-date1
     *
     * @param date1
     * @param date2
     * @return
     */
    public static long differenceNbJours(Date date1, Date date2) {
        return ((date2.getTime() - date1.getTime()) / 86400000);
    }

    /**
     * Exporte la liste des clients et des contacts au format CSV, dans le dossier directory
     *
     * @throws Exception
     */
    public static Map<String, String> exportAllClientsCSV() {
        final String CSVseparator = ",";
        Map<String, String> result = new HashMap<>();
        String fileNameClients = "clientsExported-PearCorporation.csv";
        String fileNameContacts = "contactsExported-PearCorporation.csv";


        result.put(fileNameClients, exportClients(fileNameClients, CSVseparator));
        result.put(fileNameContacts, exportContacts(fileNameContacts, CSVseparator));
        return result;
    }


    /**
     * Exporte la liste des clients dans le fichier fileName
     *
     * @param fileName
     * @param CSVseparator
     * @throws Exception
     */
    private static String exportClients(String fileName, String CSVseparator) {
        final StringBuffer sbResult = new StringBuffer();

        List<Client> listClients = Client.find.all();
        sbResult.append("Nom");
        sbResult.append(CSVseparator);
        sbResult.append("Adresse");
        sbResult.append(CSVseparator);
        sbResult.append("Zip Code");
        sbResult.append(CSVseparator);
        sbResult.append("Ville");
        sbResult.append(CSVseparator);
        sbResult.append("Pays");
        sbResult.append('\n');

        for (Client client : listClients) {
            sbResult.append(client.nom);
            sbResult.append(CSVseparator);
            sbResult.append(client.adresseClient.adresse);
            sbResult.append(CSVseparator);
            sbResult.append(client.adresseClient.zipCode);
            sbResult.append(CSVseparator);
            sbResult.append(client.adresseClient.ville);
            sbResult.append(CSVseparator);
            sbResult.append(client.adresseClient.pays);
            sbResult.append('\n');
        }

        return sbResult.toString();
    }

    /**
     * Exporte la liste des contacts dans le fichier fileName
     *
     * @param fileName
     * @param CSVseparator
     * @throws Exception
     */
    private static String exportContacts(String fileName, String CSVseparator) {
        final StringBuffer sbResult = new StringBuffer();

        List<Contact> listContacts = Contact.find.all();
        sbResult.append("Nom");
        sbResult.append(CSVseparator);
        sbResult.append("Prenom");
        sbResult.append(CSVseparator);
        sbResult.append("Email");
        sbResult.append(CSVseparator);
        sbResult.append("Telephone");
        sbResult.append(CSVseparator);
        sbResult.append("Client");
        sbResult.append('\n');

        for (Contact contact : listContacts) {
            sbResult.append(contact.nom);
            sbResult.append(CSVseparator);
            sbResult.append(contact.prenom);
            sbResult.append(CSVseparator);
            sbResult.append(contact.email);
            sbResult.append(CSVseparator);
            sbResult.append(contact.telephone);
            sbResult.append(CSVseparator);
            sbResult.append(contact.client.nom);
            sbResult.append('\n');
        }

        return sbResult.toString();
    }

    public static void importAllClientsCSV(String fileNameClient, String fileNameContact) {
        String lineClient = "";
        String lineContact = "";

        String CSVseparator = ",";
        int prioriteDefault = 3;
        boolean firstLine = true;

        try {
            BufferedReader readerClients = new BufferedReader(new FileReader(fileNameClient));
            BufferedReader readerContacts = new BufferedReader(new FileReader(fileNameContact));

            while ((lineClient = readerClients.readLine()) != null) {
                if (!firstLine) {
                    String[] read = lineClient.split(CSVseparator);
                    Adresse adresse = new Adresse(read[1], read[2], read[3], read[4]);
                    adresse.save();
                    Client client = new Client(read[0], prioriteDefault, false, adresse, null, null);
                    client.save();
                }
                firstLine = false;
            }
            readerClients.close();

            firstLine = true;

            while ((lineContact = readerContacts.readLine()) != null) {
                if (!firstLine) {
                    String[] read = lineContact.split(CSVseparator);
                    Contact contact = new Contact(read[0], read[1], read[2], read[3]);
                    String nomClient = read[4];
                    Client client = Client.find.where().eq("nom", nomClient).findUnique();
                    contact.client = client;
                    client.listeContacts.add(contact);
                    contact.save();
                    client.update();
                }
                firstLine = false;
            }
            readerContacts.close();

        } catch (Exception e) {
            Logger.error("Impossible d'importer la liste des clients [" + fileNameClient + "] et des contacts [" + fileNameContact + "]: " + e.getMessage(), e);
        }
    }

    public static File fileFromString(String fileContent, String prefix, String suffix) {
        File file = null;
        try {
            file = File.createTempFile(prefix, suffix);
            file.deleteOnExit();

            try (FileWriter fileWriter = new FileWriter(file)) {
                fileWriter.flush();
                fileWriter.write(fileContent);
            } catch (IOException e) {
                play.Logger.error("File writing error", e);
            }

        } catch (IOException e) {
            play.Logger.error("Error creating file from content: ", e);
        }
        play.Logger.debug(file.getAbsolutePath());
        return file;
    }

    /**
     * Zip a list of file into one zip file.
     *
     * @param files         files to zip
     * @param targetZipFile target zip file
     * @throws IOException IO error exception can be thrown when copying ...
     */
    public static void zipFile(final List<File> files, final File targetZipFile) throws IOException {
        try {
            FileOutputStream fos = new FileOutputStream(targetZipFile);
            ZipOutputStream zos = new ZipOutputStream(fos);
            byte[] buffer = new byte[128];
            for (int i = 0; i < files.size(); i++) {
                File currentFile = files.get(i);
                if (!currentFile.isDirectory()) {
                    ZipEntry entry = new ZipEntry(trimTmpFileName(currentFile.getName()));
                    FileInputStream fis = new FileInputStream(currentFile);
                    zos.putNextEntry(entry);
                    int read = 0;
                    while ((read = fis.read(buffer)) != -1) {
                        zos.write(buffer, 0, read);
                    }
                    zos.closeEntry();
                    fis.close();
                }
            }
            zos.close();
            fos.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found : " + e);
        }

    }

    public static boolean equals(Date date1, Date date2) {
        SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMdd");
        return fmt.format(date1).equals(fmt.format(date2));
    }

    public static boolean before(Date date1, Date date2) {
        SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMdd");
        int date1Int = Integer.parseInt(fmt.format(date1).toString());
        int date2Int = Integer.parseInt(fmt.format(date2).toString());
        return date1Int < date2Int;
    }

    public static boolean after(Date date1, Date date2) {
        SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMdd");
        int date1Int = Integer.parseInt(fmt.format(date1).toString());
        int date2Int = Integer.parseInt(fmt.format(date2).toString());
        return date1Int > date2Int;
    }


    private static String trimTmpFileName(String name) {
        return name.replaceAll("[0-9]", "");
    }

    public static String sendMailMotDePasseOublie(Utilisateur user) {
        final Email email = new Email();
        email.setSubject("[ My Project - Polytech ] Test 2 ");
        email.setFrom("NE-PAS-REPONDRE <myproject.polytechparissud@gmail.com>");

        email.addTo(user.getFirstname() + " " + user.getLastname() + "<" + user.getEmail() + ">");

        // adds attachment
        //email.addAttachment("attachment.pdf", new File("/some/path/attachment.pdf"));
        // adds inline attachment from byte array
        // email.addAttachment("data.txt", "data".getBytes(), "text/plain", "Simple data", EmailAttachment.INLINE);
        // sends text, HTML or both...
        //email.setBodyText("Hi Yasser");


        email.setBodyHtml("<html><body><p>Bonjour " + user.getFirstname() + " " + user.getLastname() + ",<br>Voici votre nouveau mot de passe : " + user.genererPassword() + "<br>Cordialement,</body></html>");

        Mail.sendEmail(email);

        return ("ok mail envoyé.");
    }

}

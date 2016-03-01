package models.Utils;

import models.Adresse;
import models.Client;
import models.Contact;

import java.io.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by Guillaume on 10/02/2016.
 */
public class Utils {

    /**
     * Teste si les deux listes passées en parametre sont égales
     * @param l1
     * @param l2
     * @param <T>
     * @return
     */
    public static <T> boolean isEqualList(List<T> l1, List<T> l2){
        return (l1!=null && l2!= null && l1.containsAll(l2)
                && l2.containsAll(l1) && l1.size()==l2.size());
    }

    /**
     * Retourne un objet java.util.Date, avec l'année, le mois et le jour passé en parametre
     * heure =0 ,minutes =0 et secondes = 0
     * @param year
     * @param month
     * @param day
     * @return
     */
    public static Date getDateFrom(int year, int month, int day){
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month-1);
        cal.set(Calendar.DAY_OF_MONTH, day);
        cal.set(Calendar.HOUR,0);
        cal.set(Calendar.MINUTE,0);
        cal.set(Calendar.SECOND,0);

        return cal.getTime();
    }

    /**
     * Calcule le nombre de jours entre date1 et date2 : date2-date1
     * @param date1
     * @param date2
     * @return
     */
    public static long differenceNbJours(Date date1, Date date2) {
        return ((date2.getTime() - date1.getTime()) / 86400000);
    }

    /**
     * Exporte la liste des clients et des contacts au format CSV, dans le dossier directory
     * @param directory
     * @throws Exception
     */
    public static void exportAllClientsCSV(String directory) throws Exception{
        String fileNameClients = "clientsExported-PearCorporation.csv";
        String fileNameContacts = "contactsExported-PearCorporation.csv";
        String CSVseparator = ",";
        exportClients(fileNameClients, CSVseparator);
        exportContacts(fileNameContacts, CSVseparator);
    }


    /**
     * Exporte la liste des clients dans le fichier fileName
     * @param fileName
     * @param CSVseparator
     * @throws Exception
     */
    private static void exportClients(String fileName, String CSVseparator) throws Exception {
        try {
            List<Client> listClients = Client.find.all();
            Writer writer = new FileWriter(fileName);
            writer.append("Nom");
            writer.append(CSVseparator);
            writer.append("Adresse");
            writer.append(CSVseparator);
            writer.append("Zip Code");
            writer.append(CSVseparator);
            writer.append("Ville");
            writer.append(CSVseparator);
            writer.append("Pays");
            writer.append('\n');

            for(Client client : listClients) {
                writer.append(client.nom);
                writer.append(CSVseparator);
                writer.append(client.adresseClient.adresse);
                writer.append(CSVseparator);
                writer.append(client.adresseClient.zipCode);
                writer.append(CSVseparator);
                writer.append(client.adresseClient.ville);
                writer.append(CSVseparator);
                writer.append(client.adresseClient.pays);
                writer.append('\n');
            }
            writer.flush();
            writer.close();
        }
        catch(Exception e) {
            throw new Exception("Impossible d'exporter les clients dans le fichier ["+ fileName +"] : " + e.getMessage());
        }
    }

    /**
     * Exporte la liste des contacts dans le fichier fileName
     * @param fileName
     * @param CSVseparator
     * @throws Exception
     */
    private static void exportContacts(String fileName, String CSVseparator) throws Exception {
        try {
            List<Contact> listContacts = Contact.find.all();
            Writer writer = new FileWriter(fileName);
            writer.append("Nom");
            writer.append(CSVseparator);
            writer.append("Prenom");
            writer.append(CSVseparator);
            writer.append("Email");
            writer.append(CSVseparator);
            writer.append("Telephone");
            writer.append(CSVseparator);
            writer.append("Client");
            writer.append('\n');

            for(Contact contact: listContacts) {
                writer.append(contact.nom);
                writer.append(CSVseparator);
                writer.append(contact.prenom);
                writer.append(CSVseparator);
                writer.append(contact.email);
                writer.append(CSVseparator);
                writer.append(contact.telephone);
                writer.append(CSVseparator);
                writer.append(contact.client.nom);
                writer.append('\n');
            }
            writer.flush();
            writer.close();
        }
        catch(Exception e) {
            throw new Exception("Impossible d'exporter les contacts dans le fichier ["+ fileName +"] : " + e.getMessage());
        }
    }

    public static void importAllClientsCSV(String fileNameClient, String fileNameContact){
        String lineClient = "";
        String lineContact = "";

        String CSVseparator = ",";
        int prioriteDefault = 3;
        boolean firstLine = true;

        try {
            BufferedReader readerClients = new BufferedReader(new FileReader(fileNameClient));
            BufferedReader readerContacts = new BufferedReader(new FileReader(fileNameContact));

            while ((lineClient = readerClients.readLine()) != null) {
                if(!firstLine){
                    String[] read = lineClient.split(CSVseparator);
                    Client client = new Client(read[0], prioriteDefault, false, new Adresse(read[1], read[2], read[3], read[4]), null, null);
                    client.save();
                }
                firstLine = false;
            }
            readerClients.close();

            firstLine = true;

            while ((lineContact = readerContacts.readLine()) != null) {
                if(!firstLine){
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

        }
        catch (Exception e) {
            System.err.println("Impossible d'importer la liste des clients ["+fileNameClient +"] et des contacts ["+fileNameContact+"]: " + e.getMessage());
        }
    }

}

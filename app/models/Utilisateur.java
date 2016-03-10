package models;

import com.avaje.ebean.common.BeanList;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import controllers.Global.StaticEntite;
import models.Securite.Role;
import models.Utils.Utils;
import play.Logger;
import play.data.validation.Constraints;

import javax.persistence.*;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;
import java.util.stream.Collectors;

@Entity
@Table
public class Utilisateur extends Personne {

    /**
     * Coefficients utilisés pour l'algorithme de proposition de taches à l'utilisateur
     */
    private static int COEFFICIENT_CRITERE_1 = 4;
    private static int COEFFICIENT_CRITERE_2 = 3;
    private static int COEFFICIENT_CRITERE_3 = 2;
    private static int COEFFICIENT_CRITERE_4 = 1;

    private static int LIMITE_PROJET_PRESQUE_FINI = 80;
    private static int LIMITE_TACHE_PRESQUE_FINI = 80;

    public static String LANGUE_FR = "FR";
    public static String LANGUE_EN = "EN";

    @Constraints.Required
    protected String password;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable
    public List<Notification> listNotifications;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "Tache")
    private List<Tache> listTaches;

    @ManyToMany(cascade = {CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    List<Tache> listTachesNotifications;
    // liste des utilisateurs où je souhaite recevoir une notification

    @ManyToMany
    @JoinTable(name = "tbl_follow_user",
            joinColumns = @JoinColumn(name = "utilisateursSuivis", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "utilisateursMeSuivant", referencedColumnName = "id") /** TODO ENLEVER car utilisateursMeSuivant n'existe plus **/
    )
    public List<Utilisateur> utilisateursSuivis;

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "utilisateursNotifications")
    @JsonIgnore
    public List<Projet> projetsNotifications;
    /**
     * TODO ENLEVER
     **/

    public String langue;

    public boolean recevoirNotifPourMesActions;
    public boolean recevoirNotifPourMesTachesPresqueFinies;
    public boolean recevoirNotifPourMesTachesRetardees;

    public String bloc_note;

    @OneToMany(mappedBy = "utilisateur")
    public List<NotificationGroupee> listNotificationsGroupees = new BeanList<>();

    public static Finder<Long, Utilisateur> find = new Finder<>(Utilisateur.class);

    public static Utilisateur authenticate(String email, String password) {
        Utilisateur utilisateur = Utilisateur.find.where().eq("email", email).findUnique();
        if (utilisateur != null && utilisateur.checkPassword(password)) {
            return utilisateur;
        } else {
            return null;
        }
    }

    ////TODO Make connection to the database to check the authentication
    //public String validate() {
    //    //if (!email.equals("yasser.rabi@gmail.com") || !password.equals("123456")) {
    //    //    return "Invalid email or password";
    //    //}
    //    Utilisateur utilisateurAuthentifie = Utilisateur.authenticate(email, password);
    //    if (utilisateurAuthentifie == null) {
    //        return "Invalid email or password";
    //    }
    //    return null;
    //}

    private Utilisateur(String nom, String prenom, String email, String telephone, boolean archive, List<Tache> listTaches,
                        List<Tache> listTachesNotifications, List<Utilisateur> utilisateursSuivis, String langue,
                        boolean recevoirNotifPourMesActions, boolean recevoirNotifPourMesTachesPresqueFinies,
                        boolean recevoirNotifPourMesTachesRetardees, String bloc_note, List<Notification> listNotifications) {
        super(nom, prenom, email, telephone, archive);
        this.listTaches = (listTaches == null) ? new BeanList<>() : listTaches;
        this.listTachesNotifications = (listTachesNotifications == null) ? new BeanList<>() : listTachesNotifications;
        this.utilisateursSuivis = (utilisateursSuivis == null) ? new BeanList<>() : utilisateursSuivis;
        this.listNotifications = (listNotifications == null) ? new BeanList<>() : listNotifications;

        if (langue != LANGUE_FR && langue != LANGUE_EN) {
            System.err.println("La langue passée en paramètre est incorrecte : " + langue + ". Seuls les paramètres [" + LANGUE_FR + "] et [" + LANGUE_EN + "] sont acceptés. Langue choisie par défaut : [ " + LANGUE_FR + "]");
            this.langue = LANGUE_FR;
        } else {
            this.langue = langue;
        }
        this.recevoirNotifPourMesActions = recevoirNotifPourMesActions;
        this.recevoirNotifPourMesTachesPresqueFinies = recevoirNotifPourMesTachesPresqueFinies;
        this.recevoirNotifPourMesTachesRetardees = recevoirNotifPourMesTachesRetardees;
        this.bloc_note = (bloc_note == null) ? "" : bloc_note;
        listNotificationsGroupees = new BeanList<>();
    }

    private Utilisateur(String nom, String prenom, String email, String telephone, boolean archive) {
        this(nom, prenom, email, telephone, archive, null, null, null, LANGUE_FR, false, false, false, null, null);
    }

    public static Utilisateur create(String nom, String prenom, String email, String telephone, String password) {
        Utilisateur user = new Utilisateur(nom, prenom, email, telephone, false);
        user.save();
        user.setPassword(password);
        user.update();
        return user;
    }

    public Utilisateur() {
        /** TODO : peut etre enlever car c'est peut etre ça qui fait que on a pas les listTaches, et tout **/
        this.listTaches = new BeanList<>();
        this.listTachesNotifications = new BeanList<>();
        this.utilisateursSuivis = new BeanList<>();
        this.listNotifications = new BeanList<>();
        this.langue = LANGUE_FR;
        listNotificationsGroupees = new BeanList<>();
    }

    public void setFirstName(String firstName) {
        this.prenom = firstName;
    }

    public String getFirstname() {
        return this.prenom;
    }

    public void setLastName(String lastName) {
        this.nom = lastName;
    }

    public String getLastname() {
        return this.nom;
    }

    public void setTelephone(String tel) {
        this.telephone = tel;
    }

    public String getTelephone() {
        return this.telephone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setPassword(String password) throws IllegalArgumentException {
        if (!validatePassword(password)) {
            throw new IllegalArgumentException("Mot de passe : " + password + " incorrect, veuillez mettre au moins 1 Maj, 1 min, 1 chiffre et 6 caracteres minimum");
        }
        this.password = hachage(this.id, password);
    }

    public String getPassword() {
        return password;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        try {
            Utilisateur utilisateur = (Utilisateur) obj;
            return utilisateur.email.equals(this.email);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public int hashCode() {
        return Integer.parseInt(id.toString());
    }

    @Override
    public String toString() {
        return "[Utilisateur : " + super.toString() + ", Password :" + password + ")";
    }

    /**
     * FIXME rustine car le champ ne contient pas la liste des projets
     *
     * @return list des projets du responsable
     */
    public List<Projet> listProjetsResponsable() {
        List<Projet> listProjet = Projet.find.where().eq("responsableProjet", this).findList();
        /** TODO : obliger de faire ça car pas présent en BDD **/
        for (Projet projet : listProjet) {
            projet.updateAvancementGlobal();
        }
        return listProjet;
    }

    @JsonSerialize
    public int listProjetsResponsableSize() {
        return listProjetsResponsable().size();
    }

    /**
     * Affecte la tache en parametre a l'utilisateur courant
     *
     * @param tache
     */
    @Transient
    public void affectTache(Tache tache) {
        if (listTaches.contains(tache)) {
            throw new IllegalArgumentException("L'utilisateur " + nom + ", possede deja la tache " + tache.nom);
        }
        tache.responsableTache = this;
        listTaches.add(tache);
        tache.save();
        save();
    }

    /**
     * FIXME rustine car le champ ne contient pas la liste des taches
     *
     * @return list des taches du responsable
     */
    public List<Tache> listTaches() {
        listTaches = Tache.find.where().eq("responsableTache", this).findList();
        return listTaches;
    }

    public List<Tache> listTachesDansProjetNonResponsable(Projet projet) {
        List<Tache> tachesTmp = Tache.find.where().eq("responsableTache", this).eq("projet", projet).findList();
        List<Tache> taches = new ArrayList<>(tachesTmp);
        // Ajout des taches meres et filles
        for (Tache tache : tachesTmp) {
            ajoutDesTachesParents(taches, tache);
            ajoutDesTachesEnfants(taches, tache);
        }

        // Tri en fonction des id - Liste tache dans sort
        Collections.sort(taches, new Comparator<Tache>() {
            @Override
            public int compare(Tache t1, Tache t2) {
                String[] idT1Parse = t1.idTache.split("\\.");
                String[] idT2Parse = t2.idTache.split("\\.");
                Integer[] idT1Integer = new Integer[idT1Parse.length];
                Integer[] idT2Integer = new Integer[idT2Parse.length];
                for (int i = 0; i < idT1Parse.length; i++) {
                    idT1Integer[i] = Integer.parseInt(idT1Parse[i]);
                }
                for (int i = 0; i < idT2Parse.length; i++) {
                    idT2Integer[i] = Integer.parseInt(idT2Parse[i]);
                }
                for (int i = 0; i < idT1Integer.length || i < idT2Integer.length; i++) {
                    if (i >= idT1Integer.length)
                        return -1;
                    if (i >= idT2Integer.length)
                        return 1;
                    if (idT1Integer[i] < idT2Integer[i])
                        return -1;
                    if (idT1Integer[i] > idT2Integer[i])
                        return 1;
                }
                return 0;
            }
        });
        return taches;
    }

    /**
     * TODO A TESTER
     **/
    public List<Tache> listTachesDansProjetNonResponsableAAfficher(Projet projet) {
        List<Tache> taches = listTachesDansProjetNonResponsable(projet);
        for (int i = 0; i < taches.size(); i++) {
            if (enfantIsPresent(taches.get(i).enfants(), taches)) {
                removeEnfants(taches.get(i), taches);
                i--;
            }
        }
        return taches;
    }

    public boolean enfantIsPresent(List<Tache> enfants, List<Tache> taches) {
        for (Tache enfant : enfants) {
            if (taches.contains(enfant))
                return true;
        }
        return false;
    }

    private void removeEnfants(Tache tache, List<Tache> taches) {
        if (tache.hasEnfant()) {
            for (int i = 0; i < tache.enfants().size(); i++) {
                if (taches.contains(tache.enfants().get(i))) {
                    taches.remove(tache.enfants().get(i));
                    removeEnfants(tache.enfants().get(i), taches);
                    i--;
                }
            }
        }
    }


    private void ajoutDesTachesParents(List<Tache> taches, Tache tache) {
        if (tache.hasParent()) {
            if (!taches.contains(tache.parent))
                taches.add(tache.parent);
            ajoutDesTachesParents(taches, tache.parent);
        }
    }

    private void ajoutDesTachesEnfants(List<Tache> taches, Tache tache) {
        if (tache.hasEnfant()) {
            for (Tache enfant : tache.enfants()) {
                if (!taches.contains(enfant))
                    taches.add(enfant);
                ajoutDesTachesParents(taches, enfant);
            }
        }
    }

    @JsonSerialize
    public int listTachesSize() {
        return listTaches().size();
    }

    public List<Notification> listNotifications() {
        listNotifications = Notification.find.where().eq("utilisateur", this).findList();
        return listNotifications;
    }

    public int nbNotificationsNonLues() {
        listNotifications = listNotifications();
        int cpt = 0;
        for (Notification notif : listNotifications) {
            if (!notif.etatLecture) cpt++;
        }
        return cpt;
    }

    /**
     * Verifie si le mot de passe saisi correspond bien au mot de passe de l'utilisateur
     *
     * @param passwordAttempt
     * @return
     */
    public boolean checkPassword(String passwordAttempt) {
        return hachage(this.id, passwordAttempt).equals(this.password);
    }

    /**
     * Donne la liste des projets où participe l'utilisateur
     *
     * @return
     */
    public List<Projet> listProjets() {
        List<Projet> listProjet = listProjetsResponsable();
        if (listProjet == null) listProjet = new BeanList<>();
        for (Tache tache : listTaches()) {
            if (!listProjet.contains(tache.projet)) {
                listProjet.add(tache.projet);
            }
        }
        return listProjet;
    }

    /**
     * TODO : peut etre faire une requete uniquement
     *
     * @return
     */
    public List<Client> listClients() {
        List<Projet> listProjets = listProjets();
        List<Client> listClients = new BeanList<>();
        for (Projet projet : listProjets) {
            if (!listClients.contains(projet.client)) {
                listClients.add(projet.client);
            }
        }
        return listClients;
    }

    /**
     * TODO : peut etre faire une requete uniquement
     *
     * @param client
     * @return
     */
    public List<Projet> listProjetsDuClient(Client client) {
        List<Projet> listProjets = listProjets();
        List<Projet> listToReturn = new BeanList<>();
        for (Projet projet : listProjets) {
            if (projet.client.equals(client)) {
                listToReturn.add(projet);
            }
        }
        return listToReturn;
    }

    /**
     * Méthode de hachage du mot de passe avec l'objet digest
     *
     * @param numClient
     * @param password
     * @return
     */
    public String hachage(Long numClient, String password) {
        String sha1 = "";
        String s = String.valueOf(numClient);
        String to_encrypt = s + password;
        try {
            MessageDigest crypt = MessageDigest.getInstance("SHA-1");
            crypt.reset();
            crypt.update(to_encrypt.getBytes("UTF-8"));
            sha1 = byteToHex(crypt.digest());
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
            Logger.error(e.getMessage());
        }
        return sha1;
    }

    /**
     * @param hash
     * @return
     */
    private static String byteToHex(final byte[] hash) {
        Formatter formatter = new Formatter();
        for (byte b : hash) {
            formatter.format("%02x", b);
        }
        String result = formatter.toString();
        formatter.close();
        return result;
    }

    /**
     * Verifie que le mot de passe contient bien une Maj, une minuscule , un chiffre et a une taille >= 6
     *
     * @param password
     * @return
     */
    public boolean validatePassword(String password) {
        boolean hasUppercase = !password.equals(password.toLowerCase());
        boolean hasLowercase = !password.equals(password.toUpperCase());
        boolean hasnumber = password.matches(".*\\d+.*");

        return (password.length() >= 6 && hasUppercase && hasLowercase && hasnumber);
    }

    /**
     * Genere un nouveau mot de passe pour l'utilisateur (de taille 6, un chiffre, une majuscule, une minuscule au moins)
     *
     * @return
     */
    public static String genererPassword() {

        String upperCaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowerCaseLetters = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "0123456789";
        int passwordLength = 6;
        char password[] = new char[passwordLength];

        List<Integer> positions = new ArrayList<Integer>();
        for (int i = 0; i < passwordLength; i++) {
            positions.add(i);
        }

        int index_position;

        // 1ere minuscule
        index_position = getRandomInt(0, positions.size());
        password[positions.get(index_position)] = getRandomChar(lowerCaseLetters);
        positions.remove(index_position);

        // 1ere majuscule
        index_position = getRandomInt(0, positions.size());
        password[positions.get(index_position)] = getRandomChar(upperCaseLetters);
        positions.remove(index_position);

        // 1er chiffre
        index_position = getRandomInt(0, positions.size());
        password[positions.get(index_position)] = getRandomChar(numbers);
        positions.remove(index_position);

        // Autres caractères
        for (int pos : positions) {
            password[pos] = getRandomChar(upperCaseLetters, lowerCaseLetters, numbers);
        }

        return (String.valueOf(password));
    }

    private static int getRandomInt(int deb, int fin) {
        Random rand = new Random();
        return rand.nextInt(fin - deb) + deb;
    }

    private static char getRandomChar(String... strings) {
        String str;
        if (strings.length == 0) {
            str = strings[0];
        } else {
            str = strings[getRandomInt(0, strings.length)];
        }
        return str.charAt(getRandomInt(0, str.length()));
    }

    public List<Tache> tachesProposees() {
        List<Tache> listTachesProposees = new ArrayList<Tache>();
        listTaches = listTaches();
        if (listTaches.isEmpty())
            return listTachesProposees;

        if (listTaches.size() == 1) {
            listTachesProposees.add(listTaches.get(0));
            return listTachesProposees;
        }
        int pos_tache_1;
        int pos_tache_2;

        setPrioriteTache(listTaches.get(0));
        setPrioriteTache(listTaches.get(1));

        if (listTaches.get(0).priorite > listTaches.get(1).priorite) {
            pos_tache_1 = 0;
            pos_tache_2 = 1;
        } else {
            pos_tache_1 = 1;
            pos_tache_2 = 0;
        }

        if (listTaches.size() == 2) {
            listTachesProposees.add(listTaches.get(pos_tache_1));
            listTachesProposees.add(listTaches.get(pos_tache_2));
            return listTachesProposees;
        }

        int pos_tache_3;
        setPrioriteTache(listTaches.get(2));
        if (listTaches.get(2).priorite > listTaches.get(pos_tache_1).priorite) {
            pos_tache_3 = pos_tache_2;
            pos_tache_2 = pos_tache_1;
            pos_tache_1 = 2;
        } else if (listTaches.get(2).priorite > listTaches.get(pos_tache_2).priorite) {
            pos_tache_3 = pos_tache_2;
            pos_tache_2 = 2;
        } else {
            pos_tache_3 = 2;
        }

        for (int i = 3; i < listTaches.size(); i++) {
            // Calcule du critère de priorité de la tâche a la position n°i de la liste de tâche “listTaches”
            setPrioriteTache(listTaches.get(i));

            // Si la tâche n°i a une priorité plus élevé que la tâche n°pos_tache_1, alors la tâche n°i remplace la tâche
            // n°pos_tache_1, la tâche n°pos_tache_1 remplace la tâche n°pos_tache_2 et la tâche n°pos_tache_2 remplace la tâche n+pos_tache_3
            if (listTaches.get(i).priorite > listTaches.get(pos_tache_1).priorite) {
                pos_tache_3 = pos_tache_2;
                pos_tache_2 = pos_tache_1;
                pos_tache_1 = i;
            }

            // Si la tâche n°i a une priorité plus élevé que la tâche n°pos_tache_2, alors la tâche n°i remplace la tâche
            // n°pos_tache_2, et la tâche n°pos_tache_2 remplace la tâche n+pos_tache_3
            else if (listTaches.get(i).priorite > listTaches.get(pos_tache_2).priorite) {
                pos_tache_3 = pos_tache_2;
                pos_tache_2 = i;
            }

            // Si la tâche n°i a une priorité plus élevé que la tâche n°pos_tache_3, alors la tâche n°i remplace la tâche n°pos_tache_3
            else if (listTaches.get(i).priorite > listTaches.get(pos_tache_3).priorite) {
                pos_tache_3 = i;
            }
        }

        listTachesProposees.add(listTaches.get(pos_tache_1));
        listTachesProposees.add(listTaches.get(pos_tache_2));
        listTachesProposees.add(listTaches.get(pos_tache_3));
        return listTachesProposees;
    }

    private void setPrioriteTache(Tache t) {
        try {
            t.priorite = COEFFICIENT_CRITERE_1 * critere1(t)
                    + COEFFICIENT_CRITERE_2 * critere2(t)
                    + COEFFICIENT_CRITERE_3 * critere3(t)
                    + COEFFICIENT_CRITERE_4 * critere4(t);
        } catch (Exception e) {
            t.priorite = 0;
            Logger.warn("Priorite de la tache [" + t.nom + "] = 0 car : " + e.getMessage());
        }
    }

    private int critere1(Tache t) {
        if (t.critique)
            return 5;
        return 1;
    }

    private int critere2(Tache t) {
        Calendar cal = Calendar.getInstance();
        Calendar today = new GregorianCalendar(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH) + 1, cal.get(Calendar.DATE));
        long nbJoursRestants = Utils.differenceNbJours(today.getTime(), t.dateFinTard);

        if (nbJoursRestants >= 51) {
            return 1;
        } else if (26 <= nbJoursRestants && nbJoursRestants <= 50) {
            return 2;
        } else if (11 <= nbJoursRestants && nbJoursRestants <= 25) {
            return 3;
        } else if (6 <= nbJoursRestants && nbJoursRestants <= 10) {
            return 4;
        } else {
            if (nbJoursRestants < 0) {
                nbJoursRestants = 0;
            }
            return 10 - (int) nbJoursRestants;
        }
    }

    private int critere3(Tache t) throws Exception {
        if (t.projet.unite == UniteProjetEnum.JOUR) {
            return critere3Jour(t);
        } else if (t.projet.unite == UniteProjetEnum.SEMAINE) {
            return critere3Semaine(t);
        } else {
            // PB
            throw new Exception("Pas d'unité pour le projet [" + t.projet.nom + "] concernant la tache [" + t.nom + "]");
        }
    }

    private int critere3Jour(Tache t) {
        double chargeRestante = t.chargeRestante;
        if (chargeRestante >= 51) {
            return 1;
        } else if (26 <= chargeRestante && chargeRestante <= 50) {
            return 2;
        } else if (11 <= chargeRestante && chargeRestante <= 25) {
            return 3;
        } else if (6 <= chargeRestante && chargeRestante <= 10) {
            return 4;
        } else {
            return 5;
        }
    }

    private int critere3Semaine(Tache t) {
        double chargeRestante = t.chargeRestante;

        if (chargeRestante >= 7) {
            return 1;
        } else if (4 <= chargeRestante && chargeRestante <= 6) {
            return 2;
        } else if (chargeRestante == 3) {
            return 3;
        } else if (chargeRestante == 2) {
            return 4;
        } else {
            return 5;
        }
    }

    private int critere4(Tache t) {
        return 7 - (t.projet.priorite + t.projet.client.priorite);
    }

    /**
     * TODO TESTME
     **/
    public int nbDeProjetsResponsableActuel() {
        int cpt = 0;
        for (Projet projet : listProjetsResponsable()) {
            if (projet.enCours) cpt++;
        }
        return cpt;
    }

    /**
     * TODO TESTME
     * TODO voir byte vs double
     *
     * @return
     */
    public int nbDeProjetsResponsablePresqueFinis() {
        int cpt = 0;
        for (Projet projet : listProjetsResponsable()) {
            if (projet.enCours && projet.avancementGlobal >= LIMITE_PROJET_PRESQUE_FINI && projet.avancementGlobal < 100)
                cpt++;
        }
        return cpt;
    }

    /**
     * TODO TESTME
     * TODO : Remplacer dateFinReel par dateFinReelTard
     *
     * @return
     */
    public int nbDeProjetsResponsableRetardes() {
        int cpt = 0;
        for (Projet projet : listProjetsResponsable()) {
            if (projet.dateFinReelTard != null) {
                //if (projet.enCours && projet.dateFinReelTard.before(Calendar.getInstance().getTime())) cpt++;
                if (projet.enCours && Utils.before(projet.dateFinReelTard, Calendar.getInstance().getTime())) cpt++;
            }
        }
        return cpt;
    }

    /**
     * TODO TEST ME
     *
     * @return
     */
    public int nbTachesActuelles() {
        int cpt = 0;
        for (Tache tache : listTaches()) {
            if (!tache.archive && tache.estDisponible() && tache.getAvancementTache()*100 < 100.0) cpt++;
        }
        return cpt;
    }

    /**
     * TODO TEST ME
     *
     * @return
     */
    public int nbTachesNonCommencees() {
        int cpt = 0;
        for (Tache tache : listTaches()) {
            if (!tache.archive && tache.estDisponible() && tache.getAvancementTache()*100 == 0.0) cpt++;
        }
        return cpt;
    }

    /**
     * TODO TEST ME
     *
     * @return
     */
    public int nbTachesCommencees() {
        int cpt = 0;
        for (Tache tache : listTaches()) {
            if (!tache.archive && tache.estDisponible() && tache.getAvancementTache()*100 > 0.0 && tache.getAvancementTache()*100 < 100.0)
                cpt++;
        }
        return cpt;
    }

    /**
     * TODO TEST ME
     *
     * @return
     */
    public int nbTachesPresquesFinies() {
        int cpt = 0;
        for (Tache tache : listTaches()) {
            if (!tache.archive && tache.estDisponible() && tache.getAvancementTache()*100 >= LIMITE_TACHE_PRESQUE_FINI && tache.getAvancementTache()*100 < 100.0)
                cpt++;
        }
        return cpt;
    }

    /**
     * TODO TEST ME
     *
     * @return
     */
    public int nbTachesRetardees() {
        int cpt = 0;
        for (Tache tache : listTaches()) {
            //if (!tache.archive && tache.estDisponible() && tache.dateFinTard.before(Calendar.getInstance().getTime()))
            if (!tache.archive && tache.estDisponible() && Utils.before(tache.dateFinTard, Calendar.getInstance().getTime()))
                cpt++;
        }
        return cpt;
    }

    /**
     * TODO TEST ME
     **/
    public boolean hasProjetsResponsable() {
        return !listProjetsResponsable().isEmpty();
    }

    /**
     * TODO TEST ME
     *
     * @return
     */
    public List<Tache> tachesPresquesFinies() {
        List<Tache> res = new ArrayList<>();
        for (Tache tache : listTaches()) {
            if (!tache.archive && tache.estDisponible() && tache.getAvancementTache()*100 >= LIMITE_TACHE_PRESQUE_FINI && tache.getAvancementTache()*100 < 100.0)
                res.add(tache);
        }
        return res;
    }

    /**
     * TODO TEST ME
     *
     * @return
     */
    public List<Tache> tachesRetardees() {
        List<Tache> res = new ArrayList<>();
        for (Tache tache : listTaches()) {
            //if (!tache.archive && tache.estDisponible() && tache.dateFinTard.before(Calendar.getInstance().getTime()))
            if (!tache.archive && tache.estDisponible() && Utils.before(tache.dateFinTard, Calendar.getInstance().getTime()))
                res.add(tache);
        }
        return res;
    }

    public static List<Utilisateur> getAllArchives() {
        return find.where().eq("archive", true).findList();
    }

    public static List<Utilisateur> getAllNonArchives() {
        //Logger.debug(find.where().eq("archive",false).findList().toString());
        return find.where().eq("archive", false).findList();
    }

    public Boolean checkAdmin() {
        return StaticEntite.getSystem().haveRole(this, Role.getRole("Administrateur"));
    }

    public void suivreUnUtilisateur(Utilisateur user) {
        if (!utilisateursSuivis.contains(user)) {
            utilisateursSuivis.add(user);
            update();
        }
    }

    public List<Utilisateur> utilisateursPouvantEtreSuivis() {
        List<Utilisateur> result = new ArrayList<>();
        for (Projet projet : listProjetsResponsable()) {
            for (Tache tache : projet.listTaches()) {
                if (!result.contains(tache.responsableTache))
                    result.add(tache.responsableTache);
            }
        }
        return result;
    }

    public boolean hasActiverNotification(Tache tache) {
        return listTachesNotifications.contains(tache);
    }

    public void activerNotification(Tache tache) {
        // TODO : Rajouter un test de permission?
        if (!listTachesNotifications.contains(tache)) {
            listTachesNotifications.add(tache);
            save();
        }
        if (!tache.utilisateursNotifications.contains(this)) {
            tache.utilisateursNotifications.add(this);
            tache.save();
        }
    }

    public void desactiverNotification(Tache tache) {
        // TODO : Rajouter un test de permission?
        if (listTachesNotifications.contains(tache)) {
            listTachesNotifications.remove(tache);
            save();
        }
        if (tache.utilisateursNotifications.contains(this)) {
            tache.utilisateursNotifications.remove(this);
            tache.save();
        }
    }

    public void addNotification(Notification notification) {
        if (!listNotifications.contains(notification)) {
            listNotifications.add(notification);
            save();
        }
    }

    public static void supprimer(Long idUtilisateur) {
        Utilisateur u = find.byId(idUtilisateur);
        u.archive = true;
        u.save();
    }


    public void enleverResponsabiliteTache(Tache t){
        if(!listTaches().contains(t)){
            throw new IllegalArgumentException("L'utilisateur "+nom+" n'est pas responsable de la tache "+t.nom);
        }
        listTaches.remove(t);
        this.save();
        t.responsableTache = null;
        t.update();
    }

    public List<Utilisateur> utilisateursMeSuivant() {
        return Utilisateur.find
                .all()
                .parallelStream()
                .filter(utilisateur ->
                        utilisateur.utilisateursSuivis
                                .stream()
                                .filter(u -> u.id.equals(this.id))
                                .findFirst()
                                .isPresent()
                ).collect(Collectors.toList());
    }

    /**
     * Envoie les notifications
     */
    public void sendNotifications() {
        this.listNotificationsGroupees = getListNotificationsGroupees();

        System.out.println("Utilisateur/sendNotifications : liste des notifs à envoyer : " + listNotificationsGroupees);

        Map<Utilisateur, Notification> mapNotifications = convertMapNotificationsGroupees();
        Notification.sendNotifications(mapNotifications);
        mapNotifications.clear();
        for(int i=listNotificationsGroupees.size()-1; i>=0; i--){
            listNotificationsGroupees.get(i).delete();
        }
        this.listNotificationsGroupees.clear();
        this.save();
    }

    private Map<Utilisateur, Notification> convertMapNotificationsGroupees() {
        HashMap<Utilisateur, Notification> mapNotifications = new HashMap<Utilisateur, Notification>();

        // On parcours la liste des taches/projets qui doivent engendrer une notification
        for (NotificationGroupee notif : listNotificationsGroupees) {
            System.out.println("Notif n°" + notif.idProjetOuTache);
            Long id = notif.idProjetOuTache;
            TypeNotification typeNotification = notif.typeNotification;
            // Projet
            if (TypeNotification.isProjet(typeNotification)) {
                Projet projet = Projet.find.byId(id);
                if (typeNotification == TypeNotification.MODIFIER_PROJET) {
                    // Envoyer la notif aux responsable de projet si c'est pas lui et tous les collaborateurs
                    // + eventuellement à l'utilisateur s'il a activé les notifications pour ses actions
                    Notification.sendNotificationModifierProjet(projet, this, mapNotifications);
                } else if (typeNotification == TypeNotification.MODIFIER_RESPONSABLE_PROJET) {
                    Notification.sendNotificationModifierResponsableProjet(projet, notif.ancienRespo, this, mapNotifications);

                }
            }
            // Tache
            else if (TypeNotification.isTache(typeNotification)) {
                Tache tache = Tache.find.byId(id);
                if (typeNotification == TypeNotification.CREER_TACHE) {
                    Notification.sendNotificationCreerTache(tache, this, mapNotifications);
                } else if (typeNotification == TypeNotification.MODIFIER_AVANCEMENT_TACHE) {
                    Notification.sendNotificationModifierAvancementTache(tache, this, mapNotifications);
                } else if (typeNotification == TypeNotification.MODIFIER_TACHE) {
                    Notification.sendNotificationModifierTache(tache, this, mapNotifications);
                } else if (typeNotification == TypeNotification.MODIFIER_RESPONSABLE_TACHE) {
                    Notification.sendNotificationModifierResponsableTache(tache, notif.ancienRespo, this, mapNotifications);
                } else if (typeNotification == TypeNotification.SUPPRIMER_TACHE) {
                    Notification.sendNotificationSupprimerTache(tache, this, mapNotifications);
                }
            }
        }
        System.out.println("Avant de retourner mapNotif = " + mapNotifications);
        return mapNotifications;
    }

    private boolean listNotificationsGenereesContainsKey(Long id) {
        for (NotificationGroupee notif : listNotificationsGroupees) {
            if (notif.idProjetOuTache == id)
                return true;
        }
        return false;
    }

    private boolean listNotificationsGenereesContainsKeyAndValue(Long id, TypeNotification typeNotification) {
        for (NotificationGroupee notif : listNotificationsGroupees) {
            if (notif.idProjetOuTache == id && notif.typeNotification == typeNotification)
                return true;
        }
        return false;
    }

    private void listNotificationsGenereesRemove(Long id) {
        for (NotificationGroupee notif : listNotificationsGroupees) {
            if (notif.idProjetOuTache == id) {
                listNotificationsGroupees.remove(notif);
                notif.delete();
            }
        }
    }

    public void createNotificationCreerTache(Tache tache) {
        this.listNotificationsGroupees = getListNotificationsGroupees();
        NotificationGroupee notif = new NotificationGroupee(tache.id, TypeNotification.CREER_TACHE, this);
        notif.save();
        listNotificationsGroupees.add(notif);
        save();

    }

    public void createNotificationModifierTache(Tache tache) {
        this.listNotificationsGroupees = getListNotificationsGroupees();
        if (!listNotificationsGenereesContainsKey(tache.id)) {
            NotificationGroupee notif = new NotificationGroupee(tache.id, TypeNotification.MODIFIER_TACHE, this);
            notif.save();
            listNotificationsGroupees.add(notif);
            save();

        } else if (listNotificationsGenereesContainsKeyAndValue(tache.id, TypeNotification.MODIFIER_AVANCEMENT_TACHE)) {
            listNotificationsGenereesRemove(tache.id);
            NotificationGroupee notif = new NotificationGroupee(tache.id, TypeNotification.MODIFIER_TACHE, this);
            notif.save();
            listNotificationsGroupees.add(notif);
            save();
        }
    }

    public void createNotificationModifierAvancementTache(Tache tache) {
        this.listNotificationsGroupees = getListNotificationsGroupees();
        if (!listNotificationsGenereesContainsKey(tache.id)) {
            NotificationGroupee notif = new NotificationGroupee(tache.id, TypeNotification.MODIFIER_AVANCEMENT_TACHE, this);
            notif.save();
            listNotificationsGroupees.add(notif);
            save();
        }
    }

    public void createNotificationModifierResponsableTache(Tache tache, Utilisateur ancienResponsable) {
        System.out.println("Utilisateur/createNotifRespoTache : " + (ancienResponsable == null ? "null" : ancienResponsable.email));
        this.listNotificationsGroupees = getListNotificationsGroupees();
        System.out.println("Je suis appelé pour la tache : " + tache.nom);
        if (!listNotificationsGenereesContainsKey(tache.id) || !listNotificationsGenereesContainsKeyAndValue(tache.id, TypeNotification.CREER_TACHE)) {
            NotificationGroupee notif = new NotificationGroupee(tache.id, TypeNotification.MODIFIER_RESPONSABLE_TACHE, ancienResponsable, this);
            notif.save();
            listNotificationsGroupees.add(notif);
            save();
        }
    }

    // TODO METTRE EN PLACE
    public void createNotificationSupprimerTache(Tache tache) {
        this.listNotificationsGroupees = getListNotificationsGroupees();
        if (listNotificationsGenereesContainsKey(tache.id) && listNotificationsGenereesContainsKeyAndValue(tache.id, TypeNotification.CREER_TACHE)) {
            listNotificationsGenereesRemove(tache.id);
            save();
        } else {
            NotificationGroupee notif = new NotificationGroupee(tache.id, TypeNotification.SUPPRIMER_TACHE, this);
            notif.save();
            listNotificationsGroupees.add(notif);
            save();
        }
    }

    public void createNotificationModifierProjet(Projet projet) {
        this.listNotificationsGroupees = getListNotificationsGroupees();
        if (!listNotificationsGenereesContainsKey(projet.id)) {
            NotificationGroupee notif = new NotificationGroupee(projet.id, TypeNotification.MODIFIER_PROJET, this);
            notif.save();
            listNotificationsGroupees.add(notif);
            save();
        }
    }

    public void createNotificationModifierResponsableProjet(Projet projet, Utilisateur ancienResponsable) {
        this.listNotificationsGroupees = getListNotificationsGroupees();
        if (listNotificationsGenereesContainsKey(projet.id))
            listNotificationsGenereesRemove(projet.id);
        NotificationGroupee notif = new NotificationGroupee(projet.id, TypeNotification.MODIFIER_RESPONSABLE_PROJET, ancienResponsable, this);
        notif.save();
        listNotificationsGroupees.add(notif);
        save();
    }

    public List<NotificationGroupee> getListNotificationsGroupees(){
        this.listNotificationsGroupees = NotificationGroupee.find.where().eq("utilisateur", this).findList();
        return this.listNotificationsGroupees;
    }
}
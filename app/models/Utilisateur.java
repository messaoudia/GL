package models;

import com.avaje.ebean.common.BeanList;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import play.Logger;
import play.data.validation.Constraints;

import javax.persistence.*;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

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

    @Constraints.Required
    protected String password;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable
    public List<Notification> listNotifications;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "Tache")
    private List<Tache> listTaches;

    // TODO @qqch?
    List<Tache> listTachesNotifications;
    // TODO @qqch? + liste des utilisateurs où je souhaite recevoir une notification
    List<Utilisateur> utilisateursSuivis;
    // TODO @qqch? + liste des utilisateurs qui me suivent
    List<Utilisateur> utilisateursMeSuivant;

    //TODO Make connection to the database to check the authentication
    public String validate() {
        if (!email.equals("yasser.rabi@gmail.com") || !password.equals("123456")) {
            return "Invalid email or password";
        }
        return null;
    }

    public static Finder<Long, Utilisateur> find = new Finder<>(Utilisateur.class);

    public Utilisateur(String nom, String prenom, String email, String telephone,boolean archive, String password,List<Tache> listTaches,
                       List<Tache> listTachesNotifications,List<Utilisateur> utilisateursSuivis,List<Utilisateur> utilisateursMeSuivant) {
        super(nom, prenom, email, telephone,archive);
        setPassword(password);
        this.listTaches = (listTaches == null)?new BeanList<>():listTaches;
        this.listTachesNotifications = (listTachesNotifications == null)?new BeanList<>(): listTachesNotifications;
        this.utilisateursSuivis = (utilisateursSuivis == null)?new BeanList<>(): utilisateursSuivis;
        this.utilisateursMeSuivant = (utilisateursMeSuivant == null)?new BeanList<>(): utilisateursMeSuivant;
    }

    public Utilisateur(String nom, String prenom, String email, String telephone, boolean archive, String password) {
        this(nom, prenom, email, telephone,archive,password,null, null, null, null);
    }

    public Utilisateur() {
        this.listTaches = new BeanList<>();
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setPassword(String password) throws IllegalArgumentException{
        this.save();
        if(!validatePassword(password)){
            throw new IllegalArgumentException("Mot de passe : "+password+" incorrect, veuillez mettre au moins 1 Maj, 1 min, 1 chiffre et 6 caracteres minimum");
        }
        this.password = hachage(this.id,password);
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
            return utilisateur.password.equals(this.password) && super.equals(utilisateur);
        } catch (ClassCastException e) {
            return false;
        }
    }

    @Override
    public String toString() {
        return "[Utilisateur : "+super.toString() +", Password :" + password + ")";
    }

    /**
     * FIXME rustine car le champ ne contient pas la liste des projets
     * @return list des projets du responsable
     */
    public List<Projet> listProjetsResponsable(){
        List<Projet> listProjet = Projet.find.where().eq("responsableProjet",this).findList();
        /** TODO : obliger de faire ça car pas présent en BDD **/
        for(Projet projet : listProjet){
            projet.updateAvancementGlobal();
        }
        return listProjet;
    }

    @JsonSerialize
    public int listProjetsResponsableSize(){
        return listProjetsResponsable().size();
    }
    /**
     * Affecte la tache en parametre a l'utilisateur courant
     * @param tache
     */
    @Transient
    public void affectTache(Tache tache){
        if(listTaches.contains(tache)){
            throw new IllegalArgumentException("L'utilisateur "+nom+", possede deja la tache "+ tache.nom);
        }
        tache.responsableTache = this;
        listTaches.add(tache);
        tache.save();
        save();
    }

    /**
     * FIXME rustine car le champ ne contient pas la liste des taches
     * @return list des taches du responsable
     */
    public List<Tache> listTaches(){
        return Tache.find.where().eq("responsableTache",this).findList();
    }

    @JsonSerialize
    public int listTachesSize(){
        return listTaches().size();
    }

    // TODO getListTachesNotifications, utilisateursMeSuivant, utilisateursMeSuivant

    /**
     * Verifie si le mot de passe saisi correspond bien au mot de passe de l'utilisateur
     * @param passwordAttempt
     * @return
     */
    public boolean checkPassword(String passwordAttempt){
        return hachage(this.id,passwordAttempt).equals(this.password);
    }

    /**
     *  Méthode de hachage du mot de passe avec l'objet digest
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
     * @param password
     * @return
     */
    public boolean validatePassword(String password){
        boolean hasUppercase = !password.equals(password.toLowerCase());
        boolean hasLowercase = !password.equals(password.toUpperCase());
        boolean hasnumber = password.matches(".*\\d+.*");

        return (password.length()>=6 && hasUppercase && hasLowercase && hasnumber);
    }

    /**
     * Genere un nouveau mot de passe pour l'utilisateur (de taille 6, un chiffre, une majuscule, une minuscule au moins)
     * @return
     */
    public String genererPassword(){

        String upperCaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowerCaseLetters = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "0123456789";
        int passwordLength = 6;
        char password[] = new char[passwordLength];

        List<Integer> positions = new ArrayList<Integer>();
        for(int i=0; i<passwordLength; i++){
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
        for(int pos : positions){
            password[pos] = getRandomChar(upperCaseLetters, lowerCaseLetters, numbers);
        }

        return String.valueOf(password);

    }

    private int getRandomInt(int deb, int fin){
        Random rand = new Random();
        return rand.nextInt(fin-deb) + deb;
    }

    private char getRandomChar(String... strings){
        String str;
        if(strings.length == 0){
            str = strings[0];
        }
        else{
            str = strings[getRandomInt(0, strings.length)];
        }
        return str.charAt(getRandomInt(0, str.length()));
    }

    public List<Tache> tachesProposees() {
        List<Tache> listTachesProposees = new ArrayList<Tache>();
        listTaches = listTaches();
        if (listTaches.isEmpty())
            return listTachesProposees;

        if(listTaches.size() == 1){
            listTachesProposees.add(listTaches.get(0));
            return listTachesProposees;
        }
        int pos_tache_1;
        int pos_tache_2;

        setPrioriteTache(listTaches.get(0));
        setPrioriteTache(listTaches.get(1));

        if(listTaches.get(0).priorite > listTaches.get(1).priorite){
            pos_tache_1 = 0;
            pos_tache_2 = 1;
        }
        else{
            pos_tache_1 = 1;
            pos_tache_2 = 0;
        }

        if(listTaches.size() == 2){
            listTachesProposees.add(listTaches.get(pos_tache_1));
            listTachesProposees.add(listTaches.get(pos_tache_2));
            return listTachesProposees;
        }

        int pos_tache_3;
        setPrioriteTache(listTaches.get(2));
        if(listTaches.get(2).priorite > listTaches.get(pos_tache_1).priorite){
            pos_tache_3 = pos_tache_2;
            pos_tache_2 = pos_tache_1;
            pos_tache_1 = 2;
        } else if(listTaches.get(2).priorite > listTaches.get(pos_tache_2).priorite){
            pos_tache_3 = pos_tache_2;
            pos_tache_2 = 2;
        } else{
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

    private void setPrioriteTache(Tache t){
        try{
            t.priorite = COEFFICIENT_CRITERE_1*critere1(t)
                    + COEFFICIENT_CRITERE_2*critere2(t)
                    + COEFFICIENT_CRITERE_3*critere3(t)
                    + COEFFICIENT_CRITERE_4*critere4(t);
        }
        catch(Exception e){
            t.priorite = 0;
            Logger.warn("Priorite de la tache [" + t.nom + "] = 0 car : "+ e.getMessage());
        }
    }

    private int critere1(Tache t){
        if(t.critique)
            return 5;
        return 1;
    }

    private int critere2(Tache t){
        Calendar cal = Calendar.getInstance();
        Calendar today = new GregorianCalendar(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH)+1, cal.get(Calendar.DATE));
        long nbJoursRestants = differenceNbJours(today.getTime(), t.dateFinTard);

        if(nbJoursRestants >= 51){
            return 1;
        }
        else if(26 <= nbJoursRestants && nbJoursRestants <= 50){
            return 2;
        }
        else if(11 <= nbJoursRestants && nbJoursRestants <= 25){
            return 3;
        }
        else if(6 <= nbJoursRestants && nbJoursRestants <= 10){
            return 4;
        }
        else{
            if(nbJoursRestants < 0){
                nbJoursRestants = 0;
            }
            return 10 - (int) nbJoursRestants;
        }
    }

    private int critere3(Tache t) throws Exception{
        if(t.projet.unite == UniteProjetEnum.JOUR){
            return critere3Jour(t);
        }
        else if(t.projet.unite == UniteProjetEnum.SEMAINE){
            return critere3Semaine(t);
        }
        else{
            // PB
            throw new Exception("Pas d'unité pour le projet ["+ t.projet.nom +"] concernant la tache ["+ t.nom +"]");
        }
    }

    private int critere3Jour(Tache t){
        double chargeRestante =  t.chargeRestante;
        if(chargeRestante >= 51){
            return 1;
        }
        else if(26 <= chargeRestante && chargeRestante <= 50){
            return 2;
        }
        else if(11 <= chargeRestante && chargeRestante <= 25){
            return 3;
        }
        else if(6 <= chargeRestante && chargeRestante <= 10){
            return 4;
        }
        else{
            return 5;
        }
    }

    private int critere3Semaine(Tache t){
        double chargeRestante =  t.chargeRestante;

        if(chargeRestante >= 7){
            return 1;
        }
        else if(4 <= chargeRestante && chargeRestante <= 6){
            return 2;
        }
        else if(chargeRestante == 3){
            return 3;
        }
        else if(chargeRestante == 2){
            return 4;
        }
        else{
            return 5;
        }
    }

    private int critere4(Tache t){
        return 7 - (t.projet.priorite + t.projet.client.priorite);
    }

    /** TODO TESTME **/
    public int nbDeProjetsResponsableActuel(){
        int cpt = 0;
        for(Projet projet : listProjetsResponsable()){
            if(projet.enCours)  cpt++;
        }
        return cpt;
    }

    /**TODO TESTME
     * TODO voir byte vs double
     * @return
     */
    public int nbDeProjetsResponsablePresqueFinis(){
        int cpt = 0;
        for(Projet projet : listProjetsResponsable()){
            if(projet.enCours && projet.avancementGlobal >= LIMITE_PROJET_PRESQUE_FINI && projet.avancementGlobal < 100)  cpt++;
        }
        return cpt;
    }

    /**TODO TESTME
     * TODO : Remplacer dateFinReel par dateFinReelTard
     * @return
     */
    public int nbDeProjetsResponsableRetardes(){
        int cpt = 0;
        for(Projet projet : listProjetsResponsable()){
            if(projet.enCours && projet.dateFinReelTard.before(Calendar.getInstance().getTime())) cpt++;
        }
        return cpt;
    }

    /**
     * TODO TEST ME
     * @return
     */
    public int nbTachesActuelles(){
        int cpt = 0;
        for(Tache tache : listTaches()){
            if(!tache.archive && tache.estDisponible() && tache.getAvancementTache() < 100.0) cpt++;
        }
        return cpt;
    }

    /**
     * TODO TEST ME
     * @return
     */
    public int nbTachesNonCommencees(){
        int cpt = 0;
        for(Tache tache : listTaches()){
            if(!tache.archive && tache.estDisponible() && tache.getAvancementTache() == 0.0) cpt++;
        }
        return cpt;
    }

    /**
     * TODO TEST ME
     * @return
     */
    public int nbTachesCommencees(){
        int cpt = 0;
        for(Tache tache : listTaches()){
            if(!tache.archive && tache.estDisponible() && tache.getAvancementTache() > 0.0 && tache.getAvancementTache() < 100.0) cpt++;
        }
        return cpt;
    }

    /**
     * TODO TEST ME
     * @return
     */
    public int nbTachesPresquesFinies(){
        int cpt = 0;
        for(Tache tache : listTaches()){
            if(!tache.archive && tache.estDisponible() && tache.getAvancementTache() >= LIMITE_TACHE_PRESQUE_FINI && tache.getAvancementTache() < 100.0) cpt++;
        }
        return cpt;
    }

    /**
     * TODO TEST ME
     * @return
     */
    public int nbTachesRetardees(){
        int cpt = 0;
        for(Tache tache : listTaches()){
            if(!tache.archive && tache.estDisponible() && tache.dateFinTard.before(Calendar.getInstance().getTime())) cpt++;
        }
        return cpt;
    }

    /** TODO TEST ME **/
    public boolean hasProjetsResponsable(){
        return !listProjetsResponsable().isEmpty();
    }

    /**
     * TODO TEST ME
     * @return
     */
    public List<Tache> tachesPresquesFinies(){
        List<Tache> res = new ArrayList<>();
        for(Tache tache : listTaches()){
            if(!tache.archive && tache.estDisponible() && tache.getAvancementTache() >= LIMITE_TACHE_PRESQUE_FINI && tache.getAvancementTache() < 100.0) res.add(tache);
        }
        return res;
    }

    /**
     * TODO TEST ME
     * @return
     */
    public List<Tache> tachesRetardees(){
        List<Tache> res = new ArrayList<>();
        for(Tache tache : listTaches()){
            if(!tache.archive && tache.estDisponible() && tache.dateFinTard.before(Calendar.getInstance().getTime())) res.add(tache);
        }
        return res;
    }

    /**
     * Calcule le nombre de jours entre date1 et date2 : date2-date1
     * @param date1
     * @param date2
     * @return
     */
    private static long differenceNbJours(Date date1, Date date2) {
        return ((date2.getTime() - date1.getTime()) / 86400000);
    }

    public static List<Utilisateur> getAllArchives(){
        return find.where().eq("archive",true).findList();
    }

    public static List<Utilisateur> getAllNonArchives(){
        //Logger.debug(find.where().eq("archive",false).findList().toString());
        return find.where().eq("archive",false).findList();
    }

    public void suivreUnUtilisateur(Utilisateur user){
        if(!utilisateursSuivis.contains(user)){
            utilisateursSuivis.add(user);
            save();
        }
        if(!user.utilisateursMeSuivant.contains(this)){
            user.utilisateursMeSuivant.add(this);
            user.save();
        }
    }

    public void activerNotification(Tache tache){
        // TODO : Rajouter un test de permission?
        if(!listTachesNotifications.contains(tache)){
            listTachesNotifications.add(tache);
            save();
        }
        if(!tache.utilisateursNotifications.contains(this)){
            tache.utilisateursNotifications.add(this);
            tache.save();
        }
    }

    public void desactiverNotification(Tache tache){
        // TODO : Rajouter un test de permission?
        if(!listTachesNotifications.contains(tache)){
            listTachesNotifications.remove(tache);
            save();
        }
        if(!tache.utilisateursNotifications.contains(this)){
            tache.utilisateursNotifications.remove(this);
            tache.save();
        }
    }
}
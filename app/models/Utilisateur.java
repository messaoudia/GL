package models;

import com.avaje.ebean.common.BeanList;
import play.Logger;
import play.data.validation.Constraints;

import javax.persistence.*;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;
import java.util.Random;

@Entity
@Table
public class Utilisateur extends Personne {

    @Constraints.Required
    protected String password;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable
    public List<Notification> listNotifications;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "Tache")
    private List<Tache> listTaches;

    //TODO Make connection to the database to check the authentication
    public String validate() {
        if (!email.equals("yasser.rabi@gmail.com") || !password.equals("123456")) {
            return "Invalid email or password";
        }
        return null;
    }

    public static Finder<Long, Utilisateur> find = new Finder<>(Utilisateur.class);

    public Utilisateur(String nom, String prenom, String email, String telephone, String password,List<Tache> listTaches) {
        super(nom, prenom, email, telephone);
        setPassword(password);
        this.listTaches = (listTaches == null)?new BeanList<>():listTaches;
    }

    public Utilisateur(String nom, String prenom, String email, String telephone, String password) {
        this(nom, prenom, email, telephone,password,null);
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

    public void setPassword(String password) {
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
     * FIXME rustine car le champ ne contient pas la liste des taches
     * @return list des projets du responsable
     */
    public List<Projet> listProjetsResponsable(){
        return Projet.find.where().eq("responsableProjet",this).findList();
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

    public List<Tache> getListTaches(){
        return Tache.find.where().eq("responsableTache",this).findList();
    }

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


}
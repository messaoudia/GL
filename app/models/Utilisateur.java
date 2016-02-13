package models;

import com.avaje.ebean.common.BeanList;
import play.Logger;
import play.data.validation.Constraints;

import javax.persistence.*;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Formatter;
import java.util.List;

@Entity
@Table
public class Utilisateur extends Personne {

    @Constraints.Required
    protected String password;

    
    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable
    public List<Notification> listNotifications;

    @OneToMany(cascade = CascadeType.ALL)
    public List<Tache> listTaches;

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
        this.save();
        this.password = hachage(this.id,password);
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

    public List<Projet> listProjetsResponsable(){
        return Projet.find.where().eq("responsableProjet",this).findList();
    }

    /**
     * TODO testme
     * Affecte la tache en parametre a l'utilisateur courant
     * @param tache
     */
    @Transient
    public void affectTache(Tache tache){
        if(listTaches.contains(tache)){
            throw new IllegalArgumentException("L'utilisateur "+nom+", possede deja la tache "+ tache.nom);
        }
        tache.responsableTache = this;
        tache.save();
        listTaches.add(tache);
        save();
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
}
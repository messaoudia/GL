package models;

import play.data.validation.Constraints;

import javax.persistence.*;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Formatter;
import java.util.List;

@Entity
@Table(name = "User")
public class User extends Personne{

    @Constraints.Required
    protected String password;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name="Notification", joinColumns={@JoinColumn(name="id")})
    public List<Notification> listNotifications;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name="Task", joinColumns={@JoinColumn(name="id")})
    public List<Task> listTasks;

    //TODO Make connection to the database to check the authentication
    public String validate() {
        if (!email.equals("yasser.rabi@gmail.com") || !password.equals("123456")) {
            return "Invalid email or password";
        }
        return null;
    }

    public static Finder<Long, User> find = new Finder<>(User.class);

    public User(String nom, String prenom, String email, String telephone, String password) {
        super(nom, prenom, email, telephone);
        this.save();
        this.password = hachage(this.id,password);
    }

    public User() {
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setPassword(String password) {
        this.password = password;
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
            User user = (User) obj;
            return user.password.equals(this.password) && super.equals(user);
        } catch (ClassCastException e) {
            return false;
        }
    }

    @Override
    public String toString() {
        return super.toString() +", Password :" + password + ")";
    }

    public void affectTask(Task task){
        if(listTasks.contains(task)){
            throw new IllegalArgumentException("L'utilisateur "+nom+", possede deja la tache "+task.nom);
        }
        listTasks.add(task);
    }

    /**
     * TODO testme
     * Verifie si le mot de passe saisi correspond bien au mot de passe de l'utilisateur
     * @param passwordAttempt
     * @return
     */
    public boolean checkPassword(String passwordAttempt){
        return hachage(this.id,passwordAttempt).equals(this.password);
    }

    /**
     * TODO testme
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
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return sha1;
    }

    /**
     * TODO testme
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
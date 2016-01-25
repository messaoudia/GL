package models;

import com.avaje.ebean.Model;
import play.data.validation.Constraints;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Gishan on 04/01/2016.
 */
@Entity
@Table(name="Personne")
public class Personne extends Model{
    @Id
    @GeneratedValue
    public Long id;
    public String nom;
    public String prenom;

    @Constraints.Email
    public String mail;
    public String telephone;

    public static Model.Finder<Long, Personne> find = new Model.Finder<Long, Personne>(Personne.class);

    public Personne(String nom, String prenom, String mail, String telephone) {
        this.nom = nom;
        this.prenom = prenom;
        this.mail = mail;
        this.telephone = telephone;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
}

package models;

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
public class Personne {
    @Id
    @GeneratedValue
    public Long id;
    public String nom;
    public String prenom;

    @Constraints.Email
    public String mail;
    public String telephone;
}

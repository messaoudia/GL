package models;

import com.avaje.ebean.Model;
import org.apache.commons.lang3.builder.ToStringBuilder;
import play.data.validation.Constraints;

import javax.persistence.*;

/**
 * Created by Gishan on 04/01/2016.
 */
@MappedSuperclass
public abstract class Personne extends Model{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public String nom;
    public String prenom;

    @Constraints.Email
    @Constraints.Required
    public String email;

    @Constraints.Pattern("\\+(9[976]\\d|8[987530]\\d|6[987]\\d|5[90]\\d|42\\d|3[875]\\d|\n" +
            "2[98654321]\\d|9[8543210]|8[6421]|6[6543210]|5[87654321]|\n" +
            "4[987654310]|3[9643210]|2[70]|7|1)\\d{1,14}$")
    //International format
    public String telephone;

    public boolean archive;

    public Personne(String nom, String prenom, String email, String telephone,boolean archive) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.telephone = telephone;
        this.archive = archive;
    }

    public Personne() {
    }

    @Override
    public String toString() {
        return  id + "] : " +
                nom + ", " + prenom + ", " +
                email + ", " + telephone+", archive : "+archive;
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
            Personne personne = (Personne) obj;
            return (personne.nom.equals(this.nom) && personne.prenom.equals(this.prenom)
                    && personne.email.equals(this.email) && personne.telephone.equals(this.telephone) && personne.archive == this.archive);
        } catch (ClassCastException e) {
            return false;
        }
    }
}

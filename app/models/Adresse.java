package models;

import com.avaje.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;

/**
 * Created by Guillaume on 25/01/2016.
 */
@Entity
@Table(name = "Adresse")
public class Adresse extends Model {

    @Id
    @GeneratedValue
    public Long id;
    public String adresse;
    public String zipCode;
    public String ville;
    public String pays;

    public static Model.Finder<Long, Adresse> find = new Model.Finder<Long, Adresse>(Adresse.class);

    public Adresse(){}

    public Adresse(String adresse, String zipCode, String ville, String pays) {
        this.adresse = adresse;
        this.zipCode = zipCode;
        this.ville = ville;
        this.pays = pays;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[Adresse : ");
        sb.append(id);
        sb.append("] : ");
        sb.append(adresse);
        sb.append(", ");
        sb.append(zipCode);
        sb.append(", ");
        sb.append(ville);
        sb.append(", ");
        sb.append(pays);
        return sb.toString();
    }

    public static List all() {
        return find.all();
    }

    public static void create(Task task) {
        task.save();
    }

    public static void delete(Long id) {
        find.ref(id).delete();
    }
}

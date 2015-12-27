package models;

import com.avaje.ebean.Model;
import play.data.format.Formats;
import play.data.validation.Constraints;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Taches")
public class Tache extends Model {

    @Id
    @GeneratedValue
    public Long id;

    @Constraints.Required
    public String nom;

    @Constraints.Required
    @Constraints.MinLength(4)
    public String description;

    @Constraints.Min(0)
    public Integer niveau;

    @Formats.DateTime(pattern = "dd/MM/yyyy HH:mm")
    public Date dateDebut = new Date();

    @Formats.DateTime(pattern = "dd/MM/yyyy HH:mm")
    public Date dateFinTot = new Date();

    @Formats.DateTime(pattern = "dd/MM/yyyy HH:mm")
    public Date dateFinTard = new Date();

    @Constraints.Min(0)
    public Integer charge;

    public static Finder<Long, Tache> find = new Finder<Long, Tache>(Tache.class);

    /**
     * Create a task
     */
    public static Tache create(Tache task) {
        task.save();
        return task;
    }

    /**
     * Create a task
     */
    public static List<Tache> getAll() {
        return find.all();
    }

}
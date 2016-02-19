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
public class Task extends Model {

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

    public static Finder<Long, Task> find = new Finder<Long, Task>(Task.class);

    /**
     * Create a task
     */
    public static Task create(Task task) {
        task.save();
        return task;
    }

    /**
     * Create a task
     */
    public static List<Task> getAll() {
        return find.all();
    }

}
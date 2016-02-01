package models;

import com.avaje.ebean.Model;
import play.data.format.Formats;
import play.data.validation.Constraints;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Tache")
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
    @Constraints.Max(3)
    public Integer niveau;
    public Boolean critique;
    @Formats.DateTime(pattern = "dd/MM/yyyy HH:mm")
    public LocalDate dateDebut;
    @Formats.DateTime(pattern = "dd/MM/yyyy HH:mm")
    public LocalDate dateFinTot;
    @Formats.DateTime(pattern = "dd/MM/yyyy HH:mm")
    public LocalDate dateFinTard;
    @Constraints.Min(0)
    public Integer chargeInitiale;
    @Constraints.Min(0)
    public Integer chargeConsommee;
    @Constraints.Min(0)
    public Integer chargeTotale;
    public Boolean disponible;
    public List<Personne> interlocuteurs;

    public static Finder<Long, Task> find = new Finder<>(Task.class);

    public Task(String nom, String description, Integer niveau, Boolean critique, LocalDate dateDebut,
                LocalDate dateFinTot, LocalDate dateFinTard, Integer chargeInitiale, Integer chargeConsommee,
                Integer chargeTotale, Boolean disponible,List<Personne> interlocuteurs) {
        this.nom = nom;
        this.description = description;
        this.niveau = niveau;
        this.critique = critique;
        this.dateDebut = dateDebut;
        this.dateFinTot = dateFinTot;
        this.dateFinTard = dateFinTard;
        this.chargeInitiale = chargeInitiale;
        this.chargeConsommee = chargeConsommee;
        this.chargeTotale = chargeTotale;
        this.disponible = disponible;
		this.interlocuteurs = interlocuteurs;
    }

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
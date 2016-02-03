package models;

import com.avaje.ebean.Model;
import models.Exceptions.IllegalTaskCreation;
import models.Exceptions.NotAvailableTask;
import play.data.format.Formats;
import play.data.validation.Constraints;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Entity
@Table(name = "Tache")
public class Task extends Model {

    @Id
    @GeneratedValue
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(referencedColumnName = "id")
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

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "listTachesCorrespondant")
    public List<Contact> interlocuteurs;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="projet_id")
    public Projet projet;

    @ManyToOne
    public Task predecesseur;
    @OneToMany(mappedBy="predecesseur")
    public List<Task> successeurs;

    @ManyToOne
    public Task parent;

    @OneToMany(mappedBy="parent")
    public List<Task> enfants;

    public static Finder<Long, Task> find = new Finder<>(Task.class);

    public Task(String nom, String description, Integer niveau, Boolean critique, LocalDate dateDebut,
                LocalDate dateFinTot, LocalDate dateFinTard, Integer chargeInitiale, Integer chargeConsommee,
                Integer chargeTotale, Boolean disponible,List<Contact> interlocuteurs, Projet projet) {
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
        this.projet = projet;
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

    @Override
    public String toString() {
        return  "[Tâche : " + id + "] : " + nom + ", " + description +
                "\nniveau : " + niveau + "\ncritique : " + critique +
                "\ndateDebut : " + dateDebut + "\ndateFinTot : " + dateFinTot +
                "\ndateFinTard : " + dateFinTard + "\nchargeInitiale : " + chargeInitiale +
                "\nchargeConsommee : " + chargeConsommee + "\nchargeTotale : " + chargeTotale +
                "\ndisponible : " + disponible + "\ninterlocuteurs : " + interlocuteurs +
                "\nprojet : " + projet.nom + "\n";
    }


    /**
     * Modifie la charge de la tâche actuelle avec les charges en parametre
     * @param chargeConsommee
     * @param chargeTotale
     * @throws NotAvailableTask
     */
    public void modifierCharge(Integer chargeConsommee, Integer chargeTotale)throws NotAvailableTask {
        if (!disponible){
            throw new NotAvailableTask("Tache "+this+", pas encore disponible, modification de charge impossible");
        }
        this.chargeConsommee = chargeConsommee;
        this.chargeTotale = chargeTotale;
        updateAvancementTache();
    }

    /**
     * Mets a jour l'avancement de la tâche éventuellement composée de sous-tâches
     */
    private void updateAvancementTache() {
        //TODO set avancement en fonction des tâches filles (récursivement)
    }

    /**
     * Cree une sous-tâche a cette tâche
     * @param tache
     * @throws IllegalTaskCreation
     */
    public void creerTacheFille(Task tache) throws IllegalTaskCreation {
        if(niveau == 3){
            throw new IllegalTaskCreation("Creation de tache de niveau superieur a 3 impossible");
        }
        enfants.add(tache);
    }

}
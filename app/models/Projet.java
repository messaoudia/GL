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

/**
 * Created by Guillaume on 25/01/2016.
 */
@Entity
@Table(name = "Projet")
public class Projet extends Model {

    @Id
    @GeneratedValue
    public Long id;
    public String nom;
    public String description;
    @Formats.DateTime(pattern = "dd/MM/yyyy HH:mm")
    public LocalDate dateDebutTheorique;
    @Formats.DateTime(pattern = "dd/MM/yyyy HH:mm")
    public LocalDate dateFinTheorique;
    @Formats.DateTime(pattern = "dd/MM/yyyy HH:mm")
    public LocalDate dateDebutReel;
    @Formats.DateTime(pattern = "dd/MM/yyyy HH:mm")
    public LocalDate dateFinReel;
    public Integer chargeInitiale;
    public Byte avancementGlobal;
    public Boolean enCours;
    public Boolean archive;
    public Client client;
    @Constraints.Min(1)
    @Constraints.Max(3)
    public Integer priorite;
    public List<Task> listTasks;
    public UniteProjetEnum unite;

    public static Model.Finder<Long, Projet> find = new Model.Finder<>(Projet.class);

    public Projet(String nom, String description, LocalDate dateDebutTheorique, LocalDate dateFinTheorique,
                  LocalDate dateDebutReel, LocalDate dateFinReel, Integer chargeInitiale, UniteProjetEnum unite,
                  Byte avancementGlobal, Boolean enCours, Boolean archive, Client client, Integer priorite, List<Task> listTasks) {
        this.nom = nom;
        this.description = description;
        this.dateDebutTheorique = dateDebutTheorique;
        this.dateFinTheorique = dateFinTheorique;
        this.dateDebutReel = dateDebutReel;
        this.dateFinReel = dateFinReel;
        this.chargeInitiale = chargeInitiale;
        this.unite = unite;
        this.avancementGlobal = avancementGlobal;
        this.enCours = enCours;
        this.archive = archive;
        this.client = client;
        this.priorite = priorite;
        this.listTasks = listTasks;
    }

    public Projet() {
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[Projet : ");
        sb.append(id);
        sb.append("] : ");
        sb.append(nom);
        sb.append(", ");
        sb.append(description);
        sb.append("\nDebutTH : ");
        sb.append(dateDebutTheorique);
        sb.append(", FinTH : ");
        sb.append(dateFinTheorique);
        sb.append(", FinTH : ");
        sb.append(dateDebutReel);
        sb.append(", FinRE : ");
        sb.append(dateFinReel);
        sb.append("\nChargeInitiale : ");
        sb.append(chargeInitiale);
        sb.append(", Avancement (%) : ");
        sb.append(avancementGlobal);
        sb.append(", En cours : ");
        sb.append(enCours);
        sb.append(", archive : ");
        sb.append(archive);
        sb.append(", Priorite :");
        sb.append(priorite);
        sb.append("\n");
        if(client != null){
            sb.append(client);
        }
        if(listTasks != null) {
            for (Task task : listTasks) {
                sb.append("\n");
                sb.append(task);
                sb.append("\n");
            }
        }
        return sb.toString();
    }
}

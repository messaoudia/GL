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
    public Date dateDebutTheorique;
    @Formats.DateTime(pattern = "dd/MM/yyyy HH:mm")
    public Date dateFinTheorique;
    @Formats.DateTime(pattern = "dd/MM/yyyy HH:mm")
    public Date dateDebutReel;
    @Formats.DateTime(pattern = "dd/MM/yyyy HH:mm")
    public Date dateFinReel;
    public Integer chargeInitiale;
    public Byte avancementGlobal;
    public Boolean enCours;
    public Boolean archive;
    public Client client;
    @Constraints.Min(1)
    @Constraints.Max(3)
    public Integer priorite;
    public List<Task> listTasks;

    public static Model.Finder<Long, Projet> find = new Model.Finder<Long, Projet>(Projet.class);

    public Projet(String nom, String description, Date dateDebutTheorique, Date dateFinTheorique, Date dateDebutReel, Date dateFinReel, Integer chargeInitiale, Byte avancementGlobal, Boolean enCours, Boolean archive, Client client, Integer priorite, List<Task> listTasks) {
        this.nom = nom;
        this.description = description;
        this.dateDebutTheorique = dateDebutTheorique;
        this.dateFinTheorique = dateFinTheorique;
        this.dateDebutReel = dateDebutReel;
        this.dateFinReel = dateFinReel;
        this.chargeInitiale = chargeInitiale;
        this.avancementGlobal = avancementGlobal;
        this.enCours = enCours;
        this.archive = archive;
        this.client = client;
        this.priorite = priorite;
        this.listTasks = listTasks;
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
        sb.append("\nDebutTH :");
        sb.append(dateDebutTheorique);
        sb.append("\nFinTH :");
        sb.append(dateFinTheorique);
        sb.append("\nFinTH :");
        sb.append(dateDebutReel);
        sb.append("\nFinRE :");
        sb.append(dateFinReel);
        sb.append("\nChargeInitiale :");
        sb.append(chargeInitiale);
        sb.append("\nAvancement (%) :");
        sb.append(avancementGlobal);
        sb.append("\nEn cours :");
        sb.append(enCours);
        sb.append("\narchive :");
        sb.append(archive);
        sb.append("\nPriorite :");
        sb.append(enCours);
        sb.append("\n");
        sb.append(client);
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

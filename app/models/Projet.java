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
    public Date dateDebut;
    @Formats.DateTime(pattern = "dd/MM/yyyy HH:mm")
    public Date dateFin;
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

    public Projet(String nom, String description, Date dateDebut, Date dateFin, Integer chargeInitiale, Byte avancementGlobal, Boolean enCours, Boolean archive, Client client, Integer priorite, List<Task> listTasks) {
        this.nom = nom;
        this.description = description;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.chargeInitiale = chargeInitiale;
        this.avancementGlobal = avancementGlobal;
        this.enCours = enCours;
        this.archive = archive;
        this.client = client;
        this.priorite = priorite;
        this.listTasks = listTasks;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public Integer getChargeInitiale() {
        return chargeInitiale;
    }

    public void setChargeInitiale(Integer chargeInitiale) {
        this.chargeInitiale = chargeInitiale;
    }

    public Byte getAvancementGlobal() {
        return avancementGlobal;
    }

    public void setAvancementGlobal(Byte avancementGlobal) {
        this.avancementGlobal = avancementGlobal;
    }

    public Boolean getEnCours() {
        return enCours;
    }

    public void setEnCours(Boolean enCours) {
        this.enCours = enCours;
    }

    public Boolean getArchive() {
        return archive;
    }

    public void setArchive(Boolean archive) {
        this.archive = archive;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Integer getPriorite() {
        return priorite;
    }

    public void setPriorite(Integer priorite) {
        this.priorite = priorite;
    }

    public List<Task> getListTasks() {
        return listTasks;
    }

    public void setListTasks(List<Task> listTasks) {
        this.listTasks = listTasks;
    }
}

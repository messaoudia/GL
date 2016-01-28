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
    public Date dateDebut = new Date();
    @Formats.DateTime(pattern = "dd/MM/yyyy HH:mm")
    public Date dateFinTot = new Date();
    @Formats.DateTime(pattern = "dd/MM/yyyy HH:mm")
    public Date dateFinTard = new Date();
    @Constraints.Min(0)
    public Integer chargeInitiale;
    @Constraints.Min(0)
    public Integer chargeConsommee;
    @Constraints.Min(0)
    public Integer chargeTotale;
    public Boolean disponible;
	
	
    public List<Personne> interlocuteurs;

    public static Finder<Long, Task> find = new Finder<Long, Task>(Task.class);

    public Task(String nom, String description, Integer niveau, Boolean critique, Date dateDebut, Date dateFinTot, Date dateFinTard, Integer chargeInitiale, Integer chargeConsommee, Integer chargeTotale, Boolean disponible,List<Personne> interlocuteurs) {
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

    public Integer getNiveau() {
        return niveau;
    }

    public void setNiveau(Integer niveau) {
        this.niveau = niveau;
    }

    public Boolean getCritique() {
        return critique;
    }

    public void setCritique(Boolean critique) {
        this.critique = critique;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFinTot() {
        return dateFinTot;
    }

    public void setDateFinTot(Date dateFinTot) {
        this.dateFinTot = dateFinTot;
    }

    public Date getDateFinTard() {
        return dateFinTard;
    }

    public void setDateFinTard(Date dateFinTard) {
        this.dateFinTard = dateFinTard;
    }

    public Integer getChargeInitiale() {
        return chargeInitiale;
    }

    public void setChargeInitiale(Integer chargeInitiale) {
        this.chargeInitiale = chargeInitiale;
    }

    public Integer getChargeConsommee() {
        return chargeConsommee;
    }

    public void setChargeConsommee(Integer chargeConsommee) {
        this.chargeConsommee = chargeConsommee;
    }

    public Integer getChargeTotale() {
        return chargeTotale;
    }

    public void setChargeTotale(Integer chargeTotale) {
        this.chargeTotale = chargeTotale;
    }

    public Boolean getDisponible() {
        return disponible;
    }

    public void setDisponible(Boolean disponible) {
        this.disponible = disponible;
    }
	
	public List<Personne> getInterlocuteurs() {
        return interlocuteurs;
    }

    public void setInterlocuteurs(List<Personne> interlocuteurs) {
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
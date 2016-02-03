package models;

import com.avaje.ebean.Model;
import play.data.format.Formats;
import play.data.validation.Constraints;

import javax.persistence.*;
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
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(referencedColumnName = "id")
    public Long id;
    public String nom;
    public String description;
    public User responsable;
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

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="client_id")
    public Client client;

    @Constraints.Min(1)
    @Constraints.Max(3)
    public Integer priorite;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name="Tache", joinColumns={@JoinColumn(name="id")})
    public List<Task> listTasks;

    public UniteProjetEnum unite;

    public static Model.Finder<Long, Projet> find = new Model.Finder<>(Projet.class);

    public Projet(String nom, String description, User responsable, LocalDate dateDebutTheorique, LocalDate dateFinTheorique,
                  LocalDate dateDebutReel, LocalDate dateFinReel, Integer chargeInitiale, UniteProjetEnum unite,
                  Byte avancementGlobal, Boolean enCours, Boolean archive, Client client, Integer priorite, List<Task> listTasks) {
        this.nom = nom;
        this.description = description;
        this.responsable = responsable;
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
        sb.append("[Projet : ").append(id).append("] : ").append(nom).append(", ").append(description);
        sb.append("\nDebutTH : ").append(dateDebutTheorique).append(", FinTH : ").append(dateFinTheorique);
        sb.append(", DebutRE : ").append(dateDebutReel).append(", FinRE : ").append(dateFinReel);
        sb.append("\nChargeInitiale : ").append(chargeInitiale).append(", Avancement (%) : ").append(avancementGlobal);
        sb.append(", En cours : ").append(enCours).append(", archive : ").append(archive);
        sb.append(", Priorite :").append(priorite).append("\n");
        if(client != null){
            sb.append(client);
        }
        if(listTasks != null) {
            for (Task task : listTasks) {
                sb.append("\n").append(task).append("\n");
            }
        }
        return sb.toString();
    }

    /**
     * Ajouter la tache en parametre a la liste des taches du projet
     * @param tache
     */
    public void ajouterTache(Task tache){
        if(listTasks.contains(tache)){
            throw new IllegalArgumentException("Le projet "+this.nom+", contient deja la tache "+tache.nom+
                    ", creation impossible");
        }
        listTasks.add(tache);
    }


    public void modifierTache(Task tache){
        if(!listTasks.contains(tache)){
            throw new IllegalArgumentException("Le projet "+this.nom+", ne contient pas la tache "+tache.nom+
                    ", modification impossible");
        }

        //TODO modifier tâche
    }

    /**
     * Supprimer la tâche du systeme
     * @param tache
     * @throws IllegalArgumentException
     */
    public void supprimerTache(Task tache) throws IllegalArgumentException{
        if(!listTasks.contains(tache)){
            throw new IllegalArgumentException("Le projet "+this.nom+", ne contient pas la tache "+tache.nom+
                    ", suppression impossible");
        }
        listTasks.remove(tache);
    }

    /**
     * Affecte l'utilisateur en parametre en tant que responsable du projet
     * @param responsable
     * @throws IllegalStateException
     */
    public void associerResponsable(User responsable) throws IllegalStateException{
        if(this.responsable != null){
            throw new IllegalStateException("Il y a deja un responsable pour ce projet");
        }
        this.responsable = responsable;
    }

    /**
     * Modifie le responsable de projet par l'utilisateur en parametre
     * @param responsable
     * @throws IllegalArgumentException
     */
    public void modifierResponsable(User responsable) throws IllegalArgumentException{
        if(this.responsable == responsable){
            throw new IllegalArgumentException("Remplacement du responsable de projet par le même responsable");
        }
        this.responsable = responsable;
    }

    /**
     * Associe le projet courant au client passé en parametre
     * @param client
     * @throws IllegalStateException
     */
    public void associerClient(Client client) throws IllegalStateException{
        if(this.client != null){
            throw new IllegalStateException("Il y a deja un client pour ce projet");
        }
        this.client = client;
    }
}

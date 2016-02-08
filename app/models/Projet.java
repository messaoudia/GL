package models;

import com.avaje.ebean.Model;
import models.Securite.EntiteSecurise;
import org.apache.commons.lang3.builder.ToStringBuilder;
import play.data.format.Formats;
import play.data.validation.Constraints;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by Guillaume on 25/01/2016.
 */
@Entity
@Table
@DiscriminatorValue("PROJET")
public class Projet extends EntiteSecurise {

    public String nom;
    public String description;
    public Utilisateur responsable;
    @Formats.DateTime(pattern = "dd/MM/yyyy")
    public Date dateDebutTheorique;
    @Formats.DateTime(pattern = "dd/MM/yyyy")
    public Date dateFinTheorique;
    @Formats.DateTime(pattern = "dd/MM/yyyy")
    public Date dateDebutReel;
    @Formats.DateTime(pattern = "dd/MM/yyyy")
    public Date dateFinReel;
    public Integer chargeInitiale;
    public Byte avancementGlobal;
    public Boolean enCours;
    public Boolean archive;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    public Client client;

    @Constraints.Min(1)
    @Constraints.Max(3)
    public Integer priorite;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "Tache")
    public List<Tache> listTaches;

    public UniteProjetEnum unite;

    public static Model.Finder<Long, Projet> find = new Model.Finder<>(Projet.class);

    public Projet(String nom, String description, Utilisateur responsable, Date dateDebutTheorique, Date dateFinTheorique,
                  Date dateDebutReel, Date dateFinReel, Integer chargeInitiale, UniteProjetEnum unite,
                  Byte avancementGlobal, Boolean enCours, Boolean archive, Client client, Integer priorite, List<Tache> listTaches) {
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
        this.listTaches = listTaches;
    }

    public Projet() {
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        try {
            Projet projet = (Projet) obj;
            return (projet.id.equals(this.id) && projet.nom.equals(this.nom) &&
                    projet.description.equals(this.description) &&
                    projet.dateDebutTheorique.equals(this.dateDebutTheorique) &&
                    projet.dateFinTheorique.equals(this.dateFinTheorique) &&
                    projet.dateDebutReel.equals(this.dateDebutReel) &&
                    projet.dateFinTheorique.equals(this.dateFinTheorique) &&
                    projet.chargeInitiale.equals(this.chargeInitiale) &&
                    projet.avancementGlobal.equals(this.avancementGlobal) &&
                    projet.enCours.equals(this.enCours) &&
                    projet.archive.equals(this.archive) &&
                    projet.priorite.equals(this.priorite) &&
                    projet.client.id.equals(this.client.id));
        } catch (ClassCastException e) {
            return false;
        }
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    /**
     * TODO testme
     * Ajouter la tache en parametre a la liste des taches du projet
     *
     * @param tache
     */
    public void ajouterTache(Tache tache) throws IllegalArgumentException {
        if (listTaches.contains(tache)) {
            throw new IllegalArgumentException("Le projet " + this.nom + ", contient deja la tache " + tache.nom +
                    ", creation impossible");
        }
        listTaches.add(tache);
    }


    /**
     * TODO testme
     * Modifie la tache en parametre
     *
     * @param tache
     * @throws IllegalArgumentException
     */
    public void modifierTache(Tache tache) throws IllegalArgumentException {
        if (!listTaches.contains(tache)) {
            throw new IllegalArgumentException("Le projet " + this.nom + ", ne contient pas la tache " + tache.nom +
                    ", modification impossible");
        }

        //TODO modifier tâche
    }

    /**
     * TODO testme
     * Supprimer la tâche du systeme
     *
     * @param tache
     * @throws IllegalArgumentException
     */
    public void supprimerTache(Tache tache) throws IllegalArgumentException {
        if (!listTaches.contains(tache)) {
            throw new IllegalArgumentException("Le projet " + this.nom + ", ne contient pas la tache " + tache.nom +
                    ", suppression impossible");
        }
        listTaches.remove(tache);
    }

    /**
     * TODO testme
     * Affecte l'utilisateur en parametre en tant que responsable du projet
     *
     * @param responsable
     * @throws IllegalStateException
     */
    public void associerResponsable(Utilisateur responsable) throws IllegalStateException {
        if (this.responsable != null) {
            throw new IllegalStateException("Il y a deja un responsable pour ce projet");
        }
        this.responsable = responsable;
    }

    /**
     * TODO testme
     * Modifie le responsable de projet par l'utilisateur en parametre
     *
     * @param responsable
     * @throws IllegalArgumentException
     */
    public void modifierResponsable(Utilisateur responsable) throws IllegalArgumentException {
        if (this.responsable == responsable) {
            throw new IllegalArgumentException("Remplacement du responsable de projet par le même responsable");
        }
        this.responsable = responsable;
    }

    /**
     * TODO testme
     * Associe le projet courant au client passé en parametre
     *
     * @param client
     * @throws IllegalStateException
     */
    public void associerClient(Client client) throws IllegalStateException {
        if (this.client != null) {
            throw new IllegalStateException("Il y a deja un client pour ce projet");
        }
        this.client = client;
    }
}

package models;

import com.avaje.ebean.Model;
import play.data.validation.Constraints;
import scala.collection.immutable.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Gishan on 04/01/2016.
 */
@Entity
@Table(name = "Client")
public class Client extends Model{

    @Id
    @GeneratedValue
    public Long id;
    public String nom;

    @Constraints.Min(1)
    @Constraints.Max(3)
    public Integer priorite;
    public Boolean archiver;
    public Adresse adresseClient;
    public List<Personne> listeContacts;
    public List<Projet> listeProjets;

    public static Model.Finder<Long, Client> find = new Model.Finder<Long, Client>(Client.class);

    public void creeClient(Client client){
        client.save();
    }

    public Client(String nom, Integer priorite, Boolean archiver, Adresse adresseClient, List<Personne> listeContacts, List<Projet> listeProjets) {
        this.nom = nom;
        this.priorite = priorite;
        this.archiver = archiver;
        this.adresseClient = adresseClient;
        this.listeContacts = listeContacts;
        this.listeProjets = listeProjets;
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

    public Integer getPriorite() {
        return priorite;
    }

    public void setPriorite(Integer priorite) {
        this.priorite = priorite;
    }

    public Boolean getArchiver() {
        return archiver;
    }

    public void setArchiver(Boolean archiver) {
        this.archiver = archiver;
    }

    public Adresse getAdresseClient() {
        return adresseClient;
    }

    public void setAdresseClient(Adresse adresseClient) {
        this.adresseClient = adresseClient;
    }

    public List<Personne> getListeContacts() {
        return listeContacts;
    }

    public void setListeContacts(List<Personne> listeContacts) {
        this.listeContacts = listeContacts;
    }

    public List<Projet> getListeProjets() {
        return listeProjets;
    }

    public void setListeProjets(List<Projet> listeProjets) {
        this.listeProjets = listeProjets;
    }
}

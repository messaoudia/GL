package models;

import com.avaje.ebean.Model;
import play.data.validation.Constraints;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;

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

    public static void creeClient(Client client){
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

}

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

    public static Model.Finder<Long, Client> find = new Model.Finder<>(Client.class);

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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[Client : ");
        sb.append(id);
        sb.append("] : Priority");
        sb.append(priorite);
        sb.append(", archived");
        sb.append(archiver);
        sb.append(", adress \n");
        sb.append(adresseClient);
        sb.append("\n, ListClients :");
        for (Personne personne : listeContacts) {
            sb.append("\n");
            sb.append(personne);
            sb.append("\n");
        }
        sb.append("\n, ListProjets :");
        for (Projet projet : listeProjets) {
            sb.append("\n");
            sb.append(projet);
            sb.append("\n");
        }
        return sb.toString();
    }
}

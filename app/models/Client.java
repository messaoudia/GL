package models;

import com.avaje.ebean.Model;
import play.data.validation.Constraints;

import javax.persistence.*;
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

    @OneToOne
    public Adresse adresseClient;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name="Contact", joinColumns={@JoinColumn(name="id")})
    public List<Contact> listeContacts;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name="Projet", joinColumns={@JoinColumn(name="id")})
    public List<Projet> listeProjets;

    public static Model.Finder<Long, Client> find = new Model.Finder<>(Client.class);

    public static void creeClient(Client client){
        client.save();
    }

    public Client(String nom, Integer priorite, Boolean archiver, Adresse adresseClient, List<Contact> listeContacts, List<Projet> listeProjets) {
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
        sb.append("[Client : ").append(id).append("] : Priority").append(priorite);
        sb.append(", archived").append(archiver).append(", adress \n").append(adresseClient);
        sb.append("\n, ListClients :");
        for (Personne personne : listeContacts) {
            sb.append("\n").append(personne).append("\n");
        }
        sb.append("\n, ListProjets :");
        for (Projet projet : listeProjets) {
            sb.append("\n").append(projet).append("\n");
        }
        return sb.toString();
    }
}

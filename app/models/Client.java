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

    public Client() {
    }

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
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        try {
            Client client = (Client) obj;
            return (client.id.equals(this.id) && client.nom.equals(this.nom) && client.priorite.equals(this.priorite)
                    && client.archiver.equals(this.archiver) && client.adresseClient.equals(this.adresseClient));
        } catch (ClassCastException e) {
            return false;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[Client : ").append(id).append("] : Priority").append(priorite);
        sb.append(", archived").append(archiver).append(", adress \n").append(adresseClient);
        sb.append("\n, ListContacts :");
        for (Contact personne : listeContacts) {
            sb.append("\n").append(personne.nom);
        }
        sb.append("\n, ListProjets :");
        for (Projet projet : listeProjets) {
            sb.append("\n").append(projet.nom);
        }
        return sb.toString();
    }

    /**
     * TODO testme
     * Affecter le projet en parametre au Client courant
     * @param projet
     */
    public void affecterProjet(Projet projet) throws IllegalArgumentException{
        if(listeProjets.contains(projet)){
            throw new IllegalArgumentException("Le client "+nom+"possede deja le projet "+projet.nom);
        }
        listeProjets.add(projet);
        this.save();
    }

    /**
     * TODO testme
     * Importer une liste de contacts, et les associer tous au client courant
     * @param listContact
     */
    public void importerListContacts(List<Contact> listContact){
        listContact.forEach(this::ajouterContact);
        save();
    }

    /**
     * TODO testme
     * @return les contacts du client courant
     */
    public List<Contact> exporterContacts(){
        return this.listeContacts;
    }

    /**
     * TODO testme
     * Ajouter le contact en parametre au champ listContact
     * @param contact
     */
    public void ajouterContact(Contact contact){
        this.listeContacts.add(contact);
    }

}

package models;

import com.avaje.ebean.Model;
import com.avaje.ebean.common.BeanList;
import models.Securite.EntiteSecurise;
import org.apache.commons.lang3.builder.ToStringBuilder;
import play.Logger;
import play.data.validation.Constraints;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Created by Gishan on 04/01/2016.
 */
@Entity
@Table
@DiscriminatorValue("CLIENT")
public class Client extends EntiteSecurise {

    public String nom;

    @Constraints.Min(1)
    @Constraints.Max(3)
    public Integer priorite;
    public Boolean archiver;

    @OneToOne
    public Adresse adresseClient;

    @OneToMany(mappedBy = "client",cascade = CascadeType.ALL)
    @JoinTable
    public List<Contact> listeContacts;

    @OneToMany(mappedBy = "client",cascade = CascadeType.ALL)
    @JoinTable
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
        this.listeContacts = (listeContacts==null)?new BeanList<>():listeContacts;
        this.listeProjets = (listeProjets==null)?new BeanList<>():listeProjets;
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
     * Affecter le projet en parametre au Client courant
     * @param projet
     */
    @Transient
    public void affecterProjet(Projet projet) throws IllegalArgumentException{
        if(listeProjets.contains(projet)){
            throw new IllegalArgumentException("Le client "+nom+"possede deja le projet "+projet.nom);
        }
        projet.client = this;
        projet.save();
        listeProjets.add(projet);
        save();
    }

    /**
     * Importer une liste de contacts, et les associer tous au client courant
     * @param listContact
     */
    @Transient
    public void importerListContacts(List<Contact> listContact){
        for(Contact c : listContact){
            try {
                ajouterContact(c);
            }catch(IllegalArgumentException e){
                Logger.error(e.getMessage());
            }
        }
        this.save();
    }

    /**
     *
     * @return les contacts du client courant
     * @throws NoSuchElementException
     */
    @Transient
    public List<Contact> exporterContacts() throws NoSuchElementException{
        if(this.listeContacts.size() == 0){
            throw new NoSuchElementException("Pas de contacts client");
        }
        return this.listeContacts;
    }

    /**
     * Ajouter le contact en parametre au champ listContact
     * @param contact
     * @throws IllegalArgumentException
     */
    @Transient
    public void ajouterContact(Contact contact) throws IllegalArgumentException{
        if(listeContacts.contains(contact)) {
            throw new IllegalArgumentException("Le contact "+contact+"appartient deja au client "+nom);
        }
        contact.client = this;
        contact.save();
        listeContacts.add(contact);
        save();
    }

}

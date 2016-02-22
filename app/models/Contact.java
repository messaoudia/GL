package models;

import com.avaje.ebean.Model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Guillaume on 03/02/2016.
 */
@Entity
@Table
public class Contact extends Personne {

    @ManyToMany
    @JsonIgnore
    public List<Tache> listTachesCorrespondant;

    @ManyToOne
    public Client client;

    public static Model.Finder<Long, Contact> find = new Model.Finder<>(Contact.class);

    public Contact(String nom, String prenom, String email, String telephone, List<Tache> listTachesCorrespondant) {
        super(nom, prenom, email, telephone,false);
        this.listTachesCorrespondant = listTachesCorrespondant;
    }

    public Contact(String nom, String prenom, String email, String telephone) {
        super(nom, prenom, email, telephone,false);
    }

    public Contact() {
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[Contact : ");
        sb.append(super.toString());
        if(client != null) {
            sb.append(", Client(");
            sb.append(client.nom).append(")");
        }
        return sb.toString();
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
            Contact contact = (Contact) obj;
            return super.equals(contact);
        } catch (ClassCastException e) {
            return false;
        }
    }
}
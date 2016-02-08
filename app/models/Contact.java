package models;

import com.avaje.ebean.Model;
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
    public List<Tache> listTachesCorrespondant;

    @ManyToOne(fetch= FetchType.LAZY)
    public Client client;

    public static Model.Finder<Long, Contact> find = new Model.Finder<>(Contact.class);

    public Contact(String nom, String prenom, String email, String telephone, List<Tache> listTachesCorrespondant, Client client) {
        super(nom, prenom, email, telephone);
        this.listTachesCorrespondant = listTachesCorrespondant;
        this.client = client;
    }

    public Contact(String nom, String prenom, String email, String telephone) {
        super(nom, prenom, email, telephone);
    }

    public Contact() {
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
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
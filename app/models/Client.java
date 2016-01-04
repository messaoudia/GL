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
@Table(name = "Clients")
public class Client extends Model{

    @Id
    @GeneratedValue
    public Long id;

    public String nom;

    @Constraints.Min(1)
    @Constraints.Max(3)
    public int importance;

    public boolean archiver;

    public List<Personne> listeContacts;

    public static Model.Finder<Long, Client> find = new Model.Finder<Long, Client>(Client.class);



    public void creeClient(Client client){
        client.save();
    }





}

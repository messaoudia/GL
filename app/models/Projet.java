package models;

import com.avaje.ebean.Model;
import play.data.format.Formats;
import play.data.validation.Constraints;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by Guillaume on 25/01/2016.
 */
@Entity
@Table(name = "Projet")
public class Projet extends Model {

    @Id
    @GeneratedValue
    public Long id;
    public String nom;
    public String description;
    @Formats.DateTime(pattern = "dd/MM/yyyy HH:mm")
    public Date dateDebut;
    @Formats.DateTime(pattern = "dd/MM/yyyy HH:mm")
    public Date dateFin;
    public int chargeInitiale;
    public byte avancementGlobal;
    public boolean enCours;
    public boolean archive;

    @Constraints.Min(1)
    @Constraints.Max(3)
    public int priorite;

    public static Model.Finder<Long, Projet> find = new Model.Finder<Long, Projet>(Projet.class);

}

package models.Securite;

import com.avaje.ebean.Model;
import models.Utilisateur;

import javax.persistence.*;

/**
 * Created by yachironi on 05/02/16.
 */
@Entity
@Table
public class Autorisation extends Model {

    @Id
    @GeneratedValue
    public Long id;

    @OneToOne
    public EntiteSecurise entiteSecurise;

    @OneToOne
    public Utilisateur utilisateur;
/*
    @OneToMany
    @JoinColumn
    public List<Role> roles;


    public static Model.Finder<Long, Autorisation> find = new Model.Finder<>(Autorisation.class);*/


}

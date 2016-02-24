package models;

import models.Securite.EntiteSecurise;
import play.data.validation.Constraints;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by yachironi on 24/02/16.
 */
@Entity
@Table
@DiscriminatorValue("egenerique")
public class EntiteGenerique extends EntiteSecurise {

    @Column(unique = true)
    @Constraints.Required
    public String nom;

    public static Finder<Long, EntiteGenerique> find = new Finder<>(EntiteGenerique.class);

}

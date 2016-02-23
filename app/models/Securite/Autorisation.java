package models.Securite;

import com.avaje.ebean.Model;
import com.avaje.ebean.annotation.Transactional;
import com.google.common.collect.ImmutableMap;
import models.Utilisateur;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yachironi on 05/02/16.
 */
@Entity
@Table(name = "autorisations")
public class Autorisation extends Model {

    @EmbeddedId
    @Column(name = "autorisation_id")
    AutorisationId autorisationId = new AutorisationId();

    public void setAutorisationId(Utilisateur utilisateur, EntiteSecurise entiteSecurise) {
        autorisationId.utilisateur_id = utilisateur.id;
        autorisationId.entite_securise_id = entiteSecurise.id;
        this.utilisateur = utilisateur;
        this.entiteSecurise = entiteSecurise;
    }

    // TODO Delete once all tests are done
    @ManyToOne
    @JoinColumn(name = "utilisateur_id", insertable = false, updatable = false)
    public Utilisateur utilisateur;

    // TODO Delete once all tests are done
    @ManyToOne
    @JoinColumn(name = "entite_securise_id", insertable = false, updatable = false)
    public EntiteSecurise entiteSecurise;

    @ManyToMany
    @JoinTable(
            name = "autorisation_role",
            joinColumns = {@JoinColumn(name = "utilisateur_id", referencedColumnName = "utilisateur_id"),
                    @JoinColumn(name = "entite_securise_id", referencedColumnName = "entite_securise_id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id_fk", referencedColumnName = "role_id")}
    )
    public List<Role> roles = new ArrayList<>();

    public static Model.Finder<Long, Autorisation> find = new Model.Finder<>(Autorisation.class);


    @Transactional
    public static void donnerLeRole(Utilisateur utilisateur, EntiteSecurise entiteSecurise, Role role) {
        Autorisation autorisation = new Autorisation();
        autorisation.setAutorisationId(utilisateur, entiteSecurise);
        autorisation.save();
        role.addAutorisation(autorisation);
    }

    @Transactional
    public static void enleverLeRole(Utilisateur utilisateur, EntiteSecurise entiteSecurise, Role role) {
        Autorisation autorisation = Autorisation
                .find
                .where()
                .allEq(
                        ImmutableMap.of(
                                "utilisateur.id", utilisateur.id.toString(),
                                "entiteSecurise.id", entiteSecurise.id.toString()))
                .findUnique();
        if (autorisation != null) {
            autorisation.roles.removeIf(roleInTheLoop -> roleInTheLoop.id == role.id);
            autorisation.update();
            //Remove the bidirectional instance
            role.autorisations.removeIf(autorisationInTheLoop -> autorisationInTheLoop.autorisationId == autorisation.autorisationId);
            role.update();
        }
    }

    @Override
    public String toString() {
        return "user id: " + utilisateur.id + ",entity id: " + entiteSecurise.id + " => " + roles;
    }
}

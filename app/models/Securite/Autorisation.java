package models.Securite;

import com.avaje.ebean.Model;
import com.avaje.ebean.annotation.Transactional;
import models.Utilisateur;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yachironi on 05/02/16.
 */
@Entity
@Table(name = "autorisation")
public class Autorisation extends Model {

    @EmbeddedId
    @Column(name = "autorisation_Id")
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

    @OneToMany(mappedBy = "autorisation", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn
    public List<Role> roles = new ArrayList<>();

    public static Model.Finder<Long, Autorisation> find = new Model.Finder<>(Autorisation.class);


    @Transactional
    public static void donnerLeRole(Utilisateur utilisateur, EntiteSecurise entiteSecurise, Role role) {
        Autorisation autorisation = new Autorisation();
        autorisation.setAutorisationId(utilisateur, entiteSecurise);
        autorisation.save();
        role.addAutorisation(autorisation);
    }

    @Override
    public String toString() {
        return "user id: " + utilisateur.id + ",entity id: " + entiteSecurise.id + " => " + roles;
    }
}

package models.Securite;


import com.avaje.ebean.Model;
import com.avaje.ebean.annotation.EnumValue;

import javax.persistence.*;

/**
 * Created by yachironi on 23/02/16.
 */
@Entity
@Table(name = "permission")
public class Permission extends Model {

    @Id
    @GeneratedValue
    public Long id;

    @Column(name = "permissionValue", nullable = false)
    public PermissionEnum permissionValue;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn
    public Role role;

    public static Model.Finder<Long, Permission> find = new Model.Finder<>(Permission.class);



    @Override
    public String toString() {
        return permissionValue.name();
    }

    public enum PermissionEnum {

        @EnumValue("0")ModifierTousProjet,
        @EnumValue("1")SupprimerProjet,
        @EnumValue("2")AfficherTousProjet,
        @EnumValue("3")SupprimerTâche,
        @EnumValue("4")AfficherToutesTâche,
        @EnumValue("5")SupprContact,
        @EnumValue("6")SupprClient,
        @EnumValue("7")AfficherContact,
        @EnumValue("8")ModifierClient,
        @EnumValue("9")AfficherTousClient,
        @EnumValue("10")CreerUtilisateur,
        @EnumValue("11")ModifierUtilisateur,
        @EnumValue("12")SupprUtilisateur,
        @EnumValue("36")AfficherUtilisateur,
        @EnumValue("13")AfficherSideBarAdministrateur,
        @EnumValue("14")ImporrterClientContact,
        @EnumValue("15")ModifierProjetReponsable,
        @EnumValue("16")AfficherProjetResponsable,
        @EnumValue("17")CreerTache,
        @EnumValue("18")ModifierTache,
        @EnumValue("19")SupprimerTacheNonCommencee,
        @EnumValue("20")AfficherTacheResponsableProjet,
        @EnumValue("21")CreerContact,
        @EnumValue("22")CreerClient,
        @EnumValue("23")AfficherClientRespoProjet,
        @EnumValue("24")AfficherClientRespoTache,
        @EnumValue("25")AffichageTDBResponsableProjet, //ajout onglet + case projets en cours
        @EnumValue("26")AfficherSideBarResponsableProjet,
        @EnumValue("27")ExporterClientContact,
        @EnumValue("28")CreerProjet,
        @EnumValue("29")AfficherProjetTache,
        @EnumValue("30")ModifierAvancementTache,
        @EnumValue("31")AfficherTacheResponsable,
        @EnumValue("32")AffichageTDBCollaborateur,
        @EnumValue("33")AfficherSideBarCollaborateur,
        @EnumValue("34")AfficherEspaceUtilisateurResponsableProjet,
        @EnumValue("35")AfficherEspaceUtilisateurCollaborateur
    }
}

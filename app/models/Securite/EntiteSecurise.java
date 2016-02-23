package models.Securite;

import com.avaje.ebean.Model;
import com.google.common.collect.ImmutableMap;
import models.Utilisateur;

import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by yachironi on 05/02/16.
 */
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class EntiteSecurise extends Model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;


    public List<Permission> getPermissions(Utilisateur utilisateur) {
        final List<Permission> listOfPermissions = Autorisation
                .find
                .where()
                .allEq(ImmutableMap.of("utilisateur.id", utilisateur.id.toString(), "entiteSecurise.id", this.id.toString()))
                .findList()
                .stream()
                .flatMap(autorisation -> autorisation.roles.stream().map(role -> role.permissions))
                .collect(Collectors.toList()).stream()
                .flatMap(l -> l.stream())
                .collect(Collectors.toList());
        return listOfPermissions;
    }

    public Boolean havePermission(Utilisateur utilisateur, Permission permission) {
        return getPermissions(utilisateur).contains(permission);
    }
}

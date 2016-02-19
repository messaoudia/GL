package models.Securite;

import com.avaje.ebean.Model;

import javax.persistence.*;

/**
 * Created by yachironi on 05/02/16.
 */
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class EntiteSecurise extends Model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    /*
    public List<Permission> getPermissions(Utilisateur utilisateur) {
        final List<Permission> listOfPermissions = Autorisation
                .find
                .where()
                .like("utilsateur", utilisateur.id.toString())
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
    }*/
}

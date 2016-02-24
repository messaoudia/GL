package models.Securite;

import com.avaje.ebean.Model;
import com.avaje.ebean.annotation.Transactional;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yachironi on 05/02/16.
 */
@Entity
@Table(name = "role")
public class Role extends Model {

    @Id
    @GeneratedValue
    @Column(name = "role_id")
    public Long id;

    @Column(unique = true)
    public String nomDuRole;

    @OneToMany(mappedBy = "role", cascade = CascadeType.ALL)
    public List<Permission> permissions;

    //TODO Rendre la relation ManyToMany est plus logique
    @ManyToMany(mappedBy = "roles")
    public List<Autorisation> autorisations = new ArrayList<>();


    public static Model.Finder<Long, Role> find = new Model.Finder<>(Role.class);

    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }

    @Transactional
    public void addPermission(Permission permission) {
        permission.role = this;
        permission.save();
        this.permissions.add(permission);
        save();
    }

    @Transactional
    public void addAutorisation(Autorisation autorisation) {
        this.autorisations.add(autorisation);
        autorisation.roles.add(this);
        autorisation.save();
        save();
    }

    @Override
    public String toString() {
        return nomDuRole + ", permissions:" + permissions;
    }

    public static Role getRole(String nomDuRole) {
        return Role.find.where().eq("nomDuRole", nomDuRole).findUnique();
    }
}

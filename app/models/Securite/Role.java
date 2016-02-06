package models.Securite;

import com.avaje.ebean.Model;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.List;

/**
 * Created by yachironi on 05/02/16.
 */
public class Role extends Model {

    @Id
    @GeneratedValue
    public Long id;
    public String nomDuRole;

    public List<Permission> permissions;

}

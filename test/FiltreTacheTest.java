import com.avaje.ebean.common.BeanList;
import models.Contact;
import models.Projet;
import models.Tache;
import models.Utilisateur;
import models.Utils.Utils;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * Created by ozad on 03/03/2016.
 */
public class FiltreTacheTest {


    @Test
    public void testCheckBox(){
        Projet pr = new Projet();
        pr.nom = "New project";
        List<Contact> contactList = new BeanList<>();
        Utilisateur u1 = new Utilisateur("Blanchard","Guillaume","g.b@abc.fr","0123456789",false,"azertY1");

        Tache t  = new Tache(
                "Test filtre",
                "Cette tâche pour tester les fct du filtre ",u1,
                1,
                true,
                Utils.getDateFrom(2016,3,7),
                Utils.getDateFrom(2016,4,10),
                Utils.getDateFrom(2016,4,15),
                20D,
                0D,
                20D,
                contactList,pr,null,null,null,false);


        Assert.assertEquals(t.estRetardee(),false);
       // Assert.assertEquals(t.nbJourRestant(),43);

        Assert.assertEquals(t.commenceNextWeek(),true);
    }
}

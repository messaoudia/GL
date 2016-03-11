import com.avaje.ebean.Ebean;
import org.apache.commons.io.FileUtils;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import play.test.FakeApplication;
import play.test.Helpers;

import java.io.IOException;

/**
 * Created by ozad on 03/03/2016.
 */
public class FiltreTacheTest {

    public static FakeApplication app;
    public static String createDdl = "";
    public static String dropDdl = "";

    @BeforeClass
    public static void startApp() throws IOException {
        app = Helpers.fakeApplication(Helpers.inMemoryDatabase());
        Helpers.start(app);

        // Reading the evolution file
        String evolutionContent = FileUtils.readFileToString(
                app.getWrappedApplication().getFile("conf/evolutions/default/1.sql"));
        String[] splittedEvolutionContent = evolutionContent.split("# --- !Ups");
        String[] upsDowns = splittedEvolutionContent[1].split("# --- !Downs");
        createDdl = upsDowns[0];
        dropDdl = upsDowns[1];
    }

    @Before
    public void beforeEachTest() {
        Ebean.execute(Ebean.createCallableSql(dropDdl));
        Ebean.execute(Ebean.createCallableSql(createDdl));
    }

    @AfterClass
    public static void stopApp() {
        Helpers.stop(app);
    }

    @Test
    public void testCheckBox(){
       // Projet pr = new Projet();
       // pr.nom = "New project";
       // List<Contact> contactList = new BeanList<>();
       // Utilisateur u1 = new Utilisateur("Blanchard","Guillaume","g.b@abc.fr","0123456789",false,"azertY1");
       //
       // Tache t  = new Tache(
       //         "Test filtre",
       //         "Cette tâche pour tester les fct du filtre ",u1,
       //         1,
       //         true,
       //         Utils.getDateFrom(2016,3,7),
       //         Utils.getDateFrom(2016,4,10),
       //         Utils.getDateFrom(2016,4,15),
       //         20D,
       //         0D,
       //         20D,
       //         contactList,pr,null,null,null,false);
       //
       //
       // Assert.assertEquals(t.estRetardee(),false);
       //// Assert.assertEquals(t.nbJourRestant(),43);
       //
       // Assert.assertEquals(t.commenceNextWeek(),true);
    }
}

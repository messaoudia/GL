import com.avaje.ebean.Ebean;
import models.Adresse;
import models.Client;
import models.Contact;
import models.Utils.Utils;
import org.apache.commons.io.FileUtils;
import org.junit.*;
import play.Logger;
import play.test.FakeApplication;
import play.test.Helpers;

import java.io.IOException;
import java.util.Map;

/**
 * Created by yachironi on 02/03/16.
 */
public class ImportClientTest {
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
    public void importTest() {

        String fileNameClient = "/Users/zzcoolj/Downloads/clients/clientsExported-PearCorporation.csv";
        String fileNameContact = "/Users/zzcoolj/Downloads/clients/contactsExported-PearCorporation.csv";
        Utils.importAllClientsCSV(fileNameClient, fileNameContact);
        for(Client c: Client.find.all()) {
            //Adresse a = Adresse.find.byId(c.adresseClient.id);
            Logger.debug("**************************************");
            Logger.debug("Nom: " + c.nom);
            Logger.debug("Adresse: " + c.adresseClient);
            Logger.debug("**************************************" + "\n");
        }

        for(Contact c: Contact.find.all()) {
            Logger.debug("--------------------------------------");
            Logger.debug("Nom: " + c.nom);
            Logger.debug("Prenom: " + c.prenom);
            Logger.debug("Email: " + c.email);
            Logger.debug("Telephone: " + c.telephone);
            Logger.debug("Client: " + c.client);
            Logger.debug("--------------------------------------" + "\n");
        }
    }
}

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
public class ExportClientTest {
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
        Client client = new Client();
        client.nom = "Apple";


        Adresse adresse = new Adresse("3 Street Cloude", "645123", "Cupertinoss", "America");
        adresse.save();
        client.adresseClient = adresse;
        client.save();
        Contact contact = new Contact();
        contact.nom = "Jobs";
        contact.prenom = "Steve";
        contact.email = "s.j@apple.com";
        contact.telephone = "0215465978";
        contact.client = client;
        client.adresseClient = adresse;


        contact.save();
        client.save();
        Logger.debug("contact "+client.listContacts().toString());
        Client t = Client.find.byId(client.id);
        Logger.debug("contact" + t.listContacts().toString());
        Logger.debug("adresseBis "+t.adresseClient);
        Logger.debug("adresseTrois "+t.adresseClient.adresse);
        Logger.debug("adresseTrois "+t.adresseClient.zipCode);
        Logger.debug("adresseTrois "+t.adresseClient.ville);
        Logger.debug("adresseTrois "+t.adresseClient.pays);


    }

    @AfterClass
    public static void stopApp() {
        Helpers.stop(app);
    }

    @Test
    public void exportTest() {
        final Map<String, String> clients = Utils.exportAllClientsCSV();
        Assert.assertNotEquals(clients, null);
        Assert.assertNotEquals(clients.size(), 0);
        Logger.debug(clients.toString());
    }
}

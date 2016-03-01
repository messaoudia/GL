import com.avaje.ebean.Ebean;
import controllers.Global.Mail;
import org.apache.commons.io.FileUtils;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import play.libs.mailer.Email;
import play.test.FakeApplication;
import play.test.Helpers;

import java.io.IOException;

/**
 * Created by yachironi on 01/03/16.
 */
public class MailTest {

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
    public void sendMail() {
        final Email email = new Email();
        email.setSubject("[ My Project - Polytech ] Test 2 ");
        email.setFrom("NE-PAS-REPONDRE <myproject.polytechparissud@gmail.com>");
        email.addTo("Yasser RABI <yasser.rabi@gmail.com>");
        // adds attachment
        //email.addAttachment("attachment.pdf", new File("/some/path/attachment.pdf"));
        // adds inline attachment from byte array
        // email.addAttachment("data.txt", "data".getBytes(), "text/plain", "Simple data", EmailAttachment.INLINE);
        // sends text, HTML or both...
        //email.setBodyText("Hi Yasser");
        email.setBodyHtml("<html><body><p>Bonjour Yasser,<br>Ceci est un test<br>Cordialement,</body></html>");


        Mail.sendEmail(email);


    }

}

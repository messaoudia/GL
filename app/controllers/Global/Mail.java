package controllers.Global;

import play.Play;
import play.api.libs.mailer.MailerClient;
import play.libs.mailer.Email;

/**
 * Created by yachironi on 01/03/16.
 */
public class Mail {

    public static void sendEmail(Email email) {
        final MailerClient mailerClient = Play.application().injector().instanceOf(MailerClient.class);
        mailerClient.send(email);

        //final Email email = new Email();
        //email.setSubject("[ My Project - Polytech ] Test 2 ");
        //email.setFrom("NE-PAS-REPONDRE <myproject.polytechparissud@gmail.com>");
        //email.addTo("Yasser RABI <yasser.rabi@gmail.com>");
        //// adds attachment
        ////email.addAttachment("attachment.pdf", new File("/some/path/attachment.pdf"));
        //// adds inline attachment from byte array
        //// email.addAttachment("data.txt", "data".getBytes(), "text/plain", "Simple data", EmailAttachment.INLINE);
        //// sends text, HTML or both...
        ////email.setBodyText("Hi Yasser");
        //email.setBodyHtml("<html><body><p>Bonjour Yasser,<br>Ceci est un test<br>Cordialement,</body></html>");
    }
}

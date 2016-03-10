package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.collect.ImmutableMap;
import models.Utilisateur;
import controllers.Utils.Utils;
import play.Logger;
import play.api.i18n.Lang;
import play.data.Form;
import play.i18n.Messages;
import play.libs.Crypto;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.defaultpages.badRequest_Scope0;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

/**
 * This class is for tests purpose only !!!
 */
public class Login extends Controller {

    private final static Form<Utilisateur> loginForm = new Form<Utilisateur>(Utilisateur.class);
    private static Crypto crypto = play.Play.application().injector().instanceOf(Crypto.class);


    /**
     * This method receive an implicit POST requests, treat them by validating
     * the request content, Here we bind the request from:
     * 'key1=value1&key2=value2&keyX=valueX' into a JAVA object
     * if the binding goes well and the data is conform to the JAVA model specification (exp: required field, length...)
     * then the action specified in the controller will be done, otherwise a badRequest (40X HTTP response will be sent)
     *
     * @return
     */
    public Result authenticate() throws NoSuchPaddingException, UnsupportedEncodingException, InvalidAlgorithmParameterException, NoSuchAlgorithmException, IllegalBlockSizeException, BadPaddingException, InvalidKeyException {
        final String email = request().body().asFormUrlEncoded().get("email")[0];
        final String password = request().body().asFormUrlEncoded().get("password")[0];
        final Utilisateur utilisateurAuthentifie = Utilisateur.authenticate(email, password);

        final Map<String, String> sessionCredential = ImmutableMap.of("email", email, "password", password);

        if (utilisateurAuthentifie == null) {
            final Utilisateur utilisateur = new Utilisateur();
            utilisateur.email = email;
            return badRequest(views.html.login.render(loginForm.fill(utilisateur), Messages.get("mailOrPasswordInvalid")));
        } else {
            session().clear();
            changeLanguage(utilisateurAuthentifie.langue);
            String jsonStringUtilisateur = Json.toJson(sessionCredential).toString();
            session("sessionCredential", crypto.encryptAES(jsonStringUtilisateur));
            Logger.debug("Utilisateur authentifie: " + utilisateurAuthentifie);
            return redirect(routes.DashboardController.afficherDashboard());
        }
    }

    private static void changeLanguage(String language) {
        if (language != null && !language.isEmpty()) {
            ctx().changeLang(language);
        } else {
            ctx().changeLang(Lang.apply$default$2());
            Logger.error("Language set to default, language not found: " + language);
        }
    }

    /**
     * Render the login page with the initial form content from (loginForm)
     * in case
     *
     * @return The login.scala.html rendered
     */
    public Result index() {
        return ok(views.html.login.render(loginForm, null));
    }

    public static Utilisateur getUtilisateurConnecte() {
        final String encryptedCredentials = session().get("sessionCredential");
        final String decryptedCredentials = crypto.decryptAES(encryptedCredentials);
        final JsonNode jsonSessionCredential = Json.parse(decryptedCredentials);
        return Utilisateur.authenticate(jsonSessionCredential.get("email").asText(), jsonSessionCredential.get("password").asText());
    }

    public Result utilisateurConnecte(){
        return ok(Json.toJson(getUtilisateurConnecte()));
    }

    public static boolean isUtilisateurConnecte() {
        if (session().containsKey("sessionCredential")) {
            final String encryptedCredentials = session().get("sessionCredential");
            final String decryptedCredentials = crypto.decryptAES(encryptedCredentials);
            final JsonNode jsonSessionCredential = Json.parse(decryptedCredentials);
            if (Utilisateur.authenticate(jsonSessionCredential.get("email").asText(), jsonSessionCredential.get("password").asText()) != null) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public Result clickMotDePasseOublie(String email){
        Utilisateur user = Utilisateur.find.where().eq("email", email).findUnique();

        if(user==null){
            System.out.println("Cet adresse mail n'existe pas.");
            return badRequest("Cet adresse mail n'existe pas.");

        }
        else {
            Logger.debug("Mot de passe oublier");
            return ok(Utils.sendMailMotDePasseOublie(user));
        }
    }
}

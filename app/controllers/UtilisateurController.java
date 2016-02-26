package controllers;

import models.Utilisateur;
import play.api.data.validation.Constraint;
import play.data.validation.Constraints;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.creerUtilisateur;
import models.Error;

import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UtilisateurController extends Controller {


    public Result afficherCreerUtilisateur() {
        return ok(creerUtilisateur.render("Créer Utilisateur"));
    }

    public Result creerUtilisateur()
    {

        Map<String, String[]> map = request().body().asFormUrlEncoded();
        System.out.println("map = "+map);
        Error error = new Error();

        // nom utilisateur [1,15] char
        if(map.get("new-formLastName")[0].isEmpty())
        {
            error.nomVide = true;
            //return badRequest(Json.toJson(error));
        }
        else if(map.get("new-formLastName")[0].length()>15)
        {
            error.nomTropLong = true;
        }

        // prenom utilisateur [1,15] char
        if(map.get("new-formFirstName")[0].isEmpty())
        {
            error.prenomVide = true;
        }
        else if(map.get("new-formFirstName")[0].length()>15)
        {
            error.prenomTropLong = true;
        }

        //pattern java
        Pattern emailRegex = Pattern.compile("^[_a-z0-9-]+(\\.[_a-z0-9-]+)*@[a-z0-9-]+(\\.[a-z0-9-]+)+$");
        Matcher emailMatch = emailRegex.matcher(map.get("new-formEmail")[0]);
        // email
        if(map.get("new-formEmail")[0].isEmpty())
        {
            error.emailVide = true;
        }
        else if(!emailMatch.matches())
        {
            error.emailIncorrecte = true;
        }

        String telRegexS = "^(([(]?(\\d{2,4})[)]?)|(\\d{2,4})|([+1-9]+\\d{1,2}))?[-\\s]?(\\d{2,3})?[-\\s]?((\\d{7,8})|(\\d{3,4}[-\\s]\\d{3,4}))$";

        Pattern telRegex = Pattern.compile(telRegexS);
        Matcher telMatch = emailRegex.matcher(map.get("new-formTel")[0]);



        boolean res = Pattern.matches(telRegexS, map.get("new-formTel")[0]) ;
        // tel
        if(map.get("new-formTel")[0].isEmpty())
        {
            error.telVide = true;
        }
        else if(!res)
        {
            error.telIncorrecte = true;
        }

        List<Utilisateur> listUser = Utilisateur.find.where().eq("email",map.get("new-formEmail")[0]).findList();

        if(!listUser.isEmpty()) {
            error.userExist = true;
        }

        if(error.hasErrorUtilisateur())
        {
            return badRequest(Json.toJson(error));
        }
        else{
            //creation user
            Utilisateur user = new Utilisateur(map.get("new-formLastName")[0], map.get("new-formFirstName")[0], map.get("new-formEmail")[0], map.get("new-formTel")[0], false, Utilisateur.genererPassword());
            user.save();
            //TODO : send email to user
            return ok();
        }
    }
}

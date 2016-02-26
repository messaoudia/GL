package controllers;

import models.Utilisateur;
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

    public Error isFormulaireCorrect(Map<String, String[]> map,String preName)
    {
        System.out.println("map = "+map);
        Json errorJson = new Json();
        Error error = new Error();

        Pattern nameRegex = Pattern.compile("^[A-Za-z ,.'-]{1,15}$");
        Matcher nameMatch = nameRegex.matcher(map.get(preName+"-formLastName")[0]);

        //TODO regex nom : que des lettres ' -
        // nom utilisateur [1,15] char
        if(map.get(preName+"-formLastName")[0].isEmpty())
        {
            error.nomVide = true;
            //return badRequest(Json.toJson(error));
        }
        else if(map.get(preName+"-formLastName")[0].length()>15)
        {
            error.nomTropLong = true;
        }
        else if(!nameMatch.matches())
        {
            error.nomIncorrect = true;
        }

        nameMatch = nameRegex.matcher(map.get(preName+"-formFirstName")[0]);

        //TODO regex prenom : que des lettres ' -
        // prenom utilisateur [1,15] char
        if(map.get(preName+"-formFirstName")[0].isEmpty())
        {
            error.prenomVide = true;
        }
        else if(map.get(preName+"-formFirstName")[0].length()>15)
        {
            error.prenomTropLong = true;
        }
        else if(!nameMatch.matches())
        {
            error.prenomIncorrect = true;
        }

        //pattern java
        Pattern emailRegex = Pattern.compile("^[_a-z0-9-]+(\\.[_a-z0-9-]+)*@[a-z0-9-]+(\\.[a-z0-9-]+)+$");
        Matcher emailMatch = emailRegex.matcher(map.get(preName+"-formEmail")[0]);
        // email
        if(map.get(preName+"-formEmail")[0].isEmpty())
        {
            error.emailVide = true;
        }
        else if(!emailMatch.matches())
        {
            error.emailIncorrecte = true;
        }
        else if(map.get(preName+"-formEmail")[0].length()>50)
        {
            error.emailTropLong = true;
        }

        String telRegexS = "^(([(]?(\\d{2,4})[)]?)|(\\d{2,4})|([+1-9]+\\d{1,2}))?[-\\s]?(\\d{2,3})?[-\\s]?((\\d{7,8})|(\\d{3,4}[-\\s]\\d{3,4}))$";
        Pattern telRegex = Pattern.compile(telRegexS);
        Matcher telMatch = telRegex.matcher(map.get(preName+"-formTel")[0]);
        boolean res = Pattern.matches(telRegexS, map.get(preName+"-formTel")[0]) ;
        // tel
        if(map.get(preName+"-formTel")[0].isEmpty())
        {
            error.telVide = true;
        }
        else if(!telMatch.matches())
        {
            error.telIncorrecte = true;
        }
        else if(map.get(preName+"-formTel")[0].length()>15)
        {
            //TODO je crois que cette condition ne sert a rien en fait car la regex du tel bloque a elle tt seul quand on depasse 15 char
            //TODO si condiition est supprime, la supprimer dans main.scala.html dans creerUtilisateur().ajax
            error.telTropLong = true;
        }
        return error;
    }

    public Result creerUtilisateur()
    {

        Map<String, String[]> map = request().body().asFormUrlEncoded();
        Error error = isFormulaireCorrect(map,"new");
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
            //TODO si admin = OUI, si admin = NON
            if(map.get("admin")[0].equals("Oui"))
            {
                //TODO lui donner droit admin
                System.out.println("Creation d'un admin ...");
            }
            else
            {
                //TODO SBLC
            }
            Utilisateur user = new Utilisateur(map.get("new-formLastName")[0], map.get("new-formFirstName")[0], map.get("new-formEmail")[0], map.get("new-formTel")[0], false, Utilisateur.genererPassword());
            user.save();
            //TODO : send email to user
            return ok(Json.toJson(user));
        }
    }

    public Result modifierUtilisateur(Long idUtilisateur)
    {
        Utilisateur utst = Utilisateur.find.byId(idUtilisateur);
        System.out.println("Utilisateur utst "+utst);

        Map<String, String[]> map = request().body().asFormUrlEncoded();

        Error error = isFormulaireCorrect(map,"modify");

        if(error.hasErrorUtilisateur())
        {
            return badRequest(Json.toJson(error));
        }

        if(utst==null)
        {
            error.userExist = false;
            return badRequest(Json.toJson(error));
        }

        //TODO modifier l'utilisateur
        utst.setFirstName(map.get("modify-formFirstName")[0]);
        utst.setLastName(map.get("modify-formLastName")[0]);
        utst.setEmail(map.get("modify-formEmail")[0]);
        utst.setTelephone(map.get("modify-formTel")[0]);

        //map.get("new-formLastName")[0]
        //map.get("new-formFirstName")[0]
        //map.get("new-formEmail")[0]
        //map.get("new-formTel")[0]
        //map.get("admin")[0].equals("Oui")
        utst.save();

        return ok(Json.toJson(utst));
    }
}

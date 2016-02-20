package controllers;

import play.mvc.Controller;
import play.mvc.Result;
import views.html.creerUtilisateur;


public class UtilisateurController extends Controller {

    public Result afficherCreerUtilisateur() {
        return ok(creerUtilisateur.render("Créer Utilisateur"));
    }
}

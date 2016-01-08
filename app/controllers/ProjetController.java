package controllers;

import play.mvc.Controller;
import play.mvc.Result;
import views.html.creerClient;
import views.html.creerProjet;
import views.html.projet;

/**
 * Created by Gishan on 07/01/2016.
 */
public class ProjetController extends Controller{

    public Result afficherProjets() {
        return ok(projet.render());
    }

    public Result afficherCreerProjet(){
        return ok(creerProjet.render());
    }
}

package controllers;

import models.Client;
import play.Logger;
import play.libs.Json;
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
        return ok(projet.render("Projets"));
    }

    public Result afficherCreerProjet(){
        return ok(creerProjet.render("Créer Projet"));
    }

    public Result afficherProjetsClient(long idClient) {
        Client client = Client.find.byId(idClient);
        Logger.debug("Projet Client ID : "+idClient);
        return ok(Json.toJson(models.Projet.find.where().eq("client",client).findList()));
    }
}

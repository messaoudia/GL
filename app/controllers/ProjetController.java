package controllers;

import models.Client;
import models.Projet;
import models.Utilisateur;
import play.Logger;
import play.libs.Json;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.creerClient;
import views.html.creerProjet;
import views.html.projet;

import java.util.Map;

import static play.data.Form.form;

public class ProjetController extends Controller{

    public Result afficherProjets() {
        return ok(projet.render("Projets", Utilisateur.getAllNonArchives().get(0)));   // provisoir en attendant login
    }

    public Result afficherCreerProjet(){
        return ok(creerProjet.render("Créer Projet", Utilisateur.getAllNonArchives(), Client.getAllNonArchives()));
    }

    public Result afficherProjetsClient(long idClient) {
        Client client = Client.find.byId(idClient);
        Logger.debug("Projet Client ID : "+idClient);
        return ok(Json.toJson(models.Projet.find.where().eq("client",client).findList()));
    }

    public Result ajouterProjet() {
        Map<String, String[]> map = request().body().asFormUrlEncoded();
        System.out.println(map.get("priorite")[0]);
        System.out.println(map.get("dateDebutTheorique")[0]);
        return ok();
    }
}

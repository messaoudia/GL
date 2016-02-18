package controllers;

import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.creerProjet;
import views.html.projet;

import java.util.Map;

import static play.data.Form.form;

public class ProjetController extends Controller{

    public Result afficherProjets() {
        return ok(projet.render("Projets"));
    }

    public Result afficherCreerProjet(){
        return ok(creerProjet.render("Créer Projet"));
    }

    public Result ajouterProjet() {
        Map<String, String[]> map = request().body().asFormUrlEncoded();
        final Form<Projet> projetForm = form(Projet.class).bindFromRequest();
        System.out.println(map.get("priorite")[0]);
        return ok();
    }
}

package controllers;

import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.creerClient;
import views.html.creerProjet;
import views.html.projet;
import views.html.tests;

import java.util.Map;

import static play.data.Form.form;

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

    public Result ajouterProjet() {
        System.out.println("JE SUIS LA");
        Map<String, String[]> map = request().body().asFormUrlEncoded();
        final Form<Projet> projetForm = form(Projet.class).bindFromRequest();
        System.out.println(projetForm.get());
        return ok();
        /*if (taskForm.hasErrors()) {
            return badRequest();
        } else {
            Tache.create(taskForm.get());
            return ok(tests.render(Tache.find.all()));
        }
        */
    }

}

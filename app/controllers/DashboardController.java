package controllers;

import models.Tache;
import models.Utilisateur;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.dashboard;

/**
 * Created by Gishan on 08/01/2016.
 */
public class DashboardController extends Controller{
    public Result afficherDashboard() {
        return ok(dashboard.render("Dashboard", Utilisateur.getAllNonArchives().get(0)));   // provisoir en attendant login
    }

    public Result afficherModalTache(long idTache) {
        return ok(Json.toJson(Tache.find.byId(idTache)));
    }

}

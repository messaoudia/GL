package controllers;

import models.Utilisateur;
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
}

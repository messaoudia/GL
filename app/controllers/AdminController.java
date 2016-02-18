package controllers;

import play.mvc.Controller;
import play.mvc.Result;
import views.html.*;

public class AdminController extends Controller{

    public Result afficherAdminClients() {
        return ok(adminClients.render("Admin Clients"));
    }

    public Result afficherAdminProjets() {
        return ok(adminProjets.render("Admin Projets"));
    }

    public Result afficherAdminUtilisateur() {
        return ok(adminUtilisateur.render("Admin Utilisateur"));
    }

    public Result afficherAdminProjetsSelect() { return ok(adminProjetsSelect.render("Projet"));}
}

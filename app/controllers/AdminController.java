package controllers;

import play.mvc.Controller;
import play.mvc.Result;
import views.html.*;

import java.util.Map;

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

    public Result afficherAdminProjetsSelect(Long idProjet) {
        System.out.println(idProjet);
        /* TODO : aller chercher dans la base de donnee le projet correspondant */
        return ok(adminProjetsSelect.render("Projet"));
    }
}

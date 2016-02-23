package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import models.*;
import play.Logger;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.adminClients;
import views.html.adminProjets;
import views.html.adminUtilisateur;
import views.html.adminProjetsSelect;

import java.util.Date;
import java.util.List;


/**
 * Created by Gishan on 07/01/2016.
 */
public class AdminController extends Controller{

    public Result afficherAdminClients() {
        return ok(adminClients.render("Admin Clients", Client.getAllNonArchives()));
    }

    public Result afficherClientsArchives() {
        return ok(Json.toJson(Client.getAllArchives()));
    }

    public Result afficherAdminProjets() {
        return ok(adminProjets.render("Admin Projets", models.Projet.getAllNonArchivesNonTermines()));
    }

    public Result afficherAdminUtilisateur() {
        return ok(adminUtilisateur.render("Admin Utilisateur", Utilisateur.getAllNonArchives()));
    }

    public Result afficherUtilisateursArchives() {
        //Logger.debug(Utilisateur.getAllArchives().toString());
        return ok(Json.toJson(Utilisateur.getAllArchives()));
    }

    public Result afficherModalUtilisateur(long idUtilisateur){
        return ok(Json.toJson(Utilisateur.find.byId(idUtilisateur)));
    }

    public Result afficherModalClient(long idUtilisateur) {
        return ok(Json.toJson(Client.find.byId(idUtilisateur)));
    }


    public Result afficherAdminProjetsSelect(Long idProjet) {
        return ok(adminProjetsSelect.render("Projet",Projet.find.byId(idProjet)));
    }

    public Result afficherProjetsTermines(Boolean check){
        List<Projet> p = Projet.getAllTermines(check);
        System.out.println(p.size());
        return ok(Json.toJson(Projet.getAllTermines(check)));
    }

    public Result afficherProjetsArchives(Boolean check) {
        System.out.println("LAAAAAAAAAAAA");
        List<Projet> p = Projet.getAllArchives(check);
        System.out.println(p.size());
        System.out.println(p.get(0).nom);
        System.out.println(p.get(1).nom);
        return ok(Json.toJson(Projet.getAllArchives(check)));
    }

    public Result supprimerProjet(Long idProjet){
        Projet.supprimerPorjet(idProjet);
        System.out.println(Projet.find.byId(idProjet).archive);
        return ok();
    }
}

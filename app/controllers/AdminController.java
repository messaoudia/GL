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
        return ok(adminClients.render("Admin Clients", Client.find.all()));
    }

    public Result afficherClientsArchives() {
        return ok(Json.toJson(Client.getAllArchives()));
    }

    public Result afficherAdminProjets() {
        return ok(adminProjets.render("Admin Projets", Projet.find.all()));
    }

    public Result afficherAdminUtilisateur() {
        return ok(adminUtilisateur.render("Admin Utilisateur", Utilisateur.find.all()));
    }

    public Result afficherUtilisateursArchives() {
        //Logger.debug(Utilisateur.getAllArchives().toString());
        return ok(Json.toJson(Utilisateur.getAllArchives()));
    }

    public Result afficherModalUtilisateur(long idUtilisateur){
        Utilisateur t = Utilisateur.find.byId(idUtilisateur);
        System.out.println("LAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
        System.out.println(t.checkAdmin());
        return ok(Json.toJson(Utilisateur.find.byId(idUtilisateur)));
    }

    public Result afficherModalSupprimerUtilisateur(long idUtilisateur){
        return ok(Json.toJson(Utilisateur.find.byId(idUtilisateur)));
    }

    public Result afficherModalClient(long idUtilisateur) {
        return ok(Json.toJson(Client.find.byId(idUtilisateur)));
    }


    public Result afficherAdminProjetsSelect(Long idProjet) {
        return ok(adminProjetsSelect.render("Projet",Projet.find.byId(idProjet)));
    }

    public Result afficherProjetsTermines(Boolean check){
        return ok(Json.toJson(Projet.getAllTermines(check)));
    }

    public Result afficherProjetsArchives(Boolean check) {
        return ok(Json.toJson(Projet.getAllArchives(check)));
    }

    public Result supprimerProjet(Long idProjet){
        Projet archive = Projet.supprimerProjet(idProjet);

        return ok(Json.toJson(archive));
    }

    public Result afficherModalProjet(Long idProjet){
        return ok(Json.toJson(Projet.find.byId(idProjet)));
    }

    public Result afficherModalCreerProjetResponsable(){
        return ok(Json.toJson(Utilisateur.getAllNonArchives()));
    }

    public Result afficherModalCreerProjetClient(){
        return ok(Json.toJson(Client.getAllNonArchives()));
    }

    public Result supprimerClient(Long id){
        Client client = Client.find.byId(id);
        client.archiver = true;
        for(Projet p : client.listeProjets){
            System.out.println(p.nom);
            p.archive = true;
            p.save();
        }

        for(Contact c : client.listContacts()){
            c.archive = true;
            c.save();
        }
        client.save();
        System.out.println(client.listeProjets.size());

        return ok();
    }
}

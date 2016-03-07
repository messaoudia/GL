package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import models.*;
import models.Error;
import play.Logger;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.*;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;


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
        List<Projet> lp =  Projet.find.all();
        System.out.println(lp.size());
        for(Projet p : lp){
            System.out.println(lp);
        }
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
        return ok(adminProjetsSelect.render("Projet",Projet.find.byId(idProjet),Login.getUtilisateurConnecte(),Client.getAllNonArchives(),Utilisateur.getAllNonArchives()));
    }

    public Result afficherProjetsTermines(Boolean check){
        return ok(Json.toJson(Projet.getAllTermines(check)));
    }

    public Result afficherProjetsArchives(Boolean check) {
        return ok(Json.toJson(Projet.getAllArchives(check)));
    }

    public Result supprimerProjet(Long idProjet){
        Projet archive = Projet.supprimerProjet(idProjet);
        Notification.sendNotificationSupprimerProjet(archive, Login.getUtilisateurConnecte());
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

    public Result checkMdpAdmin(String pswd){
        Utilisateur connecte = Login.getUtilisateurConnecte();
        //check si vide
        Error error = new Error();
        if(pswd.isEmpty()){
            error.mdpVide = true;
        }else {
            //check si mot de passe correcte
            if(!connecte.checkPassword(pswd)){
                error.mdpIncorrecte = true;
            }
        }
        if(error.hasErrorMdp()){
            return badRequest(Json.toJson(error));
        }else{
            return ok();
        }
    }

    public Result modifierProjet(Long id){
        Projet p = Projet.find.byId(id);
        Map<String, String[]> map = request().body().asFormUrlEncoded();
        Error error = new Error();
        String nom = map.get("projet")[0];
        if (nom.isEmpty()) {
            error.nomProjetVide = true;
        } else if (nom.length() > 30) {
            error.nomProjetTropLong= true;
        }
        String description = map.get("description")[0];
        if(description.length() > 65536) {
            error.descriptionTropLong = true;
        }
        if(error.hasErrorProjet()){
            return badRequest(Json.toJson(error));
        }else{
            boolean modificationProjet = false;
            boolean modificationRespoProjet = false;
            Long idUser = Long.parseLong(map.get("responsableProjet")[0]);
            Utilisateur user = Utilisateur.find.byId(idUser);
            Long idClient = Long.parseLong(map.get("client")[0]);
            Client client = Client.find.byId(idClient);
            //modification des info si besoin
            int priorite = Integer.parseInt(map.get("priorite")[0]);
            //check priorite
            if(!p.nom.equals(nom)){
                modificationProjet = true;
                p.nom = nom;
            }
            if(p.priorite != priorite){
                modificationProjet = true;
                p.priorite = priorite;
            }
            //description
            if(!p.description.equals(description)){
                //TODO : ajouter nouveau droit au respo projet + enlever droit à l'ancien
                p.description = description;
            }

            Utilisateur ancienResponsable = p.responsableProjet;
            if(!p.responsableProjet.equals(user)){
                modificationRespoProjet = true;
                p.responsableProjet = user;
            }

            if(!p.client.equals(client)){
                modificationProjet = true;
                // on enleve le projet de l'ancien
                Logger.debug("on est la");
                Optional<Projet> projet = p.client.listeProjets.stream().filter(projetC -> projetC.id == p.id).findFirst();
                if (projet.isPresent()) {
                   p.client.listeProjets.remove(projet);
                } else {
                    System.out.println("T'es dans la merde");
                }
                p.client.save();
                p.client = client;
            }
            p.save();
            Utilisateur currentUser = Login.getUtilisateurConnecte();
            if(modificationRespoProjet){
                currentUser.mapNotificationsGenerees.createNotificationModifierResponsableProjet(p, ancienResponsable);
                currentUser.save();
            } else if(modificationProjet) {
                currentUser.mapNotificationsGenerees.createNotificationModifierProjet(p);
                currentUser.save();
            }
            return ok(Json.toJson(p));
        }
    }

    public Result redirectDashboard(){
        Logger.debug(dashboard.render("Dashboard", Login.getUtilisateurConnecte()).toString());
        return ok(dashboard.render("Dashboard", Login.getUtilisateurConnecte()));   // provisoir en attendant login
    }
}

package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import models.*;
import models.Error;
import models.Utils.Utils;
import play.Logger;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.creerProjet;
import views.html.projet;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

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

    public Result creerProjet() {
        //TODO : description non obligatoire ?
        Map<String, String[]> map = request().body().asFormUrlEncoded();
        System.out.println(map);
        Error error = new Error();
        String nom = map.get("nom")[0];
        if (nom.isEmpty()) {
            error.nomProjetVide = true;
        } else if (nom.length() > 30) {
            error.nomProjetTropLong= true;
        }
        Utilisateur responsableProjet = Utilisateur.find.byId(Long.valueOf(map.get("responsableProjet")[0]));
        Client client = Client.find.byId(Long.valueOf(map.get("client")[0]));

        String description = map.get("description")[0];

        int priorite = Integer.parseInt(map.get("priorite")[0]);
        UniteProjetEnum unite;
        if (map.get("unite")[0].equals("JOUR")) {
            unite = UniteProjetEnum.JOUR;
        } else {
            unite = UniteProjetEnum.SEMAINE;
        }

        String dateDeb = map.get("dateDebutTheorique")[0];
        String dateFin = map.get("dateFinTheorique")[0];
        //Date
        if (dateDeb.isEmpty()) {
            error.dateThDebutProjetVide = true;
        }
        if (dateFin.isEmpty()) {
            error.dateThFinProjetVide = true;
        }

        if (description.length() > 65536) {
            error.descriptionTropLong = true;
        }

        if (error.hasErrorProjet()) {
            return badRequest(Json.toJson(error));
        } else {
            //TODO: check date en fonction de la langue && check si projet existe deja
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            Date dateDebutTheorique = null;
            Date dateFinTheorique = null;
            try {
                dateDebutTheorique = formatter.parse(dateDeb);
                dateFinTheorique = formatter.parse(dateFin);
                //if (dateFinTheorique.after(dateDebutTheorique) || dateFinTheorique.equals(dateDebutTheorique)) {
                if (Utils.after(dateFinTheorique, dateDebutTheorique) || Utils.equals(dateFinTheorique, dateDebutTheorique)) {
                    Projet p = new Projet(nom, description, responsableProjet, dateDebutTheorique, dateFinTheorique, unite, client, priorite);
                    p.save();
                    client.listeProjets.add(p);
                    client.save();
                    return ok(Json.toJson(p));
                } else {
                    error.dateFinAvantDebut = true;
                }
            } catch (ParseException e) {
                error.parseError = true;

            }
            return badRequest(Json.toJson(error));
        }
    }

    public Result modifierProjet(Long id){
        Projet p = Projet.find.byId(id);
        //check projet  -- nom + description
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
        Logger.debug(p.responsableProjet.nom + p.responsableProjet.prenom);
        if(error.hasErrorProjet()){
            return badRequest(Json.toJson(error));
        }else{
            //modification des info si besoin
            int priorite = Integer.parseInt(map.get("priorite")[0]);
            Utilisateur responsableProjet = Utilisateur.find.byId(Long.valueOf(map.get("responsableProjet")[0]));
            if(!p.responsableProjet.equals(responsableProjet)){
                //TODO : ajouter nouveau droit au respo projet + enlever droit à l'ancien
                p.responsableProjet = responsableProjet;
                Logger.debug(responsableProjet.nom + responsableProjet.prenom);
            }
            //check priorite
            if(!p.priorite.equals(priorite)){
                //TODO : ajouter nouveau droit au respo projet + enlever droit à l'ancien
                p.priorite = priorite;
            }
            //description
            if(!p.description.equals(description)){
                //TODO : ajouter nouveau droit au respo projet + enlever droit à l'ancien
                p.description = description;
            }
            return ok(Json.toJson(p));
        }
    }


    public Result sendDraf() {
        JsonNode json = request().body().asJson();

        Logger.debug(json.toString());
        return ok(json.toString());
    }

}

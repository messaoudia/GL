package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import models.Contact;
import models.Projet;
import models.Tache;
import models.Utilisateur;
import models.Utils.Utils;
import play.Logger;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.dashboard;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by Gishan on 08/01/2016.
 */
public class DashboardController extends Controller{
    public Result afficherDashboard() {
        if (Login.isUtilisateurConnecte()) {
            return ok(dashboard.render("Dashboard", Login.getUtilisateurConnecte()));   // provisoir en attendant login
        } else {
            return redirect(routes.Login.index());
        }
    }

    public Result afficherModalTache(Long idTache) {
        Tache t = Tache.find.byId(idTache);
        //Logger.debug(t.toString());
        JsonNode node = Json.toJson(t);
        ObjectNode o = (ObjectNode) node;

        if(t.predecesseur!=null){
            //Logger.debug("Predecesseur : "+t.predecesseur);
            o.put("predecesseurNom",t.predecesseur.nom);
            o.put("predecesseurId",t.predecesseur.id);
        }
        o.put("nbJourRestant",t.nbJourRestant());
        return ok(o);
    }


    public Result getAllInterlocuteur(Long idProjet)
    {
        System.out.println("idProjet = [" + idProjet + "]");
        Projet p = Projet.find.byId(idProjet);
        System.out.println("DashboardController.getAllInterlocuteur");
        List<Contact> lC = p.client.listContacts();
        return ok(Json.toJson(lC));
    }

    public Result getAllPredecesseursPossible(Long idTache)
    {
        Tache tache = Tache.find.byId(idTache);
        List<Tache> listPredecesseurs = Tache.find.where().eq("projet",tache.projet).le("dateFinTard",tache.dateDebut).findList();

        return ok(Json.toJson(tache.getAllTacheNonParentsDirects(listPredecesseurs)));
    }

    public Result getAllSucesseursPossible(Long idTache)
    {
        Tache tache = Tache.find.byId(idTache);
        List<Tache> listSuccesseur = Tache.find.where().eq("projet",tache.projet).ge("dateDebut",tache.dateFinTard).findList();
        //parents direct à supprimmer
        return ok(Json.toJson(tache.getAllTacheNonParentsDirects(listSuccesseur)));
    }

    public Result saveBlocNote(Long idUser, String note){
        Utilisateur user = Utilisateur.find.byId(idUser);
        user.bloc_note = note;
        user.update();
        return ok();
    }

    public Result modifierTache(){
        Map<String, String[]> map = request().body().asFormUrlEncoded();

        for (Map.Entry<String, String[]> entry : map.entrySet()) {
            Logger.debug("Key : " + entry.getKey() + " Value : " + entry.getValue()[0]);
        }
        try {
            Long idTache = Long.parseLong(map.get("id-tache")[0]);
            Tache tache = Tache.find.byId(idTache);

            String newNomTache = map.get("form-modif-tache-nom")[0];
            String newDescTache = map.get("form-modif-tache-desc")[0];

            Double newChInitiale = Double.parseDouble(map.get("form-modif-tache-ch-init")[0]);
            Double newChConso = null;
            Double newChRestante = null;

            if(tache.disponible) {
                newChConso = Double.parseDouble(map.get("form-modif-tache-ch-cons")[0]);
                newChRestante = Double.parseDouble(map.get("form-modif-tache-ch-rest")[0]);
            }

            Tache newPredecesseur = Tache.find.byId(Long.parseLong(map.get("predecesseur")[0]));
            Utilisateur newResponsable = Utilisateur.find.byId(Long.parseLong(map.get("responsable")[0]));

            String[] dateDebut = map.get("DD-modifier")[0].split("/");
            Date newDebut = Utils.getDateFrom(Integer.parseInt(dateDebut[2]), Integer.parseInt(dateDebut[1]), Integer.parseInt(dateDebut[0]));

            String[] dateFinProche = map.get("DFTO-modifier")[0].split("/");
            Date newFinTot = Utils.getDateFrom(Integer.parseInt(dateFinProche[2]), Integer.parseInt(dateFinProche[1]), Integer.parseInt(dateFinProche[0]));

            String[] dateFinTard = map.get("DFTA-modifier")[0].split("/");
            Date newFinTard = Utils.getDateFrom(Integer.parseInt(dateFinTard[2]), Integer.parseInt(dateFinTard[1]), Integer.parseInt(dateFinTard[0]));

            tache.nom = newNomTache;
            tache.description = newDescTache;
            tache.chargeInitiale = newChInitiale;
            if(tache.disponible && (tache.chargeConsommee != newChConso || tache.chargeRestante != newChRestante)) {
                tache.modifierCharge(newChConso, newChRestante);
            }
            if (!tache.predecesseur.equals(newPredecesseur)) {
                tache.modifierPredecesseur(newPredecesseur);
            }
            if (!tache.responsableTache.equals(newResponsable)) {
                tache.modifierResponsable(newResponsable);
            }

            tache.dateDebut = newDebut;
            tache.dateFinTot = newFinTot;
            tache.dateFinTard = newFinTard;
            tache.save();

            Logger.debug("SAVE OK");
        }catch(Exception e){
            return badRequest(e.getMessage());
        }
        return ok();
    }

}

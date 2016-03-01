package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import models.Contact;
import models.Projet;
import models.Tache;
import models.Utilisateur;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.dashboard;

import java.util.ArrayList;
import java.util.List;

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

    public Result afficherModalTache(long idTache) {
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
        Projet p = Projet.find.byId(idProjet);
        List<Contact> lC = p.client.listContacts();
        return ok(Json.toJson(lC));
    }

    public Result getAllSucesseursPossible(Long idTache)
    {
        Tache tache = Tache.find.byId(idTache);
        List<Tache> listSuccesseur = Tache.find.where().le("dateDebut",tache.dateFinTard).findList();
        //parents direct à supprimmer
        return ok(Json.toJson(tache.getAllTacheNonParentsDirects(listSuccesseur)));
    }

    public Result getAllPredecesseursPossible(Long idTache)
    {
        Tache tache = Tache.find.byId(idTache);
        List<Tache> listPredecesseurs = Tache.find.where().ge("dateFinTard",tache.dateDebut).findList();

        return ok(Json.toJson(tache.getAllTacheNonParentsDirects(listPredecesseurs)));
    }
}

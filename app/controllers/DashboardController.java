package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
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
        Tache t = Tache.find.byId(idTache);
        //Logger.debug(t.toString());
        JsonNode node = Json.toJson(t);
        ObjectNode o = (ObjectNode) node;

        if(t.predecesseur!=null){
            //Logger.debug("Predecesseur : "+t.predecesseur);
            o.put("predecesseurNom",t.predecesseur.nom);
            o.put("predecesseurId",t.predecesseur.id);
        }
        return ok(o);
    }

}

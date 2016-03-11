package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import models.Contact;
import models.Projet;
import models.Tache;
import models.Utilisateur;
import controllers.Utils.Utils;
import play.Logger;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.dashboard;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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
            o.put("predecesseurIdTache",t.predecesseur.idTache);
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

    public Result getAllTasks(Long idTache){
        Tache tache = Tache.find.byId(idTache);
        List<Tache> listTachesPossible = Tache.find.where().eq("projet",tache.projet).eq("archive", false).findList();

        return ok(Json.toJson(listTachesPossible));
    }

    public Result getAllPredecesseursPossible(Long idTache)
    {
        Tache tache = Tache.find.byId(idTache);
        List<Tache> listPredecesseurs = Tache.find.where().eq("projet",tache.projet).eq("archive", false).le("dateFinTard",tache.dateDebut).findList();

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
        Logger.debug("modifierTache");
        Map<String, String[]> map = request().body().asFormUrlEncoded();

        return modifierTacheMap(map);
    }

    public static Result modifierTacheMap(Map<String,String[]> map){
        for (Map.Entry<String, String[]> entry : map.entrySet()) {
            Logger.debug("Key : " + entry.getKey() + " Value : " + entry.getValue()[0]);
        }
        try {
            boolean modifierAvancement = false;
            boolean modifierTache = false;
            boolean modifierResponsableTache = false;

            Long idTache = Long.parseLong(map.get("id-tache")[0].trim());
            Tache tache = Tache.find.byId(idTache);

            String newNomTache = "";
            if(map.containsKey("form-modif-tache-nom")) {
                newNomTache = map.get("form-modif-tache-nom")[0].trim();
                if (newNomTache.isEmpty()) {
                    return badRequest();
                }
                tache.nom = newNomTache;
            }

            String newDescTache = "";
            if(map.containsKey("form-modif-tache-desc")) {
                newDescTache = map.get("form-modif-tache-desc")[0].trim();
                tache.description = newDescTache;
            }

            Double newChInitiale = null;
            Double newChConso = null;
            Double newChRestante = null;

            if(tache.disponible) {
                if(map.containsKey("form-modif-tache-ch-init")) {
                    newChInitiale = Double.parseDouble(map.get("form-modif-tache-ch-init")[0].trim());
                    newChConso = Double.parseDouble(map.get("form-modif-tache-ch-cons")[0].trim());
                    newChRestante = Double.parseDouble(map.get("form-modif-tache-ch-rest")[0].trim());
                    if (newChInitiale == 0) {
                        return badRequest();
                    }
                }
            }

            Tache newPredecesseur = null;
            if(map.containsKey("predecesseur")) {
                String idPredecesseur = map.get("predecesseur")[0].trim();

                if (!idPredecesseur.equals("")) {
                    newPredecesseur = Tache.find.byId(Long.parseLong(idPredecesseur));
                }
            }

            Utilisateur newResponsable = null;
            if(map.containsKey("responsable")) {
                newResponsable = Utilisateur.find.byId(Long.parseLong(map.get("responsable")[0].trim()));
            }

            Date newDebut = null;
            Date newFinTot = null;
            Date newFinTard = null;
            if(map.containsKey("DD-modifier")) {
                String dateDebut = map.get("DD-modifier")[0].trim();
                String dateFinProche = map.get("DFTO-modifier")[0].trim();
                String dateFinTard = map.get("DFTA-modifier")[0].trim();
                if (dateDebut.isEmpty() || dateFinProche.isEmpty() || dateFinTard.isEmpty()) {
                    return null;
                }
                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

                try {
                    newDebut = formatter.parse(dateDebut);
                    newFinTot = formatter.parse(dateFinProche);
                    newFinTard = formatter.parse(dateFinTard);
                    boolean correct = false;
                    if (Utils.after(newFinTot, newDebut) || Utils.equals(newFinTot, newDebut)) {
                        if (Utils.after(newFinTard, newFinTot) || Utils.equals(newFinTard, newFinTot)) {
                            correct = true;
                        } else {
                            return badRequest();
                        }
                    } else {
                        return badRequest();
                    }
                } catch (ParseException e) {
                    return badRequest();
                }
            }

            //Successeurs
            List<Tache> successeurs = new ArrayList<>();
            if(map.containsKey("successeurs")) {
                String[] tabSucc = map.get("successeurs")[0].split(",");
                for (String idSucc : tabSucc) {
                    if (!idSucc.equals("")) {
                        successeurs.add(Tache.find.byId(Long.parseLong(idSucc)));
                    }
                }
            }
            //interlocuteurs
            List<Contact> interlocuteurs = new ArrayList<>();
            if(map.containsKey("interlocuteurs")) {
                String[] tabInterlocuteurs = map.get("interlocuteurs")[0].split(",");
                for (String idContact : tabInterlocuteurs) {
                    if (!idContact.equals("undefined") && !idContact.equals("")) {
                        interlocuteurs.add(Contact.find.byId(Long.parseLong(idContact)));
                    }
                }
            }

            tache.update();

            if(map.containsKey("form-modif-tache-ch-init")) {
                if (tache.disponible && (tache.chargeConsommee != newChConso || tache.chargeRestante != newChRestante)) {
                    Logger.debug(tache.toString());
                    modifierAvancement = true;
                    tache.chargeInitiale = newChInitiale;
                    tache.modifierCharge(newChConso, newChRestante);
                }
            }

            if(map.containsKey("predecesseur")) {
                if (newPredecesseur != null && (tache.predecesseur == null || !tache.predecesseur.equals(newPredecesseur))) {
                    newPredecesseur.associerSuccesseur(tache);
                    if (newPredecesseur.getAvancementTache() == 1.0) {
                        tache.disponible = true;
                    } else {
                        tache.disponible = false;
                    }
                }
            }

            Utilisateur ancienResponsable = tache.responsableTache;
            if(map.containsKey("responsable")) {
                if (newResponsable != null && !tache.responsableTache.equals(newResponsable)) {
                    modifierResponsableTache = true;
                    tache.modifierResponsable(newResponsable);
                }
            }

            if(map.containsKey("successeurs")) {
                tache.supprimerSuccesseurs();
                for (Tache succ : successeurs) {
                    tache.associerSuccesseur(succ);
                }
            }

            if(map.containsKey("interlocuteurs")) {
                tache.supprimerInterlocuteurs();
                for (Contact inter : interlocuteurs) {
                    tache.associerInterlocuteur(inter);
                }
            }

            if(tache.predecesseur == null){
                tache.disponible = true;
                tache.update();
            }
            if(tache.hasSuccesseur()){
                if(tache.getAvancementTache() == 1.0) {
                    for (int i = 0; i < tache.successeurs.size(); i++) {
                        tache.successeurs.get(i).disponible = true;
                        tache.update();
                    }
                }
                else{
                    for (int i = 0; i < tache.successeurs.size(); i++) {
                        tache.successeurs.get(i).disponible = false;
                        tache.update();
                    }
                }
            }

            if(map.containsKey("DD-modifier")) {
                if (!tache.dateDebut.equals(newDebut) || !tache.dateFinTot.equals(newFinTot) || !tache.dateFinTard.equals(newFinTard))
                    modifierTache = true;
                tache.dateDebut = newDebut;
                tache.dateFinTot = newFinTot;
                tache.dateFinTard = newFinTard;
                tache.update();
            }

            Tache t = Tache.find.byId(tache.id);
            Logger.debug(t.toString());
            Logger.debug("SAVE OK");
            tache.saveAllTask();

            Utilisateur currentUser = Login.getUtilisateurConnecte();
            if(modifierResponsableTache){
                currentUser.createNotificationModifierResponsableTache(tache, ancienResponsable);
                currentUser.save();
            } else if(modifierTache){
                currentUser.createNotificationModifierTache(tache);
                currentUser.save();
            } else if(modifierAvancement){
                currentUser.createNotificationModifierAvancementTache(tache);
                currentUser.save();
            }
            return ok();
        }catch(Exception e){
            e.printStackTrace();
            return badRequest(e.getMessage());
        }
    }

}

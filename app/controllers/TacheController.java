package controllers;

import models.*;
import models.Utils.Utils;
import play.Logger;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by Guillaume on 05/03/2016.
 */
public class TacheController  extends Controller {

    public Result getTacheById(Long id){
        return ok(Json.toJson(Tache.find.byId(id)));
    }

    public Result creerSousTache(Long idTacheMere){
        Map<String, String[]> form = request().body().asFormUrlEncoded();

        Tache mere = Tache.find.byId(idTacheMere);
        Projet projet = mere.projet;

        Tache newTache = creeTacheExtractDonneesFormulaire(form);

        //newTache.niveau = mere.niveau+1;
        //newTache.critique = false;
        //newTache.projet = mere.projet;
        //newTache.update();

        try {
            projet.creerSousTache(newTache , mere);
            Utilisateur currentUser = Login.getUtilisateurConnecte();
            currentUser.createNotificationCreerTache(newTache);
            currentUser.save();
        } catch (Exception e) {
            Logger.debug("Affichage de l'exception : ");
            e.printStackTrace();
            //System.out.println("--> " + e.getMessage());
            return badRequest(/*e.getMessage()*/);
        }
        return ok();
    }

    public Result creerTacheHaut(Long idTacheSelect){
        Map<String, String[]> form = request().body().asFormUrlEncoded();

        Tache tacheReference = Tache.find.byId(idTacheSelect);
        Projet projet = tacheReference.projet;

        Tache newTache = creeTacheExtractDonneesFormulaire(form);

        try {
            projet.creerTacheAuDessus(newTache , tacheReference);
            Utilisateur currentUser = Login.getUtilisateurConnecte();
            currentUser.createNotificationCreerTache(newTache);
            currentUser.save();
        } catch (Exception e) {
            Logger.debug("Affichage de l'exception : ");
            e.printStackTrace();
            return badRequest();
        }
        return ok();
    }

    public Result creerTacheBas(Long idTacheSelect){
        Map<String, String[]> form = request().body().asFormUrlEncoded();

        Tache tacheReference = Tache.find.byId(idTacheSelect);
        Projet projet = tacheReference.projet;

        Tache newTache = creeTacheExtractDonneesFormulaire(form);
        try {
            projet.creerTacheEnDessous(newTache , tacheReference);
            Utilisateur currentUser = Login.getUtilisateurConnecte();
            currentUser.createNotificationCreerTache(newTache);
            currentUser.save();
        } catch (Exception e) {
            Logger.debug("Affichage de l'exception : ");
            e.printStackTrace();
            return badRequest();        }
        return ok();
    }

    public Tache creeTacheExtractDonneesFormulaire(Map<String,String[]> map){
        Tache newTache = new Tache();
        for (Map.Entry<String, String[]> entry : map.entrySet()) {
            Logger.debug("Key : " + entry.getKey() + " Value : " + entry.getValue()[0]);
        }
        String newNomTache = map.get("form-modif-tache-nomC")[0];
        String newDescTache = map.get("form-modif-tache-descC")[0];

        Double newChInitiale = Double.parseDouble(map.get("form-modif-tache-ch-initC")[0]);
        Double newChConso = Double.parseDouble(map.get("form-modif-tache-ch-consC")[0]);
        Double newChRestante = Double.parseDouble(map.get("form-modif-tache-ch-restC")[0]);

        String idPredecesseur = map.get("predecesseurC")[0];

        Tache newPredecesseur = null;
        if(!idPredecesseur.equals("")) {
            newPredecesseur = Tache.find.byId(Long.parseLong(idPredecesseur));
        }
        Utilisateur newResponsable = Utilisateur.find.byId(Long.parseLong(map.get("responsableC")[0]));

        String[] dateDebut = map.get("DD-modifierC")[0].split("/");
        Date newDebut = Utils.getDateFrom(Integer.parseInt(dateDebut[2]), Integer.parseInt(dateDebut[1]), Integer.parseInt(dateDebut[0]));

        String[] dateFinProche = map.get("DFTO-modifierC")[0].split("/");
        Date newFinTot = Utils.getDateFrom(Integer.parseInt(dateFinProche[2]), Integer.parseInt(dateFinProche[1]), Integer.parseInt(dateFinProche[0]));

        String[] dateFinTard = map.get("DFTA-modifierC")[0].split("/");
        Date newFinTard = Utils.getDateFrom(Integer.parseInt(dateFinTard[2]), Integer.parseInt(dateFinTard[1]), Integer.parseInt(dateFinTard[0]));

        //Successeurs
        List<Tache> successeurs = new ArrayList<>();
        String[] tabSucc = map.get("successeursC")[0].split(",");
        for(String idSucc : tabSucc){
            if(!idSucc.equals("")){
                successeurs.add(Tache.find.byId(Long.parseLong(idSucc)));
            }
        }
        //interlocuteurs
        List<Contact> interlocuteurs = new ArrayList<>();
        String[] tabInterlocuteurs = map.get("interlocuteursC")[0].split(",");
        for(String idContact : tabInterlocuteurs){
            if(!idContact.equals("undefined") && !idContact.equals("")){
                interlocuteurs.add(Contact.find.byId(Long.parseLong(idContact)));
            }
        }

        newTache.nom = newNomTache;
        newTache.description = newDescTache;
        //newTache.save();
        newTache.chargeInitiale = newChInitiale;
        newTache.chargeConsommee = newChConso;
        newTache.chargeRestante = newChRestante;

        if(!idPredecesseur.equals("") && newPredecesseur != null) {
            newPredecesseur.associerSuccesseur(newTache);
        }

        if (newResponsable != null) {
            newTache.associerResponsable(newResponsable);
        }

        for(Tache succ : successeurs){
            newTache.associerSuccesseur(succ);
        }

        for(Contact inter : interlocuteurs){
            newTache.associerInterlocuteur(inter);
        }

        newTache.dateDebut = newDebut;
        newTache.dateFinTot = newFinTot;
        newTache.dateFinTard = newFinTard;
        //newTache.update();

        return newTache;
    }
}

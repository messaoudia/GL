package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.collect.ImmutableMap;
import models.*;
import models.Error;
import models.Utils.Utils;
import play.Logger;
import play.db.ebean.Transactional;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.afficheProjet;
import views.html.creerProjet;
import views.html.projet;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class ProjetController extends Controller {

    public Result afficherProjets() {
        return ok(projet.render("Projets", Login.getUtilisateurConnecte()));   // provisoir en attendant login
    }

    public Result afficherCreerProjet() {
        return ok(creerProjet.render("Créer Projet", Utilisateur.getAllNonArchives(), Client.getAllNonArchives()));
    }

    public Result afficherProjetsClient(long idClient) {
        Client client = Client.find.byId(idClient);
        Logger.debug("Projet Client ID : " + idClient);
        return ok(Json.toJson(models.Projet.find.where().eq("client", client).findList()));
    }

    public Result creerProjet() {
        Map<String, String[]> map = request().body().asFormUrlEncoded();
        boolean dateHere = false;
        Error error = new Error();
        String nom = map.get("nom")[0];
        if (nom.isEmpty()) {
            error.nomProjetVide = true;
        } else if (nom.length() > 30) {
            error.nomProjetTropLong = true;
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
        /*if (dateDeb.isEmpty()) {
            error.dateThDebutProjetVide = true;
        }
        if (dateFin.isEmpty()) {
            error.dateThFinProjetVide = true;
        }
        */
        if (description.length() > 65536) {
            error.descriptionTropLong = true;
        }

        if(dateDeb.isEmpty() && dateDeb.isEmpty()) {
            dateHere = false;
        }else if(!dateDeb.isEmpty() && !dateDeb.isEmpty()){
            dateHere = true;
        }else{
            error.saisir2Date = true;
        }

        if (error.hasErrorProjet()) {
            return badRequest(Json.toJson(error));
        } else {
            //TODO: check date en fonction de la langue && check si projet existe deja
            if(dateHere){
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
            else{
                Projet p = new Projet(nom, description, responsableProjet, null, null, unite, client, priorite);
                p.save();
                client.listeProjets.add(p);
                client.save();
                return ok(Json.toJson(p));
            }
        }
    }

    public Result updateTacheToIndisponible(Long idTache) {
        Tache t = Tache.find.byId(idTache);

        if (t == null) {
            return badRequest();
        }

        t.disponible = false;
        t.save();
        System.out.println("t est sav => indispo " + t);

        return ok();
    }

    public Result updateTacheToDisponible(Long idTache) {
        Tache t = Tache.find.byId(idTache);

        if (t == null) {
            return badRequest();
        }

        t.disponible = true;
        t.save();
        System.out.println("t est sav => dispo " + t);
        return ok();
    }

    public Result modifierProjet(Long id) {
        Projet p = Projet.find.byId(id);
        //check projet  -- nom + description
        Map<String, String[]> map = request().body().asFormUrlEncoded();
        Error error = new Error();
        String nom = map.get("projet")[0];
        if (nom.isEmpty()) {
            error.nomProjetVide = true;
        } else if (nom.length() > 30) {
            error.nomProjetTropLong = true;
        }
        String description = map.get("description")[0];
        if (description.length() > 65536) {
            error.descriptionTropLong = true;
        }
        Logger.debug(p.responsableProjet.nom + p.responsableProjet.prenom);
        if (error.hasErrorProjet()) {
            return badRequest(Json.toJson(error));
        } else {
            //modification des info si besoin
            int priorite = Integer.parseInt(map.get("priorite")[0]);
            //check priorite
            if (!p.nom.equals(nom)) {
                p.nom = nom;
            }
            if (p.priorite != priorite) {
                p.priorite = priorite;
            }
            //description
            if (!p.description.equals(description)) {
                //TODO : ajouter nouveau droit au respo projet + enlever droit à l'ancien
                p.description = description;
            }
            p.save();
            return ok(Json.toJson(p));
        }
    }


    @Transactional
    public Result sendDraf() {
        JsonNode jsonDraft = request().body().asJson();

        Logger.debug(jsonDraft.toString());


        Projet projet = parseDraftToProject(jsonDraft);
        //Logger.debug("BEFORE check Project ==============================> "+projet.listTaches.stream().filter(tache -> tache.id==21L).findFirst().get().enfants.size());


        final Map<String, String> errors = projet.checkProjet();

        //Logger.debug("AFTER check Project ==============================> "+projet.listTaches.stream().filter(tache -> tache.id==21L).findFirst().get().enfants.size());

        if (errors.isEmpty()) {
            for (int i = 0; i < projet.listTaches.size(); i++) {
                //Logger.debug(projet.listTaches.get(i).id + ", " + projet.listTaches.get(i).idTache + " -> " + projet.listTaches.get(i).niveau);

                Tache tache = projet.listTaches.get(i);
                Logger.debug(tache.id + ", " + tache.idTache + " -> " + tache.niveau + ", enfants: " + tache.enfants.size());

                //Logger.debug(" ================> "+projet.listTaches.stream().filter(tache1 -> tache1.id==21L).findFirst().get().enfants.size());

                tache.save();
                //List<Tache> enfants = tacheCourant.enfants;
                //for (int j = 0; j < enfants.size(); j++) {
                //    enfants.get(j).parent = projet.listTaches.get(i);
                //    enfants.get(j).save();
                //}
                //projet.listTaches.get(i).save();
                //dfsTache(projet.listTaches.get(i), projet.listTaches.get(i).parent);


            }
            // projet.save();

            for (int i = 0; i < projet.listTaches.size(); i++) {
                Tache tache = Tache.find.byId(projet.listTaches.get(i).id);
                Logger.debug(tache.id + ", " + tache.idTache + " -> " + tache.niveau);
            }
            return ok(jsonDraft.toString());
        } else {
            return badRequest(Json.toJson(ImmutableMap.of("errors", errors)));
        }

    }

    @Transactional
    public static void dfsTache(Tache currentTache, Tache tacheParent) {

        Logger.debug("======================================");
        final List<Tache> childrenTaches = currentTache.enfants;

        Logger.debug(currentTache.id + ", " + currentTache.idTache + " -> " + currentTache.niveau);
        Logger.debug("Childrens: ");
        childrenTaches.forEach(child -> {
            child.parent = currentTache;
            Logger.debug(child.id + ", idTache" + child.idTache);

            //child.save();
        });

        currentTache.parent = tacheParent;
        //currentTache.save();
        Logger.debug("======================================");

        for (int i = 0; i < childrenTaches.size(); i++) {
            dfsTache(childrenTaches.get(i), currentTache);
        }
    }

    @Transactional
    public static Projet parseDraftToProject(JsonNode draft) {
        Projet projet = Projet.find.byId(draft.get("projectId").asLong());

        final List<Long> tacheDuProjetIds = draft.findValues("id").stream().map(node -> node.asLong()).collect(Collectors.toList());
        final Map<Long, Tache> taches = Tache.find.where().idIn(tacheDuProjetIds).findList().stream().collect(Collectors.toMap(x -> x.id, Function.identity()));


        draft.get("taches").findValuesAsText("id").forEach(Logger::debug);

        projet.listTaches = taches.values().parallelStream().collect(Collectors.toList()); //TODO Bring all tache with inscestor

        final List<JsonNode> tachesNodes = elementsToStream(draft.get("taches").elements()).collect(Collectors.toList());

        Integer index = 1;
        for (JsonNode tacheNode : tachesNodes) {
            dfsTraversalJsNode(null, tacheNode, index++, taches);

            //Logger.debug("Index: " + index.toString() + ", tacheId: " + tacheNode.get("id"));
        }

        projet.listTaches = taches.values().stream().collect(Collectors.toList());


        return projet;
    }

    @Transactional
    public static void dfsTraversalJsNode(JsonNode parentTacheNode, JsonNode currentTacheNode, Integer index, Map<Long, Tache> taches) {
        //Logger.debug(" dfsTraversalJsNode ==============================> "+taches.get(21L).enfants.size());
        final Tache parentTache = parentTacheNode != null ? taches.get(parentTacheNode.get("id").asLong()) : null;
        final Tache currentTache = taches.get(currentTacheNode.get("id").asLong());

        final List<Tache> childrenTaches = elementsToStream(currentTacheNode.get("childrens").elements())
                .map(tache -> taches.get(tache.get("id").asLong()))
                .collect(Collectors.toList());

        if (parentTache == null) {
            currentTache.idTache = index.toString();
        }
        // TODO Assign children to parent and parent to children
        //currentTache.enfants = childrenTaches;
        childrenTaches.forEach(child -> {
            currentTache.enfants.add(child);
            child.parent = currentTache;
            //child.save();
            taches.put(child.id, child);
        });

        currentTache.parent = parentTache;
        currentTache.niveau = currentTacheNode.get("depth").asInt();
        //currentTache.save();
        taches.put(currentTache.id, currentTache);

        List<JsonNode> childrens = elementsToStream(currentTacheNode.get("childrens").elements()).collect(Collectors.toList());

        Integer indexEnfant = 1;
        for (int i = 0; i < childrens.size(); i++) {
            JsonNode children = childrens.get(0);
            Tache childrenTache = taches.get(children.get("id").asLong(0));
            childrenTache.idTache = currentTache.idTache + "." + (indexEnfant++);
            //childrenTache.update();
            taches.put(childrenTache.id, childrenTache);


            dfsTraversalJsNode(currentTacheNode, children, index, taches);
        }
    }

    public static Stream<JsonNode> elementsToStream(Iterator<JsonNode> iterator) {
        return StreamSupport.stream(Spliterators.spliteratorUnknownSize(iterator, /*Spliterator.DISTINCT | Spliterator.SORTED | */Spliterator.ORDERED), false).sorted(new Comparator<JsonNode>() {
            @Override
            public int compare(JsonNode o1, JsonNode o2) {
                return o1.get("index").asInt() - o2.get("index").asInt();
            }
        });
    }

    public Result afficheProjet(Long idProjet) {
        Logger.debug(Login.getUtilisateurConnecte().toString());
        return ok(afficheProjet.render(Projet.find.byId(idProjet), Login.getUtilisateurConnecte()));
    }

    public Result infoProjet(Long idProjet) {
        return ok(Json.toJson(Projet.find.byId(idProjet)));
    }
}

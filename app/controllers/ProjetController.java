package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import models.*;
import models.Error;
import models.Utils.Utils;
import play.Logger;
import play.db.ebean.Transactional;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.creerProjet;
import views.html.projet;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class ProjetController extends Controller {

    public Result afficherProjets() {
        return ok(projet.render("Projets", Utilisateur.getAllNonArchives().get(0)));   // provisoir en attendant login
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
        //TODO : description non obligatoire ?
        Map<String, String[]> map = request().body().asFormUrlEncoded();
        System.out.println(map);
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

    public Result sendDraf() {
        JsonNode jsonDraft = request().body().asJson();

        Logger.debug(jsonDraft.toString());

        parseDraftToProject(jsonDraft);

        return ok(jsonDraft.toString());
    }

    @Transactional
    public static Projet parseDraftToProject(JsonNode draft) {
        Projet projet = Projet.find.byId(draft.get("projectId").asLong());

        final List<Long> tacheDuProjetIds = elementsToStream(draft.get("taches").elements()).map(tache -> tache.get("id").asLong()).collect(Collectors.toList());
        final List<Tache> taches = Tache.find.where().idIn(tacheDuProjetIds).findList();


        draft.get("taches").findValuesAsText("id").forEach(Logger::debug);

        projet.listTaches = taches; //TODO Bring all tache with inscestor
        projet.save();

        final List<JsonNode> tachesNodes = elementsToStream(draft.get("taches").elements()).collect(Collectors.toList());
        draft.get("taches").elements();
        Integer index = 1;
        for (JsonNode tacheNode : tachesNodes) {
            dfsTraversalJsNode(null, tacheNode, index++);
            Logger.debug("Index: " + index.toString() + ", tacheId: " + tacheNode.get("id"));
        }


        return projet;
    }

    @Transactional
    public static void dfsTraversalJsNode(JsonNode parentTacheNode, JsonNode currentTacheNode, Integer index) {
        final Tache parentTache = parentTacheNode != null ? Tache.find.byId(parentTacheNode.get("id").asLong()) : null;
        final Tache currentTache = Tache.find.byId(currentTacheNode.get("id").asLong());

        final List<Tache> childrenTaches = elementsToStream(currentTacheNode.get("childrens")
                .elements()).map(tache -> Tache.find.byId(tache.get("id").asLong())).collect(Collectors.toList());

        if (parentTache == null) {
            currentTache.idTache = index.toString();
        } else {

        }

        // TODO Assign children to parent and parent to children
        currentTache.enfants = childrenTaches;
        currentTache.parent = parentTache;
        currentTache.update();

        //final Long parentId = parentTacheNode == null ? null : parentTacheNode.get("id").asLong();
        //final Long currentId = currentTacheNode == null ? null : currentTacheNode.get("id").asLong();
        //Logger.debug(currentId + " , parent: " + parentId);


        //Iterator<JsonNode> childrenIterator = currentTacheNode.get("childrens").elements();
        List<JsonNode> childrens = elementsToStream(currentTacheNode.get("childrens").elements()).collect(Collectors.toList());

        Integer indexEnfant = 1;
        for (int i = 0; i < childrens.size(); i++) {
            JsonNode children = childrens.get(0);
            Tache childrenTache = Tache.find.byId(children.get("id").asLong(0));
            childrenTache.idTache = currentTache.idTache + "." + (indexEnfant++);
            childrenTache.update();

            dfsTraversalJsNode(currentTacheNode, children, index);
        }
        //while (childrenIterator.hasNext()) {
        //
        //    JsonNode children = childrenIterator.next();
        //    Tache childrenTache = Tache.find.byId(children.get("id").asLong(0));
        //    childrenTache.idTache = currentTache.idTache + "." + (indexEnfant++);
        //    childrenTache.update();
        //
        //    dfsTraversalJsNode(currentTacheNode, children, index);
        //}

    }

    public static Stream<JsonNode> elementsToStream(Iterator<JsonNode> iterator) {
        return StreamSupport.stream(Spliterators.spliteratorUnknownSize(iterator, /*Spliterator.DISTINCT | Spliterator.SORTED | */Spliterator.ORDERED), false).sorted(new Comparator<JsonNode>() {
            @Override
            public int compare(JsonNode o1, JsonNode o2) {
                return o1.get("index").asInt() - o2.get("index").asInt();
            }
        });
    }

}

package controllers.Global;

import com.avaje.ebean.Ebean;
import models.*;
import play.GlobalSettings;
import play.Logger;
import play.api.mvc.RequestHeader;
import play.libs.F;
import play.libs.Yaml;
import play.mvc.Action;
import play.mvc.Http;
import play.mvc.Result;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

/**
 * Created by Guillaume on 05/02/2016.
 */

public class Global extends GlobalSettings {

    @Override
    public Action onRequest(Http.Request request, Method actionMethod) {
        Logger.info("Request Received : " + request.uri());
        return super.onRequest(request, actionMethod);
    }

    @Override
    public void onStart(play.Application app) {
        Logger.info("Application has started");
        // Check if the database is empty
        if (Utilisateur.find.findRowCount() == 0) {
            //Ebean.save((List) Yaml.load("initial-data.yml"));

            Map<String, List<Object>> all = (Map<String, List<Object>>) Yaml.load("initial-data.yml");

            /* display file content */
            /*Logger.debug(all.get("adresses").toString());
            Logger.debug(all.get("contacts").toString());
            Logger.debug(all.get("clients").toString());
            Logger.debug(all.get("utilisateurs").toString());
            Logger.debug(all.get("projets").toString());
            Logger.debug(all.get("taches").toString());*/

            /* add elements to DB */
            all.forEach((key, value) -> Ebean.save(value));

            /* display DB content */
            /*Logger.debug(String.valueOf(Adresse.find.all()));
            Logger.debug(String.valueOf(Contact.find.all()));
            Logger.debug(String.valueOf(Client.find.all()));
            Logger.debug(String.valueOf(Projet.find.all()));
            Logger.debug(String.valueOf(Tache.find.byId(16L)));
            Logger.debug(String.valueOf(Utilisateur.find.byId(11L)));
            Logger.debug(String.valueOf(Utilisateur.find.byId(12L)));
            Logger.debug(String.valueOf(Utilisateur.find.byId(13L)));
            Logger.debug(String.valueOf(Utilisateur.find.byId(14L)));
            Tache t = Utilisateur.find.byId(12L).listTachesResponsable().get(0);*/

        }
    }

}
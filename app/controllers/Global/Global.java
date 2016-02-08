package controllers.Global;

import com.avaje.ebean.Ebean;
import models.Client;
import models.Utilisateur;
import play.GlobalSettings;
import play.Logger;
import play.libs.Yaml;

import java.util.List;
import java.util.Map;

/**
 * Created by Guillaume on 05/02/2016.
 */

public class Global extends GlobalSettings {

    @Override
    public void onStart(play.Application app) {
        Logger.info("Application has started");
        // Check if the database is empty
        if (Utilisateur.find.findRowCount() == 0) {
            //Ebean.save((List) Yaml.load("initial-data.yml"));
            Map<String, List<Object>> all = (Map<String, List<Object>>) Yaml.load("initial-data.yml");
            System.out.println(all);

            Ebean.save(all.get("adresses"));
            Ebean.save(all.get("contacts"));
            Ebean.save(all.get("clients"));
            Ebean.save(all.get("utilisateurs"));
            Ebean.save(all.get("projets"));
            Ebean.save(all.get("taches"));


            /*all.forEach((key, value) -> {
                Ebean.save(value);
            });*/

            Logger.debug(String.valueOf(Client.find.all()));
            Logger.debug(String.valueOf(Utilisateur.find.all()));
        }
    }

}
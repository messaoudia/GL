package controllers;

import models.Projet;
import play.*;
import play.libs.*;
import com.avaje.ebean.Ebean;
import models.*;
import java.util.*;

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
            List<Object> all = (List<Object>)Yaml.load("initial-data.yml");
            System.out.println(all);
            Ebean.save(all);

            Logger.debug(String.valueOf(Client.find.all()));
            Logger.debug(String.valueOf(Utilisateur.find.all()));
        }
    }

}
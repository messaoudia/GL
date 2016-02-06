package controllers;

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
            Map<String,List<Object>> all = (Map<String,List<Object>>)Yaml.load("initial-data.yml");

            for (Map.Entry<String, List<Object>> entry : all.entrySet()){
                Ebean.save(entry.getValue());
            }
        }
        System.out.println(Utilisateur.find.all());
    }

}
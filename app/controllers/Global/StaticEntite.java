package controllers.Global;

import models.EntiteGenerique;

/**
 * Created by yachironi on 24/02/16.
 */
public class StaticEntite {

    private static EntiteGenerique system = EntiteGenerique.find.where().eq("nom", "system").findUnique();

    // Singleton
    private StaticEntite() {
    }

    public static EntiteGenerique getSystem() {
        return system;
    }
}

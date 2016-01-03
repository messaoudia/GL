package controllers;

import play.mvc.Result;
import views.html.projet;

/**
 * Created by yachironi on 30/12/15.
 */
public class Projet extends play.mvc.Controller {

    public Result index() {
        return ok(projet.render());
    }
}

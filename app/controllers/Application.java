package controllers;

import play.*;
import play.mvc.*;

import views.html.*;

public class Application extends Controller {

	// Allez l'OM con
    public Result index() {
        // test - yasser
        return ok(index.render("Projet GL - ET5"));
    }

}

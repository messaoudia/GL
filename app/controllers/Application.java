package controllers;

import play.*;
import play.mvc.*;

import views.html.*;

public class Application extends Controller {

	// Allez Paris by Amin
    public Result index() {
        return ok(index.render("Projet GL - ET5"));
    }

}

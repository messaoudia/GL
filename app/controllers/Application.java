package controllers;

import play.*;
import play.mvc.*;

import views.html.*;

public class Application extends Controller {

    public Result index() {
        //testZheng
	return ok(index.render("Projet GL - ET5"));
	
    }

}

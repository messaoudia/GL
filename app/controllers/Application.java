package controllers;

import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;

public class Application extends Controller {

    public Result logout() {
        session().clear();
        flash("success", "You've been logged out");
        return ok();
    }

    public Result index() {
        return ok(index.render("Pear project manager"));
    }


}

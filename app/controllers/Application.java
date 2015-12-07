package controllers;

import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;

public class Application extends Controller {

    public Result indexGishan(String param) {
        return ok(index.render(param));
    }

    public Result index() {
        return ok(index.render("Pear project manager"));
    }

}

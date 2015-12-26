package controllers;

import models.User;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;

public class Login extends Controller {

    private final static Form<User> loginForm = new Form<User>(User.class);

    public Result authenticate() {
        Form<User> form = loginForm.bindFromRequest();

        if (form.hasErrors()) {
            return badRequest(views.html.login.render(form));
        } else {
            session().clear();
            session("email", form.get().getEmail());
            System.out.println(form.get().getEmail() + " -> " + form.get().getPassword());
            return redirect(routes.Application.index());
        }
    }

    public Result index() {
        return ok(views.html.login.render(loginForm));
    }
}

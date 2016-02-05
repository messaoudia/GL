package controllers;

import models.Utilisateur;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.login;

/**
 * This class is for tests purpose only !!!
 */
public class Login extends Controller {

    private final static Form<Utilisateur> loginForm = new Form<Utilisateur>(Utilisateur.class);

    /**
     * This method receive an implicit POST requests, treat them by validating
     * the request content, Here we bind the request from:
     * 'key1=value1&key2=value2&keyX=valueX' into a JAVA object
     * if the binding goes well and the data is conform to the JAVA model specification (exp: required field, length...)
     * then the action specified in the controller will be done, otherwise a badRequest (40X HTTP response will be sent)
     *
     * @return
     */
    public Result authenticate() {
        Form<Utilisateur> form = loginForm.bindFromRequest();
        if (form.hasErrors()) {
            return badRequest(login.render(form));
        } else {
            session().clear();
            session("email", form.get().getEmail());
            System.out.println(form.get().getEmail() + " -> " + form.get().getPassword());
            return redirect(routes.Application.index());
        }
    }

    /**
     * Render the login page with the initial form content from (loginForm)
     * in case
     *
     * @return The login.scala.html rendered
     */
    public Result index() {
        return ok(views.html.login.render(loginForm));
    }
}

package controllers;

import models.Utilisateur;
import play.Logger;
import play.Routes;
import play.api.i18n.Lang;
import play.i18n.Messages;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.dashboard;
import views.html.draftTest;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;
import java.util.stream.Collectors;

import static org.reflections.ReflectionUtils.getAllMethods;
import static org.reflections.ReflectionUtils.withReturnType;

public class Application extends Controller {

    public Result logout() {
        session().clear();
        return redirect(routes.Login.index());
    }

    /**
     * This method render the index.scala.html template
     *
     * @return A rendered HTML view
     */
    public Result index() {
        // return ok(dashboard.render("Dashboard", Utilisateur.getAllNonArchives().get(0)));
        //  String user = session("connected");
        if (Login.isUtilisateurConnecte()) {
            return ok(dashboard.render("Dashboard", Login.getUtilisateurConnecte()));
        } else {
            return redirect(routes.Login.index());
        }
    }


    /**
     * This method use java retrospecting to list all the controllers in the projects
     * and expose them all as Javascript methods in order to facilitate the ajax calls
     * <p>
     * PLEASE DO NOT TOUCHE THIS METHOD !!!
     *
     * @return A wierd javascript function, not readable humanly
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     */
    public Result javascriptRoutes() throws IllegalAccessException, InvocationTargetException {
        // use reflection to get the fields of controllers.routes.javascript and other controller packages
        Set<Object> reverseRoutes = new HashSet<Object>();
        Class[] routeClasses = {controllers.routes.javascript.class, routes.Tests.getClass()};
        for (int i = 0; i < routeClasses.length; i++) {
            for (Field f : routeClasses[i].getFields()) {
                // get its methods
                for (Method m : getAllMethods(f.getType(), withReturnType(play.api.routing.JavaScriptReverseRoute.class))) {
                    // for each method, add its result to the reverseRoutes
                    reverseRoutes.add(m.invoke(f.get(null)));
                }
            }
        }
        // return the reverse routes
        response().setContentType("text/javascript");
        return ok(Routes.javascriptRouter("jsRoutes",
                reverseRoutes.toArray(new play.api.routing.JavaScriptReverseRoute[reverseRoutes.size()])));
    }

    public Result changeLanguage() {
        final String language = request().body().asFormUrlEncoded().get("language")[0];
        if (language != null && !language.isEmpty()) {
            ctx().changeLang(language);
        } else {
            ctx().changeLang(Lang.apply$default$2());
        }
        return redirect(request().body().asFormUrlEncoded().get("return_url")[0]);
    }

    public Result changeLangue(String lang) {
        Utilisateur utilisateurConnecte = Login.getUtilisateurConnecte();
        utilisateurConnecte.langue = lang;
        utilisateurConnecte.update();
        Controller.changeLang(lang);
        Logger.debug("Language changed to: " + lang);
        return redirect(request().getHeader("referer"));
    }

    public Result getLangue() {
        return ok(Login.getUtilisateurConnecte().langue);
    }

    public Result getDraft() {
        return ok(draftTest.render());
    }

    public Result messages(String message) {
        if (Messages.isDefined(message)) {
            return ok(play.i18n.Messages.get(message));
        } else {
            return badRequest(message + " -> message indefined");
        }
    }

    public Result messagesMap() {
        try {
            final Properties config = new Properties();
            config.load(play.Play.application().resourceAsStream("messages." + ctx().lang().code())); //example input stream
            return ok(Json.toJson(config.stringPropertyNames().stream().collect(Collectors.toMap(key -> key, key -> Messages.get(key)))));
        } catch (Exception e) {
            return badRequest();
        }
    }

}

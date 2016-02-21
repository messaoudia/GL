package controllers;

import play.Logger;
import play.Routes;
import play.api.i18n.Lang;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.dashboard;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

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
        /* TODO : changer en dashboard " */
        return ok(dashboard.render("Pear project manager"));
        /*String user = session("connected");
        if (user != null) {
            return ok(index.render("Pear project manager"));
        } else {
            return redirect(routes.Login.index());
        }*/
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
        Controller.changeLang(lang);
        return redirect(request().getHeader("referer"));
    }

}

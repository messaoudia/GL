package controllers;

import models.Tache;
import play.data.Form;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.tests;

import static play.data.Form.form;

/**
 * Created by yachironi on 26/12/15.
 */
public class Tests extends Controller {

    public Result index() {
        return ok(tests.render(Tache.find.all()));
    }

    /**
     * Create a task in this project.
     */
    public Result add() {
        Form<Tache> taskForm = form(Tache.class).bindFromRequest();
        System.out.println(taskForm.get());

        if (taskForm.hasErrors()) {
            return badRequest();
        } else {
            Tache.create(taskForm.get());
            return ok(tests.render(Tache.find.all()));
        }

    }

    /**
     * Get all taches
     */
    public Result getAll() {
        return ok(Json.toJson(Tache.getAll()));
    }

    /**
     * Ajout de tache
     */
    // @BodyParser.Of(BodyParser.Json.class)
    public Result addTask() {
        Form<Tache> taskForm = form(Tache.class).bindFromRequest();
        System.out.println(taskForm.data());

        if (taskForm.hasErrors()) {
            return badRequest(taskForm.errorsAsJson());
        } else {
            return ok(Json.toJson(Tache.create(taskForm.get())));
        }
    }

}

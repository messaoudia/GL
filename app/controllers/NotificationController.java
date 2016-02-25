package controllers;

import models.Utilisateur;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.notifications;

public class NotificationController extends Controller {

    public Result afficherNotifications() {
        return ok(notifications.render("Notifications", Utilisateur.getAllNonArchives().get(0)));
    }
}

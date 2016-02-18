package controllers;

import play.mvc.Controller;
import play.mvc.Result;
import views.html.notifications;

public class ControllerNotification extends Controller {

    public Result afficherNotifications() {
        return ok(notifications.render("Notifications"));
    }
}

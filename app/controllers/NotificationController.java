package controllers;

import models.Notification;
import models.Tache;
import models.Utilisateur;
import play.Logger;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.notifications;

public class NotificationController extends Controller {

    public Result afficherNotifications() {
        return ok(notifications.render("Notifications", Login.getUtilisateurConnecte()));
    }

    /**
     * Utilisée dans les pages 'Dashboard', 'Projet' et 'Client' d'un collaborateur
     *
     * @param idTache
     * @param idUser
     * @return
     */
    public Result activerOuDesactiverNotificationTache(long idTache, long idUser) {
        Tache tache = Tache.find.byId((idTache));
        Utilisateur user = Utilisateur.find.byId((idUser));

        if (user.hasActiverNotification(tache)) {
            user.desactiverNotification(tache);
        } else {
            user.activerNotification(tache);
        }
        return ok();
    }

    public Result clickNotificationsLues(long idUser, String listIdNotif) {
        Utilisateur user = Utilisateur.find.byId(idUser);
        String[] listIdNotifParse = listIdNotif.split(",");
        for (String idNotifStr : listIdNotifParse) {
            long idNotif = Long.parseLong(idNotifStr);
            Notification notif = Notification.find.byId(idNotif);
            notif.etatLecture = true;
            notif.update();
        }
        user.listNotifications = user.listNotifications();
        user.update();
        return ok(user.nbNotificationsNonLues() + "");
    }

    public Result clickNotificationsSupprimer(long idUser, String listIdNotif) {
        Utilisateur user = Utilisateur.find.byId(idUser);
        String[] listIdNotifParse = listIdNotif.split(",");
        for (String idNotifStr : listIdNotifParse) {
            long idNotif = Long.parseLong(idNotifStr);
            Notification notif = Notification.find.byId(idNotif);
            if (user.listNotifications.contains(notif)) {
                user.listNotifications.remove(notif);
                Notification.find.deleteById(notif.id);
                user.update();
            }
        }
        user.listNotifications = user.listNotifications();
        user.update();
        return ok(user.nbNotificationsNonLues() + "");
    }

    public Result sendNotifications() {

        Logger.debug("Envoie notification...");
        Logger.debug("Utilisateur: "+Login.getUtilisateurConnecte());

        Login.getUtilisateurConnecte().sendNotifications();

        //if (request().body() != null) {
        //    Logger.error("Doeing the notification parsing...");
        //    Logger.debug("Notifications: " + request().body().asJson());
        //    return ok(request().body().asJson());
        //} else {
        //    Logger.error("Body of request is null");
        //    return badRequest(Json.toJson(ImmutableMap.of("error", "body is null")));
        //}
        return ok();
    }

}

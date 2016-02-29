package controllers;

import models.Tache;
import models.Utilisateur;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.notifications;

public class NotificationController extends Controller {

    public Result afficherNotifications() {
        return ok(notifications.render("Notifications", Utilisateur.getAllNonArchives().get(0)));
    }

    /**
     * Utilisée dans les pages 'Dashboard', 'Projet' et 'Client' d'un collaborateur
     * @param idTache
     * @param idUser
     * @return
     */
    public Result activerOuDesactiverNotificationTache(long idTache, long idUser){
        Tache tache = Tache.find.byId((idTache));
        Utilisateur user = Utilisateur.find.byId((idUser));

        if(user.hasActiverNotification(tache)){
            System.out.println("On desactive");
            user.desactiverNotification(tache);
        } else {
            System.out.println("On active");
            user.activerNotification(tache);
        }
        return ok();
    }

}

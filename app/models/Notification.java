package models;

import com.avaje.ebean.Model;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import controllers.Global.Mail;
import models.Utils.Utils;
import org.apache.commons.lang3.builder.ToStringBuilder;
import play.data.format.Formats;
import play.libs.mailer.Email;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.*;

/**
 * Created by Guillaume on 25/01/2016.
 */
@Entity
@Table
public class Notification extends Model {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public String title;
    public String contentNotification;

    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern="dd/MM/yyyy")
    @Formats.DateTime(pattern = "dd/MM/yyyy")
    public Date dateEnvoi;
    public Boolean etatLecture;
    public Boolean archiver;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    @JsonIgnore
    public Utilisateur utilisateur;

    public static Model.Finder<Long, Notification> find = new Model.Finder<>(Notification.class);

    public Notification(String title, String contentNotification, Date dateEnvoi, Boolean etatLecture, Boolean archiver, Utilisateur utilisateur) {
        this.title = title;
        this.contentNotification = contentNotification;
        this.dateEnvoi = dateEnvoi;
        this.etatLecture = etatLecture;
        this.archiver = archiver;
        this.utilisateur = utilisateur;
    }

    public Notification() {
    }

    @Override
    public String toString() {
        return "[Notification : " + id + "] : " +
                title + ", " + dateEnvoi + ", etatLecture " + etatLecture +
                ", archiver " + archiver +
                ", contentNotification \n" + contentNotification + "\n";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        try {
            Notification notification = (Notification) obj;
            return (notification.id.equals(this.id) && notification.title.equals(this.title) &&
                    //notification.dateEnvoi.equals(this.dateEnvoi) &&
                    Utils.equals(notification.dateEnvoi, this.dateEnvoi) &&
                    notification.etatLecture.equals(this.etatLecture) &&
                    notification.archiver.equals(this.archiver) &&
                    notification.contentNotification.equals(this.contentNotification));
        } catch (ClassCastException e) {
            return false;
        }
    }

    /**
     * Envoie les notifications aux utilisateurs
     * @param mapNotifications
     */
    public static void sendNotifications(Map<Utilisateur, Notification> mapNotifications){
        for(Map.Entry<Utilisateur, Notification> entry : mapNotifications.entrySet()){
            Utilisateur user = entry.getKey();
            Notification notification = entry.getValue();
            notification.save();
            user.addNotification(notification);
            user.update();
            sendEmail(user, notification);
        }
    }

    /**
     * Envoie la notification à l'utilisateur par e-mail
     * @param user
     * @param notification
     */
    private static void sendEmail(Utilisateur user, Notification notification){
        final Email email = new Email();
        email.setSubject(notification.title);
        email.setFrom("NE-PAS-REPONDRE <myproject.polytechparissud@gmail.com>");
        email.addTo(user.prenom + " " + user.nom + "\"" +user.prenom + " " + user.nom +" <" + user.email + ">\"");
        email.setBodyHtml(notification.contentNotification);
        Mail.sendEmail(email);
    }

    /**
     * Envoie une notification à tous les utilisateurs associés à la tache passé en paramètre
     * L'utilisateur passé en paramètre est l'utilisateur qui a modifié l'avancement de la tâche
     *
     * Si la modification de l'avancement entraîne un changement d'état d'une tâche (disponible/indisponible),
     * une notification est aussi envoyée (notifications groupées)
     *
     * TODO ZHENG => verifier sur pageweb
     * @param tache
     * @param utilisateur
     */
    public static void sendNotificationModificationAvancementTache(Tache tache, Utilisateur utilisateur) {
        String uniteFR, uniteEN;
        if (tache.projet.hasUniteJour()) {
            uniteFR = "jour(s)";
            uniteEN = "day(s)";
        } else {
            uniteFR = "semaine(s)";
            uniteEN = "week(s)";
        }

        String objetFR = "Modification de l'avancement de la tâche " + tache.nom;

        String messageFR = "L'utilisateur " + utilisateur.prenom + " " + utilisateur.nom + " a modifié l'avancement de la tâche "
                + tache.nom + " du projet " + tache.projet.nom + "(client : " + tache.projet.client.nom + ")\n";
        messageFR += "Le nouvel avancement de la tâche est de : " + tache.getAvancementTache() + "%\n";
        messageFR += "\t - Charge initiale : " + tache.chargeInitiale + " " + uniteFR + "\n";
        messageFR += "\t - Charge consommée : " + tache.chargeConsommee + " " + uniteFR + "\n";
        messageFR += "\t - Charge restante : " + tache.chargeRestante + " " + uniteFR + "\n";

        String objetEN = "Changing the task progress " + tache.nom;

        String messageEN = "User " + utilisateur.prenom + " " + utilisateur.nom + " has changed the progress of task "
                + tache.nom + " of project " + tache.projet.nom + "(client : " + tache.projet.client.nom + ")\n";
        messageEN += "The new task progress is : " + tache.getAvancementTache() + "%\n";
        messageEN += "\t - Initial workload : " + tache.chargeInitiale + " " + uniteEN + "\n";
        messageEN += "\t - Completed workload : " + tache.chargeConsommee + " " + uniteEN + "\n";
        messageEN += "\t - Remaining workload : " + tache.chargeRestante + " " + uniteEN + "\n";

        Map<Utilisateur, Notification> mapNotifications = new HashMap<Utilisateur, Notification>();
        String objet = "";
        String message = "";
        for (Utilisateur userANotifier : tache.utilisateursNotifications) {
            if (userANotifier.langue.equals(Utilisateur.LANGUE_FR)) {
                objet = objetFR;
                message = messageFR;
            } else if (userANotifier.langue.equals(Utilisateur.LANGUE_EN)) {
                objet = objetEN;
                message = messageEN;
            }
            if(!mapNotifications.containsKey(userANotifier)){
                mapNotifications.put(userANotifier, new Notification(objet, message, Calendar.getInstance().getTime(), false, false, userANotifier));
            }
        }
        // Envoie des notifications aux utilisateurs qui ont une nouvelle tache disponible suite à la modification
        // de l'avancement de cette tâche
        sendNotificationTachesDisponibles(tache, mapNotifications);

        // Envoie des notifications
        sendNotifications(mapNotifications);
    }

    /**
     * Envoie une notification à tous les utilisateurs associés à la tache passé en paramètre
     * L'utilisateur passé en paramètre est l'utilisateur qui a modifié la tâche
     * TODO ZHENG => verifier sur pageweb
     * @param tache
     * @param utilisateur
     */
    public static void sendNotificationModificationTache(Tache tache, Utilisateur utilisateur) {
        String uniteFR, uniteEN;
        if (tache.projet.hasUniteJour()) {
            uniteFR = "jour(s)";
            uniteEN = "day(s)";
        } else {
            uniteFR = "semaine(s)";
            uniteEN = "week(s)";
        }

        String objetFR = "Modification de la tâche " + tache.nom;

        String messageFR = "L'utilisateur " + utilisateur.prenom + " " + utilisateur.nom + " a modifié la tâche "
                + tache.nom + " du projet " + tache.projet.nom + "(client : " + tache.projet.client.nom + ")\n";
        messageFR += "Responsable : " + tache.responsableTache.prenom + tache.responsableTache.nom + "(" + tache.responsableTache.email + ")\n";
        messageFR +="Dates de la tâche :\n";
        messageFR += "\t - Date de début : " + tache.formateDate(tache.dateDebut) + "\n";
        messageFR += "\t - Date d'échéance au plus tôt : " + tache.formateDate(tache.dateFinTot) + "\n";
        messageFR += "\t - Date d'échéance au plus tard : " + tache.formateDate(tache.dateFinTard) + "\n";
        messageFR += "Avancement de la tâche est de : " + tache.getAvancementTache() + "%\n";
        messageFR += "\t - Charge initiale : " + tache.chargeInitiale + " " + uniteFR + "\n";
        messageFR += "\t - Charge consommée : " + tache.chargeConsommee + " " + uniteFR + "\n";
        messageFR += "\t - Charge restante : " + tache.chargeRestante + " " + uniteFR + "\n";

        String objetEN = "Changing the task " + tache.nom;

        String messageEN = "User " + utilisateur.prenom + " " + utilisateur.nom + " has changed the task "
                + tache.nom + " of project " + tache.projet.nom + "(client : " + tache.projet.client.nom + ")\n";
        messageEN += "Person in charge : " + tache.responsableTache.prenom + tache.responsableTache.nom + "(" + tache.responsableTache.email + ")\n";
        messageEN +="Dates of the task :\n";
        messageEN += "\t - Start date : " + tache.formateDate(tache.dateDebut) + "\n";
        messageEN += "\t - Earliest due date : " + tache.formateDate(tache.dateFinTot) + "\n";
        messageEN += "\t - Latest due date : " + tache.formateDate(tache.dateFinTard) + "\n";
        messageEN += "The task progress is : " + tache.getAvancementTache() + "%\n";
        messageEN += "\t - Initial workload : " + tache.chargeInitiale + " " + uniteEN + "\n";
        messageEN += "\t - Completed workload : " + tache.chargeConsommee + " " + uniteEN + "\n";
        messageEN += "\t - Remaining workload : " + tache.chargeRestante + " " + uniteEN + "\n";

        Map<Utilisateur, Notification> mapNotifications = new HashMap<Utilisateur, Notification>();
        String objet = "";
        String message = "";
        for (Utilisateur userANotifier : tache.utilisateursNotifications) {
            if (userANotifier.langue.equals(Utilisateur.LANGUE_FR)) {
                objet = objetFR;
                message = messageFR;
            } else if (userANotifier.langue.equals(Utilisateur.LANGUE_EN)) {
                objet = objetEN;
                message = messageEN;
            }
            if(!mapNotifications.containsKey(userANotifier)){
                mapNotifications.put(userANotifier, new Notification(objet, message, Calendar.getInstance().getTime(), false, false, userANotifier));
            }
        }
        // Envoie des notifications aux utilisateurs qui ont une nouvelle tache disponible suite à la modification
        // de l'avancement de cette tâche
        sendNotificationTachesDisponibles(tache, mapNotifications);

        // Envoie des notifications
        sendNotifications(mapNotifications);
    }

    /**
     * Appelée lorsque l'avancement d'une tache est modifiée
     * TODO : faire en sorte d'envoyer une notif quand on passe de 100% à <100%
     * @param tache
     * @param mapNotifications
     */
    private static void sendNotificationTachesDisponibles(Tache tache, Map<Utilisateur, Notification> mapNotifications){
        if(!tache.hasSuccesseur() || !tache.estTerminee())
            return;
        /** TODO : utiliser l'attribut? **/
        String objetFR = "Nouvelle(s) tâche(s) disponible(s)";

        String objetEN = "New available task(s)";

        String titleMessageFR = "Nouvelle(s) tâche(s) disponible(s) :";

        String titleMessageEN = "New available task(s) :";

        for(Tache successeur : tache.getSuccesseurs()){
            Utilisateur utilisateur = successeur.responsableTache;
            String objet = "";
            String message = "";
            String titleMessage = "";
            if(utilisateur.langue.equals(Utilisateur.LANGUE_FR)){
                message = "\t -" + successeur.nom + " du projet " + successeur.projet.nom + " (client : " + successeur.projet.client.nom + ")\n";
                objet = objetFR;
                titleMessage = titleMessageFR;
            }
            else if(utilisateur.langue.equals(Utilisateur.LANGUE_EN)){
                message = "\t - " + successeur.nom + " of project " + successeur.projet.nom + " (client : " + successeur.projet.client.nom + ")\n";
                objet = objetEN;
                titleMessage = titleMessageEN;
            }

            if(mapNotifications.containsKey(utilisateur)){
                Notification notification = mapNotifications.get(utilisateur);

                // Ajoute l'objet si il n'est pas déjà présent
                if(!notification.title.contains(objet))
                    notification.title += " - " + objet;

                // Ajoute la phrase "De nouvelles taches disponibles" au début du message
                if(!notification.contentNotification.contains(titleMessage)){
                    if(!notification.contentNotification.isEmpty())
                        notification.contentNotification += "\n";
                    notification.contentNotification += titleMessage;
                }

                notification.contentNotification += message;

                // Remplacement de l'ancienne notif par la nouvelle
                mapNotifications.put(utilisateur, notification);
            }
            else{
                mapNotifications.put(utilisateur, new Notification(objet, titleMessage + message, Calendar.getInstance().getTime(), false, false, utilisateur));
            }
        }
    }

    /**
     * Envoie une notification groupée à l'utilisateur en paramètre => lui indique quelles sont les taches
     * qui se terminent dans moins de 5 jours
     * TODO ZHENG => verifier sur pageweb
     * @param utilisateur
     */
    public static void sendNotificationTacheBientotProche(Utilisateur utilisateur, Notification notification){
        Calendar cal = Calendar.getInstance();
        Calendar today = new GregorianCalendar(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH)+1, cal.get(Calendar.DATE));
        int LIMIT_DATE_ECHEANCE = 5;

        String title = "";
        String message = "";

        if(utilisateur.langue.equals(Utilisateur.LANGUE_FR)){
            title = "Tâche(s) devant être terminée(s) dans moins de " + LIMIT_DATE_ECHEANCE + " jours";
            for(Tache tache  : utilisateur.listTaches()){
                long nbDeJoursRestants = Utils.differenceNbJours(today.getTime(), tache.dateFinTard);
                if(nbDeJoursRestants <= LIMIT_DATE_ECHEANCE){
                    message += "La tâche " + tache.nom + " du projet " + tache.projet.nom
                            + "(client : " + tache.projet.client.nom + ") doit être terminé dans "
                            + nbDeJoursRestants + " jour(s) (Date d'échéance au plus tard : "
                            + tache.formateDate(tache.dateFinTard) + ")\n";
                }
            }
        }
        else if(utilisateur.langue.equals(Utilisateur.LANGUE_EN)){
            title = "Task(s) to be completed within " + LIMIT_DATE_ECHEANCE + " days";
            for(Tache tache  : utilisateur.listTaches()){
                long nbDeJoursRestants = Utils.differenceNbJours(today.getTime(), tache.dateFinTard);
                if(nbDeJoursRestants <= LIMIT_DATE_ECHEANCE){
                    message += "The task " + tache.nom + " of project " + tache.projet.nom
                            + "(client : " + tache.projet.client.nom + ") should be completed within "
                            + nbDeJoursRestants + " day(s) (Latest due date : "
                            + tache.formateDate(tache.dateFinTard) + ")\n";
                }
            }
        }

        if(!message.isEmpty()){
            if(notification.title != null && !notification.title.isEmpty()){
                notification.title += " - " + title;
            }
            else {
                notification.title = title;
            }
            if(notification.contentNotification != null && !notification.contentNotification.isEmpty()){
                notification.contentNotification += "\n" + message;
            }
            else {
                notification.contentNotification = message;
            }
            notification.save();
        }
    }

    /**
     * Envoie une notification groupée à l'utilisateur en paramètre => lui indique quelles sont les taches
     * qui sont retardées
     * TODO ZHENG => verifier sur pageweb
     * @param utilisateur
     */
    public static void sendNotificationTacheRetardee(Utilisateur utilisateur, Notification notification){
        String title = "";
        String message = "";

        if(utilisateur.langue.equals(Utilisateur.LANGUE_FR)){
            title = "Tâche(s) retardée(s)";
            for(Tache tache  : utilisateur.listTaches()){
                if(tache.estRetardee()){
                    message += "La tâche " + tache.nom + " du projet " + tache.projet.nom
                            + "(client : " + tache.projet.client.nom + ") est retardée. La date d'échéance au plus tard était le : "
                            + tache.dateFinTard + "\n";
                }
            }
        }
        else if(utilisateur.langue.equals(Utilisateur.LANGUE_EN)){
            title = "Delayed task(s)";
            for(Tache tache  : utilisateur.listTaches()){
                if(tache.estRetardee()){
                    message += "The task " + tache.nom + " of project " + tache.projet.nom
                            + "(client : " + tache.projet.client.nom + ") is delayed. The latest due date is : "
                            + tache.dateFinTard + "\n";
                }
            }
        }

        if(!message.isEmpty()){
            if(notification.title != null && !notification.title.isEmpty()){
                notification.title += " - " + title;
            }
            else {
                notification.title = title;
            }
            if(notification.contentNotification != null && !notification.contentNotification.isEmpty()){
                notification.contentNotification += "\n" + message;
            }
            else {
                notification.contentNotification = message;
            }
            notification.save();
        }
    }

    /**
     * Prépare les notifications lors de la suppresion d'un utilisateur : l'utilisateur passé en paramètre est le nouveau responsable
     * du projet en paramètre
     * TODO ZHENG => verifier sur pageweb
     * @param utilisateur
     */
    public static void notificationSuppressionUtilisateurProjet(Map<Utilisateur, Notification> mapNotifications,
                                                                Utilisateur utilisateur, Projet projet){
        String objet = "";
        String message = "";
        String titleMessage = "";

        if(utilisateur.langue.equals(Utilisateur.LANGUE_FR)){
            objet = "Nouvelle(s) responsabilité(s)";
            titleMessage = "Voici vos nouvelles responsabilités : \n";
            message = "\t - Vous êtes le nouveau responsable du projet : " + projet.nom + " (client : " + projet.client.nom + ")\n";
        }
        else if(utilisateur.langue.equals(Utilisateur.LANGUE_EN)){
            objet = "New person(s) in charge";
            titleMessage = "Here are your new responsibilities : \n";
            message = "\t - You are the new person in charge of project : " + projet.nom + " (client : " + projet.client.nom + ")\n";
        }

        if(mapNotifications.containsKey(utilisateur)){
            Notification notification = mapNotifications.get(utilisateur);
            notification.contentNotification += message;
            mapNotifications.put(utilisateur, notification);
        }
        else {
            mapNotifications.put(utilisateur, new Notification(objet, titleMessage + message, Calendar.getInstance().getTime(), false, false, utilisateur));
        }
    }

    /**
     * Prépare les notifications lors de la suppresion d'un utilisateur : l'utilisateur passé en paramètre est le nouveau responsable
     * de la tache en paramètre
     * TODO ZHENG => verifier sur pageweb
     * @param utilisateur
     */
    public static void notificationSuppressionUtilisateurTache(Map<Utilisateur, Notification> mapNotifications,
                                                                Utilisateur utilisateur, Tache tache){
        String objet = "";
        String message = "";
        String titleMessage = "";

        if(utilisateur.langue.equals(Utilisateur.LANGUE_FR)){
            objet = "Nouvelle(s) responsabilité(s)";
            titleMessage = "Voici vos nouvelles responsabilités : \n";
            message = "\t - Vous êtes le nouveau responsable de la tâche : " + tache.nom + " du projet " + tache.projet.nom + " (client : " + tache.projet.client.nom + ")\n";
        }
        else if(utilisateur.langue.equals(Utilisateur.LANGUE_EN)){
            objet = "New person(s) in charge";
            titleMessage = "Here are your new responsibilities : \n";
            message = "\t - You are the new person in charge of the task : " + tache.nom + " of project " + tache.projet.nom + " (client : " + tache.projet.client.nom + ")\n";
        }

        if(mapNotifications.containsKey(utilisateur)){
            Notification notification = mapNotifications.get(utilisateur);
            notification.contentNotification += message;
            mapNotifications.put(utilisateur, notification);
        }
        else {
            mapNotifications.put(utilisateur, new Notification(objet, titleMessage + message, Calendar.getInstance().getTime(), false, false, utilisateur));
        }
    }

    /**
     * TODO ZHENG => verifier sur pageweb
     * @param projet
     * @param utilisateur
     */
    public static void notificationCreerProjet(Projet projet, Utilisateur utilisateur){
        Map<Utilisateur, Notification> mapNotifications = new HashMap<Utilisateur, Notification>();

        String titleFR = "Création du projet " + projet.nom;
        String messageMemeUserFR = "Vous avez créé le projet \"" + projet.nom + "\" avec les caractéristiques suivantes :\n";
        String messageAutreUserFR = utilisateur.prenom + " " + utilisateur.nom + " a créé le projet \""
                + projet.nom + "\" avec les caractéristiques suivantes :\n";

        String messageFR = "\t - Nom : " + projet.nom + "\n";
        messageFR += "\t - Client : " + projet.client.nom + "\n";
        messageFR += "\t - Responsable : " + projet.responsableProjet.prenom + " " + projet.responsableProjet.nom +
                " (" + projet.responsableProjet.email + ")\n";
        messageFR += "\t - Priorité : " + projet.priorite + "\n";
        messageFR += "\t - Date de début (théorique) : " + projet.formateDate(projet.dateDebutTheorique) + "\n";
        messageFR += "\t - Date de fin (théorique) : " + projet.formateDate(projet.dateFinTheorique) + "\n";
        messageFR += "\t - Description : " + projet.description + "\n";

        String titleEN = "Create project " + projet.nom;
        String messageMemeUserEN = "You have created the project \"" + projet.nom + "\" with the following characteristics :\n";
        String messageAutreUserEN = utilisateur.prenom + " " + utilisateur.nom + " has created the project \""
                + projet.nom + "\" with the following characteristics :\n";

        String messageEN = "\t - Name : " + projet.nom + "\n";
        messageEN += "\t - Client : " + projet.client.nom + "\n";
        messageEN += "\t - Person in charge : " + projet.responsableProjet.prenom + " " + projet.responsableProjet.nom +
                " (" + projet.responsableProjet.email + ")\n";
        messageEN += "\t - Priority : " + projet.priorite + "\n";
        messageEN += "\t - Start date (theoretical) : " + projet.formateDate(projet.dateDebutTheorique) + "\n";
        messageEN += "\t - End date (theoretical) : " + projet.formateDate(projet.dateFinTheorique) + "\n";
        messageEN += "\t - Description : " + projet.description + "\n";

        String title = "";
        String message = "";
        // Envoie notification a l'utilisateur
        if(utilisateur.equals(projet.responsableProjet) || utilisateur.recevoirNotifPourMesActions){
            if(utilisateur.langue.equals(Utilisateur.LANGUE_FR)){
                title = titleFR;
                message = messageMemeUserFR + messageFR;
            }
            else if(utilisateur.langue.equals(Utilisateur.LANGUE_EN)){
                title = titleEN;
                message = messageMemeUserEN + messageEN;
            }
            mapNotifications.put(utilisateur, new Notification(title, message, Calendar.getInstance().getTime(), false, false, utilisateur));
        }
        // Envoie notification au responsable de projet si ce n'est pas l'auteur de la création
        if(!utilisateur.equals(projet.responsableProjet)){
            if(projet.responsableProjet.langue.equals(Utilisateur.LANGUE_FR)){
                title = titleFR;
                message = messageAutreUserFR + messageFR;
            }
            else if(utilisateur.langue.equals(Utilisateur.LANGUE_EN)){
                title = titleEN;
                message = messageAutreUserEN + messageEN;
            }

            mapNotifications.put(projet.responsableProjet, new Notification(title, message, Calendar.getInstance().getTime(), false, false, projet.responsableProjet));
        }
        sendNotifications(mapNotifications);
    }

    /** TODO ZHENG => verifier sur pageweb
     * Envoie une notification quand un projet est supprimé
     * @param projet
     * @param utilisateur
     */
    public static void notificationSupprimerProjet(Projet projet, Utilisateur utilisateur){
        Map<Utilisateur, Notification> mapNotifications = new HashMap<Utilisateur, Notification>();

        String titleFR = "Suppression du projet " + projet.nom;
        String messageMemeUserFR = "Vous avez supprimé le projet \"" + projet.nom + "\" (client : "+ projet.client.nom +")\n";
        String messageAutreUserFR = utilisateur.prenom + " " + utilisateur.nom + " a supprimé le projet " + projet.nom + "\" (client : "+ projet.client.nom +")\n";

        String titleEN = "Remove project " + projet.nom;
        String messageMemeUserEN = "You have removed the project \"" + projet.nom + "\" (client : "+ projet.client.nom +")\n";
        String messageAutreUserEN = utilisateur.prenom + " " + utilisateur.nom + " has removed the project " + projet.nom + "\" (client : "+ projet.client.nom +")\n";

        String title = "";
        String message = "";
        // Envoie notification a l'utilisateur
        if(utilisateur.equals(projet.responsableProjet) || utilisateur.recevoirNotifPourMesActions){
            if(utilisateur.langue.equals(Utilisateur.LANGUE_FR)){
                title = titleFR;
                message = messageMemeUserFR;
            }
            else if(utilisateur.langue.equals(Utilisateur.LANGUE_EN)){
                title = titleEN;
                message = messageMemeUserEN;
            }
            mapNotifications.put(utilisateur, new Notification(title, message, Calendar.getInstance().getTime(), false, false, utilisateur));
        }
        // Envoie notification au responsable de projet si ce n'est pas l'auteur de la création
        if(!utilisateur.equals(projet.responsableProjet)){
            if(projet.responsableProjet.langue.equals(Utilisateur.LANGUE_FR)){
                title = titleFR;
                message = messageAutreUserFR;
            }
            else if(utilisateur.langue.equals(Utilisateur.LANGUE_EN)){
                title = titleEN;
                message = messageAutreUserEN;
            }

            mapNotifications.put(projet.responsableProjet, new Notification(title, message, Calendar.getInstance().getTime(), false, false, projet.responsableProjet));
        }
        sendNotifications(mapNotifications);
    }

}

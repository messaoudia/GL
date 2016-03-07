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
    @Column(length=65535)
    public String contentNotification;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
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
                ", contentNotification <br>" + contentNotification + "<br>";
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
     *
     * @param mapNotifications
     */
    public static void sendNotifications(Map<Utilisateur, Notification> mapNotifications) {
        for (Map.Entry<Utilisateur, Notification> entry : mapNotifications.entrySet()) {
            Utilisateur user = entry.getKey();
            Notification notification = entry.getValue();
            System.out.println("{" + notification.contentNotification + "}");
            notification.save();
            user.addNotification(notification);
            user.update();
            //sendEmail(user, notification);
        }
    }

    /**
     * Envoie la notification à l'utilisateur par e-mail
     *
     * @param user
     * @param notification
     */
    private static void sendEmail(Utilisateur user, Notification notification) {
        final Email email = new Email();
        email.setSubject(notification.title);
        email.setFrom("NE-PAS-REPONDRE <myproject.polytechparissud@gmail.com>");
        email.addTo(user.email);
        email.setBodyHtml(notification.contentNotification);
        Mail.sendEmail(email);
    }

    /**
     * Envoie une notification groupée à l'utilisateur en paramètre => lui indique quelles sont les taches
     * qui se terminent dans moins de 5 jours
     *
     * @param utilisateur
     */
    public static void sendNotificationTacheBientotProche(Utilisateur utilisateur, Notification notification) {
        Calendar cal = Calendar.getInstance();
        Calendar today = new GregorianCalendar(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH) + 1, cal.get(Calendar.DATE));
        int LIMIT_DATE_ECHEANCE = 5;

        String title = "";
        String message = "";

        if (utilisateur.langue.equals(Utilisateur.LANGUE_FR)) {
            title = "Tâche(s) devant être terminée(s) dans moins de " + LIMIT_DATE_ECHEANCE + " jours";
            for (Tache tache : utilisateur.listTaches()) {
                long nbDeJoursRestants = Utils.differenceNbJours(today.getTime(), tache.dateFinTard);
                if (nbDeJoursRestants <= LIMIT_DATE_ECHEANCE) {
                    message += "La tâche " + tache.nom + " du projet " + tache.projet.nom
                            + "(client : " + tache.projet.client.nom + ") doit être terminé dans "
                            + nbDeJoursRestants + " jour(s) (Date d'échéance au plus tard : "
                            + tache.formateDate(tache.dateFinTard) + ")<br>";
                }
            }
        }
        else if (utilisateur.langue.equals(Utilisateur.LANGUE_EN)) {
            title = "Task(s) to be completed within " + LIMIT_DATE_ECHEANCE + " days";
            for (Tache tache : utilisateur.listTaches()) {
                long nbDeJoursRestants = Utils.differenceNbJours(today.getTime(), tache.dateFinTard);
                if (nbDeJoursRestants <= LIMIT_DATE_ECHEANCE) {
                    message += "The task " + tache.nom + " of project " + tache.projet.nom
                            + "(client : " + tache.projet.client.nom + ") should be completed within "
                            + nbDeJoursRestants + " day(s) (Latest due date : "
                            + tache.formateDate(tache.dateFinTard) + ")<br>";
                }
            }
        }

        if (!message.isEmpty()) {
            if (notification.title != null && !notification.title.isEmpty()) {
                notification.title += " - " + title;
            } else {
                notification.title = title;
            }
            if (notification.contentNotification != null && !notification.contentNotification.isEmpty()) {
                notification.contentNotification += "<br>" + message;
            } else {
                notification.contentNotification = message;
            }
            notification.save();
        }
    }

    /**
     * Envoie une notification groupée à l'utilisateur en paramètre => lui indique quelles sont les taches
     * qui sont retardées
     *
     * @param utilisateur
     */
    public static void sendNotificationTacheRetardee(Utilisateur utilisateur, Notification notification) {
        String title = "";
        String message = "";

        if (utilisateur.langue.equals(Utilisateur.LANGUE_FR)) {
            title = "Tâche(s) retardée(s)";
            for (Tache tache : utilisateur.listTaches()) {
                if (tache.estRetardee()) {
                    message += "La tâche " + tache.nom + " du projet " + tache.projet.nom
                            + "(client : " + tache.projet.client.nom + ") est retardée. La date d'échéance au plus tard était le : "
                            + tache.dateFinTard + "<br>";
                }
            }
        }
        else if (utilisateur.langue.equals(Utilisateur.LANGUE_EN)) {
            title = "Delayed task(s)";
            for (Tache tache : utilisateur.listTaches()) {
                if (tache.estRetardee()) {
                    message += "The task " + tache.nom + " of project " + tache.projet.nom
                            + "(client : " + tache.projet.client.nom + ") is delayed. The latest due date is : "
                            + tache.dateFinTard + "<br>";
                }
            }
        }

        if (!message.isEmpty()) {
            if (notification.title != null && !notification.title.isEmpty()) {
                notification.title += " - " + title;
            } else {
                notification.title = title;
            }
            if (notification.contentNotification != null && !notification.contentNotification.isEmpty()) {
                notification.contentNotification += "<br>" + message;
            } else {
                notification.contentNotification = message;
            }
            notification.save();
        }
    }

    /**
     * Prépare les notifications lors de la suppresion d'un utilisateur : l'utilisateur passé en paramètre est le nouveau responsable
     * du projet en paramètre
     *
     * @param utilisateur
     */
    public static void notificationSuppressionUtilisateurProjet(Map<Utilisateur, Notification> mapNotifications,
                                                                Utilisateur utilisateur, Projet projet) {
        String objet = "";
        String message = "";
        String titleMessage = "";

        if (utilisateur.langue.equals(Utilisateur.LANGUE_FR)) {
            objet = "Nouvelle(s) responsabilité(s)";
            titleMessage = "Voici vos nouvelles responsabilités : <br>";
            message = "\t - Vous êtes le nouveau responsable du projet : " + projet.nom + " (client : " + projet.client.nom + ")<br>";
        }
        else if (utilisateur.langue.equals(Utilisateur.LANGUE_EN)) {
            objet = "New person(s) in charge";
            titleMessage = "Here are your new responsibilities : <br>";
            message = "\t - You are the new person in charge of project : " + projet.nom + " (client : " + projet.client.nom + ")<br>";
        }

        if (mapNotifications.containsKey(utilisateur)) {
            Notification notification = mapNotifications.get(utilisateur);
            notification.contentNotification += message;
            mapNotifications.put(utilisateur, notification);
        } else {
            mapNotifications.put(utilisateur, new Notification(objet, titleMessage + message, Calendar.getInstance().getTime(), false, false, utilisateur));
        }
    }

    /**
     * Prépare les notifications lors de la suppresion d'un utilisateur : l'utilisateur passé en paramètre est le nouveau responsable
     * de la tache en paramètre
     *
     * @param utilisateur
     */
    public static void notificationSuppressionUtilisateurTache(Map<Utilisateur, Notification> mapNotifications,
                                                               Utilisateur utilisateur, Tache tache) {
        String objet = "";
        String message = "";
        String titleMessage = "";

        if (utilisateur.langue.equals(Utilisateur.LANGUE_FR)) {
            objet = "Nouvelle(s) responsabilité(s)";
            titleMessage = "Voici vos nouvelles responsabilités : <br>";
            message = "\t - Vous êtes le nouveau responsable de la tâche : " + tache.nom + " du projet " + tache.projet.nom + " (client : " + tache.projet.client.nom + ")<br>";
        }
        else if (utilisateur.langue.equals(Utilisateur.LANGUE_EN)) {
            objet = "New responsabilities";
            titleMessage = "Here are your new responsibilities : <br>";
            message = "\t - You are the new person in charge of the task : " + tache.nom + " of project " + tache.projet.nom + " (client : " + tache.projet.client.nom + ")<br>";
        }

        if (mapNotifications.containsKey(utilisateur)) {
            Notification notification = mapNotifications.get(utilisateur);
            notification.contentNotification += message;
            mapNotifications.put(utilisateur, notification);
        } else {
            mapNotifications.put(utilisateur, new Notification(objet, titleMessage + message, Calendar.getInstance().getTime(), false, false, utilisateur));
        }
    }

    public static void sendNotificationCreerProjet(Projet projet, Utilisateur utilisateur) {
        Map<Utilisateur, Notification> mapNotifications = new HashMap<Utilisateur, Notification>();

        String titleFR = "Création du projet " + projet.nom;
        String messageMemeUserFR = "Vous avez créé le projet \"" + projet.nom + "\" avec les caractéristiques suivantes :<br>";
        String messageAutreUserFR = utilisateur.prenom + " " + utilisateur.nom + " a créé le projet \""
                + projet.nom + "\" avec les caractéristiques suivantes :<br>";

        String messageFR = "\t - Nom : " + projet.nom + "<br>";
        messageFR += "\t - Client : " + projet.client.nom + "<br>";
        messageFR += "\t - Responsable : " + projet.responsableProjet.prenom + " " + projet.responsableProjet.nom +
                " (" + projet.responsableProjet.email + ")<br>";
        messageFR += "\t - Priorité : " + projet.priorite + "<br>";
        messageFR += "\t - Date de début (théorique) : " + projet.formateDate(projet.dateDebutTheorique) + "<br>";
        messageFR += "\t - Date de fin (théorique) : " + projet.formateDate(projet.dateFinTheorique) + "<br>";

        String titleEN = "Create project " + projet.nom;
        String messageMemeUserEN = "You have created the project \"" + projet.nom + "\" with the following characteristics :<br>";
        String messageAutreUserEN = utilisateur.prenom + " " + utilisateur.nom + " has created the project \""
                + projet.nom + "\" with the following characteristics :<br>";

        String messageEN = "\t - Name : " + projet.nom + "<br>";
        messageEN += "\t - Client : " + projet.client.nom + "<br>";
        messageEN += "\t - Person in charge : " + projet.responsableProjet.prenom + " " + projet.responsableProjet.nom +
                " (" + projet.responsableProjet.email + ")<br>";
        messageEN += "\t - Priority : " + projet.priorite + "<br>";
        messageEN += "\t - Start date (theoretical) : " + projet.formateDate(projet.dateDebutTheorique) + "<br>";
        messageEN += "\t - End date (theoretical) : " + projet.formateDate(projet.dateFinTheorique) + "<br>";

        String title = "";
        String message = "";
        // Envoie notification a l'utilisateur
        if (utilisateur.equals(projet.responsableProjet) || utilisateur.recevoirNotifPourMesActions) {
            System.out.println("Je suis dans le 1er if : langue = " + utilisateur.langue);
            if (utilisateur.langue.equals(Utilisateur.LANGUE_FR)) {
                System.out.println("Je suis FR");
                title = titleFR;
                message = messageMemeUserFR + messageFR;
            } else if (utilisateur.langue.equals(Utilisateur.LANGUE_EN)) {
                System.out.println("Je suis EN");
                title = titleEN;
                message = messageMemeUserEN + messageEN;
            }
            mapNotifications.put(utilisateur, new Notification(title, message, Calendar.getInstance().getTime(), false, false, utilisateur));
        }
        // Envoie notification au responsable de projet si ce n'est pas l'auteur de la création
        if (!utilisateur.equals(projet.responsableProjet)) {
            if (projet.responsableProjet.langue.equals(Utilisateur.LANGUE_FR)) {
                title = titleFR;
                message = messageAutreUserFR + messageFR;
            } else if (utilisateur.langue.equals(Utilisateur.LANGUE_EN)) {
                title = titleEN;
                message = messageAutreUserEN + messageEN;
            }

            mapNotifications.put(projet.responsableProjet, new Notification(title, message, Calendar.getInstance().getTime(), false, false, projet.responsableProjet));
        }
        sendNotifications(mapNotifications);
    }

    /**
     * Envoie une notification quand un projet est supprimé
     *
     * @param projet
     * @param utilisateur
     */
    public static void sendNotificationSupprimerProjet(Projet projet, Utilisateur utilisateur) {
        Map<Utilisateur, Notification> mapNotifications = new HashMap<Utilisateur, Notification>();

        String titleFR = "Suppression du projet " + projet.nom;
        String messageMemeUserFR = "Vous avez supprimé le projet \"" + projet.nom + "\" (client : " + projet.client.nom + ")<br>";
        String messageAutreUserFR = utilisateur.prenom + " " + utilisateur.nom + " a supprimé le projet " + projet.nom + "\" (client : " + projet.client.nom + ")<br>";

        String titleEN = "Remove project " + projet.nom;
        String messageMemeUserEN = "You have removed the project \"" + projet.nom + "\" (client : " + projet.client.nom + ")<br>";
        String messageAutreUserEN = utilisateur.prenom + " " + utilisateur.nom + " has removed the project " + projet.nom + "\" (client : " + projet.client.nom + ")<br>";

        String title = "";
        String message = "";
        // Envoie notification a l'utilisateur
        if (utilisateur.equals(projet.responsableProjet) || utilisateur.recevoirNotifPourMesActions) {
            if (utilisateur.langue.equals(Utilisateur.LANGUE_FR)) {
                title = titleFR;
                message = messageMemeUserFR;
            } else if (utilisateur.langue.equals(Utilisateur.LANGUE_EN)) {
                title = titleEN;
                message = messageMemeUserEN;
            }
            mapNotifications.put(utilisateur, new Notification(title, message, Calendar.getInstance().getTime(), false, false, utilisateur));
        }
        // Envoie notification au responsable de projet si ce n'est pas l'auteur de la création
        if (!utilisateur.equals(projet.responsableProjet)) {
            if (projet.responsableProjet.langue.equals(Utilisateur.LANGUE_FR)) {
                title = titleFR;
                message = messageAutreUserFR;
            } else if (utilisateur.langue.equals(Utilisateur.LANGUE_EN)) {
                title = titleEN;
                message = messageAutreUserEN;
            }

            mapNotifications.put(projet.responsableProjet, new Notification(title, message, Calendar.getInstance().getTime(), false, false, projet.responsableProjet));
        }
        sendNotifications(mapNotifications);
    }

    public static void sendNotificationModifierProjet(Projet projet, Utilisateur utilisateur, HashMap<Utilisateur, Notification> mapNotifications) {
        String titleFR = "Modification du projet " + projet.nom;
        String titleFRManyChangements = "Des changements ont eu lieu dans vos tâches/projets";
        String messageMemeUserFR = "Vous avez modifié le projet " + projet.nom + " (client : " + projet.client.nom + ") : <br>";
        String messageAutreUserFR = utilisateur.prenom + " " + utilisateur.nom + " a modifié le projet " + projet.nom + " (client : " + projet.client.nom + ") : <br>";

        String messageProjetFR = "\t - Nom : " + projet.nom + "<br>";
        messageProjetFR += "\t - Client : " + projet.client.nom + "<br>";
        messageProjetFR += "\t - Responsable de projet : " + projet.responsableProjet.prenom + " " + projet.responsableProjet.nom + "<br>";

        String titleEN = "Modify project " + projet.nom;
        String titleENManyChangements = "The changes have taken place in your tasks/projects";
        String messageMemeUserEN = "You have modified the project " + projet.nom + " (client : " + projet.client.nom + ") : <br>";
        String messageAutreUserEN = utilisateur.prenom + " " + utilisateur.nom + " has modified the project " + projet.nom + " (client : " + projet.client.nom + ") : <br>";

        String messageProjetEN = "\t - Name : " + projet.nom + "<br>";
        messageProjetEN += "\t - Client : " + projet.client.nom + "<br>";
        messageProjetEN += "\t - Person in charge of project : " + projet.responsableProjet.prenom + " " + projet.responsableProjet.nom + "<br>";

        List<Utilisateur> listUserTemporaire = new ArrayList<Utilisateur>();

        String title = "";
        String message = "";

        // Notif pour l'utilisateur qui a fait l'action
        if (utilisateur.recevoirNotifPourMesActions || utilisateur.equals(projet.responsableProjet)) {
            updateMapNotifications(utilisateur, titleFR, messageMemeUserFR + messageProjetFR, titleFRManyChangements,
                    titleEN, messageMemeUserEN + messageProjetEN, titleENManyChangements, mapNotifications);
            listUserTemporaire.add(utilisateur);
        }

        // Notif pour le responsable de projet s'il est pas l'auteur de la notification
        if (!utilisateur.equals(projet.responsableProjet)) {
            updateMapNotifications(projet.responsableProjet, titleFR, messageAutreUserFR + messageProjetFR, titleFRManyChangements,
                    titleEN, messageAutreUserEN + messageProjetEN, titleENManyChangements, mapNotifications);
            listUserTemporaire.add(projet.responsableProjet);
        }

        // Notif pour tous les collaborateurs
        for (Tache tache : projet.listTaches()) {
            if (!listUserTemporaire.contains(tache.responsableTache)) {
                updateMapNotifications(tache.responsableTache, titleFR, messageAutreUserFR + messageProjetFR, titleFRManyChangements,
                        titleEN, messageAutreUserEN + messageProjetEN, titleENManyChangements, mapNotifications);
                listUserTemporaire.add(tache.responsableTache);
            }
        }
        listUserTemporaire.clear();
    }

    public static void sendNotificationModifierResponsableProjet(Projet projet, Utilisateur ancienResponsableProjet, Utilisateur utilisateur, HashMap<Utilisateur, Notification> mapNotifications) {
        String titleNouveauRespoFR = "Nouvelle affectation d'un projet";
        String messageNouveauRespoFR = "Vous êtes le nouveau responsable du projet " + projet.nom + " (client : " + projet.client.nom + ")<br>";

        String titleAncienRespoFR = "Désaffectation d'un projet";
        String messageAncienRespoFR = "Vous n'êtes plus responsable du projet " + projet.nom + " (client : " + projet.client.nom + ")<br>";

        String titleFR = "Modification du projet " + projet.nom;
        String titleFRManyChangements = "Des changements ont eu lieu dans vos tâches/projets";
        String messageMemeUserFR = "Vous avez modifié le projet " + projet.nom + " (client : " + projet.client.nom + ") : <br>";
        String messageAutreUserFR = utilisateur.prenom + " " + utilisateur.nom + " a modifié le projet " + projet.nom + " (client : " + projet.client.nom + ") : <br>";

        String messageProjetFR = "\t - Nom : " + projet.nom + "<br>";
        messageProjetFR += "\t - Client : " + projet.client.nom + "<br>";
        messageProjetFR += "\t - Nouveau responsable de projet : " + projet.responsableProjet.prenom + " " + projet.responsableProjet.nom + "<br>";

        String titleNouveauRespoEN = "New project assignment";
        String messageNouveauRespoEN = "You are the new person in charge of project " + projet.nom + " (client : " + projet.client.nom + ")<br>";

        String titleAncienRespoEN = "Decommissioning project";
        String messageAncienRespoEN = "You are no longer person in charge of project " + projet.nom + " (client : " + projet.client.nom + ")<br>";

        String titleEN = "Modify project " + projet.nom;
        String titleENManyChangements = "The changes have taken place in your tasks/projects";
        String messageMemeUserEN = "You have modified the project " + projet.nom + " (client : " + projet.client.nom + ") : <br>";
        String messageAutreUserEN = utilisateur.prenom + " " + utilisateur.nom + " has modified the project " + projet.nom + " (client : " + projet.client.nom + ") : <br>";

        String messageProjetEN = "\t - Name : " + projet.nom + "<br>";
        messageProjetEN += "\t - Client : " + projet.client.nom + "<br>";
        messageProjetFR += "\t - New person in charge of project : " + projet.responsableProjet.prenom + " " + projet.responsableProjet.nom + "<br>";

        List<Utilisateur> listUserTemporaire = new ArrayList<Utilisateur>();

        // Notif pour l'utilisateur qui a fait l'action
        if (utilisateur.recevoirNotifPourMesActions || utilisateur.equals(projet.responsableProjet)
                || utilisateur.equals(ancienResponsableProjet)) {
            updateMapNotifications(utilisateur, titleFR, messageMemeUserFR + messageProjetFR, titleFRManyChangements,
                    titleEN, messageMemeUserEN + messageProjetEN, titleENManyChangements, mapNotifications);
            listUserTemporaire.add(utilisateur);
        }

        // Notif pour le responsable de projet s'il est pas l'auteur de la notification
        if (!utilisateur.equals(projet.responsableProjet)) {
            updateMapNotifications(projet.responsableProjet, titleNouveauRespoFR, messageNouveauRespoFR, titleFRManyChangements,
                    titleNouveauRespoEN, messageNouveauRespoEN, titleENManyChangements, mapNotifications);
            listUserTemporaire.add(projet.responsableProjet);
        }

        // Notif pour l'ancien responsable de projet
        if (!utilisateur.equals(ancienResponsableProjet)) {
            updateMapNotifications(ancienResponsableProjet, titleAncienRespoFR, messageAncienRespoFR, titleFRManyChangements,
                    titleAncienRespoEN, messageAncienRespoEN, titleENManyChangements, mapNotifications);
            listUserTemporaire.add(ancienResponsableProjet);
        }

        // Notif pour tous les collaborateurs
        for (Tache tache : projet.listTaches()) {
            if (!listUserTemporaire.contains(tache.responsableTache)) {
                updateMapNotifications(tache.responsableTache, titleFR, messageAutreUserFR + messageProjetFR, titleFRManyChangements,
                        titleEN, messageAutreUserEN + messageProjetEN, titleENManyChangements, mapNotifications);
                listUserTemporaire.add(tache.responsableTache);
            }
        }
        listUserTemporaire.clear();
    }

    public static void sendNotificationCreerTache(Tache tache, Utilisateur utilisateur, HashMap<Utilisateur, Notification> mapNotifications) {
        String titleFR = "Création de la tâche " + tache.nom;
        String messageMemeUserFR = "Vous avez créé la tâche \"" + tache.nom + "\" avec les caractéristiques suivantes :<br>";
        String messageAutreUserFR = utilisateur.prenom + " " + utilisateur.nom + " a créé la tâche \""
                + tache.nom + "\" avec les caractéristiques suivantes :<br>";

        String titleFRManyChangements = "Des changements ont eu lieu dans vos tâches/projets";

        String messageFR = "\t - Nom : " + tache.nom + "<br>";
        messageFR += "\t - Projet : " + tache.projet.nom + "<br>";
        messageFR += "\t - Client : " + tache.projet.client.nom + "<br>";
        messageFR += "\t - Responsable : " + tache.responsableTache.prenom + " " + tache.responsableTache.nom +
                " (" + tache.responsableTache.email + ")<br>";
        messageFR += "\t - Date de début : " + tache.formateDate(tache.dateDebut) + "<br>";
        messageFR += "\t - Date d'échéance au plus tôt : " + tache.formateDate(tache.dateFinTot) + "<br>";
        messageFR += "\t - Date d'échéance au plus tard : " + tache.formateDate(tache.dateFinTard) + "<br>";
        messageFR += "\t - Charge initiale : " + tache.chargeInitiale + (tache.projet.hasUniteJour() ? " J" : " semaine(s)") + "<br>";

        String titleEN = "Create task " + tache.nom;
        String messageMemeUserEN = "You have created the task \"" + tache.nom + "\" with the following characteristics :<br>";
        String messageAutreUserEN = utilisateur.prenom + " " + utilisateur.nom + " has created the task \""
                + tache.nom + "\" with the following characteristics :<br>";

        String titleENManyChangements = "The changes have taken place in your tasks/projects";

        String messageEN = "\t - Name : " + tache.nom + "<br>";
        messageEN += "\t - Project : " + tache.projet.nom + "<br>";
        messageEN += "\t - Client : " + tache.projet.client.nom + "<br>";
        messageEN += "\t - Person in charge : " + tache.responsableTache.prenom + " " + tache.responsableTache.nom +
                " (" + tache.responsableTache.email + ")<br>";
        messageEN += "\t - Start date : " + tache.formateDate(tache.dateDebut) + "<br>";
        messageEN += "\t - Earliest due date : " + tache.formateDate(tache.dateFinTot) + "<br>";
        messageEN += "\t - Latest due date : " + tache.formateDate(tache.dateFinTard) + "<br>";
        messageEN += "\t - Initial workload : " + tache.chargeInitiale + (tache.projet.hasUniteJour() ? " Day(s)" : " week(s)") + "<br>";

        // Pour une tache : regarder List notification dans tache
        List<Utilisateur> listUserTemporaire = new ArrayList<Utilisateur>();

        // Notif pour l'utilisateur qui a fait l'action
        if (utilisateur.recevoirNotifPourMesActions || utilisateur.equals(tache.projet.responsableProjet)) {
            updateMapNotifications(utilisateur, titleFR, messageMemeUserFR + messageFR, titleFRManyChangements,
                    titleEN, messageMemeUserEN + messageEN, titleENManyChangements, mapNotifications);
            listUserTemporaire.add(utilisateur);
        }

        // Notif pour le responsable du projet s'il est pas l'auteur de la notification
        if (!utilisateur.equals(tache.projet.responsableProjet)) {
            updateMapNotifications(tache.projet.responsableProjet, titleFR, messageAutreUserFR + messageFR, titleFRManyChangements,
                    titleEN, messageAutreUserEN + messageEN, titleENManyChangements, mapNotifications);
            listUserTemporaire.add(tache.projet.responsableProjet);
        }

        // Notif pour le responsable de la tache s'il est pas l'auteur de la notification
        if (!utilisateur.equals(tache.responsableTache) && !listUserTemporaire.contains(tache.responsableTache)) {
            updateMapNotifications(tache.responsableTache, titleFR, messageAutreUserFR + messageFR, titleFRManyChangements,
                    titleEN, messageAutreUserEN + messageEN, titleENManyChangements, mapNotifications);
            listUserTemporaire.add(tache.responsableTache);
        }

        // Notif pour taches meres
        Tache parent = tache.parent;
        while(parent != null){
            if (!listUserTemporaire.contains(tache.responsableTache)) {
                updateMapNotifications(parent.responsableTache, titleFR, messageAutreUserFR + messageFR, titleFRManyChangements,
                        titleEN, messageAutreUserEN + messageEN, titleENManyChangements, mapNotifications);
                listUserTemporaire.add(parent.responsableTache);
            }
            parent = parent.parent;
        }
        listUserTemporaire.clear();
    }

    public static void sendNotificationModifierAvancementTache(Tache tache, Utilisateur utilisateur, HashMap<Utilisateur, Notification> mapNotifications) {
        String uniteFR, uniteEN;
        if (tache.projet.hasUniteJour()) {
            uniteFR = "jour(s)";
            uniteEN = "day(s)";
        } else {
            uniteFR = "semaine(s)";
            uniteEN = "week(s)";
        }

        String titleFR = "Modification de l'avancement de la tâche " + tache.nom;

        String messageMemeUserFR = "Vous avez modifié l'avancement de la tâche "
                + tache.nom + " du projet " + tache.projet.nom + "(client : " + tache.projet.client.nom + ")<br>";
        String messageAutreUserFR = utilisateur.prenom + " " + utilisateur.nom + " a modifié l'avancement de la tâche "
                + tache.nom + " du projet " + tache.projet.nom + "(client : " + tache.projet.client.nom + ")<br>";

        String titleFRManyChangements = "Des changements ont eu lieu dans vos tâches/projets";

        String messageFR = "Le nouvel avancement de la tâche est de : " + tache.getAvancementTache() + "%<br>";
        messageFR += "\t - Charge initiale : " + tache.chargeInitiale + " " + uniteFR + "<br>";
        messageFR += "\t - Charge consommée : " + tache.chargeConsommee + " " + uniteFR + "<br>";
        messageFR += "\t - Charge restante : " + tache.chargeRestante + " " + uniteFR + "<br>";

        String titleEN = "Changing the task progress " + tache.nom;

        String messageMemeUserEN = "You have changed the task progress "
                + tache.nom + " of project " + tache.projet.nom + "(client : " + tache.projet.client.nom + ")<br>";
        String messageAutreUserEN = utilisateur.prenom + " " + utilisateur.nom + " has changed the task progress "
                + tache.nom + " of project " + tache.projet.nom + "(client : " + tache.projet.client.nom + ")<br>";

        String titleENManyChangements = "The changes have taken place in your tasks/projects";

        String messageEN = "The new task progress is : " + tache.getAvancementTache() + "%<br>";
        messageEN += "\t - Initial workload : " + tache.chargeInitiale + " " + uniteEN + "<br>";
        messageEN += "\t - Completed workload : " + tache.chargeConsommee + " " + uniteEN + "<br>";
        messageEN += "\t - Remaining workload : " + tache.chargeRestante + " " + uniteEN + "<br>";

        // Pour une tache : regarder List notification dans tache
        List<Utilisateur> listUserTemporaire = new ArrayList<Utilisateur>();

        // Notif pour l'utilisateur qui a fait l'action
        if (utilisateur.recevoirNotifPourMesActions) {
            updateMapNotifications(utilisateur, titleFR, messageMemeUserFR + messageFR, titleFRManyChangements,
                    titleEN, messageMemeUserEN + messageEN, titleENManyChangements, mapNotifications);
            listUserTemporaire.add(utilisateur);
        }

        // Notif pour ceux qui l'ont activé
        for(Utilisateur userSuivantTache : tache.utilisateursNotifications){
            if(!listUserTemporaire.contains(userSuivantTache)){
                updateMapNotifications(userSuivantTache, titleFR, messageAutreUserFR + messageFR, titleFRManyChangements,
                        titleEN, messageAutreUserEN + messageEN, titleENManyChangements, mapNotifications);
                listUserTemporaire.add(userSuivantTache);
            }
        }

        // Notif pour ceux qui suivent l'utilisateur
        if (!listUserTemporaire.contains(tache.projet.responsableProjet) && utilisateur.utilisateursMeSuivant().contains(tache.projet.responsableProjet)) {
            updateMapNotifications(tache.projet.responsableProjet, titleFR, messageAutreUserFR + messageFR, titleFRManyChangements,
                    titleEN, messageAutreUserEN + messageEN, titleENManyChangements, mapNotifications);
            listUserTemporaire.add(tache.projet.responsableProjet);
        }
        listUserTemporaire.clear();
    }

    public static void sendNotificationModifierTache(Tache tache, Utilisateur utilisateur, HashMap<Utilisateur, Notification> mapNotifications) {
        String uniteFR, uniteEN;
        if (tache.projet.hasUniteJour()) {
            uniteFR = "jour(s)";
            uniteEN = "day(s)";
        } else {
            uniteFR = "semaine(s)";
            uniteEN = "week(s)";
        }

        String titleFR = "Modification de la tâche " + tache.nom;

        String messageMemeUserFR = "Vous avez modifié la tâche "
                + tache.nom + " du projet " + tache.projet.nom + "(client : " + tache.projet.client.nom + ")<br>";
        String messageAutreUserFR = utilisateur.prenom + " " + utilisateur.nom + " a modifié la tâche "
                + tache.nom + " du projet " + tache.projet.nom + "(client : " + tache.projet.client.nom + ")<br>";

        String messageFR = "Responsable : " + tache.responsableTache.prenom + tache.responsableTache.nom + "(" + tache.responsableTache.email + ")<br>";
        messageFR += "Etat de la tâche : " + (tache.disponible ? "disponible" : "indisponible") + "<br>";
        messageFR += "Dates de la tâche :<br>";
        messageFR += "\t - Date de début : " + tache.formateDate(tache.dateDebut) + "<br>";
        messageFR += "\t - Date d'échéance au plus tôt : " + tache.formateDate(tache.dateFinTot) + "<br>";
        messageFR += "\t - Date d'échéance au plus tard : " + tache.formateDate(tache.dateFinTard) + "<br>";
        messageFR += "Avancement de la tâche est de : " + tache.getAvancementTache() + "%<br>";
        messageFR += "\t - Charge initiale : " + tache.chargeInitiale + " " + uniteFR + "<br>";
        messageFR += "\t - Charge consommée : " + tache.chargeConsommee + " " + uniteFR + "<br>";
        messageFR += "\t - Charge restante : " + tache.chargeRestante + " " + uniteFR + "<br>";

        String titleFRManyChangements = "Des changements ont eu lieu dans vos tâches/projets";

        String titleEN = "Modify task " + tache.nom;

        String messageMemeUserEN = "You have modified the task "
                + tache.nom + " of project " + tache.projet.nom + "(client : " + tache.projet.client.nom + ")<br>";
        String messageAutreUserEN = utilisateur.prenom + " " + utilisateur.nom + " has modified the task "
                + tache.nom + " of project " + tache.projet.nom + "(client : " + tache.projet.client.nom + ")<br>";

        String messageEN = "Person in charge : " + tache.responsableTache.prenom + " " + tache.responsableTache.nom + "(" + tache.responsableTache.email + ")<br>";
        messageEN += "Task state : " + (tache.disponible ? "available" : "unavailable") + "<br>";
        messageEN += "Task schedule :<br>";
        messageEN += "\t - Start date : " + tache.formateDate(tache.dateDebut) + "<br>";
        messageEN += "\t - Earliest due date : " + tache.formateDate(tache.dateFinTot) + "<br>";
        messageEN += "\t - Latest due date : " + tache.formateDate(tache.dateFinTard) + "<br>";
        messageEN += "The task progress is : " + tache.getAvancementTache() + "%<br>";
        messageEN += "\t - Initial workload : " + tache.chargeInitiale + " " + uniteFR + "<br>";
        messageEN += "\t - Completed workload : " + tache.chargeConsommee + " " + uniteFR + "<br>";
        messageEN += "\t - Remaining workload : " + tache.chargeRestante + " " + uniteFR + "<br>";

        String titleENManyChangements = "The changes have taken place in your tasks/projects";

        // Pour une tache : regarder List notification dans tache
        List<Utilisateur> listUserTemporaire = new ArrayList<Utilisateur>();

        // Notif pour l'utilisateur qui a fait l'action
        if (utilisateur.recevoirNotifPourMesActions || utilisateur.equals(tache.projet.responsableProjet)) {
            updateMapNotifications(utilisateur, titleFR, messageMemeUserFR + messageFR, titleFRManyChangements,
                    titleEN, messageMemeUserEN + messageEN, titleENManyChangements, mapNotifications);
            listUserTemporaire.add(utilisateur);
        }

        // Notif pour le respo projet
        if (!utilisateur.equals(tache.projet.responsableProjet)) {
            updateMapNotifications(tache.projet.responsableProjet, titleFR, messageAutreUserFR + messageFR, titleFRManyChangements,
                    titleEN, messageAutreUserEN + messageEN, titleENManyChangements, mapNotifications);
            listUserTemporaire.add(tache.projet.responsableProjet);
        }

        // Notif pour ceux qui l'ont activé
        for(Utilisateur userSuivantTache : tache.utilisateursNotifications){
            if(!listUserTemporaire.contains(userSuivantTache)){
                updateMapNotifications(userSuivantTache, titleFR, messageAutreUserFR + messageFR, titleFRManyChangements,
                        titleEN, messageAutreUserEN + messageEN, titleENManyChangements, mapNotifications);
                listUserTemporaire.add(userSuivantTache);
            }
        }
        listUserTemporaire.clear();
    }

    public static void sendNotificationModifierResponsableTache(Tache tache, Utilisateur ancienResponsableTache, Utilisateur utilisateur, HashMap<Utilisateur, Notification> mapNotifications) {
        String uniteFR, uniteEN;
        if (tache.projet.hasUniteJour()) {
            uniteFR = "jour(s)";
            uniteEN = "day(s)";
        } else {
            uniteFR = "semaine(s)";
            uniteEN = "week(s)";
        }

        String titleNouveauRespoFR = "Nouvelle affectation d'une tache";
        String messageNouveauRespoFR = "Vous êtes le nouveau responsable de la tâche " + tache.nom + " (client : " + tache.projet.client.nom + ")<br>";

        String titleAncienRespoFR = "Désaffectation d'un projet";
        String messageAncienRespoFR = "Vous n'êtes plus responsable du projet " + tache.nom + " (client : " + tache.projet.client.nom + ")<br>";

        String titleFR = "Modification de la tâche " + tache.nom;
        String titleFRManyChangements = "Des changements ont eu lieu dans vos tâches/projets";
        String messageMemeUserFR = "Vous avez modifié la tâche " + tache.nom + " (client : " + tache.projet.client.nom + ") : <br>";
        String messageAutreUserFR = utilisateur.prenom + " " + utilisateur.nom + " a modifié la tache " + tache.nom + " (client : " + tache.projet.client.nom + ") : <br>";

        String messageFR = "Nouveau responsable : " + tache.responsableTache.prenom + " " + tache.responsableTache.nom + "(" + tache.responsableTache.email + ")<br>";
        messageFR += "Etat de la tâche : " + (tache.disponible ? "disponible" : "indisponible") + "<br>";
        messageFR += "Dates de la tâche :<br>";
        messageFR += "\t - Date de début : " + tache.formateDate(tache.dateDebut) + "<br>";
        messageFR += "\t - Date d'échéance au plus tôt : " + tache.formateDate(tache.dateFinTot) + "<br>";
        messageFR += "\t - Date d'échéance au plus tard : " + tache.formateDate(tache.dateFinTard) + "<br>";
        messageFR += "Avancement de la tâche est de : " + tache.getAvancementTache() + "%<br>";
        messageFR += "\t - Charge initiale : " + tache.chargeInitiale + " " + uniteFR + "<br>";
        messageFR += "\t - Charge consommée : " + tache.chargeConsommee + " " + uniteFR + "<br>";
        messageFR += "\t - Charge restante : " + tache.chargeRestante + " " + uniteFR + "<br>";

        String titleNouveauRespoEN = "New task assignment";
        String messageNouveauRespoEN = "You are the new person in charge of the task " + tache.nom + " (client : " + tache.projet.client.nom + ")<br>";

        String titleAncienRespoEN = "Decommissioning project";
        String messageAncienRespoEN = "You are no longer person in charge of project " + tache.nom + " (client : " + tache.projet.client.nom + ")<br>";

        String titleEN = "Modify task " + tache.nom;
        String titleENManyChangements = "The changes have taken place in your tasks/projects";
        String messageMemeUserEN = "You have modified the task " + tache.nom + " (client : " + tache.projet.client.nom + ") : <br>";
        String messageAutreUserEN = utilisateur.prenom + " " + utilisateur.nom + " has modified the task " + tache.nom + " (client : " + tache.projet.client.nom + ") : <br>";

        String messageEN = "New person in charge : " + tache.responsableTache.prenom + " " + tache.responsableTache.nom + "(" + tache.responsableTache.email + ")<br>";
        messageEN += "Task state : " + (tache.disponible ? "available" : "unavailable") + "<br>";
        messageEN += "Task schedule :<br>";
        messageEN += "\t - Start date : " + tache.formateDate(tache.dateDebut) + "<br>";
        messageEN += "\t - Earliest due date : " + tache.formateDate(tache.dateFinTot) + "<br>";
        messageEN += "\t - Latest due date : " + tache.formateDate(tache.dateFinTard) + "<br>";
        messageEN += "The task progress is : " + tache.getAvancementTache() + "%<br>";
        messageEN += "\t - Initial workload : " + tache.chargeInitiale + " " + uniteEN + "<br>";
        messageEN += "\t - Completed workload : " + tache.chargeConsommee + " " + uniteEN + "<br>";
        messageEN += "\t - Remaining workload : " + tache.chargeRestante + " " + uniteEN + "<br>";
        List<Utilisateur> listUserTemporaire = new ArrayList<Utilisateur>();

        // Notif pour l'utilisateur qui a fait l'action
        if (utilisateur.recevoirNotifPourMesActions || utilisateur.equals(tache.projet.responsableProjet)
                || utilisateur.equals(ancienResponsableTache)) {
            updateMapNotifications(utilisateur, titleFR, messageMemeUserFR + messageFR, titleFRManyChangements,
                    titleEN, messageMemeUserEN + messageEN, titleENManyChangements, mapNotifications);
            listUserTemporaire.add(utilisateur);
        }

        // Notif pour le responsable de projet s'il est pas l'auteur de la notification
        if (!utilisateur.equals(tache.projet.responsableProjet)) {
            updateMapNotifications(tache.projet.responsableProjet, titleFR, messageAutreUserFR + messageFR, titleFRManyChangements,
                    titleEN, messageAutreUserEN + messageEN, titleENManyChangements, mapNotifications);
            listUserTemporaire.add(tache.projet.responsableProjet);
        }

        // Notif pour l'ancien responsable de la tache
        if (!utilisateur.equals(ancienResponsableTache)) {
            updateMapNotifications(ancienResponsableTache, titleAncienRespoFR, messageAncienRespoFR, titleFRManyChangements,
                    titleAncienRespoEN, messageAncienRespoEN, titleENManyChangements, mapNotifications);
            listUserTemporaire.add(ancienResponsableTache);
        }

        // Notif pour le nouveau responsable de la tache
        if (!listUserTemporaire.contains(tache.responsableTache)) {
            updateMapNotifications(tache.responsableTache, titleNouveauRespoFR, messageNouveauRespoFR, titleFRManyChangements,
                    titleNouveauRespoEN, messageNouveauRespoEN, titleENManyChangements, mapNotifications);
            listUserTemporaire.add(tache.responsableTache);
        }

        // Notif pour tous les collaborateurs
        for (Utilisateur userSuivantTache : tache.utilisateursNotifications) {
            if (!listUserTemporaire.contains(userSuivantTache)) {
                updateMapNotifications(userSuivantTache, titleFR, messageFR, titleFRManyChangements,
                        titleEN, messageEN, titleENManyChangements, mapNotifications);
                listUserTemporaire.add(userSuivantTache);
            }
        }
        listUserTemporaire.clear();
    }

    public static void sendNotificationSupprimerTache(Tache tache, Utilisateur utilisateur, HashMap<Utilisateur, Notification> mapNotifications) {
        String titleFR = "Suppression de la tâche " + tache.nom;
        String messageMemeUserFR = "Vous avez supprimé la tâche "
                + tache.nom + " du projet " + tache.projet.nom + "(client : " + tache.projet.client.nom + ")<br>";
        String messageAutreUserFR = utilisateur.prenom + " " + utilisateur.nom + " a supprimé la tâche "
                + tache.nom + " du projet " + tache.projet.nom + "(client : " + tache.projet.client.nom + ")<br>";
        String titleFRManyChangements = "Des changements ont eu lieu dans vos tâches/projets";

        String titleEN = "Delete task " + tache.nom;
        String messageMemeUserEN = "You have deleted the task "
                + tache.nom + " of project " + tache.projet.nom + "(client : " + tache.projet.client.nom + ")<br>";
        String messageAutreUserEN = utilisateur.prenom + " " + utilisateur.nom + " has deleted the task "
                + tache.nom + " of project " + tache.projet.nom + "(client : " + tache.projet.client.nom + ")<br>";
        String titleENManyChangements = "The changes have taken place in your tasks/projects";

        // Pour une tache : regarder List notification dans tache
        List<Utilisateur> listUserTemporaire = new ArrayList<Utilisateur>();

        // Notif pour l'utilisateur qui a fait l'action
        if (utilisateur.recevoirNotifPourMesActions || utilisateur.equals(tache.projet.responsableProjet)) {
            updateMapNotifications(utilisateur, titleFR, messageMemeUserFR, titleFRManyChangements,
                    titleEN, messageMemeUserEN, titleENManyChangements, mapNotifications);
            listUserTemporaire.add(utilisateur);
        }

        // Notif pour le respo projet
        if (!utilisateur.equals(tache.projet.responsableProjet)) {
            updateMapNotifications(tache.projet.responsableProjet, titleFR, messageAutreUserFR, titleFRManyChangements,
                    titleEN, messageAutreUserEN, titleENManyChangements, mapNotifications);
            listUserTemporaire.add(tache.projet.responsableProjet);
        }
        listUserTemporaire.clear();
    }

    /**
     * Permet de mettre à jour mapNotification pour l'utilisateur
     * ==> Gere la langue et le fait que l'utilisateur ait déjà une notification ou pas
     *
     * @param utilisateur
     * @param titleFR
     * @param messageFR
     * @param titleFRManyChangements
     * @param titleEN
     * @param messageEN
     * @param titleENManyChangements
     * @param mapNotifications
     */
    private static void updateMapNotifications(Utilisateur utilisateur, String titleFR, String messageFR,
                                               String titleFRManyChangements, String titleEN, String messageEN,
                                               String titleENManyChangements, HashMap<Utilisateur, Notification> mapNotifications) {
        String title = "";
        String message = "";
        System.out.println("Pour l'utilisateur : " + utilisateur.prenom);
        System.out.println("==> = " + utilisateur.langue);
        if (utilisateur.langue == Utilisateur.LANGUE_FR) {
            title = titleFR;
            message = messageFR;
        } else if (utilisateur.langue == Utilisateur.LANGUE_EN) {
            title = titleEN;
            message = messageEN;
        }
        if (mapNotifications.containsKey(utilisateur)) {
            Notification notification = mapNotifications.get(utilisateur);
            if (utilisateur.langue == Utilisateur.LANGUE_FR) {
                title = titleFRManyChangements;
            } else if (utilisateur.langue == Utilisateur.LANGUE_EN) {
                title = titleENManyChangements;
            }
            notification.title = title;
            notification.contentNotification += "<br>" + message;
            mapNotifications.put(utilisateur, notification);
        } else {
            mapNotifications.put(utilisateur, new Notification(title, message, Calendar.getInstance().getTime(), false, false, utilisateur));
        }
    }
}

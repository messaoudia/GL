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
     *
     * @param mapNotifications
     */
    public static void sendNotifications(Map<Utilisateur, Notification> mapNotifications) {
        for (Map.Entry<Utilisateur, Notification> entry : mapNotifications.entrySet()) {
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
     *
     * @param user
     * @param notification
     */
    private static void sendEmail(Utilisateur user, Notification notification) {
        final Email email = new Email();
        email.setSubject(notification.title);
        email.setFrom("NE-PAS-REPONDRE <myproject.polytechparissud@gmail.com>");
        email.addTo(user.prenom + " " + user.nom + "\"" + user.prenom + " " + user.nom + " <" + user.email + ">\"");
        email.setBodyHtml(notification.contentNotification);
        Mail.sendEmail(email);
    }

    /**
     * Envoie une notification à tous les utilisateurs associés à la tache passé en paramètre
     * L'utilisateur passé en paramètre est l'utilisateur qui a modifié l'avancement de la tâche
     * <p>
     * Si la modification de l'avancement entraîne un changement d'état d'une tâche (disponible/indisponible),
     * une notification est aussi envoyée (notifications groupées)
     *
     * @param tache
     * @param utilisateur

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

        String objetEN = "Modification de l'avancement de la tâche " + tache.nom;

        String messageEN = "L'utilisateur " + utilisateur.prenom + " " + utilisateur.nom + " a modifié l'avancement de la tâche "
                + tache.nom + " du projet " + tache.projet.nom + "(client : " + tache.projet.client.nom + ")\n";
        messageFR += "Le nouvel avancement de la tâche est de : " + tache.getAvancementTache() + "%\n";
        messageFR += "\t - Charge initiale : " + tache.chargeInitiale + " " + uniteEN + "\n";
        messageFR += "\t - Charge consommée : " + tache.chargeConsommee + " " + uniteEN + "\n";
        messageFR += "\t - Charge restante : " + tache.chargeRestante + " " + uniteEN + "\n";

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
            if (!mapNotifications.containsKey(userANotifier)) {
                mapNotifications.put(userANotifier, new Notification(objet, message, Calendar.getInstance().getTime(), false, false, userANotifier));
            }
        }
        // Envoie des notifications aux utilisateurs qui ont une nouvelle tache disponible suite à la modification
        // de l'avancement de cette tâche
        sendNotificationTachesDisponibles(tache, mapNotifications);

        // Envoie des notifications
        sendNotifications(mapNotifications);
    }
     */

    /**
     * Envoie une notification à tous les utilisateurs associés à la tache passé en paramètre
     * L'utilisateur passé en paramètre est l'utilisateur qui a modifié la tâche
     *
     * @param tache
     * @param utilisateur

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
        messageFR += "Dates de la tâche :\n";
        messageFR += "\t - Date de début : " + tache.formateDate(tache.dateDebut) + "\n";
        messageFR += "\t - Date d'échéance au plus tôt : " + tache.formateDate(tache.dateFinTot) + "\n";
        messageFR += "\t - Date d'échéance au plus tard : " + tache.formateDate(tache.dateFinTard) + "\n";
        messageFR += "Avancement de la tâche est de : " + tache.getAvancementTache() + "%\n";
        messageFR += "\t - Charge initiale : " + tache.chargeInitiale + " " + uniteFR + "\n";
        messageFR += "\t - Charge consommée : " + tache.chargeConsommee + " " + uniteFR + "\n";
        messageFR += "\t - Charge restante : " + tache.chargeRestante + " " + uniteFR + "\n";


        String objetEN = "Modification de la tâche " + tache.nom;

        String messageEN = "L'utilisateur " + utilisateur.prenom + " " + utilisateur.nom + " a modifié la tâche "
                + tache.nom + " du projet " + tache.projet.nom + "(client : " + tache.projet.client.nom + ")\n";
        messageFR += "Responsable : " + tache.responsableTache.prenom + tache.responsableTache.nom + "(" + tache.responsableTache.email + ")\n";
        messageFR += "Dates de la tâche :\n";
        messageFR += "\t - Date de début : " + tache.formateDate(tache.dateDebut) + "\n";
        messageFR += "\t - Date d'échéance au plus tôt : " + tache.formateDate(tache.dateFinTot) + "\n";
        messageFR += "\t - Date d'échéance au plus tard : " + tache.formateDate(tache.dateFinTard) + "\n";
        messageFR += "Avancement de la tâche est de : " + tache.getAvancementTache() + "%\n";
        messageFR += "\t - Charge initiale : " + tache.chargeInitiale + " " + uniteFR + "\n";
        messageFR += "\t - Charge consommée : " + tache.chargeConsommee + " " + uniteFR + "\n";
        messageFR += "\t - Charge restante : " + tache.chargeRestante + " " + uniteFR + "\n";

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
            if (!mapNotifications.containsKey(userANotifier)) {
                mapNotifications.put(userANotifier, new Notification(objet, message, Calendar.getInstance().getTime(), false, false, userANotifier));
            }
        }
        // Envoie des notifications aux utilisateurs qui ont une nouvelle tache disponible suite à la modification
        // de l'avancement de cette tâche
        sendNotificationTachesDisponibles(tache, mapNotifications);

        // Envoie des notifications
        sendNotifications(mapNotifications);
    }
     */

    /**
     * Appelée lorsque l'avancement d'une tache est modifiée
     * TODO : faire en sorte d'envoyer une notif quand on passe de 100% à <100%
     *
     * @param tache
     * @param mapNotifications
     */
    private static void sendNotificationTachesDisponibles(Tache tache, Map<Utilisateur, Notification> mapNotifications) {
        if (!tache.hasSuccesseur() || !tache.estTerminee())
            return;
        /** TODO : utiliser l'attribut? **/
        String objetFR = "Nouvelle(s) tâche(s) disponible(s)";

        /** TODO FAIRE EN ANGLAIS **/
        String objetEN = "Nouvelle(s) tâche(s) disponible(s)";

        String titleMessageFR = "Nouvelle(s) tâche(s) disponible(s) :";

        /** TODO FAIRE EN ANGLAIS **/
        String titleMessageEN = "Nouvelle(s) tâche(s) disponible(s) :";

        for (Tache successeur : tache.getSuccesseurs()) {
            Utilisateur utilisateur = successeur.responsableTache;
            String objet = "";
            String message = "";
            String titleMessage = "";
            if (utilisateur.langue.equals(Utilisateur.LANGUE_FR)) {
                message = "\t -" + successeur.nom + " du projet " + successeur.projet.nom + " (client : " + successeur.projet.client.nom + ")\n";
                objet = objetFR;
                titleMessage = titleMessageFR;
            }
            /** TODO : FAIRE EN ANGLAIS **/
            else if (utilisateur.langue.equals(Utilisateur.LANGUE_EN)) {
                message = "\t - " + successeur.nom + " du projet " + successeur.projet.nom + " (client : " + successeur.projet.client.nom + ")\n";
                objet = objetEN;
                titleMessage = titleMessageEN;
            }

            if (mapNotifications.containsKey(utilisateur)) {
                Notification notification = mapNotifications.get(utilisateur);

                // Ajoute l'objet si il n'est pas déjà présent
                if (!notification.title.contains(objet))
                    notification.title += " - " + objet;

                // Ajoute la phrase "De nouvelles taches disponibles" au début du message
                if (!notification.contentNotification.contains(titleMessage)) {
                    if (!notification.contentNotification.isEmpty())
                        notification.contentNotification += "\n";
                    notification.contentNotification += titleMessage;
                }

                notification.contentNotification += message;

                // Remplacement de l'ancienne notif par la nouvelle
                mapNotifications.put(utilisateur, notification);
            } else {
                mapNotifications.put(utilisateur, new Notification(objet, titleMessage + message, Calendar.getInstance().getTime(), false, false, utilisateur));
            }
        }
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
                            + tache.formateDate(tache.dateFinTard) + ")\n";
                }
            }
        }
        /** TODO : a faire en anglais **/
        else if (utilisateur.langue.equals(Utilisateur.LANGUE_EN)) {
            title = "Tâche(s) devant être terminée(s) dans moins de " + LIMIT_DATE_ECHEANCE + " jours";
            for (Tache tache : utilisateur.listTaches()) {
                long nbDeJoursRestants = Utils.differenceNbJours(today.getTime(), tache.dateFinTard);
                if (nbDeJoursRestants <= LIMIT_DATE_ECHEANCE) {
                    message += "La tâche " + tache.nom + " du projet " + tache.projet.nom
                            + "(client : " + tache.projet.client.nom + ") doit être terminé dans "
                            + nbDeJoursRestants + " jour(s) (Date d'échéance au plus tard : "
                            + tache.formateDate(tache.dateFinTard) + ")\n";
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
                notification.contentNotification += "\n" + message;
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
                            + tache.dateFinTard + "\n";
                }
            }
        }
        /** TODO : a faire en anglais **/
        else if (utilisateur.langue.equals(Utilisateur.LANGUE_EN)) {
            title = "Tâche(s) retardée(s)";
            for (Tache tache : utilisateur.listTaches()) {
                if (tache.estRetardee()) {
                    message += "La tâche " + tache.nom + " du projet " + tache.projet.nom
                            + "(client : " + tache.projet.client.nom + ") est retardée. La date d'échéance au plus tard était le : "
                            + tache.dateFinTard + "\n";
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
                notification.contentNotification += "\n" + message;
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
            titleMessage = "Voici vos nouvelles responsabilités : \n";
            message = "\t - Vous êtes le nouveau responsable du projet : " + projet.nom + " (client : " + projet.client.nom + ")\n";
        }
        /** TODO : A FAIRE EN ANGLAIS  **/
        else if (utilisateur.langue.equals(Utilisateur.LANGUE_EN)) {
            objet = "Nouvelle(s) responsabilité(s)";
            titleMessage = "Voici vos nouvelles responsabilités : \n";
            message = "\t - Vous êtes le nouveau responsable du projet : " + projet.nom + " (client : " + projet.client.nom + ")\n";
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
            titleMessage = "Voici vos nouvelles responsabilités : \n";
            message = "\t - Vous êtes le nouveau responsable de la tâche : " + tache.nom + " du projet " + tache.projet.nom + " (client : " + tache.projet.client.nom + ")\n";
        }
        /** TODO : A FAIRE EN ANGLAIS  **/
        else if (utilisateur.langue.equals(Utilisateur.LANGUE_EN)) {
            objet = "Nouvelle(s) responsabilité(s)";
            titleMessage = "Voici vos nouvelles responsabilités : \n";
            message = "\t - Vous êtes le nouveau responsable de la tâche : " + tache.nom + " du projet " + tache.projet.nom + " (client : " + tache.projet.client.nom + ")\n";
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

        /** TODO : mettre en anglais **/
        String titleEN = "Création du projet " + projet.nom;
        String messageMemeUserEN = "Vous avez créé le projet \"" + projet.nom + "\" avec les caractéristiques suivantes :\n";
        String messageAutreUserEN = utilisateur.prenom + " " + utilisateur.nom + " a créé le projet \""
                + projet.nom + "\" avec les caractéristiques suivantes :\n";

        String messageEN = "\t - Nom : " + projet.nom + "\n";
        messageEN += "\t - Client : " + projet.client.nom + "\n";
        messageEN += "\t - Responsable : " + projet.responsableProjet.prenom + " " + projet.responsableProjet.nom +
                " (" + projet.responsableProjet.email + ")\n";
        messageEN += "\t - Priorité : " + projet.priorite + "\n";
        messageEN += "\t - Date de début (théorique) : " + projet.formateDate(projet.dateDebutTheorique) + "\n";
        messageEN += "\t - Date de fin (théorique) : " + projet.formateDate(projet.dateFinTheorique) + "\n";
        messageEN += "\t - Description : " + projet.description + "\n";

        String title = "";
        String message = "";
        // Envoie notification a l'utilisateur
        if (utilisateur.equals(projet.responsableProjet) || utilisateur.recevoirNotifPourMesActions) {
            if (utilisateur.langue.equals(Utilisateur.LANGUE_FR)) {
                title = titleFR;
                message = messageMemeUserFR + messageFR;
            } else if (utilisateur.langue.equals(Utilisateur.LANGUE_EN)) {
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
        String messageMemeUserFR = "Vous avez supprimé le projet \"" + projet.nom + "\" (client : " + projet.client.nom + ")\n";
        String messageAutreUserFR = utilisateur.prenom + " " + utilisateur.nom + " a supprimé le projet " + projet.nom + "\" (client : " + projet.client.nom + ")\n";

        /** TODO ANGLAIS **/
        String titleEN = "Suppression du projet " + projet.nom;
        String messageMemeUserEN = "Vous avez supprimé le projet \"" + projet.nom + "\" (client : " + projet.client.nom + ")\n";
        String messageAutreUserEN = utilisateur.prenom + " " + utilisateur.nom + " a supprimé le projet " + projet.nom + "\" (client : " + projet.client.nom + ")\n";

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
        String messageMemeUserFR = "Vous avez modifié le projet " + projet.nom + " (client : " + projet.client.nom + ") : \n";
        String messageAutreUserFR = utilisateur.prenom + " " + utilisateur.nom + " a modifié le projet " + projet.nom + " (client : " + projet.client.nom + ") : \n";

        String messageProjetFR = "\t - Nom : " + projet.nom + "\n";
        messageProjetFR += "\t - Client : " + projet.client.nom + "\n";
        messageProjetFR += "\t - Responsable de projet : " + projet.responsableProjet.prenom + " " + projet.responsableProjet.nom + "\n";

        /** TODO ANGLAIS **/
        String titleEN = "Modification du projet " + projet.nom;
        String titleENManyChangements = "Des changements ont eu lieu dans vos tâches/projets";
        String messageMemeUserEN = "Vous avez modifié le projet " + projet.nom + " (client : " + projet.client.nom + ") : \n";
        String messageAutreUserEN = utilisateur.prenom + " " + utilisateur.nom + " a modifié le projet " + projet.nom + " (client : " + projet.client.nom + ") : \n";

        String messageProjetEN = "\t - Nom : " + projet.nom + "\n";
        messageProjetEN += "\t - Client : " + projet.client.nom + "\n";
        messageProjetEN += "\t - Responsable de projet : " + projet.responsableProjet.prenom + " " + projet.responsableProjet.nom + "\n";

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

    public static void sendNotificationModifierResponsableProjet(Projet projet, Utilisateur utilisateur, HashMap<Utilisateur, Notification> mapNotifications) {
        String titleNouveauRespoFR = "Nouvelle affectation d'un projet";
        String messageNouveauRespoFR = "Vous êtes le nouveau responsable du projet " + projet.nom + " (client : " + projet.client.nom + ")\n";

        String titleAncienRespoFR = "Désaffectation d'un projet";
        String messageAncienRespoFR = "Vous n'êtes plus responsable du projet " + projet.nom + " (client : " + projet.client.nom + ")\n";

        String titleFR = "Modification du projet " + projet.nom;
        String titleFRManyChangements = "Des changements ont eu lieu dans vos tâches/projets";
        String messageMemeUserFR = "Vous avez modifié le projet " + projet.nom + " (client : " + projet.client.nom + ") : \n";
        String messageAutreUserFR = utilisateur.prenom + " " + utilisateur.nom + " a modifié le projet " + projet.nom + " (client : " + projet.client.nom + ") : \n";

        String messageProjetFR = "\t - Nom : " + projet.nom + "\n";
        messageProjetFR += "\t - Client : " + projet.client.nom + "\n";
        messageProjetFR += "\t - Nouveau responsable de projet : " + projet.responsableProjet.prenom + " " + projet.responsableProjet.nom + "\n";

        /** TODO ANGLAIS **/
        String titleNouveauRespoEN = "Nouvelle affectation d'un projet";
        String messageNouveauRespoEN = "Vous êtes le nouveau responsable du projet " + projet.nom + " (client : " + projet.client.nom + ")\n";

        String titleAncienRespoEN = "Désaffectation d'un projet";
        String messageAncienRespoEN = "Vous n'êtes plus responsable du projet " + projet.nom + " (client : " + projet.client.nom + ")\n";

        String titleEN = "Modification du projet " + projet.nom;
        String titleENManyChangements = "Des changements ont eu lieu dans vos tâches/projets";
        String messageMemeUserEN = "Vous avez modifié le projet " + projet.nom + " (client : " + projet.client.nom + ") : \n";
        String messageAutreUserEN = utilisateur.prenom + " " + utilisateur.nom + " a modifié le projet " + projet.nom + " (client : " + projet.client.nom + ") : \n";

        String messageProjetEN = "\t - Nom : " + projet.nom + "\n";
        messageProjetEN += "\t - Client : " + projet.client.nom + "\n";
        messageProjetFR += "\t - Nouveau responsable de projet : " + projet.responsableProjet.prenom + " " + projet.responsableProjet.nom + "\n";

        List<Utilisateur> listUserTemporaire = new ArrayList<Utilisateur>();

        // Notif pour l'utilisateur qui a fait l'action
        if (utilisateur.recevoirNotifPourMesActions || utilisateur.equals(projet.responsableProjet)
                || utilisateur.equals(utilisateur.mapNotificationsGenerees.ancienResponsableProjet)) {
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
        if (!utilisateur.equals(utilisateur.mapNotificationsGenerees.ancienResponsableProjet)) {
            Utilisateur ancienRespo = utilisateur.mapNotificationsGenerees.ancienResponsableProjet;
            updateMapNotifications(ancienRespo, titleAncienRespoFR, messageAncienRespoFR, titleFRManyChangements,
                    titleAncienRespoEN, messageAncienRespoEN, titleENManyChangements, mapNotifications);
            listUserTemporaire.add(ancienRespo);
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
        String messageMemeUserFR = "Vous avez créé la tâche \"" + tache.nom + "\" avec les caractéristiques suivantes :\n";
        String messageAutreUserFR = utilisateur.prenom + " " + utilisateur.nom + " a créé la tâche \""
                + tache.nom + "\" avec les caractéristiques suivantes :\n";

        String titleFRManyChangements = "Des changements ont eu lieu dans vos tâches/projets";

        String messageFR = "\t - Nom : " + tache.nom + "\n";
        messageFR += "\t - Projet : " + tache.projet.nom + "\n";
        messageFR += "\t - Client : " + tache.projet.client.nom + "\n";
        messageFR += "\t - Responsable : " + tache.responsableTache.prenom + " " + tache.responsableTache.nom +
                " (" + tache.responsableTache.email + ")\n";
        messageFR += "\t - Date de début : " + tache.formateDate(tache.dateDebut) + "\n";
        messageFR += "\t - Date d'échéance au plus tôt : " + tache.formateDate(tache.dateFinTot) + "\n";
        messageFR += "\t - Date d'échéance au plus tard : " + tache.formateDate(tache.dateFinTard) + "\n";
        messageFR += "\t - Charge initiale : " + tache.chargeInitiale + (tache.projet.hasUniteJour() ? " J" : " semaine(s)") + "\n";

        /** TODO ANGLAIS **/
        String titleEN = "Création de la tâche " + tache.nom;
        String messageMemeUserEN = "Vous avez créé la tâche \"" + tache.nom + "\" avec les caractéristiques suivantes :\n";
        String messageAutreUserEN = utilisateur.prenom + " " + utilisateur.nom + " a créé la tâche \""
                + tache.nom + "\" avec les caractéristiques suivantes :\n";

        String titleENManyChangements = "Des changements ont eu lieu dans vos tâches/projets";

        String messageEN = "\t - Nom : " + tache.nom + "\n";
        messageEN += "\t - Projet : " + tache.projet.nom + "\n";
        messageEN += "\t - Client : " + tache.projet.client.nom + "\n";
        messageEN += "\t - Responsable : " + tache.responsableTache.prenom + " " + tache.responsableTache.nom +
                " (" + tache.responsableTache.email + ")\n";
        messageEN += "\t - Date de début : " + tache.formateDate(tache.dateDebut) + "\n";
        messageEN += "\t - Date d'échéance au plus tôt : " + tache.formateDate(tache.dateFinTot) + "\n";
        messageEN += "\t - Date d'échéance au plus tard : " + tache.formateDate(tache.dateFinTard) + "\n";
        messageEN += "\t - Charge initiale : " + tache.chargeInitiale + (tache.projet.hasUniteJour() ? " J" : " semaine(s)") + "\n";

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
                + tache.nom + " du projet " + tache.projet.nom + "(client : " + tache.projet.client.nom + ")\n";
        String messageAutreUserFR = utilisateur.prenom + " " + utilisateur.nom + " a modifié l'avancement de la tâche "
                + tache.nom + " du projet " + tache.projet.nom + "(client : " + tache.projet.client.nom + ")\n";

        String titleFRManyChangements = "Des changements ont eu lieu dans vos tâches/projets";

        String messageFR = "Le nouvel avancement de la tâche est de : " + tache.getAvancementTache() + "%\n";
        messageFR += "\t - Charge initiale : " + tache.chargeInitiale + " " + uniteFR + "\n";
        messageFR += "\t - Charge consommée : " + tache.chargeConsommee + " " + uniteFR + "\n";
        messageFR += "\t - Charge restante : " + tache.chargeRestante + " " + uniteFR + "\n";

        /** TODO : mettre en anglais **/
        String titleEN = "Modification de l'avancement de la tâche " + tache.nom;

        String messageMemeUserEN = "Vous avez modifié l'avancement de la tâche "
                + tache.nom + " du projet " + tache.projet.nom + "(client : " + tache.projet.client.nom + ")\n";
        String messageAutreUserEN = utilisateur.prenom + " " + utilisateur.nom + " a modifié l'avancement de la tâche "
                + tache.nom + " du projet " + tache.projet.nom + "(client : " + tache.projet.client.nom + ")\n";
        String titleENManyChangements = "Des changements ont eu lieu dans vos tâches/projets";

        String messageEN = "Le nouvel avancement de la tâche est de : " + tache.getAvancementTache() + "%\n";
        messageEN += "Le nouvel avancement de la tâche est de : " + tache.getAvancementTache() + "%\n";
        messageEN += "\t - Charge initiale : " + tache.chargeInitiale + " " + uniteEN + "\n";
        messageEN += "\t - Charge consommée : " + tache.chargeConsommee + " " + uniteEN + "\n";
        messageEN += "\t - Charge restante : " + tache.chargeRestante + " " + uniteEN + "\n";

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
                + tache.nom + " du projet " + tache.projet.nom + "(client : " + tache.projet.client.nom + ")\n";
        String messageAutreUserFR = utilisateur.prenom + " " + utilisateur.nom + " a modifié la tâche "
                + tache.nom + " du projet " + tache.projet.nom + "(client : " + tache.projet.client.nom + ")\n";

        String messageFR = "Responsable : " + tache.responsableTache.prenom + tache.responsableTache.nom + "(" + tache.responsableTache.email + ")\n";
        messageFR += "Etat de la tâche : " + (tache.disponible ? "disponible" : "indisponible") + "\n";
        messageFR += "Dates de la tâche :\n";
        messageFR += "\t - Date de début : " + tache.formateDate(tache.dateDebut) + "\n";
        messageFR += "\t - Date d'échéance au plus tôt : " + tache.formateDate(tache.dateFinTot) + "\n";
        messageFR += "\t - Date d'échéance au plus tard : " + tache.formateDate(tache.dateFinTard) + "\n";
        messageFR += "Avancement de la tâche est de : " + tache.getAvancementTache() + "%\n";
        messageFR += "\t - Charge initiale : " + tache.chargeInitiale + " " + uniteFR + "\n";
        messageFR += "\t - Charge consommée : " + tache.chargeConsommee + " " + uniteFR + "\n";
        messageFR += "\t - Charge restante : " + tache.chargeRestante + " " + uniteFR + "\n";

        String titleFRManyChangements = "Des changements ont eu lieu dans vos tâches/projets";

        /** TODO ANGLAIS **/
        String titleEN = "Modification de la tâche " + tache.nom;

        String messageMemeUserEN = "Vous avez modifié la tâche "
                + tache.nom + " du projet " + tache.projet.nom + "(client : " + tache.projet.client.nom + ")\n";
        String messageAutreUserEN = utilisateur.prenom + " " + utilisateur.nom + " a modifié la tâche "
                + tache.nom + " du projet " + tache.projet.nom + "(client : " + tache.projet.client.nom + ")\n";

        String messageEN = "Responsable : " + tache.responsableTache.prenom + " " + tache.responsableTache.nom + "(" + tache.responsableTache.email + ")\n";
        messageEN += "Etat de la tâche : " + (tache.disponible ? "disponible" : "indisponible") + "\n";
        messageEN += "Dates de la tâche :\n";
        messageEN += "\t - Date de début : " + tache.formateDate(tache.dateDebut) + "\n";
        messageEN += "\t - Date d'échéance au plus tôt : " + tache.formateDate(tache.dateFinTot) + "\n";
        messageEN += "\t - Date d'échéance au plus tard : " + tache.formateDate(tache.dateFinTard) + "\n";
        messageEN += "Avancement de la tâche est de : " + tache.getAvancementTache() + "%\n";
        messageEN += "\t - Charge initiale : " + tache.chargeInitiale + " " + uniteFR + "\n";
        messageEN += "\t - Charge consommée : " + tache.chargeConsommee + " " + uniteFR + "\n";
        messageEN += "\t - Charge restante : " + tache.chargeRestante + " " + uniteFR + "\n";

        String titleENManyChangements = "Des changements ont eu lieu dans vos tâches/projets";

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

    public static void sendNotificationModifierResponsableTache(Tache tache, Utilisateur utilisateur, HashMap<Utilisateur, Notification> mapNotifications) {
        String uniteFR, uniteEN;
        if (tache.projet.hasUniteJour()) {
            uniteFR = "jour(s)";
            uniteEN = "day(s)";
        } else {
            uniteFR = "semaine(s)";
            uniteEN = "week(s)";
        }

        String titleNouveauRespoFR = "Nouvelle affectation d'une tache";
        String messageNouveauRespoFR = "Vous êtes le nouveau responsable de la tâche " + tache.nom + " (client : " + tache.projet.client.nom + ")\n";

        String titleAncienRespoFR = "Désaffectation d'un projet";
        String messageAncienRespoFR = "Vous n'êtes plus responsable du projet " + tache.nom + " (client : " + tache.projet.client.nom + ")\n";

        String titleFR = "Modification de la tâche " + tache.nom;
        String titleFRManyChangements = "Des changements ont eu lieu dans vos tâches/projets";
        String messageMemeUserFR = "Vous avez modifié la tâche " + tache.nom + " (client : " + tache.projet.client.nom + ") : \n";
        String messageAutreUserFR = utilisateur.prenom + " " + utilisateur.nom + " a modifié la tache " + tache.nom + " (client : " + tache.projet.client.nom + ") : \n";

        String messageFR = "Nouveau responsable : " + tache.responsableTache.prenom + " " + tache.responsableTache.nom + "(" + tache.responsableTache.email + ")\n";
        messageFR += "Etat de la tâche : " + (tache.disponible ? "disponible" : "indisponible") + "\n";
        messageFR += "Dates de la tâche :\n";
        messageFR += "\t - Date de début : " + tache.formateDate(tache.dateDebut) + "\n";
        messageFR += "\t - Date d'échéance au plus tôt : " + tache.formateDate(tache.dateFinTot) + "\n";
        messageFR += "\t - Date d'échéance au plus tard : " + tache.formateDate(tache.dateFinTard) + "\n";
        messageFR += "Avancement de la tâche est de : " + tache.getAvancementTache() + "%\n";
        messageFR += "\t - Charge initiale : " + tache.chargeInitiale + " " + uniteFR + "\n";
        messageFR += "\t - Charge consommée : " + tache.chargeConsommee + " " + uniteFR + "\n";
        messageFR += "\t - Charge restante : " + tache.chargeRestante + " " + uniteFR + "\n";

        /** TODO ANGLAIS **/
        String titleNouveauRespoEN = "Nouvelle affectation d'une tache";
        String messageNouveauRespoEN = "Vous êtes le nouveau responsable de la tâche " + tache.nom + " (client : " + tache.projet.client.nom + ")\n";

        String titleAncienRespoEN = "Désaffectation d'un projet";
        String messageAncienRespoEN = "Vous n'êtes plus responsable du projet " + tache.nom + " (client : " + tache.projet.client.nom + ")\n";

        String titleEN = "Modification de la tâche " + tache.nom;
        String titleENManyChangements = "Des changements ont eu lieu dans vos tâches/projets";
        String messageMemeUserEN = "Vous avez modifié la tâche " + tache.nom + " (client : " + tache.projet.client.nom + ") : \n";
        String messageAutreUserEN = utilisateur.prenom + " " + utilisateur.nom + " a modifié la tache " + tache.nom + " (client : " + tache.projet.client.nom + ") : \n";

        String messageEN = "Nouveau responsable : " + tache.responsableTache.prenom + " " + tache.responsableTache.nom + "(" + tache.responsableTache.email + ")\n";
        messageEN += "Etat de la tâche : " + (tache.disponible ? "disponible" : "indisponible") + "\n";
        messageEN += "Dates de la tâche :\n";
        messageEN += "\t - Date de début : " + tache.formateDate(tache.dateDebut) + "\n";
        messageEN += "\t - Date d'échéance au plus tôt : " + tache.formateDate(tache.dateFinTot) + "\n";
        messageEN += "\t - Date d'échéance au plus tard : " + tache.formateDate(tache.dateFinTard) + "\n";
        messageEN += "Avancement de la tâche est de : " + tache.getAvancementTache() + "%\n";
        messageEN += "\t - Charge initiale : " + tache.chargeInitiale + " " + uniteEN + "\n";
        messageEN += "\t - Charge consommée : " + tache.chargeConsommee + " " + uniteEN + "\n";
        messageEN += "\t - Charge restante : " + tache.chargeRestante + " " + uniteEN + "\n";
        List<Utilisateur> listUserTemporaire = new ArrayList<Utilisateur>();

        // Notif pour l'utilisateur qui a fait l'action
        if (utilisateur.recevoirNotifPourMesActions || utilisateur.equals(tache.projet.responsableProjet)
                || utilisateur.equals(utilisateur.mapNotificationsGenerees.ancienResponsableProjet)) {
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
        if (!utilisateur.equals(utilisateur.mapNotificationsGenerees.ancienResponsableProjet)) {
            Utilisateur ancienRespo = utilisateur.mapNotificationsGenerees.ancienResponsableTache;
            updateMapNotifications(ancienRespo, titleAncienRespoFR, messageAncienRespoFR, titleFRManyChangements,
                    titleAncienRespoEN, messageAncienRespoEN, titleENManyChangements, mapNotifications);
            listUserTemporaire.add(ancienRespo);
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
                + tache.nom + " du projet " + tache.projet.nom + "(client : " + tache.projet.client.nom + ")\n";
        String messageAutreUserFR = utilisateur.prenom + " " + utilisateur.nom + " a supprimé la tâche "
                + tache.nom + " du projet " + tache.projet.nom + "(client : " + tache.projet.client.nom + ")\n";
        String titleFRManyChangements = "Des changements ont eu lieu dans vos tâches/projets";

        /** TODO ANGLAIS **/
        String titleEN = "Suppression de la tâche " + tache.nom;
        String messageMemeUserEN = "Vous avez supprimé la tâche "
                + tache.nom + " du projet " + tache.projet.nom + "(client : " + tache.projet.client.nom + ")\n";
        String messageAutreUserEN = utilisateur.prenom + " " + utilisateur.nom + " a supprimé la tâche "
                + tache.nom + " du projet " + tache.projet.nom + "(client : " + tache.projet.client.nom + ")\n";
        String titleENManyChangements = "Des changements ont eu lieu dans vos tâches/projets";

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
            notification.contentNotification += "\n" + message;
            mapNotifications.put(utilisateur, notification);
        } else {
            mapNotifications.put(utilisateur, new Notification(title, message, Calendar.getInstance().getTime(), false, false, utilisateur));
        }
    }
}

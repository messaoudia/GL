package models;

import com.avaje.ebean.Model;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import models.Utils.Utils;
import org.apache.commons.lang3.builder.ToStringBuilder;
import play.data.format.Formats;

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
                    notification.dateEnvoi.equals(this.dateEnvoi) &&
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
            user.addNotification(notification);
        }
    }

    /**
     * Envoie une notification à tous les utilisateurs associés à la tache passé en paramètre
     * L'utilisateur passé en paramètre est l'utilisateur qui a modifié l'avancement de la tâche
     *
     * Si la modification de l'avancement entraîne un changement d'état d'une tâche (disponible/indisponible),
     * une notification est aussi envoyée (notifications groupées)
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

        /** TODO : mettre en anglais **/
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

        /** TODO : mettre en anglais **/
        String objetEN = "Modification de la tâche " + tache.nom;

        String messageEN = "L'utilisateur " + utilisateur.prenom + " " + utilisateur.nom + " a modifié la tâche "
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

        /** TODO FAIRE EN ANGLAIS **/
        String objetEN = "Nouvelle(s) tâche(s) disponible(s)";

        String titleMessageFR = "Nouvelle(s) tâche(s) disponible(s) :";

        /** TODO FAIRE EN ANGLAIS **/
        String titleMessageEN = "Nouvelle(s) tâche(s) disponible(s) :";

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
            /** TODO : FAIRE EN ANGLAIS **/
            else if(utilisateur.langue.equals(Utilisateur.LANGUE_EN)){
                message = "\t - " + successeur.nom + " du projet " + successeur.projet.nom + " (client : " + successeur.projet.client.nom + ")\n";
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
     * @param utilisateur
     */
    public static void sendNotificationTacheBientotProche(Utilisateur utilisateur){
        Calendar cal = Calendar.getInstance();
        Calendar today = new GregorianCalendar(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH)+1, cal.get(Calendar.DATE));
        int LIMIT_DATE_ECHEANCE = 5;

        String title = "";
        String message = "";

        if(utilisateur.langue.equals(Utilisateur.LANGUE_FR)){
            title = "Tâche(s) devant être terminée(s) dans moins de " + LIMIT_DATE_ECHEANCE + " jours";
            /** TODO : changer en prenant l'attribut ? **/
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
        /** TODO : a faire en anglais **/
        else if(utilisateur.langue.equals(Utilisateur.LANGUE_EN)){
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

        if(!message.isEmpty()){
            utilisateur.addNotification(new Notification(title, message, Calendar.getInstance().getTime(), false, false, utilisateur));
        }
    }

    /**
     * Prépare les notifications lors de la suppresion d'un utilisateur : l'utilisateur passé en paramètre est le nouveau responsable
     * du projet en paramètre
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
        /** TODO : A FAIRE EN ANGLAIS  **/
        else if(utilisateur.langue.equals(Utilisateur.LANGUE_EN)){
            objet = "Nouvelle(s) responsabilité(s)";
            titleMessage = "Voici vos nouvelles responsabilités : \n";
            message = "\t - Vous êtes le nouveau responsable du projet : " + projet.nom + " (client : " + projet.client.nom + ")\n";
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
        /** TODO : A FAIRE EN ANGLAIS  **/
        else if(utilisateur.langue.equals(Utilisateur.LANGUE_EN)){
            objet = "Nouvelle(s) responsabilité(s)";
            titleMessage = "Voici vos nouvelles responsabilités : \n";
            message = "\t - Vous êtes le nouveau responsable de la tâche : " + tache.nom + " du projet " + tache.projet.nom + " (client : " + tache.projet.client.nom + ")\n";
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


}

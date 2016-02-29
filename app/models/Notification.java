package models;

import com.avaje.ebean.Model;
import org.apache.commons.lang3.builder.ToStringBuilder;
import play.data.format.Formats;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

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

    @Formats.DateTime(pattern = "dd/MM/yyyy")
    public Date dateEnvoi;
    public Boolean etatLecture;
    public Boolean archiver;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    public Utilisateur utilisateur;

    // True = tache, False = projet
    public Boolean concerneTache;
    public Tache tache;

    public Projet projet;

    public static Model.Finder<Long, Notification> find = new Model.Finder<>(Notification.class);

    public Notification(String title, String contentNotification, Date dateEnvoi, Boolean etatLecture, Boolean archiver, Utilisateur utilisateur, Tache tache, Projet projet) {
        this.title = title;
        this.contentNotification = contentNotification;
        this.dateEnvoi = dateEnvoi;
        this.etatLecture = etatLecture;
        this.archiver = archiver;
        this.utilisateur = utilisateur;
        if (tache == null && projet == null) {
            throw new IllegalArgumentException("Une notification concerne au moins une tache ou un projet. Veuillez renseigner un des deux");
        }
        if (tache == null) {
            this.tache = null;
            this.projet = projet;
            this.concerneTache = false;
        } else {
            this.tache = tache;
            this.projet = tache.projet;
            this.concerneTache = true;
        }
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
                    notification.contentNotification.equals(this.contentNotification) &&
                    notification.projet.equals(this.projet) &&
                    notification.tache.equals(this.tache) &&
                    notification.concerneTache.equals(this.concerneTache));
        } catch (ClassCastException e) {
            return false;
        }
    }

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
        messageFR += "\t - Charge initiale : " + tache.chargeInitiale + " " + uniteFR + "\n";
        messageFR += "\t - Charge consommée : " + tache.chargeConsommee + " " + uniteFR + "\n";
        messageFR += "\t - Charge restante : " + tache.chargeRestante + " " + uniteFR + "\n";

        for (Utilisateur userANotifier : tache.utilisateursNotifications) {
            if (userANotifier.langue.equals(Utilisateur.LANGUE_FR)) {
                userANotifier.addNotification(new Notification(objetFR, messageFR, Calendar.getInstance().getTime(), false, false, userANotifier, tache, null));
            } else if (userANotifier.langue.equals(Utilisateur.LANGUE_EN)) {
                userANotifier.addNotification(new Notification(objetEN, messageEN, Calendar.getInstance().getTime(), false, false, userANotifier, tache, null));
            }
        }
    }

    public static void sendNotificationModificationTache(Tache tache, Utilisateur utilisateur) {
        /*
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
        messageFR += "Le nouvel avancement de la tâche est de : " + tache.getAvancementTache() + "%\n";
        messageFR += "\t - Charge initiale : " + tache.chargeInitiale + " " + uniteFR + "\n";
        messageFR += "\t - Charge consommée : " + tache.chargeConsommee + " " + uniteFR + "\n";
        messageFR += "\t - Charge restante : " + tache.chargeRestante + " " + uniteFR + "\n";
        */

        /** TODO : mettre en anglais **/
        /*
        String objetEN = "Modification de l'avancement de la tâche " + tache.nom;

        String messageEN = "L'utilisateur " + utilisateur.prenom + " " + utilisateur.nom + " a modifié l'avancement de la tâche "
                + tache.nom + " du projet " + tache.projet.nom + "(client : " + tache.projet.client.nom + ")\n";
        messageFR += "Le nouvel avancement de la tâche est de : " + tache.getAvancementTache() + "%\n";
        messageFR += "\t - Charge initiale : " + tache.chargeInitiale + " " + uniteFR + "\n";
        messageFR += "\t - Charge consommée : " + tache.chargeConsommee + " " + uniteFR + "\n";
        messageFR += "\t - Charge restante : " + tache.chargeRestante + " " + uniteFR + "\n";

        for (Utilisateur userANotifier : tache.utilisateursNotifications) {
            if (userANotifier.langue.equals(Utilisateur.LANGUE_FR)) {
                userANotifier.addNotification(new Notification(objetFR, messageFR, Calendar.getInstance().getTime(), false, false, userANotifier, tache, null));
            } else if (userANotifier.langue.equals(Utilisateur.LANGUE_EN)) {
                userANotifier.addNotification(new Notification(objetEN, messageEN, Calendar.getInstance().getTime(), false, false, userANotifier, tache, null));
            }
        }
        */
    }
}

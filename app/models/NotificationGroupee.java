package models;

import com.avaje.ebean.Model;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table
@DiscriminatorValue("NOTIFICATIONGROUPEE")
public class NotificationGroupee extends Model {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public Long idProjetOuTache;
    public TypeNotification typeNotification;

    @ManyToOne
    public Utilisateur ancienRespo;

    public static Finder<Long, NotificationGroupee> find = new Finder<>(NotificationGroupee.class);

    @ManyToOne
    @JsonIgnore
    public Utilisateur utilisateur;

    public NotificationGroupee(Long id, TypeNotification typeNotification, Utilisateur utilisateur){
        this.idProjetOuTache = id;
        this.typeNotification = typeNotification;
        this.ancienRespo = null;
        this.utilisateur = utilisateur;
    }

    public NotificationGroupee(Long id, TypeNotification typeNotification, Utilisateur ancienRespo, Utilisateur utilisateur){
        this.idProjetOuTache = id;
        this.typeNotification = typeNotification;
        this.ancienRespo = ancienRespo;
        this.utilisateur = utilisateur;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof  NotificationGroupee){
            NotificationGroupee notificationGroupee = (NotificationGroupee) obj;
            return idProjetOuTache == notificationGroupee.idProjetOuTache;
        }
        return false;
    }

    @Override
    public String toString() {
        return "[" + (idProjetOuTache==null ? "null" : idProjetOuTache) + " , " + (typeNotification==null ? "null" : typeNotification) + " , "
                + (utilisateur == null ? "null" : utilisateur.prenom + " " + utilisateur.nom) + ", ancienRespo = " + (ancienRespo == null ? "null" : ancienRespo.email) + "]";
    }
}

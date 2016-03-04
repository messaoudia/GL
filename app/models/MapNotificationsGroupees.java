package models;

import java.util.HashMap;


public class MapNotificationsGroupees extends HashMap<Long, TypeNotification> {
    public Utilisateur ancienResponsableTache = null;
    public Utilisateur ancienResponsableProjet = null;

    public void createNotificationCreerTache(Tache tache){
        put(tache.id, TypeNotification.CREER_TACHE);
    }

    public void createNotificationModifierTache(Tache tache){
        if(!containsKey(tache.id) || get(tache.id) == TypeNotification.MODIFIER_AVANCEMENT_TACHE){
            put(tache.id, TypeNotification.MODIFIER_TACHE);
        }
    }

    public void createNotificationModifierAvancementTache(Tache tache){
        if(!containsKey(tache.id)){
            put(tache.id, TypeNotification.MODIFIER_AVANCEMENT_TACHE);
        }
    }

    public void createNotificationModifierResponsableTache(Tache tache, Utilisateur ancienResponsable){
        if(!containsKey(tache.id) || get(tache.id) != TypeNotification.CREER_TACHE){
            put(tache.id, TypeNotification.MODIFIER_RESPONSABLE_TACHE);
            this.ancienResponsableTache = ancienResponsable;
        }
    }

    public void createNotificationSupprimerTache(Tache tache){
        if(containsKey(tache.id) && get(tache.id) == TypeNotification.CREER_TACHE){
            remove(tache.id);
        }
        else{
            put(tache.id, TypeNotification.SUPPRIMER_TACHE);
        }
    }

    public void createNotificationModifierProjet(Projet projet){
        if(!containsKey(projet.id)){
            put(projet.id, TypeNotification.MODIFIER_PROJET);
        }
    }

    public void createNotificationModifierResponsableProjet(Projet projet, Utilisateur ancienResponsable){
        put(projet.id, TypeNotification.MODIFIER_RESPONSABLE_PROJET);
        this.ancienResponsableProjet= ancienResponsable;
    }

}

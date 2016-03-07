package models;

import java.util.HashMap;

// Object = n'importe qu'elle donnée pouvant être utile à l'action qui engendre la notification
public class MapNotificationsGroupees extends HashMap<Long, HashMap<TypeNotification, Object>> {

    public void createNotificationCreerTache(Tache tache){
        HashMap<TypeNotification, Object> map = new HashMap<>();
        map.put(TypeNotification.CREER_TACHE, null);
        put(tache.id, map);
    }

    public void createNotificationModifierTache(Tache tache){
        if(!containsKey(tache.id) || get(tache.id).containsKey(TypeNotification.MODIFIER_AVANCEMENT_TACHE)){
            HashMap<TypeNotification, Object> map = new HashMap<>();
            map.put(TypeNotification.MODIFIER_TACHE, null);
            put(tache.id, map);
        }
    }

    public void createNotificationModifierAvancementTache(Tache tache){
        if(!containsKey(tache.id)){
            HashMap<TypeNotification, Object> map = new HashMap<>();
            map.put(TypeNotification.MODIFIER_AVANCEMENT_TACHE, null);
            put(tache.id, map);
        }
    }

    public void createNotificationModifierResponsableTache(Tache tache, Utilisateur ancienResponsable){
        if(!containsKey(tache.id) || !get(tache.id).containsKey(TypeNotification.CREER_TACHE)){
            HashMap<TypeNotification, Object> map = new HashMap<>();
            map.put(TypeNotification.MODIFIER_RESPONSABLE_TACHE, ancienResponsable);
            put(tache.id, map);
        }
    }

    public void createNotificationSupprimerTache(Tache tache){
        if(containsKey(tache.id) && get(tache.id).containsKey(TypeNotification.CREER_TACHE)){
            remove(tache.id);
        }
        else{
            HashMap<TypeNotification, Object> map = new HashMap<>();
            map.put(TypeNotification.SUPPRIMER_TACHE, null);
            put(tache.id, map);
        }
    }

    public void createNotificationModifierProjet(Projet projet){
        if(!containsKey(projet.id)){
            HashMap<TypeNotification, Object> map = new HashMap<>();
            map.put(TypeNotification.MODIFIER_PROJET, null);
            put(projet.id, map);
        }
    }

    public void createNotificationModifierResponsableProjet(Projet projet, Utilisateur ancienResponsable){
        HashMap<TypeNotification, Object> map = new HashMap<>();
        map.put(TypeNotification.MODIFIER_RESPONSABLE_PROJET, ancienResponsable);
        put(projet.id, map);
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}

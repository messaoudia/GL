package models;

public enum TypeNotification {
    CREER_TACHE, MODIFIER_TACHE, MODIFIER_AVANCEMENT_TACHE, MODIFIER_RESPONSABLE_TACHE, SUPPRIMER_TACHE,

    MODIFIER_PROJET, MODIFIER_RESPONSABLE_PROJET;

    public static boolean isTache(TypeNotification type){
        return (type == CREER_TACHE) || (type == MODIFIER_TACHE) || (type == MODIFIER_AVANCEMENT_TACHE)
                || (type == MODIFIER_RESPONSABLE_TACHE) || (type == SUPPRIMER_TACHE);
    }

    public static boolean isProjet(TypeNotification type){
        return (type == MODIFIER_PROJET) || (type == MODIFIER_RESPONSABLE_PROJET);
    }
}

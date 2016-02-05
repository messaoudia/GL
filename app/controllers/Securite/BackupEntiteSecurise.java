package controllers.Securite;

/**
 * Created by yachironi on 30/12/15.
 */
public class BackupEntiteSecurise {

    private Long id;

    public enum Permissions {
        READ, WRITE, APPEND, TRUNCATE_EXISTING, CREATE_TACHE, CREATE_NEW, DELETE_ON_CLOSE, SPARSE, SYNC, DSYNC,
        BIDULE_PERMISSION;
    }

    public static void ajoutTache(Utilisateur utilisateur, Tache tache, BackupEntiteSecurise project) {
        if (Autorisation.getPermission(utilisateur, project) == Permissions.CREATE_TACHE) {
            //TODO
        }
    }

    private static class Utilisateur {
        public Long id;
    }

    private static class Tache {
    }

    private static class Autorisation {
        public static Permissions getPermission(Utilisateur utilisateur, BackupEntiteSecurise entiteSecurise) {
            return Autorisation.searchDatabase(entiteSecurise.id, utilisateur.id);
        }

        public static Permissions searchDatabase(Long objectId, Long subjuctId) {
            // TODO Search the database
            return null;
        }
    }
}
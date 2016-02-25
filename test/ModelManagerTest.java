import com.avaje.ebean.common.BeanList;
import models.*;
import models.Exceptions.NotAvailableTask;
import models.Utils.Utils;
import org.junit.Test;
import play.Logger;

import java.util.List;

import static org.junit.Assert.*;
import static play.test.Helpers.fakeApplication;
import static play.test.Helpers.running;
/**
 * Created by zzcoolj on 16/2/24.
 */
public class ModelManagerTest {
    @Test
    public void testCreerTacheInitialisationProjet() {
        running(fakeApplication(), ()-> {
            //projet dateDebutTheorique: 2016,2,2, dateFinTheorique: 2016,2,10, dateDebutReel: 2016,2,3, dateFinReelTot: 2016,2,9, dateFinReelTard: 2016,2,9
            Projet projet = new Projet("Site Apple","Développement du nouveau site d'Apple", null,
                    Utils.getDateFrom(2016,2,2),Utils.getDateFrom(2016,2,10),Utils.getDateFrom(2016,2,3),
                    Utils.getDateFrom(2016,2,9),Utils.getDateFrom(2016,2,9),24D, UniteProjetEnum.SEMAINE,new Byte("0"),false,false,null,3,null,null);
            projet.save();

            //tache dateDebut: (2016,2,3), dateFinTot: (2016,2,4), dateFinTard: (2016,2,4)
            // Attention! C'est obligé de initialiser utilisateursNotifications, null ne passe pas pour initializ Tache.
            List<Utilisateur> utilisateursNotifications = new BeanList<>();
            Tache tache = new Tache("Tache","Cette tâche permet de réaliser l'étude du projet",0,true, Utils.getDateFrom(2016,2,3),
                    Utils.getDateFrom(2016,2,4),Utils.getDateFrom(2016,2,4),20D,10D,20D,null,null,utilisateursNotifications);
            tache.save();

            Utilisateur utilisateur = new Utilisateur("Z", "Z", "z.z@gmail.com", "1234567980", true, "123456Aa", null, null, null,null);
            utilisateur.save();
            // Attention! C'est obligé d'ajouter un responsable pour tache.
            tache.associerResponsable(utilisateur);

            try {
                projet.creerTacheInitialisationProjet(tache);

                Tache tacheSelected = Tache.find.byId(tache.id);
                assertEquals(tacheSelected.idTache, "1");
                assertEquals(tacheSelected.niveau, Integer.valueOf(0));
                assertEquals(tacheSelected.parent, null);

                Projet projetSelected = Projet.find.byId(projet.id);
                // Attention! assertTrue(projet.listTaches.contains(tacheSelected)); marche
                assertTrue(projetSelected.listTaches.contains(tacheSelected));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}

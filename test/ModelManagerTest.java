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
                    Utils.getDateFrom(2016,2,9),Utils.getDateFrom(2016,2,9),24D, UniteProjetEnum.SEMAINE,new Byte("0"),false,false,null,3,null);
            projet.save();

            //tache dateDebut: (2016,2,3), dateFinTot: (2016,2,4), dateFinTard: (2016,2,4)
            Tache tache = new Tache("Tache","Cette tâche permet de réaliser l'étude du projet",0,true, Utils.getDateFrom(2016,2,3),
                    Utils.getDateFrom(2016,2,4),Utils.getDateFrom(2016,2,4),20D,10D,20D,null,null);
            tache.save();

            try {
                projet.creerTacheInitialisationProjet(tache);

                Tache tacheSelected = Tache.find.byId(tache.id);
                assertEquals(tacheSelected.idTache, "1");
                assertEquals(tacheSelected.niveau, Integer.valueOf(0));
                assertEquals(tacheSelected.parent, null);

                Projet projetSelected = Projet.find.byId(projet.id);
                assertTrue(projetSelected.listTaches().contains(tacheSelected));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    @Test
    public void testCreerTacheAuDessus() {
        running(fakeApplication(), ()-> {
            //projet dateDebutTheorique: 2016,2,2, dateFinTheorique: 2016,2,10, dateDebutReel: 2016,2,3, dateFinReelTot: 2016,2,9, dateFinReelTard: 2016,2,9
            Projet projet = new Projet("Site Apple","Développement du nouveau site d'Apple", null,
                    Utils.getDateFrom(2016,2,2),Utils.getDateFrom(2016,2,10),Utils.getDateFrom(2016,2,3),
                    Utils.getDateFrom(2016,2,9),Utils.getDateFrom(2016,2,9),24D, UniteProjetEnum.SEMAINE,new Byte("0"),false,false,null,3,null);
            projet.save();

            //tache dateDebut: (2016,2,3), dateFinTot: (2016,2,4), dateFinTard: (2016,2,4)
            Tache tache1 = new Tache("Tache1","Cette tâche permet de réaliser l'étude du projet",0,true, Utils.getDateFrom(2016,2,3),
                    Utils.getDateFrom(2016,2,4),Utils.getDateFrom(2016,2,4),20D,10D,20D,null,null);
            tache1.save();

            //tache dateDebut: (2016,2,3), dateFinTot: (2016,2,4), dateFinTard: (2016,2,4)
            Tache tache2 = new Tache("Tache1","Cette tâche permet de réaliser l'étude du projet",0,true, Utils.getDateFrom(2016,2,3),
                    Utils.getDateFrom(2016,2,4),Utils.getDateFrom(2016,2,4),20D,10D,20D,null,null);
            tache2.save();

            try {
                projet.creerTacheInitialisationProjet(tache1);
                // tache2: idTache=1; tache1: idTache=2
                projet.creerTacheAuDessus(tache2, tache1);

                Tache tache2Selected = Tache.find.byId(tache2.id);
                Projet projetSelected = Projet.find.byId(projet.id);

                assertTrue(projetSelected.listTaches().contains(tache2Selected));
                assertEquals(tache1.idTache, "2");
                assertEquals(tache2.idTache, "1");

                //TODO test the case where project has sous taches.
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}

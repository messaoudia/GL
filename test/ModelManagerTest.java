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
            Utilisateur utilisateur = new Utilisateur("Z", "Z", "z.z@gmail.com", "1234567980", true, "123456Aa");
            utilisateur.save();

            Client client = new Client("Apple", 2, false, null, new BeanList<Contact>(), new BeanList<Projet>());

            // TODO: Attention! C'est obligé d'ajouter un responsable dans le constructeur de Projet.
            //projet dateDebutTheorique: 2016,2,2, dateFinTheorique: 2016,2,10, dateDebutReel: 2016,2,3, dateFinReelTot: 2016,2,9, dateFinReelTard: 2016,2,9
            Projet projet = new Projet("Site Apple","Développement du nouveau site d'Apple", utilisateur,
                    Utils.getDateFrom(2016,2,2),Utils.getDateFrom(2016,2,10),Utils.getDateFrom(2016,2,3),
                    Utils.getDateFrom(2016,2,9),Utils.getDateFrom(2016,2,9),24D, UniteProjetEnum.SEMAINE,new Byte("0"),false,false,client,3,null,null);
            projet.save();

            //tache dateDebut: (2016,2,3), dateFinTot: (2016,2,4), dateFinTard: (2016,2,4)
            Tache tache = new Tache("Tache","Cette tâche permet de réaliser l'étude du projet",0,true, Utils.getDateFrom(2016,2,3),
                    Utils.getDateFrom(2016,2,4),Utils.getDateFrom(2016,2,4),20D,10D,20D,null,null,null);
            tache.save();

            // TODO: Attention! C'est obligé d'ajouter un responsable pour une tache.
            //projet.associerResponsable(utilisateur);
            tache.associerResponsable(utilisateur);

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
                    Utils.getDateFrom(2016,2,9),Utils.getDateFrom(2016,2,9),24D, UniteProjetEnum.SEMAINE,new Byte("0"),false,false,null,3,null,null);
            projet.save();

            //tache dateDebut: (2016,2,3), dateFinTot: (2016,2,4), dateFinTard: (2016,2,4)
            Tache tache1 = new Tache("Tache1","Cette tâche permet de réaliser l'étude du projet",0,true, Utils.getDateFrom(2016,2,3),
                    Utils.getDateFrom(2016,2,4),Utils.getDateFrom(2016,2,4),20D,10D,20D,null,null,null);
            tache1.save();

            //tache dateDebut: (2016,2,3), dateFinTot: (2016,2,4), dateFinTard: (2016,2,4)
            Tache tache2 = new Tache("Tache1","Cette tâche permet de réaliser l'étude du projet",0,true, Utils.getDateFrom(2016,2,3),
                    Utils.getDateFrom(2016,2,4),Utils.getDateFrom(2016,2,4),20D,10D,20D,null,null,null);
            tache2.save();

            try {
                projet.creerTacheInitialisationProjet(tache1);
                // tache2: idTache=1; tache1: idTache=2
                projet.creerTacheAuDessus(tache2, tache1);

                Tache tache1Selected = Tache.find.byId(tache1.id);
                Tache tache2Selected = Tache.find.byId(tache2.id);
                Projet projetSelected = Projet.find.byId(projet.id);

                assertTrue(projetSelected.listTaches().contains(tache2Selected));
                assertEquals(tache1Selected.idTache, "2");
                assertEquals(tache2Selected.idTache, "1");

                //TODO test the case where project has sous taches.
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    @Test
    public void testCreerTacheEnDessous() {
        running(fakeApplication(), ()-> {
            //projet dateDebutTheorique: 2016,2,2, dateFinTheorique: 2016,2,10, dateDebutReel: 2016,2,3, dateFinReelTot: 2016,2,9, dateFinReelTard: 2016,2,9
            Projet projet = new Projet("Site Apple","Développement du nouveau site d'Apple", null,
                    Utils.getDateFrom(2016,2,2),Utils.getDateFrom(2016,2,10),Utils.getDateFrom(2016,2,3),
                    Utils.getDateFrom(2016,2,9),Utils.getDateFrom(2016,2,9),24D, UniteProjetEnum.SEMAINE,new Byte("0"),false,false,null,3,null,null);
            projet.save();

            //tache dateDebut: (2016,2,3), dateFinTot: (2016,2,4), dateFinTard: (2016,2,4)
            Tache tache1 = new Tache("Tache1","Cette tâche permet de réaliser l'étude du projet",0,true, Utils.getDateFrom(2016,2,3),
                    Utils.getDateFrom(2016,2,4),Utils.getDateFrom(2016,2,4),20D,10D,20D,null,null,null);
            tache1.save();

            //tache dateDebut: (2016,2,3), dateFinTot: (2016,2,4), dateFinTard: (2016,2,4)
            Tache tache2 = new Tache("Tache1","Cette tâche permet de réaliser l'étude du projet",0,true, Utils.getDateFrom(2016,2,3),
                    Utils.getDateFrom(2016,2,4),Utils.getDateFrom(2016,2,4),20D,10D,20D,null,null,null);
            tache2.save();

            try {
                projet.creerTacheInitialisationProjet(tache1);
                // tache2: idTache=2; tache1: idTache=1
                projet.creerTacheEnDessous(tache2, tache1);

                Tache tache1Selected = Tache.find.byId(tache1.id);
                Tache tache2Selected = Tache.find.byId(tache2.id);
                Projet projetSelected = Projet.find.byId(projet.id);

                assertTrue(projetSelected.listTaches().contains(tache2Selected));
                assertEquals(tache1Selected.idTache, "1");
                assertEquals(tache2Selected.idTache, "2");

                //TODO test the case where project has sous taches.
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    @Test
    public void testCreerSousTache() {
        running(fakeApplication(), ()-> {
            //projet dateDebutTheorique: 2016,2,2, dateFinTheorique: 2016,2,10, dateDebutReel: 2016,2,3, dateFinReelTot: 2016,2,9, dateFinReelTard: 2016,2,9
            Projet projet = new Projet("Site Apple","Développement du nouveau site d'Apple", null,
                    Utils.getDateFrom(2016,2,2),Utils.getDateFrom(2016,2,10),Utils.getDateFrom(2016,2,3),
                    Utils.getDateFrom(2016,2,9),Utils.getDateFrom(2016,2,9),24D, UniteProjetEnum.SEMAINE,new Byte("0"),false,false,null,3,null,null);
            projet.save();

            //tache dateDebut: (2016,2,3), dateFinTot: (2016,2,4), dateFinTard: (2016,2,4)
            Tache tache1 = new Tache("Tache1","Cette tâche permet de réaliser l'étude du projet",0,true, Utils.getDateFrom(2016,2,3),
                    Utils.getDateFrom(2016,2,4),Utils.getDateFrom(2016,2,4),20D,10D,20D,null,null,null);
            tache1.save();

            //tache dateDebut: (2016,2,3), dateFinTot: (2016,2,4), dateFinTard: (2016,2,4)
            Tache tache2 = new Tache("Tache1","Cette tâche permet de réaliser l'étude du projet",0,true, Utils.getDateFrom(2016,2,3),
                    Utils.getDateFrom(2016,2,4),Utils.getDateFrom(2016,2,4),20D,10D,20D,null,null,null);
            tache2.save();

            try {
                projet.creerTacheInitialisationProjet(tache1);
                // tache2: idTache=1.1; tache1: idTache=1
                projet.creerSousTache(tache2, tache1);

                Tache tache1Selected = Tache.find.byId(tache1.id);
                Tache tache2Selected = Tache.find.byId(tache2.id);
                Projet projetSelected = Projet.find.byId(projet.id);

                assertTrue(projetSelected.listTaches().contains(tache1Selected));
                assertTrue(projetSelected.listTaches().contains(tache2Selected));
                assertEquals(tache1Selected.idTache, "1");
                assertEquals(tache2Selected.idTache, "1.1");
                // TODO: assertTrue(tache1Selected.enfants.contains(tache2Selected)); marche pas => besoin de la fonction tache1Selected.enfants()
                //assertTrue(tache1.enfants.contains(tache2Selected));
                assertTrue(tache1Selected.enfants().contains(tache2Selected));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    @Test
    public void testIdTache() {
        running(fakeApplication(), ()-> {
            //projet dateDebutTheorique: 2016,2,2, dateFinTheorique: 2016,3,4, dateDebutReel: 2016,2,2, dateFinReelTot: 2016,3,3, dateFinReelTard: 2016,3,3
            Projet projet = new Projet("Site Apple","Développement du nouveau site d'Apple", null,
                    Utils.getDateFrom(2016,2,2),Utils.getDateFrom(2016,3,4),Utils.getDateFrom(2016,2,2),
                    Utils.getDateFrom(2016,3,3),Utils.getDateFrom(2016,3,3),24D, UniteProjetEnum.SEMAINE,new Byte("0"),false,false,null,3,null,null);
            projet.save();

            //tache dateDebut: (2016,2,2), dateFinTot: (2016,2,4), dateFinTard: (2016,2,4)
            Tache tacheA = new Tache("TacheA","Cette tâche permet de réaliser l'étude du projet",0,true, Utils.getDateFrom(2016,2,2),
                    Utils.getDateFrom(2016,2,4),Utils.getDateFrom(2016,2,4),20D,0D,20D,null,null,null);
            tacheA.save();

            //tache dateDebut: (2016,2,4), dateFinTot: (2016,2,18), dateFinTard: (2016,2,18)
            Tache tacheB = new Tache("TacheB","Cette tâche permet de réaliser l'étude du projet",0,true, Utils.getDateFrom(2016,2,4),
                    Utils.getDateFrom(2016,2,18),Utils.getDateFrom(2016,2,18),20D,0D,20D,null,null,null);
            tacheB.save();

            //tache dateDebut: (2016,2,18), dateFinTot: (2016,2,28), dateFinTard: (2016,2,28)
            Tache tacheC = new Tache("TacheC","Cette tâche permet de réaliser l'étude du projet",0,true, Utils.getDateFrom(2016,2,18),
                    Utils.getDateFrom(2016,2,28),Utils.getDateFrom(2016,2,28),20D,0D,20D,null,null,null);
            tacheC.save();

            //tache dateDebut: (2016,2,28), dateFinTot: (2016,3,3), dateFinTard: (2016,3,3)
            Tache tacheD = new Tache("TacheD","Cette tâche permet de réaliser l'étude du projet",0,true, Utils.getDateFrom(2016,2,28),
                    Utils.getDateFrom(2016,3,3),Utils.getDateFrom(2016,3,3),20D,0D,20D,null,null,null);
            tacheD.save();

            //tache dateDebut: (2016,2,18), dateFinTot: (2016,2,20), dateFinTard: (2016,2,20)
            Tache tacheE = new Tache("TacheE","Cette tâche permet de réaliser l'étude du projet",0,true, Utils.getDateFrom(2016,2,18),
                    Utils.getDateFrom(2016,2,20),Utils.getDateFrom(2016,2,20),20D,0D,20D,null,null,null);
            tacheE.save();

            //tache dateDebut: (2016,2,4), dateFinTot: (2016,2,20), dateFinTard: (2016,2,20)
            Tache tacheF = new Tache("TacheF","Cette tâche permet de réaliser l'étude du projet",0,true, Utils.getDateFrom(2016,2,4),
                    Utils.getDateFrom(2016,2,20),Utils.getDateFrom(2016,2,20),20D,0D,20D,null,null,null);
            tacheF.save();

            //tache dateDebut: (2016,2,20), dateFinTot: (2016,2,28), dateFinTard: (2016,2,28)
            Tache tacheG = new Tache("TacheG","Cette tâche permet de réaliser l'étude du projet",0,true, Utils.getDateFrom(2016,2,20),
                    Utils.getDateFrom(2016,2,28),Utils.getDateFrom(2016,2,28),20D,0D,20D,null,null,null);
            tacheG.save();

            //tache dateDebut: (2016,2,4), dateFinTot: (2016,2,5), dateFinTard: (2016,2,5)
            Tache tacheH = new Tache("TacheH","Cette tâche permet de réaliser l'étude du projet",0,true, Utils.getDateFrom(2016,2,4),
                    Utils.getDateFrom(2016,2,5),Utils.getDateFrom(2016,2,5),20D,0D,20D,null,null,null);
            tacheH.save();

            //tache dateDebut: (2016,2,5), dateFinTot: (2016,2,10), dateFinTard: (2016,2,10)
            Tache tacheI = new Tache("TacheI","Cette tâche permet de réaliser l'étude du projet",0,true, Utils.getDateFrom(2016,2,5),
                    Utils.getDateFrom(2016,2,10),Utils.getDateFrom(2016,2,10),20D,0D,20D,null,null,null);
            tacheI.save();

            //tache dateDebut: (2016,2,10), dateFinTot: (2016,2,13), dateFinTard: (2016,2,13)
            Tache tacheJ = new Tache("TacheJ","Cette tâche permet de réaliser l'étude du projet",0,true, Utils.getDateFrom(2016,2,10),
                    Utils.getDateFrom(2016,2,13),Utils.getDateFrom(2016,2,13),20D,0D,20D,null,null,null);
            tacheJ.save();

            //tache dateDebut: (2016,2,13), dateFinTot: (2016,2,18), dateFinTard: (2016,2,18)
            Tache tacheK = new Tache("TacheK","Cette tâche permet de réaliser l'étude du projet",0,true, Utils.getDateFrom(2016,2,13),
                    Utils.getDateFrom(2016,2,18),Utils.getDateFrom(2016,2,18),20D,0D,20D,null,null,null);
            tacheK.save();

            //tache dateDebut: (2016,2,5), dateFinTot: (2016,2,10), dateFinTard: (2016,2,10)
            Tache tacheL = new Tache("TacheL","Cette tâche permet de réaliser l'étude du projet",0,true, Utils.getDateFrom(2016,2,5),
                    Utils.getDateFrom(2016,2,10),Utils.getDateFrom(2016,2,10),20D,0D,20D,null,null,null);
            tacheL.save();

            //tache dateDebut: (2016,2,10), dateFinTot: (2016,2,20), dateFinTard: (2016,2,20)
            Tache tacheM = new Tache("TacheM","Cette tâche permet de réaliser l'étude du projet",0,true, Utils.getDateFrom(2016,2,10),
                    Utils.getDateFrom(2016,2,20),Utils.getDateFrom(2016,2,20),20D,0D,20D,null,null,null);
            tacheM.save();

            try {
                /* TODO: delete
                tacheA.associerSuccesseur(tacheB);
                tacheB.associerSuccesseur(tacheC);
                tacheC.associerSuccesseur(tacheD);
                tacheB.associerSuccesseur(tacheE);
                tacheA.associerSuccesseur(tacheF);
                tacheF.associerSuccesseur(tacheG);
                tacheH.associerSuccesseur(tacheI);
                tacheI.associerSuccesseur(tacheJ);
                tacheJ.associerSuccesseur(tacheK);
                tacheH.associerSuccesseur(tacheL);
                tacheL.associerSuccesseur(tacheM);
                */

                projet.creerTacheInitialisationProjet(tacheA);
                System.out.println("------ L1 -------");
                System.out.println(tacheA.nom + " " + tacheA.idTache);
                System.out.println("------ Fin - L1 -------");

                projet.creerTacheEnDessous(tacheB,tacheA);
                System.out.println("------ L2 -------");
                System.out.println(tacheA.nom + " " + tacheA.idTache);
                System.out.println(tacheB.nom + " " + tacheB.idTache);
                System.out.println("------ Fin - L2 -------");

                projet.creerTacheEnDessous(tacheC,tacheB);
                System.out.println("------ L3 -------");
                System.out.println(tacheA.nom + " " + tacheA.idTache);
                System.out.println(tacheB.nom + " " + tacheB.idTache);
                System.out.println(tacheC.nom + " " + tacheC.idTache);
                System.out.println("------ Fin - L3 -------");

                projet.creerTacheEnDessous(tacheD,tacheC);
                System.out.println("------ L4 -------");
                System.out.println(tacheA.nom + " " + tacheA.idTache);
                System.out.println(tacheB.nom + " " + tacheB.idTache);
                System.out.println(tacheC.nom + " " + tacheC.idTache);
                System.out.println(tacheD.nom + " " + tacheD.idTache);
                System.out.println("------ Fin - L4 -------");

                projet.creerTacheEnDessous(tacheE,tacheB);
                System.out.println("------ L5 -------");
                System.out.println(tacheA.nom + " " + tacheA.idTache);
                System.out.println(tacheB.nom + " " + tacheB.idTache);
                System.out.println(tacheE.nom + " " + tacheE.idTache);
                System.out.println(tacheC.nom + " " + tacheC.idTache);
                System.out.println(tacheD.nom + " " + tacheD.idTache);
                System.out.println("------ Fin - L5 -------");

                projet.creerTacheEnDessous(tacheF,tacheA);
                System.out.println("------ L6 -------");
                System.out.println(tacheA.nom + " " + tacheA.idTache);
                System.out.println(tacheF.nom + " " + tacheF.idTache);
                System.out.println(tacheB.nom + " " + tacheB.idTache);
                System.out.println(tacheE.nom + " " + tacheE.idTache);
                System.out.println(tacheC.nom + " " + tacheC.idTache);
                System.out.println(tacheD.nom + " " + tacheD.idTache);
                System.out.println("------ Fin - L6 -------");

                projet.creerTacheEnDessous(tacheG,tacheF);
                System.out.println("------ L7 -------");
                System.out.println(tacheA.nom + " " + tacheA.idTache);
                System.out.println(tacheF.nom + " " + tacheF.idTache);
                System.out.println(tacheG.nom + " " + tacheG.idTache);
                System.out.println(tacheB.nom + " " + tacheB.idTache);
                System.out.println(tacheE.nom + " " + tacheE.idTache);
                System.out.println(tacheC.nom + " " + tacheC.idTache);
                System.out.println(tacheD.nom + " " + tacheD.idTache);
                System.out.println("------ Fin - L7 -------");

                projet.creerSousTache(tacheH,tacheF);
                System.out.println("------ L8 -------");
                System.out.println(tacheF.nom + " " + tacheF.idTache);
                System.out.println(tacheH.nom + " " + tacheH.idTache);
                System.out.println("------ Fin - L8 -------");

                projet.creerTacheEnDessous(tacheI,tacheH);
                System.out.println("------ L9 -------");
                System.out.println(tacheF.nom + " " + tacheF.idTache);
                System.out.println(tacheH.nom + " " + tacheH.idTache);
                System.out.println(tacheI.nom + " " + tacheI.idTache);
                System.out.println("------ Fin - L9 -------");

                projet.creerTacheEnDessous(tacheJ,tacheI);
                System.out.println("------ L10 -------");
                System.out.println(tacheF.nom + " " + tacheF.idTache);
                System.out.println(tacheH.nom + " " + tacheH.idTache);
                System.out.println(tacheI.nom + " " + tacheI.idTache);
                System.out.println(tacheJ.nom + " " + tacheJ.idTache);
                System.out.println("------ Fin - L10 -------");

                projet.creerTacheEnDessous(tacheK,tacheJ);
                System.out.println("------ L11 -------");
                System.out.println(tacheF.nom + " " + tacheF.idTache);
                System.out.println(tacheH.nom + " " + tacheH.idTache);
                System.out.println(tacheI.nom + " " + tacheI.idTache);
                System.out.println(tacheJ.nom + " " + tacheJ.idTache);
                System.out.println(tacheK.nom + " " + tacheK.idTache);
                System.out.println("------ Fin - L11 -------");

                projet.creerTacheEnDessous(tacheL,tacheH);
                System.out.println("------ L12 -------");
                System.out.println(tacheF.nom + " " + tacheF.idTache);
                System.out.println(tacheH.nom + " " + tacheH.idTache);
                System.out.println(tacheL.nom + " " + tacheL.idTache);
                System.out.println(tacheI.nom + " " + tacheI.idTache);
                System.out.println(tacheJ.nom + " " + tacheJ.idTache);
                System.out.println(tacheK.nom + " " + tacheK.idTache);
                System.out.println("------ Fin - L12 -------");

                projet.creerTacheEnDessous(tacheM,tacheL);
                System.out.println("------ L13 -------");
                System.out.println(tacheF.nom + " " + tacheF.idTache);
                System.out.println(tacheH.nom + " " + tacheH.idTache);
                System.out.println(tacheL.nom + " " + tacheL.idTache);
                System.out.println(tacheM.nom + " " + tacheM.idTache);
                System.out.println(tacheI.nom + " " + tacheI.idTache);
                System.out.println(tacheJ.nom + " " + tacheJ.idTache);
                System.out.println(tacheK.nom + " " + tacheK.idTache);
                System.out.println("------ Fin - L13 -------");

                Projet projetSelected = Projet.find.byId(projet.id);
                Tache tacheASelected = Tache.find.byId(tacheA.id);
                Tache tacheBSelected = Tache.find.byId(tacheB.id);
                Tache tacheCSelected = Tache.find.byId(tacheC.id);
                Tache tacheDSelected = Tache.find.byId(tacheD.id);
                Tache tacheESelected = Tache.find.byId(tacheE.id);
                Tache tacheFSelected = Tache.find.byId(tacheF.id);
                Tache tacheGSelected = Tache.find.byId(tacheG.id);
                Tache tacheHSelected = Tache.find.byId(tacheH.id);
                Tache tacheISelected = Tache.find.byId(tacheI.id);
                Tache tacheJSelected = Tache.find.byId(tacheJ.id);
                Tache tacheKSelected = Tache.find.byId(tacheK.id);
                Tache tacheLSelected = Tache.find.byId(tacheL.id);
                Tache tacheMSelected = Tache.find.byId(tacheM.id);

                // TODO: Il n'y a pas de idTache: 4 et 6
                Logger.debug("IDTACHE");
                Logger.debug(tacheASelected.idTache);
                Logger.debug(tacheBSelected.idTache);
                Logger.debug(tacheCSelected.idTache);
                Logger.debug(tacheDSelected.idTache);
                Logger.debug(tacheESelected.idTache);
                Logger.debug(tacheFSelected.idTache);
                Logger.debug(tacheGSelected.idTache);
                Logger.debug(tacheHSelected.idTache);
                Logger.debug(tacheISelected.idTache);
                Logger.debug(tacheJSelected.idTache);
                Logger.debug(tacheKSelected.idTache);
                Logger.debug(tacheLSelected.idTache);
                Logger.debug(tacheMSelected.idTache);

                // Verifier si il y a 13 taches dans le projet
                assertEquals(projetSelected.listTaches().size(), 13);

                // TODO: ajouter verification de idTache
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }


    @Test
    public void testCalculeCheminCritique() {
        running(fakeApplication(), ()-> {
            //projet dateDebutTheorique: 2016,2,2, dateFinTheorique: 2016,3,4, dateDebutReel: 2016,2,2, dateFinReelTot: 2016,3,3, dateFinReelTard: 2016,3,3
            Projet projet = new Projet("Site Apple","Développement du nouveau site d'Apple", null,
                    Utils.getDateFrom(2016,2,2),Utils.getDateFrom(2016,3,4),Utils.getDateFrom(2016,2,2),
                    Utils.getDateFrom(2016,3,3),Utils.getDateFrom(2016,3,3),24D, UniteProjetEnum.SEMAINE,new Byte("0"),false,false,null,3,null,null);
            projet.save();

            //tache dateDebut: (2016,2,2), dateFinTot: (2016,2,4), dateFinTard: (2016,2,4)
            Tache tacheA = new Tache("TacheA","Cette tâche permet de réaliser l'étude du projet",0,true, Utils.getDateFrom(2016,2,2),
                    Utils.getDateFrom(2016,2,4),Utils.getDateFrom(2016,2,4),20D,0D,20D,null,null,null);
            tacheA.save();

            //tache dateDebut: (2016,2,4), dateFinTot: (2016,2,18), dateFinTard: (2016,2,18)
            Tache tacheB = new Tache("TacheB","Cette tâche permet de réaliser l'étude du projet",0,true, Utils.getDateFrom(2016,2,4),
                    Utils.getDateFrom(2016,2,18),Utils.getDateFrom(2016,2,18),20D,0D,20D,null,null,null);
            tacheB.save();

            //tache dateDebut: (2016,2,18), dateFinTot: (2016,2,28), dateFinTard: (2016,2,28)
            Tache tacheC = new Tache("TacheC","Cette tâche permet de réaliser l'étude du projet",0,true, Utils.getDateFrom(2016,2,18),
                    Utils.getDateFrom(2016,2,28),Utils.getDateFrom(2016,2,28),20D,0D,20D,null,null,null);
            tacheC.save();

            //tache dateDebut: (2016,2,28), dateFinTot: (2016,3,3), dateFinTard: (2016,3,3)
            Tache tacheD = new Tache("TacheD","Cette tâche permet de réaliser l'étude du projet",0,true, Utils.getDateFrom(2016,2,28),
                    Utils.getDateFrom(2016,3,3),Utils.getDateFrom(2016,3,3),20D,0D,20D,null,null,null);
            tacheD.save();

            //tache dateDebut: (2016,2,18), dateFinTot: (2016,2,20), dateFinTard: (2016,2,20)
            Tache tacheE = new Tache("TacheE","Cette tâche permet de réaliser l'étude du projet",0,true, Utils.getDateFrom(2016,2,18),
                    Utils.getDateFrom(2016,2,20),Utils.getDateFrom(2016,2,20),20D,0D,20D,null,null,null);
            tacheE.save();

            //tache dateDebut: (2016,2,4), dateFinTot: (2016,2,20), dateFinTard: (2016,2,20)
            Tache tacheF = new Tache("TacheF","Cette tâche permet de réaliser l'étude du projet",0,true, Utils.getDateFrom(2016,2,4),
                    Utils.getDateFrom(2016,2,20),Utils.getDateFrom(2016,2,20),20D,0D,20D,null,null,null);
            tacheF.save();

            //tache dateDebut: (2016,2,20), dateFinTot: (2016,2,28), dateFinTard: (2016,2,28)
            Tache tacheG = new Tache("TacheG","Cette tâche permet de réaliser l'étude du projet",0,true, Utils.getDateFrom(2016,2,20),
                    Utils.getDateFrom(2016,2,28),Utils.getDateFrom(2016,2,28),20D,0D,20D,null,null,null);
            tacheG.save();

            //tache dateDebut: (2016,2,4), dateFinTot: (2016,2,5), dateFinTard: (2016,2,5)
            Tache tacheH = new Tache("TacheH","Cette tâche permet de réaliser l'étude du projet",0,true, Utils.getDateFrom(2016,2,4),
                    Utils.getDateFrom(2016,2,5),Utils.getDateFrom(2016,2,5),20D,0D,20D,null,null,null);
            tacheH.save();

            //tache dateDebut: (2016,2,5), dateFinTot: (2016,2,10), dateFinTard: (2016,2,10)
            Tache tacheI = new Tache("TacheI","Cette tâche permet de réaliser l'étude du projet",0,true, Utils.getDateFrom(2016,2,5),
                    Utils.getDateFrom(2016,2,10),Utils.getDateFrom(2016,2,10),20D,0D,20D,null,null,null);
            tacheI.save();

            //tache dateDebut: (2016,2,10), dateFinTot: (2016,2,13), dateFinTard: (2016,2,13)
            Tache tacheJ = new Tache("TacheJ","Cette tâche permet de réaliser l'étude du projet",0,true, Utils.getDateFrom(2016,2,10),
                    Utils.getDateFrom(2016,2,13),Utils.getDateFrom(2016,2,13),20D,0D,20D,null,null,null);
            tacheJ.save();

            //tache dateDebut: (2016,2,13), dateFinTot: (2016,2,18), dateFinTard: (2016,2,18)
            Tache tacheK = new Tache("TacheK","Cette tâche permet de réaliser l'étude du projet",0,true, Utils.getDateFrom(2016,2,13),
                    Utils.getDateFrom(2016,2,18),Utils.getDateFrom(2016,2,18),20D,0D,20D,null,null,null);
            tacheK.save();

            //tache dateDebut: (2016,2,5), dateFinTot: (2016,2,10), dateFinTard: (2016,2,10)
            Tache tacheL = new Tache("TacheL","Cette tâche permet de réaliser l'étude du projet",0,true, Utils.getDateFrom(2016,2,5),
                    Utils.getDateFrom(2016,2,10),Utils.getDateFrom(2016,2,10),20D,0D,20D,null,null,null);
            tacheL.save();

            //tache dateDebut: (2016,2,10), dateFinTot: (2016,2,20), dateFinTard: (2016,2,20)
            Tache tacheM = new Tache("TacheM","Cette tâche permet de réaliser l'étude du projet",0,true, Utils.getDateFrom(2016,2,10),
                    Utils.getDateFrom(2016,2,20),Utils.getDateFrom(2016,2,20),20D,0D,20D,null,null,null);
            tacheM.save();

            try {
                /* TODO: delete
                tacheA.associerSuccesseur(tacheB);
                tacheB.associerSuccesseur(tacheC);
                tacheC.associerSuccesseur(tacheD);
                tacheB.associerSuccesseur(tacheE);
                tacheA.associerSuccesseur(tacheF);
                tacheF.associerSuccesseur(tacheG);
                tacheH.associerSuccesseur(tacheI);
                tacheI.associerSuccesseur(tacheJ);
                tacheJ.associerSuccesseur(tacheK);
                tacheH.associerSuccesseur(tacheL);
                tacheL.associerSuccesseur(tacheM);
                */

                projet.creerTacheInitialisationProjet(tacheA);
                projet.creerTacheEnDessous(tacheB,tacheA);
                projet.creerTacheEnDessous(tacheC,tacheB);
                projet.creerTacheEnDessous(tacheD,tacheC);
                projet.creerTacheEnDessous(tacheE,tacheB);
                projet.creerTacheEnDessous(tacheF,tacheA);
                projet.creerTacheEnDessous(tacheG,tacheF);

                projet.creerSousTache(tacheH,tacheF);

                projet.creerTacheEnDessous(tacheI,tacheH);
                projet.creerTacheEnDessous(tacheJ,tacheI);
                projet.creerTacheEnDessous(tacheK,tacheJ);
                projet.creerTacheEnDessous(tacheL,tacheH);
                projet.creerTacheEnDessous(tacheM,tacheL);

                Projet projetSelected = Projet.find.byId(projet.id);
                Tache tacheASelected = Tache.find.byId(tacheA.id);
                Tache tacheBSelected = Tache.find.byId(tacheB.id);
                Tache tacheCSelected = Tache.find.byId(tacheC.id);
                Tache tacheDSelected = Tache.find.byId(tacheD.id);
                Tache tacheESelected = Tache.find.byId(tacheE.id);
                Tache tacheFSelected = Tache.find.byId(tacheF.id);
                Tache tacheGSelected = Tache.find.byId(tacheG.id);
                Tache tacheHSelected = Tache.find.byId(tacheH.id);
                Tache tacheISelected = Tache.find.byId(tacheI.id);
                Tache tacheJSelected = Tache.find.byId(tacheJ.id);
                Tache tacheKSelected = Tache.find.byId(tacheK.id);
                Tache tacheLSelected = Tache.find.byId(tacheL.id);
                Tache tacheMSelected = Tache.find.byId(tacheM.id);

                // Afficher l'attribut critique de chaque tache
                Logger.debug("CRITIQUE");
                Logger.debug(tacheASelected.critique.toString());
                Logger.debug(tacheBSelected.critique.toString());
                Logger.debug(tacheCSelected.critique.toString());
                Logger.debug(tacheDSelected.critique.toString());
                Logger.debug(tacheESelected.critique.toString());
                Logger.debug(tacheFSelected.critique.toString());
                Logger.debug(tacheGSelected.critique.toString());
                Logger.debug(tacheHSelected.critique.toString());
                Logger.debug(tacheISelected.critique.toString());
                Logger.debug(tacheJSelected.critique.toString());
                Logger.debug(tacheKSelected.critique.toString());
                Logger.debug(tacheLSelected.critique.toString());
                Logger.debug(tacheMSelected.critique.toString());

                // Verifier le chemin critique
                assertTrue(tacheASelected.critique);
                assertTrue(tacheBSelected.critique);
                assertTrue(tacheCSelected.critique);
                assertTrue(tacheDSelected.critique);
                assertTrue(tacheHSelected.critique);
                assertTrue(tacheLSelected.critique);
                assertTrue(tacheMSelected.critique);

                assertFalse(tacheESelected.critique);
                assertFalse(tacheFSelected.critique);
                assertFalse(tacheGSelected.critique);
                assertFalse(tacheISelected.critique);
                assertFalse(tacheJSelected.critique);
                assertFalse(tacheKSelected.critique);

            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    @Test
    public void testUpdateAvancementGlobal() {
        running(fakeApplication(), ()-> {
            //projet dateDebutTheorique: 2016,2,2, dateFinTheorique: 2016,3,4, dateDebutReel: 2016,2,2, dateFinReelTot: 2016,3,3, dateFinReelTard: 2016,3,3
            Projet projet = new Projet("Site Apple","Développement du nouveau site d'Apple", null,
                    Utils.getDateFrom(2016,2,2),Utils.getDateFrom(2016,3,4),Utils.getDateFrom(2016,2,2),
                    Utils.getDateFrom(2016,3,3),Utils.getDateFrom(2016,3,3),24D, UniteProjetEnum.SEMAINE,new Byte("0"),false,false,null,3,null,null);
            projet.save();

            //tache dateDebut: (2016,2,2), dateFinTot: (2016,2,4), dateFinTard: (2016,2,4)
            Tache tacheA = new Tache("TacheA","Cette tâche permet de réaliser l'étude du projet",0,true, Utils.getDateFrom(2016,2,2),
                    Utils.getDateFrom(2016,2,4),Utils.getDateFrom(2016,2,4),20D,0D,20D,null,null,null);
            tacheA.save();

            //tache dateDebut: (2016,2,4), dateFinTot: (2016,2,18), dateFinTard: (2016,2,18)
            Tache tacheB = new Tache("TacheB","Cette tâche permet de réaliser l'étude du projet",0,true, Utils.getDateFrom(2016,2,4),
                    Utils.getDateFrom(2016,2,18),Utils.getDateFrom(2016,2,18),20D,0D,20D,null,null,null);
            tacheB.save();

            //tache dateDebut: (2016,2,18), dateFinTot: (2016,2,28), dateFinTard: (2016,2,28)
            Tache tacheC = new Tache("TacheC","Cette tâche permet de réaliser l'étude du projet",0,true, Utils.getDateFrom(2016,2,18),
                    Utils.getDateFrom(2016,2,28),Utils.getDateFrom(2016,2,28),20D,0D,20D,null,null,null);
            tacheC.save();

            //tache dateDebut: (2016,2,28), dateFinTot: (2016,3,3), dateFinTard: (2016,3,3)
            Tache tacheD = new Tache("TacheD","Cette tâche permet de réaliser l'étude du projet",0,true, Utils.getDateFrom(2016,2,28),
                    Utils.getDateFrom(2016,3,3),Utils.getDateFrom(2016,3,3),20D,0D,20D,null,null,null);
            tacheD.save();

            //tache dateDebut: (2016,2,18), dateFinTot: (2016,2,20), dateFinTard: (2016,2,20)
            Tache tacheE = new Tache("TacheE","Cette tâche permet de réaliser l'étude du projet",0,true, Utils.getDateFrom(2016,2,18),
                    Utils.getDateFrom(2016,2,20),Utils.getDateFrom(2016,2,20),20D,0D,20D,null,null,null);
            tacheE.save();

            //tache dateDebut: (2016,2,4), dateFinTot: (2016,2,20), dateFinTard: (2016,2,20)
            Tache tacheF = new Tache("TacheF","Cette tâche permet de réaliser l'étude du projet",0,true, Utils.getDateFrom(2016,2,4),
                    Utils.getDateFrom(2016,2,20),Utils.getDateFrom(2016,2,20),20D,0D,20D,null,null,null);
            tacheF.save();

            //tache dateDebut: (2016,2,20), dateFinTot: (2016,2,28), dateFinTard: (2016,2,28)
            Tache tacheG = new Tache("TacheG","Cette tâche permet de réaliser l'étude du projet",0,true, Utils.getDateFrom(2016,2,20),
                    Utils.getDateFrom(2016,2,28),Utils.getDateFrom(2016,2,28),20D,0D,20D,null,null,null);
            tacheG.save();

            //tache dateDebut: (2016,2,4), dateFinTot: (2016,2,5), dateFinTard: (2016,2,5)
            Tache tacheH = new Tache("TacheH","Cette tâche permet de réaliser l'étude du projet",0,true, Utils.getDateFrom(2016,2,4),
                    Utils.getDateFrom(2016,2,5),Utils.getDateFrom(2016,2,5),20D,0D,20D,null,null,null);
            tacheH.save();

            //tache dateDebut: (2016,2,5), dateFinTot: (2016,2,10), dateFinTard: (2016,2,10)
            Tache tacheI = new Tache("TacheI","Cette tâche permet de réaliser l'étude du projet",0,true, Utils.getDateFrom(2016,2,5),
                    Utils.getDateFrom(2016,2,10),Utils.getDateFrom(2016,2,10),20D,0D,20D,null,null,null);
            tacheI.save();

            //tache dateDebut: (2016,2,10), dateFinTot: (2016,2,13), dateFinTard: (2016,2,13)
            Tache tacheJ = new Tache("TacheJ","Cette tâche permet de réaliser l'étude du projet",0,true, Utils.getDateFrom(2016,2,10),
                    Utils.getDateFrom(2016,2,13),Utils.getDateFrom(2016,2,13),20D,0D,20D,null,null,null);
            tacheJ.save();

            //tache dateDebut: (2016,2,13), dateFinTot: (2016,2,18), dateFinTard: (2016,2,18)
            Tache tacheK = new Tache("TacheK","Cette tâche permet de réaliser l'étude du projet",0,true, Utils.getDateFrom(2016,2,13),
                    Utils.getDateFrom(2016,2,18),Utils.getDateFrom(2016,2,18),20D,0D,20D,null,null,null);
            tacheK.save();

            //tache dateDebut: (2016,2,5), dateFinTot: (2016,2,10), dateFinTard: (2016,2,10)
            Tache tacheL = new Tache("TacheL","Cette tâche permet de réaliser l'étude du projet",0,true, Utils.getDateFrom(2016,2,5),
                    Utils.getDateFrom(2016,2,10),Utils.getDateFrom(2016,2,10),20D,0D,20D,null,null,null);
            tacheL.save();

            //TODO: chargeConsomee has been changed
            //tache dateDebut: (2016,2,10), dateFinTot: (2016,2,20), dateFinTard: (2016,2,20)
            Tache tacheM = new Tache("TacheM","Cette tâche permet de réaliser l'étude du projet",0,true, Utils.getDateFrom(2016,2,10),
                    Utils.getDateFrom(2016,2,20),Utils.getDateFrom(2016,2,20),20D,10D,20D,null,null,null);
            tacheM.save();

            try {
                /* TODO: delete
                tacheA.associerSuccesseur(tacheB);
                tacheB.associerSuccesseur(tacheC);
                tacheC.associerSuccesseur(tacheD);
                tacheB.associerSuccesseur(tacheE);
                tacheA.associerSuccesseur(tacheF);
                tacheF.associerSuccesseur(tacheG);
                tacheH.associerSuccesseur(tacheI);
                tacheI.associerSuccesseur(tacheJ);
                tacheJ.associerSuccesseur(tacheK);
                tacheH.associerSuccesseur(tacheL);
                tacheL.associerSuccesseur(tacheM);
                */

                projet.creerTacheInitialisationProjet(tacheA);
                projet.creerTacheEnDessous(tacheB,tacheA);
                projet.creerTacheEnDessous(tacheC,tacheB);
                projet.creerTacheEnDessous(tacheD,tacheC);
                projet.creerTacheEnDessous(tacheE,tacheB);
                projet.creerTacheEnDessous(tacheF,tacheA);
                projet.creerTacheEnDessous(tacheG,tacheF);

                projet.creerSousTache(tacheH,tacheF);

                projet.creerTacheEnDessous(tacheI,tacheH);
                projet.creerTacheEnDessous(tacheJ,tacheI);
                projet.creerTacheEnDessous(tacheK,tacheJ);
                projet.creerTacheEnDessous(tacheL,tacheH);
                projet.creerTacheEnDessous(tacheM,tacheL);

                Projet projetSelected = Projet.find.byId(projet.id);
                Tache tacheASelected = Tache.find.byId(tacheA.id);
                Tache tacheBSelected = Tache.find.byId(tacheB.id);
                Tache tacheCSelected = Tache.find.byId(tacheC.id);
                Tache tacheDSelected = Tache.find.byId(tacheD.id);
                Tache tacheESelected = Tache.find.byId(tacheE.id);
                Tache tacheFSelected = Tache.find.byId(tacheF.id);
                Tache tacheGSelected = Tache.find.byId(tacheG.id);
                Tache tacheHSelected = Tache.find.byId(tacheH.id);
                Tache tacheISelected = Tache.find.byId(tacheI.id);
                Tache tacheJSelected = Tache.find.byId(tacheJ.id);
                Tache tacheKSelected = Tache.find.byId(tacheK.id);
                Tache tacheLSelected = Tache.find.byId(tacheL.id);
                Tache tacheMSelected = Tache.find.byId(tacheM.id);

                // Afficher la chargeConsommee
                Logger.debug("CHARGE CONSOMMEE");
                Logger.debug(tacheASelected.chargeConsommee.toString());
                Logger.debug(tacheBSelected.chargeConsommee.toString());
                Logger.debug(tacheCSelected.chargeConsommee.toString());
                Logger.debug(tacheDSelected.chargeConsommee.toString());
                Logger.debug(tacheESelected.chargeConsommee.toString());
                Logger.debug(tacheFSelected.chargeConsommee.toString());
                Logger.debug(tacheGSelected.chargeConsommee.toString());
                Logger.debug(tacheHSelected.chargeConsommee.toString());
                Logger.debug(tacheISelected.chargeConsommee.toString());
                Logger.debug(tacheJSelected.chargeConsommee.toString());
                Logger.debug(tacheKSelected.chargeConsommee.toString());
                Logger.debug(tacheLSelected.chargeConsommee.toString());
                Logger.debug(tacheMSelected.chargeConsommee.toString());

                Logger.debug("CHARGE RESTANTE");
                Logger.debug(tacheASelected.chargeRestante.toString());
                Logger.debug(tacheBSelected.chargeRestante.toString());
                Logger.debug(tacheCSelected.chargeRestante.toString());
                Logger.debug(tacheDSelected.chargeRestante.toString());
                Logger.debug(tacheESelected.chargeRestante.toString());
                Logger.debug(tacheFSelected.chargeRestante.toString());
                Logger.debug(tacheGSelected.chargeRestante.toString());
                Logger.debug(tacheHSelected.chargeRestante.toString());
                Logger.debug(tacheISelected.chargeRestante.toString());
                Logger.debug(tacheJSelected.chargeRestante.toString());
                Logger.debug(tacheKSelected.chargeRestante.toString());
                Logger.debug(tacheLSelected.chargeRestante.toString());
                Logger.debug(tacheMSelected.chargeRestante.toString());

            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}

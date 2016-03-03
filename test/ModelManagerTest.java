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

            // Attention! C'est obligé d'ajouter un responsable dans le constructeur de Projet et Tache.
            //projet dateDebutTheorique: 2016,2,2, dateFinTheorique: 2016,2,10, dateDebutReel: 2016,2,3, dateFinReelTot: 2016,2,9, dateFinReelTard: 2016,2,9
            Projet projet = new Projet("Site Apple","Développement du nouveau site d'Apple", utilisateur,
                    Utils.getDateFrom(2016,2,2),Utils.getDateFrom(2016,2,10),Utils.getDateFrom(2016,2,3),
                    Utils.getDateFrom(2016,2,9),Utils.getDateFrom(2016,2,9),24D, UniteProjetEnum.SEMAINE,new Byte("0"),false,false,client,3,null,null);
            projet.save();

            //tache dateDebut: (2016,2,3), dateFinTot: (2016,2,4), dateFinTard: (2016,2,4)
            Tache tache = new Tache("Tache","Cette tâche permet de réaliser l'étude du projet",utilisateur,0,true, Utils.getDateFrom(2016,2,3),
                    Utils.getDateFrom(2016,2,4),Utils.getDateFrom(2016,2,4),20D,10D,20D,null,null,null,null,null,true);
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
            Utilisateur utilisateur = new Utilisateur("Z", "Z", "z.z@gmail.com", "1234567980", true, "123456Aa");
            utilisateur.save();

            //projet dateDebutTheorique: 2016,2,2, dateFinTheorique: 2016,2,10, dateDebutReel: 2016,2,3, dateFinReelTot: 2016,2,9, dateFinReelTard: 2016,2,9
            Projet projet = new Projet("Site Apple","Développement du nouveau site d'Apple", utilisateur,
                    Utils.getDateFrom(2016,2,2),Utils.getDateFrom(2016,2,10),Utils.getDateFrom(2016,2,3),
                    Utils.getDateFrom(2016,2,9),Utils.getDateFrom(2016,2,9),24D, UniteProjetEnum.SEMAINE,new Byte("0"),false,false,null,3,null,null);
            projet.save();

            //tache dateDebut: (2016,2,3), dateFinTot: (2016,2,4), dateFinTard: (2016,2,4)
            Tache tache1 = new Tache("Tache1","Cette tâche permet de réaliser l'étude du projet",utilisateur,0,true, Utils.getDateFrom(2016,2,3),
                    Utils.getDateFrom(2016,2,4),Utils.getDateFrom(2016,2,4),20D,10D,20D,null,null,null,null,null,true);
            tache1.save();

            //tache dateDebut: (2016,2,3), dateFinTot: (2016,2,4), dateFinTard: (2016,2,4)
            Tache tache2 = new Tache("Tache1","Cette tâche permet de réaliser l'étude du projet",utilisateur,0,true, Utils.getDateFrom(2016,2,3),
                    Utils.getDateFrom(2016,2,4),Utils.getDateFrom(2016,2,4),20D,10D,20D,null,null,null,null,null,true);
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
            Utilisateur utilisateur = new Utilisateur("Z", "Z", "z.z@gmail.com", "1234567980", true, "123456Aa");
            utilisateur.save();

            //projet dateDebutTheorique: 2016,2,2, dateFinTheorique: 2016,2,10, dateDebutReel: 2016,2,3, dateFinReelTot: 2016,2,9, dateFinReelTard: 2016,2,9
            Projet projet = new Projet("Site Apple","Développement du nouveau site d'Apple", utilisateur,
                    Utils.getDateFrom(2016,2,2),Utils.getDateFrom(2016,2,10),Utils.getDateFrom(2016,2,3),
                    Utils.getDateFrom(2016,2,9),Utils.getDateFrom(2016,2,9),24D, UniteProjetEnum.SEMAINE,new Byte("0"),false,false,null,3,null,null);
            projet.save();

            //tache dateDebut: (2016,2,3), dateFinTot: (2016,2,4), dateFinTard: (2016,2,4)
            Tache tache1 = new Tache("Tache1","Cette tâche permet de réaliser l'étude du projet",utilisateur,0,true, Utils.getDateFrom(2016,2,3),
                    Utils.getDateFrom(2016,2,4),Utils.getDateFrom(2016,2,4),20D,10D,20D,null,null,null,null,null,true);
            tache1.save();

            //tache dateDebut: (2016,2,3), dateFinTot: (2016,2,4), dateFinTard: (2016,2,4)
            Tache tache2 = new Tache("Tache1","Cette tâche permet de réaliser l'étude du projet",utilisateur,0,true, Utils.getDateFrom(2016,2,3),
                    Utils.getDateFrom(2016,2,4),Utils.getDateFrom(2016,2,4),20D,10D,20D,null,null,null,null,null,true);
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
            Utilisateur utilisateur = new Utilisateur("Z", "Z", "z.z@gmail.com", "1234567980", true, "123456Aa");
            utilisateur.save();

            //projet dateDebutTheorique: 2016,2,2, dateFinTheorique: 2016,2,10, dateDebutReel: 2016,2,3, dateFinReelTot: 2016,2,9, dateFinReelTard: 2016,2,9
            Projet projet = new Projet("Site Apple","Développement du nouveau site d'Apple", utilisateur,
                    Utils.getDateFrom(2016,2,2),Utils.getDateFrom(2016,2,10),Utils.getDateFrom(2016,2,3),
                    Utils.getDateFrom(2016,2,9),Utils.getDateFrom(2016,2,9),24D, UniteProjetEnum.SEMAINE,new Byte("0"),false,false,null,3,null,null);
            projet.save();

            //tache dateDebut: (2016,2,3), dateFinTot: (2016,2,4), dateFinTard: (2016,2,4)
            Tache tache1 = new Tache("Tache1","Cette tâche permet de réaliser l'étude du projet",utilisateur,0,true, Utils.getDateFrom(2016,2,3),
                    Utils.getDateFrom(2016,2,5),Utils.getDateFrom(2016,2,5),20D,10D,20D,null,null,null,null,null,true);
            tache1.save();

            //tache dateDebut: (2016,2,3), dateFinTot: (2016,2,4), dateFinTard: (2016,2,4)
            Tache tache2 = new Tache("Tache2","Cette tâche permet de réaliser l'étude du projet",utilisateur,0,true, Utils.getDateFrom(2016,2,3),
                    Utils.getDateFrom(2016,2,4),Utils.getDateFrom(2016,2,4),20D,10D,20D,null,null,null,null,null,true);
            tache2.save();

            try {
                // 1er test
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
                assertTrue(tache1Selected.enfants().contains(tache2Selected));

                // 2eme test
                //tache dateDebut: (2016,2,3), dateFinTot: (2016,2,4), dateFinTard: (2016,2,4)
                Tache tache3 = new Tache("Tache3","Cette tâche permet de réaliser l'étude du projet",utilisateur,0,true, Utils.getDateFrom(2016,2,4),
                        Utils.getDateFrom(2016,2,5),Utils.getDateFrom(2016,2,5),20D,10D,20D,null,null,tache2,null,null,true);
                tache3.save();
                projet.creerTacheEnDessous(tache3,tache2);
                assertEquals(tache1Selected.idTache, "1");
                assertEquals(tache2Selected.idTache, "1.1");
                assertEquals(Tache.find.byId(tache3.id).idTache, "1.2");

                Tache tache4 = new Tache("Tache4","Cette tâche permet de réaliser l'étude du projet",utilisateur,0,true, Utils.getDateFrom(2016,2,4),
                        Utils.getDateFrom(2016,2,5),Utils.getDateFrom(2016,2,5),20D,10D,20D,null,null,tache2,null,null,true);
                tache4.save();
                projet.creerSousTache(tache4, tache3);
                assertEquals(tache1Selected.idTache, "1");
                assertEquals(tache2Selected.idTache, "1.1");
                assertEquals(Tache.find.byId(tache3.id).idTache, "1.2");
                assertEquals(Tache.find.byId(tache4.id).idTache, "1.2.1");
                assertTrue(Tache.find.byId(tache1.id).enfants().contains(Tache.find.byId(tache2.id)));
                assertTrue(Tache.find.byId(tache1.id).enfants().contains(Tache.find.byId(tache3.id)));
                assertTrue(Tache.find.byId(tache3.id).enfants().contains(Tache.find.byId(tache4.id)));

                assertFalse(Tache.find.byId(tache1.id).enfants().contains(Tache.find.byId(tache4.id)));
                assertFalse(Tache.find.byId(tache2.id).enfants().contains(Tache.find.byId(tache3.id)));
                assertFalse(Tache.find.byId(tache2.id).enfants().contains(Tache.find.byId(tache4.id)));

                assertTrue(Tache.find.byId(tache4.id).predecesseur.equals(Tache.find.byId(tache2.id)));
                assertFalse(Tache.find.byId(tache4.id).predecesseur.equals(Tache.find.byId(tache1.id)));
                assertFalse(Tache.find.byId(tache4.id).predecesseur.equals(Tache.find.byId(tache4.id)));
                assertFalse(Tache.find.byId(tache4.id).predecesseur.equals(Tache.find.byId(tache3.id)));
                assertTrue(Tache.find.byId(tache4.id).getSuccesseurs().isEmpty());

                assertTrue(Tache.find.byId(tache2.id).getSuccesseurs().contains(Tache.find.byId(tache3.id)));
                assertFalse(Tache.find.byId(tache2.id).getSuccesseurs().contains(Tache.find.byId(tache1.id)));
                assertFalse(Tache.find.byId(tache2.id).getSuccesseurs().contains(Tache.find.byId(tache2.id)));
                assertTrue(Tache.find.byId(tache2.id).getSuccesseurs().contains(Tache.find.byId(tache4.id)));
                assertTrue(!Tache.find.byId(tache2.id).hasPredecesseur());

            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    @Test
    public void testIdTache() {
        running(fakeApplication(), ()-> {
            Utilisateur utilisateur = new Utilisateur("Z", "Z", "z.z@gmail.com", "1234567980", true, "123456Aa");
            utilisateur.save();

            //projet dateDebutTheorique: 2016,2,2, dateFinTheorique: 2016,3,4, dateDebutReel: 2016,2,2, dateFinReelTot: 2016,3,3, dateFinReelTard: 2016,3,3
            Projet projet = new Projet("Site Apple","Développement du nouveau site d'Apple", utilisateur,
                    Utils.getDateFrom(2016,2,2),Utils.getDateFrom(2016,3,4),Utils.getDateFrom(2016,2,2),
                    Utils.getDateFrom(2016,3,3),Utils.getDateFrom(2016,3,3),24D, UniteProjetEnum.SEMAINE,new Byte("0"),false,false,null,3,null,null);
            projet.save();

            //tache dateDebut: (2016,2,2), dateFinTot: (2016,2,4), dateFinTard: (2016,2,4)
            Tache tacheA = new Tache("TacheA","Cette tâche permet de réaliser l'étude du projet",utilisateur,0,true, Utils.getDateFrom(2016,2,2),
                    Utils.getDateFrom(2016,2,4),Utils.getDateFrom(2016,2,4),20D,0D,20D,null,null,null,null,null,true);
            tacheA.save();

            //tache dateDebut: (2016,2,4), dateFinTot: (2016,2,18), dateFinTard: (2016,2,18)
            Tache tacheB = new Tache("TacheB","Cette tâche permet de réaliser l'étude du projet",utilisateur,0,true, Utils.getDateFrom(2016,2,4),
                    Utils.getDateFrom(2016,2,18),Utils.getDateFrom(2016,2,18),20D,0D,20D,null,null,null,null,null,true);
            tacheB.save();

            //tache dateDebut: (2016,2,18), dateFinTot: (2016,2,28), dateFinTard: (2016,2,28)
            Tache tacheC = new Tache("TacheC","Cette tâche permet de réaliser l'étude du projet",utilisateur,0,true, Utils.getDateFrom(2016,2,18),
                    Utils.getDateFrom(2016,2,28),Utils.getDateFrom(2016,2,28),20D,0D,20D,null,null,null,null,null,true);
            tacheC.save();

            //tache dateDebut: (2016,2,28), dateFinTot: (2016,3,3), dateFinTard: (2016,3,3)
            Tache tacheD = new Tache("TacheD","Cette tâche permet de réaliser l'étude du projet",utilisateur,0,true, Utils.getDateFrom(2016,2,28),
                    Utils.getDateFrom(2016,3,3),Utils.getDateFrom(2016,3,3),20D,0D,20D,null,null,null,null,null,true);
            tacheD.save();

            //tache dateDebut: (2016,2,18), dateFinTot: (2016,2,20), dateFinTard: (2016,2,20)
            Tache tacheE = new Tache("TacheE","Cette tâche permet de réaliser l'étude du projet",utilisateur,0,true, Utils.getDateFrom(2016,2,18),
                    Utils.getDateFrom(2016,2,20),Utils.getDateFrom(2016,2,20),20D,0D,20D,null,null,null,null,null,true);
            tacheE.save();

            //tache dateDebut: (2016,2,4), dateFinTot: (2016,2,20), dateFinTard: (2016,2,20)
            Tache tacheF = new Tache("TacheF","Cette tâche permet de réaliser l'étude du projet",utilisateur,0,true, Utils.getDateFrom(2016,2,4),
                    Utils.getDateFrom(2016,2,20),Utils.getDateFrom(2016,2,20),20D,0D,20D,null,null,null,null,null,true);
            tacheF.save();

            //tache dateDebut: (2016,2,20), dateFinTot: (2016,2,28), dateFinTard: (2016,2,28)
            Tache tacheG = new Tache("TacheG","Cette tâche permet de réaliser l'étude du projet",utilisateur,0,true, Utils.getDateFrom(2016,2,20),
                    Utils.getDateFrom(2016,2,28),Utils.getDateFrom(2016,2,28),20D,0D,20D,null,null,null,null,null,true);
            tacheG.save();

            //tache dateDebut: (2016,2,4), dateFinTot: (2016,2,5), dateFinTard: (2016,2,5)
            Tache tacheH = new Tache("TacheH","Cette tâche permet de réaliser l'étude du projet",utilisateur,0,true, Utils.getDateFrom(2016,2,4),
                    Utils.getDateFrom(2016,2,5),Utils.getDateFrom(2016,2,5),20D,0D,20D,null,null,null,null,null,true);
            tacheH.save();

            //tache dateDebut: (2016,2,5), dateFinTot: (2016,2,10), dateFinTard: (2016,2,10)
            Tache tacheI = new Tache("TacheI","Cette tâche permet de réaliser l'étude du projet",utilisateur,0,true, Utils.getDateFrom(2016,2,5),
                    Utils.getDateFrom(2016,2,10),Utils.getDateFrom(2016,2,10),20D,0D,20D,null,null,null,null,null,true);
            tacheI.save();

            //tache dateDebut: (2016,2,10), dateFinTot: (2016,2,13), dateFinTard: (2016,2,13)
            Tache tacheJ = new Tache("TacheJ","Cette tâche permet de réaliser l'étude du projet",utilisateur,0,true, Utils.getDateFrom(2016,2,10),
                    Utils.getDateFrom(2016,2,13),Utils.getDateFrom(2016,2,13),20D,0D,20D,null,null,null,null,null,true);
            tacheJ.save();

            //tache dateDebut: (2016,2,13), dateFinTot: (2016,2,18), dateFinTard: (2016,2,18)
            Tache tacheK = new Tache("TacheK","Cette tâche permet de réaliser l'étude du projet",utilisateur,0,true, Utils.getDateFrom(2016,2,13),
                    Utils.getDateFrom(2016,2,18),Utils.getDateFrom(2016,2,18),20D,0D,20D,null,null,null,null,null,true);
            tacheK.save();

            //tache dateDebut: (2016,2,5), dateFinTot: (2016,2,10), dateFinTard: (2016,2,10)
            Tache tacheL = new Tache("TacheL","Cette tâche permet de réaliser l'étude du projet",utilisateur,0,true, Utils.getDateFrom(2016,2,5),
                    Utils.getDateFrom(2016,2,10),Utils.getDateFrom(2016,2,10),20D,0D,20D,null,null,null,null,null,true);
            tacheL.save();

            //tache dateDebut: (2016,2,10), dateFinTot: (2016,2,20), dateFinTard: (2016,2,20)
            Tache tacheM = new Tache("TacheM","Cette tâche permet de réaliser l'étude du projet",utilisateur,0,true, Utils.getDateFrom(2016,2,10),
                    Utils.getDateFrom(2016,2,20),Utils.getDateFrom(2016,2,20),20D,0D,20D,null,null,null,null,null,true);
            tacheM.save();

            try {
                projet.creerTacheInitialisationProjet(tacheA);
                /*
                System.out.println("------ L1 -------");
                System.out.println(tacheA.nom + " " + tacheA.idTache);
                System.out.println("------ Fin - L1 -------");
                */

                projet.creerTacheEnDessous(tacheB,tacheA);
                /*
                System.out.println("------ L2 -------");
                System.out.println(tacheA.nom + " " + tacheA.idTache);
                System.out.println(tacheB.nom + " " + tacheB.idTache);
                System.out.println("------ Fin - L2 -------");
                */

                projet.creerTacheEnDessous(tacheC,tacheB);
                /*
                System.out.println("------ L3 -------");
                System.out.println(tacheA.nom + " " + tacheA.idTache);
                System.out.println(tacheB.nom + " " + tacheB.idTache);
                System.out.println(tacheC.nom + " " + tacheC.idTache);
                System.out.println("------ Fin - L3 -------");
                */

                projet.creerTacheEnDessous(tacheD,tacheC);
                /*
                System.out.println("------ L4 -------");
                System.out.println(tacheA.nom + " " + tacheA.idTache);
                System.out.println(tacheB.nom + " " + tacheB.idTache);
                System.out.println(tacheC.nom + " " + tacheC.idTache);
                System.out.println(tacheD.nom + " " + tacheD.idTache);
                System.out.println("------ Fin - L4 -------");
                */

                projet.creerTacheEnDessous(tacheE,tacheB);
                /*
                System.out.println("------ L5 -------");
                System.out.println(tacheA.nom + " " + tacheA.idTache);
                System.out.println(tacheB.nom + " " + tacheB.idTache);
                System.out.println(tacheE.nom + " " + tacheE.idTache);
                System.out.println(tacheC.nom + " " + tacheC.idTache);
                System.out.println(tacheD.nom + " " + tacheD.idTache);
                System.out.println("------ Fin - L5 -------");
                */

                projet.creerTacheEnDessous(tacheF,tacheA);
                /*
                System.out.println("------ L6 -------");
                System.out.println(tacheA.nom + " " + tacheA.idTache);
                System.out.println(tacheF.nom + " " + tacheF.idTache);
                System.out.println(tacheB.nom + " " + tacheB.idTache);
                System.out.println(tacheE.nom + " " + tacheE.idTache);
                System.out.println(tacheC.nom + " " + tacheC.idTache);
                System.out.println(tacheD.nom + " " + tacheD.idTache);
                System.out.println("------ Fin - L6 -------");
                */

                projet.creerTacheEnDessous(tacheG,tacheF);
                /*
                System.out.println("------ L7 -------");
                System.out.println(tacheA.nom + " " + tacheA.idTache);
                System.out.println(tacheF.nom + " " + tacheF.idTache);
                System.out.println(tacheG.nom + " " + tacheG.idTache);
                System.out.println(tacheB.nom + " " + tacheB.idTache);
                System.out.println(tacheE.nom + " " + tacheE.idTache);
                System.out.println(tacheC.nom + " " + tacheC.idTache);
                System.out.println(tacheD.nom + " " + tacheD.idTache);
                System.out.println("------ Fin - L7 -------");
                */

                projet.creerSousTache(tacheH,tacheF);
                /*
                System.out.println("------ L8 -------");
                System.out.println(tacheF.nom + " " + tacheF.idTache);
                System.out.println(tacheH.nom + " " + tacheH.idTache);
                System.out.println("------ Fin - L8 -------");
                */

                projet.creerTacheEnDessous(tacheI,tacheH);
                /*
                System.out.println("------ L9 -------");
                System.out.println(tacheF.nom + " " + tacheF.idTache);
                System.out.println(tacheH.nom + " " + tacheH.idTache);
                System.out.println(tacheI.nom + " " + tacheI.idTache);
                System.out.println("------ Fin - L9 -------");
                */

                projet.creerTacheEnDessous(tacheJ,tacheI);
                /*
                System.out.println("------ L10 -------");
                System.out.println(tacheF.nom + " " + tacheF.idTache);
                System.out.println(tacheH.nom + " " + tacheH.idTache);
                System.out.println(tacheI.nom + " " + tacheI.idTache);
                System.out.println(tacheJ.nom + " " + tacheJ.idTache);
                System.out.println("------ Fin - L10 -------");
                */

                projet.creerTacheEnDessous(tacheK,tacheJ);
                /*
                System.out.println("------ L11 -------");
                System.out.println(tacheF.nom + " " + tacheF.idTache);
                System.out.println(tacheH.nom + " " + tacheH.idTache);
                System.out.println(tacheI.nom + " " + tacheI.idTache);
                System.out.println(tacheJ.nom + " " + tacheJ.idTache);
                System.out.println(tacheK.nom + " " + tacheK.idTache);
                System.out.println("------ Fin - L11 -------");
                */

                projet.creerTacheEnDessous(tacheL,tacheH);
                /*
                System.out.println("------ L12 -------");
                System.out.println(tacheF.nom + " " + tacheF.idTache);
                System.out.println(tacheH.nom + " " + tacheH.idTache);
                System.out.println(tacheL.nom + " " + tacheL.idTache);
                System.out.println(tacheI.nom + " " + tacheI.idTache);
                System.out.println(tacheJ.nom + " " + tacheJ.idTache);
                System.out.println(tacheK.nom + " " + tacheK.idTache);
                System.out.println("------ Fin - L12 -------");
                */

                projet.creerTacheEnDessous(tacheM,tacheL);
                /*
                System.out.println("------ L13 -------");
                System.out.println(tacheF.nom + " " + tacheF.idTache);
                System.out.println(tacheH.nom + " " + tacheH.idTache);
                System.out.println(tacheL.nom + " " + tacheL.idTache);
                System.out.println(tacheM.nom + " " + tacheM.idTache);
                System.out.println(tacheI.nom + " " + tacheI.idTache);
                System.out.println(tacheJ.nom + " " + tacheJ.idTache);
                System.out.println(tacheK.nom + " " + tacheK.idTache);
                System.out.println("------ Fin - L13 -------");
                */

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

                /*
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
                */

                // Verifier si il y a 13 taches dans le projet
                assertEquals(projetSelected.listTaches().size(), 13);

                // Verifier les idTache
                assertEquals(tacheASelected.idTache, "1");
                assertEquals(tacheBSelected.idTache, "4");
                assertEquals(tacheCSelected.idTache, "6");
                assertEquals(tacheDSelected.idTache, "7");
                assertEquals(tacheESelected.idTache, "5");
                assertEquals(tacheFSelected.idTache, "2");
                assertEquals(tacheGSelected.idTache, "3");
                assertEquals(tacheHSelected.idTache, "2.1");
                assertEquals(tacheISelected.idTache, "2.4");
                assertEquals(tacheJSelected.idTache, "2.5");
                assertEquals(tacheKSelected.idTache, "2.6");
                assertEquals(tacheLSelected.idTache, "2.2");
                assertEquals(tacheMSelected.idTache, "2.3");
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }


    @Test
    public void testCalculeCheminCritique() {
        running(fakeApplication(), ()-> {
            Utilisateur utilisateur = new Utilisateur("Z", "Z", "z.z@gmail.com", "1234567980", true, "123456Aa");
            utilisateur.save();

            //projet dateDebutTheorique: 2016,2,2, dateFinTheorique: 2016,2,4, dateDebutReel: 2016,2,2, dateFinReelTot: 2016,2,4, dateFinReelTard: 2016,2,4
            Projet projet = new Projet("Site Apple","Développement du nouveau site d'Apple", utilisateur,
                    Utils.getDateFrom(2016,2,2),Utils.getDateFrom(2016,2,4),Utils.getDateFrom(2016,2,2),
                    Utils.getDateFrom(2016,2,4),Utils.getDateFrom(2016,2,4),24D, UniteProjetEnum.SEMAINE,new Byte("0"),false,false,null,3,null,null);
            projet.save();

            //tache dateDebut: (2016,2,2), dateFinTot: (2016,2,4), dateFinTard: (2016,2,4)
            Tache tacheA = new Tache("TacheA","Cette tâche permet de réaliser l'étude du projet",utilisateur,0,true, Utils.getDateFrom(2016,2,2),
                    Utils.getDateFrom(2016,2,4),Utils.getDateFrom(2016,2,4),20D,0D,20D,null,null,null,null,null,true);
            tacheA.save();

            //tache dateDebut: (2016,2,4), dateFinTot: (2016,2,18), dateFinTard: (2016,2,18)
            Tache tacheB = new Tache("TacheB","Cette tâche permet de réaliser l'étude du projet",utilisateur,0,true, Utils.getDateFrom(2016,2,4),
                    Utils.getDateFrom(2016,2,18),Utils.getDateFrom(2016,2,18),20D,0D,20D,null,null,tacheA,null,null,true);
            tacheB.save();

            //tache dateDebut: (2016,2,18), dateFinTot: (2016,2,28), dateFinTard: (2016,2,28)
            Tache tacheC = new Tache("TacheC","Cette tâche permet de réaliser l'étude du projet",utilisateur,0,true, Utils.getDateFrom(2016,2,18),
                    Utils.getDateFrom(2016,2,28),Utils.getDateFrom(2016,2,28),20D,0D,20D,null,null,tacheB,null,null,true);
            tacheC.save();

            //tache dateDebut: (2016,2,28), dateFinTot: (2016,3,3), dateFinTard: (2016,3,3)
            Tache tacheD = new Tache("TacheD","Cette tâche permet de réaliser l'étude du projet",utilisateur,0,true, Utils.getDateFrom(2016,2,28),
                    Utils.getDateFrom(2016,3,3),Utils.getDateFrom(2016,3,3),20D,0D,20D,null,null,tacheC,null,null,true);
            tacheD.save();

            //tache dateDebut: (2016,2,18), dateFinTot: (2016,2,20), dateFinTard: (2016,2,20)
            Tache tacheE = new Tache("TacheE","Cette tâche permet de réaliser l'étude du projet",utilisateur,0,true, Utils.getDateFrom(2016,2,18),
                    Utils.getDateFrom(2016,2,20),Utils.getDateFrom(2016,2,20),20D,0D,20D,null,null,tacheB,null,null,true);
            tacheE.save();

            //tache dateDebut: (2016,2,4), dateFinTot: (2016,2,20), dateFinTard: (2016,2,20)
            Tache tacheF = new Tache("TacheF","Cette tâche permet de réaliser l'étude du projet",utilisateur,0,true, Utils.getDateFrom(2016,2,4),
                    Utils.getDateFrom(2016,2,20),Utils.getDateFrom(2016,2,20),20D,0D,20D,null,null,tacheA,null,null,true);
            tacheF.save();

            //tache dateDebut: (2016,2,20), dateFinTot: (2016,2,28), dateFinTard: (2016,2,28)
            Tache tacheG = new Tache("TacheG","Cette tâche permet de réaliser l'étude du projet",utilisateur,0,true, Utils.getDateFrom(2016,2,20),
                    Utils.getDateFrom(2016,2,28),Utils.getDateFrom(2016,2,28),20D,0D,20D,null,null,tacheF,null,null,true);
            tacheG.save();

            try {
                projet.creerTacheInitialisationProjet(tacheA);
                projet.creerTacheEnDessous(tacheB,tacheA);
                projet.creerTacheEnDessous(tacheC,tacheB);
                projet.creerTacheEnDessous(tacheD,tacheC);
                projet.creerTacheEnDessous(tacheE,tacheB);
                projet.creerTacheEnDessous(tacheF,tacheA);
                projet.creerTacheEnDessous(tacheG,tacheF);

                //Projet projetSelected = Projet.find.byId(projet.id);
                Tache tacheASelected = Tache.find.byId(tacheA.id);
                Tache tacheBSelected = Tache.find.byId(tacheB.id);
                Tache tacheCSelected = Tache.find.byId(tacheC.id);
                Tache tacheDSelected = Tache.find.byId(tacheD.id);
                Tache tacheESelected = Tache.find.byId(tacheE.id);
                Tache tacheFSelected = Tache.find.byId(tacheF.id);
                Tache tacheGSelected = Tache.find.byId(tacheG.id);

                // Verifier les structure des taches de projet est bien MAJ
                assertTrue(tacheASelected.getSuccesseurs().contains(tacheBSelected));
                assertTrue(tacheASelected.getSuccesseurs().contains(tacheFSelected));
                assertTrue(tacheBSelected.getSuccesseurs().contains(tacheCSelected));
                assertTrue(tacheBSelected.getSuccesseurs().contains(tacheESelected));
                assertTrue(tacheCSelected.getSuccesseurs().contains(tacheDSelected));
                assertTrue(tacheFSelected.getSuccesseurs().contains(tacheGSelected));

                /*
                assertTrue(tacheFSelected.enfants().contains(tacheHSelected));
                assertTrue(tacheFSelected.enfants().contains(tacheISelected));
                assertTrue(tacheFSelected.enfants().contains(tacheJSelected));
                assertTrue(tacheFSelected.enfants().contains(tacheKSelected));
                assertTrue(tacheFSelected.enfants().contains(tacheLSelected));
                assertTrue(tacheFSelected.enfants().contains(tacheMSelected));

                assertTrue(tacheHSelected.getSuccesseurs().contains(tacheISelected));
                assertTrue(tacheHSelected.getSuccesseurs().contains(tacheLSelected));
                assertTrue(tacheISelected.getSuccesseurs().contains(tacheJSelected));
                assertTrue(tacheJSelected.getSuccesseurs().contains(tacheKSelected));
                assertTrue(tacheLSelected.getSuccesseurs().contains(tacheMSelected));
                */



                // 1er test
                // Verifier le chemin critique
                assertTrue(tacheASelected.critique);
                assertTrue(tacheBSelected.critique);
                assertTrue(tacheCSelected.critique);
                assertTrue(tacheDSelected.critique);

                assertFalse(tacheESelected.critique);
                assertFalse(tacheFSelected.critique);
                assertFalse(tacheGSelected.critique);

                // 2ème test
                // Ajouter tacheZ après tacheG
                //tache dateDebut: (2016,2,28), dateFinTot: (2016,3,4), dateFinTard: (2016,3,4)
                Tache tacheZ = new Tache("TacheZ","Cette tâche permet de réaliser l'étude du projet",utilisateur,0,true, Utils.getDateFrom(2016,2,28),
                        Utils.getDateFrom(2016,3,4),Utils.getDateFrom(2016,3,4),20D,0D,20D,null,null,tacheG,null,null,true);
                tacheZ.save();
                projet.creerTacheEnDessous(tacheZ,tacheG);
                // Verifier le chemin critique
                assertTrue(Tache.find.byId(tacheA.id).critique);
                assertTrue(Tache.find.byId(tacheF.id).critique);
                assertTrue(Tache.find.byId(tacheG.id).critique);
                assertTrue(Tache.find.byId(tacheZ.id).critique);

                assertFalse(Tache.find.byId(tacheB.id).critique);
                assertFalse(Tache.find.byId(tacheC.id).critique);
                assertFalse(Tache.find.byId(tacheD.id).critique);
                assertFalse(Tache.find.byId(tacheE.id).critique);

                // 3ème test
                // Ajouter les sous taches de TacheF(tacheH, tacheI, tacheJ, tacheK, tacheL et tacheM)
                tacheF.dateFinTard = Utils.getDateFrom(2016, 3, 5);
                tacheF.dateFinTot = Utils.getDateFrom(2016, 3, 5);
                tacheF.save();

                //tache dateDebut: (2016,2,4), dateFinTot: (2016,2,5), dateFinTard: (2016,2,5)
                Tache tacheH = new Tache("TacheH", "Cette tâche permet de réaliser l'étude du projet", utilisateur, 0, true, Utils.getDateFrom(2016, 2, 4),
                        Utils.getDateFrom(2016, 2, 5), Utils.getDateFrom(2016, 2, 5), 20D, 0D, 20D, null, null, tacheA, null, null,true);
                tacheH.save();

                //tache dateDebut: (2016,2,5), dateFinTot: (2016,2,10), dateFinTard: (2016,2,10)
                Tache tacheI = new Tache("TacheI", "Cette tâche permet de réaliser l'étude du projet", utilisateur, 0, true, Utils.getDateFrom(2016, 2, 5),
                        Utils.getDateFrom(2016, 2, 10), Utils.getDateFrom(2016, 2, 10), 20D, 0D, 20D, null, null, tacheH, null, null,true);
                tacheI.save();

                //tache dateDebut: (2016,2,10), dateFinTot: (2016,2,13), dateFinTard: (2016,2,13)
                Tache tacheJ = new Tache("TacheJ", "Cette tâche permet de réaliser l'étude du projet", utilisateur, 0, true, Utils.getDateFrom(2016, 2, 10),
                        Utils.getDateFrom(2016, 2, 13), Utils.getDateFrom(2016, 2, 13), 20D, 0D, 20D, null, null, tacheI, null, null,true);
                tacheJ.save();

                //tache dateDebut: (2016,2,13), dateFinTot: (2016,2,18), dateFinTard: (2016,2,18)
                Tache tacheK = new Tache("TacheK", "Cette tâche permet de réaliser l'étude du projet", utilisateur, 0, true, Utils.getDateFrom(2016, 2, 13),
                        Utils.getDateFrom(2016, 2, 18), Utils.getDateFrom(2016, 2, 18), 20D, 0D, 20D, null, null, tacheJ, null, null, true);
                tacheK.save();

                //tache dateDebut: (2016,2,5), dateFinTot: (2016,2,10), dateFinTard: (2016,2,10)
                Tache tacheL = new Tache("TacheL", "Cette tâche permet de réaliser l'étude du projet", utilisateur, 0, true, Utils.getDateFrom(2016, 2, 5),
                        Utils.getDateFrom(2016, 2, 10), Utils.getDateFrom(2016, 2, 10), 20D, 0D, 20D, null, null, tacheH, null, null,true);
                tacheL.save();

                //tache dateDebut: (2016,2,10), dateFinTot: (2016,3,5), dateFinTard: (2016,3,5)
                Tache tacheM = new Tache("TacheM", "Cette tâche permet de réaliser l'étude du projet", utilisateur, 0, true, Utils.getDateFrom(2016, 2, 10),
                        Utils.getDateFrom(2016, 3, 5), Utils.getDateFrom(2016, 3, 5), 20D, 0D, 20D, null, null, tacheL, null, null,true);
                tacheM.save();

                projet.creerSousTache(tacheH,tacheF);

                projet.creerTacheEnDessous(tacheI,tacheH);
                projet.creerTacheEnDessous(tacheJ,tacheI);
                projet.creerTacheEnDessous(tacheK,tacheJ);
                projet.creerTacheEnDessous(tacheL,tacheH);
                projet.creerTacheEnDessous(tacheM,tacheL);

                // Afficher l'attribut critique de chaque tache
                /*
                Logger.debug("CRITIQUE");
                Logger.debug("A:" + Tache.find.byId(tacheA.id).critique.toString());
                Logger.debug("B:" + Tache.find.byId(tacheB.id).critique.toString());
                Logger.debug("C:" + Tache.find.byId(tacheC.id).critique.toString());
                Logger.debug("D:" + Tache.find.byId(tacheD.id).critique.toString());
                Logger.debug("E:" + Tache.find.byId(tacheE.id).critique.toString());
                Logger.debug("F:" + Tache.find.byId(tacheF.id).critique.toString());
                Logger.debug("G:" + Tache.find.byId(tacheG.id).critique.toString());
                Logger.debug("H:" + Tache.find.byId(tacheH.id).critique.toString());
                Logger.debug("I:" + Tache.find.byId(tacheI.id).critique.toString());
                Logger.debug("J:" + Tache.find.byId(tacheJ.id).critique.toString());
                Logger.debug("K:" + Tache.find.byId(tacheK.id).critique.toString());
                Logger.debug("L:" + Tache.find.byId(tacheL.id).critique.toString());
                Logger.debug("M:" + Tache.find.byId(tacheM.id).critique.toString());
                Logger.debug("Z:" + Tache.find.byId(tacheZ.id).critique.toString());
                */

                // Verifier le chemin critique
                assertTrue(Tache.find.byId(tacheA.id).critique);
                assertTrue(Tache.find.byId(tacheF.id).critique);
                assertTrue(Tache.find.byId(tacheH.id).critique);
                assertTrue(Tache.find.byId(tacheL.id).critique);
                assertTrue(Tache.find.byId(tacheM.id).critique);

                assertFalse(Tache.find.byId(tacheB.id).critique);
                assertFalse(Tache.find.byId(tacheC.id).critique);
                assertFalse(Tache.find.byId(tacheD.id).critique);
                assertFalse(Tache.find.byId(tacheE.id).critique);
                assertFalse(Tache.find.byId(tacheI.id).critique);
                assertFalse(Tache.find.byId(tacheJ.id).critique);
                assertFalse(Tache.find.byId(tacheK.id).critique);
                assertFalse(Tache.find.byId(tacheZ.id).critique);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    @Test
    public void testUpdateAvancementGlobal() {
        running(fakeApplication(), ()-> {
            Utilisateur utilisateur = new Utilisateur("Z", "Z", "z.z@gmail.com", "1234567980", true, "123456Aa");
            utilisateur.save();

            //projet dateDebutTheorique: 2016,2,2, dateFinTheorique: 2016,3,4, dateDebutReel: 2016,2,2, dateFinReelTot: 2016,3,3, dateFinReelTard: 2016,3,3
            Projet projet = new Projet("Site Apple","Développement du nouveau site d'Apple", utilisateur,
                    Utils.getDateFrom(2016,2,2),Utils.getDateFrom(2016,3,4),Utils.getDateFrom(2016,2,2),
                    Utils.getDateFrom(2016,3,3),Utils.getDateFrom(2016,3,3),24D, UniteProjetEnum.SEMAINE,new Byte("0"),false,false,null,3,null,null);
            projet.save();

            //tache dateDebut: (2016,2,2), dateFinTot: (2016,2,4), dateFinTard: (2016,2,4)
            Tache tacheA = new Tache("TacheA","Cette tâche permet de réaliser l'étude du projet",utilisateur,0,true, Utils.getDateFrom(2016,2,2),
                    Utils.getDateFrom(2016,2,4),Utils.getDateFrom(2016,2,4),20D,0D,20D,null,null,null,null,null,true);
            tacheA.save();

            //tache dateDebut: (2016,2,4), dateFinTot: (2016,2,18), dateFinTard: (2016,2,18)
            Tache tacheB = new Tache("TacheB","Cette tâche permet de réaliser l'étude du projet",utilisateur,0,true, Utils.getDateFrom(2016,2,4),
                    Utils.getDateFrom(2016,2,18),Utils.getDateFrom(2016,2,18),20D,0D,20D,null,null,tacheA,null,null,true);
            tacheB.save();

            //tache dateDebut: (2016,2,18), dateFinTot: (2016,2,28), dateFinTard: (2016,2,28)
            Tache tacheC = new Tache("TacheC","Cette tâche permet de réaliser l'étude du projet",utilisateur,0,true, Utils.getDateFrom(2016,2,18),
                    Utils.getDateFrom(2016,2,28),Utils.getDateFrom(2016,2,28),20D,0D,20D,null,null,tacheB,null,null,true);
            tacheC.save();

            //tache dateDebut: (2016,2,28), dateFinTot: (2016,3,3), dateFinTard: (2016,3,3)
            Tache tacheD = new Tache("TacheD","Cette tâche permet de réaliser l'étude du projet",utilisateur,0,true, Utils.getDateFrom(2016,2,28),
                    Utils.getDateFrom(2016,3,3),Utils.getDateFrom(2016,3,3),20D,0D,20D,null,null,tacheC,null,null,true);
            tacheD.save();

            //tache dateDebut: (2016,2,18), dateFinTot: (2016,2,20), dateFinTard: (2016,2,20)
            Tache tacheE = new Tache("TacheE","Cette tâche permet de réaliser l'étude du projet",utilisateur,0,true, Utils.getDateFrom(2016,2,18),
                    Utils.getDateFrom(2016,2,20),Utils.getDateFrom(2016,2,20),20D,0D,20D,null,null,tacheB,null,null,true);
            tacheE.save();

            //tache dateDebut: (2016,2,4), dateFinTot: (2016,2,20), dateFinTard: (2016,2,20)
            Tache tacheF = new Tache("TacheF","Cette tâche permet de réaliser l'étude du projet",utilisateur,0,true, Utils.getDateFrom(2016,2,4),
                    Utils.getDateFrom(2016,2,20),Utils.getDateFrom(2016,2,20),20D,0D,20D,null,null,tacheA,null,null,true);
            tacheF.save();

            //tache dateDebut: (2016,2,20), dateFinTot: (2016,2,28), dateFinTard: (2016,2,28)
            Tache tacheG = new Tache("TacheG","Cette tâche permet de réaliser l'étude du projet",utilisateur,0,true, Utils.getDateFrom(2016,2,20),
                    Utils.getDateFrom(2016,2,28),Utils.getDateFrom(2016,2,28),20D,0D,20D,null,null,tacheF,null,null,true);
            tacheG.save();

            //tache dateDebut: (2016,2,4), dateFinTot: (2016,2,5), dateFinTard: (2016,2,5)
            Tache tacheH = new Tache("TacheH","Cette tâche permet de réaliser l'étude du projet",utilisateur,0,true, Utils.getDateFrom(2016,2,4),
                    Utils.getDateFrom(2016,2,5),Utils.getDateFrom(2016,2,5),20D,0D,20D,null,null,null,null,null,true);
            tacheH.save();

            //tache dateDebut: (2016,2,5), dateFinTot: (2016,2,10), dateFinTard: (2016,2,10)
            Tache tacheI = new Tache("TacheI","Cette tâche permet de réaliser l'étude du projet",utilisateur,0,true, Utils.getDateFrom(2016,2,5),
                    Utils.getDateFrom(2016,2,10),Utils.getDateFrom(2016,2,10),20D,0D,20D,null,null,tacheH,null,null,true);
            tacheI.save();

            //tache dateDebut: (2016,2,10), dateFinTot: (2016,2,13), dateFinTard: (2016,2,13)
            Tache tacheJ = new Tache("TacheJ","Cette tâche permet de réaliser l'étude du projet",utilisateur,0,true, Utils.getDateFrom(2016,2,10),
                    Utils.getDateFrom(2016,2,13),Utils.getDateFrom(2016,2,13),20D,0D,20D,null,null,tacheI,null,null,true);
            tacheJ.save();

            //tache dateDebut: (2016,2,13), dateFinTot: (2016,2,18), dateFinTard: (2016,2,18)
            Tache tacheK = new Tache("TacheK","Cette tâche permet de réaliser l'étude du projet",utilisateur,0,true, Utils.getDateFrom(2016,2,13),
                    Utils.getDateFrom(2016,2,18),Utils.getDateFrom(2016,2,18),20D,0D,20D,null,null,tacheJ,null,null,true);
            tacheK.save();

            //tache dateDebut: (2016,2,5), dateFinTot: (2016,2,10), dateFinTard: (2016,2,10)
            Tache tacheL = new Tache("TacheL","Cette tâche permet de réaliser l'étude du projet",utilisateur,0,true, Utils.getDateFrom(2016,2,5),
                    Utils.getDateFrom(2016,2,10),Utils.getDateFrom(2016,2,10),20D,0D,20D,null,null,tacheH,null,null,true);
            tacheL.save();

            //tache dateDebut: (2016,2,10), dateFinTot: (2016,2,20), dateFinTard: (2016,2,20)
            Tache tacheM = new Tache("TacheM","Cette tâche permet de réaliser l'étude du projet",utilisateur,0,true, Utils.getDateFrom(2016,2,10),
                    Utils.getDateFrom(2016,2,20),Utils.getDateFrom(2016,2,20),20D,0D,20D,null,null,tacheL,null,null,true);
            tacheM.save();

            try {
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

                /*
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
                */

                // 1er test
                assertEquals(tacheASelected.chargeConsommee, Double.valueOf(0));
                assertEquals(tacheBSelected.chargeConsommee, Double.valueOf(0));
                assertEquals(tacheCSelected.chargeConsommee, Double.valueOf(0));
                assertEquals(tacheDSelected.chargeConsommee, Double.valueOf(0));
                assertEquals(tacheESelected.chargeConsommee, Double.valueOf(0));
                assertEquals(tacheFSelected.chargeConsommee, Double.valueOf(0));
                assertEquals(tacheGSelected.chargeConsommee, Double.valueOf(0));
                assertEquals(tacheHSelected.chargeConsommee, Double.valueOf(0));
                assertEquals(tacheISelected.chargeConsommee, Double.valueOf(0));
                assertEquals(tacheJSelected.chargeConsommee, Double.valueOf(0));
                assertEquals(tacheKSelected.chargeConsommee, Double.valueOf(0));
                assertEquals(tacheLSelected.chargeConsommee, Double.valueOf(0));
                assertEquals(tacheMSelected.chargeConsommee, Double.valueOf(0));

                assertEquals(tacheASelected.chargeRestante, Double.valueOf(20));
                assertEquals(tacheBSelected.chargeRestante, Double.valueOf(20));
                assertEquals(tacheCSelected.chargeRestante, Double.valueOf(20));
                assertEquals(tacheDSelected.chargeRestante, Double.valueOf(20));
                assertEquals(tacheESelected.chargeRestante, Double.valueOf(20));
                assertEquals(tacheFSelected.chargeRestante, Double.valueOf(120));
                assertEquals(tacheGSelected.chargeRestante, Double.valueOf(20));
                assertEquals(tacheHSelected.chargeRestante, Double.valueOf(20));
                assertEquals(tacheISelected.chargeRestante, Double.valueOf(20));
                assertEquals(tacheJSelected.chargeRestante, Double.valueOf(20));
                assertEquals(tacheKSelected.chargeRestante, Double.valueOf(20));
                assertEquals(tacheLSelected.chargeRestante, Double.valueOf(20));
                assertEquals(tacheMSelected.chargeRestante, Double.valueOf(20));

                assertEquals(projetSelected.avancementGlobal.toString(), "0");

                // 2ème test
                // Modifier la charge consommee de tacheC à 10D => tacheC: chargeConsommee=10D, chargeRestante=20D
                tacheC.setChargeConsommee(10D);
                assertEquals(Tache.find.byId(tacheC.id).chargeConsommee, Double.valueOf(10));
                // Attention C'est obligé
                projet.updateAvancementGlobal();
                // Après MAJ, l'avancement = (0+10)/((20+20+20+20+20+(20+20+20+20+20+20)+20)+(0+10)) = 0.04 => "4"
                assertEquals(Projet.find.byId(projet.id).avancementGlobal.toString(), "4");

                // 3ème test
                // Modifier la charge restante de tacheG à 45D => tacheG: chargeConsommee=0D, chargeRestante=45D
                tacheG.setChargeRestante(65D);
                assertEquals(Tache.find.byId(tacheG.id).chargeRestante, Double.valueOf(65));
                projet.updateAvancementGlobal();
                // Après MAJ, l'avancement = (0+10)/((20+20+20+20+20+(20+20+20+20+20+20)+65)+(0+10)) = 0.03 => "3"
                assertEquals(Projet.find.byId(projet.id).avancementGlobal.toString(), "3");

                // 4ème test
                // Modifier la charge consommee de tacheJ(sous tache de tacheF) à 15D => tacheJ: chargeConsommee=15D, chargeRestante=20D
                //                                                                    => tacheF: chargeConsommee=15D, chargeRestante=120D
                tacheJ.setChargeConsommee(15D);
                assertEquals(Tache.find.byId(tacheJ.id).chargeConsommee, Double.valueOf(15));
                assertEquals(Tache.find.byId(tacheF.id).chargeConsommee, Double.valueOf(15));
                // Modifier la charge restante de tacheJ(sous tache de tacheF) à 45D => tacheJ: chargeConsommee=15D, chargeRestante=45D
                //                                                                   => tacheF: chargeConsommee=15D, chargeRestante=145D
                tacheJ.setChargeRestante(45D);
                assertEquals(Tache.find.byId(tacheJ.id).chargeRestante, Double.valueOf(45));
                assertEquals(Tache.find.byId(tacheF.id).chargeRestante, Double.valueOf(145));
                projet.updateAvancementGlobal();
                // Après MAJ, l'avancement = (0+10+15)/((20+20+20+20+20+(20+20+45+20+20+20)+65)+(0+10+15)) = 0.07 => "7"
                assertEquals(Projet.find.byId(projet.id).avancementGlobal.toString(), "7");

            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    @Test
    public void testImportContactClient(){
        running(fakeApplication(), ()-> {

            Client client = new Client("Applee",2,true, null,null, null);
            client.save();
            assertNotNull(client.id);
            assertEquals(client.listeContacts.size(),0);

            List<Contact> listContacts = new BeanList<>();
            Contact contact1 = new Contact("Jobsa","Stevea","s.j@apple.coma","0211465978",null);
            Contact contact2 = new Contact("Jameas","Franka","f.j@apple.coma","0215461979",null);
            listContacts.add(contact1);
            listContacts.add(contact2);
            client.importerListContacts(listContacts);

            Logger.debug(contact1.toString());
            Logger.debug(contact2.toString());
            assertEquals(contact1,Contact.find.where().eq("nom","Jobsa").findUnique());
            assertEquals(contact2,Contact.find.where().eq("nom","Jameas").findUnique());
            contact1.save();
            contact2.save();

            Client cl2 = Client.find.byId(client.id);
            Logger.debug(client.toString());
            Logger.debug(cl2.toString());

            Logger.debug(listContacts.toString());
            Logger.debug(cl2.listeContacts.toString());

            assertTrue(Utils.isEqualList(listContacts, cl2.listeContacts));

        });
    }

    @Test(expected=IllegalArgumentException.class)
    public void testAjouterContactClientException(){
        running(fakeApplication(), ()-> {

            Client cl = new Client("Applee",2,true, null,null, null);
            cl.save();
            Logger.debug(cl.toString());
            assertNotNull(cl.id);
            assertEquals(cl.listeContacts.size(),0);

            Contact c1 = new Contact("Jobsa","Stevea","s.j@apple.coma","0211465978");
            Contact c2 = new Contact("Jobsa","Stevea","s.j@apple.coma","0211465978");

            /* EXCEPTION THROW 2 equals contacts*/
            cl.ajouterContact(c1);
            cl.ajouterContact(c2);

        });
    }

    @Test(expected=IllegalArgumentException.class)
    public void testAffecterProjetClientException(){
        running(fakeApplication(), ()-> {

            Client cl = new Client("Google",3,true, null,null, null);
            cl.save();

            assertNotNull(cl.id);
            assertEquals(cl.listeProjets.size(),0);

            Projet pr = new Projet();
            pr.nom = "Site Google";
            pr.description = "Développement du nouveau site de Google";
            pr.dateDebutTheorique = Utils.getDateFrom(2016,2,2);
            pr.dateFinTheorique = Utils.getDateFrom(2016,2,10);
            pr.dateDebutReel = Utils.getDateFrom(2016,2,3);
            pr.dateFinReelTot = Utils.getDateFrom(2016,2,9);
            pr.chargeInitiale = 24D;
            pr.unite = UniteProjetEnum.SEMAINE;
            pr.avancementGlobal = new Byte("0");

            pr.enCours = true;
            pr.archive = false;
            pr.client = cl;
            pr.priorite = 1;

            cl.affecterProjet(pr);
            cl.affecterProjet(pr);
        });
    }

    @Test
    public void testAffecterProjetClient(){
        running(fakeApplication(), ()-> {

            Client cl = new Client("Atos",1,true, null,null, null);
            cl.save();

            assertNotNull(cl.id);
            assertEquals(cl.listeProjets.size(),0);

            Projet pr = new Projet();
            pr.nom = "Site Atos";
            pr.description = "Développement du nouveau site d'Atos";
            pr.dateDebutTheorique = Utils.getDateFrom(2016,2,2);
            pr.dateFinTheorique = Utils.getDateFrom(2016,2,10);
            pr.dateDebutReel = Utils.getDateFrom(2016,2,3);
            pr.dateFinReelTot = Utils.getDateFrom(2016,2,9);
            pr.dateFinReelTard = Utils.getDateFrom(2016,2,9);
            pr.chargeInitiale = 24D;
            pr.unite = UniteProjetEnum.SEMAINE;
            pr.avancementGlobal = new Byte("0");

            pr.enCours = true;
            pr.archive = false;
            pr.client = cl;
            pr.priorite = 1;
            pr.save();

            Logger.debug("project size 1 : "+cl.listeProjets.size());
            cl.affecterProjet(pr);
            Logger.debug("project size 2 : "+cl.listeProjets.size());
            cl.save();

            Client cl2 = Client.find.where().eq("nom","Atos").findUnique();
            Logger.debug(cl.listeProjets.get(0).toString());
            Logger.debug(cl2.listeProjets.get(0).toString());

            assertEquals(cl.listeProjets.get(0),cl2.listeProjets.get(0));
        });
    }

    @Test
    public void testSupprimerTacheProjet() {
        running(fakeApplication(), ()-> {
            Utilisateur utilisateur = new Utilisateur("Z", "Z", "z.z@gmail.com", "1234567980", true, "123456Aa");
            utilisateur.save();

            //projet dateDebutTheorique: 2016,2,2, dateFinTheorique: 2016,2,29, dateDebutReel: 2016,2,2, dateFinReelTot: 2016,2,28, dateFinReelTard: 2016,2,28
            Projet projet = new Projet("Site Apple","Développement du nouveau site d'Apple", utilisateur,
                    Utils.getDateFrom(2016,2,2),Utils.getDateFrom(2016,2,29),Utils.getDateFrom(2016,2,2),
                    Utils.getDateFrom(2016,2,28),Utils.getDateFrom(2016,2,28),24D, UniteProjetEnum.SEMAINE,new Byte("0"),false,false,null,3,null,null);
            projet.save();

            //tache dateDebut: (2016,2,2), dateFinTot: (2016,2,4), dateFinTard: (2016,2,4)
            Tache tacheA = new Tache("TacheA","Cette tâche permet de réaliser l'étude du projet",utilisateur,0,true, Utils.getDateFrom(2016,2,2),
                    Utils.getDateFrom(2016,2,4),Utils.getDateFrom(2016,2,4),20D,0D,20D,null,null,null,null,null,true);
            tacheA.save();

            //tache dateDebut: (2016,2,4), dateFinTot: (2016,2,18), dateFinTard: (2016,2,18)
            Tache tacheB = new Tache("TacheB","Cette tâche permet de réaliser l'étude du projet",utilisateur,0,true, Utils.getDateFrom(2016,2,4),
                    Utils.getDateFrom(2016,2,18),Utils.getDateFrom(2016,2,18),20D,0D,20D,null,null,tacheA,null,null,true);
            tacheB.save();

            //tache dateDebut: (2016,2,18), dateFinTot: (2016,2,28), dateFinTard: (2016,2,28)
            Tache tacheC = new Tache("TacheC","Cette tâche permet de réaliser l'étude du projet",utilisateur,0,true, Utils.getDateFrom(2016,2,18),
                    Utils.getDateFrom(2016,2,28),Utils.getDateFrom(2016,2,28),20D,0D,20D,null,null,tacheB,null,null,true);
            tacheC.save();

            try {
                // TODO: Il y a exception "Le projet [Site Apple] n'a pas de chemin critique car aucune tache ne termine à la date de fin au plus tard du projet (28/02/2016)"
                projet.creerTacheInitialisationProjet(tacheA);
                projet.creerTacheEnDessous(tacheB,tacheA);
                projet.creerTacheEnDessous(tacheC,tacheB);
                projet.supprimerTache(tacheB);
            } catch (Exception e) {
                e.printStackTrace();
            }

            assertEquals(Projet.find.byId(projet.id).listTaches().size(),2);
            assertTrue(!Projet.find.byId(projet.id).listTaches().contains(Tache.find.byId(tacheB.id)));
            assertEquals(Tache.find.byId(tacheC.id).predecesseur,Tache.find.byId(tacheA.id));
            assertEquals(Tache.find.byId(tacheA.id).getSuccesseurs().get(0),Tache.find.byId(tacheC.id));
        });
    }


}

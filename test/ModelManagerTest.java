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
 * Created by Guillaume on 04/02/2016.
 */
public class ModelManagerTest {

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

    @Test
    public void testExportContactClient(){
        running(fakeApplication(), ()-> {

            Client client = new Client("Microsoft",2,true, null,null, null);
            client.save();
            Logger.debug(client.toString());
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

            List<Contact> listContacts2 = Client.find.byId(client.id).exporterContacts();

            Logger.debug(listContacts.toString());
            Logger.debug(listContacts2.toString());

            assertTrue(Utils.isEqualList(listContacts, listContacts2));

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
            pr.dateFinReel = Utils.getDateFrom(2016,2,9);
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
            pr.dateFinReel = Utils.getDateFrom(2016,2,9);
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

    @Test(expected = IllegalStateException.class)
    public void testAssocierResponsableProjetException(){
        running(fakeApplication(), ()-> {


            Projet pr = new Projet();
            pr.nom = "Site ROCKSTAR";
            pr.description = "Développement du nouveau site de ROCKSTAR";
            pr.dateDebutTheorique = Utils.getDateFrom(2016,2,2);
            pr.dateFinTheorique = Utils.getDateFrom(2016,2,10);
            pr.dateDebutReel = Utils.getDateFrom(2016,2,3);
            pr.dateFinReel = Utils.getDateFrom(2016,2,9);
            pr.chargeInitiale = 24D;
            pr.unite = UniteProjetEnum.SEMAINE;
            pr.avancementGlobal = new Byte("0");
            pr.enCours = true;
            pr.archive = false;
            pr.priorite = 1;
            pr.save();

            Utilisateur u1 = new Utilisateur("NomUser","PrenomUser","ert@gmail.com","0123456789","azertY1");
            u1.save();
            pr.associerResponsable(u1);
            pr.associerResponsable(u1);

        });
    }

    @Test
    public void testAssocierResponsableProjet(){
        running(fakeApplication(), ()-> {

            Projet pr = new Projet();
            pr.nom = "Site ROCKSTAR";
            pr.description = "Développement du nouveau site de ROCKSTAR";
            pr.dateDebutTheorique = Utils.getDateFrom(2016,2,2);
            pr.dateFinTheorique = Utils.getDateFrom(2016,2,10);
            pr.dateDebutReel = Utils.getDateFrom(2016,2,3);
            pr.dateFinReel = Utils.getDateFrom(2016,2,9);
            pr.chargeInitiale = 24D;
            pr.unite = UniteProjetEnum.SEMAINE;
            pr.avancementGlobal = new Byte("0");
            pr.enCours = true;
            pr.archive = false;
            pr.priorite = 1;
            pr.save();

            assertNotNull(pr.id);


            Utilisateur u1 = new Utilisateur("NomUser","PrenomUser","ert@gmail.com","0123456789","azertY1");
            u1.save();
            assertNotNull(u1.id);

            pr.associerResponsable(u1);

            Projet pr2 = Utilisateur.find.byId(u1.id).listProjetsResponsable().get(0);

            assertEquals(pr,pr2);
        });
    }

    @Test
    public void testAjoutTacheProjet() {
        running(fakeApplication(), ()-> {
            Client cl = new Client();
            cl.nom = "Google";
            cl.save();

            Projet projet = new Projet();
            projet.nom = "Site Google";
            projet.description = "Développement du nouveau site de Google";
            projet.dateDebutTheorique = Utils.getDateFrom(2016,2,2);
            projet.dateFinTheorique = Utils.getDateFrom(2016,2,10);
            projet.dateDebutReel = Utils.getDateFrom(2016,2,3);
            projet.dateFinReel = Utils.getDateFrom(2016,2,9);
            projet.chargeInitiale = 24D;
            projet.unite = UniteProjetEnum.SEMAINE;
            projet.avancementGlobal = new Byte("0");
            projet.enCours = true;
            projet.archive = false;
            projet.client = cl;
            projet.priorite = 1;
            projet.save();

            Tache tache1 = new Tache("Etude 1","Cette tâche permet de réaliser l'étude du projet",1,true, Utils.getDateFrom(2016,2,1),
                    Utils.getDateFrom(2016,2,20),Utils.getDateFrom(2016,2,25),20D,0D,20D,null,null);
            Tache tache2 = new Tache("Etude 2","Cette tâche permet de réaliser l'étude poussée du projet",1,true, Utils.getDateFrom(2016,2,1),
                    Utils.getDateFrom(2016,2,20),Utils.getDateFrom(2016,2,25),20D,0D,20D,null,null);
            Tache tache3 = new Tache("Etude 3","Cette tâche permet de réaliser l'étude approfondie du projet",1,true, Utils.getDateFrom(2016,2,1),
                    Utils.getDateFrom(2016,2,20),Utils.getDateFrom(2016,2,25),20D,0D,20D,null,null);


            projet.ajouterTache(tache1);
            projet.ajouterTache(tache2);
            projet.ajouterTache(tache3);

            Logger.debug(projet.toString());
            assertNotNull(projet.id);
            Projet projetBDD = Projet.find.byId(projet.id);
            Logger.debug(projetBDD.toString());

            List<Tache> listTacheProjetBDD = projetBDD.listTaches;

            assertTrue(listTacheProjetBDD.containsAll(projet.listTaches));

            assertEquals(projet,projetBDD);
        });
    }

    @Test
    public void testInsererTacheAvant() {
        running(fakeApplication(), ()-> {
            Client cl = new Client();
            cl.nom = "Google";
            cl.save();

            Projet projet = new Projet();
            projet.nom = "Site Google";
            projet.description = "Développement du nouveau site de Google";
            projet.dateDebutTheorique = Utils.getDateFrom(2016,2,2);
            projet.dateFinTheorique = Utils.getDateFrom(2016,2,10);
            projet.dateDebutReel = Utils.getDateFrom(2016,2,3);
            projet.dateFinReel = Utils.getDateFrom(2016,2,9);
            projet.chargeInitiale = 24D;
            projet.unite = UniteProjetEnum.SEMAINE;
            projet.avancementGlobal = new Byte("0");
            projet.enCours = true;
            projet.archive = false;
            projet.client = cl;
            projet.priorite = 1;
            projet.save();

            Tache tacheApres = new Tache("Etude 1","Cette tâche permet de réaliser l'étude du projet",1,true, Utils.getDateFrom(2016,2,1),
                    Utils.getDateFrom(2016,2,20),Utils.getDateFrom(2016,2,25),20D,0D,20D,null,null);
            Tache tacheAvant = new Tache("Etude 2","Cette tâche permet de réaliser l'étude poussée du projet",1,true, Utils.getDateFrom(2016,1,1),
                    Utils.getDateFrom(2016,1,20),Utils.getDateFrom(2016,1,25),20D,0D,20D,null,null);
            tacheApres.associerResponsable(Utilisateur.find.all().get(0));
            tacheAvant.associerResponsable(Utilisateur.find.all().get(0));

            projet.ajouterTache(tacheApres);
            projet.insererTacheAvant(tacheAvant,tacheApres);

            Logger.debug(projet.toString());
            assertNotNull(projet.id);
            Projet projetBDD = Projet.find.byId(projet.id);
            Logger.debug(projetBDD.toString());

            List<Tache> listTacheProjetBDD = projetBDD.listTaches;

            assertTrue(listTacheProjetBDD.containsAll(projet.listTaches));

            assertEquals(projet,projetBDD);
            assertNotNull(Tache.find.where().eq("nom","Etude 1").findList().get(0));
            assertNotNull(Tache.find.where().eq("nom","Etude 1").findList().get(0).predecesseur);
            assertEquals(tacheAvant,Tache.find.where().eq("nom","Etude 1").findList().get(0).predecesseur);
        });
    }

    @Test
    public void testInsererTacheEntre() {
        running(fakeApplication(), ()-> {
            Client cl = new Client();
            cl.nom = "Google";
            cl.save();

            Projet projet = new Projet();
            projet.nom = "Site Google";
            projet.description = "Développement du nouveau site de Google";
            projet.dateDebutTheorique = Utils.getDateFrom(2016,2,2);
            projet.dateFinTheorique = Utils.getDateFrom(2016,2,10);
            projet.dateDebutReel = Utils.getDateFrom(2016,2,3);
            projet.dateFinReel = Utils.getDateFrom(2016,2,9);
            projet.chargeInitiale = 24D;
            projet.unite = UniteProjetEnum.SEMAINE;
            projet.avancementGlobal = new Byte("0");
            projet.enCours = true;
            projet.archive = false;
            projet.client = cl;
            projet.priorite = 1;
            projet.save();

            Tache tache1 = new Tache("Etude 1","Cette tâche permet de réaliser l'étude du projet",1,true, Utils.getDateFrom(2016,1,1),
                    Utils.getDateFrom(2016,1,20),Utils.getDateFrom(2016,1,25),20D,0D,20D,null,null);
            Tache tache2 = new Tache("Etude 2","Cette tâche permet de réaliser l'étude poussée du projet",1,true, Utils.getDateFrom(2016,2,1),
                    Utils.getDateFrom(2016,2,20),Utils.getDateFrom(2016,2,25),20D,0D,20D,null,null);
            Tache tache3 = new Tache("Etude 3","Cette tâche permet de réaliser l'étude approfondie du projet",1,true, Utils.getDateFrom(2016,3,1),
                    Utils.getDateFrom(2016,3,20),Utils.getDateFrom(2016,3,25),20D,0D,20D,null,null);


            projet.ajouterTache(tache1);
            //1 avant 3
            projet.insererTacheApres(tache1,tache3);
            //1, puis 2, puis 3
            projet.insererTacheAvant(tache2,tache3);

            Logger.debug(projet.toString());
            assertNotNull(projet.id);
            Projet projetBDD = Projet.find.byId(projet.id);
            Logger.debug(projetBDD.toString());

            List<Tache> listTacheProjetBDD = projetBDD.listTaches;

            assertTrue(listTacheProjetBDD.containsAll(projet.listTaches));

            assertEquals(projet,projetBDD);
            assertEquals(tache2,Tache.find.where().eq("nom","Etude 1").findUnique().getSuccesseurs().get(0));
            assertEquals(tache3,Tache.find.where().eq("nom","Etude 2").findUnique().getSuccesseurs().get(0));
        });
    }

    @Test
    public void testInsererTacheApres() {
        running(fakeApplication(), ()-> {
            Client cl = new Client();
            cl.nom = "Google";
            cl.save();

            Projet projet = new Projet();
            projet.nom = "Site Google";
            projet.description = "Développement du nouveau site de Google";
            projet.dateDebutTheorique = Utils.getDateFrom(2016,2,2);
            projet.dateFinTheorique = Utils.getDateFrom(2016,2,10);
            projet.dateDebutReel = Utils.getDateFrom(2016,2,3);
            projet.dateFinReel = Utils.getDateFrom(2016,2,9);
            projet.chargeInitiale = 24D;
            projet.unite = UniteProjetEnum.SEMAINE;
            projet.avancementGlobal = new Byte("0");
            projet.enCours = true;
            projet.archive = false;
            projet.client = cl;
            projet.priorite = 1;
            projet.save();

            Tache tacheAvant = new Tache("Etude 1","Cette tâche permet de réaliser l'étude du projet",1,true, Utils.getDateFrom(2016,2,1),
                    Utils.getDateFrom(2016,2,20),Utils.getDateFrom(2016,2,25),20D,0D,20D,null,null);
            Tache tacheApres = new Tache("Etude 2","Cette tâche permet de réaliser l'étude poussée du projet",1,true, Utils.getDateFrom(2016,3,1),
                    Utils.getDateFrom(2016,3,20),Utils.getDateFrom(2016,3,25),20D,0D,20D,null,null);
            tacheAvant.associerResponsable(Utilisateur.find.all().get(0));
            tacheApres.associerResponsable(Utilisateur.find.all().get(0));

            projet.ajouterTache(tacheAvant);
            projet.insererTacheApres(tacheAvant,tacheApres);

            Logger.debug(projet.toString());
            assertNotNull(projet.id);
            Projet projetBDD = Projet.find.byId(projet.id);
            Logger.debug(projetBDD.toString());

            List<Tache> listTacheProjetBDD = projetBDD.listTaches;

            assertTrue(listTacheProjetBDD.containsAll(projet.listTaches));

            Logger.debug(Tache.find.where().eq("nom","Etude 2").findList().get(0).predecesseur.toString());
            Logger.debug(Tache.find.where().eq("nom","Etude 1").findList().get(0).getSuccesseurs().get(0).toString());

            assertEquals(projet,projetBDD);
            assertEquals(tacheApres,Tache.find.where().eq("nom","Etude 1").findUnique().getSuccesseurs().get(0));
        });
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAjoutTacheProjetException() {
        running(fakeApplication(), ()-> {
            Client cl = new Client();
            cl.nom = "Google";
            cl.save();

            Projet projet = new Projet();
            projet.nom = "Site Google";
            projet.description = "Développement du nouveau site de Google";
            projet.dateDebutTheorique = Utils.getDateFrom(2016,2,2);
            projet.dateFinTheorique = Utils.getDateFrom(2016,2,10);
            projet.dateDebutReel = Utils.getDateFrom(2016,2,3);
            projet.dateFinReel = Utils.getDateFrom(2016,2,9);
            projet.chargeInitiale = 24D;
            projet.unite = UniteProjetEnum.SEMAINE;
            projet.avancementGlobal = new Byte("0");
            projet.enCours = true;
            projet.archive = false;
            projet.client = cl;
            projet.priorite = 1;
            projet.save();

            Tache tache1 = new Tache("Etude 1","Cette tâche permet de réaliser l'étude du projet",1,true, Utils.getDateFrom(2016,2,1),
                    Utils.getDateFrom(2016,2,20),Utils.getDateFrom(2016,2,25),20D,0D,20D,null,null);

            projet.ajouterTache(tache1);
            projet.ajouterTache(tache1);

        });
    }

    @Test
    public void testSupprimerTacheProjet() {
        running(fakeApplication(), ()-> {
            Client cl = new Client();
            cl.nom = "FACEBOOK";
            cl.save();

            Projet projet = new Projet();
            projet.nom = "Site FACEBOOK";
            projet.description = "Développement du nouveau site de FACEBOOK";
            projet.dateDebutTheorique = Utils.getDateFrom(2016,2,2);
            projet.dateFinTheorique = Utils.getDateFrom(2016,2,10);
            projet.dateDebutReel = Utils.getDateFrom(2016,2,3);
            projet.dateFinReel = Utils.getDateFrom(2016,2,9);
            projet.chargeInitiale = 24D;
            projet.unite = UniteProjetEnum.SEMAINE;
            projet.avancementGlobal = new Byte("0");
            projet.enCours = true;
            projet.archive = false;
            projet.client = cl;
            projet.priorite = 1;
            projet.save();

            Tache tache1 = new Tache("Etude FACEBOOK 1","Cette tâche permet de réaliser l'étude du projet",1,true, Utils.getDateFrom(2016,2,1),
                    Utils.getDateFrom(2016,2,20),Utils.getDateFrom(2016,2,25),20D,0D,20D,null,null);
            Tache tache2 = new Tache("Etude FACEBOOK 2","Cette tâche permet de réaliser l'étude poussée du projet",1,true, Utils.getDateFrom(2016,2,1),
                    Utils.getDateFrom(2016,2,20),Utils.getDateFrom(2016,2,25),20D,0D,20D,null,null);
            Tache tache3 = new Tache("Etude FACEBOOK 3","Cette tâche permet de réaliser l'étude approfondie du projet",1,true, Utils.getDateFrom(2016,2,1),
                    Utils.getDateFrom(2016,2,20),Utils.getDateFrom(2016,2,25),20D,0D,20D,null,null);

            projet.ajouterTache(tache1);
            projet.insererTacheApres(tache1,tache2);
            projet.insererTacheApres(tache2,tache3);

            assertEquals(tache1.getSuccesseurs().get(0),tache2);
            assertEquals(tache2.getSuccesseurs().get(0),tache3);
            assertEquals(tache2.predecesseur,tache1);

            assertNotNull(projet.id);
            Projet projetBDD = Projet.find.byId(projet.id);
            Logger.debug(projetBDD.toString());

            assertEquals(projetBDD.listTaches.size(),3);
            projetBDD.supprimerTache(tache2);
            projet.save();

            Projet projetBDD2 = Projet.find.byId(projet.id);
            Logger.debug(projetBDD2.toString());

            assertEquals(projetBDD2.listTaches.size(),2);
            assertTrue(!projetBDD.listTaches.contains(tache2));

            Tache tache1BDD = Tache.find.byId(tache1.id);
            Tache tache3BDD = Tache.find.byId(tache3.id);
            assertEquals(tache3BDD.predecesseur,tache1);
            assertEquals(tache1BDD.getSuccesseurs().get(0),tache3);

        });
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSupprimerTacheProjetException() {
        running(fakeApplication(), ()-> {

            Tache tache1 = new Tache("Etude FACEBOOK 1","Cette tâche permet de réaliser l'étude du projet",1,true, Utils.getDateFrom(2016,2,1),
                    Utils.getDateFrom(2016,2,20),Utils.getDateFrom(2016,2,25),20D,0D,20D,null,null);

            Projet.find.all().get(0).supprimerTache(tache1);
        });
    }

    @Test
    public void testUtilisateurCheckPassword() {
        running(fakeApplication(), ()-> {
            String password = "aZERTY123456";
            String passwordF = "aZERTY123457";

            Utilisateur utilisateur = new Utilisateur();
            utilisateur.nom = "G";
            utilisateur.prenom = "B";
            utilisateur.email = "g.b@gmail.com";
            utilisateur.telephone = "1234567980";
            utilisateur.setPassword(password);
            utilisateur.save();

            assertNotNull(utilisateur.id);
            Logger.debug(utilisateur.toString());


            Utilisateur utilisateur2 = Utilisateur.find.byId(utilisateur.id);
            Logger.debug(utilisateur2.toString());

            assertEquals(utilisateur,utilisateur2);

            assertTrue(utilisateur2.checkPassword(password));
            assertFalse(utilisateur2.checkPassword(passwordF));
        });
    }

    @Test
    public void testUtilisateurGenererPassword() {
        running(fakeApplication(), ()-> {
            String oldPassword = "aZERTY123456";

            Utilisateur utilisateur = new Utilisateur();
            utilisateur.nom = "G";
            utilisateur.prenom = "B";
            utilisateur.email = "g.b@gmail.com";
            utilisateur.telephone = "1234567980";
            utilisateur.setPassword(oldPassword);
            utilisateur.save();

            assertNotNull(utilisateur.id);
            Logger.debug(utilisateur.toString());

            Utilisateur utilisateur2 = Utilisateur.find.byId(utilisateur.id);
            Logger.debug(utilisateur2.toString());

            assertTrue(utilisateur2.checkPassword(oldPassword));

            String newPassword = utilisateur2.genererPassword();
            utilisateur2.setPassword(newPassword);
            utilisateur2.save();

            assertTrue(utilisateur2.checkPassword(newPassword));
            assertFalse(utilisateur2.checkPassword(oldPassword));

        });
    }

    @Test
    public void testUtilisateurAffecterTache() {
        running(fakeApplication(), ()-> {
            String password = "aZERTY123456";

            Utilisateur utilisateur = new Utilisateur();
            utilisateur.nom = "G";
            utilisateur.prenom = "B";
            utilisateur.email = "g.b@gmail.com";
            utilisateur.telephone = "1234567980";
            utilisateur.setPassword(password);
            utilisateur.save();

            Projet projet = new Projet();
            projet.nom = "ProjetTest2";
            projet.save();

            Tache tache = new Tache();
            tache.nom = "Tache1111";
            tache.niveau = 0;
            tache.critique = true;
            tache.dateDebut = Utils.getDateFrom(2016,12,1);
            tache.dateFinTot = Utils.getDateFrom(2016,12,1);
            tache.dateFinTard = Utils.getDateFrom(2016,12,1);
            tache.description = "description tache11111";
            //tache.chargeConsommee = 10D;
            //tache.chargeTotale = 10D;
            tache.chargeInitiale = 10D;
            try {
                tache.setChargeConsommee(10D);
                tache.setChargeTotale(10D);
            } catch (NotAvailableTask notAvailableTask) {
                notAvailableTask.printStackTrace();
            }
            tache.save();

            projet.ajouterTache(tache);

            /*ETC...*/
            utilisateur.affectTache(tache);
            utilisateur.save();

            assertNotNull(utilisateur.id);
            assertNotNull(tache.id);
            assertNotNull(tache.projet);
            assertNotNull(projet.id);
            assertNotNull(projet.listTaches.get(0));

            Utilisateur utilisateur2 = Utilisateur.find.byId(utilisateur.id);
            assertNotNull(utilisateur2.id);
            assertNotNull(utilisateur2.getListTaches());
            Logger.debug("LISTTACHES USER : "+utilisateur2.getListTaches());

            Logger.debug("UTILISATEURS");
            Logger.debug(utilisateur.toString());
            Logger.debug(utilisateur.getListTaches().size()+"");
            Logger.debug(utilisateur2.toString());
            Logger.debug(utilisateur2.getListTaches().size()+"");

            Logger.debug("PROJETS");
            Logger.debug(projet.toString());
            Logger.debug(Projet.find.byId(projet.id).toString());

            Logger.debug("TACHES");
            Logger.debug(tache.toString());
            Logger.debug(Tache.find.byId(tache.id).toString());

            Logger.debug(utilisateur.getListTaches().toString());
            Logger.debug(utilisateur2.getListTaches().toString());

            assertEquals(tache,utilisateur2.getListTaches().get(0));

        });
    }

    @Test(expected = IllegalArgumentException.class)
    public void testUtilisateurPasswordEception() {
        running(fakeApplication(), ()-> {
            String oldPassword = "AZERTY";

            Utilisateur utilisateur = new Utilisateur();
            utilisateur.nom = "G";
            utilisateur.prenom = "B";
            utilisateur.email = "g.b@gmail.com";
            utilisateur.telephone = "1234567980";
            utilisateur.setPassword(oldPassword);
            utilisateur.save();


        });
    }

    @Test
    public void testTacheEstDisponible() {
        running(fakeApplication(), ()-> {
            Utilisateur utilisateur = new Utilisateur();
            utilisateur.nom = "G";
            utilisateur.prenom = "B";
            utilisateur.email = "g.b@gmail.com";
            utilisateur.telephone = "1234567980";
            utilisateur.setPassword("123456Aa");
            utilisateur.save();

            Projet projet = new Projet();
            projet.nom = "ProjetTest2";
            projet.save();

            Tache tache = new Tache();
            tache.nom = "Tache1111";
            tache.description = "description tache11111";
            tache.chargeInitiale = 10D;
            try {
                tache.setChargeConsommee(10D);
                tache.setChargeTotale(10D);
            } catch (NotAvailableTask notAvailableTask) {
                notAvailableTask.printStackTrace();
            }
            tache.save();

            Tache tache2 = new Tache();
            tache2.nom = "Tache1111";
            tache2.description = "description tache11111";
            tache2.associerPredecesseur(tache);
            tache2.save();

            utilisateur.affectTache(tache);
            utilisateur.affectTache(tache2);
            utilisateur.save();

            projet.ajouterTache(tache);
            projet.ajouterTache(tache2);

            assertNotNull(tache.id);
            assertNotNull(tache.projet);
            assertNotNull(projet.id);
            assertNotNull(projet.listTaches.get(0));

            Logger.debug("PROJETS");
            Logger.debug(projet.toString());
            Logger.debug(Projet.find.byId(projet.id).toString());

            Logger.debug("TACHES");
            Logger.debug(tache.toString());
            Logger.debug(Tache.find.byId(tache.id).toString());

            assertTrue(Tache.find.byId(tache2.id).estDisponible());
        });
    }

    @Test
    public void testInsererTacheFille() {
        running(fakeApplication(), ()-> {
            Client cl = new Client();
            cl.nom = "Google";
            cl.save();

            Projet projet = new Projet();
            projet.nom = "Site Google 2";
            projet.description = "Développement du nouveau site de Google 2";
            projet.dateDebutTheorique = Utils.getDateFrom(2016,2,2);
            projet.dateFinTheorique = Utils.getDateFrom(2016,2,10);
            projet.dateDebutReel = Utils.getDateFrom(2016,2,3);
            projet.dateFinReel = Utils.getDateFrom(2016,2,9);
            projet.chargeInitiale = 24D;
            projet.unite = UniteProjetEnum.SEMAINE;
            projet.avancementGlobal = new Byte("0");
            projet.enCours = true;
            projet.archive = false;
            projet.client = cl;
            projet.priorite = 1;
            projet.save();

            Tache tacheMere = new Tache("Etude 11","Cette tâche permet de réaliser l'étude du projet",0,true, Utils.getDateFrom(2016,2,1),
                    Utils.getDateFrom(2016,2,20),Utils.getDateFrom(2016,2,25),20D,0D,20D,null,null);
            Tache tacheFille = new Tache("Etude 22","Cette tâche permet de réaliser l'étude poussée du projet",0,true, Utils.getDateFrom(2016,3,1),
                    Utils.getDateFrom(2016,3,20),Utils.getDateFrom(2016,3,25),20D,0D,20D,null,null);
            tacheMere.associerResponsable(Utilisateur.find.all().get(0));
            tacheFille.associerResponsable(Utilisateur.find.all().get(0));

            projet.ajouterTache(tacheMere);
            projet.insererTacheFille(tacheMere,tacheFille);

            Logger.debug(projet.toString());
            assertNotNull(projet.id);
            Projet projetBDD = Projet.find.byId(projet.id);
            Logger.debug(projetBDD.toString());

            List<Tache> listTacheProjetBDD = projetBDD.listTaches;

            assertTrue(listTacheProjetBDD.containsAll(projet.listTaches));

            Logger.debug(Tache.find.where().eq("nom","Etude 22").findList().get(0).parent.toString());
            Logger.debug(Tache.find.where().eq("nom","Etude 11").findList().get(0).getEnfants().get(0).toString());

            assertEquals(projet,projetBDD);
            assertEquals(tacheFille,Tache.find.where().eq("nom","Etude 11").findUnique().getEnfants().get(0));
            assertEquals(Tache.find.where().eq("nom","Etude 11").findUnique().niveau,Integer.valueOf(0));
            assertEquals(Tache.find.where().eq("nom","Etude 22").findUnique().niveau,Integer.valueOf(1));

        });
    }

    @Test(expected = IllegalStateException.class)
    public void testInsererTacheFilleException() {
        running(fakeApplication(), ()-> {
            Client cl = new Client();
            cl.nom = "Google";
            cl.save();

            Projet projet = new Projet();
            projet.nom = "Site Google 2";
            projet.description = "Développement du nouveau site de Google 2";
            projet.dateDebutTheorique = Utils.getDateFrom(2016,2,2);
            projet.dateFinTheorique = Utils.getDateFrom(2016,2,10);
            projet.dateDebutReel = Utils.getDateFrom(2016,2,3);
            projet.dateFinReel = Utils.getDateFrom(2016,2,9);
            projet.chargeInitiale = 24D;
            projet.unite = UniteProjetEnum.SEMAINE;
            projet.avancementGlobal = new Byte("0");
            projet.enCours = true;
            projet.archive = false;
            projet.client = cl;
            projet.priorite = 1;
            projet.save();

            Tache tacheMere = new Tache("Etude 11","Cette tâche permet de réaliser l'étude du projet",3,true, Utils.getDateFrom(2016,2,1),
                    Utils.getDateFrom(2016,2,20),Utils.getDateFrom(2016,2,25),20D,0D,20D,null,null);
            Tache tacheFille = new Tache("Etude 22","Cette tâche permet de réaliser l'étude poussée du projet",0,true, Utils.getDateFrom(2016,3,1),
                    Utils.getDateFrom(2016,3,20),Utils.getDateFrom(2016,3,25),20D,0D,20D,null,null);
            tacheMere.associerResponsable(Utilisateur.find.all().get(0));
            tacheFille.associerResponsable(Utilisateur.find.all().get(0));

            projet.ajouterTache(tacheMere);
            projet.insererTacheFille(tacheMere,tacheFille);
        });
    }

    @Test
    public void testModifierCharge() {
        running(fakeApplication(), ()-> {
            Tache tacheGrandParent = new Tache();
            tacheGrandParent.nom = "TacheGrandParent";
            tacheGrandParent.description = "description tacheGrandParent";
            tacheGrandParent.niveau = 0;
            tacheGrandParent.chargeInitiale = 10D;
            try {
                tacheGrandParent.setChargeConsommee(10D);
                tacheGrandParent.setChargeTotale(10D);
            } catch (NotAvailableTask notAvailableTask) {
                notAvailableTask.printStackTrace();
            }
            tacheGrandParent.save();

            Tache tacheParent1 = new Tache();
            tacheParent1.nom = "tacheParent1";
            tacheParent1.description = "description tacheParent1";
            tacheParent1.niveau = 1;
            tacheParent1.chargeInitiale = 6D;
            try {
                tacheParent1.setChargeConsommee(6D);
                tacheParent1.setChargeTotale(6D);
            } catch (NotAvailableTask notAvailableTask) {
                notAvailableTask.printStackTrace();
            }
            tacheParent1.save();
            tacheGrandParent.associerSousTache(tacheParent1);

            Tache tacheParent2 = new Tache();
            tacheParent2.nom = "tacheParent2";
            tacheParent2.description = "description tacheParent2";
            tacheParent2.niveau = 1;
            tacheParent2.chargeInitiale = 4D;
            try {
                tacheParent2.setChargeConsommee(4D);
                tacheParent2.setChargeTotale(4D);
            } catch (NotAvailableTask notAvailableTask) {
                notAvailableTask.printStackTrace();
            }
            tacheParent2.save();
            tacheGrandParent.associerSousTache(tacheParent2);
            tacheParent2.associerPredecesseur(tacheParent1);

            Tache tache1 = new Tache();
            tache1.nom = "tache1";
            tache1.description = "description tache1";
            tache1.niveau = 2;
            tache1.chargeInitiale = 1D;
            try {
                tache1.setChargeConsommee(1D);
                tache1.setChargeTotale(1D);
            } catch (NotAvailableTask notAvailableTask) {
                notAvailableTask.printStackTrace();
            }
            tache1.save();
            tacheParent1.associerSousTache(tache1);

            Tache tache2 = new Tache();
            tache2.nom = "tache2";
            tache2.description = "description tache2";
            tache2.niveau = 2;
            tache2.chargeInitiale = 5D;
            try {
                tache2.setChargeConsommee(5D);
                tache2.setChargeTotale(5D);
            } catch (NotAvailableTask notAvailableTask) {
                notAvailableTask.printStackTrace();
            }
            tache2.save();
            tacheParent1.associerSousTache(tache2);
            tache2.associerPredecesseur(tache1);

            Projet projet = new Projet();
            projet.nom = "Projet";
            projet.save();
            projet.ajouterTache(tacheGrandParent);

            Utilisateur u1 = new Utilisateur("NomUser","PrenomUser","ert@gmail.com","0123456789","azertY1");
            u1.save();
            u1.affectTache(tacheGrandParent);
            u1.affectTache(tacheParent1);
            u1.affectTache(tacheParent2);
            u1.affectTache(tache1);
            u1.affectTache(tache2);

            //Structure des taches: tacheGrandParent{tacheParent1, tacheParent2}
            //Structure des taches: tacheParent1{tache1, tache2}
            try {
                //Charge consommee Avant: tacheGrandParent=10, tacheParent1=6, tacheParent2=4, tache1=1 et tache2=5
                assertTrue(Tache.find.byId(tache1.id).getChargeConsommee() == 1D);
                assertTrue(Tache.find.byId(tache2.id).getChargeConsommee() == 5D);
                assertTrue(Tache.find.byId(tacheParent1.id).getChargeConsommee() == 6D);
                assertTrue(Tache.find.byId(tacheParent2.id).getChargeConsommee() == 4D);
                assertTrue(Tache.find.byId(tacheGrandParent.id).getChargeConsommee() == 10D);

                tache1.setChargeConsommee(2D);

                //Charge consommee Apres: tacheGrandParent=11, tacheParent1=7, tacheParent2=4, tache1=2 et tache2=5
                assertTrue(Tache.find.byId(tache1.id).getChargeConsommee() == 2D);
                assertTrue(Tache.find.byId(tache2.id).getChargeConsommee() == 5D);
                assertTrue(Tache.find.byId(tacheParent1.id).getChargeConsommee() == 7D);
                assertTrue(Tache.find.byId(tacheParent2.id).getChargeConsommee() == 4D);
                assertTrue(Tache.find.byId(tacheGrandParent.id).getChargeConsommee() == 11D);

                //Charge totale Avant: tacheGrandParent=10, tacheParent1=6, tacheParent2=4, tache1=1 et tache2=5
                assertTrue(Tache.find.byId(tache1.id).getChargeTotale() == 1D);
                assertTrue(Tache.find.byId(tache2.id).getChargeTotale() == 5D);
                assertTrue(Tache.find.byId(tacheParent1.id).getChargeTotale() == 6D);
                assertTrue(Tache.find.byId(tacheParent2.id).getChargeTotale() == 4D);
                assertTrue(Tache.find.byId(tacheGrandParent.id).getChargeTotale() == 10D);

                tache2.setChargeTotale(7D);

                //Charge totale Apres: tacheGrandParent=12, tacheParent1=8, tacheParent2=4, tache1=1 et tache2=7
                assertTrue(Tache.find.byId(tache1.id).getChargeTotale() == 1D);
                assertTrue(Tache.find.byId(tache2.id).getChargeTotale() == 7D);
                assertTrue(Tache.find.byId(tacheParent1.id).getChargeTotale() == 8D);
                assertTrue(Tache.find.byId(tacheParent2.id).getChargeTotale() == 4D);
                assertTrue(Tache.find.byId(tacheGrandParent.id).getChargeTotale() == 12D);

                tache1.modifierCharge(3D, 5D);
                //Charge consommee Apres: tacheGrandParent=12, tacheParent1=8, tacheParent2=4, tache1=3 et tache2=5
                assertTrue(Tache.find.byId(tache1.id).getChargeConsommee() == 3D);
                assertTrue(Tache.find.byId(tache2.id).getChargeConsommee() == 5D);
                assertTrue(Tache.find.byId(tacheParent1.id).getChargeConsommee() == 8D);
                assertTrue(Tache.find.byId(tacheParent2.id).getChargeConsommee() == 4D);
                assertTrue(Tache.find.byId(tacheGrandParent.id).getChargeConsommee() == 12D);

                //Charge totale Apres: tacheGrandParent=12, tacheParent1=8, tacheParent2=4, tache1=1 et tache2=7
                assertTrue(Tache.find.byId(tache1.id).getChargeTotale() == 5D);
                assertTrue(Tache.find.byId(tache2.id).getChargeTotale() == 7D);
                assertTrue(Tache.find.byId(tacheParent1.id).getChargeTotale() == 12D);
                assertTrue(Tache.find.byId(tacheParent2.id).getChargeTotale() == 4D);
                assertTrue(Tache.find.byId(tacheGrandParent.id).getChargeTotale() == 16D);

            } catch (NotAvailableTask notAvailableTask) {
                notAvailableTask.printStackTrace();
            }

        });
    }
}
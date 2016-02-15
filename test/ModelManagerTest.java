import com.avaje.ebean.common.BeanList;
import models.*;
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
            pr.chargeInitiale = 24;
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
            pr.chargeInitiale = 24;
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
            pr.chargeInitiale = 24;
            pr.unite = UniteProjetEnum.SEMAINE;
            pr.avancementGlobal = new Byte("0");
            pr.enCours = true;
            pr.archive = false;
            pr.priorite = 1;
            pr.save();

            Utilisateur u1 = new Utilisateur("NomUser","PrenomUser","ert@gmail.com","0123456789","azerty");
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
            pr.chargeInitiale = 24;
            pr.unite = UniteProjetEnum.SEMAINE;
            pr.avancementGlobal = new Byte("0");
            pr.enCours = true;
            pr.archive = false;
            pr.priorite = 1;
            pr.save();

            assertNotNull(pr.id);


            Utilisateur u1 = new Utilisateur("NomUser","PrenomUser","ert@gmail.com","0123456789","azerty");
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
            projet.chargeInitiale = 24;
            projet.unite = UniteProjetEnum.SEMAINE;
            projet.avancementGlobal = new Byte("0");
            projet.enCours = true;
            projet.archive = false;
            projet.client = cl;
            projet.priorite = 1;
            projet.save();

            Tache tache1 = new Tache("Etude 1","Cette tâche permet de réaliser l'étude du projet",1,true, Utils.getDateFrom(2016,2,1),
                    Utils.getDateFrom(2016,2,20),Utils.getDateFrom(2016,2,25),20,0,20,null,null);
            Tache tache2 = new Tache("Etude 2","Cette tâche permet de réaliser l'étude poussée du projet",1,true, Utils.getDateFrom(2016,2,1),
                    Utils.getDateFrom(2016,2,20),Utils.getDateFrom(2016,2,25),20,0,20,null,null);
            Tache tache3 = new Tache("Etude 3","Cette tâche permet de réaliser l'étude approfondie du projet",1,true, Utils.getDateFrom(2016,2,1),
                    Utils.getDateFrom(2016,2,20),Utils.getDateFrom(2016,2,25),20,0,20,null,null);


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
            projet.chargeInitiale = 24;
            projet.unite = UniteProjetEnum.SEMAINE;
            projet.avancementGlobal = new Byte("0");
            projet.enCours = true;
            projet.archive = false;
            projet.client = cl;
            projet.priorite = 1;
            projet.save();

            Tache tache1 = new Tache("Etude 1","Cette tâche permet de réaliser l'étude du projet",1,true, Utils.getDateFrom(2016,2,1),
                    Utils.getDateFrom(2016,2,20),Utils.getDateFrom(2016,2,25),20,0,20,null,null);

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
            projet.chargeInitiale = 24;
            projet.unite = UniteProjetEnum.SEMAINE;
            projet.avancementGlobal = new Byte("0");
            projet.enCours = true;
            projet.archive = false;
            projet.client = cl;
            projet.priorite = 1;
            projet.save();

            Tache tache1 = new Tache("Etude FACEBOOK 1","Cette tâche permet de réaliser l'étude du projet",1,true, Utils.getDateFrom(2016,2,1),
                    Utils.getDateFrom(2016,2,20),Utils.getDateFrom(2016,2,25),20,0,20,null,null);
            Tache tache2 = new Tache("Etude FACEBOOK 2","Cette tâche permet de réaliser l'étude poussée du projet",1,true, Utils.getDateFrom(2016,2,1),
                    Utils.getDateFrom(2016,2,20),Utils.getDateFrom(2016,2,25),20,0,20,null,null);
            Tache tache3 = new Tache("Etude FACEBOOK 3","Cette tâche permet de réaliser l'étude approfondie du projet",1,true, Utils.getDateFrom(2016,2,1),
                    Utils.getDateFrom(2016,2,20),Utils.getDateFrom(2016,2,25),20,0,20,null,null);

            projet.ajouterTache(tache1);
            projet.ajouterTache(tache2);
            projet.ajouterTache(tache3);

            assertNotNull(projet.id);
            Projet projetBDD = Projet.find.byId(projet.id);
            Logger.debug(projetBDD.toString());

            assertTrue(projetBDD.listTaches.size() == 3);
            projetBDD.supprimerTache(tache1);

            Projet projetBDD2 = Projet.find.byId(projet.id);
            Logger.debug(projetBDD2.toString());

            assertTrue(projetBDD2.listTaches.size() == 2);
            assertTrue(!projetBDD.listTaches.contains(tache1));
        });
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSupprimerTacheProjetException() {
        running(fakeApplication(), ()-> {

            Tache tache1 = new Tache("Etude FACEBOOK 1","Cette tâche permet de réaliser l'étude du projet",1,true, Utils.getDateFrom(2016,2,1),
                    Utils.getDateFrom(2016,2,20),Utils.getDateFrom(2016,2,25),20,0,20,null,null);

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
    public void testUtilisateurAffecterTache() {
        running(fakeApplication(), ()-> {
            String password = "AZERTY123456";

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
            tache.dateDebut = Utils.getDateFrom(2016,12,01);
            tache.dateFinTot = Utils.getDateFrom(2016,12,01);
            tache.dateFinTard = Utils.getDateFrom(2016,12,01);
            tache.description = "description tache11111";
            tache.chargeConsommee = 10;
            tache.chargeInitiale = 10;
            tache.chargeTotale = 10;
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

    @Test
    public void testTacheEstDisponible() {
        running(fakeApplication(), ()-> {
            Utilisateur utilisateur = new Utilisateur();
            utilisateur.nom = "G";
            utilisateur.prenom = "B";
            utilisateur.email = "g.b@gmail.com";
            utilisateur.telephone = "1234567980";
            utilisateur.setPassword("123456");
            utilisateur.save();

            Projet projet = new Projet();
            projet.nom = "ProjetTest2";
            projet.save();

            Tache tache = new Tache();
            tache.nom = "Tache1111";
            tache.description = "description tache11111";
            tache.chargeConsommee = 10;
            tache.chargeInitiale = 10;
            tache.chargeTotale = 10;
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
}
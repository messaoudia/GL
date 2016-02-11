import com.avaje.ebean.common.BeanList;
import models.*;
import models.Utils.Utils;
import org.junit.Test;
import play.Logger;

import java.util.Date;
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
                    Utils.getDateFrom(2016,2,20),Utils.getDateFrom(2016,2,25),20,0,20,true,null,null);
            Tache tache2 = new Tache("Etude 2","Cette tâche permet de réaliser l'étude poussée du projet",1,true, Utils.getDateFrom(2016,2,1),
                    Utils.getDateFrom(2016,2,20),Utils.getDateFrom(2016,2,25),20,0,20,true,null,null);
            Tache tache3 = new Tache("Etude 3","Cette tâche permet de réaliser l'étude approfondie du projet",1,true, Utils.getDateFrom(2016,2,1),
                    Utils.getDateFrom(2016,2,20),Utils.getDateFrom(2016,2,25),20,0,20,true,null,null);


            projet.ajouterTache(tache1);
            projet.ajouterTache(tache2);
            projet.ajouterTache(tache3);

            Logger.debug(projet.toString());
            assertNotNull(projet.id);
            Projet pr2 = Projet.find.byId(projet.id);
            Logger.debug(pr2.toString());

            assertEquals(projet,pr2);
        });
    }

    @Test
    public void testUtilisateurCheckPassword() {
        running(fakeApplication(), ()-> {
            String password = "AZERTY123456";
            String passwordF = "AZERTY123457";

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

            Projet projet = new Projet();
            projet.nom = "ProjetTest";
            projet.save();

            Tache tache = new Tache();
            tache.nom = "Tache1";
            tache.description = "description tache1";
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
            assertNotNull(utilisateur2.listTaches);

            Logger.debug(utilisateur.toString());
            Logger.debug(utilisateur2.toString());


            Logger.debug(utilisateur.listTaches.toString());
            Logger.debug(utilisateur2.listTaches.toString());

            assertEquals(tache,utilisateur2.listTaches.get(0));

        });
    }

}
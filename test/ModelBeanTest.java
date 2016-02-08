import models.*;
import org.junit.Test;
import play.Logger;

import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static play.test.Helpers.fakeApplication;
import static play.test.Helpers.running;

/**
 * Created by Guillaume on 01/02/2016.
 */
public class ModelBeanTest {

    @Test
    public void testPersistAdresse() {
        running(fakeApplication(), ()-> {
            Adresse a1 = new Adresse("3 Street Cloude","645123","Cupertinoss","America");
            Logger.debug(a1.toString());
            a1.save();
            Logger.debug(a1.toString());
            assertNotNull(a1.id);
            Adresse a2 = Adresse.find.byId(a1.id);
            assertEquals(a1,a2);
        });
    }

    @Test
    public void testPersistClient(){
        running(fakeApplication(), ()-> {
            Adresse a1 = new Adresse("30 Street Cloudz","645019","Cupertinoooo","USAAA");
            a1.save();
            List<Contact> listContacts = new ArrayList<>();
            Contact c1 = new Contact("Jobs","Steve","s.j@apple.com","0215465978");
            c1.save();
            Contact c2 = new Contact("James","Frank","f.j@apple.com","0215465979");
            c2.save();
            listContacts.add(c1);
            listContacts.add(c2);
            Projet pr = new Projet("Site Apple","Développement du nouveau site d'Apple", null,
                    new Date(2016,2,2),new Date(2016,2,10),new Date(2016,2,3),
                    new Date(2016,2,9),24, UniteProjetEnum.SEMAINE,new Byte("0"),false,false,null,3,null);
            pr.save();
            List<Projet> listProjet = Collections.singletonList(pr);
            Client cl = new Client("Applee",2,true, a1,listContacts, listProjet);
            Logger.debug("c1 id="+c1.id);
            cl.save();
            Logger.debug(cl.toString());
            assertNotNull(cl.id);
            Client cl2 = Client.find.byId(cl.id);
            Logger.debug(cl2.toString());
            assertEquals(cl,cl2);
        });
    }

    @Test
    public void testPersistContact() {
        running(fakeApplication(), ()-> {
            Contact c1 = new Contact();
            c1.nom = "Jobs";
            c1.prenom = "Steve";
            c1.email = "s.j@apple.com";
            c1.telephone = "0215465978";
            Client cl = new Client();
            cl.nom = "Apple";
            cl.save();
            c1.client = cl;
            Logger.debug(c1.toString());
            c1.save();
            Logger.debug(c1.toString());
            assertNotNull(c1.id);
            Contact c2 = Contact.find.byId(c1.id);
            Logger.debug(c2.toString());
            assertEquals(c1,c2);
        });
    }

    @Test
    public void testPersistNotification() {
        running(fakeApplication(), ()-> {
            Notification n1 = new Notification();
            n1.title = "3 Street Cloud";
            n1.contentNotification = "64500";
            n1.dateEnvoi = new Date();
            n1.link = "http://localhost:9000/notif";
            n1.etatLecture = false;
            n1.archiver = false;
            n1.utilisateur = new Utilisateur("Jean","De la fontaine","jlf@vieux.com","0247563598","azerty");
            Logger.debug(n1.toString());
            n1.save();
            Logger.debug(n1.toString());
            assertNotNull(n1.id);
            Notification n2 = Notification.find.byId(n1.id);
            assertEquals(n1,n2);
        });
    }

    @Test
    public void testPersistProjet() {
        running(fakeApplication(), ()-> {
            Projet pr = new Projet();
            pr.nom = "Site Apple";
            pr.description = "Développement du nouveau site d'Apple";
            pr.dateDebutTheorique = new Date(2016,2,2);
            pr.dateFinTheorique = new Date(2016,2,10);
            pr.dateDebutReel = new Date(2016,2,3);
            pr.dateFinReel = new Date(2016,2,9);
            pr.chargeInitiale = 24;
            pr.unite = UniteProjetEnum.SEMAINE;
            pr.avancementGlobal = new Byte("0");

            pr.enCours = true;
            pr.archive = false;
            Client cl = new Client();
            cl.nom = "Apple";
            cl.save();
            pr.client = cl;
            pr.priorite = 1;

            Tache p1 = new Tache("Etude 1","Cette tâche permet de réaliser l'étude du projet",1,true, new Date(2016,2,1),
                    new Date(2016,2,20),new Date(2016,2,25),20,0,20,true,null,pr);
            p1.save();
            Tache p2 = new Tache("Etude 2","Cette tâche permet de réaliser l'étude poussée du projet",1,true, new Date(2016,2,1),
                    new Date(2016,2,20),new Date(2016,2,25),20,0,20,true,null,pr);
            p2.save();
            pr.listTaches = Arrays.asList(p1,p2);

            pr.save();
            Logger.debug(pr.toString());
            assertNotNull(pr.id);
            Projet pr2 = Projet.find.byId(pr.id);
            Logger.debug(pr2.toString());

            assertEquals(pr,pr2);
        });
    }

    @Test
    public void testPersistTask() {
        running(fakeApplication(), ()-> {
            Projet pr = new Projet();
            pr.nom = "New project";
            pr.save();
            Tache tache = new Tache("Etude 1","Cette tâche permet de réaliser l'étude du projet",1,true, new Date(2016,2,1),
                    new Date(2016,2,20),new Date(2016,2,25),20,0,20,true,null,pr);
            tache.save();
            Logger.debug(tache.toString());
            assertNotNull(tache.id);
            Tache t2 = Tache.find.byId(tache.id);
            Logger.debug(t2.toString());
            assertEquals(tache,t2);
        });
    }


    @Test
    public void testPersistUser() {
        running(fakeApplication(), ()-> {
            Utilisateur u1 = new Utilisateur();
            u1.nom = "Jobss";
            u1.prenom = "Steeve";
            u1.email = "s.ja@apple.com";
            u1.telephone = "0215465948";
            u1.setPassword("azerty");
            Logger.debug(u1.toString());
            u1.save();
            Logger.debug(u1.toString());
            assertNotNull(u1.id);
            Utilisateur u2 = Utilisateur.find.byId(u1.id);
            assertEquals(u1,u2);
        });
    }
}

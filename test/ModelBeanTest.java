import com.avaje.ebean.common.BeanList;
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
    public void testFindAdress() {
        running(fakeApplication(), ()-> {
            Adresse a1 = new Adresse("3 Street Cloude","645123","Cupertinoss","America");
            Adresse a2 = new Adresse("9 rue nuage","123456","paris","France");
            a1.save();
            a2.save();
            assertNotNull(a1.id);
            assertNotNull(a2.id);
            Adresse a3 = Adresse.find.where().eq("adresse","3 Street Cloude").findList().get(0);
            Adresse a4 = Adresse.find.where().eq("adresse","9 rue nuage").findList().get(0);
            assertEquals(a1,a3);
            assertEquals(a2,a4);
            Adresse a5 = Adresse.find.where().eq("zipCode","645123").findList().get(0);
            Adresse a6 = Adresse.find.where().eq("zipCode","123456").findList().get(0);
            assertEquals(a1,a5);
            assertEquals(a2,a6);
            Adresse a7 = Adresse.find.where().eq("ville","Cupertinoss").findList().get(0);
            Adresse a8 = Adresse.find.where().eq("ville","paris").findList().get(0);
            assertEquals(a1,a7);
            assertEquals(a2,a8);
            Adresse a9 = Adresse.find.where().eq("pays","America").findList().get(0);
            Adresse a10 = Adresse.find.where().eq("pays","France").findList().get(0);
            assertEquals(a1,a9);
            assertEquals(a2,a10);
        });
    }


    @Test
    public void testPersistClient(){
        running(fakeApplication(), ()-> {
            Adresse a1 = new Adresse("30 Street Cloudz","645019","Cupertinoooo","USAAA");
            a1.save();
            List<Contact> listContacts = new BeanList<>();
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
    public void testFindContact() {
        running(fakeApplication(), ()-> {
            Contact c1 = new Contact("Jobs","Steve","s.j@apple.com","0245651229");
            Contact c2 = new Contact("Ibra","Zlatan","z.i@zlatanino.com","0123456789");
            c1.save();
            c2.save();
            assertNotNull(c1.id);
            assertNotNull(c2.id);
            Contact a3 = Contact.find.where().eq("nom","Jobs").findList().get(0);
            Contact a4 = Contact.find.where().eq("nom","Ibra").findList().get(0);
            assertEquals(c1,a3);
            assertEquals(c2,a4);
            Contact a5 = Contact.find.where().eq("prenom","Steve").findList().get(0);
            Contact a6 = Contact.find.where().eq("prenom","Zlatan").findList().get(0);
            assertEquals(c1,a5);
            assertEquals(c2,a6);
            Contact a7 = Contact.find.where().eq("email","s.j@apple.com").findList().get(0);
            Contact a8 = Contact.find.where().eq("email","z.i@zlatanino.com").findList().get(0);
            assertEquals(c1,a7);
            assertEquals(c2,a8);
            Contact a9 = Contact.find.where().eq("telephone","0245651229").findList().get(0);
            Contact a10 = Contact.find.where().eq("telephone","0123456789").findList().get(0);
            assertEquals(c1,a9);
            assertEquals(c2,a10);
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
    public void testFindNotification() {
        running(fakeApplication(), ()-> {
            Notification n1 = new Notification("title1","content1",new Date(2016,10,10),"http://notif1.com",true,false,new Utilisateur());
            Notification n2 = new Notification("title2","content2",new Date(2016,10,12),"http://notif2.com",false,true,new Utilisateur());
            n1.save();
            n2.save();
            assertNotNull(n1.id);
            assertNotNull(n2.id);
            Notification a3 = Notification.find.where().eq("title","title1").findList().get(0);
            Notification a4 = Notification.find.where().eq("title","title2").findList().get(0);
            assertEquals(n1,a3);
            assertEquals(n2,a4);
            Notification a5 = Notification.find.where().eq("contentNotification","content1").findList().get(0);
            Notification a6 = Notification.find.where().eq("contentNotification","content2").findList().get(0);
            assertEquals(n1,a5);
            assertEquals(n2,a6);
            Notification a7 = Notification.find.where().eq("dateEnvoi",new Date(2016,10,10)).findList().get(0);
            Notification a8 = Notification.find.where().eq("dateEnvoi",new Date(2016,10,12)).findList().get(0);
            assertEquals(n1,a7);
            assertEquals(n2,a8);
            Notification a9 = Notification.find.where().eq("link","http://notif1.com").findList().get(0);
            Notification a10 = Notification.find.where().eq("link","http://notif2.com").findList().get(0);
            assertEquals(n1,a9);
            assertEquals(n2,a10);
            Notification a11 = Notification.find.where().eq("etatLecture",true).findList().get(0);
            Notification a12 = Notification.find.where().eq("etatLecture",false).findList().get(0);
            assertEquals(n1,a11);
            assertEquals(n2,a12);
            Notification a13 = Notification.find.where().eq("archiver",false).findList().get(0);
            Notification a14 = Notification.find.where().eq("archiver",true).findList().get(0);
            assertEquals(n1,a13);
            assertEquals(n2,a14);
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
    public void testPersistUtilisateur() {
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

    @Test
    public void testFindUtilisateur() {
        running(fakeApplication(), ()-> {
            Utilisateur u1 = new Utilisateur("A","C","a.c@apple.com","1236549870","TOTO");
            Utilisateur u2 = new Utilisateur("B","D","b.d@zlatanino.com","0147258369","TATA");
            u1.save();
            u2.save();
            assertNotNull(u1.id);
            assertNotNull(u2.id);
            Utilisateur a3 = Utilisateur.find.where().eq("nom","A").findList().get(0);
            Utilisateur a4 = Utilisateur.find.where().eq("nom","B").findList().get(0);
            assertEquals(u1,a3);
            assertEquals(u2,a4);
            Utilisateur a5 = Utilisateur.find.where().eq("prenom","C").findList().get(0);
            Utilisateur a6 = Utilisateur.find.where().eq("prenom","D").findList().get(0);
            assertEquals(u1,a5);
            assertEquals(u2,a6);
            Utilisateur a7 = Utilisateur.find.where().eq("email","a.c@apple.com").findList().get(0);
            Utilisateur a8 = Utilisateur.find.where().eq("email","b.d@zlatanino.com").findList().get(0);
            assertEquals(u1,a7);
            assertEquals(u2,a8);
            Utilisateur a9 = Utilisateur.find.where().eq("telephone","1236549870").findList().get(0);
            Utilisateur a10 = Utilisateur.find.where().eq("telephone","0147258369").findList().get(0);
            assertEquals(u1,a9);
            assertEquals(u2,a10);
            assertEquals(Utilisateur.find.where().eq("password","TOTO").findList().size(),0);
            assertEquals(Utilisateur.find.where().eq("password","TATA").findList().size(),0);
        });
    }
}

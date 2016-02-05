import models.*;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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
            Adresse a1 = new Adresse();
            a1.adresse = "3 Street Cloud";
            a1.zipCode = "64500";
            a1.ville = "Cupertino";
            a1.pays = "USA";
            System.out.println(a1);
            a1.save();
            System.out.println(a1);
            assertNotNull(a1.id);
            Adresse a2 = Adresse.find.byId(a1.id);
            assertEquals(a1,a2);
        });
    }

    @Test
    public void testPersistClient(){
        running(fakeApplication(), ()-> {
            Adresse a1 = new Adresse("3 Street Cloud","64500","Cupertino","USA");
            a1.save();
            List<Contact> listContacts = new ArrayList<>();
            Contact c1 = new Contact("Jobs","Steve","s.j@apple.com","0215465978");
           // c1.save();
            Contact c2 = new Contact("James","Frank","f.j@apple.com","0215465979");
            //c2.save();
            listContacts.add(c1);
            listContacts.add(c2);
            Projet pr = new Projet("Site Apple","Développement du nouveau site d'Apple", null,
                    LocalDate.of(2016,2,2),LocalDate.of(2016,10,2),LocalDate.of(2016,3,2),
                    LocalDate.of(2016,9,2),24, UniteProjetEnum.SEMAINE,new Byte("0"),false,false,null,3,null);
            pr.save();
            List<Projet> listProjet = Collections.singletonList(pr);
            Client cl = new Client("Apple",3,false, a1,listContacts, listProjet);
            cl.save();
            System.out.println(cl);
            assertNotNull(cl.id);
            Client cl2 = Client.find.byId(c1.id);
            System.out.println(cl2);
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
            System.out.println(c1);
            c1.save();
            System.out.println(c1);
            assertNotNull(c1.id);
            Contact c2 = Contact.find.byId(c1.id);
            System.out.println(c2);
            assertEquals(c1,c2);
        });
    }

    @Test
    public void testPersistNotification() {
        running(fakeApplication(), ()-> {
            Notification n1 = new Notification();
            n1.title = "3 Street Cloud";
            n1.contentNotification = "64500";
            n1.dateEnvoi = LocalDate.now();
            n1.link = "http://localhost:9000/notif";
            n1.etatLecture = false;
            n1.archiver = false;
            n1.utilisateur = new Utilisateur("Jean","De la fontaine","jlf@vieux.com","0247563598","azerty");
            System.out.println(n1);
            n1.save();
            System.out.println(n1);
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
            pr.dateDebutTheorique = LocalDate.of(2016,2,2);
            pr.dateFinTheorique = LocalDate.of(2016,10,2);
            pr.dateDebutReel = LocalDate.of(2016,3,2);
            pr.dateFinReel = LocalDate.of(2016,9,2);
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

            Tache p1 = new Tache("Etude 1","Cette tâche permet de réaliser l'étude du projet",1,true, LocalDate.of(2016,2,1),
                    LocalDate.of(2016,2,20),LocalDate.of(2016,2,25),20,0,20,true,null,pr);
            p1.save();
            Tache p2 = new Tache("Etude 2","Cette tâche permet de réaliser l'étude poussée du projet",1,true, LocalDate.of(2016,2,1),
                    LocalDate.of(2016,2,20),LocalDate.of(2016,2,25),20,0,20,true,null,pr);
            p2.save();
            pr.listTaches = Arrays.asList(p1,p2);

            pr.save();
            System.out.println(pr);
            assertNotNull(pr.id);
            Projet pr2 = Projet.find.byId(pr.id);
            System.out.println(pr2);

            assertEquals(pr,pr2);
        });
    }

    @Test
    public void testPersistTask() {
        running(fakeApplication(), ()-> {
            Projet pr = new Projet();
            pr.nom = "New project";
            pr.save();
            Tache tache = new Tache("Etude 1","Cette tâche permet de réaliser l'étude du projet",1,true, LocalDate.of(2016,2,1),
                    LocalDate.of(2016,2,20),LocalDate.of(2016,2,25),20,0,20,true,null,pr);
            tache.save();
            System.out.println(tache);
            assertNotNull(tache.id);
            Tache t2 = Tache.find.byId(tache.id);
            System.out.println(t2);
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
            System.out.println(u1);
            u1.save();
            System.out.println(u1);
            assertNotNull(u1.id);
            Utilisateur u2 = Utilisateur.find.byId(u1.id);
            assertEquals(u1,u2);
        });
    }
}

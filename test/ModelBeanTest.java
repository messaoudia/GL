import models.*;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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
        });
    }
    @Test
    public void testPersistClient(){
        running(fakeApplication(), ()-> {
            Adresse a1 = new Adresse("3 Street Cloud","64500","Cupertino","USA");
            a1.save();
            List<Contact> listContacts = new ArrayList<>();
            Contact c1 = new Contact("Jobs","Steve","s.j@apple.com","0215465978");
            c1.save();
            Contact c2 = new Contact("James","Frank","f.j@apple.com","0215465979");
            c2.save();
            listContacts.add(c1);
            listContacts.add(c2);
            Projet pr = new Projet("Site Apple","Développement du nouveau site d'Apple",
                    LocalDate.of(2016,2,2),LocalDate.of(2016,10,2),LocalDate.of(2016,3,2),
                    LocalDate.of(2016,9,2),24, UniteProjetEnum.SEMAINE,new Byte("0"),false,false,null,3,null);
            pr.save();
            List<Projet> listProjet = Collections.singletonList(pr);
            Client cl = new Client("Apple",3,false, a1,listContacts, listProjet);
            cl.save();
            assertNotNull(cl.id);
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
            System.out.println(n1);
            n1.save();
            System.out.println(n1);
            assertNotNull(n1.id);
        });
    }

    @Test
    public void testPersistContact() {
        running(fakeApplication(), ()-> {
            Contact p1 = new Contact();
            p1.nom = "Jobs";
            p1.prenom = "Steve";
            p1.email = "s.j@apple.com";
            p1.telephone = "0215465978";
            System.out.println(p1);
            p1.save();
            System.out.println(p1);
            assertNotNull(p1.id);
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
            pr.client = null;
            pr.priorite = 1;

            Task p1 = new Task("Etude 1","Cette tâche permet de réaliser l'étude du projet",1,true, LocalDate.of(2016,2,1),
                    LocalDate.of(2016,2,20),LocalDate.of(2016,2,25),20,0,20,true,null,pr);
            p1.save();
            Task p2 = new Task("Etude 2","Cette tâche permet de réaliser l'étude poussée du projet",1,true, LocalDate.of(2016,2,1),
                    LocalDate.of(2016,2,20),LocalDate.of(2016,2,25),20,0,20,true,null,pr);
            p2.save();
            pr.listTasks = Arrays.asList(p1,p2);

            System.out.println(pr);
            pr.save();
            System.out.println(pr);
            assertNotNull(pr.id);
        });
    }

    @Test
    public void testPersistTask() {
        running(fakeApplication(), ()-> {
            Projet pr = new Projet();
            pr.nom = "New project";
            Task task = new Task("Etude 1","Cette tâche permet de réaliser l'étude du projet",1,true, LocalDate.of(2016,2,1),
                    LocalDate.of(2016,2,20),LocalDate.of(2016,2,25),20,0,20,true,null,pr);
            System.out.println(task);
            task.save();
            System.out.println(task);
            assertNotNull(task.id);
        });
    }
}

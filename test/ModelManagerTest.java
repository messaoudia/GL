import com.avaje.ebean.common.BeanList;
import models.Client;
import models.Contact;
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

    public <T> boolean listAreEquals(List<T> l1, List<T> l2){
        return (l1!=null && l2!= null && l1.containsAll(l2)
                && l2.containsAll(l1) && l1.size()==l2.size());
    }


    @Test
    public void testImportContactClient(){
        running(fakeApplication(), ()-> {

            Client client = new Client("Applee",2,true, null,null, null);
            client.save();
            assertNotNull(client.id);
            assertEquals(client.listeContacts.size(),0);

            List<Contact> listContacts = new BeanList<>();
            Contact contact1 = new Contact("Jobsa","Stevea","s.j@apple.coma","0211465978",null,client);
            Contact contact2 = new Contact("Jameas","Franka","f.j@apple.coma","0215461979",null,client);
            listContacts.add(contact1);
            listContacts.add(contact2);
            client.importerListContacts(listContacts);

            Logger.debug(contact1.toString());
            Logger.debug(contact2.toString());
            assertEquals(contact1,Contact.find.where().eq("nom","Jobsa").findUnique());
            assertEquals(contact2,Contact.find.where().eq("nom","Jameas").findUnique());

            Client cl2 = Client.find.byId(client.id);
            Logger.debug(client.toString());
            Logger.debug(cl2.toString());

            Logger.debug(listContacts.toString());
            Logger.debug(cl2.listeContacts.toString());

            assertTrue(listAreEquals(listContacts, cl2.listeContacts));

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
            Contact contact1 = new Contact("Jobsa","Stevea","s.j@apple.coma","0211465978",null,client);
            Contact contact2 = new Contact("Jameas","Franka","f.j@apple.coma","0215461979",null,client);
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

            assertTrue(listAreEquals(listContacts, listContacts2));

        });
    }
}
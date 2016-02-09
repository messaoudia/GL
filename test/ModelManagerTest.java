import models.*;
import org.junit.Test;
import play.Logger;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static play.test.Helpers.fakeApplication;
import static play.test.Helpers.running;

/**
 * Created by Guillaume on 04/02/2016.
 */
public class ModelManagerTest {

    @Test
    public void testImportContactClient(){
        running(fakeApplication(), ()-> {

            Client cl = new Client("Applee",2,true, null,null, null);
            cl.save();
            Logger.debug(cl.toString());
            assertNotNull(cl.id);
            assertNull(cl.listeContacts);

            List<Contact> listContacts = new ArrayList<>();
            Contact c1 = new Contact("Jobs","Steve","s.j@apple.com","0215465978");
            c1.save();
            Contact c2 = new Contact("James","Frank","f.j@apple.com","0215465979");
            c2.save();
            listContacts.add(c1);
            listContacts.add(c2);
            cl.listeContacts = listContacts;
            cl.save();

            assertNotNull(cl.listeContacts);
        });
    }

}

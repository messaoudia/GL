import models.Adresse;
import models.Client;
import models.Personne;
import models.Projet;
import org.junit.Test;
import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Created by Guillaume on 31/01/2016.
 */
public class ModelTest {

    @Test
    public void testPersistAdress() throws SQLException {
        Adresse a1 = new Adresse("3 Street Cloud","64500","Cupertino","USA");
        System.out.println(a1);
        a1.id = new Long("1");
        System.out.println(a1);
        a1.save();
    }

    @Test
    public void testBuildClient(){
        Adresse a1 = new Adresse("3 Street Cloud","64500","Cupertino","USA");
        a1.save();
        List<Personne> listContacts = new ArrayList<>();
        Personne p1 = new Personne("Jobs","Steve","s.j@apple.com","0215465978");
        p1.save();
        Personne p2 = new Personne("James","Frank","f.j@apple.com","0215465979");
        p2.save();
        listContacts.add(p1);
        listContacts.add(p2);
        Projet pr = new Projet("Site Apple","Développement du nouveau site d'Apple",new Date(2016,02,02),new Date(2016,10,02),new Date(2016,03,02),new Date(2016,9,02),24,new Byte("0"),false,false,null,3,null);
        pr.save();
        List<Projet> listProjet = Arrays.asList(pr);
        Client cl = new Client("Apple",3,false, a1,listContacts, listProjet);
        cl.save();

        assertNotNull(cl);
    }
}

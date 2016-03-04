import com.avaje.ebean.Ebean;
import models.EntiteGenerique;
import models.Projet;
import models.Securite.Autorisation;
import models.Securite.Permission;
import models.Securite.Role;
import models.UniteProjetEnum;
import models.Utilisateur;
import models.Utils.Utils;
import org.apache.commons.io.FileUtils;
import org.junit.*;
import play.test.FakeApplication;
import play.test.Helpers;

import java.io.IOException;

/**
 * Created by yachironi on 22/02/16.
 */
public class EntiteSecuriseTest {

    public static FakeApplication app;
    public static String createDdl = "";
    public static String dropDdl = "";

    @BeforeClass
    public static void startApp() throws IOException {
        app = Helpers.fakeApplication(Helpers.inMemoryDatabase());
        Helpers.start(app);

        // Reading the evolution file
        String evolutionContent = FileUtils.readFileToString(
                app.getWrappedApplication().getFile("conf/evolutions/default/1.sql"));
        String[] splittedEvolutionContent = evolutionContent.split("# --- !Ups");
        String[] upsDowns = splittedEvolutionContent[1].split("# --- !Downs");
        createDdl = upsDowns[0];
        dropDdl = upsDowns[1];
    }

    @Before
    public void beforeEachTest() {
        Ebean.execute(Ebean.createCallableSql(dropDdl));
        Ebean.execute(Ebean.createCallableSql(createDdl));
        // Load some roles
        Role role1 = new Role();
        role1.nomDuRole = "administrateur";
        role1.save();

        Role role2 = new Role();
        role2.nomDuRole = "collaborateur";
        role2.save();

        Permission permission1 = new Permission();
        permission1.permissionValue = Permission.PermissionEnum.CreerProjet;
        permission1.role = role1;
        permission1.save();

        Permission permission2 = new Permission();
        permission2.permissionValue = Permission.PermissionEnum.SupprimerProjet;
        permission2.role = role1;
        permission2.save();

        Permission permission3 = new Permission();
        permission3.permissionValue = Permission.PermissionEnum.AfficherContact;
        permission3.role = role2;
        permission3.save();

        role1.addPermission(permission1);
        role1.addPermission(permission2);
        role2.addPermission(permission3);


        // Load some users
        Utilisateur utilisateur1 = Utilisateur.create("lastName1", "firstName1", "first1.last1@mail.com", "0612522543", "hashedPassword1");
        Utilisateur utilisateur2 = Utilisateur.create("lastName2", "firstName2", "first2.last2@mail.com", "0117027893", "hashedPassword2");
        Ebean.save(utilisateur1);
        Ebean.save(utilisateur2);


        // Load some autorisations
        Utilisateur utilisateur1DB = Utilisateur.find.where().eq("email", "first1.last1@mail.com").findList().get(0);
        Utilisateur utilisateur2DB = Utilisateur.find.where().eq("email", "first2.last2@mail.com").findList().get(0);

        Projet projet1 = new Projet("projet1_UNIQUE", "description1", utilisateur1DB,
                Utils.getDateFrom(2016, 2, 2), Utils.getDateFrom(2016, 2, 10), Utils.getDateFrom(2016, 2, 3),
                Utils.getDateFrom(2016, 2, 9), Utils.getDateFrom(2016, 2, 9), 24D, UniteProjetEnum.SEMAINE, new Byte("0"), false, false, null, 3, null,null);
        projet1.save();

        Projet projet1DB = Projet.find.where().eq("nom", "projet1_UNIQUE").findList().get(0);

        Autorisation.donnerLeRole(utilisateur1DB, projet1DB, role1);
        Autorisation.donnerLeRole(utilisateur2DB, projet1DB, role2);

    }

    @Test
    public void testPermissionInsertion() {
        Assert.assertNotEquals(Permission.find.all().size(), 0);
    }

    @Test
    public void testRoleInsertion() {
        Assert.assertEquals(Role.find.all().size(), 2);
        Assert.assertNotEquals(Role.find.all().get(0).permissions.size(), 0);

    }

    @Test
    public void testUserInsertion() {
        Utilisateur.find.where().eq("email", "first1.last1@mail.com").findList().forEach(utilisateur -> {
            System.out.println(utilisateur);
        });
        Assert.assertNotEquals(Utilisateur.find.all().size(), 0);
    }

    @Test
    public void testAutorisationInsertion() {
        Assert.assertNotEquals(Autorisation.find.all().size(), 0);
    }

    @Test
    public void tesetUserAdminAutorisation() {
        Projet projet1DB = Projet.find.where().eq("nom", "projet1_UNIQUE").findList().get(0);
        Utilisateur utilisateur1DB = Utilisateur.find.where().eq("email", "first1.last1@mail.com").findList().get(0);
        Utilisateur utilisateur2DB = Utilisateur.find.where().eq("email", "first2.last2@mail.com").findList().get(0);

        System.out.println("ENTITE ==============+>" + projet1DB);
        System.out.println("USER =============+>" + utilisateur1DB);

        Role role1DB = Role.find.where().eq("nomDuRole", "administrateur").findList().get(0);
        Role role2DB = Role.find.where().eq("nomDuRole", "collaborateur").findList().get(0);

        System.out.println("ROLE =============+>" + role1DB.nomDuRole);

        Permission examplePermission = role1DB.permissions.get(0);
        System.out.println("Permission ==========> " + examplePermission.permissionValue);
        System.out.println("Autorisation =>" + Autorisation.find.where().eq("utilisateur_id", utilisateur1DB.id).findList().get(0).roles.get(0));

        Permission examplePermission2 = role2DB.permissions.get(0);

        Assert.assertEquals(projet1DB.havePermission(utilisateur1DB, examplePermission.permissionValue), true);
        Assert.assertEquals(projet1DB.havePermission(utilisateur1DB, examplePermission2.permissionValue), false);
        Assert.assertEquals(projet1DB.havePermission(utilisateur2DB, examplePermission2.permissionValue), true);

        //Delete role Test
        Autorisation.enleverLeRole(utilisateur2DB, projet1DB, role2DB);
        Assert.assertEquals(projet1DB.havePermission(utilisateur2DB, examplePermission2.permissionValue), false);
    }

    @Test
    public void testStaticEntite() {
        EntiteGenerique system = new EntiteGenerique();
        system.nom = "system";
        system.save();
        EntiteGenerique systemDB = EntiteGenerique.find.where().eq("nom", "system").findUnique();

        Assert.assertNotEquals(systemDB, null);
    }

    @AfterClass
    public static void stopApp() {
        Helpers.stop(app);
    }
}

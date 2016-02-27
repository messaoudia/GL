package controllers.Global;

import com.avaje.ebean.Ebean;
import models.Client;
import models.EntiteGenerique;
import models.Projet;
import models.Securite.Autorisation;
import models.Securite.Role;
import models.Utilisateur;
import play.GlobalSettings;
import play.Logger;
import play.libs.Yaml;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by Guillaume on 05/02/2016.
 */

public class Global extends GlobalSettings {

    @Override
    public void onStart(play.Application app) {
        Logger.info("Application has started");
        // Check if the database is empty
        if (Utilisateur.find.findRowCount() == 0) {
            //Ebean.save((List) Yaml.load("initial-data.yml"));

            Map<String, List<Object>> all = (Map<String, List<Object>>) Yaml.load("initial-data.yml");

            /* display file content */
            /*Logger.debug(all.get("adresses").toString());
            Logger.debug(all.get("contacts").toString());
            Logger.debug(all.get("clients").toString());
            Logger.debug(all.get("utilisateurs").toString());
            Logger.debug(all.get("projets").toString());
            Logger.debug(all.get("taches").toString());*/

            /* add elements to DB */
            all.forEach((key, value) -> Ebean.save(value));

            Client.find.all().stream().forEach(client -> {
                Logger.debug("Client:" + client.nom);
                client.listeContacts.forEach(contact -> {
                    Logger.debug("- contact:" + contact);
                });
            });

            Projet.find.all().stream().forEach(projet -> {
                Logger.debug("Projet:" + projet.chargeRestante);
                Logger.debug("Projet:" + projet.chargeConsommee);

            });

            Role.find.all().stream().forEach(role -> {
                Logger.debug("Role:" + role.nomDuRole);
                role.permissions.forEach(permission -> {
                    Logger.debug(" - Permission:" + permission.permissionValue.name());
                });
            });

            Autorisation.find.all().stream().forEach(autorisation -> {
                Logger.debug("Autorisation:");
                Logger.debug("- utilisateur id: " + autorisation.utilisateur.id);
                Logger.debug("- entiteSecurise id: " + autorisation.entiteSecurise.id);
                Logger.debug("- role: " + autorisation.roles.stream().map(x -> x.nomDuRole).collect(Collectors.toList()));
            });

            if (EntiteGenerique.find.where().eq("nom", "system").findUnique() == null) {
                throw new IllegalStateException("EntiteGenerique: system , non charge, veuillez verifier initial-data.yml");
            } else {
                EntiteGenerique.find.all().forEach(entiteGenerique -> {
                    Logger.debug("EntiteGenerique:" + entiteGenerique.nom);
                });
            }
            /* display DB content */
            /*Logger.debug(String.valueOf(Adresse.find.all()));
            Logger.debug(String.valueOf(Contact.find.all()));
            Logger.debug(String.valueOf(Client.find.all()));
            Logger.debug(String.valueOf(Projet.find.all()));
            Logger.debug(String.valueOf(Tache.find.byId(16L)));
            Logger.debug(String.valueOf(Utilisateur.find.byId(11L)));
            Logger.debug(String.valueOf(Utilisateur.find.byId(12L)));
            Logger.debug(String.valueOf(Utilisateur.find.byId(13L)));
            Logger.debug(String.valueOf(Utilisateur.find.byId(14L)));
            Tache t = Utilisateur.find.byId(12L).listTachesResponsable().get(0);*/

        }
    }

}
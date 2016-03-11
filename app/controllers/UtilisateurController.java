package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.common.collect.ImmutableMap;
import controllers.Global.Mail;
import controllers.Global.StaticEntite;
import models.Error;
import models.*;
import models.Securite.Autorisation;
import models.Securite.Role;
import play.Logger;
import play.libs.Json;
import play.libs.mailer.Email;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.creerUtilisateur;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UtilisateurController extends Controller {


    public Result afficherCreerUtilisateur() {
        return ok(creerUtilisateur.render("Créer Utilisateur"));
    }

    public Error isFormulaireCorrect(Map<String, String[]> map, String preName) {
        Error error = new Error();

        Pattern nameRegex = Pattern.compile("^[A-Za-z ,.'-éèàêîï]{1,15}$");
        Matcher nameMatch = nameRegex.matcher(map.get(preName + "-formLastName")[0].trim());

        //TODO regex nom : que des lettres ' -
        // nom utilisateur [1,15] char
        if (map.get(preName + "-formLastName")[0].trim().isEmpty()) {
            error.nomVide = true;
            //return badRequest(Json.toJson(error));
        } else if (map.get(preName + "-formLastName")[0].trim().length() > 15) {
            error.nomTropLong = true;
        } else if (!nameMatch.matches()) {
            error.nomIncorrect = true;
        }
        nameMatch = nameRegex.matcher(map.get(preName + "-formFirstName")[0].trim());
        //TODO regex prenom : que des lettres ' -
        // prenom utilisateur [1,15] char
        if (map.get(preName + "-formFirstName")[0].trim().isEmpty()) {
            error.prenomVide = true;
        } else if (map.get(preName + "-formFirstName")[0].trim().length() > 15) {
            error.prenomTropLong = true;
        } else if (!nameMatch.matches()) {
            error.prenomIncorrect = true;
        }

        //pattern java
        Pattern emailRegex = Pattern.compile("^[_a-z0-9-]+(\\.[_a-z0-9-]+)*@[a-z0-9-]+(\\.[a-z0-9-]+)+$");
        Matcher emailMatch = emailRegex.matcher(map.get(preName + "-formEmail")[0]);
        // email
        if (map.get(preName + "-formEmail")[0].trim().isEmpty()) {
            error.emailVide = true;
        } else if (!emailMatch.matches()) {
            error.emailIncorrecte = true;
        } else if (map.get(preName + "-formEmail")[0].trim().length() > 50) {
            error.emailTropLong = true;
        }

        String telRegexS = "^(([(]?(\\d{2,4})[)]?)|(\\d{2,4})|([+1-9]+\\d{1,2}))?[-\\s]?(\\d{2,3})?[-\\s]?((\\d{7,8})|(\\d{3,4}[-\\s]\\d{3,4}))$";
        Pattern telRegex = Pattern.compile(telRegexS);
        Matcher telMatch = telRegex.matcher(map.get(preName + "-formTel")[0]);
        boolean res = Pattern.matches(telRegexS, map.get(preName + "-formTel")[0]);
        // tel
        if (map.get(preName + "-formTel")[0].trim().isEmpty()) {
            error.telVide = true;
        } else if (!telMatch.matches()) {
            error.telIncorrecte = true;
        } else if (map.get(preName + "-formTel")[0].trim().length() > 15) {
            //TODO je crois que cette condition ne sert a rien en fait car la regex du tel bloque a elle tt seul quand on depasse 15 char
            //TODO si condiition est supprime, la supprimer dans main.scala.html dans creerUtilisateur().ajax
            error.telTropLong = true;
        }
        return error;
    }

    public Result creerUtilisateur() {

        Map<String, String[]> map = request().body().asFormUrlEncoded();
        Error error = isFormulaireCorrect(map, "new");
        List<Utilisateur> listUser = Utilisateur.find.where().eq("email", map.get("new-formEmail")[0].trim()).findList();

        if (!listUser.isEmpty()) {
            error.userExist = true;
        }

        if (error.hasErrorUtilisateur()) {
            return badRequest(Json.toJson(error));
        } else {
            Utilisateur user = Utilisateur.create(map.get("new-formLastName")[0], map.get("new-formFirstName")[0], map.get("new-formEmail")[0], map.get("new-formTel")[0], Utilisateur.genererPassword());
            //creation user
            //TODO si admin = OUI, si admin = NON
            if (map.get("admin")[0].equals("Oui")) {
                //TODO lui donner droit admin
                System.out.println("Creation d'un admin ...");
                donnerDroitAdmin(user);
            }

            //user.save();
            //TODO : send email to user
            return ok(Json.toJson(user));
        }
    }

    public void donnerDroitAdmin(Utilisateur utilisateur) {
        Autorisation.donnerLeRole(utilisateur,StaticEntite.getSystem(),Role.getRole("Administrateur"));
    }

    public void retirerDroitAdmin(Utilisateur utilisateur) {
        // Enlever le droit administrateur du system
        Autorisation autorisationQuiVaEtreSupprime = Autorisation.find
                .where()
                .allEq(ImmutableMap.of("utilisateur.id", utilisateur.id.toString(), "entiteSecurise.id", StaticEntite.getSystem().id))
                .findUnique();

        autorisationQuiVaEtreSupprime.roles.removeIf(role -> role.nomDuRole.equals("Administrateur"));
        autorisationQuiVaEtreSupprime.update();
    }

    public Result modifierUtilisateur(Long idUtilisateur) {
        Utilisateur utst = Utilisateur.find.byId(idUtilisateur);
        System.out.println("Utilisateur utst " + utst);

        Map<String, String[]> map = request().body().asFormUrlEncoded();

        Error error = isFormulaireCorrect(map, "modify");

        if (error.hasErrorUtilisateur()) {
            return badRequest(Json.toJson(error));
        }

        if (utst == null) {
            error.userExist = false;
            return badRequest(Json.toJson(error));
        }

        String email = map.get("modify-formEmail")[0].trim();
        Logger.debug(email);
        if (!utst.email.equals(email)) {
            List<Utilisateur> listUser = Utilisateur.find.where().eq("email", email).findList();
            if (!listUser.isEmpty()) {

                error.userExist = true;
                return badRequest(Json.toJson(error));
            }
        }

        //TODO modifier l'utilisateur
        utst.setFirstName(map.get("modify-formFirstName")[0].trim());
        utst.setLastName(map.get("modify-formLastName")[0].trim());
        utst.setEmail(map.get("modify-formEmail")[0].trim());
        utst.setTelephone(map.get("modify-formTel")[0].trim());

        //on donne les droit d'admin
        if (map.get("admin")[0].equals("Oui") && !utst.checkAdmin()) {
            System.out.println("Ajout droit admin ...");
            donnerDroitAdmin(utst);
        }
        //
        else if (map.get("admin")[0].equals("Non") && utst.checkAdmin()) {
            System.out.println("Retirer droit admin");
            retirerDroitAdmin(utst);
        }


        //map.get("new-formLastName")[0]
        //map.get("new-formFirstName")[0]
        //map.get("new-formEmail")[0]
        //map.get("new-formTel")[0]
        //map.get("admin")[0].equals("Oui")
        utst.save();

        return ok(Json.toJson(utst));
    }

    public Result afficherUtilisateursNonArchives() {
        return ok(Json.toJson(Utilisateur.getAllNonArchives()));
    }

    public Result listProjetsUtilisateur(Long idUtilisateur) {
        List<Projet> listProjetsUtilisateur = Utilisateur.find.byId(idUtilisateur).listProjetsResponsable();
        List<Projet> result = new ArrayList<>();

        for(Projet p : listProjetsUtilisateur){
            if(!p.archive && !p.estTermine()){
                result.add(p);
            }
        }
        return ok(Json.toJson(result));
    }

    public Result listTachesUtilisateur(Long idUtilisateur) {
        List<Tache> listTaches = Utilisateur.find.byId(idUtilisateur).listTaches();
        List<Tache> result = new ArrayList<>();

        for(Tache t : listTaches){
            Logger.debug("Tache archive : "+t.archive);
            Logger.debug("Tache terminee : "+t.estTerminee());
            if(!t.archive && !t.estTerminee()){
                result.add(t);
            }
        }

        JsonNode nodeArray = Json.toJson(result);

        int i = 0;
        for (JsonNode element : nodeArray) {
            ObjectNode o = (ObjectNode) element;
            if (result.get(i).predecesseur != null) {
                o.put("predecesseurIdTache", result.get(i).predecesseur.idTache);
            }
            i++;
        }

        return ok(nodeArray);
    }

    public Result listTachesUtilisateurConnecte() {
        return listTachesUtilisateur(Login.getUtilisateurConnecte().id);
    }

    public Result supprimerUtilisateur(Long idUtilisateur, String strProjet, String strTache) {
        String[] arrayProjets = strProjet.split(";");
        String[] arrayTaches = strTache.split(";");

        HashMap<String, String> mapProjet = new HashMap<>();
        HashMap<String, String> mapTache = new HashMap<>();

        for (String projetUser : arrayProjets) {
            if (!projetUser.equals("")) {
                mapProjet.put(projetUser.split(",")[0], projetUser.split(",")[1]);
            }
        }

        for (String tacheUser : arrayTaches) {
            if (!tacheUser.equals("")) {
                mapTache.put(tacheUser.split(",")[0], tacheUser.split(",")[1]);
            }
        }

        Logger.debug(mapProjet.toString());
        Logger.debug(mapTache.toString());

        Map<Utilisateur, Notification> mapNotifications = new HashMap<Utilisateur, Notification>();

        //Projets
        // <idProjet,idUtilisateur>
        for (Map.Entry<String, String> entry : mapProjet.entrySet()) {
            Projet projet = Projet.find.byId(Long.valueOf(entry.getKey()));
            Utilisateur utilisateur = Utilisateur.find.byId(Long.valueOf(entry.getValue()));
            projet.modifierResponsable(utilisateur);
            utilisateur.save();
            Notification.notificationSuppressionUtilisateurProjet(mapNotifications, utilisateur, projet);
        }

        //Taches
        //<idTache,idUtilisateur>
        for (Map.Entry<String, String> entry : mapTache.entrySet()) {
            Tache tache = Tache.find.byId(Long.valueOf(entry.getKey()));
            Utilisateur utilisateur = Utilisateur.find.byId(Long.valueOf(entry.getValue()));
            utilisateur.affectTache(tache);
            utilisateur.save();
            Notification.notificationSuppressionUtilisateurTache(mapNotifications, utilisateur, tache);
        }

        for (Map.Entry<Utilisateur, Notification> entry : mapNotifications.entrySet()) {
            System.out.println("Utilisateur : " + entry.getKey().prenom);
            System.out.println("===> Notif = " + entry.getValue().contentNotification);
        }

        // Envoie des notifications
        Notification.sendNotifications(mapNotifications);

        //Delete Utilisateur
        Utilisateur u = Utilisateur.find.byId(idUtilisateur);
        u.archive = true;
        u.save();
        return ok();
    }

    public Result allUsers() {
        return ok(Json.toJson(Utilisateur.find.all()));
    }

    /**
     * Modifie la liste des utilisateurs suivis de idUtilisateurConnecte
     *
     * @param idUtilisateurConnecte
     * @param listUtilisateurs
     * @return
     */
    public Result modifierUtilisateursASuivre(Long idUtilisateurConnecte, String listUtilisateurs) {
        Utilisateur utilisateur = Utilisateur.find.byId(idUtilisateurConnecte);
        utilisateur.utilisateursSuivis.clear();
        String[] listUtilisateursParse = listUtilisateurs.split(",");
        for (String emailUtilisateur : listUtilisateursParse) {
            Utilisateur utilisateurASuivre = Utilisateur.find.where().eq("email", emailUtilisateur.trim()).findUnique();
            if (utilisateurASuivre != null) {
                utilisateur.suivreUnUtilisateur(utilisateurASuivre);
            }
        }
        return ok();
    }

    /**
     * Active ou désactive le parametre 'Recevoir une notification si j'effectue une action'
     *
     * @param idUtilisateurConnecte
     * @param checkbox
     * @return
     */
    public Result modifierNotificationMesActions(Long idUtilisateurConnecte, boolean checkbox) {
        Utilisateur utilisateur = Utilisateur.find.byId(idUtilisateurConnecte);
        if (utilisateur != null) {
            utilisateur.recevoirNotifPourMesActions = checkbox;
            utilisateur.update();
        }
        return ok();
    }

    /**
     * Active ou désactive le parametre 'Recevoir une notification pour mes taches presque finies'
     *
     * @param idUtilisateurConnecte
     * @param checkbox
     * @return
     */
    public Result modifierNotificationTachesPresqueFinies(Long idUtilisateurConnecte, boolean checkbox) {
        Utilisateur utilisateur = Utilisateur.find.byId(idUtilisateurConnecte);
        if (utilisateur != null) {
            utilisateur.recevoirNotifPourMesTachesPresqueFinies = checkbox;
            utilisateur.update();
        }
        return ok();
    }

    /**
     * Active ou désactive le parametre 'Recevoir une notification pour mes taches retardees'
     *
     * @param idUtilisateurConnecte
     * @param checkbox
     * @return
     */
    public Result modifierNotificationTachesRetardees(Long idUtilisateurConnecte, boolean checkbox) {
        Utilisateur utilisateur = Utilisateur.find.byId(idUtilisateurConnecte);
        if (utilisateur != null) {
            utilisateur.recevoirNotifPourMesTachesRetardees = checkbox;
            utilisateur.update();
        }
        return ok();
    }

    public Result changePassword(Long idUser, String previousPassword, String newPassword, String confirmNewPassword) {
        Utilisateur user = Utilisateur.find.byId(idUser);
        boolean previousPasswordCorrect = user.checkPassword(previousPassword);
        boolean newPasswordCorrect;
        if (newPassword.length() < 6) {
            newPasswordCorrect = false;
        } else {
            boolean hasMajuscule = false;
            boolean hasMinuscule = false;
            boolean hasChiffre = false;
            for (int i = 0; i < newPassword.length(); i++) {
                char caractere = newPassword.charAt(i);
                if (caractere >= 'A' && caractere <= 'Z') {
                    hasMajuscule = true;
                } else if (caractere >= 'a' && caractere <= 'z') {
                    hasMinuscule = true;
                } else if (caractere >= '0' && caractere <= '9') {
                    hasChiffre = true;
                }
            }
            newPasswordCorrect = hasMajuscule && hasMinuscule && hasChiffre;
        }

        boolean confirmNewPasswordCorrect = newPassword.equals(confirmNewPassword);
        if (previousPasswordCorrect && newPasswordCorrect && confirmNewPasswordCorrect) {
            user.setPassword(newPassword);
            user.save();
            return ok();
        }
        return badRequest(Json.toJson(ImmutableMap.of("previousPasswordCorrect", previousPasswordCorrect, "newPasswordCorrect", newPasswordCorrect,
                "confirmNewPasswordCorrect", confirmNewPasswordCorrect)));
    }

    public Result isAdmin() {
        return ok(StaticEntite.getSystem().haveRole(Login.getUtilisateurConnecte(), Role.getRole("Administrateur")).toString());
    }
}

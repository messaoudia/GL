package controllers;

import com.avaje.ebean.common.BeanList;
import com.fasterxml.jackson.databind.JsonNode;
import models.*;
import models.Error;
import controllers.Utils.Utils;
import play.Logger;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.client;
import views.html.creerClient;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * Created by Gishan on 03/01/2016.
 */
public class ClientController extends Controller {

    public Result afficherClients() {
        return ok(client.render("Clients", Login.getUtilisateurConnecte()));
    }

    public Result afficherCreerClient() {
        return ok(creerClient.render("Créer Client"));
    }

    public Error checkCreationClient(String nomClient,String adresseClient, String codePostal, String ville, String pays){
        Pattern nameRegex = Pattern.compile("^[A-Za-z ,.'0-9-]{1,30}$");
        Matcher nameMatch = nameRegex.matcher(nomClient);
        Error error = new Error();
        if(nomClient.isEmpty()){
            error.nomClientVide = true;
        }else if(!nameMatch.matches()) {
            error.nomIncorrect = true;
        }else if(nomClient.length()>30){
            error.nomClientTropLong = true;
        }

        if(adresseClient.isEmpty()){
            error.adresseVide = true;
        }else if(adresseClient.length()>50){
            error.adresseTropLong = true;
        }

        if(codePostal.isEmpty()){
            error.codePostalVide = true;
        }else if(codePostal.length()>10){
            error.codePostalTropLong = true;
        }

        if(ville.isEmpty()){
            error.villeVide = true;
        }else if(ville.length()>20){
            error.villeTropLong = true;
        }

        if(pays.isEmpty()){
            error.paysVide = true;
        }else if(pays.length()>20){
            error.paysTropLong = true;
        }

       return error;
    }

    public Result creerClient()
    {
        JsonNode json = request().body().asJson();
        String nomClient =  json.get("form").get("formCreerClientName").asText().trim();
        System.out.println("NOM DU CLIENT EST : "+nomClient);
        String adresseClient =  json.get("form").get("formCreerClientAdress").asText().trim();
        String codePostal =  json.get("form").get("formCreerClientZipCode").asText().trim();
        String ville =  json.get("form").get("formCreerClientCity").asText().trim();
        String pays =  json.get("form").get("formCreerClientCountry").asText().trim();
        int priorite = json.get("priorite").asInt();
        Error error = checkCreationClient(nomClient,adresseClient,codePostal,ville,pays);

        Adresse adresse = new Adresse(adresseClient,codePostal,ville,pays);
        List<Contact> listC = new BeanList<>();
        Client client = new Client(nomClient,priorite,false, adresse, listC, null);

        if(!Client.find.where().eq("nom",nomClient).findList().isEmpty()){
            error.clientExiste = true;
        }
        if(error.hasErrorClient()) {
            return badRequest(Json.toJson(error));
        }else {
            adresse.save();
            if(json.get("table") != null){
                Iterator<JsonNode> elements = json.get("table").elements();
                String nom ="",prenom="",email="",tel="";
                while(elements.hasNext()){
                    JsonNode contact = elements.next();
                    Contact c = new Contact(contact.get("Nom").asText(),contact.get("Prenom").asText(), contact.get("Email").asText(),contact.get("Tel").asText(), new BeanList<Tache>());
                    c.save();
                    listC.add(c);
                }
            }
            client.listeContacts = listC;
            client.save();
            for(Contact c : listC){
                c.client = client;
                c.save();
            }
            return ok(Json.toJson(client));
        }
    }

    public Result contactCheck() {

        Map<String, String[]> map = request().body().asFormUrlEncoded();

        Error error = new Error();
        String nom = map.get("formLastNameContactClient")[0].trim();
        String prenom = map.get("formFirstNameContactClient")[0].trim();
        String email =  map.get("formEmailContactClient")[0].trim();
        String tel =  map.get("formTelContactClient")[0].trim();

        Pattern nameRegex = Pattern.compile("^[A-Za-z ,.'-]{1,15}$");
        Matcher nameMatch = nameRegex.matcher(nom);
        Matcher prenomMatch = nameRegex.matcher(prenom);

        if(nom.isEmpty()){
            error.nomVideContact = true;
        }
        else if(!nameMatch.matches()) {
            error.nomIncorrectContact = true;
        }else if(nom.length()>15){
            error.nomTropLongContact = true;

        if(prenom.isEmpty()) {
            error.prenomVideContact = true;
        }
        }else if(!prenomMatch.matches()) {
            error.prenomIncorrectContact = true;
        }else if(prenom.length()>15) {
            error.prenomTropLongContact = true;
        }
        //pattern java
        Pattern emailRegex = Pattern.compile("^[_a-z0-9-]+(\\.[_a-z0-9-]+)*@[a-z0-9-]+(\\.[a-z0-9-]+)+$");
        Matcher emailMatch = emailRegex.matcher(email);
        // email
        if(email.isEmpty())
        {
            error.emailVideContact = true;
        }
        else if(email.length()>50){
            error.emailTropLongContact = true;
        }
        else if(!emailMatch.matches())
        {
            error.emailIncorrecteContact = true;
        }

        String telRegexS = "^(([(]?(\\d{2,4})[)]?)|(\\d{2,4})|([+1-9]+\\d{1,2}))?[-\\s]?(\\d{2,3})?[-\\s]?((\\d{7,8})|(\\d{3,4}[-\\s]\\d{3,4}))$";

        boolean res = Pattern.matches(telRegexS, tel) ;
        if(tel.isEmpty())
        {
            error.telVideContact = true;
        }
        else if(tel.length()>15){
            error.telIncorrecteContact = true;
        }
        else if(!res)
        {
            error.telIncorrecteContact = true;
        }

        List<Contact> lC = Contact.find.where().eq("email",email).findList();
        if(!lC.isEmpty()){
            error.contactExiste = true;
        }

        if(error.hasErrorContact()){
            return badRequest(Json.toJson(error));
        }else{
            Contact c = new Contact(nom,prenom, email,tel);
            return ok(Json.toJson(c));
        }
    }

    public Result getClientsAsCSV() throws IOException {
        Logger.debug("Exporting clients...");
        final Map<String, String> filesToExport = Utils.exportAllClientsCSV();

        final List<File> filesToCompress = filesToExport.entrySet().stream()
                .map(entry -> Utils.fileFromString(entry.getValue(), entry.getKey().split("\\.")[0], "." + entry.getKey().split("\\.")[1]))
                .collect(Collectors.toList());

        final String filePrefix = "clients";
        final String fileSuffix = ".zip";

        final File zippedFile = File.createTempFile(filePrefix, fileSuffix);
        Utils.zipFile(filesToCompress, zippedFile);

        response().setContentType("application/x-download");
        response().setHeader("Content-disposition", "attachment; filename=" + filePrefix + fileSuffix);

        return ok(zippedFile);

        //return ok(Json.toJson(clients));
    }

    public Result modifierClient(Long idClient){
        JsonNode json = request().body().asJson();
        String nom = json.get("form").get("name").asText().trim();
        String adress = json.get("form").get("adress").asText().trim();
        String zip = json.get("form").get("zip").asText().trim();
        String ville = json.get("form").get("city").asText().trim();
        String pays = json.get("form").get("country").asText().trim();
        int priorite = json.get("priorite").asInt();

        Error error = checkCreationClient(nom,adress,zip,ville,pays);
        Client client = Client.find.byId(idClient);
        if(!client.nom.equals(nom)){
            if(!Client.find.where().eq("nom",nom).findList().isEmpty()){
                error.clientExiste = true;
            }
        }
        // Check si erreur ou pas au niveau du client
        //Client client = new Client(nomClient,priorite,false, adresse, listC, null);

        //List<Client> lClient = Client.getAll();
        //if(lClient.contains(client)){
        //  error.clientExiste = true;
        //}
        //Si adresse existe deja, pas de modification fait
        if(error.hasErrorClient()) {
            return badRequest(Json.toJson(error));
        }else {
            Adresse adresse = new Adresse(adress,zip,ville,pays);

            if(!client.adresseClient.equals(adresse)){
                //adresse is not the same
                client.adresseClient.adresse = adress;
                client.adresseClient.zipCode = zip;
                client.adresseClient.pays = pays;
                client.adresseClient.ville = ville;
                client.adresseClient.save();
            }
            if(!client.priorite.equals(priorite)){
                client.priorite = priorite;
            }
            // Ajout nouveau contact
            // parcours du json
            //System.out.println(json.get("table").elements());
            Iterator<JsonNode> elements = json.get("table").elements();
            List<Contact> listClient = new BeanList<>();
            while(elements.hasNext()){
                JsonNode contact = elements.next();
                Contact c = new Contact(contact.get("nom").asText(),contact.get("prenom").asText(), contact.get("email").asText(),contact.get("telephone").asText(), new BeanList<Tache>());
                c.save();
                listClient.add(c);
            }
            client.listeContacts.addAll(listClient);
            client.save();
            for(Contact c : listClient){
                c.client = client;
                c.save();
            }

            // mis de contact en archiver si il y a
            Iterator<JsonNode> archiverContact = json.get("contact").elements();
            while(archiverContact.hasNext()){
                JsonNode contactArchiver = archiverContact.next();
                Contact tmp = Contact.find.byId(contactArchiver.get("idContact").asLong());
                tmp.archive = true;
                tmp.save();
            }


            //mis a jour des projet archive
            Iterator<JsonNode> archiverProjet = json.get("projet").elements();
            while(archiverProjet.hasNext()){
                JsonNode projetArchiver = archiverProjet.next();
                Projet p = Projet.find.byId(projetArchiver.get("idProjet").asLong());
                p.archive = true;
                p.save();
            }
            client.save();
            return ok(Json.toJson(client));
        }

    }

}

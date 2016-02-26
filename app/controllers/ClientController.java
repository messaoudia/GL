package controllers;

import com.avaje.ebean.common.BeanList;
import com.fasterxml.jackson.databind.JsonNode;
import models.*;
import models.Error;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.client;
import views.html.creerClient;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static play.mvc.Results.ok;

/**
 * Created by Gishan on 03/01/2016.
 */
public class ClientController extends Controller {

    public Result afficherClients() {
        return ok(client.render("Clients"));
    }

    public Result afficherCreerClient() {
        return ok(creerClient.render("Créer Client"));
    }

    public Result creerClient()
    {
        JsonNode json = request().body().asJson();
        System.out.println("LAAAAAAAAAAAAAAAAAAAAAA"+json);
        Error error = new Error();
        String nomClient =  json.get("form").get("formCreerClientName").asText();
        String adresseClient =  json.get("form").get("formCreerClientAdress").asText();
        String codePostal =  json.get("form").get("formCreerClientZipCode").asText();
        String ville =  json.get("form").get("formCreerClientCity").asText();
        String pays =  json.get("form").get("formCreerClientCountry").asText();
        int priorite = json.get("priorite").asInt();

        Pattern nameRegex = Pattern.compile("^[A-Za-z ,.'-]{1,30}$");
        Matcher nameMatch = nameRegex.matcher(nomClient);

        //TODO : utiliser matche pour le nomClient
        if(nomClient.isEmpty()){
            error.nomClientVide = true;
        }else if(nomClient.length()>30){
            error.nomClientTropLong = true;
        }else if(!nameMatch.matches()) {
            error.nomIncorrect = true;
        }

        if(adresseClient.isEmpty()){
            error.adresseVide = true;
        }else if(adresseClient.length()>50){
            error.adresseTropLong = true;
        }

        if(codePostal.isEmpty()){
            error.codePostalVide = true;
        }else if(codePostal.length()>10){
            error.codePostaleTropLong = true;
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

        Adresse adresse = new Adresse(adresseClient,codePostal,ville,pays);
        List<Contact> listC = new BeanList<>();
        Client client = new Client(nomClient,priorite,false, adresse, listC, null);

        List<Client> lClient = Client.getAll();
        if(lClient.contains(client)){
            error.clientExiste = true;
        }
        if(error.hasErrorClient()) {
            System.out.println("ERREUUUUUURRRRR");
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
        String nom = map.get("formLastNameContactClient")[0];
        String prenom = map.get("formFirstNameContactClient")[0];
        String email =  map.get("formEmailContactClient")[0];
        String tel =  map.get("formTelContactClient")[0];

        Pattern nameRegex = Pattern.compile("^[A-Za-z ,.'-]{1,30}$");
        Matcher nameMatch = nameRegex.matcher(nom);
        Matcher prenomMatch = nameRegex.matcher(prenom);

        if(nom.isEmpty()){
            error.nomVideContact = true;
        }else if(nom.length()>15){
            error.nomTropLongContact = true;
        }else if(!nameMatch.matches()) {
            error.nomIncorrectContact = true;
        }

        if(prenom.isEmpty()){
            error.prenomVideContact = true;
        }else if(prenom.length()>15){
            error.prenomTropLongContact = true;
        }else if(!prenomMatch.matches()) {
            error.prenomIncorrectContact = true;
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
        //TODO : contact existe deja ?
        if(error.hasErrorContact()){
            return badRequest(Json.toJson(error));
        }else{
            Contact c = new Contact(nom,prenom, email,tel);
            return ok(Json.toJson(c));
        }
    }

}

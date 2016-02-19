package controllers;

import models.Client;
import play.Logger;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

/**
 * Created by Guillaume on 19/02/2016.
 */
public class ContactController extends Controller {

    public Result afficherContactsClient(long idClient) {
        Client client = Client.find.byId(idClient);
        Logger.debug("Contact Client ID : "+idClient);
        return ok(Json.toJson(models.Contact.find.where().eq("client",client).findList()));
    }
}

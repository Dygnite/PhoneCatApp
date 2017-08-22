package controllers;

import models.Phone;
import modules.LoadPhonesComponent;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

import javax.inject.Inject;

public class Application extends Controller {
    @Inject
    public Application(LoadPhonesComponent c) {
        // just to load phones to db on start
    }

    public Result phones() {
        return ok(Json.toJson(Phone.find.all())).as("application/json");
    }

    public Result phoneDetails(String phoneId) {
        Phone p = Phone.find.byId(phoneId);
        if (p != null) {
            return ok(Json.toJson(p.details)).as("application/json");
        } else {
            return notFound();
        }
    }
}

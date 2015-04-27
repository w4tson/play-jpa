package controllers;

import play.mvc.Result;
import views.html.index;
import views.html.swagger;

import static play.mvc.Results.ok;

/**
 * Created by paul on 27/04/15.
 */
public class Application {

    public static Result swagger() {
        return ok(swagger.render());
    }

    public static Result index() {
        return ok(index.render("Your new application is ready."));
    }

}

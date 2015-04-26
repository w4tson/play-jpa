package controllers;

import play.*;
import play.mvc.*;

import views.html.*;
import play.db.jpa.*;
import model.*;
import javax.persistence.*;
import java.util.List;
import play.libs.Json;
import com.fasterxml.jackson.databind.JsonNode;
import play.mvc.BodyParser;

public class Users extends Controller {

    public static Result index() {
        return ok(index.render("Your new application is ready."));
    }

	@Transactional
	@BodyParser.Of(BodyParser.Json.class)
    public static Result create() {
    	JsonNode json = request().body().asJson();
  		String name = json.findPath("name").textValue();

  		if(name == null) {
  		  return badRequest("Missing parameter [name]");
  		} else {
  		  return ok("Hello " + name);
  		}
    }    

    @Transactional
    public static Result getAll() {
    	TypedQuery<User> query = em().createQuery("SELECT u FROM User u", User.class);
    	List<User> users = query.getResultList();
    	return ok(Json.toJson(users));
    }

    @Transactional
    public static Result get(Integer id) {
    	User user = em().find(User.class, id);
    	return ok(Json.toJson(user));
    }

    public static EntityManager em() {
    	return JPA.em();
    }

}

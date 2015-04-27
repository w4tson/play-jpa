package controllers;

import com.wordnik.swagger.annotations.*;
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

@Api(value = "/users", description = "Operations with user")
public class Users extends Controller {



	@Transactional
	@ApiOperation(
		nickname = "create",
		value = "Create a new User",
		notes = "The id should not be supplied, this is generated.",
		httpMethod = "POST",
		response = model.User.class)
	@ApiResponse(code = 400, message = "Invalid user supplied")
	@ApiImplicitParams(value = {
		@ApiImplicitParam(
				value = "User object that is to be created",
				required = true,
				dataType = "model.User",
				paramType = "body")
	})
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

	@ApiOperation(
			nickname = "get_all",
			value = "Get all Users",
			notes = "Retrieves all the users, no paging involved.",
			httpMethod = "GET",
			response = model.User.class)
	@ApiResponse(code = 400, message = "Invalid username supplied")
	@Transactional
    public static Result getAll() {
    	TypedQuery<User> query = em().createQuery("SELECT u FROM User u", User.class);
    	List<User> users = query.getResultList();
    	return ok(Json.toJson(users));
    }

	@ApiOperation(
			nickname = "get_by_id",
			value = "Get a User",
			httpMethod = "GET",
			response = model.User.class)
	@ApiResponses(value = {
			@ApiResponse(code = 400, message = "Invalid user id supplied"),
			@ApiResponse(code = 404, message = "User not found") }
	)
    @Transactional
    public static Result get(@ApiParam(value = "The id of the user", required = true) Integer id) {
    	User user = em().find(User.class, id);
    	return ok(Json.toJson(user));
    }

    public static EntityManager em() {
    	return JPA.em();
    }

}

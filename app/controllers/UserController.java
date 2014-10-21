
package controllers;

import java.io.IOException;
import java.util.List;

import models.User;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import play.Logger;
import play.modules.guice.InjectSupport;
import play.mvc.Controller;
import service.UserService;

import com.google.inject.Inject;

@InjectSupport
public class UserController extends SecureController.Security{

	@Inject
	protected static UserService userService;
	
	public static List<User> getAllUsers(){
		List<User> users = userService.getAllUser();
		Logger.info("*****Success*****");
		return users;
	}
	
	public static List<User> getActiveUsers(){
		List<User> users = userService.getAllActiveUser();
		Logger.info("*****Success*****");
		return users;
	}
	
	public static void createUser(String body) throws JsonParseException, JsonMappingException, IOException{
		ObjectMapper mapper = new ObjectMapper();
		User user = new User();
		user = mapper.readValue(body, User.class);
		userService.createUser(user);
		Logger.info("*****Success*****");
		//TODO add response for frontend, some feedback
	}
	
	public static void disableUser(String body) throws JsonParseException, JsonMappingException, IOException{
		User user = new ObjectMapper().readValue(body, User.class);
		userService.disableUser(user.id);
		Logger.info("*****Success*****");
		//TODO add some response for frontend
	}
	
	public static void updateUser(String body) throws JsonParseException, JsonMappingException, IOException{
		User user = new ObjectMapper().readValue(body, User.class);
		userService.updateUser(user);
		Logger.info("*****Success*****");
		//TODO add some response for frontend
	}
	
	public static void login() {
		render("Authentification/login.html");
	}

	/**
	 * Renders page for registration
	 */
	public static void showRegister() {
//		render("Authentification/register.html");
	}

	/**
	 * Checks if user exists
	 * 
	 * @param username
	 * @param password
	 * @return
	 */
	static boolean authenticate(String username, String password) {
		User u = userService.loginUser(username, password);
		if (u != null) {
			Logger.debug(u.username + " logged in!");
			return true;
		} else {
			return false;
		}
	}

}

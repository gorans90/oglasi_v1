package controllers;

import java.util.List;

import models.Ads;
import models.Category;
import models.Images;
import models.Subcategory;
import models.User;
import play.modules.guice.InjectSupport;
import play.mvc.Controller;
import service.UserService;
import service.impl.UserServiceImpl;

import com.google.inject.Inject;

@InjectSupport
public class Application extends Controller {

	@Inject
	protected static UserService userService;
	
	
    public static void index() {
    	List<User> users = userService.getAllActiveUser();
    	render("/Application/test.html", users);
    }

}
package controllers;

import models.Ads;
import models.Category;
import models.Images;
import models.Subcategory;
import models.User;
import play.mvc.Controller;

public class Application extends Controller {

    public static void index() {
    	User u = new User();
    	u.username = "gorans";
    	u.save();
    	
    	Category c = new Category();
    	Subcategory s = new Subcategory();
    	Ads a = new Ads();
    	Images i = new Images();
    	
        renderText("Successfuly created user: "+u.username);
    }

}
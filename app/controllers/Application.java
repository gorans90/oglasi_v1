package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.*;

public class Application extends Controller {

    public static void index() {
    	User u = new User();
    	u.username = "gorans";
    	u.save();
    	
        renderText("Successfuly created user: "+u.username);
    }

}
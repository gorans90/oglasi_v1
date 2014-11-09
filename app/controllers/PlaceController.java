package controllers;

import java.io.IOException;
import java.text.ParseException;

import models.Place;
import models.resource.AdsResource;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.google.inject.Inject;

import play.Logger;
import play.modules.guice.InjectSupport;
import play.mvc.Controller;
import service.PlaceService;

@InjectSupport
public class PlaceController extends Controller {

	@Inject
	protected static PlaceService placeService;
	
	public static void createPlace(String body) throws JsonParseException, JsonMappingException, IOException, ParseException{
		Place p = new ObjectMapper().readValue(body, Place.class);
		placeService.createPlace(p);
		Logger.info("*****SUCCESS***** Place created");
	}
	
	public static void updatePlace(String body) throws JsonParseException, JsonMappingException, IOException{
		Place p = new ObjectMapper().readValue(body, Place.class);
		placeService.updatePlace(p);
		Logger.info("*****SUCCESS***** Place updated");
	}
}

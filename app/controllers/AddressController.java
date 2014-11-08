package controllers;

import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.google.inject.Inject;

import play.Logger;
import play.modules.guice.InjectSupport;
import play.mvc.Controller;
import play.mvc.results.RenderText;
import service.AddressService;
import models.Address;

@InjectSupport
public class AddressController extends Controller {

	@Inject
	protected static AddressService addressService;
	
	public static void createAddress(String body) throws JsonParseException, JsonMappingException, IOException{
		Address address = new ObjectMapper().readValue(body, Address.class);
		addressService.createAddress(address);
		Logger.info("*****SUCCESS***** Address created");
	}
	
	public static void updateAddress(String body) throws JsonParseException, JsonMappingException, IOException{
		Address a = new ObjectMapper().readValue(body, Address.class);
		addressService.updateAddress(a);
		Logger.info("*****SUCCESS***** Address updated");
	}
	
	public static void getByUserId(long userId){
		Address a = addressService.getAdressByUserId(userId);
		renderText(a.streetName +" "+ a.houseNumber);
	}
	
	
	
}

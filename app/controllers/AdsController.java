package controllers;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import models.Ads;
import models.resource.AdsResource;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import play.Logger;
import play.modules.guice.InjectSupport;
import play.mvc.Controller;
import service.AdsService;

import com.google.inject.Inject;

@InjectSupport
public class AdsController extends Controller{
	
	@Inject
	protected static AdsService adsService;
	
	public static void createAd(String body) throws JsonParseException, JsonMappingException, IOException, ParseException{
		AdsResource adResource = new ObjectMapper().readValue(body, AdsResource.class);
		adsService.createAds(adResource);
		Logger.info("*****SUCCESS*****");
	}
	
	public static void disableAd(String body) throws JsonParseException, JsonMappingException, IOException{
		Ads ad= new ObjectMapper().readValue(body, Ads.class);
		adsService.disableAds(ad.id);
		Logger.info("*****SUCCESS*****");
	}
	
	public static void updateAd(String body) throws JsonParseException, JsonMappingException, IOException{
		AdsResource ad = new ObjectMapper().readValue(body, AdsResource.class);
		adsService.updateAds(ad);
		Logger.info("*****SUCCESS*****");
	}
	
	public static void getById(Long id) throws JsonParseException, JsonMappingException, IOException{
		Ads ads = adsService.getAdById(id);
		renderText(ads.name);
	}
	
	public static void getAllAds(){
		List<Ads> ads = adsService.getAllAds();
		renderText(ads.size());
	}
	
	public static void getByCategory(Long id){
		List<Ads> ads = adsService.getAllAdsByCategory(id);
		renderText(ads.size());
	}
	
	public static void getBySubCategory(Long id){
		List<Ads> ads = adsService.getAllAdsBySubCategory(id);
		renderText(ads.size());
	}
}

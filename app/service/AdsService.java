package service;

import java.text.ParseException;
import java.util.List;

import models.Ads;
import models.Category;
import models.Subcategory;
import models.resource.AdsResource;

public interface AdsService {

	public Ads createAds(AdsResource adsResource) throws ParseException;
	
	public void disableAds(long id);
	
	public Ads updateAds(AdsResource ads);

	public Ads getAdById(long id);
	
	public List<Ads> getAllAds();
	
	public List<Ads> getAllAdsByCategory(long id);
	
	public List<Ads> getAllAdsBySubCategory(long id);
	
}

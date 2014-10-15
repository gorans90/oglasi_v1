package service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import models.Ads;
import models.Category;
import models.Subcategory;
import models.User;
import models.resource.AdsResource;
import play.Logger;
import service.AdsService;

public class AdsServiceImpl implements AdsService{

	@Override
	public Ads createAds(AdsResource adsResource) throws ParseException {
		Ads ads = new Ads();
		
		String stringDate = adsResource.dateCreated;
		Date date = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH).parse(stringDate);

		
		ads.name = adsResource.name;
		ads.description = adsResource.description;
		ads.category = Category.findById(adsResource.category_id);
		ads.subcategory = Subcategory.findById(adsResource.subcategory_id);
		ads.createdBy = User.findById(adsResource.user_id);
		ads.active = adsResource.active;
		ads.images = adsResource.images;
		ads.dateCreated = date;
		
		ads.save();
		
		return ads;
	}

	@Override
	public void disableAds(long id) {
		Ads ads = Ads.findById(id);
		ads.active = false;
		ads.save();
		Logger.info("Successfully disabled ad!");
	}

	@Override
	public Ads updateAds(AdsResource ads) {
		Ads a = Ads.findById(ads.id);
		
		a.name = ads.name;
		a.description = ads.description;
		a.category = Category.findById(ads.category_id);
		a.subcategory = Category.findById(ads.subcategory_id);
		a.images = ads.images;
		
		a.save();
		
		Logger.info("Successfully updated ad!");
		return a;
	}

	@Override
	public Ads getAdById(long id) {
		Ads ad = Ads.findById(id);
		return ad;
	}

	@Override
	public List<Ads> getAllAds() {
		List<Ads> ads = Ads.findAll();
		return ads;
	}

	@Override
	public List<Ads> getAllAdsByCategory(long id) {
		List<Ads> ads = Ads.find("category_id = ?", id).fetch();
		return ads;
	}

	@Override
	public List<Ads> getAllAdsBySubCategory(long id) {
		List<Ads> ads= Ads.find("subcategory_id = ?", id).fetch();
		return ads;
	}

}

package models;

import javax.persistence.Entity;

import play.data.validation.Required;

@Entity
public class Address extends BaseModelImpl {
	
	@Required
	public String streetName;
	
	@Required
	public String houseNumber;
	
	public Place place;
	
	@Required
	public long userId;
	
	public double longitude;
	
	public double latitude;
	
	
	
}

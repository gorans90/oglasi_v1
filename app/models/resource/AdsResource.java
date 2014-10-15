package models.resource;

import java.util.Date;
import java.util.List;

import models.Images;

public class AdsResource {
	
	public long id;
	public String name;
	public String description;
	public long category_id;
	public long subcategory_id;
	public String dateCreated;
	public List<Images> images;
	public boolean active;
	public long user_id;

}

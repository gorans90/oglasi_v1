package models;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import play.data.validation.Required;

@Entity
public class Subcategory extends BaseModelImpl{

	@Required
	public String name;
	
	public String decription;
	
	@ManyToOne
	public Category category;
}

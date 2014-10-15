package models;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import play.data.validation.Required;

@Entity
public class Ads extends BaseModelImpl{
	
	@Required
	public String name;
	
	public String description;
	
	@Required
	@OneToOne
	public Category category;
	
	@Required
	@OneToOne
	public Subcategory subcategory;
	
	public Date dateCreated;
	
	@Required
	@OneToMany(mappedBy="ads", cascade = CascadeType.ALL)
	public List<Images> images;
	
	@OneToOne
	public User createdBy;
	
	public boolean active;
	
	
}

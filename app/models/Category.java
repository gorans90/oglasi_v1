package models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import play.data.validation.Required;

@Entity
public class Category extends BaseModelImpl{

	@Required
	public String name;
	
	public String decription;
	
	@OneToMany(mappedBy = "category", cascade = CascadeType.ALL, orphanRemoval = true)
	public List<Subcategory> subcategory;
}

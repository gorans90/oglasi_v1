package models;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

import play.data.validation.Required;

@Entity
public class Images extends BaseModelImpl{

	@Required
	public String pathToImg;
	
	@Required
	@OneToOne
	public Ads ads;
}

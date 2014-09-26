package models;

import javax.persistence.Entity;

import play.data.validation.Required;

@Entity
public class User extends BaseModelImpl{
	
	@Required
	public String username;
}

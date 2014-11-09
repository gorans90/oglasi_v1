package models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import play.data.validation.Required;

@Entity
public class Messages extends BaseModelImpl{
	
	@Required
	public String title;
	
	@Required
	public String messageBody;
	
	@ManyToOne
	public User from;
	
	@ManyToOne
	public User to;
	
	public Date date;
	
	public long inboxid;
}

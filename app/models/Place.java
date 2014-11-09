package models;

import play.data.validation.Required;

public class Place extends BaseModelImpl {

	@Required
	public long ptt;
	@Required
	public String name;
	
}

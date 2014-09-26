package models;

import play.db.jpa.Model;

public class BaseModelImpl extends Model implements BaseModel {
	@Override
	public boolean equals(Object other){
		if(other == null){
			return false;
		}else if(!(other instanceof BaseModelImpl)){
			return false;
		}else{
			return this.id.equals(((BaseModelImpl) other).id);
		}
	}
}

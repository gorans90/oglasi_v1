package models;

import java.util.Date;

import javax.persistence.Entity;

import play.data.validation.Required;
import play.libs.Crypto;

@Entity
public class User extends BaseModelImpl{
	
	@Required
	public String username;
	
	@Required
	public String password;
	
	@Required
	public String name;
	
	@Required
	public String surname;
	
	@Required
	public String mail;
	
	public String address;
	
	public String city;
	
	public String number;
	
	public Date dateOfBirth;
	
	public String profilePicture;
	
	public void setPassword(String password) {
		this.password = Crypto.encryptAES(password);
	}

	public String getPassword() {
		return Crypto.decryptAES(password);
	}
}

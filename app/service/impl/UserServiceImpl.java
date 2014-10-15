package service.impl;

import java.util.Date;
import java.util.List;

import models.User;
import service.UserService;

public class UserServiceImpl implements UserService{

	@Override
	public List<User> getAllUser() {
		List<User> users = User.findAll();
		return users;
	}
	
	@Override
	public List<User> getAllActiveUser() {
		List<User> users = User.find("active = ?", true).fetch();
		return users;
	}

	@Override
	public User createUser(User user) {
		User u = new User();
		
		u = user;
		u.save();
		
		return u;
	}

	@Override
	public void disableUser(Long id) {
		User user = User.findById(id);
		//we just want to disable user, we don't want to delete user from database
		user.active = false;
		user.save();
	}

	@Override
	public void updateUser(User user) {
		User u = User.findById(user.id);
		
		//Updating values
		u.username = user.username;
		u.password = user.password;
		u.name = user.name;
		u.surname = user.surname;
		u.mail = user.mail;
		u.address = user.address;
		u.city = user.city;
		u.number = user.number;
		u.dateOfBirth = user.dateOfBirth;
		u.profilePicture = user.profilePicture;
		
		u.save();
	}

	
	

}

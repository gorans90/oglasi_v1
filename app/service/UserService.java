package service;

import java.util.Date;
import java.util.List;

import models.User;

public interface UserService {
	
	public List<User> getAllUser();
	
	public List<User> getAllActiveUser();
	
	public User createUser(User user);
	
	public void disableUser(Long id);
	
	public void updateUser(User user);
}

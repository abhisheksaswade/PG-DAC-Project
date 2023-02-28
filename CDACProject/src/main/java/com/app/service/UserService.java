package com.app.service;

import java.util.List;
import java.util.Optional;

import com.app.entities.User;

public interface UserService {
	
	public List<User> getAllUserDetails();
	
	public Optional<User> getUserDetails(Long userId);
	
	public User addUserDetails(User transientUser);
	
	public User updateUserDetails(User detachedUser);
	
	public String deleteUserDetails(Long userId);

}//End of UserService

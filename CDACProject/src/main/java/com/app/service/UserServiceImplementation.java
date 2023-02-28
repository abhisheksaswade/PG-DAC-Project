package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.entities.User;
import com.app.repository.UserDao;


@Service
@Transactional
public class UserServiceImplementation implements UserService {

	
//*********************dependency injection****************************************************************************	
	@Autowired
	private UserDao userRepo;
	
	
	
//*********************method implementation****************************************************************************	
	@Override
	public List<User> getAllUserDetails() {
		return userRepo.findAll();
	}
	
	
	@Override
	public User addUserDetails(User transientUser) {
		return userRepo.save(transientUser);
	}


	@Override
	public Optional<User> getUserDetails(Long userId) {
		return userRepo.findById(userId);
	}


	@Override
	public User updateUserDetails(User detachedUser) {
		return userRepo.save(detachedUser);
	}


	@Override
	public String deleteUserDetails(Long userId) {
		
		if(userRepo.existsById(userId))
		{
			userRepo.deleteById(userId);
			return "User Sucessfully Deleted......";
		}

		return "User Deletion Failed......";
	}



}//End of UserServiceImplementation

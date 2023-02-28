package com.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entities.User;
import com.app.service.UserService;



@RestController
@RequestMapping("/user")
public class UserController {

	
//*********************dependency injection****************************************************************************		
	@Autowired
	private UserService userService;
	

//*********************method implementation****************************************************************************	
	@GetMapping
	public List<User> getAllUsers()
	{
		return userService.getAllUserDetails();
	}
	
	@GetMapping("/{userId}")
	public Optional<User> getUser(@PathVariable Long userId)
	{
		return userService.getUserDetails(userId);
	}
	
	@PostMapping
	public User addUser(@RequestBody User transientUser)
	{
		return userService.addUserDetails(transientUser);
	}
	
	@PutMapping
	public User updateUser(@RequestBody User detachedUser)
	{
		return userService.updateUserDetails(detachedUser);
	}
	
	@DeleteMapping("/{userId}")
	public String deleteUser(@PathVariable Long userId)
	{
		return userService.deleteUserDetails(userId);
	}

	
}//End of User

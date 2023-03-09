package com.app.controller;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entities.Category;
import com.app.entities.User;
import com.app.service.CategoryService;
import com.app.service.UserService;



@RestController
@RequestMapping("/user")
@Transactional
@CrossOrigin("http://localhost:3000/")
public class UserController {

	
//*********************dependency injection****************************************************************************		
	@Autowired
	private UserService userService;
	
	@Autowired
	private CategoryService categoryService;
	
	
//*********************method implementation****************************************************************************

//---------------------Standard method implementation-----------------------------------------------	
	
	//GET
	@GetMapping
	public List<User> getAllUsers()
	{
		return userService.getAllUserDetails();
	}
	
	
	//GET BY ID
	@GetMapping("/{userId}")
	public Optional<User> getUser(@PathVariable Long userId)
	{
		return userService.getUserDetails(userId);
	}
	
	//INSERT
	@PostMapping
	public User addUser(@RequestBody User transientUser)
	{
		return userService.addUserDetails(transientUser);
	}
	
	//UPDATE
	@PutMapping
	public User updateUser(@RequestBody User detachedUser)
	{
		return userService.updateUserDetails(detachedUser);
	}
	
	
	//DELETE
	@DeleteMapping("/{userId}")
	public String deleteUser(@PathVariable Long userId)
	{
		return userService.deleteUserDetails(userId);
	}
	
	
//---------------------Custom method implementation for Administrator-----------------------------------------------
	
	//to get user list by roles
	@GetMapping("/admin/{role}")
	public List<User> getAllUsersByRole(@PathVariable String role)
	{
		return userService.getAllUserDetailsByRole(role);
	}
		
	//to get category list by userId
	@GetMapping("/admin/categoryList/{userId}")
	public List<Category> getCategoryListByUserId(@PathVariable Long userId)
	{
		return userService.getCategoryListByUserId(userId);
	}
	
	
	//to Add category by userID
	@PostMapping("/admin/addcatgory/{userId}")
	public String addCategoryBinding(@PathVariable Long userId, @RequestBody Category transientAddCategory)
	{
		return userService.addCategoryByUserIdAndCategory(userId, transientAddCategory);
	}

	
	//to Delete category by userID
	@DeleteMapping("/admin/deletecatgory/{userId}")
	public String deleteCategoryBinding(@PathVariable Long userId, @RequestBody Category transientDeleteCategory)
	{
		return userService.deleteCategoryByUserIdAndCategory(userId, transientDeleteCategory);
	}


	
}//End of User

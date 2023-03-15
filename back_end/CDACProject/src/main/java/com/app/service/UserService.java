package com.app.service;

import java.util.List;
import java.util.Optional;

import com.app.entities.Category;
import com.app.entities.Role;
import com.app.entities.User;

public interface UserService {
//*********************method implementation****************************************************************************

	
//---------------------Standard method declaration-----------------------------------------------
	
	//GET ALL
	public List<User> getAllUserDetails();
	
	//GET BY ID
	public Optional<User> getUserDetails(Long userId);
	
	//INSERT
	public User addUserDetails(User transientUser);
	
	//UPDATE
	public User updateUserDetails(User detachedUser);
	
	//DELETE
	public String deleteUserDetails(Long userId);
	
	
//---------------------Custom method declaration for Administrator-------------------------------
	
	//to get user list by roles
	public List<User> getAllUserDetailsByRole(String role);
	
	//to get category list by userId
	public List<Category> getCategoryListByUserId(Long userId);
	
	//to Add category by userID
	public String addCategoryByUserIdAndCategory(Long userId, Category transientAddCategory);
	
	//to Delete category by userID
	public String deleteCategoryByUserIdAndCategory(Long userId, Category transientDeleteCategory);
	
	public Optional<User> getUser (String email);
	
	
	
}//End of UserService

package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.entities.Category;
import com.app.entities.Role;
import com.app.entities.User;
import com.app.repository.CategoryDao;
import com.app.repository.UserDao;


@Service
@Transactional
public class UserServiceImplementation implements UserService {

	
//*********************dependency injection****************************************************************************	
	@Autowired
	private UserDao userRepo;
	
	@Autowired
	private CategoryDao categoryRepo;
	
	@Autowired
	private PasswordEncoder enc;


//*********************method implementation****************************************************************************
	
//---------------------Standard method implementation-----------------------------------------------
	//GET ALL
	@Override
	public List<User> getAllUserDetails() {
		return userRepo.findAll();
	}
	
	
	//GET BY ID
	@Override
	public Optional<User> getUserDetails(Long userId) {
		return userRepo.findById(userId);
	}

	
	//INSERT
	@Override
	public User addUserDetails(User transientUser) {
		//encrypt the pwd
		transientUser.setPassword(enc.encode(transientUser.getPassword()));
		return userRepo.save(transientUser);
	}

	//UPDATE
	@Override
	public User updateUserDetails(User detachedUser) {
		return userRepo.save(detachedUser);
	}
	
	//DELETE
	@Override
	public String deleteUserDetails(Long userId) {
		
		if(userRepo.existsById(userId))
		{
			userRepo.deleteById(userId);
			return "User Sucessfully Deleted......";
		}

		return "User Deletion Failed......";
	}

	
//---------------------Custom method implementation-----------------------------------------------
	
	//to get user list by roles
	@Override
	public List<User> getAllUserDetailsByRole(String role) {
		Role enumRole= Role.valueOf(role); 
		return userRepo.findByRole(enumRole);
	}


	//to get category list by userId
	@Override
	public List<Category> getCategoryListByUserId(Long userId) {
		
		//getting persistent User from database by Id
		Optional<User> persistentUser= userRepo.findById(userId);
	
		//getting categoryList from persistentUser
		List<Category> categoryList= persistentUser.get().getCategoryList();
		
		//to handle lazy initialization error: just firing a query on CategoryList
		categoryList.isEmpty();
		
		//returning the categoryList for persistentUser
		return categoryList;
	}
	
	
	//to Add category by userID	
	@Override
	public String addCategoryByUserIdAndCategory(Long userId, Category transientAddCategory) {
		
		//getting persistent User & Category from database by Id
		Optional<User> persistentUser= userRepo.findById(userId);
		Optional<Category> persistentCategory= categoryRepo.findById(transientAddCategory.getId());

		
		//to handle lazy initialization error
		String firstName= persistentUser.get().getFirstName();
		String categoryName=persistentCategory.get().getCategoryName();
		
		
		//User side binding
		List<Category> categoryList= persistentUser.get().getCategoryList();
		categoryList.add(persistentCategory.get());
		userRepo.save(persistentUser.get());
		
		//Category side binding
		List<User> userList=persistentCategory.get().getUserList();
		userList.add(persistentUser.get());
		categoryRepo.save(persistentCategory.get());
		
		return "Category added successfully....!";
	}


	//to Delete category by userID		
	@Override
	public String deleteCategoryByUserIdAndCategory(Long userId, Category transientDeleteCategory) {
		
		//getting persistent User & Category from database by Id
		Optional<User> persistentUser= userRepo.findById(userId);
		Optional<Category> persistentCategory= categoryRepo.findById(transientDeleteCategory.getId());

		
		//to handle lazy initialization error
		String firstName= persistentUser.get().getFirstName();
		String categoryName=persistentCategory.get().getCategoryName();
		
		
		//User side un-binding
		List<Category> categoryList= persistentUser.get().getCategoryList();
		categoryList.remove(persistentCategory.get());
		userRepo.save(persistentUser.get());
		
		//Category side un-binding
		List<User> userList=persistentCategory.get().getUserList();
		userList.remove(persistentUser.get());
		categoryRepo.save(persistentCategory.get());
		
		return "Category Deleted Succesfully....!";
	}


	@Override
	public Optional<User> getUser(String email) {
		
		return userRepo.findByEmail(email);
	}

	
	
}//End of UserServiceImplementation

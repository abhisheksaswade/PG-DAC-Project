package com.app.service;

import java.util.List;
import java.util.Optional;

import com.app.entities.Category;

public interface CategoryService {
	

//********************* standard method declaration*****************************************************************
	//GET ALL
	public List<Category> getAllCategoryDetails();
	
	//GET BY ID
	public Optional<Category> getCategoryDetails(Long categoryId);
	
	//INSERT
	public Category addCategoryDetails(Category transientCategory);
	
	//UPDATE
	public Category updateCategoryDetails(Category detachedCategory);
	
	//DELETE
	public String deleteCategoryDetails(Long categoryId);
	
	
}//End of CategoryService

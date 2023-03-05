package com.app.service;

import java.util.List;
import java.util.Optional;

import com.app.entities.Category;

public interface CategoryService {
	
	public List<Category> getAllCategoryDetails();
	
	public Optional<Category> getCategoryDetails(Long categoryId);
	
	public Category addCategoryDetails(Category transientCategory);
	
	public Category updateCategoryDetails(Category detachedCategory);
	
	public String deleteCategoryDetails(Long categoryId);

}//End of CategoryService

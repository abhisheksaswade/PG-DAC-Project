package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.entities.Category;
import com.app.repository.CategoryDao;

@Service
@Transactional
public class CategoryServiceImplementation implements CategoryService {

	
//*********************dependency injection****************************************************************************		
	@Autowired
	private CategoryDao categoryRepo;

	
//********************* standard method implementation*****************************************************************
	
	//GET ALL
	@Override
	public List<Category> getAllCategoryDetails() {
		return categoryRepo.findAll();
	}
	
	
	//GET BY ID
	@Override
	public Optional<Category> getCategoryDetails(Long categoryId) {
		return categoryRepo.findById(categoryId);
	}

	
	//INSERT
	@Override
	public Category addCategoryDetails(Category transientCategory) {
		return categoryRepo.save(transientCategory);
	}

	
	//UPDATE
	@Override
	public Category updateCategoryDetails(Category detachedCategory) {
		return categoryRepo.save(detachedCategory);
	}

	
	//DELETE
	@Override
	public String deleteCategoryDetails(Long categoryId) {
		if(categoryRepo.existsById(categoryId))
		{
			categoryRepo.deleteById(categoryId);
			return "Category Sucessfully Deleted......";
		}

		return "Category Deletion Failed......";
	}
	
	
}//End of CategoryServiceImplementation

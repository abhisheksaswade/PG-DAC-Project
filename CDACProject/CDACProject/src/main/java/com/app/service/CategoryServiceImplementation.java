package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.entities.Category;
import com.app.entities.User;
import com.app.repository.CategoryDao;

@Service
@Transactional
public class CategoryServiceImplementation implements CategoryService {

	
//*********************dependency injection****************************************************************************		
	@Autowired
	private CategoryDao categoryRepo;

	
//*********************method implementation****************************************************************************	
	@Override
	public List<Category> getAllCategoryDetails() {
		return categoryRepo.findAll();
	}
	

	@Override
	public Optional<Category> getCategoryDetails(Long categoryId) {
		return categoryRepo.findById(categoryId);
	}

	@Override
	public Category addCategoryDetails(Category transientCategory) {
		return categoryRepo.save(transientCategory);
	}

	@Override
	public Category updateCategoryDetails(Category detachedCategory) {
		return categoryRepo.save(detachedCategory);
	}

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

package com.app.controller;

import java.util.List;
import java.util.Optional;

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

@RestController
@RequestMapping("/category")
@CrossOrigin("http://localhost:3000/")
public class CategoryController {
	
	
//*********************dependency injection****************************************************************************
	@Autowired
	private CategoryService categoryService;

	
//*********************method implementation****************************************************************************
	
	//GET
	@GetMapping
	public List<Category> getAllCategories()
	{
		return categoryService.getAllCategoryDetails();
	}
	
	//GET BY ID
	@GetMapping("/{categoryId}")
	public Optional<Category> getCategory(@PathVariable Long categoryId)
	{
		return categoryService.getCategoryDetails(categoryId);
	}
	
	//INSERT
	@PostMapping
	public Category addCategory(@RequestBody Category transientCategory)
	{
		return categoryService.addCategoryDetails(transientCategory);
	}
	
	//UPDATE
	@PutMapping
	public Category updateCategory(@RequestBody Category detachedCategory)
	{
		return categoryService.updateCategoryDetails(detachedCategory);
	}
	
	//DELETE
	@DeleteMapping("/{categoryId}")
	public String deleteUser(@PathVariable Long categoryId)
	{
		return categoryService.deleteCategoryDetails(categoryId);
	}

	
}//End of CategoryController

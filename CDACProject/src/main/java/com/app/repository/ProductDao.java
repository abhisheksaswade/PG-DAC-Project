package com.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Category;
import com.app.entities.Product;

public interface ProductDao extends JpaRepository<Product, Long> {

	
//---------------------Custom method for Customer-----------------------------------------------	
	//to get product by part number
	public Product findByPartNumber(int partNumber);

	//to get product by product name
	public List<Product> findByProductName(String productName);
	
	//to get product list by category name
	public List<Product> findByProductCategory(Category category);
	
	
}//End of ProductDao

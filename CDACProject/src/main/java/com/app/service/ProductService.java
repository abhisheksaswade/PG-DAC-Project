package com.app.service;

import java.util.List;
import java.util.Optional;

import com.app.entities.Product;

public interface ProductService {

	public List<Product> getAllProductDetails();
	
	public Optional<Product> getProductDetails(Long productId);
	
	public Product addProductDetails(Product transientProduct);
	
	public Product updateProductDetails(Product detachedProduct);
	
	public String deleteProductDetails(Long productId);
	
}//End of ProductService

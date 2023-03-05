package com.app.service;

import java.util.List;
import java.util.Optional;

import com.app.entities.Category;
import com.app.entities.Product;
import com.app.entities.Vehicle;

public interface ProductService {

	public List<Product> getAllProductDetails();
	
	public Optional<Product> getProductDetails(Long productId);
	
	public Product addProductDetails(Product transientProduct);
	
	public Product updateProductDetails(Product detachedProduct);
	
	public String deleteProductDetails(Long productId);
	
	//---------------------Custom method declaration for Administrator-----------------------------------------------
	
	//to get vehicle list by productId
	public List<Vehicle> getVehicleListByProductId(Long productId);
	
	//to Add vehicle by productID
	public String addVehicleByProductIdAndVehicle(Long productId, Vehicle transientAddVehicle);
	
	//to Delete vehicle by productID
	public String deleteVehicleByProductIdAndVehicle(Long productId, Vehicle transientDeleteVehicle);
	
}//End of ProductService

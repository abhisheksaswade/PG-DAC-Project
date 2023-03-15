package com.app.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
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
import com.app.entities.Product;
import com.app.entities.Vehicle;
import com.app.service.ProductService;

@RestController
@RequestMapping("/products")
@CrossOrigin("http://localhost:3000/")
public class ProductController {
	

//*********************dependency injection****************************************************************************	
	@Autowired
	private ProductService productService;

	
//*********************method implementation****************************************************************************	
	
	//GET
	@GetMapping("/view")
	public List<Product> getAllProducts()
	{
		return productService.getAllProductDetails();
	}
	
	
	@GetMapping("/purchase")
	public String purchaseProducts(Authentication auth) {
		System.out.println(auth);
		StringBuilder sb = new StringBuilder("Hello , ");
		sb.append(auth.getName()).append("  you are logged in under ").append(auth.getAuthorities())
				.append(" Proceed to purchasing of products ...");
		return sb.toString();
	}
	
	
	//GET BY ID
	@GetMapping("/{productId}")
	public Optional<Product> getProduct(@PathVariable Long productId)
	{
		return productService.getProductDetails(productId);
	}
	
	
	//INSERT
	@PostMapping
	public Product addProduct(@RequestBody Product transientProduct)
	{
		return productService.addProductDetails(transientProduct);
	}
	
	
	//UPDATE
	@PutMapping
	public Product updateProduct(@RequestBody Product detachedProduct)
	{
		return productService.updateProductDetails(detachedProduct);
	}
	
	
	//DELETE
	@DeleteMapping("/{productId}")
	public String deleteProduct(@PathVariable Long productId)
	{
		return productService.deleteProductDetails(productId);
	}
	
	
//---------------------Custom method implementation for Administrator-----------------------------------------------
	//to get vehicle list by userId
	@GetMapping("/admin/vehicleList/{productId}")
	public List<Vehicle> getVehicleListByUserId(@PathVariable Long productId)
	{
		return productService.getVehicleListByProductId(productId);
	}
	
	
	//to Add vehicle by productID
	@PostMapping("/admin/addvehicle/{productId}")
	public String addVehicleBinding(@PathVariable Long productId, @RequestBody Vehicle transientAddVehicle)
	{
		return productService.addVehicleByProductIdAndVehicle(productId, transientAddVehicle);
	}

	
	//to Delete vehicle by productID
	@DeleteMapping("/admin/deletevehicle/{productId}")
	public String deleteVehicleBinding(@PathVariable Long productId, @RequestBody Vehicle transientDeleteVehicle)
	{
		return productService.deleteVehicleByProductIdAndVehicle(productId, transientDeleteVehicle);
	}
	

//---------------------Custom method implementation for Customer-----------------------------------------------	
	//to get product by part number
	@GetMapping("/Product/{partNumber}")
	public Product findByPartNumber(@PathVariable int partNumber) 
	{
		return productService.findByPartNumber(partNumber);
		
	}

	//to get Product by product name
	@GetMapping("/productlist")
	public List<Product> findByProductName(String productName)
	{
		return productService.findByProductName(productName);
		
	}
	
	//find by category name
	@GetMapping("/category")
	public List<Product> findByCategoryName(@RequestBody Category category){
		return productService.findByCategoryName(category);
	}
	
	
}//End of ProductController

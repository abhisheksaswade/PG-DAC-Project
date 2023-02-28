package com.app.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entities.Product;
import com.app.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
	

//*********************dependency injection****************************************************************************	
	@Autowired
	private ProductService productService;

	
//*********************method implementation****************************************************************************	
	@GetMapping
	public List<Product> getAllProducts()
	{
		return productService.getAllProductDetails();
	}
	
	@GetMapping("/{productId}")
	public Optional<Product> getProduct(@PathVariable Long productId)
	{
		return productService.getProductDetails(productId);
	}
	
	@PostMapping
	public Product addProduct(@RequestBody Product transientProduct)
	{
		return productService.addProductDetails(transientProduct);
	}
	
	@PutMapping
	public Product updateProduct(@RequestBody Product detachedProduct)
	{
		return productService.updateProductDetails(detachedProduct);
	}
	
	@DeleteMapping("/{productId}")
	public String deleteProduct(@PathVariable Long productId)
	{
		return productService.deleteProductDetails(productId);
	}
	
	
}//End of ProductController

package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.entities.Product;
import com.app.repository.ProductDao;

@Service
@Transactional
public class ProductServiceImplementation implements ProductService {

	
//*********************dependency injection****************************************************************************
	@Autowired
	private ProductDao productRepo;

	
//*********************method implementation****************************************************************************	
	@Override
	public List<Product> getAllProductDetails() {
		return productRepo.findAll();
	}

	@Override
	public Optional<Product> getProductDetails(Long productId) {
		return productRepo.findById(productId);
	}

	@Override
	public Product addProductDetails(Product transientProduct) {
		return productRepo.save(transientProduct);
	}

	@Override
	public Product updateProductDetails(Product detachedProduct) {
		return productRepo.save(detachedProduct);
	}

	@Override
	public String deleteProductDetails(Long productId) {
		
		if(productRepo.existsById(productId))
		{
			productRepo.deleteById(productId);
			return "Product Sucessfully Deleted......";
		}

		return "Product Deletion Failed......";
	}
	
	
}//End of ProductService

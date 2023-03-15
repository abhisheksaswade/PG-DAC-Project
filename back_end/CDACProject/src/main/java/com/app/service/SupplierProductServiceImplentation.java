package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.entities.Category;
import com.app.entities.Product;
import com.app.entities.SupplierProducts;
import com.app.entities.User;
import com.app.repository.CategoryDao;
import com.app.repository.ProductDao;
import com.app.repository.SupplierProductsDao;
import com.app.repository.UserDao;

@Service
@Transactional
public class SupplierProductServiceImplentation implements SupplierProductsService {


//*********************dependency injection****************************************************************************	
	@Autowired
	private SupplierProductsDao supplierProductsRepo;
	
	@Autowired
	private ProductDao productRepo;
	
	@Autowired
	private UserDao userRepo;

	
//*********************method implementation****************************************************************************
	//GET ALL
	@Override
	public List<SupplierProducts> getAllSupplierProductsDetails() {	
		return supplierProductsRepo.findAll();
	}

	
	//GET BY ID
	@Override
	public Optional<SupplierProducts> getSupplierProductsDetails(Long supplierProductsId) {
		return supplierProductsRepo.findById(supplierProductsId);
	}

	
	//INSERT
	@Override
	public SupplierProducts addSupplierProductsDetails(SupplierProducts transientSupplierProduct) {
		
		//getting productId & distributorID
		Long productId= transientSupplierProduct.getProducts().getId();
		Long distributorId= transientSupplierProduct.getDistributor().getId();
		
		
		//getting persistent Category
		Optional<Product> persistentProduct= productRepo.findById(productId);
		Optional<User> persistentDistributor= userRepo.findById(distributorId);
		
		
		//to avoid lazy initialization
		persistentDistributor.get().getFirstName();
		
		//getting SupplierProductList & binding
		List<SupplierProducts> supplierproductsList = persistentDistributor.get().getSupplierProducts();
		supplierproductsList.add(transientSupplierProduct);
		persistentDistributor.get().setSupplierProducts(supplierproductsList);

		//setting persistent object to transientSupplierProduct
		transientSupplierProduct.setProducts(persistentProduct.get());
		transientSupplierProduct.setDistributor(persistentDistributor.get());
		
		
		return supplierProductsRepo.save(transientSupplierProduct);
	}

	
	//UPDATE
	@Override
	public SupplierProducts updateSupplierProductsDetails(SupplierProducts detachedSupplierProducts) {
		return supplierProductsRepo.save(detachedSupplierProducts);
	}

	
	//DELETE
	@Override
	public String deleteSupplierProductsDetails(Long supplierProductsId) {
		
		if(supplierProductsRepo.existsById(supplierProductsId))
		{
			supplierProductsRepo.deleteById(supplierProductsId);
			return "SuppliedProducts Sucessfully Deleted......";
		}

		return "SuplliedProducts Deletion Failed......";
	}
	
	
}//End of SupplierProductServiceImplentation

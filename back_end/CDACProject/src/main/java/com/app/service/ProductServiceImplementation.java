package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.entities.Category;
import com.app.entities.Image;
import com.app.entities.Product;
import com.app.entities.User;
import com.app.entities.Vehicle;
import com.app.repository.CategoryDao;
import com.app.repository.ImageDao;
import com.app.repository.ProductDao;
import com.app.repository.VehicleDao;

@Service
@Transactional
public class ProductServiceImplementation implements ProductService {

	
//*********************dependency injection****************************************************************************
	@Autowired
	private ProductDao productRepo;
	
	@Autowired
	private VehicleDao vehicleRepo;
	
	@Autowired
	private CategoryDao categoryRepo;

	
//*********************method implementation****************************************************************************	
	//GET ALL
	@Override
	public List<Product> getAllProductDetails() {
		return productRepo.findAll();
	}

	//GET BY ID
	@Override
	public Optional<Product> getProductDetails(Long productId) {
		return productRepo.findById(productId);
	}

	//INSERT
	@Override
	public Product addProductDetails(Product transientProduct) {
		
		//getting categoryId 
		Long categoryId= transientProduct.getProductCategory().getId();
		
		//getting persistent Category
		Optional<Category> persistentCategory= categoryRepo.findById(categoryId);
		
		//to avoid lazy initialization
		persistentCategory.get().getCategoryName();
		
		//getting ProductList & binding
		List<Product> productList = persistentCategory.get().getProductsList();
		productList.add(transientProduct);
		persistentCategory.get().setProductsList(productList);
		
		transientProduct.setProductCategory(persistentCategory.get());
		
		return productRepo.save(transientProduct);
	}

	//UPDATE
	@Override
	public Product updateProductDetails(Product detachedProduct) {
		return productRepo.save(detachedProduct);
	}

	//DELETE
	@Override
	public String deleteProductDetails(Long productId) {
		
		if(productRepo.existsById(productId))
		{
			productRepo.deleteById(productId);
			return "Product Sucessfully Deleted......";
		}

		return "Product Deletion Failed......";
	}


//---------------------Custom method declaration for Administrator-----------------------------------------------
	
	//to get vehicle list by productId
	@Override
	public List<Vehicle> getVehicleListByProductId(Long productId) {
		
		//getting persistent Product from database by Id
		Optional<Product> persistentProduct= productRepo.findById(productId);
	
		//getting productList from persistentProduct
		List<Vehicle> vehicleList= persistentProduct.get().getVehicleList();
		
		//to handle lazy initialization error: just firing a query on CategoryList
		vehicleList.isEmpty();
		
		//returning the categoryList for persistentUser
		return vehicleList;
		
	}//End of getVehicleListByProductId

	
	//to Add vehicle by productID	
	@Override
	public String addVehicleByProductIdAndVehicle(Long productId, Vehicle transientAddVehicle) {
		
		//getting persistent Product & Vehicle from database by Id
		Optional<Product> persistentProduct= productRepo.findById(productId);
		Optional<Vehicle> persistentVehicle= vehicleRepo.findById(transientAddVehicle.getId());

		
		//to handle lazy initialization error
		String productName= persistentProduct.get().getProductName();
		String vehicleName=persistentVehicle.get().getVehicleName();
		
		
		//User side binding
		List<Vehicle> vehicleList= persistentProduct.get().getVehicleList();
		vehicleList.add(persistentVehicle.get());
		productRepo.save(persistentProduct.get());
		
		//Category side binding
		List<Product> productList=persistentVehicle.get().getProductList();
		productList.add(persistentProduct.get());
		vehicleRepo.save(persistentVehicle.get());
		
		return "Vehicle added successfully....!";
		
	}//End of addVehicleByProductIdAndVehicle

	
	//to Delete vehicle by productID	
	@Override
	public String deleteVehicleByProductIdAndVehicle(Long productId, Vehicle transientDeleteVehicle) {
		
		//getting persistent Product & Vehicle from database by Id
		Optional<Product> persistentProduct= productRepo.findById(productId);
		Optional<Vehicle> persistentVehicle= vehicleRepo.findById(transientDeleteVehicle.getId());

		
		//to handle lazy initialization error
		String productName= persistentProduct.get().getProductName();
		String vehicleName=persistentVehicle.get().getVehicleName();
		
		
		//User side un-binding
		List<Vehicle> vehicleList= persistentProduct.get().getVehicleList();
		vehicleList.remove(persistentVehicle.get());
		productRepo.save(persistentProduct.get());
		
		//Vehicle side un-binding
		List<Product> productList=persistentVehicle.get().getProductList();
		productList.remove(persistentProduct.get());
		vehicleRepo.save(persistentVehicle.get());
		
		return "Vehicle Deleted Succesfully....!";
	}//End of deleteVehicleByProductIdAndVehicle


//---------------------Custom method declaration for Customer-----------------------------------------------	
	//to get Product by Part Number
	@Override
	public Product findByPartNumber(int PartNumber) {
		return productRepo.findByPartNumber(PartNumber);
	}

	//to get Product by Product Name
	@Override
	public List<Product> findByProductName(String productName) {
		return productRepo.findByProductName(productName);
	}

	
	//to get Product List by Category Name
	@Override
	public List<Product> findByCategoryName(Category category) {
		return productRepo.findByProductCategory(category);
	}	
	
	
}//End of ProductService

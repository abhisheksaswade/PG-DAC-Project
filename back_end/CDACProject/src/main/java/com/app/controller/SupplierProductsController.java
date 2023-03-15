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

import com.app.entities.SupplierProducts;
import com.app.service.SupplierProductsService;

@RestController
@RequestMapping("/supplierproducts")
@CrossOrigin("http://localhost:3000/")
public class SupplierProductsController {
	

//*********************dependency injection****************************************************************************		
	@Autowired
	private SupplierProductsService supplierProductsService;
	
	
//*********************method implementation****************************************************************************	

	//GET
	@GetMapping
	public List<SupplierProducts> getAllSupplierProducts()
	{
		return supplierProductsService.getAllSupplierProductsDetails();
	}
	
	
	//GET BY ID
	@GetMapping("/{supplierProductsId}")
	public Optional<SupplierProducts> getSupplierProducts(@PathVariable Long supplierProductsId)
	{
		return supplierProductsService.getSupplierProductsDetails(supplierProductsId);
	}
	
	
	//INSERT
	@PostMapping
	public SupplierProducts addSupplierProducts(@RequestBody SupplierProducts transientSupplierProducts)
	{
		return supplierProductsService.addSupplierProductsDetails(transientSupplierProducts);
	}
	
	
	//UPDATE
	@PutMapping
	public SupplierProducts updateSupplierProducts(@RequestBody SupplierProducts detachedSupplierProducts)
	{
		return supplierProductsService.updateSupplierProductsDetails(detachedSupplierProducts);
	}
	
	
	//DELETE
	@DeleteMapping("/{supplierProductsId}")
	public String deleteSupplierProducts(@PathVariable Long supplierProductsId)
	{
		return supplierProductsService.deleteSupplierProductsDetails(supplierProductsId);
	}
	

}//End of SupplierProductsController

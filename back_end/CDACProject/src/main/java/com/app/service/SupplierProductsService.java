package com.app.service;

import java.util.List;
import java.util.Optional;

import com.app.entities.SupplierProducts;

public interface SupplierProductsService {
	

//********************* standard method declaration*****************************************************************
	//GET ALL
	public List<SupplierProducts> getAllSupplierProductsDetails();
	
	//GET BY ID
	public Optional<SupplierProducts> getSupplierProductsDetails(Long supplierProductsId);
	
	//INSERT
	public SupplierProducts addSupplierProductsDetails(SupplierProducts transientSupplierProducts);
	
	//UPDATE
	public SupplierProducts updateSupplierProductsDetails(SupplierProducts detachedSupplierProducts);
	
	//DELETE
	public String deleteSupplierProductsDetails(Long supplierProductsId);
	
}//End of SupplierProductsService

package com.app.service;

import java.util.List;
import java.util.Optional;

import com.app.entities.SupplierProducts;

public interface SupplierProductsService {

	public List<SupplierProducts> getAllSupplierProductsDetails();
	
	public Optional<SupplierProducts> getSupplierProductsDetails(Long supplierProductsId);
	
	public SupplierProducts addSupplierProductsDetails(SupplierProducts transientSupplierProducts);
	
	public SupplierProducts updateSupplierProductsDetails(SupplierProducts detachedSupplierProducts);
	
	public String deleteSupplierProductsDetails(Long supplierProductsId);
	
}//End of SupplierProductsService

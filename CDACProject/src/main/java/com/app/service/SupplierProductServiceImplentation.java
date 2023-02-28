package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.entities.SupplierProducts;
import com.app.repository.SupplierProductsDao;

@Service
@Transactional
public class SupplierProductServiceImplentation implements SupplierProductsService {


//*********************dependency injection****************************************************************************	
	@Autowired
	private SupplierProductsDao supplierProductsRepo;

	
//*********************method implementation****************************************************************************	
	@Override
	public List<SupplierProducts> getAllSupplierProductsDetails() {	
		return supplierProductsRepo.findAll();
	}

	@Override
	public Optional<SupplierProducts> getSupplierProductsDetails(Long supplierProductsId) {
		return supplierProductsRepo.findById(supplierProductsId);
	}

	@Override
	public SupplierProducts addSupplierProductsDetails(SupplierProducts transientSupplierProducts) {
		return supplierProductsRepo.save(transientSupplierProducts);
	}

	@Override
	public SupplierProducts updateSupplierProductsDetails(SupplierProducts detachedSupplierProducts) {
		return supplierProductsRepo.save(detachedSupplierProducts);
	}

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

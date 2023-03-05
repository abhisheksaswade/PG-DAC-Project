package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.entities.ItemDetails;
import com.app.entities.MyOrder;
import com.app.entities.SupplierProducts;
import com.app.repository.ItemDetailsDao;
import com.app.repository.MyOrderDao;
import com.app.repository.SupplierProductsDao;

@Service
@Transactional
public class ItemDetailsServiceImplentation implements ItemDetailsService {

	
//*********************dependency injection****************************************************************************	
	@Autowired
	private ItemDetailsDao itemDetailsRepo;
	
	@Autowired
	private MyOrderDao myOrderRepo;
	
	@Autowired
	private SupplierProductsDao supplierProductsRepo;

	
//*********************method implementation****************************************************************************
	//GET ALL
	@Override
	public List<ItemDetails> getAllItemDetailsDetails() {
		return itemDetailsRepo.findAll();
	}

	//GET BY ID
	@Override
	public Optional<ItemDetails> getItemDetailsDetails(Long itemDetailsId) {
		return itemDetailsRepo.findById(itemDetailsId);
	}

	//INSERT
	@Override
	public ItemDetails addItemDetailsDetails(ItemDetails transientItemDetails) {
		
		//getting myorderId &supplierProductsId 
		Long myorderId = transientItemDetails.getMyorder().getId();
		Long supplierProductsId = transientItemDetails.getSupplierProduct().getId();
		
		//getting Persistent object of MyOrder & SupplierProducts
		Optional<MyOrder> persistentMyorder = myOrderRepo.findById(myorderId);
		Optional<SupplierProducts> persistentSupplierProducts = supplierProductsRepo.findById(supplierProductsId);
		
		//to avoid lazy initialization
		persistentMyorder.get().getCustomer();
		persistentSupplierProducts.get().getQuantity();
		
		//getting ItemList and Binding
//		List<ItemDetails> itemDetailsList = persistentMyorder.get().getItemDetailsList();
//		itemDetailsList.add(transientItemDetails);
//		persistentMyorder.get().setItemDetailsList(itemDetailsList);

		//
		transientItemDetails.setMyorder(persistentMyorder.get());
		
		
		//getting ItemList and Binding
//		List<ItemDetails> itemDetailsList2 = persistentSupplierProducts.get().getItemDetailsList();
//		itemDetailsList2.add(transientItemDetails);
//		persistentSupplierProducts.get().setItemDetailsList(itemDetailsList2);
		
		//
		transientItemDetails.setSupplierProduct(persistentSupplierProducts.get());
		
		return itemDetailsRepo.save(transientItemDetails);
	}

	//UPDATE
	@Override
	public ItemDetails updateItemDetailsDetails(ItemDetails detachedItemDetails) {
		return itemDetailsRepo.save(detachedItemDetails);
	}

	//DELETE
	@Override
	public String deleteItemDetailsDetails(Long itemDetailsId) {

		if(itemDetailsRepo.existsById(itemDetailsId))
		{
			itemDetailsRepo.deleteById(itemDetailsId);
			return "ItemDetails Sucessfully Deleted......";
		}

		return "ItemDetails Deletion Failed......";
	}
	
	
}//End of ItemDetailsServiceImplentation

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
		MyOrder persistentMyorder = myOrderRepo.findById(myorderId).get();
		SupplierProducts persistentSupplierProducts = supplierProductsRepo.findById(supplierProductsId).get();
		
		//to avoid lazy initialization
//		persistentMyorder.get().getCustomer();
//		persistentSupplierProducts.get().getQuantity();
		
		//getting ItemList and Binding
//		List<ItemDetails> itemDetailsList = persistentMyorder.get().getItemDetailsList();
//		itemDetailsList.add(transientItemDetails);
//		persistentMyorder.get().setItemDetailsList(itemDetailsList);
	
		//getting ItemList and Binding
//		List<ItemDetails> itemDetailsList2 = persistentSupplierProducts.get().getItemDetailsList();
//		itemDetailsList2.add(transientItemDetails);
//		persistentSupplierProducts.get().setItemDetailsList(itemDetailsList2);
		
		//if item already in cart or new
		if(itemDetailsRepo.findByMyorderAndSupplierProduct(persistentMyorder, persistentSupplierProducts).isPresent())
		{
			ItemDetails persistentItemDetails = itemDetailsRepo.findByMyorderAndSupplierProduct(persistentMyorder, persistentSupplierProducts).get();
			persistentItemDetails.setQuantity(persistentItemDetails.getQuantity()+1);
			persistentItemDetails.setPrice((persistentItemDetails.getQuantity())*(persistentSupplierProducts.getFinalPrice()));
			persistentMyorder.setOrderPrice(persistentMyorder.getOrderPrice()+persistentSupplierProducts.getFinalPrice());
			persistentSupplierProducts.setQuantity(persistentSupplierProducts.getQuantity()-1);
			return itemDetailsRepo.save(persistentItemDetails);
		}
		else
		{
			transientItemDetails.setMyorder(persistentMyorder);
			transientItemDetails.setSupplierProduct(persistentSupplierProducts);
			transientItemDetails.setPrice(persistentSupplierProducts.getFinalPrice());
			persistentMyorder.setOrderPrice(persistentMyorder.getOrderPrice()+persistentSupplierProducts.getFinalPrice());
			persistentSupplierProducts.setQuantity(persistentSupplierProducts.getQuantity()-1);
			return itemDetailsRepo.save(transientItemDetails);
		}

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
			
			ItemDetails persistentItemDetails = itemDetailsRepo.findById(itemDetailsId).get();
			
			Long supplierProductsId = persistentItemDetails.getSupplierProduct().getId();
			SupplierProducts persistentSupplierProducts = supplierProductsRepo.findById(supplierProductsId).get();
			persistentSupplierProducts.setQuantity(persistentSupplierProducts.getQuantity()+ persistentItemDetails.getQuantity());
			
			MyOrder persistentMyOrder= persistentItemDetails.getMyorder();
			persistentMyOrder.setOrderPrice(persistentMyOrder.getOrderPrice()-persistentItemDetails.getPrice());
			
			itemDetailsRepo.deleteById(itemDetailsId);
			return "ItemDetails Sucessfully Deleted......";
		}

		return "ItemDetails Deletion Failed......";
	}
//********************* Custom method declaration for Customer*****************************************************************

	//find items by order id
	@Override
	public List<ItemDetails> getAllItemsByOrderId(Long OrderId) {
		MyOrder persistentMyOrder= myOrderRepo.findById(OrderId).get();
		return itemDetailsRepo.findByMyorder(persistentMyOrder);
	}
	
	
}//End of ItemDetailsServiceImplentation

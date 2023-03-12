package com.app.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.ItemDetails;
import com.app.entities.MyOrder;
import com.app.entities.SupplierProducts;

public interface ItemDetailsDao extends JpaRepository<ItemDetails, Long> {
	
	//find items by order id
	public List<ItemDetails> findByMyorder(MyOrder myOrder);
	
	//find item by orderId and supplierProductId
	public Optional<ItemDetails> findByMyorderAndSupplierProduct(MyOrder myOrder, SupplierProducts supplierProduct);

}//End of ItemDetailsDao

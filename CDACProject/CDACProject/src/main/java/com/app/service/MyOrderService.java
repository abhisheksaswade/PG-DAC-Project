package com.app.service;

import java.util.List;
import java.util.Optional;

import com.app.entities.MyOrder;

public interface MyOrderService {

	public List<MyOrder> getAllMyOrderDetails();
	
	public Optional<MyOrder> getMyOrderDetails(Long myOrderId);
	
	public MyOrder addMyOrderDetails(MyOrder transientMyOrder);
	
	public MyOrder updateMyOrderDetails(MyOrder detachedMyOrder);
	
	public String deleteMyOrderDetails(Long myOrderId);
	
}//End of MyOrderService
	
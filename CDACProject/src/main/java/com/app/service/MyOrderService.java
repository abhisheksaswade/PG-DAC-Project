package com.app.service;

import java.util.List;
import java.util.Optional;

import com.app.entities.MyOrder;
import com.app.entities.OrderStatus;
import com.app.entities.User;

public interface MyOrderService {
	
	
//********************* standard method declaration*****************************************************************
	//GET ALL
	public List<MyOrder> getAllMyOrderDetails();
	
	//GET BY ID
	public Optional<MyOrder> getMyOrderDetails(Long myOrderId);
	
	//INSERT
	public MyOrder addMyOrderDetails(MyOrder transientMyOrder);
	
	//UPDATE
	public MyOrder updateMyOrderDetails(MyOrder detachedMyOrder);
	
	//DELETE
	public String deleteMyOrderDetails(Long myOrderId);
	
	
//---------------------Custom method declaration for Administrator-----------------------------------------------
	
	//to get order to be deliver/delivered by deliveryPerson based on order status
	public List<MyOrder> deliveryPersonOrdersByOrderStatus(Long deliveryPerson, Enum orderStatus);
	
	//to get orderList by orderStatus
	public List<MyOrder> getByOrderStatus(Enum orderStatus);
	
	//to update order by orderStatus
	public String updateOrderStatus(OrderStatus orderStatusEnum, Long orderId);
	

//---------------------Custom method declaration for Customer-----------------------------------------------
	//to get cart by customerId & order status
	public MyOrder cartOrder(Long customerId, OrderStatus orderStatus);
	
	//to get myOrderList by customerId & order status
	public List<MyOrder> myOrderList(Long customerId, OrderStatus orderStatus);
	
}//End of MyOrderService
	
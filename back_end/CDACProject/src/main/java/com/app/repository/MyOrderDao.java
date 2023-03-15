package com.app.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.MyOrder;
import com.app.entities.OrderStatus;
import com.app.entities.User;

public interface MyOrderDao extends JpaRepository<MyOrder, Long> {

	//to get order to be deliver/delivered by deliveryPerson based on order status
	public List<MyOrder> findByDeliveryPersonAndOrderStatus(User deliveryPersonId, Enum orderStatus);
	
	//to get orderList by orderStatus
	public List<MyOrder> findByOrderStatus(Enum orderStatus); 

	//to get cart/MyOrderList by customerId & order status
	public List<MyOrder> findByCustomerAndOrderStatus(User customer, OrderStatus orderStatus);
		
}//End of MyOrderDao

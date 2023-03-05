package com.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.MyOrder;
import com.app.entities.User;

public interface MyOrderDao extends JpaRepository<MyOrder, Long> {

	//to get order to be deliver/delivered by deliveryPerson based on order status
	public List<MyOrder> findByDeliveryPersonAndOrderStatus(User deliveryPersonId, Enum orderStatus);

	
}//End of MyOrderDao

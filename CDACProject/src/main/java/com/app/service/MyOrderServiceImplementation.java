package com.app.service;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.entities.Category;
import com.app.entities.MyOrder;
import com.app.entities.OrderStatus;
import com.app.entities.Product;
import com.app.entities.User;
import com.app.repository.MyOrderDao;
import com.app.repository.UserDao;

@Service
@Transactional
public class MyOrderServiceImplementation implements MyOrderService {


//*********************dependency injection****************************************************************************	
	@Autowired
	private MyOrderDao myOrderRepo;

	@Autowired
	private UserDao userRepo;
	
//*********************method implementation****************************************************************************	
	@Override
	public List<MyOrder> getAllMyOrderDetails() {
		return myOrderRepo.findAll();
	}

	@Override
	public Optional<MyOrder> getMyOrderDetails(Long myOrderId) {
		return myOrderRepo.findById(myOrderId);
	}

	@Override
	public MyOrder addMyOrderDetails(MyOrder transientMyOrder) {
		
		//getting customerId & deliveryPersonId
		Long customerId= transientMyOrder.getCustomer().getId();
		Long deliveryPersonId= transientMyOrder.getDeliveryPerson().getId();
		
		//getting persistent User= customer & deliveryPerson
		Optional<User> persistentCustomer= userRepo.findById(customerId);
		Optional<User> persistentDeliveryPerson= userRepo.findById(deliveryPersonId);
		
		
		//to avoid lazy initialization
		persistentCustomer.get().getFirstName();
		persistentDeliveryPerson.get().getFirstName();
		
		
		//getting List & binding
//		List<MyOrder> myOrderList = persistentCustomer.get().getMyOrder_C();
//		myOrderList.add(transientMyOrder);
//		persistentCustomer.get().setMyOrder_C(myOrderList);
		
		transientMyOrder.setCustomer(persistentCustomer.get());
		
//		List<MyOrder> myOrderList2 = persistentDeliveryPerson.get().getMyOrder_D();
//		myOrderList.add(transientMyOrder);
//		persistentDeliveryPerson.get().setMyOrder_D(myOrderList);
		
		transientMyOrder.setDeliveryPerson(persistentDeliveryPerson.get());
		
		
		return myOrderRepo.save(transientMyOrder);
	}

	@Override
	public MyOrder updateMyOrderDetails(MyOrder detachedMyOrder) {
		return myOrderRepo.save(detachedMyOrder);
	}

	@Override
	public String deleteMyOrderDetails(Long myOrderId) {

		if(myOrderRepo.existsById(myOrderId))
		{
			myOrderRepo.deleteById(myOrderId);
			return "User Sucessfully Deleted......";
		}

		return "User Deletion Failed......";
		
	}
	
//---------------------Custom method implementation for Administrator-----------------------------------------------
	
	//to get order to be deliver/delivered by deliveryPerson based on order status
	@Override
	public List<MyOrder> deliveryPersonOrdersByOrderStatus(Long deliveryPersonId, Enum orderStatus) {
		
		Optional<User> deliveryPerson= userRepo.findById(deliveryPersonId);
		
		return myOrderRepo.findByDeliveryPersonAndOrderStatus(deliveryPerson.get(), orderStatus);
	}

	//to get orderList by orderStatus
	@Override
	public List<MyOrder> getByOrderStatus(Enum orderStatus) {
		return myOrderRepo.findByOrderStatus(orderStatus);
	}

	@Override
	public String updateOrderStatus(OrderStatus orderStatusEnum,Long orderId) {
		
		//getting persistent myOrder
		Optional<MyOrder> persistentMyOrder = myOrderRepo.findById(orderId);
		persistentMyOrder.get().setOrderStatus(orderStatusEnum);
		
		return "Order Updated Successfully";
	}

	
//---------------------Custom method implementation for Customer-----------------------------------------------	
	
	//to get cart order by customer and ordrStatus
	
	@Override
	public MyOrder cartOrder(Long customerId, OrderStatus orderStatus) {
		User persistentCustomer = userRepo.findById(customerId).get();
		boolean result= myOrderRepo.findByCustomerAndOrderStatus(persistentCustomer, orderStatus).isPresent();
		 
		 if(result)
		 {
			 MyOrder oldCart= myOrderRepo.findByCustomerAndOrderStatus(persistentCustomer, orderStatus).get();
			 oldCart.setOrderDate(LocalDate.now());
             oldCart.setDeliveryDate(LocalDate.now().plusDays(7)); 
			return oldCart; 
		 }
		 else
		 {
			 MyOrder newCart = new MyOrder(OrderStatus.INCART, persistentCustomer);
			 newCart.setOrderDate(LocalDate.now());
             newCart.setDeliveryDate(LocalDate.now().plusDays(7)); 
			return myOrderRepo.save(newCart); 
		 }
	}
	
	
	
}//End of MyOrderServiceImplementation

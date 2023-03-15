package com.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entities.MyOrder;
import com.app.entities.OrderStatus;
import com.app.service.MyOrderService;

@RestController
@RequestMapping("/myorder")
@CrossOrigin("http://localhost:3000/")
public class MyOrderController {

	
//*********************dependency injection****************************************************************************	
	@Autowired
	private MyOrderService myOrderService;

	
//*********************method implementation****************************************************************************	
		
		//GET
		@GetMapping
		public List<MyOrder> getAllMyOrder()
		{
			return myOrderService.getAllMyOrderDetails();
		}
		
		
		//GET BY ID
		@GetMapping("/{myOrderId}")
		public Optional<MyOrder> getMyOrder(@PathVariable Long myOrderId)
		{
			return myOrderService.getMyOrderDetails(myOrderId);
		}
		
		
		//INSERT
		@PostMapping
		public MyOrder addMyOrder(@RequestBody MyOrder transientMyOrder)
		{
			return myOrderService.addMyOrderDetails(transientMyOrder);
		}
		
		
		//UPDATE
		@PutMapping
		public MyOrder updateMyOrder(@RequestBody MyOrder detachedMyOrder)
		{
			return myOrderService.updateMyOrderDetails(detachedMyOrder);
		}
		
		
		//DELETE
		@DeleteMapping("/{myOrderId}")
		public String deleteMyOrder(@PathVariable Long myOrderId)
		{
			return myOrderService.deleteMyOrderDetails(myOrderId);
		}	
		
		
//*********************custom method implementation for deliveryPerson****************************************************************************

		//to get order to be deliver based on order status
		@GetMapping("/orderlist/{deliveryPersonId}")
		public List<MyOrder> deliveryPersonOrderList(@PathVariable Long deliveryPersonId)
		{
			String orderStatus= "INPROCESS";
			Enum orderStatusEnum= OrderStatus.valueOf(orderStatus);
			return myOrderService.deliveryPersonOrdersByOrderStatus(deliveryPersonId, orderStatusEnum);
			
		}
		
		//to get order to be delivered by deliveryPerson based on order status
		@GetMapping("/deliverylist/{deliveryPersonId}")
		public List<MyOrder> deliveryPersonDeliveredList(@PathVariable Long deliveryPersonId)
		{
			return myOrderService.deliveryPersonOrdersByOrderStatus(deliveryPersonId, OrderStatus.DELIVERED);
			
		}
		
		//to get orderList by orderStatus= INCART
		@GetMapping("/cartlist")
		public List<MyOrder> getAllCarts()
		{
			return myOrderService.getByOrderStatus(OrderStatus.INCART);
		}
		
		
		@PutMapping("/orderdelivered/{orderId}")
		public String updateDeliverOrderStatus(@PathVariable Long orderId)
		{
			return myOrderService.updateOrderStatus(OrderStatus.DELIVERED, orderId);
			
		}
//*********************custom method implementation for customer****************************************************************************

		//to get order to be deliver based on order status
		@GetMapping("/cart/{customerId}")
		public MyOrder customerCart(@PathVariable Long customerId)
		{			
			return myOrderService.cartOrder(customerId, OrderStatus.INCART);
					
		}	
		
		//to place an order
		@PutMapping("/orderplace/{orderId}")
		public String updatePlaceOrderStatus(@PathVariable Long orderId)
		{
			return myOrderService.updateOrderStatus(OrderStatus.INPROCESS, orderId);
			
		}
		
		
		//to get myOrderList(INPROCESS) based on order status
		@GetMapping("/mycurrentorders/{customerId}")
		public List<MyOrder> myCurrentOrderList(@PathVariable Long customerId)
		{			
			return myOrderService.myOrderList(customerId, OrderStatus.INPROCESS);
					
		}	
		
		//to get myOrderList(DELIVERED) based on order status
		@GetMapping("/orderhistory/{customerId}")
		public List<MyOrder> myOrderHistoryList(@PathVariable Long customerId)
		{			
			return myOrderService.myOrderList(customerId, OrderStatus.DELIVERED);
					
		}	
		
		
		
}//End of MyOrderController
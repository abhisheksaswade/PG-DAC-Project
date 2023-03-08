package com.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
			String orderStatus= "INCART";
			Enum orderStatusEnum= OrderStatus.valueOf(orderStatus);
			return myOrderService.deliveryPersonOrdersByOrderStatus(deliveryPersonId, orderStatusEnum);
			
		}
		
		//to get order to be delivered by deliveryPerson based on order status
		@GetMapping("/deliverylist/{deliveryPersonId}")
		public List<MyOrder> deliveryPersonDeliveredList(@PathVariable Long deliveryPersonId)
		{
			return myOrderService.deliveryPersonOrdersByOrderStatus(deliveryPersonId, OrderStatus.INPROCESS);
			
		}
		
		//to get orderList by orderStatus= INCART
		@GetMapping("/cartlist")
		public List<MyOrder> getAllCarts()
		{
			return myOrderService.getByOrderStatus(OrderStatus.INCART);
		}
		
		
		@PutMapping("/order/{orderStatus}")
		public String updateOrderStatus(@PathVariable String orderStatus, @RequestBody Long orderId)
		{
			OrderStatus orderStatusEnum= OrderStatus.valueOf(orderStatus);
			return myOrderService.updateOrderStatus(orderStatusEnum, orderId);
			
		}
		
		
}//End of MyOrderController
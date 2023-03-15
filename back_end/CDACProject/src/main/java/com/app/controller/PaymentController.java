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

import com.app.entities.Payment;
import com.app.entities.PaymentMode;
import com.app.service.PaymentService;

@RestController
@RequestMapping("/payment")
@CrossOrigin("http://localhost:3000/")
public class PaymentController {
	
	
//*********************dependency injection****************************************************************************	
	@Autowired
	private PaymentService paymentService;
	

//*********************method implementation****************************************************************************	

	//GET
	@GetMapping
	public List<Payment> getAllPaymentDetails()
	{
		return paymentService.getAllPaymentsDetails();
	}
	
	
	//GET BY ID
	@GetMapping("/{paymentId}")
	public Optional<Payment> getPayment(@PathVariable Long paymentId)
	{
		return paymentService.getPaymentsDetails(paymentId);
	}
	
	
	//INSERT
	@PostMapping
	public Payment addPayment(@RequestBody Payment transientPayment)
	{
		return paymentService.addPaymentDetails(transientPayment);
	}
	
	
	//UPDATE
	@PutMapping
	public Payment updatePayment(@RequestBody Payment detachedPayment)
	{
		return paymentService.updatePaymentDetails(detachedPayment);
	}
	
	
	//DELETE
	@DeleteMapping("/{paymentId}")
	public String deletePayment(@PathVariable Long paymentId)
	{
		return paymentService.deletePaymentDetails(paymentId);
	}
//*********************custom method implementation for customer****************************************************************************

	//to get payment status by order id
	@GetMapping("getpaymentbyorder/{orderId}")
	public Payment getPaymentByMyOrder(@PathVariable Long orderId)
	{
		return paymentService.getPaymentByOrder(orderId);
	}
	
	//update payment status by receiving mode & orderid
	@PutMapping("/makepayment")
	public Payment updatePaymentByModeAndOrder(@RequestBody Payment transientPayment)
	{
		return paymentService.updatePaymentByModeAndOrder(transientPayment);
	}
	
}//End of PaymentController

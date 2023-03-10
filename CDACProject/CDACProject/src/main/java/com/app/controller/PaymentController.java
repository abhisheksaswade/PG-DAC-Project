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

import com.app.entities.Payment;
import com.app.service.PaymentService;

@RestController
@RequestMapping("/payment")
public class PaymentController {
	
	
//*********************dependency injection****************************************************************************	
	@Autowired
	private PaymentService paymentService;
	

//*********************method implementation****************************************************************************	
	@GetMapping
	public List<Payment> getAllPaymentDetails()
	{
		return paymentService.getAllPaymentsDetails();
	}
	
	@GetMapping("/{paymentId}")
	public Optional<Payment> getPayment(@PathVariable Long paymentId)
	{
		return paymentService.getPaymentsDetails(paymentId);
	}
	
	@PostMapping
	public Payment addPayment(@RequestBody Payment transientPayment)
	{
		return paymentService.addPaymentDetails(transientPayment);
	}
	
	@PutMapping
	public Payment updatePayment(@RequestBody Payment detachedPayment)
	{
		return paymentService.updatePaymentDetails(detachedPayment);
	}
	
	@DeleteMapping("/{paymentId}")
	public String deletePayment(@PathVariable Long paymentId)
	{
		return paymentService.deletePaymentDetails(paymentId);
	}

	
}//End of PaymentController

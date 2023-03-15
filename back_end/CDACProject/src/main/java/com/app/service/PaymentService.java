package com.app.service;

import java.util.List;
import java.util.Optional;

import com.app.entities.MyOrder;
import com.app.entities.Payment;

public interface PaymentService {
	
//********************* standard method declaration*****************************************************************
	
	//GET ALL
	public List<Payment> getAllPaymentsDetails();
	
	//GET BY ID
	public Optional<Payment> getPaymentsDetails(Long paymentId);
	
	//INSERT
	public Payment addPaymentDetails(Payment transientPayment);
	
	//UPDATE
	public Payment updatePaymentDetails(Payment detachedPayment);
	
	//DELETE
	public String deletePaymentDetails(Long paymentId);

	
//********************* Custom method implementation method declaration*****************************************************************	

	//get payment by order id
	public Payment getPaymentByOrder(Long orderId);
	
	//to make payment with mode & order
	public Payment updatePaymentByModeAndOrder(Payment transientPayment);
	
}//End of PaymentService

package com.app.service;

import java.util.List;
import java.util.Optional;

import com.app.entities.Payment;

public interface PaymentService {
	
	public List<Payment> getAllPaymentsDetails();
	
	public Optional<Payment> getPaymentsDetails(Long paymentId);
	
	public Payment addPaymentDetails(Payment transientPayment);
	
	public Payment updatePaymentDetails(Payment detachedPayment);
	
	public String deletePaymentDetails(Long paymentId);

}//End of PaymentService

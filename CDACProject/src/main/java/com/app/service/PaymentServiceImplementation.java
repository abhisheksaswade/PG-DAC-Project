package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.entities.Payment;
import com.app.repository.PaymentDao;

@Service
@Transactional
public class PaymentServiceImplementation implements PaymentService {
	
	
//*********************dependency injection****************************************************************************	
	@Autowired
	private PaymentDao paymentRepo;


//*********************method implementation****************************************************************************	
	@Override
	public List<Payment> getAllPaymentsDetails() {
		return paymentRepo.findAll();
	}

	@Override
	public Optional<Payment> getPaymentsDetails(Long paymentId) {
		return paymentRepo.findById(paymentId);
	}

	@Override
	public Payment addPaymentDetails(Payment transientPayment) {
		return paymentRepo.save(transientPayment);
	}

	@Override
	public Payment updatePaymentDetails(Payment detachedPayment) {	
		return paymentRepo.save(detachedPayment);
	}

	@Override
	public String deletePaymentDetails(Long paymentId) {
		
		if(paymentRepo.existsById(paymentId))
		{
			paymentRepo.deleteById(paymentId);
			return "Payment Sucessfully Deleted......";
		}

		return "Payment Deletion Failed......";
	}

}//End of PaymentServiceImplementation

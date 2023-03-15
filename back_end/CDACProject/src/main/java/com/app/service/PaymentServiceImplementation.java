package com.app.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.entities.Category;
import com.app.entities.MyOrder;
import com.app.entities.OrderStatus;
import com.app.entities.Payment;
import com.app.entities.PaymentMode;
import com.app.entities.PaymentStatus;
import com.app.entities.Product;
import com.app.repository.MyOrderDao;
import com.app.repository.PaymentDao;

@Service
@Transactional
public class PaymentServiceImplementation implements PaymentService {
	
	
//*********************dependency injection****************************************************************************	
	@Autowired
	private PaymentDao paymentRepo;
	
	@Autowired
	private MyOrderDao myOrderRepo;


//*********************Standard method implementation****************************************************************************
	//GET ALL
	@Override
	public List<Payment> getAllPaymentsDetails() {
		return paymentRepo.findAll();
	}

	
	//GET BY ID
	@Override
	public Optional<Payment> getPaymentsDetails(Long paymentId) {
		return paymentRepo.findById(paymentId);
	}

	
	//INSERT
	@Override
	public Payment addPaymentDetails(Payment transientPayment) {
		
		//getting MyOrder Id
		Long myOrderId = transientPayment.getMyOrder().getId();
		
		//Getting Persistence MyOrder
		MyOrder persistenceMyOrder = myOrderRepo.findById(myOrderId).get();
		
		//Setting Order details in Payment
		transientPayment.setMyOrder(persistenceMyOrder);
		transientPayment.setPaymentDate(LocalDate.now());
		transientPayment.setPaymentStatus(PaymentStatus.UNPAID);
		
		
		return paymentRepo.save(transientPayment);
	}
	
	
	//UPDATE
	@Override
	public Payment updatePaymentDetails(Payment detachedPayment) {	
		return paymentRepo.save(detachedPayment);
	}

	
	//DELETE
	@Override
	public String deletePaymentDetails(Long paymentId) {
		
		if(paymentRepo.existsById(paymentId))
		{
			paymentRepo.deleteById(paymentId);
			return "Payment Sucessfully Deleted......";
		}

		return "Payment Deletion Failed......";
	}
//*********************Custom method implementation****************************************************************************
	
   //to get payment by order
	@Override
	public Payment getPaymentByOrder(Long orderId) {
		MyOrder persistentMyOrder= myOrderRepo.findById(orderId).get();
		return paymentRepo.findByMyOrder(persistentMyOrder);
	}


	//update payment
	@Override
	public Payment updatePaymentByModeAndOrder(Payment transientPayment) {
		PaymentMode paymentMode= transientPayment.getPaymentMode();
		Long orderId=transientPayment.getMyOrder().getId();
		
		MyOrder persistentMyOrder= myOrderRepo.findById(orderId).get();
		Payment persistentPayment= paymentRepo.findByMyOrder(persistentMyOrder);
		
		if(!(PaymentStatus.PAID.equals(persistentPayment.getPaymentStatus())))
		{
		persistentPayment.setPaymentMode(paymentMode);
		persistentPayment.setPaymentStatus(PaymentStatus.PAID);
		}
		
		return paymentRepo.save(persistentPayment);
	}

	
	
}//End of PaymentServiceImplementation

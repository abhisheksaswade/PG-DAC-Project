package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.MyOrder;
import com.app.entities.Payment;

public interface PaymentDao extends JpaRepository<Payment, Long> {
	
	//to get payment by order
	public Payment findByMyOrder(MyOrder myOrder);

}//End of PaymentDao

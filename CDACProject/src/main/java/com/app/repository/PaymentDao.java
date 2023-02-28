package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Payment;

public interface PaymentDao extends JpaRepository<Payment, Long> {

}//End of PaymentDao

package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.MyOrder;

public interface MyOrderDao extends JpaRepository<MyOrder, Long> {

}//End of MyOrderDao

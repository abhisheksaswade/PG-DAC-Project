package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.SupplierProducts;

public interface SupplierProductsDao extends JpaRepository<SupplierProducts, Long> {

}//End of SupplierProductsDao

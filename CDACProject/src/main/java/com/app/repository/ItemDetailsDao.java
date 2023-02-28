package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.ItemDetails;

public interface ItemDetailsDao extends JpaRepository<ItemDetails, Long> {

}//End of ItemDetailsDao

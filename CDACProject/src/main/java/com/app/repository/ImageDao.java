package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Image;

public interface ImageDao extends JpaRepository<Image, Long> {

}//End of ImageDao

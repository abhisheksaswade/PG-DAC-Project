package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Category;

public interface CategoryDao extends JpaRepository<Category, Long> {

}//End of CategoryDao

package com.app.entities;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Category extends BaseEntity {

	
//************************data members************************************************************************************		
	private String categoryName;

	
//************************Entity Relations********************************************************************************			
	//Owning & Inverse entities are mentioned respectively
	//User & Category
	@ToString.Exclude
	@JsonIgnore
	@ManyToMany(mappedBy = "categoryList")
	private List<User> userList = new ArrayList();


	//Product & category= for category id 
	@ToString.Exclude
	@JsonIgnore
	@OneToMany(mappedBy = "productCategory", cascade = CascadeType.ALL, orphanRemoval = true)
	private  List<Product> ProductsList = new ArrayList();


//************************constructors************************************************************************************	
	
}//End of Category

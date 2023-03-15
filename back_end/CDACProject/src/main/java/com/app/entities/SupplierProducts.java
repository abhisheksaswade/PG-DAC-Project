package com.app.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

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
public class SupplierProducts extends BaseEntity{
	
	
//************************data members********************************************************************************************	
	private double price;
	
	private double discount;
	
	private double finalPrice;
	
	private int quantity;
	
	
//************************Entity Relations****************************************************************************************
	//Owning & Inverse entities are mentioned respectively
	//SupplierProduct & Products: for Product id
 	 @ToString.Exclude
  	 @OneToOne
	 private Product products;
 	 
 	//ItemDetails & Supplier Products= for supplier products id 
 	@ToString.Exclude
 	@JsonIgnore
 	@OneToMany(mappedBy = "supplierProduct", cascade = CascadeType.ALL, orphanRemoval = true)
 	private  List<ItemDetails> itemDetailsList = new ArrayList();

	//SupplierProduct & User: for User(distributor) id
	@ToString.Exclude
	@ManyToOne
	@JoinColumn(name="distributor_id")
	private User distributor;
	
}//End of S_Products

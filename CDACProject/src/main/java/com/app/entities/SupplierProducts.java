package com.app.entities;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

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
	//SupplierProduct & Category: for Category id
	@ToString.Exclude
	@ManyToOne
	@JoinColumn(name="category_id")
	private Category supplierproductCategory;

	
}//End of S_Products

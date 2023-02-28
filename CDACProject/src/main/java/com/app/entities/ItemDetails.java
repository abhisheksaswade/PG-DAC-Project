package com.app.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

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
public class ItemDetails extends BaseEntity {

	
//************************data members***************************************************************************************
	private String itemName;
	
	private double weight;
	
	private int quantity;
	
	private double price;
	
	
//************************Entity Relations**********************************************************************************
	//Owning & Inverse entities are mentioned respectively
	
    //User & ItemDetails= for distributor 
	@ToString.Exclude
	@JsonIgnore
	@ManyToMany(mappedBy = "itemDetailsList")
	private List<User> distributorList = new ArrayList();

    //ItemDetails & MyOrder= for MyOrder id 
	@ToString.Exclude
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="order_id")
	private MyOrder myorder;


//************************constructors**************************************************************************************

	
}// End of ItemDetails

package com.app.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.apache.commons.lang3.builder.ToStringExclude;

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
public class MyOrder extends BaseEntity{
	
	
//************************data members************************************************************************************
	private double orderPrice;
	private LocalDate orderDate;
	private LocalDate deliveryDate;
	
	@Enumerated(EnumType.STRING)
	private OrderStatus orderStatus;

	
//************************Entity Relations*********************************************************************************
	//Owning & Inverse entities are mentioned respectively
    //MyOrder & User= Customer
	@ToString.Exclude
	@ManyToOne
	@JoinColumn(name="customer_id")
	private User customer;
	
	
    //MyOrder & User= deliveryPerson
	@ToString.Exclude
	@ManyToOne
	@JoinColumn(name="deliveryPerson_id")
	private User deliveryPerson;

    //ItemDetails & MyOrder= for MyOrder id 
	@ToString.Exclude
	@JsonIgnore
	@OneToMany(mappedBy = "myorder", cascade = CascadeType.ALL, orphanRemoval = true)
	private  List<ItemDetails> itemDetailsList = new ArrayList();

	
//************************constructors*************************************************************************************

	public MyOrder(OrderStatus orderStatus, User customer) {
		super();
		this.orderStatus = orderStatus;
		this.customer = customer;
	}
	
}//End of MyOrder

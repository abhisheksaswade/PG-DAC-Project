package com.app.entities;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
public class Payment extends BaseEntity{


//************************data members************************************************************************************
	private LocalDate paymentDate;
	
	@Enumerated(EnumType.STRING)
	private PaymentStatus paymentStatus;
	
	@Enumerated(EnumType.STRING)
	private PaymentMode paymentMode;
	
	
//************************Entity Relations********************************************************************************
	
	//Owning & Inverse entities are mentioned respectively	
	//Payment & MyOrder = for order_id
	//@JsonIgnore
	@ToString.Exclude
	@OneToOne
	private MyOrder myOrder;


//************************constructors************************************************************************************
		
	
}//End of Payment

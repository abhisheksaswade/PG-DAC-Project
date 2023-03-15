package com.app.entities;

import java.util.List;

import javax.persistence.Embeddable;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Address {

//************************data members************************************************************************************
	private String line1;
	private String line2;
	private String landmark;
	private String city;
	private String district;
	private String state;
	private int pincode;


//************************constructors************************************************************************************

}//End of Address

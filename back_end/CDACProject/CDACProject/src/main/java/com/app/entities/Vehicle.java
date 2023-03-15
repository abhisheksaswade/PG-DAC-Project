package com.app.entities;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;

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
public class Vehicle extends BaseEntity{
	
	
//************************data members**************************************************************************
	private String vehicleName;

	
//************************Entity Relations**********************************************************************
	//Owning & Inverse entities are mentioned respectively
	//Product & Vehicle	
	@ToString.Exclude
	@JsonIgnore
	@ManyToMany(mappedBy = "vehicleList")
	private List<Product> productList = new ArrayList();
	
	
//************************constructors************************************************************************************	
	
	
}// End of Vehicle

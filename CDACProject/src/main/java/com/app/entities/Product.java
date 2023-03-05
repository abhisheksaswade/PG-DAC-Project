package com.app.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
public class Product extends BaseEntity{
	
	
//************************data members************************************************************************************
	private String productName;
	
	private String description;
	
	private double weight;
	
	private int rating;
	
	private int partNumber;
	

//************************Entity Relations********************************************************************************
	//Owning & Inverse entities are mentioned respectively
	//Product & Category: for category id
	@ToString.Exclude
	@ManyToOne
	@JoinColumn(name="category_id")
	private Category productCategory;
	
	
	//Product & Vehicle= 
	@ToString.Exclude
	@JsonIgnore
	@ManyToMany(cascade= CascadeType.ALL)
	@JoinTable(name = "product_vehicle", 
	joinColumns = {@JoinColumn(name = "product_id", referencedColumnName = "id")}, 
	inverseJoinColumns = {@JoinColumn(name = "vehicle_id", referencedColumnName = "id")})
	List<Vehicle> vehicleList = new ArrayList();
	
	//Image & Product: for product id
	@ToString.Exclude
	@JsonIgnore
	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Image> image= new ArrayList();
	
	
//************************constructors************************************************************************************	

}//End of Product

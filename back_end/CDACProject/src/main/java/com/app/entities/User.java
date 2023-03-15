
package com.app.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
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
public class User extends BaseEntity{

	
//************************data members************************************************************************************
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String contactNo;

	@Enumerated(EnumType.STRING)
	private Role role;
	
	
//************************Entity Relations********************************************************************************
	//Value Type
	@Embedded
	private Address address;
	
	
	//Owning & Inverse entities are mentioned respectively
	//MyOrder & User=customer
	@ToString.Exclude
	@JsonIgnore
	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<MyOrder> myOrder_C= new ArrayList();

	
	//MyOrder & User= deliveryPerson
	@ToString.Exclude
	@JsonIgnore
	@OneToMany(mappedBy = "deliveryPerson", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<MyOrder> myOrder_D= new ArrayList();

		
	//User to Category= for admin & distributor
	@ToString.Exclude
	@JsonIgnore
	@ManyToMany(cascade= CascadeType.ALL)
	@JoinTable(name = "user_category", 
	joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")}, 
	inverseJoinColumns = {@JoinColumn(name = "category_id", referencedColumnName = "id")})
	private List<Category> categoryList = new ArrayList();
	
	
	//User to Supplied Products = product List
		@ToString.Exclude
		@JsonIgnore
		@OneToMany (mappedBy = "distributor", cascade = CascadeType.ALL, orphanRemoval = true)
		private List<SupplierProducts> supplierProducts = new ArrayList<SupplierProducts>();
//************************constructors************************************************************************************




		
	
}//End of User 

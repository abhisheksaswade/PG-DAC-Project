package com.app.entities;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
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
public class Image extends BaseEntity {


//************************data members**************************************************************************
	private String imagePath;
	
	
//************************Entity Relations**********************************************************************
	//Owning & Inverse entities are mentioned respectively
	//Images & Product	
	@ToString.Exclude
	@ManyToOne
	@JoinColumn(name="product_id")
	private Product product;
	
	
//************************constructors**************************************************************************	
	
	
}//End of image

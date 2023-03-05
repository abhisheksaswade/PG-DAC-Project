package com.app.entities;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@MappedSuperclass
@Getter
@Setter
public class BaseEntity {

//************************data members************************************************************************************			
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
}//End of BaseEntity

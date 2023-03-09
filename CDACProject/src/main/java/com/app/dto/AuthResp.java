package com.app.dto;

import com.app.entities.Role;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class AuthResp {
	
	
//************************data members************************************************************************************	
	private Long id;
	private String role;
	private String message;
	private String jwt;
	
}//End of AuthResp

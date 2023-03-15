package com.app.dto;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class ApiResponse {
	
	
//************************data members************************************************************************************	
	private String message;
	private LocalDateTime timeStamp;
	
	
//************************Constructor************************************************************************************	
	public ApiResponse(String message) {
		super();
		this.message = message;
		this.timeStamp=LocalDateTime.now();
	}
	

}//End of ApiResponse

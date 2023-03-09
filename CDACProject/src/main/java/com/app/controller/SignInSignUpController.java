package com.app.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.AuthRequest;
import com.app.dto.AuthResp;
import com.app.entities.Role;
import com.app.entities.User;
import com.app.jwt_utils.JwtUtils;
import com.app.service.UserService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/auth")
@Slf4j
@CrossOrigin("http://localhost:3000/")
public class SignInSignUpController {

	
//*********************dependency injection****************************************************************************		
	
	//dep : JWT utils : for generating JWT
	@Autowired
	private JwtUtils utils;
	
	// dep : Auth mgr
	@Autowired
	private AuthenticationManager manager;
	
	// dep : user service for handling users
	@Autowired
	private UserService userService;

	
//*********************method implementation****************************************************************************		

	// add a method to authenticate user . In case of success --send back token ,
	// o.w
	// send back err mesg
	@PostMapping("/signin")
	public ResponseEntity<?> validateUserCreateToken(@RequestBody @Valid AuthRequest request) {
		// store incoming user details(not yet validated) into Authentication object
		// Authentication i/f ---> implemented by UserNamePasswordAuthToken
		UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(request.getEmail(),
				request.getPassword());
		log.info("auth token " + authToken);
		try {
			// authenticate the credentials
			Authentication authenticatedDetails = manager.authenticate(authToken);
			log.info("auth token again " + authenticatedDetails);
			// => auth succcess
			
			Optional<User> loginuser = userService.getUser(request.getEmail());
			
			Role userRole = loginuser.get().getRole();
			String userRoleString = userRole.name();
			Long userId= loginuser.get().getId();
			
			if(userRoleString.equals("ROLE_ADMIN")) {
				return ResponseEntity.ok(new AuthResp(userId,"ROLE_ADMIN","Auth successful!", utils.generateJwtToken(authenticatedDetails)));
			}
			if(userRoleString.equals("ROLE_CUSTOMER")) {
				return ResponseEntity.ok(new AuthResp(userId,"ROLE_CUSTOMER","Auth successful!", utils.generateJwtToken(authenticatedDetails)));
			}
			if(userRoleString.equals("ROLE_DISTRIBUTOR")) {
				return ResponseEntity.ok(new AuthResp( userId,"ROLE_DISTRIBUTOR","Auth successful!", utils.generateJwtToken(authenticatedDetails)));
			}
	
			return ResponseEntity.ok(new AuthResp(userId,"ROLE_DELIVERYPERSON", "Auth successful!", utils.generateJwtToken(authenticatedDetails)));
		} catch (BadCredentialsException e) { // later replace this by a method in global exc handler
			// send back err resp code
			System.out.println("err " + e);
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
		}
	}


	// add request handling method for user registration
	@PostMapping("/signup")
	public ResponseEntity<?> userRegistration(@RequestBody @Valid User user) {
		System.out.println("PINCODE IS: "+ user.getAddress().getPincode());
		System.out.println("in reg user : user " );
		// invoke service layer method , for saving : user info + associated roles info
		return ResponseEntity.status(HttpStatus.CREATED).body(userService.addUserDetails(user));
	}
	
}//End of SignInSignUpController

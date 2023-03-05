package com.app.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.app.entities.CustomUserDetails;
import com.app.entities.User;
import com.app.repository.UserDao;

@Service
@Transactional
public class CustomUserDetailsService implements UserDetailsService {
	

//*********************dependency injection****************************************************************************	
	@Autowired
	private UserDao userRepo;
	

//********************* standard method implementation*****************************************************************	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User user = userRepo.findByEmail(email)
				.orElseThrow(() -> new UsernameNotFoundException("Invalid Email ID"));
		//use email valid
		return new CustomUserDetails(user);
	}

}//End of CustomUserDetailsService

package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.User;
import com.app.entities.Role;
import java.util.List;

public interface UserDao extends JpaRepository<User, Long> {
	
	
	//to get user list by roles
	List<User> findByRole(Enum role);
	
	

}//End of UserDao

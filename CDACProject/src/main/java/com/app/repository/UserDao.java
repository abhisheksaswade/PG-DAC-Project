package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.User;
import com.app.entities.Role;
import java.util.List;
import java.util.Optional;

public interface UserDao extends JpaRepository<User, Long> {
	
	
	//to get user list by roles
	List<User> findByRole(Enum role);
	
	//to get user by his email
	Optional<User> findByEmail(String email);
	

}//End of UserDao

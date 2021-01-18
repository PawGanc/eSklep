package com.moviestore;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.moviestore.domain.User;
import com.moviestore.domain.security.Role;
import com.moviestore.domain.security.UserRole;
import com.moviestore.service.UserService;
import com.moviestore.utility.SecurityUtility;

@SpringBootApplication
public class MoviestoreApplication implements CommandLineRunner {

	@Autowired
	private UserService userService;
	
	public static void main(String[] args) {
		SpringApplication.run(MoviestoreApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception{
		User user1 = new User();
		user1.setFirstName("Jan");
		user1.setLastName("Kowalski");
		user1.setUsername("j");
		user1.setPassword(SecurityUtility.passwordEncoder().encode("k"));
		user1.setEmail("JKowalski@o2.pl");
		Set<UserRole> userRoles = new HashSet<>();
		Role role1 = new Role();
		role1.setRoleId(1);
		role1.setName("ROLE_USER");
		userRoles.add(new UserRole(user1, role1));
		
		userService.createUser(user1, userRoles);
	}

}

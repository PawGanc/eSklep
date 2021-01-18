package com.moviestore.repository;

import org.springframework.data.repository.CrudRepository;

import com.moviestore.domain.User;

public interface UserRepository extends CrudRepository<User, Long> {
	User findByUsername(String username);
	
	User findByEmail(String email);

}

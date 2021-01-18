package com.moviestore.repository;

import org.springframework.data.repository.CrudRepository;

import com.moviestore.domain.security.Role;

public interface RoleRepository extends CrudRepository<Role, Long>{
	Role findByname(String name);

}

package com.moviestore.service;

import java.util.Set;

import com.moviestore.domain.User;
import com.moviestore.domain.security.PasswordResetToken;
import com.moviestore.domain.security.UserRole;

public interface UserService {
	
	PasswordResetToken getPasswordResetToken(final String token);
	
	void createPasswordResetTokenForUser(final User user, final String token);
	
	User findByUsername(String username);
	
	User findByEmail(String email);
	
	User createUser(User user, Set<UserRole> userRoles) throws Exception;
	
	User save(User user);
	
	

}

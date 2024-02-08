package com.blog.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.blog.entities.User;
import com.blog.exception.UserNotFoundException;
import com.blog.repository.UserRepo;

@Service
public class CustomUserDetailService implements UserDetailsService {
	@Autowired
	private UserRepo userRepo;

	@Override
	public UserDetails loadUserByUsername(String username) {
		User user = this.userRepo.findByEmail(username)
				.orElseThrow(() -> new UserNotFoundException("User", "Email", username));
		return user;
	}

}

package com.blog.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blog.exception.ApiException;
import com.blog.payloads.JwtAuthRequest;
import com.blog.payloads.JwtAuthResponse;
import com.blog.payloads.UserDto;
import com.blog.security.CustomUserDetailService;
import com.blog.security.JwtTokenHelper;
import com.blog.services.UserService;

@RestController
@RequestMapping("/api/v1/auth/")
public class AuthController {
	@Autowired
	private JwtTokenHelper jwtTokenHelper;
	@Autowired
	private CustomUserDetailService userDetailsService;
	@Autowired
	private AuthenticationManager authenticatinoManager;
	@Autowired
	private UserService userSerice;

	@PostMapping("/login")
	public ResponseEntity<JwtAuthResponse> createToken(@RequestBody JwtAuthRequest request) throws Exception {
		try {
			this.authenticatinoManager.authenticate(
					new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
		} catch (Exception e) {
			System.out.println("Invalid Details!!");
			throw new ApiException("Invalid Username & Password");
		}

		UserDetails userDetails = this.userDetailsService.loadUserByUsername(request.getUsername());

		String token = this.jwtTokenHelper.generateToken(userDetails);

		System.out.println("Token: " + token);

		JwtAuthResponse authResponse = new JwtAuthResponse();

		authResponse.setToken(token);

		return new ResponseEntity<JwtAuthResponse>(authResponse, HttpStatus.OK);
	}
	
//	register new user api
	@PostMapping("/register")
	public ResponseEntity<UserDto> registerUser(@RequestBody UserDto userDto){
		UserDto registeredUser = this.userSerice.registerNewUser(userDto);
		return new ResponseEntity<UserDto>(registeredUser, HttpStatus.CREATED);
	}
}

package com.blog.payloads;

import java.util.HashSet;
import java.util.Set;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {
	private int id;
	@NotEmpty
	@Size(min = 4, message = "Username must be of 4 characters..")
	private String name;
	@Email(message = "Email address is not valid!!")
	@Pattern(regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$", message = "Invaid Email")
	private String email;
	@NotEmpty
	@Pattern(regexp = "(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{5,}", message = "Use correct password")
	private String password;
	@NotEmpty
	private String about;
	private Set<RoleDto> roles = new HashSet<>();
}

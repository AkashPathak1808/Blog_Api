package com.blog.exception;

import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("serial")
@Getter
@Setter
public class UserNotFoundException extends RuntimeException {
	private String resourceName;
	private String fieldName;
	private String fieldValue;

	public UserNotFoundException(String resourceName, String fieldName, String fieldValue) {
		super(String.format("%s not found with %s: %s", resourceName, fieldName, fieldValue));
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
	}
}

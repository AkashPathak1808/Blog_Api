package com.blog.exception;

@SuppressWarnings("serial")
public class ApiException extends RuntimeException {

	public ApiException() {
		super();
	}

	public ApiException(String message) {
		super(message);
	}

}

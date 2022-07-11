package com.se.spring.rest;

public class CustomNotFoundException extends RuntimeException { // Tạo một NotFoundException riêng
	public CustomNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public CustomNotFoundException(String message) {
		super(message);
	}

	public CustomNotFoundException(Throwable cause) {
		super(cause);
	}
}

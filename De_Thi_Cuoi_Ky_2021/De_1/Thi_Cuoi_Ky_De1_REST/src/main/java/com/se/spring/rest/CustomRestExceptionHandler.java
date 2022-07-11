package com.se.spring.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomRestExceptionHandler { // Tạo một RestException riêng
	@ExceptionHandler
	public ResponseEntity<CustomErrorResponse> handleException(Exception exc) {
		CustomErrorResponse error = new CustomErrorResponse();
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setMessage(exc.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		return new ResponseEntity<CustomErrorResponse>(error, HttpStatus.BAD_REQUEST);
	}
}

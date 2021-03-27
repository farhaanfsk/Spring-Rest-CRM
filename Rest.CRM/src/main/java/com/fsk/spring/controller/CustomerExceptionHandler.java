package com.fsk.spring.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.fsk.spring.entity.CustomerErrorResponse;
import com.fsk.spring.exceptions.CustomerNotFound;

@ControllerAdvice
public class CustomerExceptionHandler {

	@ExceptionHandler
	public ResponseEntity<CustomerErrorResponse> customerNotFound(CustomerNotFound ex) {
		CustomerErrorResponse response = new CustomerErrorResponse(HttpStatus.NOT_FOUND.value(), ex.getMessage());
		return new ResponseEntity<CustomerErrorResponse>(response, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler
	public ResponseEntity<CustomerErrorResponse> badRequest(Exception ex) {
		CustomerErrorResponse response = new CustomerErrorResponse(HttpStatus.BAD_REQUEST.value(), ex.getMessage());
		return new ResponseEntity<CustomerErrorResponse>(response, HttpStatus.BAD_REQUEST);
	}
}

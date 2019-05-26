package com.appointment.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.appointment.exception.UserException;
import com.appointment.exception.UserNotFoundException;
import com.appointment.response.Response;

@ControllerAdvice
public class UserControllerAdvice {

	@ExceptionHandler(UserException.class)
	public ResponseEntity<Response> responseEntity(UserException userException) {
		Response response = new Response(HttpStatus.INTERNAL_SERVER_ERROR.value(), userException.getMessage());
		return new ResponseEntity<Response>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<Response> responseEntity(UserNotFoundException userNotFoundException) {
		Response response = new Response(HttpStatus.INTERNAL_SERVER_ERROR.value(), userNotFoundException.getMessage());
		return new ResponseEntity<Response>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}

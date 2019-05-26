package com.appointment.exception;

public class UserException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public UserException(String exception) {
		super(exception);
	}
}

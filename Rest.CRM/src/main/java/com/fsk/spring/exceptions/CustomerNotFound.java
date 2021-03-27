package com.fsk.spring.exceptions;

public class CustomerNotFound extends RuntimeException {

	private static final long serialVersionUID = -1187507777026587405L;

	public CustomerNotFound() {
	}

	public CustomerNotFound(String message) {
		super(message);
	}

	public CustomerNotFound(Throwable cause) {
		super(cause);
	}

	public CustomerNotFound(String message, Throwable cause) {
		super(message, cause);
	}

	public CustomerNotFound(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}

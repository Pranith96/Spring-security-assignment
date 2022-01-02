package com.springbootmvc.a4.exception;

public class StoreNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public StoreNotFoundException(String message) {
		super(message);
	}
}

package com.web.exep;

public class Myexception extends Exception {
	private String message;

	public Myexception(String message) {
		super();
		this.message=message;
		
	}
	public String getMessage() {
		return message;
	}

}

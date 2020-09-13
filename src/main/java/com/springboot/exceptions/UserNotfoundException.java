package com.springboot.exceptions;

public class UserNotfoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unused")
	private String msg;

	public UserNotfoundException(String msg) {
		super();
		this.msg = msg;
	}

}

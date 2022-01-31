package com.boot.server.exam.exception;

public class UserFoundException extends Exception {

	public UserFoundException() {

		super("User with this Username is already exist !! try with another Username");
	}

	public UserFoundException(String msg) {
		super(msg);
	}

}

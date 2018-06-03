package com.oakwood.utility.exception;
/**
 * 
 * @author jtinio
 * @since 06/02/2018
 */
public class InvalidLoginCredentialsException extends Exception {

	private static final long serialVersionUID = -7078520463430782044L;

	public InvalidLoginCredentialsException() {
	}

	public InvalidLoginCredentialsException(String message) {
		super(message);
	}

	public InvalidLoginCredentialsException(Throwable throwable) {
		super(throwable);
	}

	public InvalidLoginCredentialsException(String message, Throwable throwable) {
		super(message, throwable);
	}

}
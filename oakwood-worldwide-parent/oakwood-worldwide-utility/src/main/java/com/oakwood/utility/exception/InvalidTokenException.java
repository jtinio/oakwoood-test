package com.oakwood.utility.exception;

/**
 * 
 * @author jtinio
 * @since 06/02/2018
 */
public class InvalidTokenException extends Exception {

	private static final long serialVersionUID = 8011549603928594943L;

	public InvalidTokenException() {
	}

	public InvalidTokenException(String message) {
		super(message);
	}

	public InvalidTokenException(Throwable throwable) {
		super(throwable);
	}

	public InvalidTokenException(String message, Throwable throwable) {
		super(message, throwable);
	}

}

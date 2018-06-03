package com.oakwood.utility.exception;

/**
 * 
 * @author jtinio
 * @since 06/02/2018
 */
public class UsernameExistException extends Exception {

	private static final long serialVersionUID = -3534761371308818289L;

	public UsernameExistException() {
	}

	public UsernameExistException(String message) {
		super(message);
	}

	public UsernameExistException(Throwable throwable) {
		super(throwable);
	}

	public UsernameExistException(String message, Throwable throwable) {
		super(message, throwable);
	}

}

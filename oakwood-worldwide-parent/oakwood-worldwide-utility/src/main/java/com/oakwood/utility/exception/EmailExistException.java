package com.oakwood.utility.exception;

/**
 * 
 * @author jtinio
 * @since 06/02/2018
 */
public class EmailExistException extends Exception {

	private static final long serialVersionUID = -466191841582041531L;

	public EmailExistException() {
	}

	public EmailExistException(String message) {
		super(message);
	}

	public EmailExistException(Throwable throwable) {
		super(throwable);
	}

	public EmailExistException(String message, Throwable throwable) {
		super(message, throwable);
	}

}

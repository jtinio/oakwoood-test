package com.oakwood.utility.exception;

import org.springframework.validation.Errors;

/**
 * 
 * @author jtinio
 * @since 06/02/2018
 */
public class ResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -5234261903759267829L;

	private Errors errors;

	public ResourceNotFoundException() {
		super();
	}

	public ResourceNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public ResourceNotFoundException(String message, Errors errors) {
		super(message);
		this.errors = errors;
	}

	public Errors getErrors() {
		return errors;
	}

}

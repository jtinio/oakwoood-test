package com.oakwood.web.api.exception;

import org.springframework.validation.Errors;

/**
 * 
 * @author jtinio
 * @since 06/02/2018
 */
public class InvalidRestRequestException extends RuntimeException {

	private static final long serialVersionUID = -7267237185047215329L;

	private Errors errors;

	public InvalidRestRequestException(String message, Errors errors) {
		super(message);
		this.errors = errors;
	}

	public Errors getErrors() {
		return errors;
	}
}
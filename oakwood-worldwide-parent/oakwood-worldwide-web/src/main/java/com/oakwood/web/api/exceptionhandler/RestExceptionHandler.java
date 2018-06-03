package com.oakwood.web.api.exceptionhandler;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.boot.context.config.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.oakwood.dto.rest.resource.ErrorResource;
import com.oakwood.dto.rest.resource.FieldErrorResource;
import com.oakwood.dto.rest.resource.MessageResource;
import com.oakwood.utility.exception.EmailExistException;
import com.oakwood.utility.exception.UsernameExistException;
import com.oakwood.web.api.exception.InvalidRestRequestException;
import com.oakwood.web.resource.ApiError;

/**
 * 
 * @author Johnlery
 * @since 01/19/2017
 */
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler({ InvalidRestRequestException.class })
	@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
	@ResponseBody
	protected ErrorResource handleInvalidRequest(InvalidRestRequestException invalidRestRequestException) {
		final List<FieldErrorResource> fieldErrorResources = invalidRestRequestException.getErrors().getFieldErrors()
				.stream().map(fieldError -> generateFieldErrorResource(fieldError)).collect(Collectors.toList());
		final ErrorResource error = new ErrorResource("422", invalidRestRequestException.getMessage());
		error.setFieldErrors(fieldErrorResources);
		return error;
	}

	private FieldErrorResource generateFieldErrorResource(final FieldError fieldError) {
		final FieldErrorResource fieldErrorResource = new FieldErrorResource();
		// fieldErrorResource.setResource(fieldError.getObjectName());
		fieldErrorResource.setField(fieldError.getField());
		// fieldErrorResource.setCode(fieldError.getCode());
		fieldErrorResource.setMessage(fieldError.getDefaultMessage());
		return fieldErrorResource;
	}

	@ExceptionHandler({ ResourceNotFoundException.class })
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ResponseBody
	public ApiError handleResourceNotFoundException(ResourceNotFoundException resourceNotFoundException) {
		return new ApiError(HttpStatus.NOT_FOUND,
				(resourceNotFoundException.getMessage() != null) ? resourceNotFoundException.getMessage()
						: "Resource not found",
				"Resource not found");
	}

	@ExceptionHandler({ UsernameExistException.class, EmailExistException.class })
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	public MessageResource usernameAndEmailExistException(Exception exception) {
		return new MessageResource(exception.getMessage());
	}

}
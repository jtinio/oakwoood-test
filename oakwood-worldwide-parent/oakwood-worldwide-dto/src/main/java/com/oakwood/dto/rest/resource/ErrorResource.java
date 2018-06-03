package com.oakwood.dto.rest.resource;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
/**
 * 
 * @author tinio
 * @since 06/02/2018
 */
public class ErrorResource extends Resource {
	
	@JsonProperty("fieldErrors")
	private List<FieldErrorResource> fieldErrors;

	public ErrorResource() {
	}

	public ErrorResource(String code, String message) {
		super(code, message);
	}

	public List<FieldErrorResource> getFieldErrors() {
		return fieldErrors;
	}

	public void setFieldErrors(List<FieldErrorResource> fieldErrors) {
		this.fieldErrors = fieldErrors;
	}
}
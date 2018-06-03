package com.oakwood.dto.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.oakwood.dto.base.BaseDto;

/**
 * 
 * @author tinio
 * @since 06/02/2018
 */
public class UserDto extends BaseDto {

	@JsonProperty("id")
	private Integer id;

	@JsonProperty("username")
	private String username;

	@JsonProperty("firstName")
	private String firstName;

	@JsonProperty("lastName")
	private String lastName;

	@JsonProperty("email")
	private String email;

	public UserDto() {
	}

	public UserDto(Integer id, String username, String firstName, String lastName, String email) {
		super();
		this.id = id;
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}

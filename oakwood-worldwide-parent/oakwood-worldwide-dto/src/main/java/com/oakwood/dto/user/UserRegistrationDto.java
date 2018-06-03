package com.oakwood.dto.user;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.oakwood.dto.base.BaseDto;

/**
 * 
 * @author jtinio
 * @since 06/02/2018
 */
public class UserRegistrationDto extends BaseDto {

	@JsonProperty("id")
	private Integer id;

	@JsonProperty("username")
	@NotNull(message = "{NotNull.username}")
	@NotEmpty(message = "{NotEmpty.username}")
	@Size(min = 5, max = 35, message = "{Size.username}")
	@Pattern(regexp = "^[0-9a-zA-Z]+$", message = "{Pattern.username}")
	private String username;

	@JsonProperty("password")
	@NotNull(message = "{NotNull.password}")
	@NotEmpty(message = "{NotEmpty.password}")
	@Size(min = 8, max = 20, message = "{Size.password}")
	private String password;

	@JsonProperty("matchingPassword")
	@NotNull(message = "{NotNull.matchingPassword}")
	@NotEmpty(message = "{NotEmpty.matchingPassword}")
	@Size(min = 8, max = 20, message = "{Size.matchingPassword}")
	private String matchingPassword;

	@JsonProperty("lastName")
	@NotNull(message = "{NotNull.lastName}")
	@NotEmpty(message = "{NotEmpty.lastName}")
	@Size(min = 2, max = 35, message = "{Size.lastName}")
	private String lastName;

	@JsonProperty("firstName")
	@NotNull(message = "{NotNull.firstName}")
	@NotEmpty(message = "{NotEmpty.firstName}")
	@Size(min = 2, max = 35, message = "{Size.firstName}")
	private String firstName;

	@JsonProperty("email")
	@NotNull(message = "{NotNull.email}")
	@NotEmpty(message = "{NotEmpty.email}")
	@Email
	private String email;

	public UserRegistrationDto() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMatchingPassword() {
		return matchingPassword;
	}

	public void setMatchingPassword(String matchingPassword) {
		this.matchingPassword = matchingPassword;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}

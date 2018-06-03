package com.oakwood.dto.user;

/**
 * 
 * @author tinio
 * @since 06/02/2018
 */
public class UserLoginDto {

	private Integer id;
	private String password;

	public UserLoginDto(Integer id, String password) {
		super();
		this.id = id;
		this.password = password;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}

package com.oakwood.model.user;

import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.oakwood.dto.user.UserDto;
import com.oakwood.model.base.BaseEntity;
import com.oakwood.model.role.Role;

/**
 * @author jtinio
 * @since 06/02/2018
 */
@Entity
@DynamicUpdate
@DynamicInsert
@Table(name = "UserAccount")
@SequenceGenerator(name = "EntitySequenceGenerator", sequenceName = "seq_user", allocationSize = 1)
@AttributeOverrides({ @AttributeOverride(name = "id", column = @Column(name = "USER_Id")),
		@AttributeOverride(name = "genesis", column = @Column(name = "USER_Genesis")),
		@AttributeOverride(name = "update", column = @Column(name = "USER_Update")), })
@SqlResultSetMapping(name = "UserDtoMapping", classes = @ConstructorResult(targetClass = UserDto.class, columns = {
		@ColumnResult(name = "id", type = Integer.class), @ColumnResult(name = "username", type = String.class),
		@ColumnResult(name = "firstName", type = String.class), @ColumnResult(name = "lastName", type = String.class),
		@ColumnResult(name = "email", type = String.class) }))
@NamedNativeQueries({
		@NamedNativeQuery(name = "User.findUserById", query = "SELECT USER_Id as id, USER_Username as username, USER_FirstName as firstName, USER_LastName as lastName, USER_Email as email FROM User where USER_Id = ?1 ", resultSetMapping = "UserDtoMapping"),})
public class User extends BaseEntity {

	private static final long serialVersionUID = 8559492030672421962L;

	@Column(name = "USER_Username")
	@JsonProperty("username")
	private String username;

	@Column(name = "USER_Password")
	@JsonProperty("password")
	private byte[] password;

	@Column(name = "USER_FirstName")
	@JsonProperty("firstName")
	private String firstName;

	@Column(name = "USER_LastName")
	@JsonProperty("lastName")
	private String lastName;

	@Column(name = "USER_Email")
	@JsonProperty("email")
	private String email;

	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
	@JoinTable(name = "User_Role", joinColumns = @JoinColumn(name = "USER_Id", referencedColumnName = "USER_Id", nullable = false, updatable = false), inverseJoinColumns = @JoinColumn(name = "ROLE_Id", referencedColumnName = "ROLE_Id", nullable = false, updatable = false))
	private List<Role> roles;

	public User() {
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public byte[] getPassword() {
		return password;
	}

	public void setPassword(byte[] password) {
		this.password = password;
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

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

}

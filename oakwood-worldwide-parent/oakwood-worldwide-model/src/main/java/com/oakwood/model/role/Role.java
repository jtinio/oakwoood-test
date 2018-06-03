package com.oakwood.model.role;

import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.oakwood.model.base.BaseEntity;
import com.oakwood.model.permission.Permission;
import com.oakwood.model.user.User;

/**
 * 
 * @author jtinio
 * @since 06/02/2018
 */
@Entity
@DynamicUpdate
@DynamicInsert
@Table(name = "Role")
@SequenceGenerator(name = "EntitySequenceGenerator", sequenceName = "seq_role", allocationSize = 1)
@AttributeOverrides({ @AttributeOverride(name = "id", column = @Column(name = "ROLE_Id")),
		@AttributeOverride(name = "genesis", column = @Column(name = "ROLE_Genesis")),
		@AttributeOverride(name = "update", column = @Column(name = "ROLE_Update")), })
public class Role extends BaseEntity {

	private static final long serialVersionUID = -1029359575058102170L;

	@Column(name = "ROLE_Name")
	@JsonProperty("name")
	private String name;

	@Column(name = "ROLE_Description")
	@JsonProperty("description")
	private String description;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "Role_Permission", joinColumns = @JoinColumn(name = "ROLE_Id", referencedColumnName = "ROLE_Id", nullable = false), 
		inverseJoinColumns = @JoinColumn(name = "PERM_Id", referencedColumnName = "PERM_Id", nullable = false))
	private List<Permission> permissions;

	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "roles")
	private List<User> users;

	public Role() {
	}

	public Role(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Permission> getPermissions() {
		return permissions;
	}

	public void setPermissions(List<Permission> permissions) {
		this.permissions = permissions;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

}

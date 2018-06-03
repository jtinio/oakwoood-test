package com.oakwood.model.permission;

import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Immutable;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.oakwood.model.base.BaseEntity;
import com.oakwood.model.role.Role;

/**
 * 
 * @author jtinio
 * @since 06/02/2018
 */
@Entity
@Cacheable
@Immutable
@DynamicUpdate
@DynamicInsert
@Table(name = "Permission")
@SequenceGenerator(name = "EntitySequenceGenerator", sequenceName = "seq_permission", allocationSize = 1)
@AttributeOverrides({ @AttributeOverride(name = "id", column = @Column(name = "PERM_Id")),
		@AttributeOverride(name = "genesis", column = @Column(name = "PERM_Genesis")),
		@AttributeOverride(name = "update", column = @Column(name = "PERM_Update")), })
public class Permission extends BaseEntity {

	private static final long serialVersionUID = 6961025969743735822L;
	
	@Column(name = "PERM_Name")
	@JsonProperty("name")
	private String name;
	
	@Column(name = "PERM_Label")
	@JsonProperty("label")
	private String label;
	
	@Column(name = "PERM_Description")
	@JsonProperty("description")
	private String description;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.MERGE, CascadeType.PERSIST,
			CascadeType.DETACH }, mappedBy = "permissions")
	private List<Role> roles;

	public Permission() {
	}

	public Permission(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

}

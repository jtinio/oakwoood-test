package com.oakwood.model.base;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Abstract base entity class the contains the common fields of all entities
 * <br>
 * <br>
 * <code>id</code> - the primary key if the data<br>
 * <code>genesis</code> - the created date and time<br>
 * <code>update</code> - the updated date and time<br>
 * 
 * @author jtinio
 * @since 06/02/2018
 */
@MappedSuperclass
@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class BaseEntity extends BaseGenesisUpdate {

	private static final long serialVersionUID = -3718346955999269176L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EntitySequenceGenerator")
	@JsonProperty("id")
	private Integer id;

	public BaseEntity() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}

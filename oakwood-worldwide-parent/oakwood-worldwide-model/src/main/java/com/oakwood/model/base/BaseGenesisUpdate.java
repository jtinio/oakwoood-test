package com.oakwood.model.base;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.oakwood.dto.util.LocalDateTimeDeserializer;
import com.oakwood.dto.util.LocalDateTimeSerializer;

/**
 * 
 * @author jtinio
 * @since 06/02/2018
 */
@MappedSuperclass
@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class BaseGenesisUpdate implements Serializable {

	private static final long serialVersionUID = 5083713544032513390L;

	@JsonFormat(pattern = "MM/dd/yyyy HH:mm:ss")
	@JsonSerialize(using = LocalDateTimeSerializer.class)
	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	private LocalDateTime genesis;
	@JsonFormat(pattern = "MM/dd/yyyy HH:mm:ss")
	@JsonSerialize(using = LocalDateTimeSerializer.class)
	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	private LocalDateTime update;

	public BaseGenesisUpdate() {
	}

	@PrePersist
	protected void generateGenesisUtcTime() {
		this.genesis = ZonedDateTime.now(ZoneOffset.UTC).toLocalDateTime();
	}

	@PreUpdate
	protected void generateUpdateUtcTime() {
		this.update = ZonedDateTime.now(ZoneOffset.UTC).toLocalDateTime();
	}

	public LocalDateTime getGenesis() {
		return genesis;
	}

	public void setGenesis(LocalDateTime genesis) {
		this.genesis = genesis;
	}

	public LocalDateTime getUpdate() {
		return update;
	}

	public void setUpdate(LocalDateTime update) {
		this.update = update;
	}

}

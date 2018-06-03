package com.oakwood.dto.util;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

/**
 * Custom {@link JsonDeserializer} for {@link LocalDateTime} fields
 * 
 * Deserialize Json LocalDateTime field the contains a pattern of "MM/dd/yyyy
 * HH:mm:ss"
 * 
 * @author jtinio
 * @since 06/02/2018
 */
public class LocalDateTimeDeserializer extends JsonDeserializer<LocalDateTime> {

	/**
	 * @see JsonDeserializer#deserialize(JsonParser, DeserializationContext)
	 */
	@Override
	public LocalDateTime deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
		return LocalDateTime.parse(p.getValueAsString(), DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss"));
	}

}
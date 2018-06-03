package com.oakwood.dto.util;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/**
 * Custom {@link JsonSerializer} for {@link LocalDateTime} fields
 * 
 * Serialize Json LocalDateTime into String with a pattern of "MM/dd/yyyy
 * HH:mm:ss"
 * 
 * @author jtinio
 * @since 06/02/2018
 */
public class LocalDateTimeSerializer extends JsonSerializer<LocalDateTime> {

	/**
	 * @see JsonSerializer#serialize(Object, JsonGenerator, SerializerProvider)
	 */
	@Override
	public void serialize(LocalDateTime value, JsonGenerator gen, SerializerProvider serializers)
			throws IOException, JsonProcessingException {
		gen.writeString(value.format(DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss")));
	}
}

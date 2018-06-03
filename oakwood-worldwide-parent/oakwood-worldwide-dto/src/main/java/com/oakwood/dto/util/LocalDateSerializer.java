package com.oakwood.dto.util;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/**
 * Custom {@link JsonSerializer} for {@link LocalDate} fields
 * 
 * Serialize Json LocalDate into String with a pattern of "MM/dd/yyyy"
 * 
 * @author jtinio
 * @since 06/02/2018
 */
public class LocalDateSerializer extends JsonSerializer<LocalDate> {

	/**
	 * @see JsonSerializer#serialize(Object, JsonGenerator, SerializerProvider)
	 */
	@Override
	public void serialize(LocalDate value, JsonGenerator gen, SerializerProvider serializers)
			throws IOException, JsonProcessingException {
		gen.writeString(value.format(DateTimeFormatter.ofPattern("MM/dd/yyyy")));
	}
}

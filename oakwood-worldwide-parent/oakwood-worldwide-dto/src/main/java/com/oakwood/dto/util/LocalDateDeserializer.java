package com.oakwood.dto.util;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

/**
 * Custom {@link JsonDeserializer} for {@link LocalDate} fields
 * 
 * Deserialize Json LocalDate field the contains a pattern of "MM/dd/yyyy"
 * 
 * @author jtinio
 * @since 06/02/2018
 */
public class LocalDateDeserializer extends JsonDeserializer<LocalDate> {

	/**
	 * @see JsonDeserializer#deserialize(JsonParser, DeserializationContext)
	 */
	@Override
	public LocalDate deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
		return LocalDate.parse(p.getValueAsString(), DateTimeFormatter.ofPattern("MM/dd/yyyy"));
	}

}
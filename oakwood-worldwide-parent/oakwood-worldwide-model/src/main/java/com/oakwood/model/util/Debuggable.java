package com.oakwood.model.util;

import java.lang.reflect.Field;
import java.util.StringJoiner;
/**
 * Uses the reflection API to get the access to the object's fields<br/>
 * and provides a decent toString() implementation for the object that prints the fields values.
 * @author jtinio
 * @since 06/02/2018
 */
public interface Debuggable {
	
	/**
	 * Print Objects toString method
	 * @return String
	 */
	default String debug() {
		StringJoiner stringJoiner = new StringJoiner(",", "[", "]");
		Field[] fields = this.getClass().getDeclaredFields();
		for (Field field : fields) {
			field.setAccessible(true);
			try {
				stringJoiner.add(field.getName() + " = " + field.get(this));
			} catch (IllegalArgumentException | IllegalAccessException e) {
				throw new RuntimeException(e);
			}
		}
		return stringJoiner.toString();
	}
	
}
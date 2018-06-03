package com.oakwood.model.util;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * Annotation Type for class introduction based on<br/>
 * https://docs.oracle.com/javase/tutorial/java/annotations/declaring.html
 * 
 * @author jtinio
 * @since 06/02/2018
 */
@Target(value = { ElementType.TYPE })
@Documented
public @interface ClassPreamble {

	String author();

	String date();

	int currentRevision() default 1;

	String lastModified() default "N/A";

	String lastModifiedBy() default "N/A";

	String[] reviewers();

}
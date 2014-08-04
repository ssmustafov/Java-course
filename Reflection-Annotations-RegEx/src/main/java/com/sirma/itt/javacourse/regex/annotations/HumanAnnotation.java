package com.sirma.itt.javacourse.regex.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Annotation for ordering Human objects with human's age.
 * 
 * @author Sinan
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface HumanAnnotation {

	/**
	 * Unique number for ordering objects.
	 */
	int age() default 0;

}

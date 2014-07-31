package com.sirma.itt.javacourse.regex.regex;

import java.util.regex.Pattern;

/**
 * Holds methods for validating email.
 * 
 * @author smustafov
 */
public final class EmailValidator {

	/**
	 * Protects from instantiation.
	 */
	private EmailValidator() {

	}

	/**
	 * Checks if given string is valid email.
	 * 
	 * @param email
	 *            - the email to be checked if its valid
	 * @return true if the given string is valid email or false if the given string is not valid
	 *         email
	 */
	public static boolean isValidEmail(String email) {
		if (email == null) {
			throw new IllegalArgumentException("The given string is null");
		}

		final String regEx = "^[A-za-z][A-Za-z0-9.-]*+@[A-Za-z][A-Za-z0-9.-]*";

		if (Pattern.matches(regEx, email)) {
			return true;
		}

		return false;
	}

}

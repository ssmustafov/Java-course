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
	 * Checks if given string is valid email. Email starts with letter followed by any of letters,
	 * digits, dot or dash, after that '@', after that must start with letter, after that any
	 * letters, digits, dot or dash and at the end must follow a single dot followed by domain with
	 * at least 2 letters.
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

		final String regEx = "([a-zA-Z])([a-zA-Z0-9.-]*)([a-zA-Z0-9])@([a-zA-Z])([a-zA-Z0-9.-]*)\\.([a-zA-Z]{2,})";

		return Pattern.matches(regEx, email);
	}
}

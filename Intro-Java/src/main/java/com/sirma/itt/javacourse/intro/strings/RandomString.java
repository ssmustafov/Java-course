package com.sirma.itt.javacourse.intro.strings;

/**
 * Generates random strings.
 * 
 * @author smustafov
 */
public class RandomString {

	// TODO: add method for generating string with ascii

	/**
	 * Generates random string. It consists of a-z, A-Z, 0-9 symbols.
	 * 
	 * @param length
	 *            the length of the string to be generated
	 * @return the generated string
	 */
	public String generateString(int length) {
		if (length <= 0) {
			throw new IllegalArgumentException("The string's size cannot be under zero : " + length);
		}

		final String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		StringBuilder generatedString = new StringBuilder(length);

		for (int i = 0; i < length; i++) {
			int randomNumber = (int) Math.floor(Math.random() * characters.length());
			char randomChar = characters.charAt(randomNumber);
			generatedString.append(randomChar);
		}

		return generatedString.toString();
	}

}

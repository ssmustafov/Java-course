package com.sirma.itt.javacourse.intro.strings;

/**
 * Class for generating strings.
 * 
 * @author smustafov
 */
public class RandomString {

	/**
	 * Method for generating random string.
	 * 
	 * @param length
	 *            the length of the string to be generated
	 * @return the generated string
	 */
	public String generateString(int length) {
		if (length <= 0) {
			throw new IllegalArgumentException("The string's size cannot be under zero : " + length);
		}

		String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		StringBuilder generatedString = new StringBuilder(length);

		for (int i = 0; i < length; i++) {
			int randomNumber = (int) Math.floor(Math.random() * characters.length());
			char randomChar = characters.charAt(randomNumber);
			generatedString.append(randomChar);
		}

		return generatedString.toString();
	}

}

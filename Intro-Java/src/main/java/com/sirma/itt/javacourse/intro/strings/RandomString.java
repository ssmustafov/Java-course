package com.sirma.itt.javacourse.intro.strings;

/**
 * Generates random strings.
 * 
 * @author smustafov
 */
public class RandomString {

	/**
	 * Generates random number.
	 * 
	 * @param end
	 *            the end range of generated value
	 * @return random number
	 */
	private int getRandomNumber(int end) {
		return (int) Math.floor(Math.random() * end);
	}

	/**
	 * Generates random string. It consists of a-z, A-Z, 0-9 symbols and uses ASCII codes.
	 * 
	 * @param length
	 *            the length of the string to be generated
	 * @return the generated random string
	 */
	public String generateStringAscii(int length) {
		if (length <= 0) {
			throw new IllegalArgumentException("The string's size cannot be under zero : " + length);
		}
		final int[] asciiCodes = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70,
				71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97,
				98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114,
				115, 116, 117, 118, 119, 120, 121, 122 };
		StringBuilder generatedString = new StringBuilder(length);

		for (int i = 0; i < length; i++) {
			int randomNumber = getRandomNumber(asciiCodes.length);
			char ch = (char) asciiCodes[randomNumber];
			generatedString.append(ch);
		}

		return generatedString.toString();
	}

	/**
	 * Generates random string. It consists of a-z, A-Z, 0-9 symbols.
	 * 
	 * @param length
	 *            the length of the string to be generated
	 * @return the generated random string
	 */
	public String generateString(int length) {
		if (length <= 0) {
			throw new IllegalArgumentException("The string's size cannot be under zero : " + length);
		}

		final String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		StringBuilder generatedString = new StringBuilder(length);

		for (int i = 0; i < length; i++) {
			int randomNumber = getRandomNumber(characters.length());
			char randomChar = characters.charAt(randomNumber);
			generatedString.append(randomChar);
		}

		return generatedString.toString();
	}

}

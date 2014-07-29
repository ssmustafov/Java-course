package com.sirma.itt.javacourse.intro.strings;

import java.util.Random;

/**
 * Generates random strings.
 * 
 * @author smustafov
 */
public class RandomString {

	private static final String STRING_SIZE_ERROR_MESSAGE = "The string's size cannot be equal or under zero. It was given : ";
	private static final int SYMBOL_TYPE_DIGITS = 0;
	private static final int SYMBOL_TYPE_UP_LETTERS = 1;
	private static final int SYMBOL_TYPE_SMALL_LETTERS = 2;
	private final Random randomGenerator = new Random();

	/**
	 * Generates and returns random number.
	 * 
	 * @param end
	 *            the maximum range of generated value
	 * @return random number
	 */
	private int getRandomNumber(int end) {
		return randomGenerator.nextInt(end);
	}

	/**
	 * Generates and returns random number with given range.
	 * 
	 * @param min
	 *            the minimum range of generated value
	 * @param max
	 *            the maximum range of generated value
	 * @return random number
	 */
	private int getRandomNumberRange(int min, int max) {
		return randomGenerator.nextInt(max - min) + min;
	}

	/**
	 * Generates and returns random string. It consists of a-z, A-Z, 0-9 symbols and uses ASCII
	 * codes.
	 * 
	 * @param length
	 *            the length of the string to be generated
	 * @return the generated random string
	 */
	public String generateStringAsciiCode(int length) {
		if (length <= 0) {
			throw new IllegalArgumentException(STRING_SIZE_ERROR_MESSAGE + length);
		}

		final int digitsAsciiStartCode = 48;
		final int digitsAsciiEndCode = 57;
		final int upperLettersAsciiStartCode = 65;
		final int upperLettersAsciiEndCode = 90;
		final int smallLettersAsciiStartCode = 97;
		final int smallLettersAsciiEndCode = 122;

		StringBuilder generatedString = new StringBuilder();
		for (int i = 0; i < length; i++) {
			int symbolType = getRandomNumber(3);
			if (symbolType == SYMBOL_TYPE_DIGITS) {
				int randomAsciiCode = getRandomNumberRange(digitsAsciiStartCode, digitsAsciiEndCode);
				generatedString.append((char) randomAsciiCode);
			} else if (symbolType == SYMBOL_TYPE_SMALL_LETTERS) {
				int randomAsciiCode = getRandomNumberRange(smallLettersAsciiStartCode,
						smallLettersAsciiEndCode);
				generatedString.append((char) randomAsciiCode);
			} else if (symbolType == SYMBOL_TYPE_UP_LETTERS) {
				int randomAsciiCode = getRandomNumberRange(upperLettersAsciiStartCode,
						upperLettersAsciiEndCode);
				generatedString.append((char) randomAsciiCode);
			}
		}

		return generatedString.toString();
	}

	/**
	 * Generates and returns random string. It consists of a-z, A-Z, 0-9 symbols and uses ASCII
	 * codes.
	 * 
	 * @param length
	 *            the length of the string to be generated
	 * @return the generated random string
	 */
	public String generateStringAscii(int length) {
		if (length <= 0) {
			throw new IllegalArgumentException(STRING_SIZE_ERROR_MESSAGE + length);
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
	 * Generates and returns random string. It consists of a-z, A-Z, 0-9 symbols.
	 * 
	 * @param length
	 *            the length of the string to be generated
	 * @return the generated random string
	 */
	public String generateString(int length) {
		if (length <= 0) {
			throw new IllegalArgumentException(STRING_SIZE_ERROR_MESSAGE + length);
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

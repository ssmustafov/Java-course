package com.sirma.itt.javacourse.intro.strings;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Tests {@link com.sirma.itt.javacourse.intro.strings.RandomString} class.
 * 
 * @author smustafov
 */
public class RandomStringTest {

	private RandomString randomString = new RandomString();

	/**
	 * Tests {@link com.sirma.itt.javacourse.intro.strings.RandomString#generateString(int)} with
	 * given length.
	 */
	@Test
	public void testGenerateStringLength() {
		String generatedString = randomString.generateString(100);
		int actual = generatedString.length();
		int expected = 100;

		assertEquals(expected, actual);
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.intro.strings.RandomString#generateString(int)} for
	 * valid symbols.
	 */
	@Test
	public void testGenerateStringSymbols() {
		String generatedString = randomString.generateString(100);
		boolean actual = generatedString.matches("[a-zA-Z0-9]*");
		boolean expected = true;

		assertEquals(expected, actual);
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.intro.strings.RandomString#generateStringAscii(int)}
	 * for valid symbols.
	 */
	@Test
	public void testGenerateStringAsciiSymbols() {
		String generatedString = randomString.generateStringAscii(155);
		boolean actual = generatedString.matches("[a-zA-Z0-9]*");
		boolean expected = true;

		assertEquals(expected, actual);
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.intro.strings.RandomString#generateStringAscii(int)}
	 * with given length.
	 */
	@Test
	public void testGenerateStringAsciiLength() {
		String generatedString = randomString.generateStringAscii(155);
		int actual = generatedString.length();
		int expected = 155;

		assertEquals(expected, actual);
	}

	/**
	 * Tests
	 * {@link com.sirma.itt.javacourse.intro.strings.RandomString#generateStringAsciiCode(int)} for
	 * valid symbols.
	 */
	@Test
	public void testGenerateStringAsciiCodeSymbols() {
		String generatedString = randomString.generateStringAsciiCode(155);
		boolean actual = generatedString.matches("[a-zA-Z0-9]*");
		boolean expected = true;

		assertEquals(expected, actual);
	}

	/**
	 * Tests
	 * {@link com.sirma.itt.javacourse.intro.strings.RandomString#generateStringAsciiCode(int)} with
	 * given length.
	 */
	@Test
	public void testGenerateStringAsciiCodeLength() {
		String generatedString = randomString.generateStringAsciiCode(43);
		int actual = generatedString.length();
		int expected = 43;

		assertEquals(expected, actual);
	}

}

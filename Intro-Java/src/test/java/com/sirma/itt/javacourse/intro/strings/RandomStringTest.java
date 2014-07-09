package com.sirma.itt.javacourse.intro.strings;

import static org.junit.Assert.fail;

import org.junit.Test;

/**
 * Class for testing {@link com.sirma.itt.javacourse.intro.strings.RandomString} class.
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
		String actual = randomString.generateString(100);
		if (actual.length() != 100) {
			fail("The length of the generated string is not 100");
		}
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.intro.strings.RandomString#generateString(int)} for
	 * valid symbols.
	 */
	@Test
	public void testGenerateStringSymbols() {
		String actual = randomString.generateString(100);
		if (!actual.matches("[a-zA-Z0-9]*")) {
			fail("The generated string is not valid");
		}
	}
}

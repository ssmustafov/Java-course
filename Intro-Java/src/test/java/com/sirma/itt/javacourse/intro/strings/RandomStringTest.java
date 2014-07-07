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
	 * Test method for
	 * {@link com.sirma.itt.javacourse.intro.strings.RandomString#generateString(int)}.
	 */
	@Test
	public void testGenerateStringLength() {
		String actual = randomString.generateString(100);
		if (actual.length() != 100) {
			fail("The length of the generated string is not 100");
		}
	}

}

package com.sirma.itt.javacourse.intro.hangman;

import static org.junit.Assert.fail;

import org.junit.Test;

/**
 * Tests {@link com.sirma.itt.javacourse.intro.hangman.ArrayReader} class.
 * 
 * @author smustafov
 */
public class ArrayReaderTest {

	/**
	 * Tests
	 * {@link com.sirma.itt.javacourse.intro.hangman.ArrayReader#ArrayReader(java.lang.String[])}
	 * with empty array of strings.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testArrayReaderWithEmptyArray() {
		String[] arr = {};
		new ArrayReader(arr);
	}

	/**
	 * Tests
	 * {@link com.sirma.itt.javacourse.intro.hangman.ArrayReader#ArrayReader(java.lang.String[])}
	 * with one element.
	 */
	@Test
	public void testArrayReaderWithOneElement() {
		String[] arr = { "developer" };
		ArrayReader reader = new ArrayReader(arr);
		if (!reader.getRandomWord().equals(arr[0])) {
			fail("The given one word doesn't exist in the array");
		}
	}

	/**
	 * Tests
	 * {@link com.sirma.itt.javacourse.intro.hangman.ArrayReader#ArrayReader(java.lang.String[])}
	 * with null array.
	 */
	@Test(expected = NullPointerException.class)
	public void testArrayReaderWithNull() {
		String[] arr = null;
		new ArrayReader(arr);
	}

}

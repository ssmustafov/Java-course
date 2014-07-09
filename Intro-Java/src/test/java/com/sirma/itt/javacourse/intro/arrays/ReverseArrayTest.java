package com.sirma.itt.javacourse.intro.arrays;

import static org.junit.Assert.fail;

import org.junit.Test;

/**
 * Tests {@link com.sirma.itt.javacourse.intro.arrays.ReverseArray} class.
 * 
 * @author smustafov
 */
public class ReverseArrayTest {

	private int[] originalArray;

	/**
	 * Validates reversing.
	 * 
	 * @param array
	 *            the array to be checked if its reversed
	 * @return true if the array is reversed or false if its not reversed
	 */
	private boolean isReversed(int[] array) {
		final int length = array.length;
		for (int index = 0; index < length; index++) {
			if (array[index] != originalArray[length - 1 - index]) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.intro.arrays.ReverseArray#reverse(int[])} with ordinary
	 * elements.
	 */
	@Test
	public void testSimpleReverse() {
		int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		originalArray = array.clone();
		ReverseArray.reverse(array);

		if (!isReversed(array)) {
			fail("The array is not reversed");
		}
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.intro.arrays.ReverseArray#reverse(int[])} with two
	 * elements.
	 */
	@Test
	public void testReverseWithTwoElements() {
		int[] array = { 1, 2 };
		originalArray = array.clone();
		ReverseArray.reverse(array);

		if (!isReversed(array)) {
			fail("The array is not reversed");
		}
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.intro.arrays.ReverseArray#reverse(int[])} with empty
	 * array.
	 */
	@Test
	public void testReverseWithEmptyArray() {
		int[] array = {};
		ReverseArray.reverse(array);

		if (array.length > 0) {
			fail("The array is not empty");
		}
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.intro.arrays.ReverseArray#reverse(int[])} with null
	 * array.
	 */
	@Test(expected = NullPointerException.class)
	public void testReverseWithNullArray() {
		int[] array = null;
		ReverseArray.reverse(array);
	}

}

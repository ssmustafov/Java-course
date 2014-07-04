package com.sirma.itt.javacourse.intro;

import static org.junit.Assert.fail;

import org.junit.Test;

/**
 * Class for testing {@link com.sirma.itt.javacourse.intro.ReverseArray} class.
 * 
 * @author smustafov
 */
public class ReverseArrayTest {

	private int[] originalArray;

	/**
	 * Method for validating reversing.
	 * 
	 * @param array
	 *            the array to be checked if its reversed
	 * @return true if the array is reversed or false if its not reversed
	 */
	private boolean isReversed(int[] array) {
		int length = array.length;
		for (int index = 0; index < length; index++) {
			if (array[index] != originalArray[length - 1 - index]) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Test method for {@link com.sirma.itt.javacourse.intro.ReverseArray#reverse(int[])}.
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

}

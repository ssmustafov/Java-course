package com.sirma.itt.javacourse.intro.arrays;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Tests {@link com.sirma.itt.javacourse.intro.arrays.ArrayProcess#findMedianOfArray(int[])} method.
 * 
 * @author smustafov
 */
public class MedianTest {

	/**
	 * Tests {@link com.sirma.itt.javacourse.intro.arrays.ArrayProcess#findMedianOfArray(int[])}
	 * with empty array.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testFindMedianIndexWithEmptyArray() {
		int[] array = {};
		ArrayProcess.findMedianOfArray(array);
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.intro.arrays.ArrayProcess#findMedianOfArray(int[])}
	 * elementary median.
	 */
	@Test
	public void testSimpleFindMedianIndex() {
		int[] array = { 1, 2, 3, 4, 5 };
		int actual = ArrayProcess.findMedianOfArray(array);
		int expected = 4;

		assertEquals(expected, actual);
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.intro.arrays.ArrayProcess#findMedianOfArray(int[])}
	 * with one element.
	 */
	@Test
	public void testFindMedianIndexWithOneElement() {
		int[] array = { 1 };
		int actual = ArrayProcess.findMedianOfArray(array);
		int expected = 1;

		assertEquals(expected, actual);
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.intro.arrays.ArrayProcess#findMedianOfArray(int[])}
	 * with two elements.
	 */
	@Test
	public void testFindMedianIndexWithTwoElements() {
		int[] array = { 10, 2 };
		int actual = ArrayProcess.findMedianOfArray(array);
		int expected = 1;

		assertEquals(expected, actual);
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.intro.arrays.ArrayProcess#findMedianOfArray(int[])}
	 * with three elements.
	 */
	@Test
	public void testFindMedianIndexWithThreeElements() {
		int[] array = { 300, 20, 1 };
		int actual = ArrayProcess.findMedianOfArray(array);
		int expected = 1;

		assertEquals(expected, actual);
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.intro.arrays.ArrayProcess#findMedianOfArray(int[])}
	 * with negative numbers.
	 */
	@Test
	public void testFindMedianIndexWithNegativeNumbers() {
		int[] array = { -4, -5, -99, -1, -5, -6 };
		int actual = ArrayProcess.findMedianOfArray(array);
		int expected = 3;

		assertEquals(expected, actual);
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.intro.arrays.ArrayProcess#findMedianOfArray(int[])}
	 * with large array.
	 */
	@Test
	public void testFindMedianIndexLargeArray() {
		int[] array = { -4, 4, 5, 4, -5, -99, 0, 22, 17, 9, -1, -5, -6, -1, 3838, 921, 452, -4, 4,
				5, 4, -5, -99, 0, 22, 17, 9, -1, -5, -6, -1, 3838, 921, 452 };
		int actual = ArrayProcess.findMedianOfArray(array);
		int expected = 18;

		assertEquals(expected, actual);
	}

}

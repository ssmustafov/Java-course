package com.sirma.itt.javacourse.intro.arrays;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Class for testing {@link com.sirma.itt.javacourse.intro.arrays.Median} class.
 * 
 * @author smustafov
 */
public class MedianTest {

	/**
	 * Test method for {@link com.sirma.itt.javacourse.intro.arrays.Median#findMedianOfArray(int[])}
	 * .
	 */
	@Test
	public void testSimpleFindMedianIndex() {
		int[] array = { 1, 2, 3, 4, 5 };
		int actual = Median.findMedianOfArray(array);
		int expected = 4;

		assertEquals(expected, actual);
	}

	/**
	 * Test method for {@link com.sirma.itt.javacourse.intro.arrays.Median#findMedianOfArray(int[])}
	 * .
	 */
	@Test
	public void testFindMedianIndexWithOneElement() {
		int[] array = { 1 };
		int actual = Median.findMedianOfArray(array);
		int expected = 1;

		assertEquals(expected, actual);
	}

	/**
	 * Test method for {@link com.sirma.itt.javacourse.intro.arrays.Median#findMedianOfArray(int[])}
	 * .
	 */
	@Test
	public void testFindMedianIndexWithTwoElements() {
		int[] array = { 10, 2 };
		int actual = Median.findMedianOfArray(array);
		int expected = 1;

		assertEquals(expected, actual);
	}

	/**
	 * Test method for {@link com.sirma.itt.javacourse.intro.arrays.Median#findMedianOfArray(int[])}
	 * .
	 */
	@Test
	public void testFindMedianIndexWithThreeElements() {
		int[] array = { 300, 20, 1 };
		int actual = Median.findMedianOfArray(array);
		int expected = 1;

		assertEquals(expected, actual);
	}

	/**
	 * Test method for {@link com.sirma.itt.javacourse.intro.arrays.Median#findMedianOfArray(int[])}
	 * .
	 */
	@Test
	public void testFindMedianIndexWithNegativeNumbers() {
		int[] array = { -4, -5, -99, -1, -5, -6 };
		int actual = Median.findMedianOfArray(array);
		int expected = 3;

		assertEquals(expected, actual);
	}

	/**
	 * Test method for {@link com.sirma.itt.javacourse.intro.arrays.Median#findMedianOfArray(int[])}
	 * .
	 */
	@Test
	public void testFindMedianIndexLargeArray() {
		int[] array = { -4, 4, 5, 4, -5, -99, 0, 22, 17, 9, -1, -5, -6, -1, 3838, 921, 452, -4, 4,
				5, 4, -5, -99, 0, 22, 17, 9, -1, -5, -6, -1, 3838, 921, 452 };
		int actual = Median.findMedianOfArray(array);
		int expected = 18;

		assertEquals(expected, actual);
	}

}
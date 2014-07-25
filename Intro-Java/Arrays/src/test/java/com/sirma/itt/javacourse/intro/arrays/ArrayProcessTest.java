package com.sirma.itt.javacourse.intro.arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

/**
 * Tests {@link com.sirma.itt.javacourse.intro.arrays.ArrayProcess} class.
 * 
 * @author smustafov
 */
public class ArrayProcessTest {

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
		ArrayProcess.reverse(array);

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
		ArrayProcess.reverse(array);

		if (!isReversed(array)) {
			fail("The array is not reversed");
		}
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.intro.arrays.ReverseArray#reverse(int[])} with empty
	 * array.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testReverseWithEmptyArray() {
		int[] array = {};
		ArrayProcess.reverse(array);
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.intro.arrays.ReverseArray#reverse(int[])} with null
	 * array.
	 */
	@Test(expected = NullPointerException.class)
	public void testReverseWithNullArray() {
		int[] array = null;
		ArrayProcess.reverse(array);
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.intro.arrays.ArrayProcess#getMinElement(int[])} with
	 * normal numbers.
	 */
	@Test
	public void testGetMinElementWithNormalNumbers() {
		int[] array = { 2, 4, 5, 3, 1, 7, 0, 9, 8 };
		int actual = ArrayProcess.getMinElement(array);
		int expected = 0;

		assertEquals(expected, actual);
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.intro.arrays.ArrayProcess#getMinElement(int[])} with
	 * negative numbers.
	 */
	@Test
	public void testGetMinElementWithNegativeNumbers() {
		int[] array = { 29, 45, -5, 3, 11, 27, 22, 9, 8, -100 };
		int actual = ArrayProcess.getMinElement(array);
		int expected = -100;

		assertEquals(expected, actual);
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.intro.arrays.ArrayProcess#getMinElement(int[])} with
	 * empty array.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testGetMinElementWithEmptyArray() {
		int[] array = {};
		ArrayProcess.getMinElement(array);
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.intro.arrays.ArrayProcess#getMinElement(int[])} with
	 * one element.
	 */
	@Test
	public void testGetMinElementWithOneElementInArray() {
		int[] array = { 11 };
		int actual = ArrayProcess.getMinElement(array);
		int expected = 11;

		assertEquals(expected, actual);
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.intro.arrays.ArrayProcess#sum(int[])} with normal
	 * numbers.
	 */
	@Test
	public void testBasicSum() {
		int[] array = { 11, 4, 100, 12, 43, 1 };
		int actual = ArrayProcess.sum(array);
		int expected = 171;

		assertEquals(expected, actual);
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.intro.arrays.ArrayProcess#sum(int[])} with one number.
	 */
	@Test
	public void testSumWithOneElement() {
		int[] array = { 100 };
		int actual = ArrayProcess.sum(array);
		int expected = 100;

		assertEquals(expected, actual);
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.intro.arrays.ArrayProcess#sum(int[])} with zeros.
	 */
	@Test
	public void testSumWithZeros() {
		int[] array = { 0, 0, 0 };
		int actual = ArrayProcess.sum(array);
		int expected = 0;

		assertEquals(expected, actual);
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.intro.arrays.ArrayProcess#sum(int[])} with negative
	 * numbers.
	 */
	@Test
	public void testSumWithNegativeNumbers() {
		int[] array = { -234, -1, 0, -5, -17, 55, 33, -33 };
		int actual = ArrayProcess.sum(array);
		int expected = -202;

		assertEquals(expected, actual);
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.intro.arrays.ArrayProcess#print(int[])} in most cases.
	 */
	@Test
	public void testPrintNormalCase() {
		int[] array = { -234, -1, 0, -5, -17, 55, 33, -33 };
		String actual = ArrayProcess.print(array);
		String expected = "-234, -1, 0, -5, -17, 55, 33, -33";

		assertEquals(expected, actual);
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.intro.arrays.ArrayProcess#print(int[])} with empty
	 * array.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testPrintWithEmptyArray() {
		int[] array = {};
		ArrayProcess.print(array);
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.intro.arrays.ArrayProcess#print(int[])} with one
	 * element.
	 */
	@Test
	public void testPrintWithOneElement() {
		int[] array = { 55 };
		String actual = ArrayProcess.print(array);
		String expected = "55";

		assertEquals(expected, actual);
	}

}

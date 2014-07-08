package com.sirma.itt.javacourse.intro.arrays;

import static org.junit.Assert.fail;

import java.util.Arrays;

import org.junit.Test;

/**
 * Tests {@link com.sirma.itt.javacourse.intro.arrays.QuickSort} class.
 * 
 * @author smustafov
 */
public class QuickSortTest {

	/**
	 * Validates sorting.
	 * 
	 * @param originalArray
	 *            the not sorted array to be sorted with Arrays.sort()
	 * @param sortedArray
	 *            the array to be checked for sorting
	 * @return true if the array is sorted or false if it's not sorted
	 */
	private static boolean isSorted(int[] originalArray, int[] sortedArray) {
		/*
		 * for (int i = 0; i < arr.length - 1; i++) { if (arr[i] > arr[i + 1]) { return false; } }
		 * return true;
		 */
		Arrays.sort(originalArray);
		if (Arrays.equals(originalArray, sortedArray)) {
			return true;
		}
		return false;
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.intro.arrays.QuickSort#sort(int[])} normal size and
	 * numebrs.
	 */
	@Test
	public void testSimpleSort() {
		int[] originalArray = { 5, 99, 4, 6, 0, 1 };
		int[] sortedArray = { 5, 99, 4, 6, 0, 1 };
		QuickSort.sort(sortedArray);

		if (!isSorted(originalArray, sortedArray)) {
			fail("The array is not sorted");
		}
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.intro.arrays.QuickSort#sort(int[])} with empty arrays.
	 */
	@Test
	public void testEmptyArray() {
		int[] array = {};
		QuickSort.sort(array);
		if (array.length > 0) {
			fail("The array is not empty");
		}
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.intro.arrays.QuickSort#sort(int[])} with two elements.
	 */
	@Test
	public void testTwoElementsSort() {
		int[] originalArray = { 11, 4 };
		int[] sortedArray = { 11, 4 };
		QuickSort.sort(sortedArray);

		if (!isSorted(originalArray, sortedArray)) {
			fail("The array is not sorted");
		}
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.intro.arrays.QuickSort#sort(int[])} with negative
	 * elements.
	 */
	@Test
	public void testNegativeElementsSort() {
		int[] originalArray = { 4, 5, -99, 1, 5, 0, -6, 11, -4, 22 };
		int[] sortedArray = { 4, 5, -99, 1, 5, 0, -6, 11, -4, 22 };
		QuickSort.sort(sortedArray);

		if (!isSorted(originalArray, sortedArray)) {
			fail("The array is not sorted");
		}
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.intro.arrays.QuickSort#sort(int[])} with negative
	 * elements only.
	 */
	@Test
	public void testOnlyNegativeElementsSort() {
		int[] originalArray = { -4, -5, -99, -1, -5, -390, -6, -11, -4 };
		int[] sortedArray = { -4, -5, -99, -1, -5, -390, -6, -11, -4 };
		QuickSort.sort(sortedArray);

		if (!isSorted(originalArray, sortedArray)) {
			fail("The array is not sorted");
		}
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.intro.arrays.QuickSort#sort(int[])} with repeatable
	 * elements.
	 */
	@Test
	public void testRepeatableElementsSort() {
		int[] originalArray = { 5, 5, 6, 6, 4, 4, 5, 0, 0, 5, 4, 4, -1, 6, 6, 5, 5 };
		int[] sortedArray = { 5, 5, 6, 6, 4, 4, 5, 0, 0, 5, 4, 4, -1, 6, 6, 5, 5 };
		QuickSort.sort(sortedArray);

		if (!isSorted(originalArray, sortedArray)) {
			fail("The array is not sorted");
		}
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.intro.arrays.QuickSort#sort(int[])} with worst case
	 * scenario.
	 */
	@Test
	public void testSortWorstCase() {
		int[] originalArray = { 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 };
		int[] sortedArray = { 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 };
		QuickSort.sort(sortedArray);

		if (!isSorted(originalArray, sortedArray)) {
			fail("The array is not sorted");
		}
	}

	/*
	 * /** Test method for {@link com.sirma.itt.javacourse.intro.arrays.QuickSort#sort(int[])}.
	 * @Test(timeout = 2500) public void testBigRandomArraySort() { int[] array = new
	 * int[10_000_000]; for (int i = 0; i < array.length; i++) { array[i] = (int) Math.random(); }
	 * QuickSort.sort(array); if (!isSorted(array)) { fail("The array is not sorted"); } }
	 */
}

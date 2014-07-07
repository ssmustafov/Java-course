package com.sirma.itt.javacourse.intro.arrays;

import static org.junit.Assert.fail;

import org.junit.Test;

/**
 * Class for testing {@link com.sirma.itt.javacourse.intro.arrays.QuickSort} class.
 * 
 * @author smustafov
 */
public class QuickSortTest {

	/**
	 * Method for validating sorting.
	 * 
	 * @param arr
	 *            the array to be checked for sorting
	 * @return true if the array is sorted or false if it's not sorted
	 */
	private static boolean isSorted(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i] > arr[i + 1]) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Test method for {@link com.sirma.itt.javacourse.intro.arrays.QuickSort#sort(int[])}.
	 */
	@Test
	public void testSimpleSort() {
		int[] array = { 5, 99, 4, 6, 0, 1 };
		QuickSort.sort(array);

		if (!isSorted(array)) {
			fail("The array is not sorted");
		}
	}

	/**
	 * Test method for {@link com.sirma.itt.javacourse.intro.arrays.QuickSort#sort(int[])}.
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
	 * Test method for {@link com.sirma.itt.javacourse.intro.arrays.QuickSort#sort(int[])}.
	 */
	@Test
	public void testTwoElementsSort() {
		int[] array = { 11, 4 };
		QuickSort.sort(array);

		if (!isSorted(array)) {
			fail("The array is not sorted");
		}
	}

	/**
	 * Test method for {@link com.sirma.itt.javacourse.intro.arrays.QuickSort#sort(int[])}.
	 */
	@Test
	public void testNegativeElementsSort() {
		int[] array = { 4, 5, -99, 1, 5, 0, -6, 11, -4, 22 };
		QuickSort.sort(array);

		if (!isSorted(array)) {
			fail("The array is not sorted");
		}
	}

	/**
	 * Test method for {@link com.sirma.itt.javacourse.intro.arrays.QuickSort#sort(int[])}.
	 */
	@Test
	public void testOnlyNegativeElementsSort() {
		int[] array = { -4, -5, -99, -1, -5, 0, -6, -11, -4 };
		QuickSort.sort(array);

		if (!isSorted(array)) {
			fail("The array is not sorted");
		}
	}

	/**
	 * Test method for {@link com.sirma.itt.javacourse.intro.arrays.QuickSort#sort(int[])}.
	 */
	@Test
	public void testRepeatableElementsSort() {
		int[] array = { 5, 5, 6, 6, 4, 4, 5, 0, 0, 5, 4, 4, -1, 6, 6, 5, 5 };
		QuickSort.sort(array);

		if (!isSorted(array)) {
			fail("The array is not sorted");
		}
	}

	/**
	 * Test method for {@link com.sirma.itt.javacourse.intro.arrays.QuickSort#sort(int[])}.
	 */
	@Test(timeout = 2500)
	public void testBigRandomArraySort() {
		int[] array = new int[10_000_000];
		for (int i = 0; i < array.length; i++) {
			array[i] = (int) Math.random();
		}
		QuickSort.sort(array);

		if (!isSorted(array)) {
			fail("The array is not sorted");
		}
	}
}
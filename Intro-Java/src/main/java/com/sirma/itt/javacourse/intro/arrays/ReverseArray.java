package com.sirma.itt.javacourse.intro.arrays;

/**
 * Reverses the elements in array of integers. It swaps the first element with the last element, the
 * second element with the one before the last element and etc.
 * 
 * @author smustafov
 */
public final class ReverseArray {

	/**
	 * Protection from instantiation.
	 */
	private ReverseArray() {

	}

	/**
	 * Reverses the elements in array of integers.
	 * 
	 * @param arr
	 *            the array to be reversed
	 */
	public static void reverse(int[] arr) {
		final int length = arr.length;
		for (int index = 0; index < length / 2; index++) {
			int temp = arr[index];
			arr[index] = arr[length - 1 - index];
			arr[length - 1 - index] = temp;
		}
	}

}

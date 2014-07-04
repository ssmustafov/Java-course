package com.sirma.itt.javacourse.intro.arrays;

/**
 * Class with method for reversing the elements in array of integers.
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
	 * Method for reversing the elements in array of integers.
	 * 
	 * @param arr
	 *            the array to be reversed
	 */
	public static void reverse(int[] arr) {
		int length = arr.length;
		for (int index = 0; index < length / 2; index++) {
			int temp = arr[index];
			arr[index] = arr[length - 1 - index];
			arr[length - 1 - index] = temp;
		}
	}

}

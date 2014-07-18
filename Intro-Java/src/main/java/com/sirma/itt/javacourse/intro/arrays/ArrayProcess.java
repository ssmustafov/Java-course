package com.sirma.itt.javacourse.intro.arrays;

/**
 * Processes arrays.
 * 
 * @author smustafov
 */
public final class ArrayProcess {

	/**
	 * Protects from instantiation.
	 */
	private ArrayProcess() {

	}

	/**
	 * Finds and returns the minimal element in array of integers.
	 * 
	 * @param array
	 *            the array for finding the minimal element
	 * @return the minimal element in the array
	 */
	public static int getMinElement(int[] array) {
		if (array.length <= 0) {
			throw new IllegalArgumentException("The array's size is equal or under zero");
		}

		int minElement = array[0];
		for (int index = 1; index < array.length; index++) {
			if (array[index] < minElement) {
				minElement = array[index];
			}
		}
		return minElement;
	}

	/**
	 * Finds and returns the sum of the elements in array of integers.
	 * 
	 * @param array
	 *            the array for finding the sum
	 * @return the sum of the elements in array
	 */
	public static int sum(int[] array) {
		if (array.length <= 0) {
			throw new IllegalArgumentException("The array's size is equal or under zero");
		}

		int sum = 0;
		for (int index = 0; index < array.length; index++) {
			sum += array[index];
		}
		return sum;
	}

	/**
	 * Prints the elements in given array.
	 * 
	 * @param array
	 *            the array to print
	 * @return string with elements of the array
	 */
	public static String print(int[] array) {
		if (array.length <= 0) {
			throw new IllegalArgumentException("The array's size is equal or under zero");
		}

		StringBuilder result = new StringBuilder();
		for (int index = 0; index < array.length - 1; index++) {
			result.append(array[index]);
			result.append(", ");
		}

		// Don't add space after the last element
		result.append(array[array.length - 1]);

		return result.toString();
	}

	/**
	 * Reverses the elements in array of integers. It swaps the first element with the last element,
	 * the second element with the one before the last element and etc.
	 * 
	 * @param arr
	 *            the array to be reversed
	 */
	public static void reverse(int[] arr) {
		if (arr.length <= 0) {
			throw new IllegalArgumentException("The array's size is equal or under zero");
		}

		final int length = arr.length;
		for (int index = 0; index < length / 2; index++) {
			int temp = arr[index];
			arr[index] = arr[length - 1 - index];
			arr[length - 1 - index] = temp;
		}
	}
}

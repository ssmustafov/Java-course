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
	 * Finds the minimal element in array of integers.
	 * 
	 * @param array
	 *            the array for finding the minimal element
	 * @return the minimal element in the array
	 */
	public static int getMinElement(int[] array) {
		int minElement = array[0];
		for (int index = 1; index < array.length; index++) {
			if (array[index] < minElement) {
				minElement = array[index];
			}
		}
		return minElement;
	}

	/**
	 * Finds the sum of the elements in array of integers.
	 * 
	 * @param array
	 *            the array for finding the sum
	 * @return the sum of the elements in array
	 */
	public static int sum(int[] array) {
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
		StringBuilder result = new StringBuilder();
		for (int index = 0; index < array.length - 1; index++) {
			result.append(array[index]);
			result.append(", ");
		}

		// Don't add space after the last element
		result.append(array[array.length - 1]);

		return result.toString();
	}
}

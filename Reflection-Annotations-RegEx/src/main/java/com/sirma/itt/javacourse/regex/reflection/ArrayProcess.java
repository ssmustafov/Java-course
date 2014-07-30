package com.sirma.itt.javacourse.regex.reflection;

/**
 * Processes arrays.
 * 
 * @author smustafov
 */
public class ArrayProcess {

	public static final String ARRAY_SIZE_UNDER_ZERO_ERROR_MESSAGE = "The array's size is equal or under zero";
	private String counter;
	private String message;

	/**
	 * 
	 */
	public ArrayProcess() {
		setCounter("Text");
		setMessage("This is message");
	}

	/**
	 * Finds and returns the minimal element in array of integers.
	 * 
	 * @param array
	 *            the array for finding the minimal element
	 * @return the minimal element in the array
	 */
	public int getMinElement(int[] array) {
		if (array.length <= 0) {
			throw new IllegalArgumentException(ARRAY_SIZE_UNDER_ZERO_ERROR_MESSAGE);
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
	public int sum(int[] array) {
		if (array.length <= 0) {
			throw new IllegalArgumentException(ARRAY_SIZE_UNDER_ZERO_ERROR_MESSAGE);
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
	public String print(int[] array) {
		if (array.length <= 0) {
			throw new IllegalArgumentException(ARRAY_SIZE_UNDER_ZERO_ERROR_MESSAGE);
		}

		StringBuilder result = new StringBuilder();
		for (int index = 0; index < array.length - 1; index++) {
			result.append(array[index]);
			result.append(", ");
		}

		// Don't add comma after the last element
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
	public void reverse(int[] arr) {
		if (arr.length <= 0) {
			throw new IllegalArgumentException(ARRAY_SIZE_UNDER_ZERO_ERROR_MESSAGE);
		}

		final int length = arr.length;
		for (int index = 0; index < length / 2; index++) {
			int temp = arr[index];
			arr[index] = arr[length - 1 - index];
			arr[length - 1 - index] = temp;
		}
	}

	/**
	 * Finds and returns the array's median - the sum of the elements before the median, which is
	 * element in the array, and after it as close as possible.
	 * 
	 * @param array
	 *            the array's median to be found
	 * @return the index of the median starting from 1. If the array has one element it returns
	 *         index 1
	 */
	public int findMedianOfArray(int[] array) {
		if (array.length <= 0) {
			throw new IllegalArgumentException(ARRAY_SIZE_UNDER_ZERO_ERROR_MESSAGE);
		}
		if (array.length == 1) {
			return 1;
		}

		int index = 0;
		int leftSum = 0;
		int rightSum = 0;
		int bestDiff = 0;

		for (int i = 1; i < array.length; i++) {
			rightSum += array[i];
		}

		bestDiff = Math.abs(leftSum - rightSum);

		for (int i = 1; i < array.length; i++) {
			leftSum += array[i - 1];
			rightSum -= array[i];

			int currentDiff = Math.abs(leftSum - rightSum);
			if (bestDiff > currentDiff) {
				bestDiff = currentDiff;
				index = i;
			}
		}

		return index + 1;
	}

	/**
	 * Getter method for counter.
	 * 
	 * @return the counter
	 */
	public String getCounter() {
		return counter;
	}

	/**
	 * Setter method for counter.
	 * 
	 * @param counter
	 *            the counter to set
	 */
	public void setCounter(String counter) {
		this.counter = counter;
	}

	/**
	 * Getter method for message.
	 * 
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * Setter method for message.
	 * 
	 * @param message
	 *            the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

}

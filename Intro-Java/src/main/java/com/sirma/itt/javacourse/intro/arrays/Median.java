package com.sirma.itt.javacourse.intro.arrays;

/**
 * Finds the array's median - the sum of the elements before the median, which is element in the
 * array, and after it as close as possible.
 * 
 * @author smustafov
 */
public final class Median {

	/**
	 * Protection from instantiation.
	 */
	private Median() {

	}

	/**
	 * Finds and returns the index of array's median.
	 * 
	 * @param array
	 *            the array's median to be found
	 * @return the index of the median starting from 1. If the array has one element it returns
	 *         index 1
	 */
	public static int findMedianOfArray(int[] array) {
		if (array.length <= 0) {
			throw new IllegalArgumentException("The array's size is equal or under zero");
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

}

package com.sirma.itt.javacourse.libraries.reuse;

import com.sirma.itt.javacourse.intro.arrays.ArrayProcess;

/**
 * Uses the code from Intro-Java project as jar libraries.
 * 
 * @author smustafov
 */
public final class Run {

	/**
	 * Default constructor.
	 */
	private Run() {

	}

	/**
	 * Uses <code>ArrayProcess</code> to sum the elements of integer array.
	 * 
	 * @param array
	 *            - the array which elements to sum
	 * @return - the sum of array's elements
	 */
	public static int sum(int[] array) {
		return ArrayProcess.sum(array);
	}

	/**
	 * Uses <code>ArrayProcess</code> to get min element in array of integers.
	 * 
	 * @param array
	 *            - the array from which min elemenet to be get
	 * @return - the min element
	 */
	public static int getMinElement(int[] array) {
		return ArrayProcess.getMinElement(array);
	}

	/**
	 * Uses <code>ArrayProcess</code> to reverse array of integers.
	 * 
	 * @param array
	 *            - the array to be reversed
	 */
	public static void reverse(int[] array) {
		ArrayProcess.reverse(array);
	}

	/**
	 * @param args
	 *            - arguments
	 */
	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 0 };
		System.out.println(sum(arr));
		System.out.println(getMinElement(arr));
		reverse(arr);
		for (int i : arr) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
}

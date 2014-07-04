package com.sirma.itt.javacourse.intro.arrays;

import java.util.Arrays;

public class Median {

	public static int findMedianOfArray(int[] array) {
		Arrays.sort(array);

		int index = 0;
		int length = array.length;
		int middle = length / 2;

		if (length % 2 == 0) {
			index = middle;
		} else {
			index = ((middle + 1) + middle) / 2;
		}

		return index;
	}

}

package com.sirma.itt.javacourse.regex.annotations;

import java.util.Arrays;

/**
 * @author Sinan
 */
public class Run {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Parent[] arr = { new Class1(), new Class2(), new Class3() };
		Arrays.sort(arr);

		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
}

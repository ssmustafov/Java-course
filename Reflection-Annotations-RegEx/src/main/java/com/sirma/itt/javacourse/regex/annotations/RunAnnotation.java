package com.sirma.itt.javacourse.regex.annotations;

import java.util.Arrays;

/**
 * Shows how the annotations can be used.
 * 
 * @author smustafov
 */
public final class RunAnnotation {

	/**
	 * Protects from instantiation.
	 */
	private RunAnnotation() {

	}

	/**
	 * @param args
	 *            - arguments
	 */
	public static void main(String[] args) {
		Human[] arr = { new Human3(), new Human2(), new Human1(), new Human2(), new Human3() };
		Arrays.sort(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i].getClass().getSimpleName());
		}
	}

}

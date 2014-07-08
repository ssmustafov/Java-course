package com.sirma.itt.javacourse.intro.numbers;

/**
 * Holds methods for finding the greatest common divisor and the least common multiple of two
 * numbers.
 * 
 * @author smustafov
 */
public final class CommonDivisor {

	/**
	 * Constructor for protection from instantiation.
	 */
	private CommonDivisor() {

	}

	/**
	 * Finds the Greatest common divisor of two numbers.
	 * 
	 * @param number1
	 *            the first number
	 * @param number2
	 *            the second number
	 * @return the Greatest common divisor of two numbers
	 */
	public static long findGreatestCommonDivisor(long number1, long number2) {
		if (number1 == 0 && number2 == 0) {
			return 1;
		} else if (number2 == 0) {
			return number1;
		}
		return findGreatestCommonDivisor(number2, number1 % number2);
	}

	/**
	 * Finds the Least common multiple of two numbers.
	 * 
	 * @param number1
	 *            the first number
	 * @param number2
	 *            the second number
	 * @return the Least common multiple of two numbers
	 */
	public static long findLeastCommonMultiple(long number1, long number2) {
		if (number1 == 0 && number2 != 0) {
			return number2;
		} else if (number2 == 0 && number1 != 0) {
			return number1;
		} else if (number1 == 0 && number2 == 0) {
			return 0;
		}
		return number1 * (number2 / findGreatestCommonDivisor(number1, number2));
	}

}

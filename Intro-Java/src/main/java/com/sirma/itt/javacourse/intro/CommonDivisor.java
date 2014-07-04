package com.sirma.itt.javacourse.intro;

/**
 * Class with methods for finding the greatest common divisor and the least common multiple of two
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
	 * Method for finding the Greatest common divisor of two numbers.
	 * 
	 * @param number1
	 *            the first number
	 * @param number2
	 *            the second number
	 * @return the Greatest common divisor of two numbers
	 */
	public static long findGreatestCommonDivisor(long number1, long number2) {
		if (number2 == 0) {
			return number1;
		}
		return findGreatestCommonDivisor(number2, number1 % number2);
	}

	/**
	 * Method for finding the Least common multiple of two numbers.
	 * 
	 * @param number1
	 *            the first number
	 * @param number2
	 *            the second number
	 * @return the Least common multiple of two numbers
	 */
	public static long findLeastCommonMultiple(long number1, long number2) {
		return number1 * (number2 / findGreatestCommonDivisor(number1, number2));
	}

}

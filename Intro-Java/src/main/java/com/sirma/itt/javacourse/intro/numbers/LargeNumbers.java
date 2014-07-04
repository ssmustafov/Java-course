package com.sirma.itt.javacourse.intro.numbers;

import java.math.BigInteger;

/**
 * Class for work with large numbers.
 * 
 * @author smustafov
 */
public final class LargeNumbers {

	/**
	 * Protection from instantiation.
	 */
	private LargeNumbers() {

	}

	/**
	 * Sum two large numbers.
	 * 
	 * @param number1AsString
	 *            the first number to sum
	 * @param number2AsString
	 *            the second number to sum
	 * @return number1AsString + number2AsString
	 */
	public static BigInteger sumTwoNumbers(String number1AsString, String number2AsString) {
		BigInteger number1 = new BigInteger(number1AsString);
		BigInteger number2 = new BigInteger(number2AsString);
		return number1.add(number2);
	}

}

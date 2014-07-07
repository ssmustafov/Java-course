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
		StringBuilder result = new StringBuilder();
		int numberWithMaxLen = Math.max(number1AsString.length(), number2AsString.length());
		int digit1;
		int digit2;
		int sum = 0;
		int carry = 0;
		for (int i = 0; i < numberWithMaxLen; i++) {
			if (i < number1AsString.length()) {
				digit1 = Character.getNumericValue(number1AsString.charAt(i));
			} else {
				digit1 = 0;
			}

			if (i < number2AsString.length()) {
				digit2 = Character.getNumericValue(number2AsString.charAt(i));
			} else {
				digit2 = 0;
			}

			sum = digit1 + digit2 + carry;
			if (sum >= 10) {
				carry = sum;
				sum -= 10;
			}

			carry /= 10;
			result.append(sum);
		}

		if (carry > 0) {
			result.append(carry + sum);
		}

		BigInteger finalNumber = new BigInteger(result.toString());
		return finalNumber;
	}
}

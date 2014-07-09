package com.sirma.itt.javacourse.intro.numbers;

/**
 * Works with large numbers.
 * 
 * @author smustafov
 */
public final class LargeNumbers {

	private static final char ZERO_CHAR = '0';
	private static final char MINUS_CHAR = '-';

	/**
	 * Protection from instantiation.
	 */
	private LargeNumbers() {

	}

	/**
	 * Sums two large numbers.
	 * 
	 * @param number1AsString
	 *            the first number to sum
	 * @param number2AsString
	 *            the second number to sum
	 * @return number1AsString + number2AsString
	 */
	public static String sumTwoNumbers(final String number1AsString, final String number2AsString) {
		String workingNumber1 = number1AsString;
		String workingNumber2 = number2AsString;
		char charFromNumber1;
		char charFromNumber2;
		int digitFromNumber1;
		int digitFromNumber2;
		int addition = 0;
		int sum;
		StringBuilder result = new StringBuilder();

		while (workingNumber1.length() > 0 || workingNumber2.length() > 0) {
			if (workingNumber1.length() > 0) {
				charFromNumber1 = workingNumber1.charAt(workingNumber1.length() - 1);
				workingNumber1 = workingNumber1.substring(0, workingNumber1.length() - 1);
			} else {
				charFromNumber1 = ZERO_CHAR;
			}

			if (workingNumber2.length() > 0) {
				charFromNumber2 = workingNumber2.charAt(workingNumber2.length() - 1);
				workingNumber2 = workingNumber2.substring(0, workingNumber2.length() - 1);
			} else {
				charFromNumber2 = ZERO_CHAR;
			}

			if (charFromNumber2 == MINUS_CHAR || charFromNumber1 == MINUS_CHAR) {
				break;
			}

			digitFromNumber1 = Character.getNumericValue(charFromNumber1);
			digitFromNumber2 = Character.getNumericValue(charFromNumber2);
			sum = digitFromNumber1 + digitFromNumber2 + addition;
			if (sum >= 10) {
				addition = sum;
				sum -= 10;
			}
			addition /= 10;
			result.append(sum);
		}

		if (addition > 0) {
			result.append(addition);
		}

		StringBuilder finalResult = new StringBuilder();

		for (int i = result.length() - 1; i >= 0; i--) {
			finalResult.append(result.charAt(i));
		}

		return finalResult.toString();
	}
}

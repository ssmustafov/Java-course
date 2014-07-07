package com.sirma.itt.javacourse.intro.numbers;

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
	public static String sumTwoNumbers(String number1AsString, String number2AsString) {
		char charFromNumber1;
		char charFromNumber2;
		int digitFromNumber1;
		int digitFromNumber2;
		int addition = 0;
		int sum;
		StringBuilder result = new StringBuilder();

		// TODO assignment to parameters must be avoided
		while (number1AsString.length() > 0 || number2AsString.length() > 0) {
			if (number1AsString.length() > 0) {
				charFromNumber1 = number1AsString.charAt(number1AsString.length() - 1);
				number1AsString = number1AsString.substring(0, number1AsString.length() - 1);
			} else {
				charFromNumber1 = '0';
			}

			if (number2AsString.length() > 0) {
				charFromNumber2 = number2AsString.charAt(number2AsString.length() - 1);
				number2AsString = number2AsString.substring(0, number2AsString.length() - 1);
			} else {
				charFromNumber2 = '0';
			}

			if (charFromNumber2 == '-' || charFromNumber1 == '-') {
				break;
				//
			}

			digitFromNumber1 = Character.getNumericValue(charFromNumber1);
			digitFromNumber2 = Character.getNumericValue(charFromNumber2);
			sum = digitFromNumber1 + digitFromNumber2 + addition;
			if (sum > 9) {
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

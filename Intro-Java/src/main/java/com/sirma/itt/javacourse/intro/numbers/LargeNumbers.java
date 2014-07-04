package com.sirma.itt.javacourse.intro.numbers;

import java.math.BigInteger;

public final class LargeNumbers {

	public static BigInteger sumTwoNumbers(String number1AsString, String number2AsString) {
		BigInteger number1 = new BigInteger(number1AsString);
		BigInteger number2 = new BigInteger(number2AsString);
		return number1.add(number2);
	}

}

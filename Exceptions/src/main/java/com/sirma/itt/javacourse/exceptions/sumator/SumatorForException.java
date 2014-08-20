package com.sirma.itt.javacourse.exceptions.sumator;

import com.sirma.itt.javacourse.objects.sumator.Sumator;

/**
 * Holds method for summing two given numbers as string.
 * 
 * @author smustafov
 */
public class SumatorForException {

	private final Sumator sumator = new Sumator();

	/**
	 * Sums two numbers given as <code>String</code>.
	 * 
	 * @param a
	 *            first number as string to sum
	 * @param b
	 *            second numbers as string to sum
	 * @return a + b
	 */
	public String sum(String a, String b) {
		try {
			String s = sumator.sum(a, b);
			return s;
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException(e.getMessage());
		}

		// if (a == null || b == null) {
		// throw new IllegalArgumentException("One of the given strings is null");
		// }
		// if (a.isEmpty() || b.isEmpty()) {
		// throw new IllegalArgumentException("One of the given strings is empty");
		// }
		//
		// if (sumator.isInt(a) && sumator.isInt(b)) {
		// int num1 = Integer.parseInt(a);
		// int num2 = Integer.parseInt(b);
		// int sumStrings = sumator.sum(num1, num2);
		// return Integer.toString(sumStrings);
		// } else if (sumator.isBigInteger(a) && sumator.isBigInteger(b)) {
		// BigInteger num1 = new BigInteger(a);
		// BigInteger num2 = new BigInteger(b);
		// BigInteger sum = sumator.sum(num1, num2);
		// return sum.toString();
		// } else if (sumator.isBigDecimal(a) && sumator.isBigDecimal(b)) {
		// BigDecimal num1 = new BigDecimal(a);
		// BigDecimal num2 = new BigDecimal(b);
		// BigDecimal sum = sumator.sum(num1, num2);
		// return sum.toString();
		// } else {
		// throw new NumberFormatException("Incorrect number format: a = " + a + " b = " + b);
		// }
	}

}

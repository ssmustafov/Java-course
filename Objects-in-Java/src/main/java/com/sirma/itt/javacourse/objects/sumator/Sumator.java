package com.sirma.itt.javacourse.objects.sumator;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * Sums numbers.
 * 
 * @author smustafov
 */
public class Sumator {

	/**
	 * Sums two numbers of type <code>Byte</code>.
	 * 
	 * @param a
	 *            first number to sum
	 * @param b
	 *            second number to sum
	 * @return a + b
	 */
	public byte sum(byte a, byte b) {
		byte s = (byte) (a + b);
		return s;
	}

	/**
	 * Sums two numbers of type <code>Short</code>.
	 * 
	 * @param a
	 *            first number to sum
	 * @param b
	 *            second number to sum
	 * @return a + b
	 */
	public short sum(short a, short b) {
		short s = (short) (a + b);
		return s;
	}

	/**
	 * Sums two numbers of type <code>Integer</code>.
	 * 
	 * @param a
	 *            first number to sum
	 * @param b
	 *            second number to sum
	 * @return a + b
	 */
	public int sum(int a, int b) {
		return a + b;
	}

	/**
	 * Sums two numbers of type <code>Long</code>.
	 * 
	 * @param a
	 *            first number to sum
	 * @param b
	 *            second number to sum
	 * @return a + b
	 */
	public long sum(long a, long b) {
		return a + b;
	}

	/**
	 * Sums two numbers of type <code>Float</code>.
	 * 
	 * @param a
	 *            first number to sum
	 * @param b
	 *            second number to sum
	 * @return a + b
	 */
	public float sum(float a, float b) {
		return a + b;
	}

	/**
	 * Sums two numbers of type <code>Double</code>.
	 * 
	 * @param a
	 *            first number to sum
	 * @param b
	 *            second number to sum
	 * @return a + b
	 */
	public double sum(double a, double b) {
		return a + b;
	}

	/**
	 * Sums two numbers of type <code>BigInteger</code>.
	 * 
	 * @param a
	 *            first number to sum
	 * @param b
	 *            second number to sum
	 * @return a + b
	 */
	public BigInteger sum(BigInteger a, BigInteger b) {
		BigInteger sum = a.add(b);
		return sum;
	}

	/**
	 * Sums two numbers of type <code>BigDecimal</code>.
	 * 
	 * @param a
	 *            first number to sum
	 * @param b
	 *            second number to sum
	 * @return a + b
	 */
	public BigDecimal sum(BigDecimal a, BigDecimal b) {
		BigDecimal sum = a.add(b);
		return sum;
	}

	/**
	 * Checks if given string can be parsed to <code>Integer</code>.
	 * 
	 * @param str
	 *            - the string to be checked
	 * @return true if the given string can be parsed to <code>Integer</code> or false if it cannot
	 *         be parsed
	 */
	private boolean isInt(String str) {
		try {
			Integer.parseInt(str);
		} catch (NumberFormatException e) {
			return false;
		}

		return true;
	}

	/**
	 * Checks if given string can be parsed to <code>Double</code>.
	 * 
	 * @param str
	 *            - the string to be checked
	 * @return true if the given string can be parsed to <code>Double</code> or false if it cannot
	 *         be parsed
	 */
	private boolean isDouble(String str) {
		try {
			Double.parseDouble(str);
		} catch (NumberFormatException e) {
			return false;
		}

		return true;
	}

	/**
	 * Checks if given string can be parsed to <code>BigInteger</code>.
	 * 
	 * @param str
	 *            - the string to be checked
	 * @return true if the given string can be parsed to <code>BigInteger</code> or false if it
	 *         cannot be parsed
	 */
	private boolean isBigInteger(String str) {
		try {
			new BigInteger(str);
		} catch (NumberFormatException e) {
			return false;
		}

		return true;
	}

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
		if (a == null || b == null) {
			throw new IllegalArgumentException("One of the given strings is null");
		}
		if (a.isEmpty() || b.isEmpty()) {
			throw new IllegalArgumentException("One of the given strings is empty");
		}
		if (!a.matches("[-0-9].*")) {
			throw new IllegalArgumentException("Invalid number: " + a);
		}
		if (!b.matches("[-0-9].*")) {
			throw new IllegalArgumentException("Invalid number: " + b);
		}

		if (isInt(a) && isInt(b)) {
			int num1 = Integer.parseInt(a);
			int num2 = Integer.parseInt(b);
			int sumStrings = sum(num1, num2);
			return Integer.toString(sumStrings);
		} else if (isBigInteger(a) && isBigInteger(b)) {
			BigInteger num1 = new BigInteger(a);
			BigInteger num2 = new BigInteger(b);
			BigInteger sum = num1.add(num2);
			return sum.toString();
		} else if (isDouble(a) && isDouble(b)) {
			double num1 = Double.parseDouble(a);
			double num2 = Double.parseDouble(b);
			double sum = num1 + num2;
			return Double.toString(sum);
		} else {
			throw new NumberFormatException("Incorrect number format: a = " + a + " b = " + b);
		}

	}

}

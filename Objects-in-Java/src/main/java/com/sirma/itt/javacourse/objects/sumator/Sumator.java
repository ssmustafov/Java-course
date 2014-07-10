package com.sirma.itt.javacourse.objects.sumator;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * @author smustafov
 */
public class Sumator {

	/**
	 * Sums two byte numbers.
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
	 * Sums two short numbers.
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
	 * Sums two int numbers.
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
	 * Sums two long numbers.
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
	 * Sums two float numbers.
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
	 * Sums two double numbers.
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
	 * Sums two BigInteger numbers.
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
	 * Sums two BigDecimal numbers.
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
	 * Sums (concatinates) two strings.
	 * 
	 * @param a
	 *            first string to sum
	 * @param b
	 *            second string to sum
	 * @return a + b
	 */
	public String sum(String a, String b) {
		StringBuilder sum = new StringBuilder();
		sum.append(a);
		sum.append(b);
		return sum.toString();
	}

}

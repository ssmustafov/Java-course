package com.sirma.itt.javacourse.intro.numbers;

import static org.junit.Assert.assertEquals;

import java.math.BigInteger;

import org.junit.Test;

/**
 * @author smustafov
 */
public class LargeNumbersTest {

	/**
	 * Test method for
	 * {@link com.sirma.itt.javacourse.intro.numbers.LargeNumbers#sumTwoNumbers(java.lang.String, java.lang.String)}
	 * .
	 */
	@Test
	public void testPositiveTwoNumbersSum() {
		BigInteger actual = LargeNumbers.sumTwoNumbers("89237642346719412378",
				"32425298234278340234");
		BigInteger expected = new BigInteger("121662940580997752612");

		assertEquals(expected, actual);
	}

	/**
	 * Test method for
	 * {@link com.sirma.itt.javacourse.intro.numbers.LargeNumbers#sumTwoNumbers(java.lang.String, java.lang.String)}
	 * .
	 */
	@Test
	public void testNegativeTwoNumbersSum() {
		BigInteger actual = LargeNumbers.sumTwoNumbers("-458747878438764529624392349",
				"-94832543248223487234790");
		BigInteger expected = new BigInteger("-458842710982012753111627139");

		assertEquals(expected, actual);
	}

	/**
	 * Test method for
	 * {@link com.sirma.itt.javacourse.intro.numbers.LargeNumbers#sumTwoNumbers(java.lang.String, java.lang.String)}
	 * .
	 */
	@Test
	public void testTwoZerosSum() {
		BigInteger actual = LargeNumbers.sumTwoNumbers("0", "0");
		BigInteger expected = new BigInteger("0");

		assertEquals(expected, actual);
	}

	/**
	 * Test method for
	 * {@link com.sirma.itt.javacourse.intro.numbers.LargeNumbers#sumTwoNumbers(java.lang.String, java.lang.String)}
	 * .
	 */
	@Test
	public void testOneNumberSum() {
		BigInteger actual = LargeNumbers.sumTwoNumbers("98347259849859852342342237884", "0");
		BigInteger expected = new BigInteger("98347259849859852342342237884");

		assertEquals(expected, actual);
	}

}

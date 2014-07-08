package com.sirma.itt.javacourse.intro.numbers;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Tests {@link com.sirma.itt.javacourse.intro.numbers.LargeNumbers} class.
 * 
 * @author smustafov
 */
public class LargeNumbersTest {

	/**
	 * Tests the sum of two large positive numbers.
	 * {@link com.sirma.itt.javacourse.intro.numbers.LargeNumbers#sumTwoNumbers(java.lang.String, java.lang.String)}
	 * .
	 */
	@Test
	public void testPositiveTwoNumbersSum() {
		String actual = LargeNumbers.sumTwoNumbers("89237642346719412378", "32425298234278340234");
		String expected = "121662940580997752612";

		assertEquals(expected, actual);
	}

	/**
	 * Tests the sum of two large negative numbers.
	 * {@link com.sirma.itt.javacourse.intro.numbers.LargeNumbers#sumTwoNumbers(java.lang.String, java.lang.String)}
	 * .
	 */
	@Test
	public void testNegativeTwoNumbersSum() {
		String actual = LargeNumbers.sumTwoNumbers("-458747878438764529624392349",
				"-94832543248223487234790");
		String expected = "-458842710982012753111627139";

		assertEquals(expected, actual);
	}

	/**
	 * Tests the sum of two zeros.
	 * {@link com.sirma.itt.javacourse.intro.numbers.LargeNumbers#sumTwoNumbers(java.lang.String, java.lang.String)}
	 * .
	 */
	@Test
	public void testTwoZerosSum() {
		String actual = LargeNumbers.sumTwoNumbers("0", "0");
		String expected = "0";

		assertEquals(expected, actual);
	}

	/**
	 * Tests the sum of zero with a large number.
	 * {@link com.sirma.itt.javacourse.intro.numbers.LargeNumbers#sumTwoNumbers(java.lang.String, java.lang.String)}
	 * .
	 */
	@Test
	public void testOneNumberSum() {
		String actual = LargeNumbers.sumTwoNumbers("98347259849859852342342237884", "0");
		String expected = "98347259849859852342342237884";

		assertEquals(expected, actual);
	}

}

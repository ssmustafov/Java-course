package com.sirma.itt.javacourse.intro.numbers;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Tests {@link com.sirma.itt.javacourse.intro.numbers.CommonDivisor} class.
 * 
 * @author smustafov
 */
public class CommonDivisorTest {

	/**
	 * Tests GCD with zero and ordinary number.
	 * {@link com.sirma.itt.javacourse.intro.numbers.CommonDivisor#findGreatestCommonDivisor(long, long)}
	 * .
	 */
	@Test
	public void testGreatestCommonDivisorWithZero() {
		long actual = CommonDivisor.findGreatestCommonDivisor(0, 84);
		long expected = 84;

		assertEquals(expected, actual);
	}

	/**
	 * Tests GCD with two ordinary numbers.
	 * {@link com.sirma.itt.javacourse.intro.numbers.CommonDivisor#findGreatestCommonDivisor(long, long)}
	 * .
	 */
	@Test
	public void testGreatestCommonDivisorNormalNumbers() {
		long actual = CommonDivisor.findGreatestCommonDivisor(18, 84);
		long expected = 6;

		assertEquals(expected, actual);
	}

	/**
	 * Tests GCD with two negative numbers.
	 * {@link com.sirma.itt.javacourse.intro.numbers.CommonDivisor#findGreatestCommonDivisor(long, long)}
	 * .
	 */
	@Test
	public void testGreatestCommonDivisorNegativeNumbers() {
		long actual = CommonDivisor.findGreatestCommonDivisor(-6, -12);
		long expected = -6;

		assertEquals(expected, actual);
	}

	/**
	 * Tests GCD with two large numbers.
	 * {@link com.sirma.itt.javacourse.intro.numbers.CommonDivisor#findGreatestCommonDivisor(long, long)}
	 * .
	 */
	@Test
	public void testGreatestCommonDivisorLargeNumbers() {
		long actual = CommonDivisor.findGreatestCommonDivisor(654565646, 642323131);
		long expected = 1;

		assertEquals(expected, actual);
	}

	/**
	 * Tests GCD with two zeros.
	 * {@link com.sirma.itt.javacourse.intro.numbers.CommonDivisor#findGreatestCommonDivisor(long, long)}
	 * .
	 */
	@Test
	public void testGreatestCommonDivisorTwoZeros() {
		long actual = CommonDivisor.findGreatestCommonDivisor(0, 0);
		long expected = 1;

		assertEquals(expected, actual);
	}

	/**
	 * Tests LCM with zero and ordinary number.
	 * {@link com.sirma.itt.javacourse.intro.numbers.CommonDivisor#findLeastCommonMultiple(long, long)}
	 * .
	 */
	@Test
	public void testLeastCommonMultipleWithZero() {
		long actual = CommonDivisor.findLeastCommonMultiple(65, 0);
		long expected = 65;

		assertEquals(expected, actual);
	}

	/**
	 * Tests LCM with two ordinary numbers.
	 * {@link com.sirma.itt.javacourse.intro.numbers.CommonDivisor#findLeastCommonMultiple(long, long)}
	 * .
	 */
	@Test
	public void testLeastCommonMultipleNormalNumbers() {
		long actual = CommonDivisor.findLeastCommonMultiple(234, 164);
		long expected = 19188;

		assertEquals(expected, actual);
	}

	/**
	 * Tests LCM with two negative numbers.
	 * {@link com.sirma.itt.javacourse.intro.numbers.CommonDivisor#findLeastCommonMultiple(long, long)}
	 * .
	 */
	@Test
	public void testLeastCommonMultipleNegativeNumbers() {
		long actual = CommonDivisor.findLeastCommonMultiple(-15, -9);
		long expected = -45;

		assertEquals(expected, actual);
	}

	/**
	 * Tests LCM with two large numbers.
	 * {@link com.sirma.itt.javacourse.intro.numbers.CommonDivisor#findLeastCommonMultiple(long, long)}
	 * .
	 */
	@Test
	public void testLeastCommonMultipleLargeNumbers() {
		long actual = CommonDivisor.findLeastCommonMultiple(654565646, 642323131);
		long expected = 420442655183757626L;

		assertEquals(expected, actual);
	}

	/**
	 * Tests LCM with two zeros.
	 * {@link com.sirma.itt.javacourse.intro.numbers.CommonDivisor#findLeastCommonMultiple(long, long)}
	 * .
	 */
	@Test
	public void testLeastCommonMultipleTwoZeros() {
		long actual = CommonDivisor.findLeastCommonMultiple(0, 0);
		long expected = 0;

		assertEquals(expected, actual);
	}

}

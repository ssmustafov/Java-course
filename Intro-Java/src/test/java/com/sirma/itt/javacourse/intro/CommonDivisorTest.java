package com.sirma.itt.javacourse.intro;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Class for testing the {@link com.sirma.itt.javacourse.intro.CommonDivisor} class.
 * 
 * @author smustafov
 */
public class CommonDivisorTest {

	/**
	 * Test method for
	 * {@link com.sirma.itt.javacourse.intro.CommonDivisor#findGreatestCommonDivisor(long, long)}.
	 */
	@Test
	public void testGreatestCommonDivisorNormalNumbers() {
		long actual = CommonDivisor.findGreatestCommonDivisor(18, 84);
		long expected = 6;

		assertEquals(expected, actual);
	}

	/**
	 * Test method for
	 * {@link com.sirma.itt.javacourse.intro.CommonDivisor#findGreatestCommonDivisor(long, long)}.
	 */
	@Test
	public void testGreatestCommonDivisorNegativeNumbers() {
		long actual = CommonDivisor.findGreatestCommonDivisor(-6, -12);
		long expected = -6;

		assertEquals(expected, actual);
	}

	/**
	 * Test method for
	 * {@link com.sirma.itt.javacourse.intro.CommonDivisor#findGreatestCommonDivisor(long, long)}.
	 */
	@Test
	public void testGreatestCommonDivisorLargeNumbers() {
		long actual = CommonDivisor.findGreatestCommonDivisor(654565646, 642323131);
		long expected = 1;

		assertEquals(expected, actual);
	}

	/**
	 * Test method for
	 * {@link com.sirma.itt.javacourse.intro.CommonDivisor#findLeastCommonMultiple(long, long)}.
	 */
	@Test
	public void testLeastCommonMultipleNormalNumbers() {
		long actual = CommonDivisor.findLeastCommonMultiple(234, 164);
		long expected = 19188;

		assertEquals(expected, actual);
	}

	/**
	 * Test method for
	 * {@link com.sirma.itt.javacourse.intro.CommonDivisor#findLeastCommonMultiple(long, long)}.
	 */
	@Test
	public void testLeastCommonMultipleNegativeNumbers() {
		long actual = CommonDivisor.findLeastCommonMultiple(-15, -9);
		long expected = -45;

		assertEquals(expected, actual);
	}

	/**
	 * Test method for
	 * {@link com.sirma.itt.javacourse.intro.CommonDivisor#findLeastCommonMultiple(long, long)}.
	 */
	@Test
	public void testLeastCommonMultipleLargeNumbers() {
		long actual = CommonDivisor.findLeastCommonMultiple(654565646, 642323131);
		long expected = 420442655183757626L;

		assertEquals(expected, actual);
	}

}

package com.sirma.itt.javacourse.patterns.calculator;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Tests {@link com.sirma.itt.javacourse.patterns.calculator.MultiplicationCommand} class.
 * 
 * @author smustafov
 */
public class MultiplicationCommandTest {

	/**
	 * Tests {@link com.sirma.itt.javacourse.patterns.calculator.MultiplicationCommand} to multiply
	 * two zeros.
	 */
	@Test
	public void testMultiplyWithTwoZeros() {
		Calculator calc = new Calculator();
		MultiplicationCommand cmd = new MultiplicationCommand(calc);
		calc.setResult(0L);

		long actual = cmd.execute(0L);
		long expected = 0L;

		assertEquals(expected, actual);
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.patterns.calculator.MultiplicationCommand} to
	 * multiplicate a number to zero.
	 */
	@Test
	public void testMultiplyWithZero() {
		Calculator calc = new Calculator();
		MultiplicationCommand cmd = new MultiplicationCommand(calc);
		calc.setResult(0L);

		long actual = cmd.execute(10L);
		long expected = 0L;

		assertEquals(expected, actual);
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.patterns.calculator.MultiplicationCommand} to
	 * multiplicate two small positive numbers.
	 */
	@Test
	public void testMultiplyPositiveSmallNumbers() {
		Calculator calc = new Calculator();
		MultiplicationCommand cmd = new MultiplicationCommand(calc);
		calc.setResult(100L);

		long actual = cmd.execute(100L);
		long expected = 1_0000L;

		assertEquals(expected, actual);
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.patterns.calculator.MultiplicationCommand} to
	 * multiplicate two small negative numbers.
	 */
	@Test
	public void testMultiplyNegativeSmallNumbers() {
		Calculator calc = new Calculator();
		MultiplicationCommand cmd = new MultiplicationCommand(calc);
		calc.setResult(-100L);

		long actual = cmd.execute(-100L);
		long expected = 1_0000L;

		assertEquals(expected, actual);
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.patterns.calculator.MultiplicationCommand} to
	 * multiplicate positive and negative small numbers.
	 */
	@Test
	public void testMultiplyNegativeAndPositiveSmallNumbers() {
		Calculator calc = new Calculator();
		MultiplicationCommand cmd = new MultiplicationCommand(calc);
		calc.setResult(-100L);

		long actual = cmd.execute(100L);
		long expected = -1_0000L;

		assertEquals(expected, actual);
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.patterns.calculator.MultiplicationCommand} to
	 * multiplicate two large positive numbers.
	 */
	@Test
	public void testMultiplyTwoPositiveLargeNumbers() {
		Calculator calc = new Calculator();
		MultiplicationCommand cmd = new MultiplicationCommand(calc);
		calc.setResult(100_000_000L);

		long actual = cmd.execute(100_000L);
		long expected = 10_000_000_000_000L;

		assertEquals(expected, actual);
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.patterns.calculator.MultiplicationCommand} to
	 * multiplicate two large negative numbers.
	 */
	@Test
	public void testMultiplyTwoNegativeLargeNumbers() {
		Calculator calc = new Calculator();
		MultiplicationCommand cmd = new MultiplicationCommand(calc);
		calc.setResult(-100_000_000L);

		long actual = cmd.execute(-100_000L);
		long expected = 10_000_000_000_000L;

		assertEquals(expected, actual);
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.patterns.calculator.MultiplicationCommand} to
	 * multiplicate positive and negative small numbers.
	 */
	@Test
	public void testMultiplyNegativeAndPositiveLargeNumbers() {
		Calculator calc = new Calculator();
		MultiplicationCommand cmd = new MultiplicationCommand(calc);
		calc.setResult(100_000_000L);

		long actual = cmd.execute(-100_000L);
		long expected = -10_000_000_000_000L;

		assertEquals(expected, actual);
	}

}

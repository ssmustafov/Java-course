package com.sirma.itt.javacourse.patterns.calculator;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Tests {@link com.sirma.itt.javacourse.patterns.calculator.PowerCommand}.
 * 
 * @author smustafov
 */
public class PowerCommandTest {

	/**
	 * Tests {@link com.sirma.itt.javacourse.patterns.calculator.PowerCommand} with 0^0.
	 */
	@Test
	public void testPowerZeroWithZero() {
		Calculator calc = new Calculator();
		PowerCommand cmd = new PowerCommand(calc);
		calc.setResult(0L);

		long actual = cmd.execute(0L);
		long expected = 1L;

		assertEquals(expected, actual);
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.patterns.calculator.PowerCommand} with 0^(positive
	 * number).
	 */
	@Test
	public void testPowerZeroWithPositiveNumber() {
		Calculator calc = new Calculator();
		PowerCommand cmd = new PowerCommand(calc);
		calc.setResult(0L);

		long actual = cmd.execute(5L);
		long expected = 0L;

		assertEquals(expected, actual);
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.patterns.calculator.PowerCommand} with (positive
	 * number)^0.
	 */
	@Test
	public void testPowerPositiveNumberWithZero() {
		Calculator calc = new Calculator();
		PowerCommand cmd = new PowerCommand(calc);
		calc.setResult(1024L);

		long actual = cmd.execute(0L);
		long expected = 1L;

		assertEquals(expected, actual);
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.patterns.calculator.PowerCommand} with (negative
	 * number)^0.
	 */
	@Test
	public void testPowerNegativeNumberWithZero() {
		Calculator calc = new Calculator();
		PowerCommand cmd = new PowerCommand(calc);
		calc.setResult(-1024L);

		long actual = cmd.execute(0L);
		long expected = 1L;

		assertEquals(expected, actual);
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.patterns.calculator.PowerCommand} with 1^(number).
	 */
	@Test
	public void testPowerOneWithAnyNumber() {
		Calculator calc = new Calculator();
		PowerCommand cmd = new PowerCommand(calc);
		calc.setResult(1L);

		long actual = cmd.execute(50000L);
		long expected = 1L;

		assertEquals(expected, actual);
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.patterns.calculator.PowerCommand} with (positive
	 * number)^(positive number).
	 */
	@Test
	public void testPositiveNumWithPositivePower() {
		Calculator calc = new Calculator();
		PowerCommand cmd = new PowerCommand(calc);
		calc.setResult(2L);

		long actual = cmd.execute(10L);
		long expected = 1024L;

		assertEquals(expected, actual);
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.patterns.calculator.PowerCommand} with (positive
	 * number)^(negative number).
	 */
	@Test
	public void testPositiveNumWithNegativePower() {
		Calculator calc = new Calculator();
		PowerCommand cmd = new PowerCommand(calc);
		calc.setResult(2L);

		long actual = cmd.execute(-10L);
		long expected = 0L;

		assertEquals(expected, actual);
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.patterns.calculator.PowerCommand} with (positive large
	 * number)^(positive number).
	 */
	@Test
	public void testPositiveLargeNumWithPositivePower() {
		Calculator calc = new Calculator();
		PowerCommand cmd = new PowerCommand(calc);
		calc.setResult(100_000L);

		long actual = cmd.execute(2L);
		long expected = 10_000_000_000L;

		assertEquals(expected, actual);
	}

}

package com.sirma.itt.javacourse.patterns.calculator;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Tests {@link com.sirma.itt.javacourse.patterns.calculator.DivisionCommand} class.
 * 
 * @author smustafov
 */
public class DivisionCommandTest {

	/**
	 * Tests {@link com.sirma.itt.javacourse.patterns.calculator.DivisionCommand} with divisible
	 * zero.
	 */
	@Test
	public void testDivisionWithZero() {
		Calculator calc = new Calculator();
		DivisionCommand cmd = new DivisionCommand(calc);
		calc.setResult(0L);

		long actual = cmd.execute(5L);
		long expected = 0L;

		assertEquals(expected, actual);
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.patterns.calculator.DivisionCommand} by end result to
	 * be a real number and if its converted properly to integer.
	 */
	@Test
	public void testDivisionWithResultRealNumber() {
		Calculator calc = new Calculator();
		DivisionCommand cmd = new DivisionCommand(calc);
		calc.setResult(58L);

		long actual = cmd.execute(11L);
		long expected = 5L;

		assertEquals(expected, actual);
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.patterns.calculator.DivisionCommand} with negative and
	 * positive numbers and result to be a real negative number and if its converted properly to
	 * integer.
	 */
	@Test
	public void testDivisionWithOneNegativeResultRealNumber() {
		Calculator calc = new Calculator();
		DivisionCommand cmd = new DivisionCommand(calc);
		calc.setResult(-58L);

		long actual = cmd.execute(11L);
		long expected = -5L;

		assertEquals(expected, actual);
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.patterns.calculator.DivisionCommand} with two negative
	 * numbers and result to be a real positive number and if its converted properly to integer.
	 */
	@Test
	public void testDivisionWithTwoNegativeResultRealNumber() {
		Calculator calc = new Calculator();
		DivisionCommand cmd = new DivisionCommand(calc);
		calc.setResult(-58L);

		long actual = cmd.execute(-11L);
		long expected = 5L;

		assertEquals(expected, actual);
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.patterns.calculator.DivisionCommand} with negative and
	 * positive large numbers and result to be a real negative number and if its converted properly
	 * to integer.
	 */
	@Test
	public void testDivisionWithOneNegativeLargeNumsReal() {
		Calculator calc = new Calculator();
		DivisionCommand cmd = new DivisionCommand(calc);
		calc.setResult(-58_000_000_000L);

		long actual = cmd.execute(11_000_000L);
		long expected = -5272L;

		assertEquals(expected, actual);
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.patterns.calculator.DivisionCommand} with two negative
	 * large numbers and result to be a real positive number and if its converted properly to
	 * integer.
	 */
	@Test
	public void testDivisionWithTwoNegativeLargeNumsReal() {
		Calculator calc = new Calculator();
		DivisionCommand cmd = new DivisionCommand(calc);
		calc.setResult(-58_000_000_000L);

		long actual = cmd.execute(-11_000_000L);
		long expected = 5272L;

		assertEquals(expected, actual);
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.patterns.calculator.DivisionCommand}.
	 */
	@Test
	public void testNormalDivision() {
		Calculator calc = new Calculator();
		DivisionCommand cmd = new DivisionCommand(calc);
		calc.setResult(200L);

		long actual = cmd.execute(8L);
		long expected = 25L;

		assertEquals(expected, actual);
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.patterns.calculator.DivisionCommand} with large
	 * numbers.
	 */
	@Test
	public void testDivisionLargeNumbers() {
		Calculator calc = new Calculator();
		DivisionCommand cmd = new DivisionCommand(calc);
		calc.setResult(4_000_000_000L);

		long actual = cmd.execute(2_000_000_000L);
		long expected = 2L;

		assertEquals(expected, actual);
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.patterns.calculator.DivisionCommand} with two negative
	 * small numbers.
	 */
	@Test
	public void testDivisionSmallTwoNegativeNumbers() {
		Calculator calc = new Calculator();
		DivisionCommand cmd = new DivisionCommand(calc);
		calc.setResult(-200L);

		long actual = cmd.execute(-20L);
		long expected = 10L;

		assertEquals(expected, actual);
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.patterns.calculator.DivisionCommand} with negative and
	 * positive small numbers.
	 */
	@Test
	public void testDivisionSmallOneNegativeNumbers() {
		Calculator calc = new Calculator();
		DivisionCommand cmd = new DivisionCommand(calc);
		calc.setResult(200L);

		long actual = cmd.execute(-20L);
		long expected = -10L;

		assertEquals(expected, actual);
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.patterns.calculator.DivisionCommand} with two negative
	 * large numbers.
	 */
	@Test
	public void testDivisionLargeTwoNegativeNumbers() {
		Calculator calc = new Calculator();
		DivisionCommand cmd = new DivisionCommand(calc);
		calc.setResult(-2_000_000_000L);

		long actual = cmd.execute(-5000L);
		long expected = 400000L;

		assertEquals(expected, actual);
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.patterns.calculator.DivisionCommand} with negative and
	 * positive large numbers.
	 */
	@Test
	public void testDivisionLargeOneNegativeNumbers() {
		Calculator calc = new Calculator();
		DivisionCommand cmd = new DivisionCommand(calc);
		calc.setResult(2_000_000_000L);

		long actual = cmd.execute(-5000L);
		long expected = -400000L;

		assertEquals(expected, actual);
	}

}

package com.sirma.itt.javacourse.patterns.calculator;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Tests {@link com.sirma.itt.javacourse.patterns.calculator.AdditionCommand} class.
 * 
 * @author smustafov
 */
public class AdditionCommandTest {

	/**
	 * Tests {@link com.sirma.itt.javacourse.patterns.calculator.AdditionCommand} to add two zeros.
	 */
	@Test
	public void testAdditionWithTwoZeros() {
		Calculator calc = new Calculator();
		AdditionCommand cmd = new AdditionCommand(calc);
		calc.setResult(0L);

		long actual = cmd.execute(0L);
		long expected = 0L;

		assertEquals(expected, actual);
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.patterns.calculator.AdditionCommand} to add zero with
	 * positive number.
	 */
	@Test
	public void testAdditionWithZeroAndPositiveNumber() {
		Calculator calc = new Calculator();
		AdditionCommand cmd = new AdditionCommand(calc);
		calc.setResult(0L);

		long actual = cmd.execute(100L);
		long expected = 100L;

		assertEquals(expected, actual);
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.patterns.calculator.AdditionCommand} to add zero with
	 * negative number.
	 */
	@Test
	public void testAdditionWithZeroAndNegativeNumber() {
		Calculator calc = new Calculator();
		AdditionCommand cmd = new AdditionCommand(calc);
		calc.setResult(0L);

		long actual = cmd.execute(-99L);
		long expected = -99L;

		assertEquals(expected, actual);
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.patterns.calculator.AdditionCommand} addition with two
	 * positive small numbers.
	 */
	@Test
	public void testAdditionWithTwoPositiveSmallNumbers() {
		Calculator calc = new Calculator();
		AdditionCommand cmd = new AdditionCommand(calc);
		calc.setResult(245L);

		long actual = cmd.execute(35L);
		long expected = 280L;

		assertEquals(expected, actual);
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.patterns.calculator.AdditionCommand} addition with two
	 * positive large numbers.
	 */
	@Test
	public void testAdditionWithTwoPositiveLargeNumbers() {
		Calculator calc = new Calculator();
		AdditionCommand cmd = new AdditionCommand(calc);
		calc.setResult(245_000_000_000L);

		long actual = cmd.execute(35_000_000_000L);
		long expected = 280_000_000_000L;

		assertEquals(expected, actual);
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.patterns.calculator.AdditionCommand} addition with two
	 * negative large numbers.
	 */
	@Test
	public void testAdditionWithTwoNegativeLargeNumbers() {
		Calculator calc = new Calculator();
		AdditionCommand cmd = new AdditionCommand(calc);
		calc.setResult(-245_000_000_000L);

		long actual = cmd.execute(-35_000_000_000L);
		long expected = -280_000_000_000L;

		assertEquals(expected, actual);
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.patterns.calculator.AdditionCommand} addition with
	 * negative number and positive number.
	 */
	@Test
	public void testAdditionWithNegativeAndPositive() {
		Calculator calc = new Calculator();
		AdditionCommand cmd = new AdditionCommand(calc);
		calc.setResult(-245L);

		long actual = cmd.execute(35L);
		long expected = -210L;

		assertEquals(expected, actual);
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.patterns.calculator.AdditionCommand} addition with
	 * negative number and positive number which equals to zero.
	 */
	@Test
	public void testAdditionWithNegativeAndPositiveToZero() {
		Calculator calc = new Calculator();
		AdditionCommand cmd = new AdditionCommand(calc);
		calc.setResult(-100L);

		long actual = cmd.execute(100L);
		long expected = 0L;

		assertEquals(expected, actual);
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.patterns.calculator.AdditionCommand} addition with
	 * positive number and negative number which equals to zero.
	 */
	@Test
	public void testAdditionWithPositiveAndNegativeToZero() {
		Calculator calc = new Calculator();
		AdditionCommand cmd = new AdditionCommand(calc);
		calc.setResult(100L);

		long actual = cmd.execute(-100L);
		long expected = 0L;

		assertEquals(expected, actual);
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.patterns.calculator.AdditionCommand} addition with two
	 * negative small numbers.
	 */
	@Test
	public void testAdditionWithTwoNegativeSmallNumbers() {
		Calculator calc = new Calculator();
		AdditionCommand cmd = new AdditionCommand(calc);
		calc.setResult(-299L);

		long actual = cmd.execute(-11L);
		long expected = -310L;

		assertEquals(expected, actual);
	}

}

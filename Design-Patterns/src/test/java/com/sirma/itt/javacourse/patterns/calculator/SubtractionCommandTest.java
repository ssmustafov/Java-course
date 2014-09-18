package com.sirma.itt.javacourse.patterns.calculator;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Tests {@link com.sirma.itt.javacourse.patterns.calculator.SubtractionCommand} class.
 * 
 * @author smustafov
 */
public class SubtractionCommandTest {

	/**
	 * Tests {@link com.sirma.itt.javacourse.patterns.calculator.SubtractionCommand} to subtract
	 * 0-0.
	 */
	@Test
	public void testSubtractTwoZeros() {
		Calculator calc = new Calculator();
		SubtractionCommand cmd = new SubtractionCommand(calc);
		calc.setResult(0L);

		long actual = cmd.execute(0L);
		long expected = 0L;

		assertEquals(expected, actual);
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.patterns.calculator.SubtractionCommand} to subtract
	 * 0-(positive small number).
	 */
	@Test
	public void testSubtractFromZeroPositiveSmallNum() {
		Calculator calc = new Calculator();
		SubtractionCommand cmd = new SubtractionCommand(calc);
		calc.setResult(0L);

		long actual = cmd.execute(100L);
		long expected = -100L;

		assertEquals(expected, actual);
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.patterns.calculator.SubtractionCommand} to subtract
	 * 0-(positive large number).
	 */
	@Test
	public void testSubtractFromZeroPositiveLargeNum() {
		Calculator calc = new Calculator();
		SubtractionCommand cmd = new SubtractionCommand(calc);
		calc.setResult(0L);

		long actual = cmd.execute(100_000_000L);
		long expected = -100_000_000L;

		assertEquals(expected, actual);
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.patterns.calculator.SubtractionCommand} to subtract
	 * (negative number)-(positive number).
	 */
	@Test
	public void testSubtractFromNegativePositiveNum() {
		Calculator calc = new Calculator();
		SubtractionCommand cmd = new SubtractionCommand(calc);
		calc.setResult(-10L);

		long actual = cmd.execute(8L);
		long expected = -18L;

		assertEquals(expected, actual);
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.patterns.calculator.SubtractionCommand} to subtract
	 * (negative number)-(negative number).
	 */
	@Test
	public void testSubtractFromNegativeAlsoNegativeNum() {
		Calculator calc = new Calculator();
		SubtractionCommand cmd = new SubtractionCommand(calc);
		calc.setResult(-10L);

		long actual = cmd.execute(-8L);
		long expected = -2L;

		assertEquals(expected, actual);
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.patterns.calculator.SubtractionCommand} to subtract
	 * (positive number)-(positive number).
	 */
	@Test
	public void testSubtractFromPositiveAlsoPositiveNum() {
		Calculator calc = new Calculator();
		SubtractionCommand cmd = new SubtractionCommand(calc);
		calc.setResult(100L);

		long actual = cmd.execute(18L);
		long expected = 82L;

		assertEquals(expected, actual);
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.patterns.calculator.SubtractionCommand} to subtract
	 * (positive small number)-(positive large number).
	 */
	@Test
	public void testSubtract() {
		Calculator calc = new Calculator();
		SubtractionCommand cmd = new SubtractionCommand(calc);
		calc.setResult(100L);

		long actual = cmd.execute(5_000_000L);
		long expected = -4_999_900L;

		assertEquals(expected, actual);
	}

}

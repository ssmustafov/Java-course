package com.sirma.itt.javacourse.patterns.calculator;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Tests {@link com.sirma.itt.javacourse.patterns.calculator.ConsoleCalculato} class.
 * 
 * @author Sinan
 */
public class ConsoleCalculatorTest {

	/**
	 * Tests {@link com.sirma.itt.javacourse.patterns.calculator.ConsoleCalculator} with invalid
	 * input: "a + b".
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testWithInvalidInput() {
		CalculatorReader r = new UnitTestReader(new String[] { "a", "+", "b", "end" });
		ConsoleCalculator c = new ConsoleCalculator(r);
		c.run();
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.patterns.calculator.ConsoleCalculator} with empty
	 * input.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testWithEmptyInput() {
		CalculatorReader r = new UnitTestReader(new String[] { "", "" });
		ConsoleCalculator c = new ConsoleCalculator(r);
		c.run();
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.patterns.calculator.ConsoleCalculator} with addition
	 * operation.
	 */
	@Test
	public void testAdditonCommand() {
		CalculatorReader r = new UnitTestReader(new String[] { "5", "+", "10", "end" });
		ConsoleCalculator c = new ConsoleCalculator(r);
		c.run();

		String actual = c.getResult();
		String expected = "15.0";

		assertEquals(expected, actual);
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.patterns.calculator.ConsoleCalculator} with division
	 * operation.
	 */
	@Test
	public void testDivisonCommand() {
		CalculatorReader r = new UnitTestReader(new String[] { "5", "/", "2", "end" });
		ConsoleCalculator c = new ConsoleCalculator(r);
		c.run();

		String actual = c.getResult();
		String expected = "2.5";

		assertEquals(expected.toString(), actual);
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.patterns.calculator.ConsoleCalculator} with
	 * multiplication operation.
	 */
	@Test
	public void testMultiplicationCommand() {
		CalculatorReader r = new UnitTestReader(new String[] { "5", "*", "10", "end" });
		ConsoleCalculator c = new ConsoleCalculator(r);
		c.run();

		String actual = c.getResult();
		String expected = "50.0";

		assertEquals(expected, actual);
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.patterns.calculator.ConsoleCalculator} with subtract
	 * operation.
	 */
	@Test
	public void testSubtractCommand() {
		CalculatorReader r = new UnitTestReader(new String[] { "5", "-", "10", "end" });
		ConsoleCalculator c = new ConsoleCalculator(r);
		c.run();

		String actual = c.getResult();
		String expected = "-5.0";

		assertEquals(expected, actual);
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.patterns.calculator.ConsoleCalculator} with powering
	 * operation.
	 */
	@Test
	public void testPowerCommand() {
		CalculatorReader r = new UnitTestReader(new String[] { "5", "^", "2", "end" });
		ConsoleCalculator c = new ConsoleCalculator(r);
		c.run();

		String actual = c.getResult();
		String expected = "25.0";

		assertEquals(expected, actual);
	}
}

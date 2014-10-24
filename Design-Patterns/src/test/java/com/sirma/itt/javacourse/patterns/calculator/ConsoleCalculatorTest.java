package com.sirma.itt.javacourse.patterns.calculator;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

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
	 * 
	 * @throws IOException
	 *             - not expected exception
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testWithInvalidInput() throws IOException {
		CalculatorReader r = new UnitTestReader(new String[] { "a", "+", "b", "end" });
		ConsoleCalculator c = new ConsoleCalculator(r);
		c.run();
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.patterns.calculator.ConsoleCalculator} with empty
	 * input.
	 * 
	 * @throws IOException
	 *             - not expected exception
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testWithEmptyInput() throws IOException {
		CalculatorReader r = new UnitTestReader(new String[] { "", "" });
		ConsoleCalculator c = new ConsoleCalculator(r);
		c.run();
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.patterns.calculator.ConsoleCalculator} with addition
	 * operation.
	 * 
	 * @throws IOException
	 *             - not expected exception
	 */
	@Test
	public void testAdditonCommand() throws IOException {
		CalculatorReader r = new UnitTestReader(new String[] { "5", "+", "10", "end" });
		ConsoleCalculator c = new ConsoleCalculator(r);
		c.run();

		String actual = c.getResult();
		String expected = "15";

		assertEquals(expected, actual);
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.patterns.calculator.ConsoleCalculator} with division
	 * operation.
	 * 
	 * @throws IOException
	 *             - not expected exception
	 */
	@Test
	public void testDivisonCommand() throws IOException {
		CalculatorReader r = new UnitTestReader(new String[] { "5", "/", "2", "end" });
		ConsoleCalculator c = new ConsoleCalculator(r);
		c.run();

		String actual = c.getResult();
		StringBuilder expected = new StringBuilder();

		expected.append("2.5");
		for (int i = 1; i < DivisionCommand.DECIMAL_PRECISION; i++) {
			expected.append("0");
		}

		assertEquals(expected.toString(), actual);
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.patterns.calculator.ConsoleCalculator} with
	 * multiplication operation.
	 * 
	 * @throws IOException
	 *             - not expected exception
	 */
	@Test
	public void testMultiplicationCommand() throws IOException {
		CalculatorReader r = new UnitTestReader(new String[] { "5", "*", "10", "end" });
		ConsoleCalculator c = new ConsoleCalculator(r);
		c.run();

		String actual = c.getResult();
		String expected = "50";

		assertEquals(expected, actual);
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.patterns.calculator.ConsoleCalculator} with subtract
	 * operation.
	 * 
	 * @throws IOException
	 *             - not expected exception
	 */
	@Test
	public void testSubtractCommand() throws IOException {
		CalculatorReader r = new UnitTestReader(new String[] { "5", "-", "10", "end" });
		ConsoleCalculator c = new ConsoleCalculator(r);
		c.run();

		String actual = c.getResult();
		String expected = "-5";

		assertEquals(expected, actual);
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.patterns.calculator.ConsoleCalculator} with powering
	 * operation.
	 * 
	 * @throws IOException
	 *             - not expected exception
	 */
	@Test
	public void testPowerCommand() throws IOException {
		CalculatorReader r = new UnitTestReader(new String[] { "5", "^", "2", "end" });
		ConsoleCalculator c = new ConsoleCalculator(r);
		c.run();

		String actual = c.getResult();
		String expected = "25";

		assertEquals(expected, actual);
	}
}

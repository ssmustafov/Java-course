package com.sirma.itt.javacourse.patterns.calculator;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Tests {@link com.sirma.itt.javacourse.patterns.calculator.CalculatorManager} class.
 * 
 * @author smustafov
 */
public class CalculatorManagerTest {

	/**
	 * Tests
	 * {@link com.sirma.itt.javacourse.patterns.calculator.CalculatorManager#compute(com.sirma.itt.javacourse.patterns.calculator.Operations, long)}
	 * to check if it invokes addition operation properly.
	 */
	@Test
	public void testComputeAddition() {
		CalculatorManager manager = new CalculatorManager();
		manager.compute(Operations.Add, "100", "10");

		String actual = manager.toString();
		String expected = "110";

		assertEquals(expected, actual);
	}

	/**
	 * Tests
	 * {@link com.sirma.itt.javacourse.patterns.calculator.CalculatorManager#compute(com.sirma.itt.javacourse.patterns.calculator.Operations, long)}
	 * to check if it invokes subtraction operation properly.
	 */
	@Test
	public void testComputeSubtraction() {
		CalculatorManager manager = new CalculatorManager();
		manager.compute(Operations.Subtract, "100", "10");

		String actual = manager.toString();
		String expected = "90";

		assertEquals(expected, actual);
	}

	/**
	 * Tests
	 * {@link com.sirma.itt.javacourse.patterns.calculator.CalculatorManager#compute(com.sirma.itt.javacourse.patterns.calculator.Operations, long)}
	 * to check if it invokes division operation properly.
	 */
	@Test
	public void testComputeDivision() {
		int precision = DivisionCommand.DECIMAL_PRECISION;
		CalculatorManager manager = new CalculatorManager();
		manager.compute(Operations.Divide, "100", "10");

		String actual = manager.toString();

		StringBuilder expected = new StringBuilder();
		expected.append("10.");
		for (int i = 0; i < precision; i++) {
			expected.append("0");
		}

		assertEquals(expected.toString(), actual);
	}

	/**
	 * Tests
	 * {@link com.sirma.itt.javacourse.patterns.calculator.CalculatorManager#compute(com.sirma.itt.javacourse.patterns.calculator.Operations, long)}
	 * to check if it invokes multiplication operation properly.
	 */
	@Test
	public void testComputeMultiplication() {
		CalculatorManager manager = new CalculatorManager();
		manager.compute(Operations.Multiply, "100", "10");

		String actual = manager.toString();
		String expected = "1000";

		assertEquals(expected, actual);
	}

	/**
	 * Tests
	 * {@link com.sirma.itt.javacourse.patterns.calculator.CalculatorManager#compute(com.sirma.itt.javacourse.patterns.calculator.Operations, long)}
	 * to check if it invokes power operation properly.
	 */
	@Test
	public void testComputePower() {
		CalculatorManager manager = new CalculatorManager();
		manager.compute(Operations.Power, "10", "2");

		String actual = manager.toString();
		String expected = "100";

		assertEquals(expected, actual);
	}

}

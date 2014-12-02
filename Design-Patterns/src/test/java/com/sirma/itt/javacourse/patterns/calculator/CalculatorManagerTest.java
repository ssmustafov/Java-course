package com.sirma.itt.javacourse.patterns.calculator;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Tests {@link com.sirma.itt.javacourse.patterns.calculator.CalculatorManager} class.
 * 
 * @author smustafov
 */
public class CalculatorManagerTest {
	private static final double DELTA = 1e-15;

	/**
	 * Tests
	 * {@link com.sirma.itt.javacourse.patterns.calculator.CalculatorManager#compute(com.sirma.itt.javacourse.patterns.calculator.Operations, long)}
	 * to check if it invokes addition operation properly.
	 */
	@Test
	public void testComputeAddition() {
		CalculatorManager manager = new CalculatorManager();

		double actual = manager.compute(Operations.Add, 100, 10);
		double expected = 110.0;

		assertEquals(expected, actual, DELTA);
	}

	/**
	 * Tests
	 * {@link com.sirma.itt.javacourse.patterns.calculator.CalculatorManager#compute(com.sirma.itt.javacourse.patterns.calculator.Operations, long)}
	 * to check if it invokes subtraction operation properly.
	 */
	@Test
	public void testComputeSubtraction() {
		CalculatorManager manager = new CalculatorManager();

		double actual = manager.compute(Operations.Subtract, 100, 10);
		double expected = 90.0;

		assertEquals(expected, actual, DELTA);
	}

	/**
	 * Tests
	 * {@link com.sirma.itt.javacourse.patterns.calculator.CalculatorManager#compute(com.sirma.itt.javacourse.patterns.calculator.Operations, long)}
	 * to check if it invokes division operation properly.
	 */
	@Test
	public void testComputeDivision() {
		CalculatorManager manager = new CalculatorManager();

		double actual = manager.compute(Operations.Divide, 100, 10);
		double expected = 10.0;

		assertEquals(expected, actual, DELTA);
	}

	/**
	 * Tests
	 * {@link com.sirma.itt.javacourse.patterns.calculator.CalculatorManager#compute(com.sirma.itt.javacourse.patterns.calculator.Operations, long)}
	 * to check if it invokes multiplication operation properly.
	 */
	@Test
	public void testComputeMultiplication() {
		CalculatorManager manager = new CalculatorManager();

		double actual = manager.compute(Operations.Multiply, 100, 10);
		double expected = 1000.0;

		assertEquals(expected, actual, DELTA);
	}

	/**
	 * Tests
	 * {@link com.sirma.itt.javacourse.patterns.calculator.CalculatorManager#compute(com.sirma.itt.javacourse.patterns.calculator.Operations, long)}
	 * to check if it invokes power operation properly.
	 */
	@Test
	public void testComputePower() {
		CalculatorManager manager = new CalculatorManager();

		double actual = manager.compute(Operations.Power, 2, 10);
		double expected = 1024.0;

		assertEquals(expected, actual, DELTA);
	}

}

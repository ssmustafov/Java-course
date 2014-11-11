package com.sirma.itt.javacourse.patterns.calculator;

import java.math.BigDecimal;

/**
 * Does the real calculations. This class must be used to work with the calculator.
 * 
 * @author smustafov
 */
public class CalculatorManager {
	private BigDecimal result = new BigDecimal("0");

	/**
	 * Computes given operation with given number.
	 * 
	 * @param operation
	 *            - operation to be executed
	 * @param a
	 *            - the first number of the operation
	 * @param b
	 *            - the second number of the operation
	 */
	public void compute(Operations operation, String a, String b) {
		Command command = CommandFactory.createCommand(operation);

		result = command.execute(new BigDecimal(a), new BigDecimal(b));
	}

	/**
	 * Returns the result in the calculator.
	 * 
	 * @return - the result in the calculator
	 */
	public BigDecimal getResult() {
		return result;
	}

	/**
	 * Sets the result in the calculator.
	 * 
	 * @param newResult
	 *            - number to be set as result to the calculator
	 */
	public void setResult(String newResult) {
		if (newResult.isEmpty()) {
			throw new IllegalArgumentException("The result cannot be empty");
		}
		if (!newResult.matches("[0-9.-]+")) {
			throw new IllegalArgumentException("The result must only contain: a number, '.', '-'");
		}

		result = new BigDecimal(newResult);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return result.toString();
	}
}

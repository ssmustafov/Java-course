package com.sirma.itt.javacourse.patterns.calculator;

/**
 * Does the real calculations. This class must be used to work with the calculator.
 * 
 * @author smustafov
 */
public class CalculatorManager {
	private double result = 0;

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
	public void compute(Operations operation, double a, double b) {
		Command command = CommandFactory.createCommand(operation);

		result = command.execute(a, b);
	}

	/**
	 * Returns the result in the calculator.
	 * 
	 * @return - the result in the calculator
	 */
	public double getResult() {
		return result;
	}

	/**
	 * Sets the result in the calculator.
	 * 
	 * @param newResult
	 *            - number to be set as result to the calculator
	 */
	public void setResult(double newResult) {
		result = newResult;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return Double.toString(result);
	}
}

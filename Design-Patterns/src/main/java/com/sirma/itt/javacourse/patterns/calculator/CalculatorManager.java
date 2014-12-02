package com.sirma.itt.javacourse.patterns.calculator;

/**
 * Does the real calculations. This class must be used to work with the calculator.
 * 
 * @author smustafov
 */
public class CalculatorManager {

	/**
	 * Computes given operation with given number.
	 * 
	 * @param operation
	 *            - operation to be executed
	 * @param a
	 *            - the first number of the operation
	 * @param b
	 *            - the second number of the operation
	 * @return - the calculated result
	 */
	public double compute(Operations operation, double a, double b) {
		Command command = CommandFactory.createCommand(operation);

		return command.execute(a, b);
	}

}

package com.sirma.itt.javacourse.patterns.calculator;

/**
 * Interface for executing commands for the calculator. Works with double.
 * 
 * @author smustafov
 */
public interface Command {

	/**
	 * Executes and returns command depending on the implementation and uses the given numbers.
	 * 
	 * @param a
	 *            - the first number which will be operated
	 * @param b
	 *            - the second number which will be operated
	 * @return - the result of the operation
	 */
	double execute(double a, double b);
}

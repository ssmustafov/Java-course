package com.sirma.itt.javacourse.patterns.calculator;

/**
 * Interface for reading input for the calculator.
 * 
 * @author Sinan
 */
public interface CalculatorReader {

	/**
	 * Returns the read input from the user.
	 * 
	 * @return - the read input from the user
	 */
	String readInput();

	/**
	 * Prints the result in the calculator.
	 * 
	 * @param result
	 *            - the result to be printed
	 */
	void printResult(String result);
}

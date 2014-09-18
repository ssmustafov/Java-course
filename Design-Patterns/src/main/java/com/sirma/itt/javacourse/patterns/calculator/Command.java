package com.sirma.itt.javacourse.patterns.calculator;

/**
 * Interface for executing commands for the calculator.
 * 
 * @author smustafov
 */
public interface Command {

	/**
	 * Executes and returns command depending on the implementation and uses the given number.
	 * 
	 * @param number
	 *            - the number which will be operated
	 * @return - the result of the operation
	 */
	long execute(long number);

}

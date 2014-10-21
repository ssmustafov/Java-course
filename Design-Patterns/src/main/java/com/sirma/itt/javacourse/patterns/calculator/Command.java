package com.sirma.itt.javacourse.patterns.calculator;

import java.math.BigDecimal;

/**
 * Interface for executing commands for the calculator. Works with {@code BigDecimal}.
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
	BigDecimal execute(BigDecimal a, BigDecimal b);
}

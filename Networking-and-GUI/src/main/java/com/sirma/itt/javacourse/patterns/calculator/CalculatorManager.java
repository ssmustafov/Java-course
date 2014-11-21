package com.sirma.itt.javacourse.patterns.calculator;

import java.math.BigDecimal;

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
	public String compute(Operations operation, String a, String b) {
		Command command = CommandFactory.createCommand(operation);

		BigDecimal result = command.execute(new BigDecimal(a), new BigDecimal(b));
		return result.toString();
	}
}

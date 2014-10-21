package com.sirma.itt.javacourse.patterns.calculator;

import java.math.BigDecimal;

/**
 * Does the real calculations. This class must be used to work with the calculator.
 * 
 * @author smustafov
 */
public class CalculatorManager {
	private Calculator calc = new Calculator();

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
	public void compute(Operations operation, BigDecimal a, BigDecimal b) {
		// TODO: factory
		Command command = null;
		if (operation.equals(Operations.Add)) {
			command = new AdditionCommand();
		} else if (operation.equals(Operations.Divide)) {
			command = new DivisionCommand();
		} else if (operation.equals(Operations.Multiply)) {
			command = new MultiplicationCommand();
		} else if (operation.equals(Operations.Subtract)) {
			command = new SubtractionCommand();
		} else if (operation.equals(Operations.Power)) {
			command = new PowerCommand();
		}

		BigDecimal result = command.execute(a, b);
		calc.setResult(result);
	}

	/**
	 * Returns the result in the calculator.
	 * 
	 * @return - the result in the calculator
	 */
	public BigDecimal getResult() {
		return calc.getResult();
	}

	/**
	 * Sets the result in the calculator.
	 * 
	 * @param newResult
	 *            - number to be set as result to the calculator
	 */
	public void setResult(BigDecimal newResult) {
		calc.setResult(newResult);
	}
}

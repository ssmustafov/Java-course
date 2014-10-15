package com.sirma.itt.javacourse.patterns.calculator;

/**
 * Does the real calculations. This class must be used to work with the calculator.
 * 
 * @author smustafov
 */
public class CalculatorManager {

	private final Calculator calc = new Calculator();

	/**
	 * Computes given operation with given number.
	 * 
	 * @param operation
	 *            - operation to be executed
	 * @param number
	 *            - number with the operation to be executed
	 */
	public void compute(Operations operation, long number) {
		Command command = null;
		if (operation.equals(Operations.Add)) {
			command = new AdditionCommand(calc);
		} else if (operation.equals(Operations.Divide)) {
			command = new DivisionCommand(calc);
		} else if (operation.equals(Operations.Multiply)) {
			command = new MultiplicationCommand(calc);
		} else if (operation.equals(Operations.Subtract)) {
			command = new SubtractionCommand(calc);
		} else if (operation.equals(Operations.Power)) {
			command = new PowerCommand(calc);
		}

		long result = command.execute(number);
		calc.setResult(result);
	}

	/**
	 * Returns the result in the calculator.
	 * 
	 * @return - the result in the calculator
	 */
	public long getResult() {
		return calc.getResult();
	}

	/**
	 * Sets the result in the calculator.
	 * 
	 * @param number
	 *            - number to be set as result to the calculator
	 */
	public void setResult(long number) {
		calc.setResult(number);
	}

}

package com.sirma.itt.javacourse.patterns.calculator;

/**
 * @author smustafov
 */
public class CalculatorManager {

	private final Calculator calc = new Calculator();

	public void compute(Operations operation, int number) {
		Command command = null;
		if (operation.equals(Operations.Add)) {
			command = new AdditionCommand(calc);
		} else if (operation.equals(Operations.Divide)) {
			command = new DivisionCommand(calc);
		} else if (operation.equals(Operations.Multiply)) {
			command = new MultiplicationCommand(calc);
		} else if (operation.equals(Operations.Substract)) {
			command = new SubstractionCommand(calc);
		} else if (operation.equals(Operations.Power)) {
			// TODO: how......
		}

		command.execute(number);
	}

	public int getResult() {
		return calc.getResult();
	}

}

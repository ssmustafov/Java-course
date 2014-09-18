package com.sirma.itt.javacourse.patterns.calculator;

/**
 * Represents addition in the calculator. Implements {@code Command} interface.
 * 
 * @author smustafov
 */
public class AdditionCommand implements Command {

	private Calculator calc;

	/**
	 * Creates a new command for addition.
	 * 
	 * @param calc
	 *            - the calculator which the addition operation will be executed
	 */
	public AdditionCommand(Calculator calc) {
		this.calc = calc;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public long execute(long number) {
		long result = calc.getResult() + number;
		return result;
	}

}

package com.sirma.itt.javacourse.patterns.calculator;

/**
 * Represents multiplication in the calculator. Implements {@code Command} interface.
 * 
 * @author smustafov
 */
public class MultiplicationCommand implements Command {

	private Calculator calc;

	/**
	 * Creates a new command for multiplication.
	 * 
	 * @param calc
	 *            - the calculator which the multiplication operation will be executed
	 */
	public MultiplicationCommand(Calculator calc) {
		this.calc = calc;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public long execute(long number) {
		long result = calc.getResult() * number;
		return result;
	}

}

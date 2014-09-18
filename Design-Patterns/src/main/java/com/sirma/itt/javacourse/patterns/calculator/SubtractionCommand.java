package com.sirma.itt.javacourse.patterns.calculator;

/**
 * Represents subtraction in the calculator. Implements {@code Command} interface.
 * 
 * @author smustafov
 */
public class SubtractionCommand implements Command {

	private Calculator calc;

	/**
	 * Creates a new command for subtraction.
	 * 
	 * @param calc
	 *            - the calculator which the subtraction operation will be executed
	 */
	public SubtractionCommand(Calculator calc) {
		this.calc = calc;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public long execute(long number) {
		long result = calc.getResult() - number;
		return result;
	}

}

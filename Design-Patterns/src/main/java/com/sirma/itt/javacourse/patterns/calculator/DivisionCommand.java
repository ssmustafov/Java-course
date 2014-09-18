package com.sirma.itt.javacourse.patterns.calculator;

/**
 * Represents division in the calculator. Implements {@code Command} interface.
 * 
 * @author smustafov
 */
public class DivisionCommand implements Command {

	private Calculator calc;

	/**
	 * Creates a new command for division.
	 * 
	 * @param calc
	 *            - the calculator which the division operation will be executed
	 */
	public DivisionCommand(Calculator calc) {
		this.calc = calc;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public long execute(long number) {
		long result = calc.getResult() / number;
		return result;
	}

}

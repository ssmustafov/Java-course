package com.sirma.itt.javacourse.patterns.calculator;

/**
 * Represents powering in the calculator. Implements {@code Command} interface.
 * 
 * @author smustafov
 */
public class PowerCommand implements Command {

	private Calculator calc;

	/**
	 * Creates a new command for powering.
	 * 
	 * @param calc
	 *            - the calculator which the powering operation will be executed
	 */
	public PowerCommand(Calculator calc) {
		this.calc = calc;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public long execute(long number) {
		long result = (long) Math.pow(calc.getResult(), number);
		return result;
	}
}

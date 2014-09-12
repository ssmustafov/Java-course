package com.sirma.itt.javacourse.patterns.calculator;

/**
 * @author smustafov
 */
public class PowerCommand implements Command {

	private Calculator calc;

	public PowerCommand(Calculator calc) {
		this.calc = calc;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void execute(int number) {

	}
}

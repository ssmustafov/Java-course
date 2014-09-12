package com.sirma.itt.javacourse.patterns.calculator;

/**
 * @author smustafov
 */
public class SubstractionCommand implements Command {

	private Calculator calc;

	public SubstractionCommand(Calculator calc) {
		this.calc = calc;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void execute(int number) {
		int substraction = calc.getResult() - number;
		calc.setResult(substraction);
	}

}

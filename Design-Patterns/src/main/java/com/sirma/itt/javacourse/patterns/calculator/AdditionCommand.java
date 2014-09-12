package com.sirma.itt.javacourse.patterns.calculator;

/**
 * @author smustafov
 */
public class AdditionCommand implements Command {

	private Calculator calc;

	public AdditionCommand(Calculator calc) {
		this.calc = calc;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void execute(int number) {
		int addition = calc.getResult() + number;
		calc.setResult(addition);
	}

}

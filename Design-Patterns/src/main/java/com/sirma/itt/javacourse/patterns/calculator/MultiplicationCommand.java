package com.sirma.itt.javacourse.patterns.calculator;

/**
 * @author smustafov
 */
public class MultiplicationCommand implements Command {

	private Calculator calc;

	public MultiplicationCommand(Calculator calc) {
		this.calc = calc;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void execute(int number) {
		int multi = calc.getResult() * number;
		calc.setResult(multi);
	}

}

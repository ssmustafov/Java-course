package com.sirma.itt.javacourse.patterns.calculator;

/**
 * @author smustafov
 */
public class DivisionCommand implements Command {

	private Calculator calc;

	public DivisionCommand(Calculator calc) {
		this.calc = calc;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void execute(int number) {
		int division = calc.getResult() / number;
		calc.setResult(division);
	}

}

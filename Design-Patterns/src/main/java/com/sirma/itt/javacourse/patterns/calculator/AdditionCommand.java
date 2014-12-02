package com.sirma.itt.javacourse.patterns.calculator;


/**
 * Represents addition in the calculator. Implements {@code Command} interface.
 * 
 * @author smustafov
 */
public class AdditionCommand implements Command {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public double execute(double a, double b) {
		return a + b;
	}

}

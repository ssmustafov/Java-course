package com.sirma.itt.javacourse.patterns.calculator;

/**
 * Represents division in the calculator. Implements {@code Command} interface.
 * 
 * @author smustafov
 */
public class DivisionCommand implements Command {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public double execute(double a, double b) {
		return a / b;
	}

}

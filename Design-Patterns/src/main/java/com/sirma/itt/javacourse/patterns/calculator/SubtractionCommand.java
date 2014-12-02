package com.sirma.itt.javacourse.patterns.calculator;


/**
 * Represents subtraction in the calculator. Implements {@code Command} interface.
 * 
 * @author smustafov
 */
public class SubtractionCommand implements Command {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public double execute(double a, double b) {
		return a - b;
	}

}

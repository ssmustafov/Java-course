package com.sirma.itt.javacourse.patterns.calculator;


/**
 * Represents powering in the calculator. Implements {@code Command} interface.
 * 
 * @author smustafov
 */
public class PowerCommand implements Command {

	/**
	 * The power <b>b</b> must be an integer number. {@inheritDoc}
	 */
	@Override
	public double execute(double a, double b) {
		return Math.pow(a, b);
	}

}

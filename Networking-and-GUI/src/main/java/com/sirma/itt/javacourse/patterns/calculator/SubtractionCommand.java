package com.sirma.itt.javacourse.patterns.calculator;

import java.math.BigDecimal;

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
	public BigDecimal execute(BigDecimal a, BigDecimal b) {
		return a.subtract(b);
	}

}

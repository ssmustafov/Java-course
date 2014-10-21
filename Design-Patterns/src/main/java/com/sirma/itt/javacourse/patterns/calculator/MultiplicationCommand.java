package com.sirma.itt.javacourse.patterns.calculator;

import java.math.BigDecimal;

/**
 * Represents multiplication in the calculator. Implements {@code Command} interface.
 * 
 * @author smustafov
 */
public class MultiplicationCommand implements Command {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public BigDecimal execute(BigDecimal a, BigDecimal b) {
		return a.multiply(b);
	}

}

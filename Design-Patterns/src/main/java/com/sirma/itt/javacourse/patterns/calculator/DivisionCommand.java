package com.sirma.itt.javacourse.patterns.calculator;

import java.math.BigDecimal;

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
	public BigDecimal execute(BigDecimal a, BigDecimal b) {
		return a.divide(b);
	}

}

package com.sirma.itt.javacourse.patterns.calculator;

import java.math.BigDecimal;

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
	public BigDecimal execute(BigDecimal a, BigDecimal b) {
		return a.add(b);
	}

}

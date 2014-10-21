package com.sirma.itt.javacourse.patterns.calculator;

import java.math.BigDecimal;

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
	public BigDecimal execute(BigDecimal a, BigDecimal b) {
		return a.pow(b.intValueExact());
	}

}

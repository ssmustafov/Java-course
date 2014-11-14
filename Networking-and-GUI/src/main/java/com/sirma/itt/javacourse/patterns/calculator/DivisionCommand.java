package com.sirma.itt.javacourse.patterns.calculator;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Represents division in the calculator. Implements {@code Command} interface.
 * 
 * @author smustafov
 */
public class DivisionCommand implements Command {

	/**
	 * Precision of the division.
	 */
	public static final int DECIMAL_PRECISION = 10;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public BigDecimal execute(BigDecimal a, BigDecimal b) {
		return a.divide(b, DECIMAL_PRECISION, RoundingMode.HALF_UP);
	}

}

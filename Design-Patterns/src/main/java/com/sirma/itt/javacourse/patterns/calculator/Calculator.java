package com.sirma.itt.javacourse.patterns.calculator;

import java.math.BigDecimal;

/**
 * Represents a calculator. Holds the result. In the beginning the result always is zero.
 * 
 * @author smustafov
 */
public class Calculator {
	private BigDecimal result = new BigDecimal("0");

	/**
	 * Returns the result in the calculator.
	 * 
	 * @return - the result in the calculator
	 */
	public BigDecimal getResult() {
		return result;
	}

	/**
	 * Sets the result in the calculator.
	 * 
	 * @param newResult
	 *            - the new result to be set
	 */
	public void setResult(BigDecimal newResult) {
		result = newResult;
	}
}

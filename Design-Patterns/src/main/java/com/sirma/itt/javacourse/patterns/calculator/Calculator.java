package com.sirma.itt.javacourse.patterns.calculator;

/**
 * Represents a calculator. Holds the result. In the beginning the result always is zero.
 * 
 * @author smustafov
 */
public class Calculator {

	private long result = 0L;

	/**
	 * Returns the result in the calculator.
	 * 
	 * @return - the result in the calculator
	 */
	public long getResult() {
		return result;
	}

	/**
	 * Sets the result in the calculator.
	 * 
	 * @param res
	 *            - the new result to be set
	 */
	public void setResult(long res) {
		result = res;
	}

}

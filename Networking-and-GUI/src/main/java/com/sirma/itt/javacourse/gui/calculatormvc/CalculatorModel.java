package com.sirma.itt.javacourse.gui.calculatormvc;

import java.math.BigDecimal;

/**
 * @author smustafov
 */
public class CalculatorModel {
	private BigDecimal result = new BigDecimal("0");

	public void setResult(BigDecimal newResult) {
		this.result = newResult;
	}

	public void setResult(String newResult) {
		this.result = new BigDecimal(newResult);
	}

	public BigDecimal getResult() {
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return result.toString();
	}
}

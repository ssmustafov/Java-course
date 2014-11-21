package com.sirma.itt.javacourse.gui.calculatormvc;

import java.math.BigDecimal;

/**
 * @author smustafov
 */
public class CalculatorModel {
	public static final String INITIAL_VALUE = "0";
	private BigDecimal value;

	public CalculatorModel() {
		value = new BigDecimal(INITIAL_VALUE);
	}

	public void setValue(String newValue) {
		value = new BigDecimal(newValue);
	}

	public void setValue(BigDecimal newValue) {
		value = newValue;
	}

	public BigDecimal getValue() {
		return value;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return value.toString();
	}
}

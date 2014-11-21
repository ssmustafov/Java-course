package com.sirma.itt.javacourse.gui.calculatormvc;

import java.math.BigDecimal;

/**
 * The model of the calculator.
 * 
 * @author smustafov
 */
public class CalculatorModel {
	public static final String INITIAL_VALUE = "0";
	private BigDecimal value;

	/**
	 * Creates new model with initial value zero.
	 */
	public CalculatorModel() {
		value = new BigDecimal(INITIAL_VALUE);
	}

	/**
	 * Sets the value of the model to the given BigDecimal value from string.
	 * 
	 * @param newValue
	 *            - the new value to be set
	 */
	public void setValue(String newValue) {
		value = new BigDecimal(newValue);
	}

	/**
	 * Sets the value of the model to the given BigDecimal value.
	 * 
	 * @param newValue
	 *            - the new value to be set
	 */
	public void setValue(BigDecimal newValue) {
		value = newValue;
	}

	/**
	 * Returns the value of the model.
	 * 
	 * @return - the value of the model
	 */
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

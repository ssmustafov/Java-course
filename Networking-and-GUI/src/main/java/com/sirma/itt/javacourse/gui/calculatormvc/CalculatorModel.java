package com.sirma.itt.javacourse.gui.calculatormvc;

/**
 * The model of the calculator.
 * 
 * @author smustafov
 */
public class CalculatorModel {
	public static final double INITIAL_VALUE = 0;
	private double value;

	/**
	 * Creates new model with initial value zero.
	 */
	public CalculatorModel() {
		value = INITIAL_VALUE;
	}

	/**
	 * Sets the value of the model to the given BigDecimal value from string.
	 * 
	 * @param newValue
	 *            - the new value to be set
	 */
	public void setValue(String newValue) {
		value = Double.parseDouble(newValue);
	}

	/**
	 * Sets the value of the model to the given BigDecimal value.
	 * 
	 * @param newValue
	 *            - the new value to be set
	 */
	public void setValue(double newValue) {
		value = newValue;
	}

	/**
	 * Returns the value of the model.
	 * 
	 * @return - the value of the model
	 */
	public double getValue() {
		return value;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return Double.toString(value);
	}
}

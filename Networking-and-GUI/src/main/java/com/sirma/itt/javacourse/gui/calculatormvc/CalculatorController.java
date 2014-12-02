package com.sirma.itt.javacourse.gui.calculatormvc;

import com.sirma.itt.javacourse.patterns.calculator.CalculatorManager;
import com.sirma.itt.javacourse.patterns.calculator.Operations;

/**
 * The controller of the calculator. It knows about the model and the view.
 * 
 * @author smustafov
 */
public class CalculatorController {
	private static final String ADDITION_OPERATION = "+";
	private static final String SUBTRACTION_OPERATION = "-";
	private static final String MULTIPLICATION_OPERATION = "*";
	private static final String DIVISION_OPERATION = "/";
	private static final String POWERING_OPERATION = "^";
	private static final String CLEAR_OPERATION = "clear";
	private static final String BACK_OPERATION = "b";
	private static final String EQUALS_OPERATION = "=";
	private final CalculatorModel model;
	private final CalculatorView view;
	private final CalculatorManager manager;
	private Operations operation;
	private boolean isNumberSwitched;
	private StringBuilder num1;
	private StringBuilder num2;

	/**
	 * Creates a new calculator controller with given model and view.
	 * 
	 * @param model
	 *            - the model of the calculator
	 * @param view
	 *            - the view of the calculator
	 */
	public CalculatorController(CalculatorModel model, CalculatorView view) {
		this.model = model;
		this.view = view;
		this.manager = new CalculatorManager();
		this.operation = null;
		this.isNumberSwitched = false;
		this.num1 = new StringBuilder();
		this.num2 = new StringBuilder();

		this.updateView(this.model, this.view);
	}

	/**
	 * Updates the view by getting data from the model.
	 * 
	 * @param model
	 *            - the calculator model
	 * @param view
	 *            - the calculator view
	 */
	private void updateView(CalculatorModel model, CalculatorView view) {
		String value = model.toString();

		if (hasZeroFraction(value)) {
			value = removeZeroFraction(value);
		}

		if (view != null) {
			view.setFieldText(value);
		}
	}

	/**
	 * Checks if the string's last char is zero (in double always have .0).
	 * 
	 * @param value
	 *            - the string to be checked
	 * @return - true if it has '.0'; otherwise false
	 */
	private boolean hasZeroFraction(String value) {
		if (value.charAt(value.length() - 1) == '0') {
			return true;
		}
		return false;
	}

	/**
	 * Removes '.0' fraction in the number.
	 * 
	 * @param value
	 *            - the value from which zero fraction to be removed
	 * @return new string with removed zero fraction
	 */
	private String removeZeroFraction(String value) {
		String result = value.substring(0, value.length() - 2);
		return result;
	}

	/**
	 * Resets the StringBuilders num1 and num2.
	 */
	private void resetNumbers() {
		num1.setLength(0);
		num2.setLength(0);
	}

	/**
	 * Processes the given command and does the calculation.
	 * 
	 * @param cmd
	 *            - the command from the view
	 */
	public void processCommand(String cmd) {
		if (EQUALS_OPERATION.equals(cmd)) {
			double a = Double.parseDouble(num1.toString());
			double b = Double.parseDouble(num2.toString());

			double result = manager.compute(operation, a, b);
			model.setValue(result);

			resetNumbers();
			num1.append(model.toString());

			isNumberSwitched = false;
		} else if (CLEAR_OPERATION.equals(cmd)) {
			resetNumbers();
			operation = null;
			isNumberSwitched = false;

			model.setValue(CalculatorModel.INITIAL_VALUE);
		} else if (BACK_OPERATION.equals(cmd)) {
			if (!isNumberSwitched) {
				num1.deleteCharAt(num1.length() - 1);
				model.setValue(num1.toString());
			} else {
				num2.deleteCharAt(num2.length() - 1);
				model.setValue(num2.toString());
			}
		} else if (ADDITION_OPERATION.equals(cmd)) {
			operation = Operations.Add;
			isNumberSwitched = true;
		} else if (SUBTRACTION_OPERATION.equals(cmd)) {
			operation = Operations.Subtract;
			isNumberSwitched = true;
		} else if (MULTIPLICATION_OPERATION.equals(cmd)) {
			operation = Operations.Multiply;
			isNumberSwitched = true;
		} else if (DIVISION_OPERATION.equals(cmd)) {
			operation = Operations.Divide;
			isNumberSwitched = true;
		} else if (POWERING_OPERATION.equals(cmd)) {
			operation = Operations.Power;
			isNumberSwitched = true;
		} else {
			if (!isNumberSwitched) {
				num1.append(cmd);
				model.setValue(num1.toString());
			} else {
				num2.append(cmd);
				model.setValue(num2.toString());
			}
		}

		updateView(model, view);
	}
}

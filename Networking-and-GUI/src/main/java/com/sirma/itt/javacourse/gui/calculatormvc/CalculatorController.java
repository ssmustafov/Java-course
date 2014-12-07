package com.sirma.itt.javacourse.gui.calculatormvc;

import com.sirma.itt.javacourse.patterns.calculator.CalculatorManager;
import com.sirma.itt.javacourse.patterns.calculator.Operations;

/**
 * The controller of the calculator. It knows about the model and the view.
 * 
 * @author Sinan
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
	private CalculatorManager manager;
	private CalculatorModel model;
	private CalculatorView view;
	private StringBuilder num1;
	private StringBuilder num2;
	private Operations operation;
	private boolean isNumberSwitched;

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
		num1 = new StringBuilder();
		num2 = new StringBuilder();
		operation = null;
		isNumberSwitched = false;
		manager = new CalculatorManager();
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
		if (view != null) {
			String value = model.toString();
			view.setFieldText(value);
		}
	}

	/**
	 * Calculates the two numbers in the calculator.
	 */
	private void calculate() {
		double a = Double.parseDouble(num1.toString());
		double b = Double.parseDouble(num2.toString());
		double result = manager.compute(operation, a, b);
		model.setValue(result);
		num1.setLength(0);
		num2.setLength(0);
		num1.append(result);
	}

	/**
	 * Resets the calculator.
	 */
	private void resetCalculator() {
		num1.setLength(0);
		num2.setLength(0);
		operation = null;
		isNumberSwitched = false;
		model.setValue(0);
	}

	/**
	 * Process the given operation.
	 * 
	 * @param operation
	 *            - the calculator operation to process
	 */
	private void evaluateOperation(Operations operation) {
		if (isNumberSwitched) {
			calculate();
		} else {
			isNumberSwitched = true;
		}
		this.operation = operation;
	}

	/**
	 * Reverts the last made change to the current number.
	 */
	private void revertChanges() {
		if (!isNumberSwitched) {
			num1.deleteCharAt(num1.length() - 1);
			model.setValue(num1.toString());
		} else {
			num2.deleteCharAt(num2.length() - 1);
			model.setValue(num2.toString());
		}
	}

	/**
	 * Processes the given command and does the calculation.
	 * 
	 * @param command
	 *            - the command from the view to process
	 */
	public void processCommand(String command) {
		if (EQUALS_OPERATION.equals(command)) {
			calculate();
			isNumberSwitched = false;
		} else if (CLEAR_OPERATION.equals(command)) {
			resetCalculator();
		} else if (BACK_OPERATION.equals(command)) {
			revertChanges();
		} else if (ADDITION_OPERATION.equals(command)) {
			evaluateOperation(Operations.Add);
		} else if (SUBTRACTION_OPERATION.equals(command)) {
			evaluateOperation(Operations.Subtract);
		} else if (DIVISION_OPERATION.equals(command)) {
			evaluateOperation(Operations.Divide);
		} else if (MULTIPLICATION_OPERATION.equals(command)) {
			evaluateOperation(Operations.Multiply);
		} else if (POWERING_OPERATION.equals(command)) {
			evaluateOperation(Operations.Power);
		} else {
			if (!isNumberSwitched) {
				num1.append(command);
				model.setValue(num1.toString());
			} else {
				num2.append(command);
				model.setValue(num2.toString());
			}
		}

		updateView(model, view);
	}

}

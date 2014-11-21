package com.sirma.itt.javacourse.gui.calculatormvc;

import com.sirma.itt.javacourse.patterns.calculator.CalculatorManager;
import com.sirma.itt.javacourse.patterns.calculator.Operations;

/**
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
	private boolean isChanged;
	private StringBuilder num1;
	private StringBuilder num2;

	public CalculatorController(CalculatorModel model, CalculatorView view) {
		this.model = model;
		this.view = view;
		this.manager = new CalculatorManager();
		this.operation = null;
		this.isChanged = false;
		this.num1 = new StringBuilder();
		this.num2 = new StringBuilder();
		this.updateView(this.model, this.view);
	}

	private void updateView(CalculatorModel model, CalculatorView view) {
		String value = model.toString();
		view.setFieldText(value);
	}

	private void resetNumbers() {
		num1.setLength(0);
		num2.setLength(0);
	}

	public void processCommand(String cmd) {
		if (EQUALS_OPERATION.equals(cmd)) {
			manager.compute(operation, num1.toString(), num2.toString());
			model.setValue(manager.toString());

			resetNumbers();
			num1.append(model.toString());

			isChanged = false;
		} else if (CLEAR_OPERATION.equals(cmd)) {
			resetNumbers();
			operation = null;
			isChanged = false;

			model.setValue(CalculatorModel.INITIAL_VALUE);
		} else if (BACK_OPERATION.equals(cmd)) {

		} else if (ADDITION_OPERATION.equals(cmd)) {
			operation = Operations.Add;
			isChanged = true;
		} else if (SUBTRACTION_OPERATION.equals(cmd)) {
			operation = Operations.Subtract;
			isChanged = true;
		} else if (MULTIPLICATION_OPERATION.equals(cmd)) {
			operation = Operations.Multiply;
			isChanged = true;
		} else if (DIVISION_OPERATION.equals(cmd)) {
			operation = Operations.Divide;
			isChanged = true;
		} else if (POWERING_OPERATION.equals(cmd)) {
			operation = Operations.Power;
			isChanged = true;
		} else {
			if (!isChanged) {
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

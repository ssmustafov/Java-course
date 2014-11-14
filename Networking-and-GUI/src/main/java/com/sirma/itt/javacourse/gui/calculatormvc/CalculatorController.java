package com.sirma.itt.javacourse.gui.calculatormvc;

/**
 * @author smustafov
 */
public class CalculatorController {
	private CalculatorModel model;
	private CalculatorView view;

	public CalculatorController(CalculatorModel model, CalculatorView view) {
		this.model = model;
		this.view = view;
	}

	public void compute() {
		view.setFieldText(model.toString());
	}
}

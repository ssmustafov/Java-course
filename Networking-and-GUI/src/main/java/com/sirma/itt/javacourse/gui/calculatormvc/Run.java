package com.sirma.itt.javacourse.gui.calculatormvc;

import javax.swing.SwingUtilities;

/**
 * Shows hot to use the calculator.
 * 
 * @author smustafov
 */
public final class Run {

	/**
	 * Protects from initialization.
	 */
	private Run() {

	}

	/**
	 * Main method.
	 * 
	 * @param args
	 *            - arguments; not used
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				CalculatorModel model = new CalculatorModel();
				CalculatorView view = new CalculatorView();
				CalculatorController c = new CalculatorController(model, view);

				view.registerObserver(c);
			}
		});
	}
}

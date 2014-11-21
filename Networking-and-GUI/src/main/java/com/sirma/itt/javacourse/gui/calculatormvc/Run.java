package com.sirma.itt.javacourse.gui.calculatormvc;

import javax.swing.SwingUtilities;

/**
 * @author smustafov
 */
public class Run {
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

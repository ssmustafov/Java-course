package com.sirma.itt.javacourse.gui.calculatormvc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author smustafov
 */
public class ButtonListener implements ActionListener {

	private CalculatorModel m;

	public ButtonListener(CalculatorModel m) {
		this.m = m;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		String r = e.getActionCommand();
		m.setResult(r);
		System.out.println(m.toString());
	}

}

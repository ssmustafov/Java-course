package com.sirma.itt.javacourse.gui.calculator;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

/**
 * @author smustafov
 */
public class Calculator2 extends JFrame {
	private static final String[] BUTTONS = { "Cls", "Bck", "", "Close", "7", "8", "9", "/", "4",
			"5", "6", "*", "1", "2", "3", "-", "0", ".", "=", "+" };
	private static final long serialVersionUID = 1L;
	private static final String WINDOW_TITLE = "Calculator";
	private JTextField field;

	public Calculator2() {
		super(WINDOW_TITLE);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		Container pane = getContentPane();
		pane.setLayout(new GridLayout(6, 4, 5, 5));

		field = new JTextField();
		field.setEditable(false);
		pane.add(field);

		for (int i = 0; i < BUTTONS.length; i++) {
			JButton b = new JButton(BUTTONS[i]);
			b.addActionListener(new ButtonListener());
			pane.add(b);
		}

		pack();
		setVisible(true);
	}

	private class ButtonListener implements ActionListener {

		/**
		 * {@inheritDoc}
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			String command = e.getActionCommand();
			if ("Cls".equals(command)) {
				field.setText("");
			} else {
				field.setText(command);
			}
		}
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				new Calculator2();
			}
		});
	}
}

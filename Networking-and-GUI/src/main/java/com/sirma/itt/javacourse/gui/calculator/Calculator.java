package com.sirma.itt.javacourse.gui.calculator;

import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

/**
 * @author smustafov
 */
public class Calculator {
	private JTextField field;

	public void createGUI() {
		JFrame frame = new JFrame("Calculator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);

		Container container = frame.getContentPane();
		container.setLayout(new GridBagLayout());
		GridBagConstraints cons = new GridBagConstraints();
		cons.fill = GridBagConstraints.HORIZONTAL;

		field = new JTextField();
		field.setEditable(false);
		cons.gridwidth = 4;
		cons.gridheight = 2;
		cons.ipadx = 5;
		cons.ipady = 5;
		cons.gridx = 0;
		cons.gridy = 0;
		container.add(field, cons);

		cons.gridwidth = 1;
		cons.gridheight = 1;
		cons.ipadx = 5;
		cons.ipady = 5;
		cons.insets = new Insets(2, 2, 2, 2);

		JButton clearButton = new JButton("Clear");
		clearButton.addActionListener(new ButtonListener());
		cons.gridwidth = 2;
		cons.gridx = 0;
		cons.gridy = 2;
		container.add(clearButton, cons);

		cons.gridwidth = 1;

		JButton backButton = new JButton("B");
		backButton.addActionListener(new ButtonListener());
		cons.gridx = 2;
		cons.gridy = 2;
		container.add(backButton, cons);

		JButton powerButton = new JButton("^");
		powerButton.addActionListener(new ButtonListener());
		cons.gridx = 3;
		cons.gridy = 2;
		container.add(powerButton, cons);

		JButton oneButton = new JButton("1");
		oneButton.addActionListener(new ButtonListener());
		cons.gridx = 0;
		cons.gridy = 3;
		container.add(oneButton, cons);

		JButton twoButton = new JButton("2");
		twoButton.addActionListener(new ButtonListener());
		cons.gridx = 1;
		cons.gridy = 3;
		container.add(twoButton, cons);

		JButton threeButton = new JButton("3");
		threeButton.addActionListener(new ButtonListener());
		cons.gridx = 2;
		cons.gridy = 3;
		container.add(threeButton, cons);

		JButton divideButton = new JButton("/");
		divideButton.addActionListener(new ButtonListener());
		cons.gridx = 3;
		cons.gridy = 3;
		container.add(divideButton, cons);

		JButton fourButton = new JButton("4");
		fourButton.addActionListener(new ButtonListener());
		cons.gridx = 0;
		cons.gridy = 4;
		container.add(fourButton, cons);

		JButton fiveButton = new JButton("5");
		fiveButton.addActionListener(new ButtonListener());
		cons.gridx = 1;
		cons.gridy = 4;
		container.add(fiveButton, cons);

		JButton sixButton = new JButton("6");
		sixButton.addActionListener(new ButtonListener());
		cons.gridx = 2;
		cons.gridy = 4;
		container.add(sixButton, cons);

		JButton multiplyButton = new JButton("*");
		multiplyButton.addActionListener(new ButtonListener());
		cons.gridx = 3;
		cons.gridy = 4;
		container.add(multiplyButton, cons);

		JButton sevenButton = new JButton("7");
		sevenButton.addActionListener(new ButtonListener());
		cons.gridx = 0;
		cons.gridy = 5;
		container.add(sevenButton, cons);

		JButton eigthButton = new JButton("8");
		eigthButton.addActionListener(new ButtonListener());
		cons.gridx = 1;
		cons.gridy = 5;
		container.add(eigthButton, cons);

		JButton nineButton = new JButton("9");
		nineButton.addActionListener(new ButtonListener());
		cons.gridx = 2;
		cons.gridy = 5;
		container.add(nineButton, cons);

		JButton subtractButton = new JButton("-");
		subtractButton.addActionListener(new ButtonListener());
		cons.gridx = 3;
		cons.gridy = 5;
		container.add(subtractButton, cons);

		JButton zeroButton = new JButton("0");
		zeroButton.addActionListener(new ButtonListener());
		cons.gridx = 0;
		cons.gridy = 6;
		container.add(zeroButton, cons);

		JButton dotButton = new JButton(".");
		dotButton.addActionListener(new ButtonListener());
		cons.gridx = 1;
		cons.gridy = 6;
		container.add(dotButton, cons);

		JButton equalsButton = new JButton("=");
		equalsButton.addActionListener(new ButtonListener());
		cons.gridx = 2;
		cons.gridy = 6;
		container.add(equalsButton, cons);

		JButton plusButton = new JButton("+");
		plusButton.addActionListener(new ButtonListener());
		cons.gridx = 3;
		cons.gridy = 6;
		container.add(plusButton, cons);

		frame.pack();
		frame.setResizable(false);
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				Calculator c = new Calculator();
				c.createGUI();
			}
		});
	}

	public class ButtonListener implements ActionListener {

		/**
		 * {@inheritDoc}
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			String command = e.getActionCommand();
			if ("Clear".equals(command)) {
				field.setText("");
			} else {
				field.setText(command);
			}
		}

	}
}

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

import com.sirma.itt.javacourse.patterns.calculator.CalculatorManager;
import com.sirma.itt.javacourse.patterns.calculator.Operations;

/**
 * @author smustafov
 */
public class SwingCalculator implements ActionListener {
	private static final String ADDITION_OPERATION = "+";
	private static final String SUBTRACTION_OPERATION = "-";
	private static final String MULTIPLICATION_OPERATION = "*";
	private static final String DIVISION_OPERATION = "/";
	private static final String POWERING_OPERATION = "^";
	private static final String CLEAR_OPERATION = "clear";
	// private static final String BACK_OPERATION = "b";
	private static final String EQUALS_OPERATION = "=";
	private CalculatorManager manager = new CalculatorManager();
	private Operations operation = null;
	private JTextField field;
	private StringBuilder a = new StringBuilder();
	private StringBuilder b = new StringBuilder();

	public SwingCalculator() {
		JFrame frame = new JFrame("Calculator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);

		Container container = frame.getContentPane();
		container.setLayout(new GridBagLayout());
		GridBagConstraints cons = new GridBagConstraints();
		cons.fill = GridBagConstraints.HORIZONTAL;

		field = new JTextField("0");
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

		JButton clearButton = new JButton("clear");
		clearButton.addActionListener(this);
		cons.gridwidth = 2;
		cons.gridx = 0;
		cons.gridy = 2;
		container.add(clearButton, cons);

		cons.gridwidth = 1;

		JButton backButton = new JButton("B");
		backButton.addActionListener(this);
		cons.gridx = 2;
		cons.gridy = 2;
		container.add(backButton, cons);

		JButton powerButton = new JButton("^");
		powerButton.addActionListener(this);
		cons.gridx = 3;
		cons.gridy = 2;
		container.add(powerButton, cons);

		JButton oneButton = new JButton("1");
		oneButton.addActionListener(this);
		cons.gridx = 0;
		cons.gridy = 3;
		container.add(oneButton, cons);

		JButton twoButton = new JButton("2");
		twoButton.addActionListener(this);
		cons.gridx = 1;
		cons.gridy = 3;
		container.add(twoButton, cons);

		JButton threeButton = new JButton("3");
		threeButton.addActionListener(this);
		cons.gridx = 2;
		cons.gridy = 3;
		container.add(threeButton, cons);

		JButton divideButton = new JButton("/");
		divideButton.addActionListener(this);
		cons.gridx = 3;
		cons.gridy = 3;
		container.add(divideButton, cons);

		JButton fourButton = new JButton("4");
		fourButton.addActionListener(this);
		cons.gridx = 0;
		cons.gridy = 4;
		container.add(fourButton, cons);

		JButton fiveButton = new JButton("5");
		fiveButton.addActionListener(this);
		cons.gridx = 1;
		cons.gridy = 4;
		container.add(fiveButton, cons);

		JButton sixButton = new JButton("6");
		sixButton.addActionListener(this);
		cons.gridx = 2;
		cons.gridy = 4;
		container.add(sixButton, cons);

		JButton multiplyButton = new JButton("*");
		multiplyButton.addActionListener(this);
		cons.gridx = 3;
		cons.gridy = 4;
		container.add(multiplyButton, cons);

		JButton sevenButton = new JButton("7");
		sevenButton.addActionListener(this);
		cons.gridx = 0;
		cons.gridy = 5;
		container.add(sevenButton, cons);

		JButton eigthButton = new JButton("8");
		eigthButton.addActionListener(this);
		cons.gridx = 1;
		cons.gridy = 5;
		container.add(eigthButton, cons);

		JButton nineButton = new JButton("9");
		nineButton.addActionListener(this);
		cons.gridx = 2;
		cons.gridy = 5;
		container.add(nineButton, cons);

		JButton subtractButton = new JButton("-");
		subtractButton.addActionListener(this);
		cons.gridx = 3;
		cons.gridy = 5;
		container.add(subtractButton, cons);

		JButton zeroButton = new JButton("0");
		zeroButton.addActionListener(this);
		cons.gridx = 0;
		cons.gridy = 6;
		container.add(zeroButton, cons);

		JButton dotButton = new JButton(".");
		dotButton.addActionListener(this);
		cons.gridx = 1;
		cons.gridy = 6;
		container.add(dotButton, cons);

		JButton equalsButton = new JButton("=");
		equalsButton.addActionListener(this);
		cons.gridx = 2;
		cons.gridy = 6;
		container.add(equalsButton, cons);

		JButton plusButton = new JButton("+");
		plusButton.addActionListener(this);
		cons.gridx = 3;
		cons.gridy = 6;
		container.add(plusButton, cons);

		frame.pack();
		frame.setResizable(false);
		frame.setVisible(true);

	}

	private boolean isChange = false;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		if (EQUALS_OPERATION.equals(cmd)) {
			manager.compute(operation, a.toString(), b.toString());
			field.setText(manager.toString());
			a.setLength(0);
			a.append(manager.toString());
			b.setLength(0);
			isChange = false;
		} else if (CLEAR_OPERATION.equals(cmd)) {
			field.setText("0");
			a.setLength(0);
			b.setLength(0);
			operation = null;
			isChange = false;
		} else if (ADDITION_OPERATION.equals(cmd)) {
			operation = Operations.Add;
			isChange = true;
		} else if (SUBTRACTION_OPERATION.equals(cmd)) {
			operation = Operations.Subtract;
			isChange = true;
		} else if (MULTIPLICATION_OPERATION.equals(cmd)) {
			operation = Operations.Multiply;
			isChange = true;
		} else if (DIVISION_OPERATION.equals(cmd)) {
			operation = Operations.Divide;
			isChange = true;
		} else if (POWERING_OPERATION.equals(cmd)) {
			operation = Operations.Power;
			isChange = true;
		} else {
			if (!isChange) {
				a.append(cmd);
				field.setText(a.toString());
			} else {
				b.append(cmd);
				field.setText(b.toString());
			}
		}
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				new SwingCalculator();
			}
		});
	}
}

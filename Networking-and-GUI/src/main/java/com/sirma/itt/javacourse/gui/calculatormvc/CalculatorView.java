package com.sirma.itt.javacourse.gui.calculatormvc;

import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

/**
 * The view of the calculator. It knows only about controller.
 * 
 * @author smustafov
 */
public class CalculatorView extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	private static final String WINDOW_TITLE = "Calculator";
	private CalculatorController controller;
	private JTextField field;

	/**
	 * Creates a new view.
	 */
	public CalculatorView() {
		super(WINDOW_TITLE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		Container container = getContentPane();
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

		JButton backButton = new JButton("b");
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

		pack();
		setResizable(false);
		setVisible(true);
	}

	/**
	 * Registers a controller to the view. Only one controller can be registered.
	 * 
	 * @param controller
	 *            - the calculator controller
	 */
	public void registerObserver(CalculatorController controller) {
		this.controller = controller;
	}

	/**
	 * Sets the text in the text field.
	 * 
	 * @param text
	 *            - the new text to be set
	 */
	public void setFieldText(String text) {
		field.setText(text);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		controller.processCommand(e.getActionCommand());
	}
}

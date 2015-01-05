package com.sirma.itt.javacourse.chatclient.views;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 * Represents the login form of the client chat application.
 * 
 * @author Sinan
 */
public class LoginForm implements ActionListener {

	private JFrame frame;
	private JTextField nicknameField;
	private JButton loginButton;

	// private JProgressBar progressBar;

	/**
	 * Creates a new login form.
	 */
	public LoginForm() {
		frame = new JFrame();
		frame.setTitle("Chat Login Form");
		frame.setSize(300, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setLayout(new GridBagLayout());

		nicknameField = new JTextField(20);
		loginButton = new JButton("Login");
		loginButton.addActionListener(this);
		JLabel label = new JLabel("Enter nickname:");
		// progressBar = new JProgressBar();
		// progressBar.setIndeterminate(true);
		// progressBar.setVisible(false);

		GridBagConstraints constraints = new GridBagConstraints();

		constraints.insets = new Insets(10, 0, 0, 0);
		constraints.ipady = 0;
		constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.gridx = 0;
		constraints.gridy = 0;
		frame.getContentPane().add(label, constraints);

		constraints.insets = new Insets(0, 0, 0, 0);
		constraints.ipady = 10;
		constraints.gridx = 0;
		constraints.gridy = 1;
		frame.getContentPane().add(nicknameField, constraints);

		constraints.insets = new Insets(10, 0, 35, 0);
		constraints.ipady = 0;
		constraints.gridx = 0;
		constraints.gridy = 2;
		frame.getContentPane().add(loginButton, constraints);

		// constraints.insets = new Insets(10, 0, 35, 0);
		// constraints.ipady = 0;
		// constraints.gridx = 0;
		// constraints.gridy = 3;
		// frame.getContentPane().add(progressBar, constraints);

		frame.setVisible(true);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void actionPerformed(ActionEvent e) {

	}

}

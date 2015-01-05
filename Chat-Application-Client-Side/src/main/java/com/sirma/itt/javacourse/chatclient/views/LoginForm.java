package com.sirma.itt.javacourse.chatclient.views;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;

import com.sirma.itt.javacourse.chathelper.utils.ServerConfig;

/**
 * Represents the login form of the client chat application.
 * 
 * @author Sinan
 */
public class LoginForm implements ActionListener {

	private JFrame frame;
	private JTextField nicknameField;
	private JButton loginButton;
	private JProgressBar progressBar;
	private JComboBox<?> langList;

	/**
	 * Creates a new login form.
	 */
	public LoginForm() {
		frame = new JFrame();
		frame.setTitle("Chat Login Form");
		frame.setSize(300, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setLayout(new GridBagLayout());

		createButtons();
		createProgressBar();
		createComboBoxes();

		JLabel label = new JLabel("Enter nickname:");
		nicknameField = new JTextField(20);

		GridBagConstraints constraints = new GridBagConstraints();

		constraints.insets = new Insets(0, 0, 0, 0);
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

		constraints.insets = new Insets(10, 0, 0, 0);
		constraints.ipady = 0;
		constraints.gridx = 0;
		constraints.gridy = 2;
		frame.getContentPane().add(langList, constraints);

		constraints.insets = new Insets(10, 0, 0, 0);
		constraints.ipady = 0;
		constraints.gridx = 0;
		constraints.gridy = 3;
		frame.getContentPane().add(loginButton, constraints);

		constraints.insets = new Insets(50, 0, 0, 0);
		constraints.ipady = 5;
		constraints.gridx = 0;
		constraints.gridy = 4;
		frame.getContentPane().add(progressBar, constraints);

		frame.setVisible(true);
	}

	/**
	 * Creates the progress bar.
	 */
	private void createProgressBar() {
		progressBar = new JProgressBar();
		progressBar.setIndeterminate(true);
		progressBar.setVisible(false);
	}

	/**
	 * Creates the buttons.
	 */
	private void createButtons() {
		loginButton = new JButton("Login");
		loginButton.setActionCommand("login");
		loginButton.addActionListener(this);
	}

	/**
	 * Creates the comboxes.
	 */
	private void createComboBoxes() {
		langList = new JComboBox<>(ServerConfig.AVAILABLE_LANGUAGES);
		langList.setActionCommand("langList");
		langList.setSelectedIndex(0);
		langList.addActionListener(this);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		if ("login".equals(cmd)) {
			progressBar.setVisible(true);
		}
	}

}

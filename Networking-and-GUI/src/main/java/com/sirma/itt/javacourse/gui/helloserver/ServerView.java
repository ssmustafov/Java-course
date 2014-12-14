package com.sirma.itt.javacourse.gui.helloserver;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * @author Sinan
 */
public class ServerView extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	private static final String WINDOW_TITLE = "Server";
	private static final String START_SERVER_MESSAGE = "Start server";
	private static final String STOP_SERVER_MESSAGE = "Stop server";
	private static final int WINDOW_WIDTH = 500;
	private static final int WINDOW_HEIGHT = 300;
	private JButton startServerButton;
	private JTextArea consoleArea;

	public ServerView() {
		super(WINDOW_TITLE);
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		startServerButton = new JButton(START_SERVER_MESSAGE);
		consoleArea = new JTextArea(5, 20);
		JScrollPane scrollPane = new JScrollPane(consoleArea);
		consoleArea.setEditable(false);

		startServerButton.addActionListener(this);

		setLayout(new BorderLayout());
		JPanel panel = new JPanel();
		panel.add(startServerButton);

		add(panel, BorderLayout.PAGE_START);
		add(scrollPane, BorderLayout.CENTER);

		setVisible(true);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		if (cmd.equals(START_SERVER_MESSAGE)) {
			startServerButton.setText(STOP_SERVER_MESSAGE);
			consoleArea.setText(consoleArea.getText() + "Server started at: " + new Date()
					+ System.lineSeparator());

		} else {
			startServerButton.setText(START_SERVER_MESSAGE);
			consoleArea.setText(consoleArea.getText() + "Server stopped at: " + new Date()
					+ System.lineSeparator());

		}
	}

}

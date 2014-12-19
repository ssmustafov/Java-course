package com.sirma.itt.javacourse.gui.helloserver;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

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
	private static final String STOP_SERVER_MESSAGE = "Stop server";
	private static final int WINDOW_WIDTH = 500;
	private static final int WINDOW_HEIGHT = 300;
	private JButton stopServerButton;
	private JTextArea consoleArea;

	public ServerView() throws IOException {
		super(WINDOW_TITLE);
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		stopServerButton = new JButton(STOP_SERVER_MESSAGE);
		consoleArea = new JTextArea(5, 20);
		JScrollPane scrollPane = new JScrollPane(consoleArea);
		consoleArea.setEditable(false);

		stopServerButton.addActionListener(this);

		setLayout(new BorderLayout());
		JPanel panel = new JPanel();
		panel.add(stopServerButton);

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
		if (cmd.equals(STOP_SERVER_MESSAGE)) {
			// TODO: close the server
			dispose();
		}
	}

}

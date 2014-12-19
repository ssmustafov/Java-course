package com.sirma.itt.javacourse.gui.helloserver;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * @author Sinan
 */
public class ClientView extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	private static final String WINDOW_TITLE = "Client";
	private static final String CONNECT_MESSAGE = "Connect";
	private static final String DISCONNECT_MESSAGE = "Disconnect";
	private static final int WINDOW_WIDTH = 500;
	private static final int WINDOW_HEIGHT = 300;
	private JButton startServerButton;
	private JTextArea consoleArea;

	public ClientView() {
		super(WINDOW_TITLE);
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		startServerButton = new JButton(CONNECT_MESSAGE);
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
	public synchronized void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		if (cmd.equals(CONNECT_MESSAGE)) {
			startServerButton.setText(DISCONNECT_MESSAGE);
			try (Socket socket = new Socket("localhost", 7002);
					BufferedReader reader = new BufferedReader(new InputStreamReader(
							socket.getInputStream()));) {
				System.out.println(reader.readLine());
				// socket.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		} else {
			startServerButton.setText(CONNECT_MESSAGE);
		}
	}

}

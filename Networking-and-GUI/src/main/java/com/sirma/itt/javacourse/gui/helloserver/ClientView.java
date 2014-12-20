package com.sirma.itt.javacourse.gui.helloserver;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * Represents the UI for the client. Creates a new {@code Client} which connects to a server.
 * 
 * @author Sinan
 */
public class ClientView extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	private static final String NO_SERVER_ON_THAT_PORT_MESSAGE = "There is no running server on that port";
	private static final String WINDOW_TITLE = "Client";
	private static final String CONNECT_MESSAGE = "Connect";
	private static final int WINDOW_WIDTH = 400;
	private static final int WINDOW_HEIGHT = 200;
	private JButton button;
	private JTextArea consoleArea;

	/**
	 * Creates a new UI for the client.
	 */
	public ClientView() {
		super(WINDOW_TITLE);
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		button = new JButton(CONNECT_MESSAGE);
		consoleArea = new JTextArea(5, 20);
		JScrollPane scrollPane = new JScrollPane(consoleArea);
		consoleArea.setEditable(false);

		button.addActionListener(this);

		setLayout(new BorderLayout());
		JPanel panel = new JPanel();
		panel.add(button);

		add(panel, BorderLayout.PAGE_START);
		add(scrollPane, BorderLayout.CENTER);

		setVisible(true);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals(CONNECT_MESSAGE)) {
			try {
				Client client = new Client();
				client.connectToServer();

				consoleArea.append(client.getReceivedMessage() + System.lineSeparator());
			} catch (IOException e1) {
				JOptionPane.showMessageDialog(this, NO_SERVER_ON_THAT_PORT_MESSAGE, "Error",
						JOptionPane.ERROR_MESSAGE);
			}
		}
	}

}

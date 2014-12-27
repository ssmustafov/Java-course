package com.sirma.itt.javacourse.gui.infoserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.sirma.itt.javacourse.gui.utils.SocketUtils;

/**
 * Represents a Client in the Client/Server application.
 * 
 * @author Sinan
 */
public class Client extends Thread {
	private static final Logger LOGGER = LogManager.getLogger(Client.class);
	private Socket socket;
	private BufferedReader reader;
	private View view;

	/**
	 * Creates a new Client with given view for the user interface.
	 * 
	 * @param view
	 *            - the view for the user interface
	 */
	public Client(View view) {
		this.view = view;
		this.view.getButton().addActionListener(new ClientActionListener(this));
	}

	/**
	 * Connects to the server.
	 */
	public void connectToServer() {
		view.getButton().setEnabled(false);

		try {
			socket = SocketUtils.openSocket();
			reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			view.appendMessageToConsole("Connected to the server...");
		} catch (IOException e) {
			view.showErrorDialog(e.getMessage());
			interrupt();
			LOGGER.error(e.getMessage(), e);
		}
	}

	@Override
	public void run() {
		try {
			readLoop();
		} catch (NoSocketException e) {
			view.showErrorDialog(e.getMessage());
			LOGGER.error(e.getMessage(), e);
		} catch (IOException e) {
			view.showErrorDialog("An error occured during reading from the server.");
			LOGGER.error(e.getMessage(), e);
		} finally {
			try {
				if (socket != null) {
					socket.close();
				}
				if (reader != null) {
					reader.close();
				}
				view.getButton().setEnabled(true);
			} catch (IOException e) {
				LOGGER.error(e.getMessage(), e);
			}
		}
	}

	/**
	 * Reads from the sockets stream in a loop until the server sends the string for termination of
	 * the server.
	 * 
	 * @throws NoSocketException
	 *             - thrown when the server stops
	 * @throws IOException
	 *             - thrown when I/O exception occurs
	 */
	private void readLoop() throws NoSocketException, IOException {
		String serverResponse;
		while (true) {
			serverResponse = reader.readLine();
			if (serverResponse == null
					|| Server.CLOSING_SERVER_MESSAGE.equalsIgnoreCase(serverResponse)) {
				throw new NoSocketException("The server has stopped.");
			} else {
				view.appendMessageToConsole(serverResponse);
			}
		}
	}
}

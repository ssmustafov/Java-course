package com.sirma.itt.javacourse.gui.reverseserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.sirma.itt.javacourse.gui.utils.SocketUtils;

/**
 * Represents a client. Holds methods for connecting to a server. In a thread it starts to read and
 * write to the server. The thread waits until a new message is set.
 * 
 * @see SocketUtils
 * @author Sinan
 */
public class Client extends Thread {
	private static final Logger LOGGER = LogManager.getLogger(Client.class);
	private Socket socket;
	private PrintWriter writer;
	private BufferedReader reader;
	private ClientView view;
	private String message;

	/**
	 * Creates a new client with given user interface.
	 * 
	 * @param view
	 *            - the user interface of the client
	 */
	public Client(ClientView view) {
		this.view = view;
	}

	/**
	 * Connects to a server.
	 */
	public void connectToServer() {
		try {
			socket = SocketUtils.openSocket();
			reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			writer = new PrintWriter(socket.getOutputStream(), true);
			view.appendMessageToConsole(reader.readLine());
		} catch (IOException e) {
			view.showErrorDialog("There is no running server in ports range [7000...7020]");
			LOGGER.error(e.getMessage(), e);
		}
	}

	/**
	 * Sets the message of the client.
	 * 
	 * @param message
	 *            - the message to be set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * Notifies this thread that the client has entered a message.
	 */
	public synchronized void notifyClient() {
		notify();
	}

	/**
	 * Sends a message to the server.
	 * 
	 * @param message
	 *            - the message to be sent to the server
	 */
	public void sendMessageToServer(String message) {
		writer.println(message);
	}

	/**
	 * Reads and returns a message from the server.
	 * 
	 * @return - the read message from the server
	 * @throws IOException
	 *             - thrown when I/O exception occurs
	 */
	public String readMessageFromServer() throws IOException {
		return reader.readLine();
	}

	/**
	 * While there is no message this thread waits until a new one is set. {@inheritDoc}
	 */
	@Override
	public synchronized void run() {
		String serverResponse;
		try {
			while (true) {
				if (message == null || message.isEmpty()) {
					wait();
				}

				sendMessageToServer(message);

				if (message.equals(CommunicationConstants.CLIENT_END_READING_MESSAGE)) {
					view.appendMessageToConsole("Disconnected from the server");
					break;
				}

				serverResponse = readMessageFromServer();
				if (CommunicationConstants.STOPPING_SERVER_MESSAGE.equals(serverResponse)) {
					view.showErrorDialog("The server has been stopped");
					break;
				}

				String formatedMessage = String.format("The reverse of [%s] is [%s]", message,
						serverResponse);
				view.appendMessageToConsole(formatedMessage);

				message = null;
			}
		} catch (SocketException e) {
			LOGGER.error(e.getMessage(), e);
		} catch (IOException e) {
			LOGGER.error(e.getMessage(), e);
		} catch (InterruptedException e) {
			LOGGER.error(e.getMessage(), e);
		} finally {
			closeStreams();
			view.getConnectButton().setEnabled(true);
			view.getSendButton().setEnabled(false);
		}
	}

	/**
	 * Extracts the message from client and returns it as {@code MessageMemento}.
	 * 
	 * @return - memento of the current message
	 */
	public MessageMemento saveMemento() {
		return new MessageMemento(message);
	}

	/**
	 * Restores a given {@code MessageMemento} for this client.
	 * 
	 * @param memento
	 *            - the memento from which to be restored
	 */
	public void restoreMemento(MessageMemento memento) {
		this.message = memento.getMessage();
	}

	/**
	 * Closes all the streams in the client.
	 */
	private void closeStreams() {
		if (writer != null) {
			writer.close();
		}
		if (reader != null) {
			try {
				reader.close();
				interrupt();
			} catch (IOException e) {
				LOGGER.error(e.getMessage(), e);
			}
		}
	}
}

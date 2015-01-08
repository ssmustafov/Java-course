package com.sirma.itt.javacourse.gui.reverseserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Reverses a messages from the client.
 * 
 * @author Sinan
 */
public class ClientHandler extends Thread {
	private static final Logger LOGGER = LogManager.getLogger(ClientHandler.class);
	private Socket clientSocket;
	private PrintWriter writer;
	private BufferedReader reader;
	private boolean isServerStopped = false;
	private ServerView view;

	/**
	 * Creates a new handler for a client with given socket and user interface of the server.
	 * 
	 * @param clientSocket
	 *            - the socket of the client
	 * @param view
	 *            - the user interface of the server
	 */
	public ClientHandler(Socket clientSocket, ServerView view) {
		this.clientSocket = clientSocket;
		this.view = view;
		setClientTimeout();
		createStreams();
	}

	/**
	 * Reads a message from the client.
	 * 
	 * @return - a message from the client
	 * @throws IOException
	 *             - thrown when I/O exception occurs
	 */
	public String readClientMessage() throws IOException {
		return reader.readLine();
	}

	/**
	 * Writes the given message as reversed to the client.
	 * 
	 * @param message
	 *            - the message that will be reversed and sent to the client
	 */
	public void writeReversedMessage(String message) {
		String reversedMessage = reverseMessage(message);
		writer.println(reversedMessage);
	}

	/**
	 * Sets that the server has stopped.
	 */
	public synchronized void setServerStopped() {
		isServerStopped = true;
	}

	/**
	 * Reverses and returns a given message.
	 * 
	 * @param message
	 *            - the message to be reversed
	 * @return - the reversed message
	 */
	private String reverseMessage(String message) {
		StringBuffer reversedMessage = new StringBuffer(message);
		return reversedMessage.reverse().toString();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void run() {
		String clientMessage;
		try {
			while (true) {
				if (isServerStopped) {
					break;
				}

				clientMessage = readClientMessage();
				if (CommunicationConstants.CLIENT_END_READING_MESSAGE.equals(clientMessage)) {
					view.appendMessageToConsole(">> A client is disconnected");
					break;
				}

				writeReversedMessage(clientMessage);
			}
		} catch (IOException e) {
			LOGGER.error(e.getMessage(), e);
		} finally {
			closeStreams();
		}
	}

	/**
	 * Sets a timeout for the client.
	 */
	private void setClientTimeout() {
		try {
			clientSocket.setSoTimeout(Server.CLIENT_READ_TIMEOUT);
		} catch (SocketException e) {
			LOGGER.error(e.getMessage(), e);
		}
	}

	/**
	 * Creates the streams for the client.
	 */
	private void createStreams() {
		try {
			writer = new PrintWriter(clientSocket.getOutputStream(), true);
			reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		} catch (IOException e) {
			LOGGER.error(e.getMessage(), e);
		}
	}

	/**
	 * Closes the streams for the client.
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

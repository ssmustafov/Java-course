package com.sirma.itt.javacourse.gui.helloserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

import com.sirma.itt.javacourse.gui.utils.SocketUtils;

/**
 * Communicates with server socket and reads from its stream.
 * 
 * @author Sinan
 */
public class Client {
	private String receivedMessage = "";

	/**
	 * Returns the read message from the server socket.
	 * 
	 * @return - the read message from the server socket
	 */
	public synchronized String getReceivedMessage() {
		return receivedMessage;
	}

	/**
	 * Connects to the server socket and reads from its stream.
	 * 
	 * @throws IOException
	 *             - thrown when the server socket is closed.
	 */
	public void connectToServer() throws IOException {
		try (Socket socket = SocketUtils.openSocket();
				BufferedReader in = new BufferedReader(new InputStreamReader(
						socket.getInputStream()));) {
			receivedMessage = in.readLine();
		}
	}
}

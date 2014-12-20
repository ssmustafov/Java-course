package com.sirma.itt.javacourse.gui.helloserver;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Represents a thread. Opens a server socket and infinitely accepts clients until its stopServer
 * method is invoked.
 * 
 * @author Sinan
 */
public class ServerListener extends Thread {
	private static final Logger LOGGER = LogManager.getLogger(ServerListener.class);
	private ServerSocket serverSocket;
	private boolean isClosed = false;

	/**
	 * Binds a server socket to listen in given port.
	 */
	private void bindServerSocket() {
		try {
			serverSocket = new ServerSocket(7002);
		} catch (IOException e) {
			LOGGER.error("Cannot start to listen on port 7002", e);
			System.exit(-1);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void run() {
		bindServerSocket();

		while (!isClosed) {
			try {
				Socket socket = serverSocket.accept();
				ServerProtocol client = new ServerProtocol(socket);
				client.start();
			} catch (IOException e) {
				LOGGER.error(e);
			}
		}
	}

	/**
	 * Stops the server socket from listening.
	 */
	public void stopServer() {
		if (serverSocket != null) {
			try {
				isClosed = true;
				serverSocket.close();
			} catch (IOException e) {
				LOGGER.error(e);
			}
		}
	}
}

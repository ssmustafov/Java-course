package com.sirma.itt.javacourse.gui.helloserver;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.sirma.itt.javacourse.gui.utils.SocketUtils;

/**
 * Represents a thread. Opens a server socket and infinitely accepts clients until its stopServer
 * method is invoked.
 * 
 * @author Sinan
 */
public class Server implements Runnable {
	private static final Logger LOGGER = LogManager.getLogger(Server.class);
	private ServerSocket serverSocket;
	private boolean isClosed = false;

	/**
	 * Binds a server socket to listen in given port.
	 */
	public void startServer() {
		try {
			serverSocket = SocketUtils.openServerSocket();
			new Thread(this).start();
		} catch (IOException e) {
			LOGGER.error(e.getMessage(), e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void run() {
		while (!isClosed) {
			try {
				Socket socket = serverSocket.accept();
				ServerProtocol client = new ServerProtocol(socket);
				client.start();
			} catch (IOException e) {
				LOGGER.info(e);
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

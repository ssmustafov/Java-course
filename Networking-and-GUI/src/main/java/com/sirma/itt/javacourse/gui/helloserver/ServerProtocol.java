package com.sirma.itt.javacourse.gui.helloserver;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Sends the current date through {@code OutputStreamWriter} in given socket.
 * 
 * @author Sinan
 */
public class ServerProtocol extends Thread {
	private static final Logger LOGGER = LogManager.getLogger(ServerProtocol.class);
	private static final String HELLO_MESSAGE = "Hello! ";
	private Socket socket;
	private OutputStreamWriter out;

	/**
	 * Creates a new server protocol with given socket.
	 * 
	 * @param socket
	 *            - the socket in which the current date will be transmitted
	 * @throws IOException
	 *             - thrown when the server stops accepting clients
	 */
	public ServerProtocol(Socket socket) throws IOException {
		this.socket = socket;
		out = new OutputStreamWriter(this.socket.getOutputStream());
	}

	/**
	 * Returns the current date as string.
	 * 
	 * @return - the current date as string
	 */
	public String getDateAsString() {
		return new Date().toString();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void run() {
		try {
			out.write(HELLO_MESSAGE + getDateAsString());
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				out.close();
				socket.close();
			} catch (IOException e) {
				LOGGER.error(e);
			}
		}
	}
}

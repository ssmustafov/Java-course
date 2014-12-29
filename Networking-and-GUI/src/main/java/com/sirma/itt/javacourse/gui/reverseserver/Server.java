package com.sirma.itt.javacourse.gui.reverseserver;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.sirma.itt.javacourse.gui.utils.SocketUtils;

/**
 * Represents a server. Holds methods for starting and stopping a server. When a client is accepted
 * it transmits him to a {@code ClientHandler} thread.
 * 
 * @author Sinan
 */
public class Server {
	/**
	 * 15 minutes wait time for the clients.
	 */
	public static final int CLIENT_READ_TIMEOUT = 300000;

	private static final Logger LOGGER = LogManager.getLogger(Server.class);
	private ServerSocket serverSocket;
	private Socket clientSocket;
	private PrintWriter writer;
	private List<ClientHandler> clientHandlersList;
	private ServerView view;

	/**
	 * Creates a new server with given user interface.
	 * 
	 * @param view
	 *            - the user interface of the server
	 */
	public Server(ServerView view) {
		this.view = view;
		clientHandlersList = new ArrayList<>();
	}

	/**
	 * Starts the server.
	 */
	public void startServer() {
		try {
			serverSocket = SocketUtils.openServerSocket();

			view.appendMessageToConsole(">> Server started at port: " + serverSocket.getLocalPort());

			acceptClient();
		} catch (IOException e) {
			view.showErrorDialog("Cannot start a server. Please try again.");
			LOGGER.error(e.getMessage(), e);
		}
	}

	/**
	 * Accepts clients in an infinite loop. When a client is accepted it transmits him to a
	 * {@code ClientHandler} thread.
	 */
	private void acceptClient() {
		try {
			while (true) {
				clientSocket = serverSocket.accept();
				writer = new PrintWriter(clientSocket.getOutputStream(), true);

				view.appendMessageToConsole(">> A new client accepted");
				writer.println(CommunicationConstants.CLIENT_WELCOME_MESSAGE);

				ClientHandler clientHandler = new ClientHandler(clientSocket, view);
				clientHandler.start();
				clientHandlersList.add(clientHandler);
			}
		} catch (IOException e) {
			LOGGER.error(e.getMessage(), e);
		}
	}

	/**
	 * Stops the server.
	 */
	public void stopServer() {
		synchronized (clientHandlersList) {
			for (ClientHandler clientHandler : clientHandlersList) {
				clientHandler.setServerStopped();
			}
		}

		if (writer != null) {
			writer.close();
		}
		if (serverSocket != null) {
			try {
				serverSocket.close();
			} catch (IOException e) {
				view.showErrorDialog("There was a problem stopping the server.");
				LOGGER.error(e.getMessage(), e);
			}
		}
		if (clientSocket != null) {
			try {
				clientSocket.close();
			} catch (IOException e) {
				view.showErrorDialog("There was a problem disconnecting from the server.");
				LOGGER.error(e.getMessage(), e);
			}
		}
	}
}

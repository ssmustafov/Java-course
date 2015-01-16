package com.sirma.itt.javacourse.gui.infoserver;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.sirma.itt.javacourse.gui.utils.SocketUtils;

/**
 * Represents a Server in the Client/Server application. It holds a list of the connected clients.
 * 
 * @author Sinan
 */
public class Server implements Runnable {
	private static final Logger LOGGER = LogManager.getLogger(Server.class);
	public static final String CLOSING_SERVER_MESSAGE = "end";
	private List<Socket> clients;
	private ServerSocket serverSocket;
	private Socket currentClient;
	private PrintWriter writer;
	private View view;

	/**
	 * Creates a new Server with given view for the user interface.
	 * 
	 * @param view
	 *            - the view for the user interface
	 */
	public Server(View view) {
		clients = Collections.synchronizedList(new ArrayList<Socket>());
		this.view = view;
		this.view.getButton().addActionListener(new ServerActionListener(this));
	}

	/**
	 * Starts the server. Creates a new {@code ServerSocket} and starts to accept clients.
	 */
	public void startServer() {
		try {
			serverSocket = SocketUtils.openServerSocket();

			view.appendMessageToConsole(">> SERVER STARTED AT PORT-" + serverSocket.getLocalPort());

			new Thread(this).start();
		} catch (IOException e) {
			view.showErrorDialog(e.getMessage());
			LOGGER.error(e.getMessage(), e);
		}
	}

	/**
	 * Stops the server.
	 */
	public void stopServer() {
		if (writer != null) {
			writer.println(CLOSING_SERVER_MESSAGE);
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
		if (currentClient != null) {
			try {
				currentClient.close();
			} catch (IOException e) {
				view.showErrorDialog("There was a problem disconnecting from the server.");
				LOGGER.error(e.getMessage(), e);
			}
		}
		clients.clear();
		view.disposeView();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void run() {
		acceptClients();
	}

	/**
	 * In an infinite loop accepts clients. For every connected client it creates a new
	 * {@code ClientNotifier} thread which notifies the other clients that a new client is
	 * connected.
	 */
	private void acceptClients() {
		while (true) {
			try {
				currentClient = serverSocket.accept();
				clients.add(currentClient);

				writer = new PrintWriter(currentClient.getOutputStream(), true);
				view.appendMessageToConsole(">> ACCEPTED A NEW CLIENT#" + clients.size());
				writer.println("You are client number-" + clients.size());

				if (clients.size() > 1) {
					new ClientNotifier(clients);
				}
			} catch (IOException e) {
				view.appendMessageToConsole(">> SERVER IS CLOSED");
				view.getButton().setEnabled(false);
				LOGGER.info(e.getMessage(), e);
				break;
			}
		}
	}

}

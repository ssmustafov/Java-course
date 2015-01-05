package com.sirma.itt.javacourse.chatclient.client;

import java.io.IOException;
import java.net.Socket;

import com.sirma.itt.javacourse.chatclient.utils.ServerFinder;
import com.sirma.itt.javacourse.chatclient.views.View;
import com.sirma.itt.javacourse.chathelper.utils.Query;
import com.sirma.itt.javacourse.chathelper.utils.QueryHandler;
import com.sirma.itt.javacourse.chathelper.utils.QueryTypes;

/**
 * @author Sinan
 */
public class Client {

	private Socket client;
	private QueryHandler queryHandler;
	private View view;

	/**
	 * @param view
	 *            - the view
	 */
	public Client(View view) {
		this.view = view;
	}

	/**
	 * Connects to the chat server.
	 */
	public void connectToServer() {
		try {
			client = ServerFinder.openSocket();
			queryHandler = new QueryHandler(client);
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}

		ClientThread t = new ClientThread(queryHandler, view);
		t.start();

		queryHandler.sendQuery(new Query(QueryTypes.Login, "Sinan"));
	}

	public void sendMessage(String message) {
		queryHandler.sendQuery(new Query(QueryTypes.SendMessage, message));
	}

}

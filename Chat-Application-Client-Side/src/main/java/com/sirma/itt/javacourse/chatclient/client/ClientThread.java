package com.sirma.itt.javacourse.chatclient.client;

import com.sirma.itt.javacourse.chatclient.commands.ClientCommand;
import com.sirma.itt.javacourse.chatclient.commands.ClientCommandFactory;
import com.sirma.itt.javacourse.chatclient.views.View;
import com.sirma.itt.javacourse.chathelper.utils.Query;
import com.sirma.itt.javacourse.chathelper.utils.QueryHandler;

/**
 * @author Sinan
 */
public class ClientThread extends Thread {

	private QueryHandler queryHandler;
	private View view;

	/**
	 * @param queryHandler
	 * @param view
	 */
	public ClientThread(QueryHandler queryHandler, View view) {
		this.queryHandler = queryHandler;
		this.view = view;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void run() {
		Query query = null;
		while ((query = queryHandler.readQuery()) != null) {
			handleServerQuery(query);
		}

		queryHandler.closeStreams();
		interrupt();
	}

	/**
	 * @param query
	 */
	private void handleServerQuery(Query query) {
		ClientCommand command = ClientCommandFactory.createCommand(view, query);
		command.execute(query);
	}

}

package com.sirma.itt.javacourse.chatserver.commands;

import com.sirma.itt.javacourse.chathelper.utils.Query;
import com.sirma.itt.javacourse.chathelper.utils.QueryTypes;
import com.sirma.itt.javacourse.chatserver.server.Client;
import com.sirma.itt.javacourse.chatserver.server.ServerDispatcher;
import com.sirma.itt.javacourse.chatserver.view.View;

/**
 * @author Sinan
 */
public class SendMessageCommand extends ServerCommand {

	private Query clientQuery;

	/**
	 * @param serverDispacher
	 */
	public SendMessageCommand(ServerDispatcher serverDispatcher, View view, Query clientQuery) {
		super(serverDispatcher, view);
		this.clientQuery = clientQuery;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void execute(Client client) {
		String clientMessage = clientQuery.getMessage();
		String formattedMessage = String.format("<%s>: %s", client.getNickname(), clientMessage);
		getServerDispatcher().dispatchQuery(new Query(QueryTypes.SendMessage, formattedMessage));
	}

}

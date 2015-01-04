package com.sirma.itt.javacourse.chatserver.commands;

import com.sirma.itt.javacourse.chathelper.utils.Query;
import com.sirma.itt.javacourse.chatserver.server.Client;
import com.sirma.itt.javacourse.chatserver.server.ServerDispatcher;
import com.sirma.itt.javacourse.chatserver.view.View;

/**
 * @author Sinan
 */
public class SendMessageCommand extends ServerCommand {

	/**
	 * @param serverDispacher
	 */
	public SendMessageCommand(ServerDispatcher serverDispatcher, View view, Query clientQuery) {
		super(serverDispatcher, view);
		// TODO Auto-generated constructor stub
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void execute(Client client) {
		// TODO Auto-generated method stub

	}

}

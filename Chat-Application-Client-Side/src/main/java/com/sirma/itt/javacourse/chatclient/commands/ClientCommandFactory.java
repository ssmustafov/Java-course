package com.sirma.itt.javacourse.chatclient.commands;

import com.sirma.itt.javacourse.chatclient.views.View;
import com.sirma.itt.javacourse.chathelper.utils.Query;

/**
 * @author smustafov
 */
public final class ClientCommandFactory {

	/**
	 * Protects from instantiation.
	 */
	private ClientCommandFactory() {

	}

	/**
	 * @param view
	 * @param query
	 * @return
	 */
	public static ClientCommand createCommand(View view, Query query) {
		ClientCommand command = null;

		switch (query.getQueryType()) {
			case Success:
				command = new SuccesCommand(view);
				break;
			case SendMessage:
				command = new SendMessageCommand(view);
				break;

			default:
				throw new IllegalArgumentException("Not supported command");
		}

		return command;
	}

}

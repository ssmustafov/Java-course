package com.sirma.itt.javacourse.chatclient.commands;

import com.sirma.itt.javacourse.chatclient.views.View;
import com.sirma.itt.javacourse.chathelper.utils.Query;

/**
 * @author smustafov
 */
public class SuccesCommand extends ClientCommand {

	/**
	 * @param view
	 * @param query
	 */
	public SuccesCommand(View view) {
		super(view);

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void execute(Query query) {
		getClientView().appendMessageToChatArea(query.getMessage());
	}

}

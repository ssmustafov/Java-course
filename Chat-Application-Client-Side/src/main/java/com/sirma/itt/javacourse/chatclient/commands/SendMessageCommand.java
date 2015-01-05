package com.sirma.itt.javacourse.chatclient.commands;

import com.sirma.itt.javacourse.chatclient.views.View;
import com.sirma.itt.javacourse.chathelper.utils.Query;

/**
 * @author smustafov
 */
public class SendMessageCommand extends ClientCommand {

	private View view;

	/**
	 * @param view
	 */
	public SendMessageCommand(View view) {
		super(view);
		this.view = view;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void execute(Query query) {
		String message = query.getMessage();
		view.appendMessageToChatArea(message);
	}

}

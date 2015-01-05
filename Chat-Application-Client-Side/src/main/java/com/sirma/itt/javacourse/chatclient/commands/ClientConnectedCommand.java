package com.sirma.itt.javacourse.chatclient.commands;

import com.sirma.itt.javacourse.chatclient.views.View;
import com.sirma.itt.javacourse.chathelper.utils.Query;

/**
 * @author smustafov
 */
public class ClientConnectedCommand extends ClientCommand {

	private View view;

	/**
	 * @param view
	 */
	public ClientConnectedCommand(View view) {
		super(view);
		this.view = view;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void execute(Query query) {
		String nickname = query.getMessage();
		view.addOnlineClient(nickname);
	}

}
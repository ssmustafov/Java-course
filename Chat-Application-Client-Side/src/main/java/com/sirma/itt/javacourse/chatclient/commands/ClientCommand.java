package com.sirma.itt.javacourse.chatclient.commands;

import com.sirma.itt.javacourse.chatclient.views.View;
import com.sirma.itt.javacourse.chathelper.utils.Query;

/**
 * @author smustafov
 */
public abstract class ClientCommand {
	private View view;

	public ClientCommand(View view) {
		this.view = view;
	}

	/**
	 * Returns the {@link View}.
	 * 
	 * @return - the client view
	 */
	protected View getClientView() {
		return view;
	}

	/**
	 * Executes the query of the given {@link Query}.
	 * 
	 * @param query
	 *            - the client which query will be executed
	 */
	public abstract void execute(Query query);
}

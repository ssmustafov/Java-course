package com.sirma.itt.javacourse.chatserver.commands;

import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.sirma.itt.javacourse.chathelper.utils.Query;
import com.sirma.itt.javacourse.chathelper.utils.QueryTypes;
import com.sirma.itt.javacourse.chatserver.server.Client;
import com.sirma.itt.javacourse.chatserver.server.ServerDispatcher;
import com.sirma.itt.javacourse.chatserver.utils.LanguageBundleSingleton;
import com.sirma.itt.javacourse.chatserver.view.View;

/**
 * @author Sinan
 */
public class LoginCommand extends ServerCommand {

	private Query clientQuery;
	private ResourceBundle bundle = LanguageBundleSingleton.getBundleInstance();

	/**
	 * @param serverDispacher
	 *            - the
	 * @param view
	 *            - the view
	 * @param clientQuery
	 *            - the
	 */
	public LoginCommand(ServerDispatcher serverDispacher, View view, Query clientQuery) {
		super(serverDispacher, view);
		this.clientQuery = clientQuery;
	}

	private String nicknameRegEx = "[\\w\\d-]+";
	private Pattern nicknamePattern = Pattern.compile(nicknameRegEx, Pattern.CASE_INSENSITIVE);

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void execute(Client client) {
		String nickname = clientQuery.getMessage();

		if (getServerDispatcher().containsClient(nickname)) {
			client.sendQuery(new Query(QueryTypes.Refused, "That nickname is already in use"));
			return;
		}
		if (nickname.isEmpty()) {
			client.sendQuery(new Query(QueryTypes.Refused, "Nickname is empty"));
			return;
		}
		if (nickname.length() > 15) {
			client.sendQuery(new Query(QueryTypes.Refused,
					"The maximum length of the nickname is 15"));
			return;
		}
		Matcher matcher = nicknamePattern.matcher(nickname);
		if (!matcher.matches()) {
			client.sendQuery(new Query(QueryTypes.Refused,
					"The nickname contains forbidden symbols. Can consist of letters, numbers, -, _"));
			return;
		}

		client.setNickname(nickname);
		getServerDispatcher().addClient(client);
		client.sendQuery(new Query(QueryTypes.Success, "Welcome, " + nickname));

		getServerView().appendMessageToConsole(bundle.getString("clientConnected") + nickname);
		getServerView().appendMessageToConsole(bundle.getString("startedThread") + nickname);

		getServerView().addOnlineClient(nickname);
	}
}

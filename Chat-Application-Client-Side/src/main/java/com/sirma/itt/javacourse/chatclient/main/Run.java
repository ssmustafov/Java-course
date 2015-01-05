package com.sirma.itt.javacourse.chatclient.main;

import com.sirma.itt.javacourse.chatclient.views.ClientView;

/**
 * Starts a new client for the chat application.
 * 
 * @author Sinan
 */
public final class Run {

	/**
	 * Protects from instantiation.
	 */
	private Run() {

	}

	/**
	 * Main method.
	 * 
	 * @param args
	 *            - arguments
	 */
	public static void main(String[] args) {
		new ClientView();
	}
}

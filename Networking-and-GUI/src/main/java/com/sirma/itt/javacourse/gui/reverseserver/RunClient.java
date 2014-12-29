package com.sirma.itt.javacourse.gui.reverseserver;

/**
 * Starts a new client from the server-client application.
 * 
 * @author Sinan
 */
public final class RunClient {

	/**
	 * Protects from instantiation.
	 */
	private RunClient() {

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

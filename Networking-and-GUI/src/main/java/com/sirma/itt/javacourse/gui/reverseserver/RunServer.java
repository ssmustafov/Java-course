package com.sirma.itt.javacourse.gui.reverseserver;

/**
 * Starts a new server in the client-server application.
 * 
 * @author Sinan
 */
public final class RunServer {

	/**
	 * Protects from instantiation.
	 */
	private RunServer() {

	}

	/**
	 * Main method.
	 * 
	 * @param args
	 *            - arguments
	 */
	public static void main(String[] args) {
		new ServerView();
	}
}

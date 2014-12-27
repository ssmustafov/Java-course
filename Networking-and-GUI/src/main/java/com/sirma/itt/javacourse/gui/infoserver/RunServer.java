package com.sirma.itt.javacourse.gui.infoserver;

/**
 * Starts a new Server.
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
		View view = new ServerView();
		new Server(view).startServer();
	}
}

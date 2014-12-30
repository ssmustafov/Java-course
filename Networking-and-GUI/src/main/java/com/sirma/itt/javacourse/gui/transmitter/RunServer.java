package com.sirma.itt.javacourse.gui.transmitter;

/**
 * Starts a new multicasting server.
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

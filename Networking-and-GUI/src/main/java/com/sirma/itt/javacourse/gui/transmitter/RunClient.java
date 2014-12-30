package com.sirma.itt.javacourse.gui.transmitter;

/**
 * Starts a new client.
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

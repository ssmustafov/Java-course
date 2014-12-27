package com.sirma.itt.javacourse.gui.infoserver;

/**
 * Starts a new Client.
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
		View view = new ClientView();
		new Client(view);
	}

}

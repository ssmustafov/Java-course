package com.sirma.itt.javacourse.gui.reverseserver;

/**
 * Holds a constants serving for communication between the client and server.
 * 
 * @author Sinan
 */
public final class CommunicationConstants {
	/**
	 * Protects from instantiation.
	 */
	private CommunicationConstants() {

	}

	/**
	 * Send from the server when it will stop.
	 */
	public static final String STOPPING_SERVER_MESSAGE = "end";

	/**
	 * Send from the server when the client first connected.
	 */
	public static final String CLIENT_WELCOME_MESSAGE = "Welcome. You can start typing messages:";

	/**
	 * Send from the client. Meaning that the client wants to end session with the server.
	 */
	public static final String CLIENT_END_READING_MESSAGE = ".";
}

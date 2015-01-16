package com.sirma.itt.javacourse.gui.infoserver;

/**
 * Thrown when the Server in a Client/Server application stops.
 * 
 * @author Sinan
 */
public class NoSocketException extends Exception {

	private static final long serialVersionUID = 5354443218828873751L;

	/**
	 * Create a new empty {@link NoSocketException}.
	 */
	public NoSocketException() {

	}

	/**
	 * Create a new {@link NoSocketException} with given message.
	 * 
	 * @param message
	 *            - message for the exception
	 */
	public NoSocketException(String message) {
		super(message);
	}

	/**
	 * Create a new {@link NoSocketException} with given message and caused exception.
	 * 
	 * @param message
	 *            - message for the exception
	 * @param cause
	 *            - the caused exception
	 */
	public NoSocketException(String message, Throwable cause) {
		super(message, cause);
	}

}

package com.sirma.itt.javacourse.exceptions.console;

/**
 * Thrown when given interval is not valid interval.
 * 
 * @author smustafov
 */
public class InvalidIntervalException extends RuntimeException {

	/**
	 * Comment for serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Creates a new exception.
	 */
	public InvalidIntervalException() {
		super();
	}

	/**
	 * Creates a new exception with given message.
	 * 
	 * @param message
	 *            - the message of the exception
	 */
	public InvalidIntervalException(String message) {
		super(message);
	}

}

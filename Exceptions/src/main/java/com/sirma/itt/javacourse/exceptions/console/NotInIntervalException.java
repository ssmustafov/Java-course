package com.sirma.itt.javacourse.exceptions.console;

/**
 * Thrown when given number is not in defined interval.
 * 
 * @author smustafov
 */
public class NotInIntervalException extends RuntimeException {

	/**
	 * Comment for serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Creates a new exception.
	 */
	public NotInIntervalException() {
		super();
	}

	/**
	 * Creates a new exception with given message.
	 * 
	 * @param message
	 *            - the message of the exception
	 */
	public NotInIntervalException(String message) {
		super(message);
	}

}

package com.sirma.itt.javacourse.collections.manager;

/**
 * Thrown when given message code does not exist in collection.
 * 
 * @author smustafov
 */
public class NoSuchMessageCodeException extends Exception {

	/**
	 * Comment for serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Creates a new <code>NoSuchMessageCodeException</code>.
	 */
	public NoSuchMessageCodeException() {
		super();
	}

	/**
	 * Creates a new <code>NoSuchMessageCodeException</code> with given message.
	 * 
	 * @param message
	 *            - message of the exception
	 */
	public NoSuchMessageCodeException(String message) {
		super(message);
	}

}

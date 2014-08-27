package com.sirma.itt.javacourse.collections.manager;

/**
 * Thrown when given message does not exist in collection.
 * 
 * @author smustafov
 */
public class NoSuchMessageException extends Exception {

	/**
	 * Comment for serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Creates a new <code>NoSuchMessageException</code>.
	 */
	public NoSuchMessageException() {
		super();
	}

	/**
	 * Creates a new <code>NoSuchMessageException</code> with given message.
	 * 
	 * @param message
	 *            - message of the exception
	 */
	public NoSuchMessageException(String message) {
		super(message);
	}

}

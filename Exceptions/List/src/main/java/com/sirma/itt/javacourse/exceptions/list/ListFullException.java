package com.sirma.itt.javacourse.exceptions.list;

/**
 * Thrown to indicate that there is no more space to add element in a list.
 * 
 * @author smustafov
 */
public class ListFullException extends RuntimeException {

	/**
	 * Comment for serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Creates a ListFullException.
	 */
	public ListFullException() {
		super("The list is full");
	}

	/**
	 * Creates a ListFullException with given message.
	 * 
	 * @param message
	 *            - the message to be set
	 */
	public ListFullException(String message) {
		super(message);
	}

}

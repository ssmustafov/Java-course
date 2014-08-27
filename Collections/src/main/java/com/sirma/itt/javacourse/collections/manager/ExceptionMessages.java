package com.sirma.itt.javacourse.collections.manager;

/**
 * @author smustafov
 */
public enum ExceptionMessages {

	DebitCart("Invalid debit cart ID"), PersonalID("Invalid personal ID"), PostalCode(
			"Invalid postal code");

	private String message;

	/**
	 * @param message
	 *            - message of the enum
	 */
	ExceptionMessages(String message) {
		this.message = message;
	}

	/**
	 * Returns the message of the enum type.
	 * 
	 * @return - message of the enum type
	 */
	public String getMessage() {
		return message;
	}

}

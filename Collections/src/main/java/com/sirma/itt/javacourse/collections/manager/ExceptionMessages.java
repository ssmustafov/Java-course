package com.sirma.itt.javacourse.collections.manager;

/**
 * Holds defined enumerations with predefined messages.
 * 
 * @author smustafov
 */
public enum ExceptionMessages {

	DebitCart("Invalid debit cart ID"), PersonalID("Invalid personal ID"), PostalCode(
			"Invalid postal code");

	private String message;

	/**
	 * @param message
	 *            - message of the enumeration
	 */
	ExceptionMessages(String message) {
		this.message = message;
	}

	/**
	 * Returns the message of the enumeration type.
	 * 
	 * @return - message of the enumeration type
	 */
	public String getMessage() {
		return message;
	}

}

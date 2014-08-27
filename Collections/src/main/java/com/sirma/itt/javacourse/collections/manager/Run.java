package com.sirma.itt.javacourse.collections.manager;

/**
 * Shows how the ExceptionsMessageManager class can be used.
 * 
 * @author smustafov
 */
public final class Run {

	/**
	 * Protects from instantiation.
	 */
	private Run() {

	}

	/**
	 * Main method.
	 * 
	 * @param args
	 *            - arguments
	 */
	public static void main(String[] args) {
		try {
			ExceptionsMessageManager manager = new ExceptionsMessageManager(
					ExceptionMessages.DebitCart, ExceptionMessages.PersonalID,
					ExceptionMessages.PostalCode);
			// manager.addExceptionMessage("No such message");
			// manager.addExceptionMessage(ExceptionMessages.DebitCart.getMessage());
			manager.addExceptionMessage(ExceptionMessages.PersonalID.getMessage());
			manager.addExceptionMessageUsingCode(ExceptionMessages.DebitCart.name());
			System.out.println(manager.getMessage());
			ExceptionsMessageManager.getMessages(manager.getMessage());
		} catch (IllegalArgumentException e) {
			System.err.println(e.getMessage());
		}
	}
}

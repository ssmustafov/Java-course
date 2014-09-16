package com.sirma.itt.javacourse.collections.manager;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Shows how the ExceptionsMessageManager class can be used.
 * 
 * @author smustafov
 */
public final class Run {

	private static final Logger LOGGER = LogManager.getLogger(Run.class);

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
			System.out.println(ExceptionsMessageManager.getMessages(manager.getMessage()));
		} catch (NoSuchMessageException e) {
			LOGGER.error(e.getMessage(), e);
		} catch (NoSuchMessageCodeException e) {
			LOGGER.error(e.getMessage(), e);
		}
	}
}

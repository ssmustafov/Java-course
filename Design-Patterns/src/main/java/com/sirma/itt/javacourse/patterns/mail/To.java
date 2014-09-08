package com.sirma.itt.javacourse.patterns.mail;

/**
 * This interface is part of the fluent interface. It contains method for setting to who to be sent
 * a mail.
 * 
 * @author smustafov
 */
public interface To {

	/**
	 * Sets to who a mail to be sent.
	 * 
	 * @param to
	 *            - to who the mail to be sent
	 * @return - Subject interface because of the fluent interface implementation
	 */
	Subject to(String to);

}

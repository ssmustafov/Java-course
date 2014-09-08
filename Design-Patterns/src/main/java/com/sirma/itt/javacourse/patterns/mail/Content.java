package com.sirma.itt.javacourse.patterns.mail;

/**
 * This interface is part of the fluent interface. It contains method for setting the content of a
 * mail.
 * 
 * @author smustafov
 */
public interface Content {

	/**
	 * Sets the content of a mail.
	 * 
	 * @param content
	 *            - content of the mail
	 * @return - Build interface because of the fluent interface implementation
	 */
	Build content(String content);

}

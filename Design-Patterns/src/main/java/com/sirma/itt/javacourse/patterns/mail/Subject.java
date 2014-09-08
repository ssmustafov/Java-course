package com.sirma.itt.javacourse.patterns.mail;

/**
 * This interface is part of the fluent interface. It contains method for setting the subject of a
 * mail.
 * 
 * @author smustafov
 */
public interface Subject {

	/**
	 * Sets the subject of a mail.
	 * 
	 * @param subject
	 *            - subject of the mail
	 * @return - Content interface because of the fluent interface implementation
	 */
	Content subject(String subject);

}

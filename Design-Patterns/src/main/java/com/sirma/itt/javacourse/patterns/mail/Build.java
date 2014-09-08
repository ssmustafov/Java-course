package com.sirma.itt.javacourse.patterns.mail;

/**
 * This interface is part of the fluent interface. It contains optional methods such as carbon
 * copies and attachments to a mail. Also contains a method for building the hole mail.
 * 
 * @author smustafov
 */
public interface Build {

	/**
	 * Sets the carbon copies of a mail.
	 * 
	 * @param cc
	 *            - carbon copies of the mail
	 * @return build interface
	 */
	Build carbonCopies(String[] cc);

	/**
	 * Sets the attachments of a mail.
	 * 
	 * @param attachments
	 *            - attachments of the mail
	 * @return build interface
	 */
	Build attachments(String[] attachments);

	/**
	 * Builds the hole mail. It must be invoked at the end of fluent interface construction of the
	 * mail.
	 * 
	 * @return - the mail
	 */
	Mail build();

}

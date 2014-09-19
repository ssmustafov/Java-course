package com.sirma.itt.javacourse.patterns.mail;

import com.sirma.itt.javacourse.regex.regex.EmailValidator;

/**
 * Represents a mail. Enables fluent interface for easer code constructing.
 * 
 * @author smustafov
 */
public class Mail {

	private String from;
	private String to;
	private String subject;
	private String content;
	private String[] carbonCopies;
	private String[] attachments;

	/**
	 * Creates a new mail.
	 */
	public Mail() {
		carbonCopies = new String[0];
		attachments = new String[0];
	}

	/**
	 * Sets from whom is the mail. Starting point of the fluent interface.
	 * 
	 * @param from
	 *            - from who is this mail
	 * @return - interface <code>To</code>, which suggest to fluent interface what is the next
	 *         suggestion
	 */
	public static To from(String from) {
		return new Builder(from);
	}

	/**
	 * Sets from who is the mail.
	 * 
	 * @param from
	 *            - from who is the mail
	 */
	public void setFrom(String from) {
		if (!EmailValidator.isValidEmail(from)) {
			throw new IllegalArgumentException("Invalid email 'From': " + from);
		}
		this.from = from;
	}

	/**
	 * Returns from who is the mail.
	 * 
	 * @return - from who is the mail
	 */
	public String getFrom() {
		return from;
	}

	/**
	 * Sets to who to send this mail.
	 * 
	 * @param to
	 *            - to who to send this mail
	 */
	public void setTo(String to) {
		if (!EmailValidator.isValidEmail(to)) {
			throw new IllegalArgumentException("Invalid email 'To': " + to);
		}
		this.to = to;
	}

	/**
	 * Returns to who is the mail.
	 * 
	 * @return - to who is the mail
	 */
	public String getTo() {
		return to;
	}

	/**
	 * Sets the subject of the mail.
	 * 
	 * @param subject
	 *            - subject of the mail to be set
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}

	/**
	 * Returns the subject of the mail.
	 * 
	 * @return - subject of the mail
	 */
	public String getSubject() {
		return subject;
	}

	/**
	 * Sets the content of the mail.
	 * 
	 * @param content
	 *            - content of the mail to be set
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * Returns the content of the mail.
	 * 
	 * @return - content of the mail
	 */
	public String getContent() {
		return content;
	}

	/**
	 * Sets the carbon copies of the mail.
	 * 
	 * @param cc
	 *            - carbon copies of the mail to be set
	 */
	public void setCarbonCopies(String[] cc) {
		this.carbonCopies = cc;
	}

	/**
	 * Returns the carbon copies of the mail.
	 * 
	 * @return - carbon copies of the mail
	 */
	public String[] getCarbonCopies() {
		return carbonCopies;
	}

	/**
	 * Sets attachments of the mail.
	 * 
	 * @param attachments
	 *            - attachments of the mail to be set
	 */
	public void setAttachments(String[] attachments) {
		this.attachments = attachments;
	}

	/**
	 * Returns attachments in the mail.
	 * 
	 * @return - attachments in the mail
	 */
	public String[] getAttachments() {
		return attachments;
	}

	/**
	 * Displays the constructed mail.
	 */
	public void show() {
		System.out.println("---------------------------------------------");
		System.out.println("From: " + from);
		System.out.println("To: " + to);
		System.out.println("Subject: " + subject);
		System.out.println("Content: " + content);

		System.out.print("Attachments: ");
		if (attachments.length != 0) {
			for (int i = 0; i < attachments.length; i++) {
				System.out.print(attachments[i] + "  ");
			}
		} else {
			System.out.print("None");
		}
		System.out.println();

		System.out.print("Carbon copies: ");
		if (carbonCopies.length != 0) {
			for (int i = 0; i < carbonCopies.length; i++) {
				System.out.print(carbonCopies[i] + "  ");
			}
		} else {
			System.out.print("None");
		}
		System.out.println();
	}

}

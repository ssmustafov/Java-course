package com.sirma.itt.javacourse.patterns.mail;

/**
 * Shows how tha mail class can be used.
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
		Mail a = Mail.from("my_email@mail.com").to("your.mail@gmail.com").subject("Test email")
				.content("Hello sir").attachments(new String[] { "a", "b" }).build();
		a.show();
	}
}

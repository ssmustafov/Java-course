package com.sirma.itt.javacourse.patterns.mail;

/**
 * Constructs mail. Implements <code>To</code>, <code>Subject</code>, <code>Content</code>,
 * <code>Build</code> interfaces. These interfaces are designed to make fluent interface when
 * constructing the mail. Each interface contains one method which returns the next suggested method
 * of the fluent interface, except the <code>Build</code> interface which contains optional methods
 * such as attachments and carbon copies.
 * 
 * @author smustafov
 */
public class Builder implements To, Subject, Content, Build {

	private Mail instance = new Mail();

	/**
	 * Creates a new builder.
	 * 
	 * @param from
	 *            - from who is the mail
	 */
	public Builder(String from) {
		instance.setFrom(from);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Build carbonCopies(String[] cc) {
		instance.setCarbonCopies(cc);
		return this;
	}

	/**
	 * Returns the instance of the mail. {@inheritDoc}
	 */
	@Override
	public Mail build() {
		return instance;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Build content(String content) {
		instance.setContent(content);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Content subject(String subject) {
		instance.setSubject(subject);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Subject to(String to) {
		instance.setTo(to);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Build attachments(String[] a) {
		instance.setAttachments(a);
		return this;
	}

}

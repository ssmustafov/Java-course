package com.sirma.itt.javacourse.patterns.singleton;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Represents a logger - events containing messages with date they've occured.
 * 
 * @author smustafov
 */
public class EventLogger {

	private String message;
	private Date eventDate;

	/**
	 * Creates a new logger with given message. Sets the current date when it was created.
	 * 
	 * @param message
	 *            - event's message
	 */
	public EventLogger(String message) {
		this.message = message;
		this.eventDate = new Date();
	}

	/**
	 * Returns the message of the event.
	 * 
	 * @return - message of the event
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * Returns the date of the event.
	 * 
	 * @return - date of the event
	 */
	public Date getDate() {
		return eventDate;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();

		SimpleDateFormat dateFormat = new SimpleDateFormat("[yyyy-MM-dd HH:mm:ss]");
		result.append(dateFormat.format(eventDate));
		result.append(": ");
		result.append(message);

		return result.toString();
	}
}

package com.sirma.itt.javacourse.patterns.singleton;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Represents a Singleton design pattern. Provides working with logs containing messages and date of
 * the log.
 * 
 * @author smustafov
 */
public final class Singleton {

	private static final Logger LOGGER = LogManager.getLogger(Singleton.class);
	private static List<EventLog> logs = new ArrayList<>();
	private static Singleton instance = new Singleton();

	/**
	 * Protects from instantiation.
	 */
	private Singleton() {
		LOGGER.info("Singleton is created");
	}

	/**
	 * Returns the single instance of the Singleton.
	 * 
	 * @return - single instance of the Singleton
	 */
	public static Singleton getInstance() {
		return instance;
	}

	/**
	 * Adds new event to the log. Sets the date to current date.
	 * 
	 * @param message
	 *            - message of the event to be added
	 */
	public static void addToLog(String message) {
		logs.add(new EventLog(message));
	}

	/**
	 * Returns all the logs in the Singleton.
	 * 
	 * @return - all logs in the Singleton
	 */
	public static List<EventLog> getLogs() {
		return logs;
	}

}

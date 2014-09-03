package com.sirma.itt.javacourse.patterns.singleton;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a Singleton design pattern. Provides working with logs containing messages and date of
 * the log.
 * 
 * @author smustafov
 */
public final class Singleton {

	private static List<EventLogger> logs;
	private static Singleton instance;

	/**
	 * Protects from instantiation.
	 */
	private Singleton() {
		System.out.println("Singleton is created");
	}

	/**
	 * Initializes one object from this class also initializes the List of logs.
	 */
	static {
		instance = new Singleton();
		logs = new ArrayList<>();
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
		logs.add(new EventLogger(message));
	}

	/**
	 * Returns all the logs in the Singleton.
	 * 
	 * @return - all logs in the Singleton
	 */
	public static List<EventLogger> getLogs() {
		return logs;
	}

}

package com.sirma.itt.javacourse.patterns.singleton;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

/**
 * Tests {@link com.sirma.itt.javacourse.patterns.singleton.Singleton} class.
 * 
 * @author smustafov
 */
public class SingletonTest {

	/**
	 * Tests {@link com.sirma.itt.javacourse.patterns.singleton.Singleton} if it has only one single
	 * instance.
	 */
	@Test
	public void testIfHasOnlyOneSingleInstance() {
		Singleton instanceOne = Singleton.getInstance();
		Singleton instanceTwo = Singleton.getInstance();

		assertEquals(instanceOne, instanceTwo);
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.patterns.singleton.Singleton} if the log is empty when
	 * the singleton is invoked for the first time.
	 */
	@Test
	public void testEmptyLogs() {
		List<EventLog> logs = Singleton.getLogs();

		int actualSize = logs.size();
		int expectedSize = 0;

		assertEquals(expectedSize, actualSize);
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.patterns.singleton.Singleton} by adding one log message
	 * in the log.
	 */
	@Test
	public void testOneLog() {
		Singleton.addToLog("Testing things");
		List<EventLog> logs = Singleton.getLogs();

		int actualSize = logs.size();
		int expectedSize = 1;

		assertEquals(expectedSize, actualSize);
	}

}

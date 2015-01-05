package com.sirma.itt.javacourse.threads.stopcounter;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests {@link com.sirma.itt.javacourse.threads.stopcounter.StopCounterThread} class.
 * 
 * @author smustafov
 */
public class StopCounterThreadTest {

	private static final int COUNT = 10;
	private Thread thread;
	private StopCounterThread counter;

	/**
	 * 
	 */
	@Before
	public void setUp() {
		counter = new StopCounterThread(COUNT);
		thread = new Thread(counter);
		thread.start();
	}

	/**
	 * 
	 */
	@After
	public void tearDown() {
		thread.interrupt();
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.threads.stopcounter.StopCounterThread} by sleeping for
	 * {@link StopCounterThread#SLEEP_TIME} which means the counter must count only one time.
	 */
	@Test
	public void testWithOneCount() {
		try {
			Thread.sleep(StopCounterThread.SLEEP_TIME);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		long actual = counter.getCounter();
		long expected = 0;

		assertEquals(expected, actual);
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.threads.stopcounter.StopCounterThread} by sleeping for
	 * {@link StopCounterThread#SLEEP_TIME} * {@link StopCounterThreadTest#COUNT}, which means the
	 * counter to the end.
	 */
	@Test
	public void testCountToEnd() {
		try {
			Thread.sleep(StopCounterThread.SLEEP_TIME * COUNT + 45);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		long actual = counter.getCounter();
		long expected = COUNT;

		assertEquals(expected, actual);
	}

}

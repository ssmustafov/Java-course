package com.sirma.itt.javacourse.threads.stopcounter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Counts numbers to given max number. Implements {@code Runnable} interface.
 * 
 * @author smustafov
 */
public class StopCounterThread implements Runnable {
	private static final Logger LOGGER = LogManager.getLogger(StopCounterThread.class);
	private long max;
	private long currentCounter = 0;

	/**
	 * Creates a new stop counter with given.
	 * 
	 * @param max
	 *            - max number to count starting from zero to max-1
	 */
	public StopCounterThread(long max) {
		this.max = max;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void run() {
		try {
			while (true) {
				Thread.sleep(500);

				if (Thread.currentThread().isInterrupted() || currentCounter == max) {
					break;
				}
				currentCounter++;
			}
		} catch (InterruptedException e) {
			LOGGER.info("Counting stopped", e);
		}
	}

	/**
	 * Returns the counter.
	 * 
	 * @return the counter
	 */
	public long getCounter() {
		return currentCounter;
	}

}

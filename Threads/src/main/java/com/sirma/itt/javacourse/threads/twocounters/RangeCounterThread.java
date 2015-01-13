package com.sirma.itt.javacourse.threads.twocounters;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Counts numbers in given range.
 * 
 * @author smustafov
 */
public class RangeCounterThread extends Thread {

	private static final Logger LOGGER = LogManager.getLogger(RangeCounterThread.class);
	private static volatile boolean isStopped = false;
	private long start;
	private long end;

	/**
	 * Creates a new range counter with given range.
	 * 
	 * @param start
	 *            - starting value of the range
	 * @param end
	 *            - ending value of the range
	 */
	public RangeCounterThread(long start, long end) {
		this.start = start;
		this.end = end;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void run() {
		try {
			long counter = start;
			while (counter <= end) {
				if (isStopped) {
					break;
				}
				sleep(500);

				LOGGER.info(Thread.currentThread().getName() + " #" + counter);
				counter++;

				synchronized (this) {
					wait(50);
				}
			}
			isStopped = true;
		} catch (InterruptedException e) {
			LOGGER.error(e.getMessage(), e);
		}
	}
}

package com.sirma.itt.javacourse.threads.sleepingcounters;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Counts numbers in given range. Uses {@link Thread#sleep(long)}.
 * 
 * @author smustafov
 */
public class SleepingCounterThread extends Thread {

	private static final Logger LOGGER = LogManager.getLogger(SleepingCounterThread.class);
	private static final int SLEEP_TIME = 500;
	private long start;
	private long end;

	/**
	 * Creates a new SleepingCounterThread with given range.
	 * 
	 * @param start
	 *            - starting value of the range
	 * @param end
	 *            - ending value of the range
	 */
	public SleepingCounterThread(long start, long end) {
		this.start = start;
		this.end = end;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void run() {
		try {
			for (long i = start; i <= end; i++) {
				System.out.print(Thread.currentThread().getName());
				System.out.print(" #");
				System.out.println(i);

				sleep(SLEEP_TIME);
			}
		} catch (InterruptedException e) {
			LOGGER.error("Sleeping interupted", e);
		}
	}
}
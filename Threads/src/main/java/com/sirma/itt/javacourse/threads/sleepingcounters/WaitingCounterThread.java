package com.sirma.itt.javacourse.threads.sleepingcounters;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author smustafov
 */
public class WaitingCounterThread extends Thread {

	private static final Logger LOGGER = LogManager.getLogger(WaitingCounterThread.class);
	private static final int WAIT_TIME = 500;
	private long start;
	private long end;

	/**
	 * Creates a new WaitingCounterThread with given range.
	 * 
	 * @param start
	 *            - starting value of the range
	 * @param end
	 *            - ending value of the range
	 */
	public WaitingCounterThread(long start, long end) {
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

				synchronized (this) {
					wait(WAIT_TIME);
				}
			}
		} catch (InterruptedException e) {
			LOGGER.error("Waiting is interrupted", e);
		}
	}
}

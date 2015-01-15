package com.sirma.itt.javacourse.threads.synchronizedthreads;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Counts numbers in given range so that when the first thread counts it waits for the second thread
 * to count and so on.
 * 
 * @author smustafov
 */
public class SynchronizedThread extends Thread {

	private static final Logger LOGGER = LogManager.getLogger(SynchronizedThread.class);
	private static volatile boolean isStopped = false;
	private static Object lock = new Object();
	private long start;
	private long end;

	/**
	 * Creates a new SynchronizedThread with given range.
	 * 
	 * @param start
	 *            - starting value of the range
	 * @param end
	 *            - ending value of the range
	 */
	public SynchronizedThread(long start, long end) {
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
			while (counter <= end && !isStopped) {
				sleep(500);

				LOGGER.info(Thread.currentThread().getName() + " #" + counter);
				counter++;

				synchronized (lock) {
					lock.notifyAll();
					lock.wait();
				}
			}
			isStopped = true;
			synchronized (lock) {
				lock.notifyAll();
			}
		} catch (InterruptedException e) {
			LOGGER.error(e.getMessage(), e);
		}
	}

}
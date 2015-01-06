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
	 * Notifes this thread.
	 */
	public synchronized void notifyThread() {
		notify();
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

				System.out.print(Thread.currentThread().getName());
				System.out.print(" #");
				System.out.println(counter);
				counter++;

				synchronized (this) {
					wait();
				}
			}
			isStopped = true;
		} catch (InterruptedException e) {
			LOGGER.error(e.getMessage(), e);
		}
	}

}
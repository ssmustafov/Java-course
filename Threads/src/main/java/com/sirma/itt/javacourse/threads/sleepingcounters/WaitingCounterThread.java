package com.sirma.itt.javacourse.threads.sleepingcounters;

/**
 * @author smustafov
 */
public class WaitingCounterThread extends Thread {
	private static final int WAIT_TIME = 2000;
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
		for (long i = start; i <= end; i++) {
			System.out.print(Thread.currentThread().getName());
			System.out.print(" #");
			System.out.println(i);
			try {
				synchronized (this) {
					wait(WAIT_TIME);
				}
			} catch (InterruptedException e) {
				System.err.println(e.getMessage());
			}
		}
	}
}

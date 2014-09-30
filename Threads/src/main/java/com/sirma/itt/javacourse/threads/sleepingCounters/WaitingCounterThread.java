package com.sirma.itt.javacourse.threads.sleepingCounters;

/**
 * @author smustafov
 */
public class WaitingCounterThread extends Thread {

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
					wait(2000);
				}
			} catch (InterruptedException e) {
				System.err.println(e.getMessage());
			}
		}
	}

}

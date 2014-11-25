package com.sirma.itt.javacourse.threads.sleepingCounters;

/**
 * @author smustafov
 */
public class SleepingCounterThread extends Thread {
	private static final int SLEEP_TIME = 2000;
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
		for (long i = start; i <= end; i++) {
			System.out.print(Thread.currentThread().getName());
			System.out.print(" #");
			System.out.println(i);
			try {
				sleep(SLEEP_TIME);
			} catch (InterruptedException e) {
				System.err.println(e.getMessage());
			}
		}
	}
}

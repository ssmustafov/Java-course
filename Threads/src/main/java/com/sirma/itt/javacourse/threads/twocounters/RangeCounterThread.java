package com.sirma.itt.javacourse.threads.twocounters;

/**
 * Counts numbers in given range.
 * 
 * @author smustafov
 */
public class RangeCounterThread extends Thread {

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
		for (long i = start; i <= end; i++) {
			System.out.print(Thread.currentThread().getName());
			System.out.print(" #");
			System.out.println(i);
		}
	}
}

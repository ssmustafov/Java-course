package com.sirma.itt.javacourse.threads.stopCounter;

/**
 * Counts numbers to given max number. Implements {@code Runnable} interface.
 * 
 * @author smustafov
 */
public class StopCounterThread implements Runnable {

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
		for (int i = 0; i < max; i++) {
			if (Thread.currentThread().isInterrupted()) {
				break;
			}
			currentCounter = i;
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

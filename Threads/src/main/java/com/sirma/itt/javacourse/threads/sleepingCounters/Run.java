package com.sirma.itt.javacourse.threads.sleepingCounters;

/**
 * @author smustafov
 */
public final class Run {

	/**
	 * Protects from instantiation.
	 */
	private Run() {

	}

	/**
	 * Main method.
	 * 
	 * @param args
	 *            - arguments
	 */
	public static void main(String[] args) {
		SleepingCounterThread s = new SleepingCounterThread(0, 10);
		s.start();

		WaitingCounterThread w = new WaitingCounterThread(0, 10);
		w.start();
	}
}

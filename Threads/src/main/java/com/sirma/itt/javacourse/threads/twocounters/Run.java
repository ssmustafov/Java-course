package com.sirma.itt.javacourse.threads.twocounters;

/**
 * Starts a new thread counters.
 * 
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
		RangeCounterThread r = new RangeCounterThread(0, 5);
		RangeCounterThread a = new RangeCounterThread(0, 10);
		r.start();
		a.start();
	}

}

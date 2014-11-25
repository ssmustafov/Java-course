package com.sirma.itt.javacourse.threads.twoCounters;

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
		RangeCounterThread r = new RangeCounterThread(0, 40);
		RangeCounterThread a = new RangeCounterThread(10, 100);
		r.start();
		a.start();
	}

}

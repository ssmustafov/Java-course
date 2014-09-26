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
		RangeCounter r = new RangeCounter(10, 70);
		RangeCounter a = new RangeCounter(10, 100);
		r.start();
		a.start();
	}

}

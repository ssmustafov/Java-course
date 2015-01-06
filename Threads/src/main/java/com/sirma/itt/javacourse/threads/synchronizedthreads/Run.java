package com.sirma.itt.javacourse.threads.synchronizedthreads;

/**
 * Shows how the {@link SynchronizedThread} class can be used.
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
		SynchronizedThread a = new SynchronizedThread(1, 5);
		SynchronizedThread b = new SynchronizedThread(1, 5);
		a.start();
		b.start();
	}

}

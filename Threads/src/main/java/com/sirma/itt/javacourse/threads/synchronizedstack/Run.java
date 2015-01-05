package com.sirma.itt.javacourse.threads.synchronizedstack;

/**
 * Shows how the SynchronizedList class can be used.
 * 
 * @author Sinan
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
		SynchronizedList list = new SynchronizedList(3);
		AddThread a = new AddThread(list);
		RemoveThread r = new RemoveThread(list);
		a.start();
		r.start();
	}
}

package com.sirma.itt.javacourse.threads.synchronizedStack;

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
		SynchronizedList a = new SynchronizedList(3);
		a.add(32);
		a.add(11);
		a.add(4);
		a.add(202);
		a.remove();
	}
}

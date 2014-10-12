package com.sirma.itt.javacourse.threads.hashtable;

/**
 * Shows how the TimeoutHashtable can be used.
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
		TimeoutHashtable<Integer, Integer> t = new TimeoutHashtable<>();
		Thread r = new Thread(t);
		r.start();

		t.put(1, 1);
		t.put(2, 10);
		t.put(3, 11);
		t.get(2);
		t.get(3);
		t.get(2);
	}
}

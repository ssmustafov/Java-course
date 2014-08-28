package com.sirma.itt.javacourse.collections.lru;

/**
 * Shows how the LeastRecentlyUsed class can be used.
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
		LeastRecentlyUsed<Integer> lru = new LeastRecentlyUsed<>(3);
		lru.add(7, 0, 1, 2, 0, 3, 0, 4);
		System.out.println(lru);
	}

}

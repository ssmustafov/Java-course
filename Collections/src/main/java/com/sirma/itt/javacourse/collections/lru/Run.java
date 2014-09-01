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
		LeastRecentlyUsed<String, Integer> lru = new LeastRecentlyUsed<>(4);
		// 1, 2, 3, 4, 1, 2, 5, 1, 2, 3, 4, 5

		lru.put("one", 1);
		lru.put("two", 2);
		lru.put("three", 3);
		lru.put("four", 4);
		lru.put("one", 1);
		lru.put("two", 2);
		lru.put("five", 5);
		lru.put("one", 1);
		lru.put("two", 2);
		lru.put("three", 3);
		lru.put("four", 4);
		lru.put("five", 5);
		System.out.println(lru);
	}
}

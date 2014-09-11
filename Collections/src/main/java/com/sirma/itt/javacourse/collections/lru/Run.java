package com.sirma.itt.javacourse.collections.lru;

import java.util.Map.Entry;
import java.util.Set;

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

		lru.add("one", 1);
		lru.add("two", 2);
		lru.add("three", 3);
		lru.add("four", 4);
		lru.add("one", 1);
		lru.add("two", 2);
		lru.add("five", 5);
		lru.add("one", 1);
		lru.add("two", 2);
		lru.add("three", 3);
		lru.add("four", 4);
		lru.add("five", 5);

		Set<Entry<String, Integer>> cache = lru.getCache();
		for (Entry<String, Integer> entry : cache) {
			System.out.print(entry.getKey() + " -> ");
			System.out.println(entry.getValue());
		}
	}
}

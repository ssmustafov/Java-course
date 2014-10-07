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
		LeastRecentlyUsed<Integer, Integer> lru = new LeastRecentlyUsed<>(2);
		lru.add(1, 1);
		lru.add(5, 101);

		lru.use(1);
		lru.use(1);
		lru.use(1);
		lru.use(5);
		lru.add(8, 1000);

		Set<Entry<Integer, Integer>> cache = lru.getCache();
		for (Entry<Integer, Integer> entry : cache) {
			System.out.print(entry.getKey() + " -> ");
			System.out.println(entry.getValue());
		}
	}
}

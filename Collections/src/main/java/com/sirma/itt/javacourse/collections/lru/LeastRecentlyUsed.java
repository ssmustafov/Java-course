package com.sirma.itt.javacourse.collections.lru;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Implementation of the Least Recently Used (LRU) cache algorithm.
 * 
 * @param <K>
 *            - the type of the cache
 * @param <V>
 *            - the value of the cache
 * @author smustafov
 */
public class LeastRecentlyUsed<K, V> extends LinkedHashMap<K, V> {

	/**
	 * Comment for serialVersionUID.
	 */
	private static final long serialVersionUID = -9059879807053437600L;
	private int capacity;

	/**
	 * Creates a new Least Recently Used (LRU) cache.
	 * 
	 * @param capacity
	 *            - the size of the cache
	 */
	public LeastRecentlyUsed(int capacity) {
		super(capacity, 0.75f, true);

		if (capacity <= 0) {
			throw new IllegalArgumentException("The given cache size cannot be equal or under zero");
		}

		this.capacity = capacity;
	}

	@Override
	protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
		return size() > capacity;
	}

}

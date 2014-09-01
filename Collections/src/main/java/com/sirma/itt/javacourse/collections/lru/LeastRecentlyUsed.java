package com.sirma.itt.javacourse.collections.lru;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Implementation of the Least Recently Used (LRU) cache algorithm.
 * 
 * @param <K>
 *            - the type of the cache
 * @param <V>
 *            - the value of the keys
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

	/**
	 * Overrides the method in <code>LinkedHashMap</code> for restricting the number of elements
	 * that the map can contain.
	 * 
	 * @param eldest
	 *            - the least recently accessed entry. This is the entry that will be removed it
	 *            this method returns true. If the map was empty prior to the put or putAll
	 *            invocation resulting in this invocation, this will be the entry that was just
	 *            inserted; in other words, if the map contains a single entry, the eldest entry is
	 *            also the newest.
	 * @return - true if the number of elements in the <code>LinkedHashMap</code> is greater than
	 *         the cache <code>capacity</code>; otherwise returns false
	 */
	@Override
	protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
		return size() > capacity;
	}

}

package com.sirma.itt.javacourse.collections.lru;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Implementation of the Least Recently Used (LRU) cache algorithm.
 * 
 * @param <T>
 *            - the type of the cache
 * @author smustafov
 */
public class LeastRecentlyUsed<T> {

	private Map<T, Integer> cache;
	private int counter;
	private int size;

	/**
	 * Creates a new Least Recently Used (LRU) cache.
	 * 
	 * @param size
	 *            - the size of the cache
	 */
	public LeastRecentlyUsed(int size) {
		if (size <= 0) {
			throw new IllegalArgumentException("The given cache size cannot be equal or under zero");
		}

		this.size = size;
		cache = new HashMap<>(size);
		counter = 1;
	}

	/**
	 * Returns the key of given value in the <code>cache</code> map.
	 * 
	 * @param minValue
	 *            - the key's value
	 * @return given value's key
	 */
	private T getKeyByValue(int minValue) {
		for (Entry<T, Integer> entry : cache.entrySet()) {
			if (entry.getValue() == minValue) {
				return entry.getKey();
			}
		}
		return null;
	}

	/**
	 * Adds new item to the cache.
	 * 
	 * @param item
	 *            - item to be added
	 */
	public void add(T item) {
		if (cache.containsKey(item)) {
			cache.put(item, counter);
		} else if (cache.size() < size) {
			cache.put(item, counter);
		} else {
			int minCounter = Collections.min(cache.values());
			T key = getKeyByValue(minCounter);
			if (key != null) {
				cache.remove(key);
				cache.put(item, counter);
			}
		}
		counter++;
	}

	/**
	 * Adds new items to the cache.
	 * 
	 * @param items
	 *            - items to be added
	 */
	@SuppressWarnings("unchecked")
	public void add(T... items) {
		for (int i = 0; i < items.length; i++) {
			add(items[i]);
		}
	}

	/**
	 * Returns collection of what is inside the cache.
	 * 
	 * @return - collection of cache's content
	 */
	public Collection<T> getCache() {
		Collection<T> collection = cache.keySet();

		return collection;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return cache.toString();
	}
}

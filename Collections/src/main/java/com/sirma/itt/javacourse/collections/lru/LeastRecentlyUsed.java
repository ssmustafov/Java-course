package com.sirma.itt.javacourse.collections.lru;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;

/**
 * Implementation of the Least Recently Used (LRU) cache algorithm. The implementation uses
 * {@code Map} and {@code Queue}. The {@code Queue} is for tracking the elements' usage and the
 * {@code Map} contains the cache itself.
 * 
 * @param <K>
 *            - type of the key in the cache
 * @param <V>
 *            - type of the value in a key
 * @author smustafov
 */
public class LeastRecentlyUsed<K, V> {

	private Map<K, V> cache = new HashMap<>();
	private Queue<K> queue = new LinkedList<>();
	private int capacity;

	/**
	 * Creates a new Least Recently Used (LRU) cache.
	 * 
	 * @param capacity
	 *            - the size of the cache
	 */
	public LeastRecentlyUsed(int capacity) {
		if (capacity <= 0) {
			throw new IllegalArgumentException("Cache's size cannot be equal or under zero");
		}

		this.capacity = capacity;
	}

	/**
	 * Adds key value pair to the cache. If there is key with the same value in the cache it removes
	 * it from the queue and adds it to the head; if there is no such element with that key and its
	 * reached max capacity of the cache it removes the tail of the queue (least recently used
	 * element) and adds the new element to the head of the queue; and if there is space (max
	 * capacity not reached) in the cache and key with same value doesn't exists just adds the
	 * element to the cache and to the head of the queue.
	 * 
	 * @param key
	 *            - key of the element to be added to the cache
	 * @param value
	 *            - value of the element to be added to the cache
	 */
	public void add(K key, V value) {
		if (queue.contains(key)) {
			// First remove it from the queue then add it again, this is a way to change the usage
			// of an element - simulating least and most used
			queue.remove(key);
			queue.add(key);
			cache.put(key, value);
		} else if (queue.size() >= capacity) {
			K keyToRemove = queue.remove();
			cache.remove(keyToRemove);
			queue.add(key);
			cache.put(key, value);
		} else {
			queue.add(key);
			cache.put(key, value);
		}
	}

	/**
	 * Returns the value of given key without removing it from the cache.
	 * 
	 * @param key
	 *            - key of the value to be used
	 * @return value of the given key
	 */
	public V use(K key) {
		if (!containsKey(key)) {
			throw new IllegalArgumentException("The cache does not contain the given key: " + key);
		}

		queue.remove(key);
		queue.add(key);
		return cache.get(key);
	}

	/**
	 * Returns the cache as {@code Set<Entry<K, V>>}.
	 * 
	 * @return - set of key value pair entries in the cache
	 */
	public Set<Entry<K, V>> getCache() {
		return cache.entrySet();
	}

	/**
	 * Checks if given key exists in the cache.
	 * 
	 * @param key
	 *            - key to be checked if it exists in the cache
	 * @return - true if the given key exists in the cache; otherwise false
	 */
	public boolean containsKey(K key) {
		return cache.containsKey(key);
	}

	/**
	 * Checks if given value exists in the cache.
	 * 
	 * @param value
	 *            - value to be checked if it exists in the cache
	 * @return - true if the given value exists in the cache; otherwise false
	 */
	public boolean containsValue(V value) {
		return cache.containsValue(value);
	}

	/**
	 * Returns the current size of the cache. If its reached max size always will return the max
	 * size.
	 * 
	 * @return - current size of the cache.
	 */
	public int getSize() {
		return cache.size();
	}

}

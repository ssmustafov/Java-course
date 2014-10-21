package com.sirma.itt.javacourse.threads.hashtable;

import java.util.Enumeration;
import java.util.Hashtable;

/**
 * Stores elements for a period of time in a {@code Hashtable}. Implements {@code KeyValuePair}
 * interface.
 * 
 * @param <K>
 *            - type of the keys
 * @param <V>
 *            - type of the value
 * @author Sinan
 */
public class TimeoutHashtable<K, V> implements Runnable {
	private Hashtable<K, V> hashtable = new Hashtable<>();
	private Hashtable<K, Integer> timeout = new Hashtable<>();
	private int maxTime = 4000;

	/**
	 * Creates a new timeout hashtable with given max time for storing elements.
	 * 
	 * @param maxTime
	 *            - how many times an element can be stored
	 */
	public TimeoutHashtable(int maxTime) {
		this.maxTime = maxTime;
	}

	/**
	 * Creates a new timeout hashtable with default max time for storing elements - <code>1</code>
	 * second.
	 */
	public TimeoutHashtable() {

	}

	/**
	 * @param key
	 * @param value
	 */
	public void put(K key, V value) {
		hashtable.put(key, value);
		timeout.put(key, 0);

	}

	/**
	 * @param key
	 * @return
	 */
	public V get(K key) {
		timeout.put(key, 0);
		return hashtable.get(key);
	}

	/**
	 * @param key
	 */
	public void remove(K key) {
		hashtable.remove(key);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return hashtable.toString();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			Enumeration<K> keys = timeout.keys();
			while (keys.hasMoreElements()) {
				K key = keys.nextElement();
				if (timeout.get(key) > maxTime) {
					hashtable.remove(key);
					System.out.println("REMOVED: " + key);
				} else {
					timeout.put(key, timeout.get(key) + 1200);
				}
			}
		}
	}
}

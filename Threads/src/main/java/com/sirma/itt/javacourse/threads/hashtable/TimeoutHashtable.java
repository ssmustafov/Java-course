package com.sirma.itt.javacourse.threads.hashtable;

import java.util.Hashtable;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Represents a {@code Hashtable} but with given time to exist for every element in the table.
 * 
 * @param <K>
 *            - the type of the keys in the hashtable
 * @param <V>
 *            - the type of the values in the hashtable
 * @author smustafov
 */
public class TimeoutHashtable<K, V> {

	private static final Logger LOGGER = LogManager.getLogger(TimeoutHashtable.class);
	private static final int THOUSAND_MILISECONDS = 1000;
	private static final int MINIMUM_SECONDS_FOR_EACH_ELEMENT = 1;
	private Hashtable<K, V> hashtable;
	private Hashtable<K, Timer> timeout;
	private long miliseconds;

	/**
	 * Creates a new timeout hashtable with given seconds for each element in the table.
	 * 
	 * @param seconds
	 *            - the time for each element in the table to exist
	 */
	public TimeoutHashtable(int seconds) {
		setMiliseconds(seconds);
		this.hashtable = new Hashtable<>();
		this.timeout = new Hashtable<>();
	}

	/**
	 * Puts a new element in the table with given key and value.
	 * 
	 * @param key
	 *            - key of the element
	 * @param value
	 *            - value of the key
	 */
	public synchronized void put(K key, V value) {
		hashtable.put(key, value);
		timeout.put(key, new Timer(key));
	}

	/**
	 * Returns the value associated with given key in the table. Does not remove the element. It
	 * restarts the time of existence for the given key.
	 * 
	 * @param key
	 *            - the key which associated value will be returned
	 * @return associated value of the given key
	 */
	public synchronized V get(K key) {
		Timer t = timeout.get(key);
		t.setUsed();
		t.notifyTimer();

		return hashtable.get(key);
	}

	/**
	 * Removes the element with given key and returns its associated value.
	 * 
	 * @param key
	 *            - the key of the element to be removed
	 * @return associated value of the removed key
	 */
	public synchronized V remove(K key) {
		timeout.remove(key);
		V removed = hashtable.remove(key);
		return removed;
	}

	/**
	 * Checks if the specified key is a key in this timeout hash table.
	 * 
	 * @param key
	 *            - the key to be checked if it contains in the hash table
	 * @return true if the key contains in the table, otherwise false
	 */
	public boolean contains(K key) {
		if (hashtable.containsKey(key)) {
			return true;
		}
		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public synchronized String toString() {
		return hashtable.toString();
	}

	/**
	 * Sets the seconds that every element will live in the hash table.
	 * 
	 * @param seconds
	 *            - the seconds of every element that will live in the hash table
	 */
	private void setMiliseconds(int seconds) {
		if (seconds < MINIMUM_SECONDS_FOR_EACH_ELEMENT) {
			throw new IllegalArgumentException("The minimal seconds for element to live is: "
					+ MINIMUM_SECONDS_FOR_EACH_ELEMENT + ". It is given: " + seconds);
		}

		this.miliseconds = seconds * THOUSAND_MILISECONDS;
	}

	/**
	 * Represents a timer.
	 * 
	 * @author smustafov
	 */
	private class Timer implements Runnable {
		private K key;
		private boolean isUsed;

		/**
		 * Creates a new timer with given seconds.
		 * 
		 * @param key
		 *            - key on which timer will count
		 */
		public Timer(K key) {
			this.key = key;
			this.isUsed = false;
			new Thread(this).start();
		}

		/**
		 * Notifies the thread that the key is used.
		 */
		public synchronized void notifyTimer() {
			notify();
		}

		/**
		 * Sets that the key of the timer is used hence it restarts the timer for that key.
		 */
		public synchronized void setUsed() {
			isUsed = true;
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public synchronized void run() {
			while (true) {
				try {
					wait(miliseconds);

					if (timeout.containsKey(key) && !isUsed) {
						hashtable.remove(key);
						timeout.remove(key);
						LOGGER.info("REMOVED: key -> " + key);
					} else {
						isUsed = false;
					}
				} catch (InterruptedException e) {
					LOGGER.error(e.getMessage(), e);
				}
			}
		}
	}
}

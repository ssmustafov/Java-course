package com.sirma.itt.javacourse.threads.hashtable;

import java.util.Hashtable;

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
	private Hashtable<K, V> hashtable;
	private Hashtable<K, Timer> timeout;
	private long miliseconds;

	/**
	 * Creates a new timeout hashtable with given seconds for each element in the table.
	 * 
	 * @param seconds
	 *            - the time for each element in the table to exist
	 */
	public TimeoutHashtable(long seconds) {
		this.hashtable = new Hashtable<>();
		this.timeout = new Hashtable<>();
		this.miliseconds = seconds * 1000;
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
	 * {@inheritDoc}
	 */
	@Override
	public synchronized String toString() {
		return hashtable.toString();
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
						System.out.println("REMOVED: key -> " + key);
					} else {
						isUsed = false;
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}

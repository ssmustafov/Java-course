package com.sirma.itt.javacourse.threads.hashtable;

import java.util.Hashtable;

/**
 * @param <K>
 * @param <V>
 * @author smustafov
 */
public class TimeoutHashtable<K, V> {
	private Hashtable<K, V> hashtable = new Hashtable<>();
	private Hashtable<K, Timer> time = new Hashtable<>();
	private int seconds;

	/**
	 * Creates a new timeout hashtable with given seconds for each element in the table.
	 * 
	 * @param seconds
	 *            - the time for each element
	 */
	public TimeoutHashtable(int seconds) {
		this.seconds = seconds;
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
		time.put(key, new Timer(key, seconds));
	}

	/**
	 * Returns the value associated with given key in the table. Does not remove the element.
	 * 
	 * @param key
	 *            - the key which associated value will be returned
	 * @return associated value of the given key
	 */
	public synchronized V get(K key) {
		Timer timer = time.get(key);
		timer.setUsed();
		timer.restart();

		return hashtable.get(key);
	}

	/**
	 * Removes the element with given key and returns his associated value.
	 * 
	 * @param key
	 *            - the key of the element to be removed
	 * @return associated value of the removed key
	 */
	public synchronized V remove(K key) {
		V value = hashtable.remove(key);
		time.remove(key);
		return value;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return hashtable.toString();
	}

	/**
	 * Represents a timer.
	 * 
	 * @author smustafov
	 */
	public class Timer implements Runnable {
		private K key;
		private boolean isUsed = false;

		/**
		 * Creates a new timer with given seconds.
		 * 
		 * @param key
		 *            - key on which timer will count
		 * @param seconds
		 *            - the time in seconds for timer to count
		 */
		public Timer(K key, int seconds) {
			this.key = key;
			new Thread(this).start();
		}

		/**
		 * Sets that the key of the timer is used.
		 */
		public synchronized void setUsed() {
			isUsed = true;
		}

		/**
		 * Restarts the thread. (Notifies).
		 */
		public synchronized void restart() {
			notify();
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public synchronized void run() {
			while (!isUsed) {
				try {
					wait(seconds * 1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				if (isUsed) {
					break;
				}
			}

			if (time.containsKey(key)) {
				hashtable.remove(key);
				time.remove(key);

				System.out.println("REMOVED: key->" + key);
			}
		}
	}
}

package com.sirma.itt.javacourse.threads.producerconsumer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Represents a storehouse. Thread safe.
 * 
 * @author Sinan
 */
public class StoreHouse {
	private Queue<Object> queue = new LinkedList<>();
	private int size;

	/**
	 * Creates a new storehouse with given size.
	 * 
	 * @param size
	 *            - size of the storehouse
	 */
	public StoreHouse(int size) {
		this.size = size;
	}

	/**
	 * Puts new production.
	 * 
	 * @param obj
	 *            - production to be added storehouse
	 * @throws InterruptedException
	 *             - thrown when waiting is interrupted
	 */
	public synchronized void put(Object obj) throws InterruptedException {
		while (queue.size() == size) {
			wait();
		}

		queue.add(obj);
		notify();
	}

	/**
	 * Returns first added production.
	 * 
	 * @return - the first added production to the storehouse
	 * @throws InterruptedException
	 *             - thrown when sync fails
	 */
	public synchronized Object get() throws InterruptedException {
		while (queue.size() == 0) {
			wait();
		}

		Object obj = queue.poll();
		notify();
		return obj;
	}
}

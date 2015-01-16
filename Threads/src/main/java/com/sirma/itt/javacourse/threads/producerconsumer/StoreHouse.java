package com.sirma.itt.javacourse.threads.producerconsumer;

import java.util.LinkedList;
import java.util.Queue;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Represents a storehouse for the Producer-Consumer task. Thread safe.
 * 
 * @author Sinan
 */
public class StoreHouse {

	private static final Logger LOGGER = LogManager.getLogger(StoreHouse.class);
	private Queue<Object> queue;
	private int size;

	/**
	 * Creates a new storehouse with given size.
	 * 
	 * @param size
	 *            - size of the storehouse
	 */
	public StoreHouse(int size) {
		if (size <= 0) {
			throw new IllegalArgumentException(
					"The store house's size cannot be under or equal to zero");
		}

		this.size = size;
		this.queue = new LinkedList<>();
	}

	/**
	 * Puts new production.
	 * 
	 * @param obj
	 *            - production to be added storehouse
	 */
	public synchronized void put(Object obj) {
		while (queue.size() == size) {
			try {
				wait();
			} catch (InterruptedException e) {
				LOGGER.error(e.getMessage(), e);
			}
		}

		queue.add(obj);
		notify();
	}

	/**
	 * Returns first added production.
	 * 
	 * @return - the first added production to the storehouse
	 */
	public synchronized Object get() {
		while (queue.size() == 0) {
			try {
				wait();
			} catch (InterruptedException e) {
				LOGGER.error(e.getMessage(), e);
			}
		}

		Object obj = queue.poll();
		notify();
		return obj;
	}

	/**
	 * Returns the left number of stocks in the store house.
	 * 
	 * @return - the left number of stocks in the store house.
	 */
	public synchronized int getLeftSize() {
		return queue.size();
	}
}

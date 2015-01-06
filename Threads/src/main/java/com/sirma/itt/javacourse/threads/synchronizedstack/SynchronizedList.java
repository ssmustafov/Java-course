package com.sirma.itt.javacourse.threads.synchronizedstack;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Holds list of elements of type <code>Object</code> with fixed size. Thread safe.
 * 
 * @author smustafov
 */
public class SynchronizedList {

	private static final Logger LOGGER = LogManager.getLogger(SynchronizedList.class);
	private Object[] array;
	private int index;

	/**
	 * Creates a new list with given size.
	 * 
	 * @param size
	 *            - the size of the list to be set
	 */
	public SynchronizedList(int size) {
		if (size <= 0) {
			throw new IllegalArgumentException("The size of the list cannot be under zero");
		}

		array = new Object[size];
		index = 0;
	}

	/**
	 * Adds new element to the list. When the list is full it waits until an element is removed and
	 * then the new one is added.
	 * 
	 * @param obj
	 *            - the element to be added
	 */
	public synchronized void add(Object obj) {
		if (array.length == index) {
			System.out.println("ADD: List full... waiting for element to be removed");
			try {
				wait();
			} catch (InterruptedException e) {
				LOGGER.error("Waiting interrupted", e);
			}
		}

		array[index] = obj;
		index++;
		notifyAll();
	}

	/**
	 * Removes the last element of the list. When its empty it waits until new element is added.
	 */
	public synchronized void remove() {
		if (index == 0) {
			System.out.println("REMOVE: List empty... waiting for element to be added");
			try {
				wait();
			} catch (InterruptedException e) {
				LOGGER.error("Waiting interrupted", e);
			}
		}

		index--;
		array[index] = null;
		notifyAll();
	}

	/**
	 * Returns the actual size of the list.
	 * 
	 * @return - the size of the list
	 */
	public int getListSize() {
		return index;
	}

	/**
	 * Returns the capacity of the list.
	 * 
	 * @return - the capacity of the list
	 */
	public int getListCapacity() {
		return array.length;
	}

	/**
	 * Returns element at given index.
	 * 
	 * @param index
	 *            - the index of the element
	 * @return the object element at given index
	 */
	public Object get(int index) {
		if (index >= array.length) {
			throw new ArrayIndexOutOfBoundsException("Index out of the range: Index: " + index
					+ ", Size: " + array.length);
		}

		return array[index];
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		StringBuffer result = new StringBuffer();
		result.append("[");

		for (int i = 0; i < index - 1; i++) {
			result.append(array[i]);
			result.append(", ");
		}

		if (index > 0) {
			result.append(array[index - 1]);
		}

		result.append("]");

		return result.toString();
	}
}

package com.sirma.itt.javacourse.threads.synchronizedstack;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.sirma.itt.javacourse.exceptions.list.List;

/**
 * Holds list of elements of type <code>Object</code> with fixed size. Thread safe.
 * 
 * @author smustafov
 */
public class SynchronizedStack {

	private static final Logger LOGGER = LogManager.getLogger(SynchronizedStack.class);
	private List list;

	/**
	 * Creates a new list with given size.
	 * 
	 * @param size
	 *            - the size of the list to be set
	 */
	public SynchronizedStack(int size) {
		if (size <= 0) {
			throw new IllegalArgumentException("The size of the list cannot be under zero");
		}

		list = new List(size);
	}

	/**
	 * Adds given element to the list by starting a new {@link AddThread}.
	 * 
	 * @param obj
	 *            - the element to be added from a thread
	 */
	public void add(Object obj) {
		new AddThread(this, obj);
	}

	/**
	 * Removes the last element of the list by starting a new {@link RemoveThread}.
	 */
	public void remove() {
		new RemoveThread(this);
	}

	/**
	 * Adds new element to the list. When the list is full it waits until an element is removed and
	 * then the new one is added.
	 * 
	 * @param obj
	 *            - the element to be added
	 */
	public synchronized void addItem(Object obj) {
		while (list.getListSize() == list.getListCapacity()) {
			try {
				wait();
			} catch (InterruptedException e) {
				LOGGER.error(e.getMessage(), e);
			}
		}

		list.add(obj);
		notify();
	}

	/**
	 * Removes the last element of the list. When its empty it waits until new element is added then
	 * removes it.
	 */
	public synchronized void removeItem() {
		while (list.getListSize() == 0) {
			try {
				wait();
			} catch (InterruptedException e) {
				LOGGER.error(e.getMessage(), e);
			}
		}

		list.remove();
		notify();
	}

	/**
	 * Returns element at given index.
	 * 
	 * @param index
	 *            - the index of the element
	 * @return the object element at given index
	 */
	public synchronized Object get(int index) {
		return list.get(index);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return list.getAllElements();
	}

}

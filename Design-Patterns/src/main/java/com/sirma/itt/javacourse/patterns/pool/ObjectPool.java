package com.sirma.itt.javacourse.patterns.pool;

import java.util.Stack;

/**
 * Represents Object pool design pattern. Holds objects from given type <code>T</code> by maximum N
 * number of times.
 * 
 * @param <T>
 *            - type of the objects in the pool
 * @author smustafov
 */
public class ObjectPool<T> implements Pool<T> {

	private Stack<T> instances;
	private int maxPoolSize;

	/**
	 * Creates a new pool with given maximum size of objects to store in it.
	 * 
	 * @param maxPoolSize
	 *            - maximum size of the pool
	 */
	public ObjectPool(int maxPoolSize) {
		instances = new Stack<>();
		setPoolSize(maxPoolSize);
	}

	/**
	 * Sets the maximum size of the pool.
	 * 
	 * @param maxPoolSize
	 *            - maximum size of the pool to be set
	 */
	private void setPoolSize(int maxPoolSize) {
		if (maxPoolSize <= 0) {
			throw new IllegalArgumentException("The pool's size cannot be under or equal to zero");
		}

		this.maxPoolSize = maxPoolSize;
	}

	/**
	 * Returns number of objects that are available in the pool.
	 * 
	 * @return - number of objects that are available in the pool
	 */
	public int getNumberOfAvailableObjects() {
		return instances.size();
	}

	/**
	 * {@inheritDoc} If there is no objects in the pool it throws {@code IllegalAccessError}
	 * exception.
	 */
	@Override
	public T acquire() {
		if (instances.size() <= 0) {
			throw new IllegalAccessError("Not available resources in the pool");
		}

		return instances.pop();
	}

	/**
	 * {@inheritDoc} If the maximum number of allowed objects in the pool is reached it throws
	 * {@code IllegalAccessError} exception.
	 */
	@Override
	public void release(T object) {
		if (instances.size() >= maxPoolSize) {
			throw new IllegalAccessError("The pool reached maximum size. Max: " + maxPoolSize);
		}

		instances.push(object);
	}

}

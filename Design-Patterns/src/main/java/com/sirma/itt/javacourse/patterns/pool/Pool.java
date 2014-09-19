package com.sirma.itt.javacourse.patterns.pool;

/**
 * Defines interface for Object pool design pattern.
 * 
 * @param <T>
 *            - the type of the pool
 * @author smustafov
 */
public interface Pool<T> {

	/**
	 * Acquires an instance of <code>T</code> from the pool. If there are no more instances left in
	 * the pool it must throw an exception.
	 * 
	 * @return - instance from the pool
	 */
	T acquire();

	/**
	 * Releases the given instance of <code>T</code> from use.
	 * 
	 * @param object
	 *            - an instance to be released to the pool
	 */
	void release(T object);

}

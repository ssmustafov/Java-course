package com.sirma.itt.javacourse.patterns.pool;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents the Object Pool design pattern. Holds instances of {@code VeryHeavyClass} by given N
 * number of times.
 * 
 * @author smustafov
 */
public class ObjectPool {

	private final List<VeryHeavyClass> inUse = new ArrayList<>();
	private final List<VeryHeavyClass> available = new ArrayList<>();
	private int poolSize;

	/**
	 * Creates a new object pool with given pool size.
	 * 
	 * @param poolSize
	 *            - size of the pool to be set
	 */
	public ObjectPool(int poolSize) {
		if (poolSize <= 0) {
			throw new IllegalArgumentException(
					"The maximum pool size cannot be under or equal to zero");
		}

		this.poolSize = poolSize;
		initialSet();
	}

	/**
	 * Sets the initial pool.
	 */
	private void initialSet() {
		for (int i = 0; i < poolSize; i++) {
			available.add(new VeryHeavyClass());
		}
	}

	/**
	 * Acquires an instance of <code>VeryHeavyClass</code> from the pool. If there are no more
	 * instances left in the pool it throws <code>IllegalAccessError</code>.
	 * 
	 * @return - instance of the VeryHeavyClass from the pool
	 */
	public VeryHeavyClass acquire() {
		if (available.size() == 0) {
			throw new IllegalAccessError("Reached maximum size of the pool: " + poolSize);
		}

		VeryHeavyClass c = available.remove(available.size() - 1);
		inUse.add(c);
		return c;
	}

	/**
	 * Releases the given instance of <code>VeryHeavyClass</code>. If the given instance doesn't
	 * exists in use it throws <code>IllegalArgumentException</code>.
	 * 
	 * @param c
	 *            - instance of the VeryHeavyClass to be released to the pool
	 */
	public void release(VeryHeavyClass c) {
		// TODO: does have to take a parameter?
		if (!inUse.contains(c)) {
			throw new IllegalArgumentException("There is no such registered object in use");
		}

		inUse.remove(c);
		available.add(c);
	}

	/**
	 * Returns number of acquired objects from the pool.
	 * 
	 * @return - number of acquired objects from the pool
	 */
	public int getNumberOfAcquiredObjects() {
		return inUse.size();
	}

	/**
	 * Returns number of available objects in the pool.
	 * 
	 * @return - number of available objects in the pool
	 */
	public int getNumberOfAvailableObjects() {
		return available.size();
	}

}

package com.sirma.itt.javacourse.patterns.pool;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents the Object Pool design pattern. Holds instances by given N number of times.
 * 
 * @author smustafov
 */
public class ObjectPool {

	private static final List<VeryHeavyClass> IN_USE = new ArrayList<>();
	private static final List<VeryHeavyClass> AVAILABLE = new ArrayList<>();
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
			AVAILABLE.add(new VeryHeavyClass());
		}
	}

	/**
	 * Acquires an instance of <code>VeryHeavyClass</code> from the pool. If there are no more
	 * instances left in the pool it throws <code>IllegalAccessError</code>.
	 * 
	 * @return - instance of the VeryHeavyClass from the pool
	 */
	public VeryHeavyClass acquire() {
		if (AVAILABLE.size() == 0) {
			throw new IllegalAccessError("Reached maximum size of the pool: " + poolSize);
		}

		VeryHeavyClass c = AVAILABLE.remove(AVAILABLE.size() - 1);
		IN_USE.add(c);
		return c;
	}

	/**
	 * Releases the given instance of <code>VeryHeavyClass</code>.
	 * 
	 * @param c
	 *            - instance of the VeryHeavyClass to be released to the pool
	 */
	public void release(VeryHeavyClass c) {
		IN_USE.remove(c);
		AVAILABLE.add(c);
	}

}

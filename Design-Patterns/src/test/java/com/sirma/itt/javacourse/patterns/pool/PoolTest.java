package com.sirma.itt.javacourse.patterns.pool;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Tests {@link com.sirma.itt.javacourse.patterns.pool.ObjectPool} class.
 * 
 * @author smustafov
 */
public class PoolTest {

	/**
	 * Tests {@link com.sirma.itt.javacourse.patterns.pool.ObjectPool#release(T)} by adding more
	 * objects than the pool's size.
	 */
	@Test(expected = IllegalAccessError.class)
	public void testReleaseObjectsMoreThanTheSize() {
		Pool<Character> pool = new ObjectPool<>(5);
		pool.release('A');
		pool.release('B');
		pool.release('C');
		pool.release('d');
		pool.release('E');
		pool.release('w');
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.patterns.pool.ObjectPool} with series of releasing
	 * objects to the pool and acquiring objects from the pool until it's empty.
	 */
	@Test
	public void testSeriesOfAcquireAndRealease() {
		ObjectPool<Integer> p = new ObjectPool<>(4);
		p.release(1);
		p.release(2);
		p.release(3);
		p.release(4);
		p.acquire();
		p.acquire();
		p.release(5);
		p.acquire();
		p.acquire();
		p.acquire();

		int actual = p.getNumberOfAvailableObjects();
		int expected = 0;

		assertEquals(expected, actual);
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.patterns.pool.ObjectPool#acquire()} with empty pool.
	 */
	@Test(expected = IllegalAccessError.class)
	public void testAcquireWithEmptyPool() {
		Pool<String> pool = new ObjectPool<>(5);
		pool.acquire();
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.patterns.pool.ObjectPool#ObjectPool(int)} with negative
	 * size.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testNegativePoolSize() {
		new ObjectPool<String>(-3);
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.patterns.pool.ObjectPool#ObjectPool(int)} with zero
	 * size.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testZeroPoolSize() {
		new ObjectPool<Double>(0);
	}

}

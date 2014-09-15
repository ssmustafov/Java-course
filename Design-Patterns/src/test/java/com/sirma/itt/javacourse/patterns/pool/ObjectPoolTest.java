package com.sirma.itt.javacourse.patterns.pool;

import org.junit.Test;

/**
 * Tests {@link com.sirma.itt.javacourse.patterns.pool.ObjectPool} class.
 * 
 * @author smustafov
 */
public class ObjectPoolTest {

	/**
	 * Tests {@link com.sirma.itt.javacourse.patterns.pool.ObjectPool#acquire()} when there is no
	 * available objects in the pool.
	 */
	@Test(expected = IllegalAccessError.class)
	public void testAcquireWhenNoAvailableObjects() {
		ObjectPool pool = new ObjectPool(4);
		pool.acquire();
		pool.acquire();
		pool.acquire();
		pool.acquire();
		pool.acquire();
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.patterns.pool.ObjectPool#release(VeryHeavyClass)} with
	 * unregistered object.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testReleaseWithUnregisteredObject() {
		ObjectPool pool = new ObjectPool(5);
		pool.acquire();
		pool.acquire();
		pool.acquire();
		VeryHeavyClass a = new VeryHeavyClass();
		pool.release(a);
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.patterns.pool.ObjectPool#acquire()} by acquiring only
	 * one object from the pool.
	 */
	@Test
	public void testAcquireOneObject() {

	}

}

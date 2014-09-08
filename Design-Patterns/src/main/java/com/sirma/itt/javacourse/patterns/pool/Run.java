package com.sirma.itt.javacourse.patterns.pool;

/**
 * Shows how the Object pool can be used.
 * 
 * @author smustafov
 */
public final class Run {

	/**
	 * Protects from instantiation.
	 */
	private Run() {

	}

	/**
	 * Main method.
	 * 
	 * @param args
	 *            - arguments
	 */
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		ObjectPool pool = new ObjectPool(4);
		VeryHeavyClass a = pool.acquire();
		VeryHeavyClass b = pool.acquire();
		VeryHeavyClass c = pool.acquire();
		VeryHeavyClass d = pool.acquire();
		pool.release(c);
		VeryHeavyClass f = pool.acquire();
	}

}

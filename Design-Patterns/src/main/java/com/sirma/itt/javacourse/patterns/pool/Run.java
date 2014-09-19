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
	public static void main(String[] args) {
		Pool<Integer> p = new ObjectPool<>(4);
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
		// p.acquire();
	}

}

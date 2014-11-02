package com.sirma.itt.javacourse.patterns.proxy;

/**
 * Factory for creating {@code Number}s.
 * 
 * @author Sinan
 */
public final class IntegerFactory {

	/**
	 * Protects from instantiation.
	 */
	private IntegerFactory() {

	}

	/**
	 * Creates and returns an instance of {@code IntegerProxy}.
	 * 
	 * @return an instance of integer proxy
	 */
	public static Number createInstance() {
		return new IntegerProxy();
	}
}

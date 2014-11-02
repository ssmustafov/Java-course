package com.sirma.itt.javacourse.patterns.proxy;

/**
 * Shows how to use the Proxy pattern.
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
		Number number = IntegerFactory.createInstance();
		System.out.println(number);
		number.setNumber(120);
		System.out.println(number);
	}
}

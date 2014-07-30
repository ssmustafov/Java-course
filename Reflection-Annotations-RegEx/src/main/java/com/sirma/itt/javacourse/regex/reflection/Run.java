package com.sirma.itt.javacourse.regex.reflection;

/**
 * @author smustafov
 */
public final class Run {

	/**
	 * Protects from instantiation.
	 */
	private Run() {

	}

	/**
	 * @param args
	 *            - arguments
	 */
	public static void main(String[] args) {
		ArrayProcess a = new ArrayProcess();
		Reflection r = new Reflection();
		r.printFields(a);
		r.printMethods(a);

	}

}

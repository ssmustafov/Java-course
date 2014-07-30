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
		// Task 1
		RandomString a = new RandomString();
		Reflection r = new Reflection();
		r.printFields(a);
		r.printMethods(a);

		// Task 2
		StringBuilder stringBuilder = (StringBuilder) r
				.instantiateClassByName("java.lang.StringBuilder");
		stringBuilder.append("a");
		stringBuilder.append("b");
		stringBuilder.append(" text");
		r.printInterfaces(stringBuilder);
		r.printParentClass(stringBuilder);
	}

}

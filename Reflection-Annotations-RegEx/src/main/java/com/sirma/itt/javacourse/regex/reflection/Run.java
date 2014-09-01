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
		r.printAllFields(a);
		r.printMethods(a);
		System.out.println();

		// Task 2
		StringBuilder stringBuilder = (StringBuilder) r
				.instantiateClassByName("java.lang.StringBuilder");
		stringBuilder.append("a");
		stringBuilder.append("b");
		stringBuilder.append(" text");
		r.printInterfaces(stringBuilder);
		r.printParentClass(stringBuilder);
		System.out.println();

		// Task 3
		RandomStringReflector reflector = new RandomStringReflector();
		reflector.printAllPrivateFields();
		System.out.println();
		reflector.invokeAllPrivateMethods();
	}

}

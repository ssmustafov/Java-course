package com.sirma.itt.javacourse.regex.reflection;


/**
 * Works with {@link com.sirma.itt.javacourse.regex.reflection.RandomString} class by using
 * reflection.
 * 
 * @author smustafov
 */
public class RandomStringReflector {

	private RandomString randomString;
	private Reflection reflection;

	/**
	 * Creates a new reflector.
	 */
	public RandomStringReflector() {
		reflection = new Reflection();
		randomString = new RandomString();
	}

	/**
	 * Prints on the console all private fields of
	 * {@link com.sirma.itt.javacourse.regex.reflection.RandomString} class.
	 */
	public void printAllPrivateFields() {
		reflection.printPrivateFields(randomString);
	}

	/**
	 * Prints on the console all private methods of
	 * {@link com.sirma.itt.javacourse.regex.reflection.RandomString} class.
	 */
	public void invokeAllPrivateMethods() {
		reflection.invokeAllPrivateMethods(randomString);
	}

}

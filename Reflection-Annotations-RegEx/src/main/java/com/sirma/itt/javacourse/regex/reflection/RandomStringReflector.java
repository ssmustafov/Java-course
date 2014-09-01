package com.sirma.itt.javacourse.regex.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

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
		reflection.printAllPrivateMethodsSignature(randomString);

		try {
			Method method1 = randomString.getClass()
					.getDeclaredMethod("getRandomNumber", int.class);
			method1.setAccessible(true);
			System.out.println("Invoking method 'getRandomNumber' with parameter 100: "
					+ method1.invoke(randomString, 100));

			Method method2 = randomString.getClass().getDeclaredMethod("getRandomNumberRange",
					int.class, int.class);
			method2.setAccessible(true);
			System.out.println("Invoking method 'getRandomNumberRange' with parameters 10, 50: "
					+ method2.invoke(randomString, 10, 50));
		} catch (NoSuchMethodException e) {
			System.err.println(e.getMessage());
		} catch (SecurityException e) {
			System.err.println(e.getMessage());
		} catch (IllegalAccessException e) {
			System.err.println(e.getMessage());
		} catch (IllegalArgumentException e) {
			System.err.println(e.getMessage());
		} catch (InvocationTargetException e) {
			System.err.println(e.getMessage());
		}
	}
}

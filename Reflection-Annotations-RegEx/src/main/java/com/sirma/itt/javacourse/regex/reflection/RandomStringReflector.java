package com.sirma.itt.javacourse.regex.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Works with {@link com.sirma.itt.javacourse.regex.reflection.RandomString} class ny using
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
		try {
			Method method1 = RandomString.class.getDeclaredMethod("getRandomNumber", int.class);
			method1.setAccessible(true);
			System.out.println("Invoking method 'getRandomNumber' with parameter 100: "
					+ method1.invoke(randomString, 100));

			Method method2 = RandomString.class.getDeclaredMethod("getRandomNumberRange",
					int.class, int.class);
			method2.setAccessible(true);
			System.out.println("Invoking method 'getRandomNumberRange' with parameters 10,15: "
					+ method2.invoke(randomString, 10, 15));
		} catch (NoSuchMethodException e) {
			System.out.println("No such method: " + e.getMessage());
		} catch (SecurityException e) {
			System.out.println(e.getMessage());
		} catch (InvocationTargetException e) {
			System.out.println(e.getMessage());
		} catch (IllegalAccessException e) {
			System.out.println(e.getMessage());
		}
	}
}

package com.sirma.itt.javacourse.reflection.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Holds methods for reflection.
 * 
 * @author smustafov
 */
public class Reflection {

	/**
	 * Prints on the console all methods signature in given class.
	 * 
	 * @param obj
	 *            - the class whom methods signature to be printed
	 */
	public void printMethods(Object obj) {
		Class<?> someClass = obj.getClass();
		Method[] methods = someClass.getMethods();
		if (methods.length != 0) {
			System.out.println("Methods with their signatures in '" + someClass.getSimpleName()
					+ "' class:");
			for (Method method : methods) {
				System.out.printf("\t%s", method.toGenericString());
				System.out.println();
			}
		} else {
			System.out.println("\t-- No methods --");
		}
	}

	/**
	 * Prints on the console all fields in given class.
	 * 
	 * @param obj
	 *            - the class whom fields to be printed
	 */
	public void printFields(Object obj) {
		Class<?> someClass = obj.getClass();
		Field[] fields = someClass.getDeclaredFields();
		if (fields.length != 0) {
			System.out.println("Fields in '" + someClass.getSimpleName() + "' class:");
			for (Field field : fields) {
				field.setAccessible(true);
				try {
					Object fieldValue = field.get(obj);
					System.out.printf("\tName: %s  Type: %s  Value: %s", field.getName(),
							field.getType(), fieldValue);
					System.out.println();
				} catch (IllegalArgumentException e) {
					System.out.println(e.getMessage());
				} catch (IllegalAccessException e) {
					System.out.println(e.getMessage());
				}
			}
		} else {
			System.out.println("\t-- No fields --");
		}
	}
}

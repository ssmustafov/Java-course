package com.sirma.itt.javacourse.regex.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Holds methods for reflection.
 * 
 * @author smustafov
 */
public class Reflection {

	/**
	 * Creates an instance of class by given full class name.
	 * 
	 * @param className
	 *            - the class which class name to be created
	 * @return instance of the class created
	 */
	public Object instantiateClassByName(String className) {
		Object object = null;
		try {
			Class<?> c = Class.forName(className);
			object = c.newInstance();
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (InstantiationException e) {
			System.out.println(e.getMessage());
		} catch (IllegalAccessException e) {
			System.out.println(e.getMessage());
		}
		return object;
	}

	/**
	 * Prints on the console the parent class of the given class.
	 * 
	 * @param obj
	 *            - the class whom parent class to be printed
	 */
	public void printParentClass(Object obj) {
		Class<?> someClass = obj.getClass();
		System.out.println("Parent class of '" + someClass.getSimpleName() + "' class");
		System.out.printf("\t%s", someClass.getSuperclass().getSimpleName());
		System.out.println();
	}

	/**
	 * Prints on the console all interfaces the given class implements.
	 * 
	 * @param obj
	 *            - the class whom interfaces to be printed
	 */
	public void printInterfaces(Object obj) {
		Class<?> someClass = obj.getClass();
		Class<?>[] interfaces = someClass.getInterfaces();

		System.out.println("Interfaces implemented by '" + someClass.getSimpleName() + "' class");
		if (interfaces.length != 0) {
			for (Class<?> class1 : interfaces) {
				System.out.printf("\t%s", class1.getSimpleName());
				System.out.println();
			}
		} else {
			System.out.println("\t-- No interfaces --");
		}
	}

	/**
	 * Prints on the console all methods signature in given class.
	 * 
	 * @param obj
	 *            - the class whom methods signature to be printed
	 */
	public void printMethods(Object obj) {
		Class<?> someClass = obj.getClass();
		Method[] methods = someClass.getMethods();

		System.out.println("Methods in '" + someClass.getSimpleName() + "' class:");
		if (methods.length != 0) {
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

		System.out.println("Fields in '" + someClass.getSimpleName() + "' class:");
		if (fields.length != 0) {
			for (Field field : fields) {
				try {
					field.setAccessible(true);
					System.out.printf("\tName: %s  Type: %s  Value: %s", field.getName(),
							field.getType(), field.get(obj));
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

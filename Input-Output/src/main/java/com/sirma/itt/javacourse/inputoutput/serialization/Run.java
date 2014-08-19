package com.sirma.itt.javacourse.inputoutput.serialization;

import java.io.IOException;

/**
 * Show how the serializible classes can be used.
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
	 * @param args
	 *            - arguments
	 */
	public static void main(String[] args) {
		DataClass data = new DataClass();
		Person person = new Person("Sinan Mustafov", 21);
		try {
			data.saveObject("src\\main\\resources\\person.ser", person);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

		Person readPerson = null;
		try {
			Object obj = data.getObject("src\\main\\resources\\person.ser");
			readPerson = (Person) obj;
			System.out.println(readPerson);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		// -----------------------------------------------------+

		Point point = new Point(10.0, 15.0);
		try {
			data.saveObject("src\\main\\resources\\point.ser", point);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

		Point readPoint = null;
		try {
			Object obj = data.getObject("src\\main\\resources\\point.ser");
			readPoint = (Point) obj;
			System.out.println(readPoint);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}

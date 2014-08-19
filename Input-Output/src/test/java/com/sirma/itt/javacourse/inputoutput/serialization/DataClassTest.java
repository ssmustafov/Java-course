package com.sirma.itt.javacourse.inputoutput.serialization;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;

/**
 * Tests {@link com.sirma.itt.javacourse.inputoutput.serialization.DataClass} class.
 * 
 * @author smustafov
 */
public class DataClassTest {

	/**
	 * Tests serializing and deserializing an valid object.
	 */
	@Test
	public void testWithValidObject() {
		DataClass data = new DataClass();
		Point point = new Point(10, 121);
		try {
			data.saveObject("src\\test\\resources\\testWithValidObject.ser", point);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

		Point readPoint = null;
		try {
			Object obj = data.getObject("src\\test\\resources\\testWithValidObject.ser");
			readPoint = (Point) obj;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		String actual = readPoint.toString();
		String expected = point.toString();
		assertEquals(expected, actual);
	}

	/**
	 * Tests serializing and deserializing an empty object.
	 */
	@Test
	public void testWithEmptyObject() {
		DataClass data = new DataClass();
		Point point = new Point();
		try {
			data.saveObject("src\\test\\resources\\testWithEmptyObject.ser", point);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

		Point readPoint = null;
		try {
			Object obj = data.getObject("src\\test\\resources\\testWithEmptyObject.ser");
			readPoint = (Point) obj;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		String actual = readPoint.toString();
		String expected = point.toString();
		assertEquals(expected, actual);
	}

}

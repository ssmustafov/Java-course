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
	 * Tests serializing and deserializing an object.
	 */
	@Test
	public void testSerializeAndDeserialize() {
		DataClass data = new DataClass();
		Point point = new Point(10, 121);
		try {
			data.saveObject("src\\test\\resources\\testSerializeAndDeserialize.ser", point);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

		Point readPoint = null;
		try {
			Object obj = data.getObject("src\\test\\resources\\testSerializeAndDeserialize.ser");
			readPoint = (Point) obj;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		String actual = readPoint.toString();
		String expected = point.toString();
		assertEquals(expected, actual);
	}

}

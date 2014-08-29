package com.sirma.itt.javacourse.regex.annotations;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

/**
 * Tests {@link com.sirma.itt.javacourse.regex.annotations.HumanComparator} class.
 * 
 * @author smustafov
 */
public class HumanComparatorTest {

	/**
	 * Tests {@link com.sirma.itt.javacourse.regex.annotations.HumanComparator}.
	 */
	@Test
	public void test() {
		Human[] originalArr = { new Human1(), new Human2(), new Human2(), new Human3(),
				new Human3() };
		Human[] arr = { new Human3(), new Human2(), new Human1(), new Human2(), new Human3() };
		Arrays.sort(arr);

		boolean actual = Arrays.equals(originalArr, arr);
		boolean expected = true;

		assertEquals(expected, actual);
	}
}

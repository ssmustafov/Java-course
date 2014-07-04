package com.sirma.itt.javacourse.intro.arrays;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Class for testing {@link com.sirma.itt.javacourse.intro.arrays.ArrayProcess} class.
 * 
 * @author smustafov
 */
public class ArrayProcessTest {

	/**
	 * Test method for
	 * {@link com.sirma.itt.javacourse.intro.arrays.ArrayProcess#getMinElement(int[])}.
	 */
	@Test
	public void testGetMinElementWithNormalNumbers() {
		int[] array = { 2, 4, 5, 3, 1, 7, 0, 9, 8 };
		int actual = ArrayProcess.getMinElement(array);
		int expected = 0;

		assertEquals(expected, actual);
	}

	/**
	 * Test method for
	 * {@link com.sirma.itt.javacourse.intro.arrays.ArrayProcess#getMinElement(int[])}.
	 */
	@Test
	public void testGetMinElementWithNegativeNumbers() {
		int[] array = { 29, 45, -5, 3, 11, 27, 22, 9, 8, -100 };
		int actual = ArrayProcess.getMinElement(array);
		int expected = -100;

		assertEquals(expected, actual);
	}

	/**
	 * Test method for
	 * {@link com.sirma.itt.javacourse.intro.arrays.ArrayProcess#getMinElement(int[])}.
	 */
	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void testGetMinElementWithEmptyArray() {
		int[] array = {};
		ArrayProcess.getMinElement(array);
	}

	/**
	 * Test method for
	 * {@link com.sirma.itt.javacourse.intro.arrays.ArrayProcess#getMinElement(int[])}.
	 */
	@Test
	public void testGetMinElementWithOneElementInArray() {
		int[] array = { 11 };
		int actual = ArrayProcess.getMinElement(array);
		int expected = 11;

		assertEquals(expected, actual);
	}

	/**
	 * Test method for {@link com.sirma.itt.javacourse.intro.arrays.ArrayProcess#sum(int[])}.
	 */
	@Test
	public void testBasicSum() {
		int[] array = { 11, 4, 100, 12, 43, 1 };
		int actual = ArrayProcess.sum(array);
		int expected = 171;

		assertEquals(expected, actual);
	}

	/**
	 * Test method for {@link com.sirma.itt.javacourse.intro.arrays.ArrayProcess#sum(int[])}.
	 */
	@Test
	public void testSumWithOneElement() {
		int[] array = { 100 };
		int actual = ArrayProcess.sum(array);
		int expected = 100;

		assertEquals(expected, actual);
	}

	/**
	 * Test method for {@link com.sirma.itt.javacourse.intro.arrays.ArrayProcess#sum(int[])}.
	 */
	@Test
	public void testSumWithZeros() {
		int[] array = { 0, 0, 0 };
		int actual = ArrayProcess.sum(array);
		int expected = 0;

		assertEquals(expected, actual);
	}

	/**
	 * Test method for {@link com.sirma.itt.javacourse.intro.arrays.ArrayProcess#sum(int[])}.
	 */
	@Test
	public void testSumWithNegativeNumbers() {
		int[] array = { -234, -1, 0, -5, -17, 55, 33, -33 };
		int actual = ArrayProcess.sum(array);
		int expected = -202;

		assertEquals(expected, actual);
	}

	/**
	 * Test method for {@link com.sirma.itt.javacourse.intro.arrays.ArrayProcess#print(int[])}.
	 */
	@Test
	public void testPrintNormalCase() {
		int[] array = { -234, -1, 0, -5, -17, 55, 33, -33 };
		String actual = ArrayProcess.print(array);
		String expected = "-234, -1, 0, -5, -17, 55, 33, -33";

		assertEquals(expected, actual);
	}

	/**
	 * Test method for {@link com.sirma.itt.javacourse.intro.arrays.ArrayProcess#print(int[])}.
	 */
	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void testPrintWithEmptyArray() {
		int[] array = {};
		ArrayProcess.print(array);
	}

	/**
	 * Test method for {@link com.sirma.itt.javacourse.intro.arrays.ArrayProcess#print(int[])}.
	 */
	@Test
	public void testPrintWithOneElement() {
		int[] array = { 55 };
		String actual = ArrayProcess.print(array);
		String expected = "55";

		assertEquals(expected, actual);
	}

}

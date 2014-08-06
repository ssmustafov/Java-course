package com.sirma.itt.javacourse.exceptions.list;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;

/**
 * Tests {@link com.sirma.itt.javacourse.exceptions.list.List} class.
 * 
 * @author smustafov
 */
public class ListTest {

	/**
	 * Tests {@link com.sirma.itt.javacourse.exceptions.list.List#List(int)} with zero size.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testListWithZeroSize() {
		new List(0);
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.exceptions.list.List#List(int)} with negative size.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testListWithNegativeSize() {
		new List(-5);
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.exceptions.list.List#add(Object)} by adding one
	 * element.
	 */
	@Test
	public void testAddOneElement() {
		List list = new List(10);
		list.add(100);
		Object actual = list.get(0);
		Object expected = 100;

		assertEquals(expected, actual);
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.exceptions.list.List#add(Object)} with adding elements
	 * more than the size of the list.
	 */
	@Test(expected = ListFullException.class)
	public void testAddManyTimes() {
		List list = new List(5);
		list.add(542);
		list.add("Text");
		list.add(12.423f);
		list.remove();
		list.remove();
		list.add(new BigDecimal("20098363603986698.200"));
		list.remove();
		list.remove();

		list.add(100);
		list.add('D');
		list.add("stack");
		list.add(200);
		list.add(300);

		list.add(500);
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.exceptions.list.List#add(Object)}.
	 */
	@Test
	public void testAddNormalCase() {
		List list = new List(5);
		list.add("Text");
		list.add(new BigDecimal("29083.34895"));
		list.add('E');
		Object actual = list.get(2);
		Object expected = 'E';

		assertEquals(expected, actual);
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.exceptions.list.List#remove()}.
	 */
	@Test
	public void testRemoveNormalCase() {
		List list = new List(4);
		list.add(100);
		list.add('E');
		list.add("Text");
		list.add(new BigDecimal("29083.34895"));
		list.remove();
		Object actual = list.get(3);
		Object expected = null;

		assertEquals(expected, actual);
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.exceptions.list.List#remove()} with zero size of the
	 * list.
	 */
	@Test(expected = ListEmptyException.class)
	public void testRemoveManyTimes() {
		List list = new List(5);
		list.add(542);
		list.add("Text");
		list.add(12.423f);
		list.remove();
		list.remove();
		list.add(new BigDecimal("200.200"));
		list.remove();
		list.remove();
		list.remove();
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.exceptions.list.List#remove()} with one element in the
	 * list.
	 */
	@Test
	public void testRemoveWithOneElement() {
		List list = new List(4);
		list.add('E');
		list.remove();
		Object actual = list.get(0);
		Object expected = null;

		assertEquals(expected, actual);
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.exceptions.list.List#getAllElements()} with empty list
	 * empty.
	 */
	@Test
	public void testGetAllElementsWithEmptyList() {
		List list = new List(4);
		String actual = list.getAllElements();
		String expected = "[]";

		assertEquals(expected, actual);
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.exceptions.list.List#getAllElements()} with one element
	 * in the list.
	 */
	@Test
	public void testGetAllElementsWithOneElement() {
		List list = new List(40);
		list.add(200);
		String actual = list.getAllElements();
		String expected = "[200]";

		assertEquals(expected, actual);
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.exceptions.list.List#getAllElements()}.
	 */
	@Test
	public void testGetAllElementsNormalCase() {
		List list = new List(4);
		list.add(200);
		list.add("test");
		list.add('Q');
		list.add(3.14f);
		String actual = list.getAllElements();
		String expected = "[200, test, Q, 3.14]";

		assertEquals(expected, actual);
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.exceptions.list.List#List(int)} with more adding and
	 * removing.
	 */
	@Test
	public void testListSpecialCase() {
		List list = new List(5);
		list.add(542);
		list.add("Text");
		list.add(12.423f);
		list.remove();
		list.remove();
		list.add(new BigDecimal("200.200"));
		list.remove();
		list.remove();

		list.add(100);
		list.add('D');
		list.add("stack");
		list.add(200);
		list.add(300);
		list.remove();
		list.remove();
		list.remove();
		list.remove();
		list.remove();
		list.add(500);

		String actual = list.getAllElements();
		String expected = "[500]";

		assertEquals(expected, actual);
	}

}

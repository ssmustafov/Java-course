package com.sirma.itt.javacourse.threads.synchronizedstack;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests {@link com.sirma.itt.javacourse.threads.synchronizedstack.SynchronizedList} class.
 * 
 * @author smustafov
 */
public class SynchronizedListTest {

	private SynchronizedList list;

	/**
	 * 
	 */
	@Before
	public void setUp() {
		list = new SynchronizedList(4);
	}

	/**
	 * 
	 */
	@After
	public void tearDown() {
		list = null;
	}

	/**
	 * Tests by adding and removing only one object.
	 */
	@Test
	public void test() {
		list.add("Test");
		list.remove();

		String actual = list.toString();
		String expected = "[]";

		assertEquals(expected, actual);
	}

}

package com.sirma.itt.javacourse.threads.synchronizedstack;

import static org.junit.Assert.assertEquals;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

/**
 * Tests {@link com.sirma.itt.javacourse.threads.synchronizedstack.SynchronizedStack} class.
 * 
 * @author smustafov
 */
public class SynchronizedStackTest {

	private static final Logger LOGGER = LogManager.getLogger(SynchronizedStackTest.class);
	private static final int SLEEP_TIME = 250;

	/**
	 * Sleeps for {@link SynchronizedStackTest#SLEEP_TIME} time.
	 */
	private void sleep() {
		try {
			Thread.sleep(SLEEP_TIME);
		} catch (InterruptedException e) {
			LOGGER.error(e.getMessage(), e);
		}
	}

	/**
	 * Tests by removing which will wait an item to be added and then adds only one object.
	 */
	@Test
	public void testRemoveBeforeAdding() {
		SynchronizedStack list = new SynchronizedStack(4);
		list.remove();
		list.add("Test");

		sleep();

		String actual = list.toString();
		String expected = "[]";

		assertEquals(expected, actual);
	}

	/**
	 * Tests by removing multiple items which will wait an items to be added and then adds objects.
	 */
	@Test
	public void testRemoveMultipleTimesBeforeAdding() {
		SynchronizedStack list = new SynchronizedStack(3);
		list.remove();
		list.remove();
		list.remove();
		list.add(200);
		list.add("hi");
		list.add(2.35);

		sleep();

		String actual = list.toString();
		String expected = "[]";

		assertEquals(expected, actual);
	}

	/**
	 * Tests by removing multiple items which will wait an items to be added after adding objects.
	 */
	@Test
	public void testRemoveMultipleTimesAfterAdding() {
		SynchronizedStack list = new SynchronizedStack(3);
		list.add("hi");
		list.add(200);
		list.add("recursion");
		list.remove();
		list.remove();
		list.remove();

		sleep();

		String actual = list.toString();
		String expected = "[]";

		assertEquals(expected, actual);
	}

	/**
	 * Tests by adding one item and then removes it.
	 */
	@Test
	public void testRemoveAfterAdding() {
		SynchronizedStack list = new SynchronizedStack(2);
		list.remove();
		list.add(200);

		sleep();

		String actual = list.toString();
		String expected = "[]";

		assertEquals(expected, actual);
	}

	/**
	 * Tests by adding more items than the list can contains, then removes them.
	 */
	@Test
	public void testAddManyTimes() {
		SynchronizedStack list = new SynchronizedStack(2);
		list.add("a");
		list.add("b");
		list.add("c");
		list.remove();

		sleep();

		String actual = list.toString();
		String expected = "[a, c]";

		assertEquals(expected, actual);
	}

}

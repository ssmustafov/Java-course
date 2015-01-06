package com.sirma.itt.javacourse.threads.hashtable;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Tests {@link com.sirma.itt.javacourse.threads.hashtable.TimeoutHashtable} class.
 * 
 * @author smustafov
 */
public class TimeoutHashtableTest {

	/**
	 * Tests
	 * {@link com.sirma.itt.javacourse.threads.hashtable.TimeoutHashtable#TimeoutHashtable(int)}
	 * with negative seconds.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testWithNegativeSeconds() {
		new TimeoutHashtable<Integer, Integer>(-1);
	}

	/**
	 * Tests adding two elements and sleeping for 2 seconds then checks if the first element
	 * contains in the table hence the seconds element must be in the table.
	 */
	@Test
	public void testAddSleepToRemove() {
		TimeoutHashtable<Integer, Integer> table = new TimeoutHashtable<>(2);
		table.put(10, 1234);

		try {
			Thread.sleep(2100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		table.put(17, 44331);
		boolean actualFirstKeyContains = table.contains(10);
		boolean actualSecondKeyContains = table.contains(17);

		assertFalse(actualFirstKeyContains);
		assertTrue(actualSecondKeyContains);
	}

	/**
	 * Tests adding two elements and sleeping for 2 seconds then gets the first element hence the
	 * second should be removed.
	 */
	@Test
	public void testGetSleepToRemove() {
		TimeoutHashtable<Integer, Integer> table = new TimeoutHashtable<>(2);
		table.put(10, 1234);
		table.put(17, 44331);

		try {
			Thread.sleep(1200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		table.get(10);

		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		boolean actualFirstKeyContains = table.contains(10);
		boolean actualSecondKeyContains = table.contains(17);

		assertTrue(actualFirstKeyContains);
		assertFalse(actualSecondKeyContains);
	}

}

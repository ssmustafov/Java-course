package com.sirma.itt.javacourse.collections.lru;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Tests {@link com.sirma.itt.javacourse.collections.lru.LeastRecentlyUsed} class.
 * 
 * @author smustafov
 */
public class LeastRecentlyUsedTest {

	/**
	 * Tests
	 * {@link com.sirma.itt.javacourse.collections.lru.LeastRecentlyUsed#LeastRecentlyUsed(int)}
	 * with negative size.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testLRUWithNegativeSize() {
		new LeastRecentlyUsed<String, Integer>(-3);
	}

	/**
	 * Tests
	 * {@link com.sirma.itt.javacourse.collections.lru.LeastRecentlyUsed#LeastRecentlyUsed(int)}
	 * with zero size.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testLRUWithZeroSize() {
		new LeastRecentlyUsed<Integer, String>(0);
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.collections.lru.LeastRecentlyUsed} with size 4 and 12
	 * additions.
	 */
	@Test
	public void testNormalCase() {
		LeastRecentlyUsed<Integer, String> lru = new LeastRecentlyUsed<>(4);
		lru.add(1, "one");
		lru.add(2, "two");
		lru.add(3, "three");
		lru.add(4, "four");
		lru.add(1, "one");
		lru.add(2, "two");
		lru.add(5, "five");
		lru.add(1, "one");
		lru.add(2, "two");
		lru.add(3, "three");
		lru.add(4, "four");
		lru.add(5, "five");

		boolean actual1 = lru.containsKey(5);
		boolean actual2 = lru.containsKey(2);
		boolean actual3 = lru.containsKey(4);
		boolean actual4 = lru.containsKey(3);
		boolean expected = true;

		assertEquals(expected, actual1);
		assertEquals(expected, actual2);
		assertEquals(expected, actual3);
		assertEquals(expected, actual4);
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.collections.lru.LeastRecentlyUsed} with size 4 and
	 * adding the same element 4 times.
	 */
	@Test
	public void testAddingSameElement() {
		LeastRecentlyUsed<Double, Integer> lru = new LeastRecentlyUsed<>(4);
		lru.add(2.71, 1);
		lru.add(2.71, 1);
		lru.add(2.71, 1);
		lru.add(2.71, 1);

		boolean actual = lru.containsKey(2.71);
		int actualSize = lru.getSize();
		int expectedSize = 1;
		boolean expected = true;

		assertEquals(expected, actual);
		assertEquals(expectedSize, actualSize);
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.collections.lru.LeastRecentlyUsed} with size 3 and
	 * adding 20 elements.
	 */
	@Test
	public void testAddingTwentyElements() {
		LeastRecentlyUsed<Character, Integer> lru = new LeastRecentlyUsed<>(3);
		lru.add('B', 1);
		lru.add('A', 10);
		lru.add('F', 100);
		lru.add('E', 1000);
		lru.add('A', 10);
		lru.add('Z', 10000);
		lru.add('E', 1000);
		lru.add('Q', 100000);
		lru.add('A', 10);
		lru.add('Q', 100000);
		lru.add('E', 1000);
		lru.add('F', 100);
		lru.add('E', 1000);
		lru.add('A', 10);
		lru.add('F', 100);
		lru.add('B', 1);
		lru.add('A', 10);
		lru.add('F', 100);

		boolean actual1 = lru.containsKey('F');
		boolean actual2 = lru.containsKey('A');
		boolean actual3 = lru.containsKey('B');
		boolean expected = true;

		assertEquals(expected, actual1);
		assertEquals(expected, actual2);
		assertEquals(expected, actual3);
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.collections.lru.LeastRecentlyUsed} with size 3 and
	 * adding 1 element.
	 */
	@Test
	public void testAddingOneElement() {
		LeastRecentlyUsed<String, Float> lru = new LeastRecentlyUsed<>(3);
		lru.add("Test", 0.012f);

		boolean actualContent = lru.containsKey("Test");
		int actualSize = lru.getSize();
		boolean expectedContent = true;
		int expectedSize = 1;

		assertEquals(expectedContent, actualContent);
		assertEquals(expectedSize, actualSize);
	}

}

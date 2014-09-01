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
		lru.put(1, "one");
		lru.put(2, "two");
		lru.put(3, "three");
		lru.put(4, "four");
		lru.put(1, "one");
		lru.put(2, "two");
		lru.put(5, "five");
		lru.put(1, "one");
		lru.put(2, "two");
		lru.put(3, "three");
		lru.put(4, "four");
		lru.put(5, "five");

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
		lru.put(2.71, 1);
		lru.put(2.71, 1);
		lru.put(2.71, 1);
		lru.put(2.71, 1);

		boolean actual = lru.containsKey(2.71);
		int actualSize = lru.size();
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
		lru.put('B', 1);
		lru.put('A', 10);
		lru.put('F', 100);
		lru.put('E', 1000);
		lru.put('A', 10);
		lru.put('Z', 10000);
		lru.put('E', 1000);
		lru.put('Q', 100000);
		lru.put('A', 10);
		lru.put('Q', 100000);
		lru.put('E', 1000);
		lru.put('F', 100);
		lru.put('E', 1000);
		lru.put('A', 10);
		lru.put('F', 100);
		lru.put('B', 1);
		lru.put('A', 10);
		lru.put('F', 100);

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
		lru.put("Test", 0.012f);

		boolean actualContent = lru.containsKey("Test");
		int actualSize = lru.size();
		boolean expectedContent = true;
		int expectedSize = 1;

		assertEquals(expectedContent, actualContent);
		assertEquals(expectedSize, actualSize);
	}

}

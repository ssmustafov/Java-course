package com.sirma.itt.javacourse.collections.lru;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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

		assertTrue(actual1);
		assertTrue(actual2);
		assertTrue(actual3);
		assertTrue(actual4);
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

		assertTrue(actual);
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

		assertTrue(actual1);
		assertTrue(actual2);
		assertTrue(actual3);
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
		int expectedSize = 1;

		assertTrue(actualContent);
		assertEquals(expectedSize, actualSize);
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.collections.lru.LeastRecentlyUsed} with size 1 and
	 * adding 3 elements.
	 */
	@Test
	public void testWithSizeOne() {
		LeastRecentlyUsed<Integer, Integer> lru = new LeastRecentlyUsed<>(1);
		lru.add(2, 10);
		lru.add(3, 11);
		lru.add(5, 101);

		boolean actualContent1 = lru.containsKey(2);
		boolean actualContent2 = lru.containsKey(3);
		boolean actualContent3 = lru.containsKey(5);
		int actualSize = lru.getSize();
		int expectedSize = 1;

		assertFalse(actualContent1);
		assertFalse(actualContent2);
		assertTrue(actualContent3);
		assertEquals(expectedSize, actualSize);
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.collections.lru.LeastRecentlyUsed} with size 1 and
	 * adding same element with different values.
	 */
	@Test
	public void testSameElementWithDifferentValue() {
		LeastRecentlyUsed<Integer, String> lru = new LeastRecentlyUsed<>(1);
		lru.add(2, "10");
		lru.add(2, "11");
		lru.add(2, "101");

		boolean actualKey = lru.containsKey(2);
		boolean actualValue1 = lru.containsValue("10");
		boolean actualValue2 = lru.containsValue("11");
		boolean actualValue3 = lru.containsValue("101");
		int actualSize = lru.getSize();
		int expectedSize = 1;

		assertTrue(actualKey);
		assertFalse(actualValue1);
		assertFalse(actualValue2);
		assertTrue(actualValue3);
		assertEquals(expectedSize, actualSize);
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.collections.lru.LeastRecentlyUsed} with size 4 and
	 * adding 2 elements 2 times with different values.
	 */
	@Test
	public void testElementsWithDifferenValues() {
		LeastRecentlyUsed<Integer, Integer> lru = new LeastRecentlyUsed<>(4);
		lru.add(1, 10);
		lru.add(2, 100);
		lru.add(1, 20);
		lru.add(2, 200);

		boolean actualValue1 = lru.containsValue(10);
		boolean actualValue2 = lru.containsValue(100);
		boolean actualValue3 = lru.containsValue(20);
		boolean actualValue4 = lru.containsValue(200);
		int actualSize = lru.getSize();
		int expectedSize = 2;

		assertFalse(actualValue1);
		assertFalse(actualValue2);
		assertTrue(actualValue3);
		assertTrue(actualValue4);
		assertEquals(expectedSize, actualSize);
	}

	// Following tests are when elements are only used in the cache

	/**
	 * Tests {@link com.sirma.itt.javacourse.collections.lru.LeastRecentlyUsed} by adding elements
	 * until the cache is full then only uses two elements of the cache without removing them.
	 */
	@Test
	public void testUsingTwoElements() {
		LeastRecentlyUsed<Integer, Integer> lru = new LeastRecentlyUsed<>(4);
		lru.add(1, 1);
		lru.add(5, 101);
		lru.add(7, 111);
		lru.add(3, 11);

		lru.use(1);
		lru.use(1);
		lru.use(1);
		lru.use(5);
		lru.use(5);

		lru.add(10, 1000);

		boolean actualValue1 = lru.containsKey(1);
		boolean actualValue2 = lru.containsKey(5);
		boolean actualValue3 = lru.containsKey(3);
		boolean actualValue4 = lru.containsKey(10);
		boolean actualValue5 = lru.containsKey(7);

		assertTrue(actualValue1);
		assertTrue(actualValue2);
		assertTrue(actualValue3);
		assertTrue(actualValue4);
		assertFalse(actualValue5);
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.collections.lru.LeastRecentlyUsed} by adding elements
	 * until the cache is full then only uses one element of the cache.
	 */
	@Test
	public void testUsingOneElements() {
		LeastRecentlyUsed<Integer, Integer> lru = new LeastRecentlyUsed<>(2);
		lru.add(1, 1);
		lru.add(5, 101);

		lru.use(1);
		lru.use(1);
		lru.use(1);
		lru.use(5);

		lru.add(8, 1000);

		boolean actualValue1 = lru.containsKey(1);
		boolean actualValue2 = lru.containsKey(5);
		boolean actualValue3 = lru.containsKey(8);

		assertTrue(actualValue1);
		assertTrue(actualValue3);
		assertFalse(actualValue2);
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.collections.lru.LeastRecentlyUsed#use(Object)} by
	 * trying to get element with not existing key.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testUseElementWithNoSuchKey() {
		LeastRecentlyUsed<Integer, Integer> lru = new LeastRecentlyUsed<>(4);
		lru.add(1, 1);
		lru.add(5, 101);
		lru.add(7, 111);
		lru.add(3, 11);

		lru.use(100);
	}
}

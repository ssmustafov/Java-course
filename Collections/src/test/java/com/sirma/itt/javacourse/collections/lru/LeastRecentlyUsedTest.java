package com.sirma.itt.javacourse.collections.lru;

import static org.junit.Assert.assertEquals;

import java.util.Collection;

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
		new LeastRecentlyUsed<Integer>(-3);
	}

	/**
	 * Tests
	 * {@link com.sirma.itt.javacourse.collections.lru.LeastRecentlyUsed#LeastRecentlyUsed(int)}
	 * with zero size.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testLRUWithZeroSize() {
		new LeastRecentlyUsed<Integer>(0);
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.collections.lru.LeastRecentlyUsed} with size 4 and 12
	 * additions.
	 */
	@Test
	public void testNormalCase() {
		LeastRecentlyUsed<Integer> lru = new LeastRecentlyUsed<>(4);
		lru.add(1, 2, 3, 4, 1, 2, 5, 1, 2, 3, 4, 5);

		Collection<Integer> list = lru.getCache();
		boolean actual1 = list.contains(5);
		boolean actual2 = list.contains(2);
		boolean actual3 = list.contains(4);
		boolean actual4 = list.contains(3);
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
		LeastRecentlyUsed<Integer> lru = new LeastRecentlyUsed<>(4);
		lru.add(2, 2, 2, 2);

		Collection<Integer> list = lru.getCache();
		boolean actual1 = list.contains(1);
		boolean actual2 = list.contains(2);
		boolean actual3 = list.contains(3);
		boolean actual4 = list.contains(4);
		boolean expected = true;

		assertEquals(expected, actual2);
		assertEquals(false, actual1);
		assertEquals(false, actual3);
		assertEquals(false, actual4);
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.collections.lru.LeastRecentlyUsed} with size 3 and
	 * adding 20 elements.
	 */
	@Test
	public void testAddingTwentyElements() {
		LeastRecentlyUsed<Character> lru = new LeastRecentlyUsed<>(3);
		lru.add('B', 'A', 'F', 'E', 'A', 'Q', 'A', 'Z', 'E', 'Q', 'A', 'Q', 'E', 'F', 'E', 'A',
				'F', 'B', 'A', 'F');

		Collection<Character> list = lru.getCache();
		boolean actual1 = list.contains('F');
		boolean actual2 = list.contains('A');
		boolean actual3 = list.contains('B');
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
		LeastRecentlyUsed<String> lru = new LeastRecentlyUsed<>(3);
		lru.add("Test");

		Collection<String> list = lru.getCache();
		boolean actualContent = list.contains("Test");
		int actualSize = list.size();
		boolean expectedContent = true;
		int expectedSize = 1;

		assertEquals(expectedContent, actualContent);
		assertEquals(expectedSize, actualSize);
	}

}

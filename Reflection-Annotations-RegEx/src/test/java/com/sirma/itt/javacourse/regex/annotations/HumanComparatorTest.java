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
	 * Tests {@link com.sirma.itt.javacourse.regex.annotations.HumanComparator} by sorting objects
	 * in normal situation.
	 */
	@Test
	public void testNormalCase() {
		Human[] originalArr = { new Human1(), new Human2(), new Human2(), new Human3(),
				new Human3() };
		Human[] arr = { new Human3(), new Human2(), new Human1(), new Human2(), new Human3() };
		Arrays.sort(arr);

		boolean actual = Arrays.equals(originalArr, arr);
		boolean expected = true;

		assertEquals(expected, actual);
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.regex.annotations.HumanComparator} with one repeated
	 * class.
	 */
	@Test
	public void testWithSameElement() {
		Human[] originalArr = { new Human3() };
		Human[] arr = { new Human3() };
		Arrays.sort(arr);

		boolean actual = Arrays.equals(originalArr, arr);
		boolean expected = true;

		assertEquals(expected, actual);
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.regex.annotations.HumanComparator} with already sorted
	 * array.
	 */
	@Test
	public void testAlreadySortedArray() {
		Human[] originalArr = { new Human1(), new Human1(), new Human3(), new Human3(),
				new Human3() };
		Human[] arr = { new Human1(), new Human1(), new Human3(), new Human3(), new Human3() };
		Arrays.sort(arr);

		boolean actual = Arrays.equals(originalArr, arr);
		boolean expected = true;

		assertEquals(expected, actual);
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.regex.annotations.Human1} by getting age annotation via
	 * reflection.
	 */
	@Test
	public void testConcreteClassAnnotation1() {
		Human1 human = new Human1();
		HumanComparator comp = human.getClass().getAnnotation(HumanComparator.class);

		int actual = comp.age();
		int expected = 20;

		assertEquals(expected, actual);
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.regex.annotations.Human2} by getting age annotation via
	 * reflection.
	 */
	@Test
	public void testConcreteClassAnnotation2() {
		Human2 human = new Human2();
		HumanComparator comp = human.getClass().getAnnotation(HumanComparator.class);

		int actual = comp.age();
		int expected = 26;

		assertEquals(expected, actual);
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.regex.annotations.Human3} by getting age annotation via
	 * reflection.
	 */
	@Test
	public void testConcreteClassAnnotation3() {
		Human3 human = new Human3();
		HumanComparator comp = human.getClass().getAnnotation(HumanComparator.class);

		int actual = comp.age();
		int expected = 30;

		assertEquals(expected, actual);
	}

}

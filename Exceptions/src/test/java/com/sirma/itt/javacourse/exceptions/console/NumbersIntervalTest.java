package com.sirma.itt.javacourse.exceptions.console;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Tests {@link com.sirma.itt.javacourse.exceptions.console.NumbersInterval} class.
 * 
 * @author smustafov
 */
public class NumbersIntervalTest {

	/**
	 * Tests
	 * {@link com.sirma.itt.javacourse.exceptions.console.NumbersInterval#readNumbersInterval(int, int)}
	 * with invalid interval.
	 */
	@Test(expected = InvalidIntervalException.class)
	public void testReadNumbersIntervalInvalidInterval() {
		ConsoleReader reader = new ConsoleReader();
		NumbersInterval interval = new NumbersInterval(reader);
		interval.readNumbersInterval(100, 0);
	}

	/**
	 * Tests
	 * {@link com.sirma.itt.javacourse.exceptions.console.NumbersInterval#readNumbersInterval(int, int)}
	 * with invalid number format.
	 */
	@Test(expected = NumberFormatException.class)
	public void testReadNumbersWithInvalidNumber() {
		String[] nums = { "23", "0", "-5", "aaa8ddd", "48", "33", "21" };
		UnitTestReader reader = new UnitTestReader(nums);
		NumbersInterval interval = new NumbersInterval(reader);
		interval.readNumbersInterval(-10, 100);
	}

	/**
	 * Tests
	 * {@link com.sirma.itt.javacourse.exceptions.console.NumbersInterval#readNumbersInterval(int, int)}
	 * with valid interval but with number out of the interval.
	 */
	@Test(expected = NotInIntervalException.class)
	public void testReadNumbersIntervalInvalidNumber() {
		String[] nums = { "23", "0", "-5", "8", "48", "33", "21" };
		UnitTestReader reader = new UnitTestReader(nums);
		NumbersInterval interval = new NumbersInterval(reader);
		interval.readNumbersInterval(-10, 40);
	}

	/**
	 * Tests
	 * {@link com.sirma.itt.javacourse.exceptions.console.NumbersInterval#readNumbersInterval(int, int)}
	 * with valid interval and valid numbers.
	 */
	@Test
	public void testReadNumbersIntervalNormalCase() {
		String[] nums = { "0", "100", "0", "100", "45", "0", "33", "49", "88", "99", "1", "11",
				"100", "end" };
		UnitTestReader reader = new UnitTestReader(nums);
		NumbersInterval interval = new NumbersInterval(reader);
		interval.readNumbersInterval(0, 100);
	}

	/**
	 * Tests
	 * {@link com.sirma.itt.javacourse.exceptions.console.NumbersInterval#readNumbersInterval(int, int)}
	 * with space.
	 */
	@Test(expected = NumberFormatException.class)
	public void testReadNumbersWithSpace() {
		String[] nums = { "15", " ", "end" };
		UnitTestReader reader = new UnitTestReader(nums);
		NumbersInterval interval = new NumbersInterval(reader);
		interval.readNumbersInterval(0, 100);
	}

	/**
	 * Tests
	 * {@link com.sirma.itt.javacourse.exceptions.console.NumbersInterval#readNumbersInterval(int, int)}
	 * with empty string.
	 */
	@Test(expected = NumberFormatException.class)
	public void testReadNumbersWithEmptyNumber() {
		String[] nums = { "", "end" };
		UnitTestReader reader = new UnitTestReader(nums);
		NumbersInterval interval = new NumbersInterval(reader);
		interval.readNumbersInterval(0, 100);
	}

	/**
	 * Tests
	 * {@link com.sirma.itt.javacourse.exceptions.console.NumbersInterval#isNumberInRange(int, int, int)}
	 * with number in the range.
	 */
	@Test
	public void testIsNumberInRangeTrue() {
		String[] nums = { "", "end" };
		UnitTestReader reader = new UnitTestReader(nums);
		NumbersInterval interval = new NumbersInterval(reader);
		boolean actual = interval.isNumberInRange(-10, 10, 5);
		boolean expected = true;

		assertEquals(expected, actual);
	}

	/**
	 * Tests
	 * {@link com.sirma.itt.javacourse.exceptions.console.NumbersInterval#isNumberInRange(int, int, int)}
	 * with number out of the range.
	 */
	@Test
	public void testIsNumberInRangeFalse() {
		String[] nums = { "", "end" };
		UnitTestReader reader = new UnitTestReader(nums);
		NumbersInterval interval = new NumbersInterval(reader);
		boolean actual = interval.isNumberInRange(20, 50, 55);
		boolean expected = false;

		assertEquals(expected, actual);
	}

}

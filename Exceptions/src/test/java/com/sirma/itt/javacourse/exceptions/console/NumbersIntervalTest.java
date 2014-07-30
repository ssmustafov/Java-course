package com.sirma.itt.javacourse.exceptions.console;

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

	// /**
	// * Tests {@link com.sirma.itt.javacourse.exceptions.console.UnitTestReader}.
	// */
	// @Test
	// public void testReaderInput() {
	// String[] nums = { "12", "50", "0", "48", "8", "end" };
	// UnitTestReader reader = new UnitTestReader(nums);
	//
	// if (!Arrays.equals(nums, reader.getUserInput())) {
	// fail("The given array is not equal to that in the reader");
	// }
	// }
	//
	// /**
	// * Tests
	// * {@link com.sirma.itt.javacourse.exceptions.console.NumbersInterval#getLastReadedNumbers()}
	// * with one read number.
	// */
	// @Test
	// public void testGetLastReadedNumbersOneNumber() {
	// String[] nums = { "200", "end" };
	//
	// UnitTestReader reader = new UnitTestReader(nums);
	// NumbersInterval interval = new NumbersInterval(reader);
	// interval.readNumbersInterval(100, 500);
	// String actual = interval.getLastReadedNumbers();
	// String expected = "[200]";
	//
	// assertEquals(expected, actual);
	// }

}

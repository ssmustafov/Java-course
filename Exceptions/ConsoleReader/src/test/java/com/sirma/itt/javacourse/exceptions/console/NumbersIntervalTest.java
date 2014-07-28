package com.sirma.itt.javacourse.exceptions.console;

import static org.junit.Assert.fail;

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
		NumbersInterval interval = new NumbersInterval();
		interval.readNumbersInterval(100, 0);
	}

	/**
	 * Tests
	 * {@link com.sirma.itt.javacourse.exceptions.console.NumbersInterval#getLastReadedNumbers()}.
	 */
	@Test
	public void testGetLastReadedNumbers() {
		fail("Not yet implemented");
	}

}

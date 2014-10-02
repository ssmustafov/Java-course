package com.sirma.itt.javacourse.collections.dice;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Tests {@link com.sirma.itt.javacourse.collections.dice.HashDice} class.
 * 
 * @author smustafov
 */
public class HashDiceTest {

	/**
	 * Tests
	 * {@link com.sirma.itt.javacourse.collections.dice.HashDice#HashDice(com.sirma.itt.javacourse.collections.dice.DiceReader, int, int)}
	 * with normal case of two different combinations.
	 */
	@Test
	public void testHashDiceNormalCase() {
		String[] dices = { "1", "2", "6", "6" };
		UnitTestDiceReader reader = new UnitTestDiceReader(dices);
		HashDice h = new HashDice(2, 6, reader);
		h.generate();
		String actual = h.toString();
		String expected = "{1,2}: [0]" + System.lineSeparator() + "{6,6}: [1]"
				+ System.lineSeparator();

		assertEquals(expected, actual);
	}

	/**
	 * Tests
	 * {@link com.sirma.itt.javacourse.collections.dice.HashDice#HashDice(com.sirma.itt.javacourse.collections.dice.DiceReader, int, int)}
	 * with zero number of throws.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testHashDiceWithZeroThrowns() {
		String[] dices = { "1", "2", "6", "6" };
		UnitTestDiceReader reader = new UnitTestDiceReader(dices);
		new HashDice(0, 6, reader);
	}

	/**
	 * Tests
	 * {@link com.sirma.itt.javacourse.collections.dice.HashDice#HashDice(com.sirma.itt.javacourse.collections.dice.DiceReader, int, int)}
	 * with zero number of dices' size.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testHashDiceWithZeroSides() {
		String[] dices = { "1", "2", "6", "6" };
		UnitTestDiceReader reader = new UnitTestDiceReader(dices);
		new HashDice(10, 0, reader);
	}

	/**
	 * Tests
	 * {@link com.sirma.itt.javacourse.collections.dice.HashDice#HashDice(com.sirma.itt.javacourse.collections.dice.DiceReader, int, int)}
	 * with repeated dices only.
	 */
	@Test
	public void testHashDiceWithRepeatableDicesOnly() {
		String[] dices = { "3", "5", "3", "5", "3", "5" };
		UnitTestDiceReader reader = new UnitTestDiceReader(dices);
		HashDice h = new HashDice(3, 6, reader);
		h.generate();
		String actual = h.toString();
		String expected = "{3,5}: [0, 1, 2]" + System.lineSeparator();

		assertEquals(expected, actual);
	}

	/**
	 * Tests
	 * {@link com.sirma.itt.javacourse.collections.dice.HashDice#HashDice(com.sirma.itt.javacourse.collections.dice.DiceReader, int, int)}
	 * with three repeated dices and three unique.
	 */
	@Test
	public void testHashDiceWithRepeatableDices() {
		String[] dices = { "3", "5", "2", "1", "3", "5", "6", "6", "3", "5", "1", "6" };
		UnitTestDiceReader reader = new UnitTestDiceReader(dices);
		HashDice h = new HashDice(6, 6, reader);
		h.generate();
		String actual = h.toString();

		StringBuilder expected = new StringBuilder();
		expected.append("{3,5}: [0, 2, 4]");
		expected.append(System.lineSeparator());
		expected.append("{2,1}: [1]");
		expected.append(System.lineSeparator());
		expected.append("{6,6}: [3]");
		expected.append(System.lineSeparator());
		expected.append("{1,6}: [5]");
		expected.append(System.lineSeparator());

		assertEquals(expected.toString(), actual);
	}

	/**
	 * Tests
	 * {@link com.sirma.itt.javacourse.collections.dice.HashDice#HashDice(com.sirma.itt.javacourse.collections.dice.DiceReader, int, int)}
	 * with one double dice.
	 */
	@Test
	public void testHashDiceWithOneDiceCombinaton() {
		String[] dices = { "4", "4" };
		UnitTestDiceReader reader = new UnitTestDiceReader(dices);
		HashDice h = new HashDice(1, 6, reader);
		h.generate();
		String actual = h.toString();

		StringBuilder expected = new StringBuilder();
		expected.append("{4,4}: [0]");
		expected.append(System.lineSeparator());

		assertEquals(expected.toString(), actual);
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.collections.dice.HashDice#throwDices()} by giving a
	 * predefined dices.
	 */
	@Test
	public void testThrowDices() {
		String[] dices = { "1", "2" };
		UnitTestDiceReader reader = new UnitTestDiceReader(dices);
		HashDice h = new HashDice(1, 6, reader);

		String actual = h.throwDices();
		String expected = dices[0] + "," + dices[1];

		assertEquals(expected, actual);
	}

}

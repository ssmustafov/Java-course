package com.sirma.itt.javacourse.collections.dice;

import java.util.Random;

/**
 * Generates random dice. Implements <code>DiceReader</code>.
 * 
 * @author smustafov
 */
public class RandomDiceReader implements DiceReader {

	private static final Random RANDOM_GENERATOR = new Random();

	/**
	 * Returns a random number between 0 - M inclusive.
	 * 
	 * @param m
	 *            - max range
	 * @return - the random number
	 */
	private int getRandomNumber(int m) {
		int randomNumber = RANDOM_GENERATOR.nextInt(m + 1);
		return randomNumber;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String throwDice(int sides) {
		return Integer.toString(getRandomNumber(sides));
	}

}

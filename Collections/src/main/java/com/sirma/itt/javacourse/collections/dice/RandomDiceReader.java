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
	 * Returns a random number between 1-6 inclusive.
	 * 
	 * @return - the random number
	 */
	private int getRandomNumber() {
		final int start = 1;
		final int end = 6;

		int randomNumber = RANDOM_GENERATOR.nextInt((end - start) + 1) + start;
		return randomNumber;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getDice() {
		return Integer.toString(getRandomNumber());
	}

}

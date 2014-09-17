package com.sirma.itt.javacourse.collections.dice;

/**
 * Interface for getting dice.
 * 
 * @author smustafov
 */
public interface DiceReader {

	/**
	 * Returns a dice after it has been thrown.
	 * 
	 * @param sides
	 *            - number of sides of the dice
	 * @return - a dice number
	 */
	String getDice(int sides);

}

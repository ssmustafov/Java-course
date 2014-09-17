package com.sirma.itt.javacourse.collections.dice;

/**
 * This class is for unit testing purpose only.
 * 
 * @author smustafov
 */
public class UnitTestDiceReader implements DiceReader {

	private String[] dicesCombinations;
	private int index;

	/**
	 * Creates a new unit test dice reader with given dice combinations.
	 * 
	 * @param dicesCombinations
	 *            - array of dice combinations
	 */
	public UnitTestDiceReader(String[] dicesCombinations) {
		this.dicesCombinations = dicesCombinations;
		index = -1;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getDice(int sides) {
		index++;
		return dicesCombinations[index];
	}

}

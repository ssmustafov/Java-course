package com.sirma.itt.javacourse.collections.dice;

/**
 * Used for unit testing purpose only.
 * 
 * @author smustafov
 */
public class UnitTestDiceReader implements DiceReader {

	private String[] dices;
	private int index;

	/**
	 * Creates a new UnitTestDiceReader with given array of dices as strings.
	 * 
	 * @param dices
	 *            - the dices
	 */
	public UnitTestDiceReader(String[] dices) {
		this.dices = dices;
		index = -1;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getDice() {
		index++;
		return dices[index];
	}

}

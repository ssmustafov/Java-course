package com.sirma.itt.javacourse.exceptions.console;

/**
 * @author smustafov
 */
public class UnitTestReader implements IntervalReader {

	private String[] userInput;
	private int counter;

	/**
	 * Creates new unit test reader.
	 * 
	 * @param userInput
	 *            - the user input
	 */
	public UnitTestReader(String[] userInput) {
		this.userInput = userInput;
		counter = 0;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String readInput() {
		return userInput[counter++];
	}

}

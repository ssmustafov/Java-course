package com.sirma.itt.javacourse.exceptions.console;

/**
 * This class is for unit test purpose only. Holds array of user input and returns them one by one.
 * 
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

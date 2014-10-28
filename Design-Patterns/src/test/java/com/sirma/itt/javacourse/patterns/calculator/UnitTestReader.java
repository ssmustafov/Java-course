package com.sirma.itt.javacourse.patterns.calculator;

/**
 * Reads input from given array of strings. Implements {@code CalculatorReader}. This class is for
 * unit testing purpose only.
 * 
 * @author Sinan
 */
public class UnitTestReader implements CalculatorReader {
	private String[] input;
	private int index;

	/**
	 * Creates a new unit test reader with given arrays of strings. The array must start with a
	 * number and must end with the string "end".
	 * 
	 * @param input
	 *            - array of string in which are the commands for the calculator
	 */
	public UnitTestReader(String[] input) {
		this.input = input;
		index = 0;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String readInput() {
		return input[index++];
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void printResult(String result) {
		//
	}
}

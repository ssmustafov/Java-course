package com.sirma.itt.javacourse.patterns.calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Reads input from the console. Implements {@code CalculatorReader} interface.
 * 
 * @author Sinan
 */
public class ConsoleReader implements CalculatorReader {
	private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String readInput() {
		String input = "";

		try {
			input = reader.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return input;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void printResult(String result) {
		System.out.println("Result: " + result);
		// System.out.format("Result: %.2f%s", manager.getResult(), System.lineSeparator());
	}
}

package com.sirma.itt.javacourse.exceptions.console;

import java.util.Scanner;

/**
 * Reads input from the console.
 * 
 * @author smustafov
 */
public class ConsoleIntervalReader implements IntervalReader {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String readInput() {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		return scanner.nextLine();
	}

}

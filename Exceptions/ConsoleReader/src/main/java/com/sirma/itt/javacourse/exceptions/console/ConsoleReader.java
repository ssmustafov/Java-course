package com.sirma.itt.javacourse.exceptions.console;

import java.util.Scanner;

/**
 * @author smustafov
 */
public class ConsoleReader implements IntervalReader {

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

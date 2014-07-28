package com.sirma.itt.javacourse.exceptions.console;

/**
 * Shows hot the NumbersInterval class can be used.
 * 
 * @author smustafov
 */
public final class Run {

	/**
	 * Protects from instantiation.
	 */
	private Run() {

	}

	/**
	 * @param args
	 *            arguments
	 */
	public static void main(String[] args) {
		ConsoleReader reader = new ConsoleReader();
		NumbersInterval interval = new NumbersInterval(reader);
		interval.readNumbersInterval(0, 5);
		System.out.println(interval.getLastReadedNumbers());

		System.out.println("--------------------------------");
		interval.readNumbersInterval(4, 8);
		System.out.println(interval.getLastReadedNumbers());
	}

}

package com.sirma.itt.javacourse.exceptions.console;

/**
 * Shows how the NumbersInterval class can be used.
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
		try {
			ConsoleReader reader = new ConsoleReader();
			NumbersInterval interval = new NumbersInterval(reader);
			interval.readNumbersInterval(0, 5);
			System.out.println(interval.getLastReadedNumbers());

			System.out.println("--------------------------------");
			interval.readNumbersInterval(4, 8);
			System.out.println(interval.getLastReadedNumbers());
		} catch (NumberFormatException e) {
			System.out.println(e.getMessage());
		} catch (InvalidIntervalException e) {
			System.out.println(e.getMessage());
		}
	}

}

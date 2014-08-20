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
			ConsoleIntervalReader reader = new ConsoleIntervalReader();
			NumbersReader interval = new NumbersReader(reader);
			System.out.println("Enter number between 0-5:");
			interval.readNumbersInterval(0, 5);

			System.out.println("--------------------------------");
			System.out.println("Enter number between 0-100:");
			interval.readNumbersInterval(0, 100);
		} catch (NumberFormatException e) {
			System.out.println(e.getMessage());
		} catch (InvalidIntervalException e) {
			System.out.println(e.getMessage());
		} catch (NotInIntervalException e) {
			System.out.println(e.getMessage());
		}
	}

}

package com.sirma.itt.javacourse.exceptions.console;

/**
 * @author smustafov
 */
public class NumbersInterval {

	private int[] input;

	/**
	 * Reads numbers from the console in given interval.
	 * 
	 * @param startInterval
	 *            - the start interval
	 * @param endInterval
	 *            - the end interval
	 */
	public void readNumbersInterval(int startInterval, int endInterval) {
		if (endInterval < startInterval) {
			throw new InvalidIntervalException("Invalid interval: (" + startInterval + ","
					+ endInterval + ")");
		}

		if (input == null) {
			int arraySize = Math.abs(startInterval - endInterval);
			input = new int[arraySize];
		}

		for (int i = 0; i < input.length; i++) {
			String line = ConsoleHandler.readLineFromConsole();
			line = line.trim();
			input[i] = Integer.parseInt(line);
		}
	}

	public String getLastReadedNumbers() {
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < input.length - 1; i++) {
			result.append(input[i] + ", ");
		}

		return result.toString();
	}
}

package com.sirma.itt.javacourse.exceptions.console;

/**
 * Holds a method for reading numbers from the console in given interval.
 * 
 * @author smustafov
 */
public class NumbersInterval {

	private static final String INPUT_END_STRING = "end";
	private final IntervalReader reader;

	/**
	 * Creates a new interval reader.
	 * 
	 * @param reader
	 *            - the reader
	 */
	public NumbersInterval(IntervalReader reader) {
		this.reader = reader;
	}

	/**
	 * Checks if given string can be parsed to <code>Integer</code>.
	 * 
	 * @param str
	 *            - the string to be checked
	 * @return true if the given string can be parsed to <code>Integer</code> or false if it cannot
	 *         be parsed
	 */
	private boolean isInt(String str) {
		try {
			Integer.parseInt(str);
		} catch (NumberFormatException e) {
			return false;
		}

		return true;
	}

	/**
	 * Checks if given number is in given range inclusively.
	 * 
	 * @param start
	 *            - the start range
	 * @param end
	 *            - end range
	 * @param number
	 *            - the number to be checked if its in range
	 * @return true if the given number is in range or false if its not
	 */
	public boolean isNumberInRange(int start, int end, int number) {
		if (number >= start && number <= end) {
			return true;
		}

		return false;
	}

	/**
	 * Reads numbers from the console in given interval. The reading of numbers ends when the string
	 * "end" is read.
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

		String line;
		while (true) {
			line = reader.readInput();
			line = line.trim();

			if (isInt(line)) {
				int number = Integer.parseInt(line);
				if (!isNumberInRange(startInterval, endInterval, number)) {
					throw new NotInIntervalException("The number is not in the interval: ("
							+ startInterval + "," + endInterval + ")");
				}
			} else if (INPUT_END_STRING.equals(line.toLowerCase())) {
				break;
			} else {
				throw new NumberFormatException("The entered input is not a number: " + line);
			}
		}
	}

}

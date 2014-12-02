package com.sirma.itt.javacourse.patterns.calculator;

/**
 * Executes commands given from stream to work with the Calculator.
 * 
 * @author smustafov
 */
public class ConsoleCalculator {
	private static final String END_READING = "end";
	private static final String ADDITION_OPERATION = "+";
	private static final String SUBTRACTION_OPERATION = "-";
	private static final String MULTIPLICATION_OPERATION = "*";
	private static final String DIVISION_OPERATION = "/";
	private static final String POWERING_OPERATION = "^";
	private CalculatorManager manager = new CalculatorManager();
	private CalculatorReader calcReader;

	/**
	 * Creates a new console calculator with given reader.
	 * 
	 * @param reader
	 *            - the reader from which the user input will be read
	 */
	public ConsoleCalculator(CalculatorReader reader) {
		calcReader = reader;
	}

	/**
	 * Reads user input.
	 * 
	 * @return - the read user input
	 */
	private String readInput() {
		String line = calcReader.readInput();
		line = line.trim();
		line = line.toLowerCase();

		return line;
	}

	/**
	 * Returns the result.
	 * 
	 * @return - the result
	 */
	public String getResult() {
		return manager.toString();
	}

	/**
	 * Launches the calculator. The reading always must start with number and every line must
	 * contain only one command (a number, operation or end of reading).
	 */
	public void run() {
		Operations operation = null;
		double number = 0;

		String firstLine = readInput();
		manager.setResult(Double.parseDouble(firstLine));

		while (true) {
			String line = readInput();

			if (END_READING.equals(line)) {
				break;
			} else if (ADDITION_OPERATION.equals(line)) {
				operation = Operations.Add;
			} else if (SUBTRACTION_OPERATION.equals(line)) {
				operation = Operations.Subtract;
			} else if (DIVISION_OPERATION.equals(line)) {
				operation = Operations.Divide;
			} else if (MULTIPLICATION_OPERATION.equals(line)) {
				operation = Operations.Multiply;
			} else if (POWERING_OPERATION.equals(line)) {
				operation = Operations.Power;
			} else {
				number = Double.parseDouble(line);
				manager.compute(operation, manager.getResult(), number);

				calcReader.printResult(manager.toString());
			}
		}
	}
}

package com.sirma.itt.javacourse.patterns.calculator;

/**
 * Holds method for creating calculator {@code Command}s.
 * 
 * @author Sinan
 */
public final class CommandFactory {

	/**
	 * Protects from instantiation.
	 */
	private CommandFactory() {

	}

	/**
	 * Creates a command object depending on the operation argument.
	 * 
	 * @param operation
	 *            - calculator operation on which a command will be created
	 * @return - command for the calculator
	 */
	public static Command createCommand(Operations operation) {
		Command command = null;

		switch (operation) {
			case Add:
				command = new AdditionCommand();
				break;
			case Multiply:
				command = new MultiplicationCommand();
				break;
			case Divide:
				command = new DivisionCommand();
				break;
			case Subtract:
				command = new SubtractionCommand();
				break;
			case Power:
				command = new PowerCommand();
				break;
			default:
				throw new IllegalArgumentException("No such operation");
		}

		return command;
	}
}

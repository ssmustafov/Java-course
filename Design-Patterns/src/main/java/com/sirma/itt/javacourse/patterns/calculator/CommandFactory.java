package com.sirma.itt.javacourse.patterns.calculator;

/**
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
		if (operation.equals(Operations.Add)) {
			command = new AdditionCommand();
		} else if (operation.equals(Operations.Divide)) {
			command = new DivisionCommand();
		} else if (operation.equals(Operations.Multiply)) {
			command = new MultiplicationCommand();
		} else if (operation.equals(Operations.Subtract)) {
			command = new SubtractionCommand();
		} else if (operation.equals(Operations.Power)) {
			command = new PowerCommand();
		}

		return command;
	}
}

package com.sirma.itt.javacourse.patterns.calculator;

/**
 * Shows how the calculator can be used.
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
	 * Main method.
	 * 
	 * @param args
	 *            - arguments
	 */
	public static void main(String[] args) {
		CalculatorManager m = new CalculatorManager();
		m.compute(Operations.Add, 100);
		m.compute(Operations.Divide, 5);

		System.out.println(m.getResult());
	}

}

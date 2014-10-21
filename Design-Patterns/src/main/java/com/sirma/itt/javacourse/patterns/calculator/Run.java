package com.sirma.itt.javacourse.patterns.calculator;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Shows how the calculator can be used.
 * 
 * @author smustafov
 */
public final class Run {
	private static final Logger LOGGER = LogManager.getLogger(Run.class);

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
		// CalculatorManager m = new CalculatorManager();
		// m.compute(Operations.Add, new BigDecimal("0"), new BigDecimal("100"));
		// m.compute(Operations.Divide, new BigDecimal("100"), new BigDecimal("5"));
		// m.compute(Operations.Power, new BigDecimal("20"), new BigDecimal("2"));
		// m.compute(Operations.Multiply, new BigDecimal("400"), new BigDecimal("2"));
		// System.out.println(m.getResult());
		try {
			ConsoleCalculator c = new ConsoleCalculator();
			c.run();
		} catch (ArithmeticException e) {
			LOGGER.error(e.getMessage(), e);
		} catch (NumberFormatException e) {
			LOGGER.error(
					"Invalid input. Allowed input is: an integer number, +, -, *, /, ^, 'end'", e);
		} catch (IOException e) {
			LOGGER.error(e.getMessage(), e);
		}
	}
}

package com.sirma.itt.javacourse.gui.calculatormvc;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Tests {@link com.sirma.itt.javacourse.gui.calculatormvc.CalculatorController}.
 * 
 * @author smustafov
 */
public class CalculatorControllerTest {

	/**
	 * Tests
	 * {@link com.sirma.itt.javacourse.gui.calculatormvc.CalculatorController#processCommand(java.lang.String)}
	 * with powering operation.
	 */
	@Test
	public void testProcessCommandWithPower() {
		CalculatorModel model = new CalculatorModel();
		CalculatorController c = new CalculatorController(model, null);

		c.processCommand("2");
		c.processCommand("^");
		c.processCommand("0");
		c.processCommand("=");

		String actual = model.toString();
		String expected = "1.0";

		assertEquals(expected, actual);
	}

	/**
	 * Tests
	 * {@link com.sirma.itt.javacourse.gui.calculatormvc.CalculatorController#processCommand(java.lang.String)}
	 * with addition operation.
	 */
	@Test
	public void testProcessCommandWithAddition() {
		CalculatorModel model = new CalculatorModel();
		CalculatorController c = new CalculatorController(model, null);

		c.processCommand("2");
		c.processCommand("+");
		c.processCommand("2");
		c.processCommand("=");

		String actual = model.toString();
		String expected = "4.0";

		assertEquals(expected, actual);
	}

	/**
	 * Tests
	 * {@link com.sirma.itt.javacourse.gui.calculatormvc.CalculatorController#processCommand(java.lang.String)}
	 * with subtraction operation.
	 */
	@Test
	public void testProcessCommandWithSubtract() {
		CalculatorModel model = new CalculatorModel();
		CalculatorController c = new CalculatorController(model, null);

		c.processCommand("2");
		c.processCommand("-");
		c.processCommand("5");
		c.processCommand("=");

		String actual = model.toString();
		String expected = "-3.0";

		assertEquals(expected, actual);
	}

	/**
	 * Tests
	 * {@link com.sirma.itt.javacourse.gui.calculatormvc.CalculatorController#processCommand(java.lang.String)}
	 * with multiplication operation.
	 */
	@Test
	public void testProcessCommandWithMultiply() {
		CalculatorModel model = new CalculatorModel();
		CalculatorController c = new CalculatorController(model, null);

		c.processCommand("2");
		c.processCommand("*");
		c.processCommand("5");
		c.processCommand("=");

		String actual = model.toString();
		String expected = "10.0";

		assertEquals(expected, actual);
	}

	/**
	 * Tests
	 * {@link com.sirma.itt.javacourse.gui.calculatormvc.CalculatorController#processCommand(java.lang.String)}
	 * with division operation.
	 */
	@Test
	public void testProcessCommandWithDivide() {
		CalculatorModel model = new CalculatorModel();
		CalculatorController c = new CalculatorController(model, null);

		c.processCommand("20");
		c.processCommand("/");
		c.processCommand("5");
		c.processCommand("=");

		String actual = model.toString();
		String expected = "4.0";

		assertEquals(expected, actual);
	}

	/**
	 * Tests
	 * {@link com.sirma.itt.javacourse.gui.calculatormvc.CalculatorController#processCommand(java.lang.String)}
	 * with clear.
	 */
	@Test
	public void testProcessCommandClear() {
		CalculatorModel model = new CalculatorModel();
		CalculatorController c = new CalculatorController(model, null);

		c.processCommand("20");
		c.processCommand("/");
		c.processCommand("5");
		c.processCommand("=");
		c.processCommand("clear");

		String actual = model.toString();
		String expected = "0.0";

		assertEquals(expected, actual);
	}

	/**
	 * Tests
	 * {@link com.sirma.itt.javacourse.gui.calculatormvc.CalculatorController#processCommand(java.lang.String)}
	 * with back.
	 */
	@Test
	public void testProcessCommandBack() {
		CalculatorModel model = new CalculatorModel();
		CalculatorController c = new CalculatorController(model, null);

		c.processCommand("205");
		c.processCommand("b");

		String actual = model.toString();
		String expected = "20.0";

		assertEquals(expected, actual);
	}
}

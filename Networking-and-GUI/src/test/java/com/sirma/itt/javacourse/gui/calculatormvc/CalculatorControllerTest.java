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
	 * .
	 */
	@Test
	public void testProcessCommand() {
		CalculatorModel model = new CalculatorModel();
		CalculatorView view = new CalculatorView();
		CalculatorController c = new CalculatorController(model, view);
		view.registerController(c);

		c.processCommand("2");
		c.processCommand("^");
		c.processCommand("10");
		c.processCommand("=");

		String actual = model.toString();
		String expected = "1024";

		assertEquals(expected, actual);
	}

}

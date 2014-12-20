package com.sirma.itt.javacourse.gui.helloserver;

import javax.swing.SwingUtilities;

/**
 * @author Sinan
 */
public final class RunClient {

	/**
	 * Protects from instantiation.
	 */
	private RunClient() {

	}

	/**
	 * Main method.
	 * 
	 * @param args
	 *            - arguments
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				new ClientView();
			}
		});
	}
}

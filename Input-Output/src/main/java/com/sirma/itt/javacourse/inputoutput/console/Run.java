package com.sirma.itt.javacourse.inputoutput.console;

/**
 * Shows how the console classes can be used.
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
	 * @param args
	 *            - arguments
	 */
	public static void main(String[] args) {

		FileWriter w = new FileWriter("text.txt");
		w.write();
	}
}

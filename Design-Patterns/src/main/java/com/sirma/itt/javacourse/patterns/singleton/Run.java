package com.sirma.itt.javacourse.patterns.singleton;

/**
 * Shows how the Singleton class can be used.
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
	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		// Singleton s = new Singleton();
		Singleton s = Singleton.getInstance();
		s.addToLog("Test");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			System.err.println(e.getMessage());
		}
		s.addToLog("Another test");
		System.out.println(Singleton.getLogs());

	}

}

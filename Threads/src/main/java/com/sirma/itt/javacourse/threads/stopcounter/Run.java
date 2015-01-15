package com.sirma.itt.javacourse.threads.stopcounter;

import java.util.Scanner;

/**
 * Shows how the StopCounterThread class can be used.
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
		StopCounterThread stopCounter = new StopCounterThread(20);
		Thread t = new Thread(stopCounter);
		t.start();

		try (Scanner scanner = new Scanner(System.in);) {
			scanner.nextLine();
			t.interrupt();
		}

		System.out.println(stopCounter.getCounter());
	}

}

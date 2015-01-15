package com.sirma.itt.javacourse.threads.synchronizedstack;

import java.util.Scanner;

/**
 * Shows how the SynchronizedList class can be used.
 * 
 * @author Sinan
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
		SynchronizedStack list = new SynchronizedStack(2);
		String line;
		int option = 0;

		try (Scanner scanner = new Scanner(System.in);) {
			do {
				System.out.println();
				System.out.println("[0] - Exit");
				System.out.println("[1] - Add item");
				System.out.println("[2] - Remove item");
				System.out.println("[3] - Print list");
				System.out.println();

				option = scanner.nextInt();
				switch (option) {
					case 0:
						break;

					case 1:
						System.out.print("Add: ");
						line = scanner.next();
						list.add(line);
						break;

					case 2:
						System.out.println("Removing last item");
						list.remove();
						break;

					case 3:
						System.out.println(list.toString());
						break;

					default:
						System.out.println("Invalid option");
						break;
				}
			} while (option != 0);
		}
	}
}

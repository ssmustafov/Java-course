package com.sirma.itt.javacourse.threads.hashtable;

import java.util.Scanner;

/**
 * Shows how the TimeoutHashtable can be used.
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
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		TimeoutHashtable<Integer, String> table = new TimeoutHashtable<>(10);

		Scanner scanner = new Scanner(System.in);
		int key;
		String value;
		while (true) {
			System.out.println("Choose for hashtable with (Integer, String):");
			System.out.println("\tExit			- 0");
			System.out.println("\tAdd			- 1");
			System.out.println("\tChange value		- 2");
			System.out.println("\tUse key			- 3");
			System.out.println("\tRemove			- 4");
			System.out.println("\tShow			- 5");

			int line = Integer.parseInt(scanner.nextLine());
			if (line == 0) {
				break;
			}

			switch (line) {
				case 1:
					key = Integer.parseInt(scanner.nextLine());
					value = scanner.nextLine();
					table.put(key, value);
					break;
				case 2:
					key = Integer.parseInt(scanner.nextLine());
					value = scanner.nextLine();
					table.put(key, value);
					break;
				case 3:
					key = Integer.parseInt(scanner.nextLine());
					table.get(key);
					break;
				case 4:
					key = Integer.parseInt(scanner.nextLine());
					table.remove(key);
					break;
				case 5:
					System.out.println(table);
					break;
				default:
					System.out.println("No such command");
					break;
			}
		}
	}
}

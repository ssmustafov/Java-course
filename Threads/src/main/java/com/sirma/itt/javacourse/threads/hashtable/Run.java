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
		TimeoutHashtable<Integer, Integer> t = new TimeoutHashtable<>(5);

		Scanner s = new Scanner(System.in);
		while (true) {
			System.out.println("Choose:");
			System.out.println("\tExit			- 0");
			System.out.println("\tAdd			- 1");
			System.out.println("\tChange value		- 2");
			System.out.println("\tUse key			- 3");
			System.out.println("\tRemove			- 4");
			System.out.println("\tShow			- 5");

			int c = Integer.parseInt(s.nextLine());
			if (c == 0) {
				break;
			}

			switch (c) {
				case 1:
					int k = Integer.parseInt(s.nextLine());
					int v = Integer.parseInt(s.nextLine());
					t.put(k, v);
					break;
				case 2:
					k = Integer.parseInt(s.nextLine());
					v = Integer.parseInt(s.nextLine());
					t.put(k, v);
					break;
				case 3:
					k = Integer.parseInt(s.nextLine());
					t.get(k);
					break;
				case 4:
					k = Integer.parseInt(s.nextLine());
					t.remove(k);
					break;
				case 5:
					System.out.println(t);
					break;
				default:
					System.out.println("No such command");
					break;
			}
		}
	}
}

package com.sirma.itt.javacourse.intro.hangman;

import java.util.Scanner;

/**
 * Works with console.
 * 
 * @author smustafov
 */
public final class ConsoleHandler {

	/**
	 * Protects from instantiation.
	 */
	private ConsoleHandler() {

	}

	/**
	 * Prints string to console.
	 * 
	 * @param str
	 *            the string to be printed
	 */
	public static void printOnConsole(String str) {
		System.out.print(str);
	}

	/**
	 * Prints char on the console.
	 * 
	 * @param ch
	 *            the char to be printed
	 */
	public static void printOnConsole(char ch) {
		System.out.print(ch);
	}

	/**
	 * Reads line from the console.
	 * 
	 * @return the read line
	 */
	public static String readLineFromConsole() {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		return scanner.nextLine();
	}

}

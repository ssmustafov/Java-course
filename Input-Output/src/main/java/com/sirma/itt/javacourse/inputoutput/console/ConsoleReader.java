package com.sirma.itt.javacourse.inputoutput.console;

import java.util.Scanner;

/**
 * Works with the console. Holds methods for reading <code>Integer</code>, <code>Float</code>,
 * <code>String</code> and <code>Character</code>.
 * 
 * @author smustafov
 */
public final class ConsoleReader {

	private static final Scanner SCANNER = new Scanner(System.in);

	/**
	 * Protects from instantiation.
	 */
	private ConsoleReader() {

	}

	/**
	 * Reads a string from the console.
	 * 
	 * @return - the read string
	 */
	public static String readString() {
		return SCANNER.next();
	}

	/**
	 * Reads from the console one line.
	 * 
	 * @return - the read line as string
	 */
	public static String readLine() {
		return SCANNER.nextLine();
	}

	/**
	 * Reads from the console one character.
	 * 
	 * @return - the read character
	 */
	public static char readChar() {
		String input = SCANNER.next("\\S");
		return input.charAt(0);
	}

	/**
	 * Reads from the console one <code>int</code> number.
	 * 
	 * @return - the read int number
	 */
	public static int readInt() {
		return SCANNER.nextInt();
	}

	/**
	 * Reads from the console one <code>float</code> number.
	 * 
	 * @return - the read float number
	 */
	public static float readFloat() {
		return SCANNER.nextFloat();
	}

}

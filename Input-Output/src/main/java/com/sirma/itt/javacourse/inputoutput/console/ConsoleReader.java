package com.sirma.itt.javacourse.inputoutput.console;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Works with the console. Holds methods for reading <code>Integer</code>, <code>Float</code>,
 * <code>String</code> and <code>Character</code>.
 * 
 * @author smustafov
 */
public final class ConsoleReader {

	private static BufferedReader reader = null;

	/**
	 * Protects from instantiation.
	 */
	private ConsoleReader() {

	}

	static {
		reader = new BufferedReader(new InputStreamReader(System.in));
	}

	/**
	 * Reads a string from the console.
	 * 
	 * @return - the read string
	 */
	public static String readString() {
		String res = "";
		try {
			res = reader.readLine();
		} catch (IOException e) {
			System.err.println(e.getMessage());
		} finally {
			try {
				if (reader != null) {
					reader.close();
				}
			} catch (IOException e) {
				System.err.println(e.getMessage());
			}
		}

		return res;
	}

	/**
	 * Reads from the console one line.
	 * 
	 * @return - the read line as string
	 */
	public static String readLine() {
		String line = "";
		try {
			line = reader.readLine();
		} catch (IOException e) {
			System.err.println(e.getMessage());
		} finally {
			try {
				if (reader != null) {
					reader.close();
				}
			} catch (IOException e) {
				System.err.println(e.getMessage());
			}
		}

		return line;
	}

	/**
	 * Reads from the console one character.
	 * 
	 * @return - the read character
	 */
	public static char readChar() {
		String line = "";
		try {
			line = reader.readLine();
			if (line.length() >= 2) {
				throw new IOException(
						"You have entered a whole string instead of one single character");
			}
		} catch (IOException e) {
			System.err.println(e.getMessage());
		} finally {
			try {
				if (reader != null) {
					reader.close();
				}
			} catch (IOException e) {
				System.err.println(e.getMessage());
			}
		}

		return line.charAt(0);
	}

	/**
	 * Reads from the console one <code>int</code> number.
	 * 
	 * @return - the read int number
	 */
	public static int readInt() {
		String line = "";
		try {
			line = reader.readLine();
		} catch (IOException e) {
			System.err.println(e.getMessage());
		} finally {
			try {
				if (reader != null) {
					reader.close();
				}
			} catch (IOException e) {
				System.err.println(e.getMessage());
			}
		}

		return Integer.parseInt(line);
	}

	/**
	 * Reads from the console one <code>float</code> number.
	 * 
	 * @return - the read float number
	 */
	public static float readFloat() {
		String line = "";
		try {
			line = reader.readLine();
		} catch (IOException e) {
			System.err.println(e.getMessage());
		} finally {
			try {
				if (reader != null) {
					reader.close();
				}
			} catch (IOException e) {
				System.err.println(e.getMessage());
			}
		}

		return Float.parseFloat(line);
	}

}

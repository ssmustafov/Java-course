package com.sirma.itt.javacourse.intro.hangman;

import java.io.IOException;

/**
 * Tests the game.
 * 
 * @author smustafov
 */
public final class PlayHangman {

	/**
	 * Protects from instantiation.
	 */
	private PlayHangman() {

	}

	/**
	 * Main method.
	 * 
	 * @param args
	 *            args
	 * @throws IOException
	 *             throws exception if it cannot load the given file or the encode of the file is
	 *             not UTF-8
	 */
	public static void main(String[] args) throws IOException {
		// String[] arr = { "developer", "java", "javascript" };
		// HangmanReader arrReader = new ArrayReader(arr);

		HangmanReader fileReader = new FileReader("src\\main\\resources\\words.txt");
		Hangman game = new Hangman(fileReader);
		game.run();
	}

}

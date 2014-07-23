package com.sirma.itt.javacourse.libraries.hangman;

import com.sirma.itt.javacourse.intro.hangman.ArrayReader;
import com.sirma.itt.javacourse.intro.hangman.Hangman;
import com.sirma.itt.javacourse.intro.hangman.HangmanReader;

/**
 * Play hangman.
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
		String[] words = { "test", "developer", "assurance" };
		HangmanReader reader = new ArrayReader(words);
		Hangman game = new Hangman(reader);
		game.run();
	}

}

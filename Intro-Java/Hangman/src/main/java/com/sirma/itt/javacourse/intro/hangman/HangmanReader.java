package com.sirma.itt.javacourse.intro.hangman;

import java.util.Random;

/**
 * Interface for reading words.
 * 
 * @author smustafov
 */
public interface HangmanReader {

	Random RANDOM_GENERATOR = new Random();

	/**
	 * Returns a random word.
	 * 
	 * @return random word
	 */
	String getRandomWord();

	/**
	 * Returns the user input.
	 * 
	 * @return the user input
	 */
	String getUserInput();

	/**
	 * Prints message to user.
	 * 
	 * @param message
	 *            the message to print
	 */
	void printMessage(String message);

}
